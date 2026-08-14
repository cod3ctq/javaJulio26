package service;

import dto.CuentaDTO;
import models.Ticket;

public interface OperacionesAvanzadas {

    Ticket depositar(CuentaDTO cuenta, double monto);

}
