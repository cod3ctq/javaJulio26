package com.ms_transacciones.constants;

public class Mensajes {
    public static final String WITHDRAWAL_EXCEEDS_MAXIMUM_LIMIT =
            "El monto supera el límite máximo permitido.";

    public static final String INSUFFICIENT_ACCOUNT_BALANCE =
            "La cuenta no dispone de saldo suficiente para realizar la operacion";

    public static final String WITHDRAWAL_BELOW_MINIMUM_BALANCE =
            "El monto dejaría el saldo de la cuenta por debajo del mínimo permitido.";
    public static final String INVALID_AMOUNT="La cantidad debe ser multiplo de 100";
    public static final String ACCOUNT_NOT_FOUND="No existe una cuenta con dicho id";
}
