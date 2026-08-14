package service;

import dto.CuentaDTO;
import models.Ticket;

public interface IOperacionesAvanzadas {

    Ticket depositar(CuentaDTO cuenta, double monto);

}
