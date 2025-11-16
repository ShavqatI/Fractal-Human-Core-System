package com.fractal.exception;

public class ResourceWithCodeNotFoundException extends ResourceNotFoundException {
    public ResourceWithCodeNotFoundException() {
    }

    public ResourceWithCodeNotFoundException(String message) {
        super(message);
    }

    public ResourceWithCodeNotFoundException(Object object, String code) {
        super(object.getClass().getSimpleName() + " with code: " + code + " not found");
    }
}
