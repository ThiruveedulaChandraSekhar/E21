package com.e21.todo.exception;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String username) {
        super("User with username: " + username + " already exists");
    }
}
