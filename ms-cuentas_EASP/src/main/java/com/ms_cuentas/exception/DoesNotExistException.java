package com.ms_cuentas.exception;

public class DoesNotExistException extends RuntimeException {
    public DoesNotExistException(String message) {
        super(message);
    }
}
