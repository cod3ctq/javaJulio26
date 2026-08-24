package service;

import models.Ticket;
import dto.CuentaDTO;

public interface OperacionesAvanzadas {

    Ticket depositar(CuentaDTO cuenta, double monto);

}
