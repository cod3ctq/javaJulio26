package com.ms_cuentas.exception;

public class AlreadyExisteSameAccountTypeException extends RuntimeException {
    public AlreadyExisteSameAccountTypeException(String message) {
        super(message);
    }
}
