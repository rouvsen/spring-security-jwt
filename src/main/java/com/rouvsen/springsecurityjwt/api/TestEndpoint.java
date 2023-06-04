package com.rouvsen.springsecurityjwt.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@PreAuthorize("hasAuthority('USER')")
@RequestMapping("/api")
public class TestEndpoint {

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/public")
    public String publicEndPoint() {
        return "public";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/myUsername")
    public String getMySelf() {
        return "You're Admin, username is " + ((UserDetails)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()).getUsername();
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/mePrincipal")//username, password, token details and authorities
    public String getMySelfAll() {
        return "You're User, Details: " + SecurityContextHolder.getContext().getAuthentication().toString();
    }

    @GetMapping("/test")//Top of Class
    public String test() {
        return "Top of Class..";
    }

    @GetMapping("/home")//authority with request-method
    public String home() {
        return "Here is Home, User can only send GET request";
    }
}
