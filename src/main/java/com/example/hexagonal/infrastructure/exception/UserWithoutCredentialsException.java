package com.example.hexagonal.infrastructure.exception;

public class UserWithoutCredentialsException extends RuntimeException {
    public UserWithoutCredentialsException() {
        super();
    }
}
