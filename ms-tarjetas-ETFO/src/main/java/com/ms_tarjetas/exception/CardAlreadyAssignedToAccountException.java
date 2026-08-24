package com.ms_tarjetas.exception;

public class CardAlreadyAssignedToAccountException extends RuntimeException {
    public CardAlreadyAssignedToAccountException(String message) {
        super(message);
    }
}
