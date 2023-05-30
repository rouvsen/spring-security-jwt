package com.rouvsen.springsecurityjwt.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class GeneralException extends RuntimeException{

    private final String message;
    private final HttpStatus status;

}
