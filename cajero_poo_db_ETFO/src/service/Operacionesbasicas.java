package service;

import dto.CuentaDTO;
import model.Ticket;

public interface Operacionesbasicas {

    Object[] retirar(CuentaDTO cuenta, double monto);
    Ticket pagarServicio(CuentaDTO cuenta, String convenio, String referencia);
}
