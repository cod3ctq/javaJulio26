package com.ms_tarjetas.exception;

public class CardTypeNotFoundException extends RuntimeException {
    public CardTypeNotFoundException(String message) {
        super(message);
    }
}
