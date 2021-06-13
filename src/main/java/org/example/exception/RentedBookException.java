package org.example.exception;

public class RentedBookException extends RuntimeException {
    public RentedBookException(String message) {
        super("This book is already rented!");
    }
}
