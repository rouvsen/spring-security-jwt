package com.rouvsen.springsecurityjwt.service.impl;

import com.rouvsen.springsecurityjwt.model.User;
import com.rouvsen.springsecurityjwt.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        var roles = Stream.of(user.getRole())
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .toList();
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), roles
        );
    }
}
