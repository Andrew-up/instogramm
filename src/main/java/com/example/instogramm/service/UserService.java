package com.example.instogramm.service;

import com.example.instogramm.entity.User;
import com.example.instogramm.entity.enums.ERole;
import com.example.instogramm.exceptions.UserAlreadyExistException;
import com.example.instogramm.payload.request.SignupRequest;
import com.example.instogramm.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public  static final Logger LOG = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    public User createUser(SignupRequest userIn){
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setFirstname(userIn.getFirstname());
        user.setLastname(userIn.getLastname());
        user.setUsername(userIn.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userIn.getPassword()));
        user.getRoles().add(ERole.ROLE_USER);

        try {
            LOG.info("Saving user {} ",userIn.getEmail());
            return  userRepository.save(user);
        } catch (Exception e) {
            LOG.error("Error registration {} ",e.getMessage());
            throw  new UserAlreadyExistException("The user "+ user.getEmail()+"already exist!");
        }

    }

}
