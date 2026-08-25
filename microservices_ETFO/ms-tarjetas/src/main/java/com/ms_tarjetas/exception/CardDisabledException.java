package com.ms_tarjetas.exception;

public class CardDisabledException extends RuntimeException {
    public CardDisabledException(String message) {
        super(message);
    }
}
