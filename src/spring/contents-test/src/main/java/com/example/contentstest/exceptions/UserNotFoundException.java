package com.example.contentstest.exceptions;

public class UserNotFoundException extends Status404Exception {
    public UserNotFoundException() {
        super("target user not found");
    }
}
