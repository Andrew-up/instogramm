package com.example.instogramm.service;

import com.example.instogramm.entity.User;
import com.example.instogramm.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class ConfigUserDetailsService {

    private final UserRepository userRepository;

    public ConfigUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDetails loadUserByUsername(String username) {

        User user = userRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
        return initUser(user);
    }

    public static User initUser(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(eRole -> new SimpleGrantedAuthority(eRole.name()))
                .collect(Collectors.toList());

        return new User(user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities);
    }


    public User loadUserById(Long id){
        return userRepository.findUserById(id).orElse(null);
    }
}
