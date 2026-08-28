package com.ms_cuentas.exception;

public class AlreadyExistSameAccountTypeException extends RuntimeException {
    public AlreadyExistSameAccountTypeException(String message) {
        super(message);
    }
}
