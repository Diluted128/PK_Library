package org.example.exception;

public class IncorrectIdException extends RuntimeException {
    public IncorrectIdException() {
        super("The Id is incorrect!");
    }
}
