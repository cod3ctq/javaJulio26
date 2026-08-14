package service;

import dto.CuentaDTO;
import models.Ticket;

public interface OperacionesBasicas {

    Object[] retirar(CuentaDTO cuenta, double monto);

    Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia);


}
