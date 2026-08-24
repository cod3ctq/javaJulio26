package com.ms_cuentas.exception;

public class AccountWithAlreadyRegisteredCard extends RuntimeException {
    public AccountWithAlreadyRegisteredCard(String message) {
        super(message);
    }
}
