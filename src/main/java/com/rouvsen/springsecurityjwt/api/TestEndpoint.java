package com.rouvsen.springsecurityjwt.api;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @GetMapping("/me")
    public String getMySelf() {
        return "Who are you? " + ((UserDetails)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()).getUsername();
    }

    @GetMapping("/mePrincipal")//username, password, token details and authorities
    public String getMySelfAll() {
        return SecurityContextHolder.getContext().getAuthentication().toString();
    }

    //TODO
    // 1) use PreAuthorized only top of 'Method',
    // 2) use PreAuthorized only top of 'Class' (which is Overridden by SecurityConfig Configs.)
    // 3) Edit SecurityConfig, cause User can send only 'GET' Request, User cannot send POST Req. spec.-endpoint

}
