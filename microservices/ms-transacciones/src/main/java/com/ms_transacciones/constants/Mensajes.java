package com.ms_transacciones.constants;

public class Mensajes {

    public static final String WITHDRAWAL_EXCEEDS_MAXIMUM_LIMIT =
            "El monto supera el límite máximo permitido.";

    public static final String INSUFFICIENT_ACCOUNT_BALANCE =
            "La cuenta no dispone de saldo suficiente para realizar la operacion";

    public static final String WITHDRAWAL_BELOW_MINIMUM_BALANCE =
            "El monto dejaría el saldo de la cuenta por debajo del mínimo permitido.";

    public static final String INVALID_AMOUNT = "La cantidad" +
            " debe ser multipliplo de 100";

    public static final String ACCOUNT_NOT_FOUND = "No existe una cuenta con ese ID";

    public static final String INVALID_QUANTITY_AMOUNT = "La cantidad debe " +
            "ser mUltiplo de 20 o 50";

    public static final String AMOUNT_EXCEEDING_ACCOUNT_LIMIT =
            "El monto es mayor al maximo de la cuenta";

    public static final String AMOUNT_EXCEEDING_MAXIMUM_DEPOSIT_LIMIT =
            "El monto es mayor al maximo del deposito permitido";
}
