package com.ms_tarjetas.exception;

public class AccountWithAlreadyRegisteredCard extends RuntimeException {
    public AccountWithAlreadyRegisteredCard(String message) {
        super(message);
    }
}
