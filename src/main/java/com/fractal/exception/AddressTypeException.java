package com.fractal.exception;

public class AddressTypeException extends RuntimeException {
    public AddressTypeException() {
    }

    public AddressTypeException(String message) {
        super(message);
    }
}
