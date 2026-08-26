package com.ms_transacciones.constants;

public class Mensajes {
    public static final String WITHDRAWAL_EXCEEDS_MAXIMUM_TRANSACTION_LIMIT = "Monto supera el retiro maximo por transaccion.";

    public static final String INSUFFICIENT_ACCOUNT_BALANCE = "Saldo insuficiente.";

    public static final String MINIMUM_BALANCE_REACHED = "Retiro no permitido, saldo minimo superado.";

    public static final String ACCOUNT_NOT_FOUND = "No existe una cuenta con ese numero de tarjeta";

    public static final String ACCOUNT_TYPE_NOT_FOUND = "La cuenta no tiene un tipo de cuenta asignado";

    public static final String DEPOSIT_EXCEEDS_TRANSACTION_LIMIT = "Monto supera el límite maximo por transaccion";

    public static final String MAXIMUM_BALANCE_REACHED = "Operacion excede el saldo maximo de la cuenta destino";

    public static final String INVALID_AMOUNT = "El monto debe ser multiplo de 100";
}
