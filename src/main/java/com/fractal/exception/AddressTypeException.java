package com.fractal.exception;

public class AddressTypeException extends ResourceNotFoundException {
    public AddressTypeException() {
    }

    public AddressTypeException(String message) {
        super(message);
    }
}
