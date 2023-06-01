package com.rouvsen.springsecurityjwt.service;

import com.rouvsen.springsecurityjwt.dao.UserRepository;
import com.rouvsen.springsecurityjwt.exception.GeneralException;
import com.rouvsen.springsecurityjwt.model.User;
import com.rouvsen.springsecurityjwt.model.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);
        return UserDto.builder()
                .username(savedUser.getUsername())
                .role(savedUser.getRole())
                .email(savedUser.getEmail())
                .build();
    }

    public UserDto getUser(String username) {
        var userByUsername = findUserByUsername(username);
        return UserDto.builder()
                .username(userByUsername.getUsername())
                .role(userByUsername.getRole())
                .email(userByUsername.getEmail())
                .build();
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> GeneralException.builder()
                        .message("user not found by given id!")
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }
}
