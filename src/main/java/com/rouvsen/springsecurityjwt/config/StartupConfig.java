package com.rouvsen.springsecurityjwt.config;

import com.rouvsen.springsecurityjwt.model.Role;
import com.rouvsen.springsecurityjwt.model.User;
import com.rouvsen.springsecurityjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupConfig implements CommandLineRunner {

    private final UserService userService;

    public StartupConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.createUser(User.builder()
                        .username("rouvsen")
                        .password("pass")
                        .role(Role.ADMIN)
                .build());
        userService.createUser(User.builder()
                .username("amigos")
                .password("pass")
                .role(Role.USER)
                .build());
    }
}
