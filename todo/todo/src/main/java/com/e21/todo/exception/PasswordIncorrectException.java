package com.e21.todo.exception;

public class PasswordIncorrectException extends RuntimeException{
    public PasswordIncorrectException() {
        super("Password you have entered is incorrect");
    }
}
