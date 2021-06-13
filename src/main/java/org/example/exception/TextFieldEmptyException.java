package org.example.exception;

public class TextFieldEmptyException extends RuntimeException {
    public TextFieldEmptyException(String message) {
        super("Text Field is empty!");
    }
}
