package service;

import dto.CuentaDTO;
import models.Ticket;

public interface OpercionesAvanzadas {

    Ticket depositar (CuentaDTO cuenta, double monto);
}
