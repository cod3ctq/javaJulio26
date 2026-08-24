package service;

import dto.CuentaDTO;
import models.Ticket;

public interface IOperacionesBasicas {

    Object[] retirar(CuentaDTO cuenta, double monto);
    Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia);

}
