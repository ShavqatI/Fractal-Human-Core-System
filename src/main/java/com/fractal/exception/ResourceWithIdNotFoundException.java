package com.fractal.exception;

public class ResourceWithIdNotFoundException extends ResourceNotFoundException {
    public ResourceWithIdNotFoundException() {
    }

    public ResourceWithIdNotFoundException(String message) {
        super(message);
    }

    public ResourceWithIdNotFoundException(Object object, Long id) {
        super(object.getClass().getSimpleName() + " with id: " + id + " not found");
    }
}
