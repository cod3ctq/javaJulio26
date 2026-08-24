package com.ms_tarjetas.exception;

public class AccountAlreadyHasCardException extends RuntimeException {
    public AccountAlreadyHasCardException(String message) {
        super(message);
    }
}
