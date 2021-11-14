package com.example.instogramm.service;

import com.example.instogramm.entity.User;
import com.example.instogramm.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ConfigUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public ConfigUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
        return initUser(user);
    }

    public static User initUser(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(eRole -> new SimpleGrantedAuthority(eRole.name()))
                .collect(Collectors.toList());
        System.out.println("user: "+user);
        return new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                authorities);
    }

    public User loadUserById(Long id){
        return userRepository.findUserById(id).orElse(null);
    }
}
