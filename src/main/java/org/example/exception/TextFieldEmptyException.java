package org.example.exception;

public class TextFieldEmptyException extends RuntimeException {
    public TextFieldEmptyException() {
        super("Text Field is empty!");
    }
}
