package com.example.ms_transacciones.constanst;

public class Mensajes {
    public static final String WITHDRAWAL_EXCEEDS_MAXIMUM_LIMIT =
            "El monto supera el límite máximo permitido.";

    public static final String INSUFFICIENT_ACCOUNT_BALANCE =
            "La cuenta no dispone de saldo suficiente para realizar la operacion";

    public static final String WITHDRAWAL_BELOW_MINIMUM_BALANCE =
            "El monto dejaría el saldo de la cuenta por debajo del mínimo permitido.";

    public static final String WITHDRAWAL_EXCEED_MAXIMUM_BALANCE =
            "El monto dejaría el saldo de la cuenta por arriba del máximo permitido.";

    public static final String INVALID_AMOUNT =
            "La cantidad deber ser múltiplo de 100.";

    public static final String ACCOUNT_NOT_FOUND =
            "No existe una cuenta con dicho ";
}
