package org.example.exception;

public class RentedBookException extends RuntimeException {
    public RentedBookException() {
        super("This book is already rented!");
    }
}
