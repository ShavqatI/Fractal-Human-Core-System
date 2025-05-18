package com.fractal.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {}

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
