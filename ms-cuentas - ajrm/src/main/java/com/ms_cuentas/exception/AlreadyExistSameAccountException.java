package com.ms_cuentas.exception;

public class AlreadyExistSameAccountException extends RuntimeException {
    public AlreadyExistSameAccountException(String message) {
        super(message);
    }
}
