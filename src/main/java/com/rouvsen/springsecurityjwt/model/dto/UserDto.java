package com.rouvsen.springsecurityjwt.model.dto;

import com.rouvsen.springsecurityjwt.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String username;
    private Role role;
    private String email;
}
