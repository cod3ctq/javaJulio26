import {  Injectable, signal } from '@angular/core';
import { Cliente } from '../models/cliente.interface';

@Injectable({
  providedIn: 'root'
})
export class ClienteStateService {
  modoEdicion = signal(false);
  clienteSeleccionado = signal<Cliente | null>(null);

  setClienteSeleccionado(cliente: Cliente): void {
    this.clienteSeleccionado.set(cliente);
  }

  getClienteSeleccionado(): Cliente | null {
    return this.clienteSeleccionado();
  }

  activarModoEdicion(): void {
    this.modoEdicion.set(true);
  }

  desactivarModoEdicion(): void {
    this.modoEdicion.set(false);
  }

  /*getModoEdicion(): void {
    this.modoEdicion.set(false);
  }*/
  
}