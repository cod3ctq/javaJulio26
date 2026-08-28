package com.ms_tarjetas.exception;

public class DoesNotExistCardException extends RuntimeException {
    public DoesNotExistCardException(String message) {
        super(message);
    }
}
