package service;

import models.Ticket;
import dto.CuentaDTO;

public interface OperacionesBasicas {

    Object[] retirar(CuentaDTO cuenta, double monto );

    Ticket pagarServicio(CuentaDTO cuentaDTO, String convenio, String referencia);





}
