package com.example.contentstest.exceptions;

public class UsernameExistException extends Status400Exception {
    public UsernameExistException() {
        super("username not unique");
    }
}
