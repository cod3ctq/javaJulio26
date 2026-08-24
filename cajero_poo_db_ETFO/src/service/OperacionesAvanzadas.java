package service;

import dto.CuentaDTO;
import model.Ticket;

public interface OperacionesAvanzadas {

    Ticket depositar(CuentaDTO cuenta, double monto);

}