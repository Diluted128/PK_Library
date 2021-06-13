package org.example.exception;

public class CannotDeleteUserException extends RuntimeException {
    public CannotDeleteUserException() {
        super("Cannot delete this user due to the rented books");
    }
}
