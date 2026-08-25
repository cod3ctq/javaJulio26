package com.example.ms_transacciones.excepcion;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
