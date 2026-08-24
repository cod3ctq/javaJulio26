package com.ms_tarjetas.exception;

public class InvalidCardNumberDigitsException extends RuntimeException {
    public InvalidCardNumberDigitsException(String message) {
        super(message);
    }
}
