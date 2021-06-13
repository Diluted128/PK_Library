package org.example.exception;

public class IncorrectIdException extends RuntimeException {
    public IncorrectIdException(String message) {
        super("The Id is incorrect!");
    }
}
