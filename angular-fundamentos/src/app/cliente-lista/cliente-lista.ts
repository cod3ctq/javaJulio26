import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Cliente } from '../models/cliente';
import { ClienteStateService } from '../services/cliente-state.service';

@Component({
  selector: 'app-cliente-lista',
  standalone: true,
  templateUrl: './cliente-lista.html'
})
export class ClienteLista {
  constructor(
    private clienteStateService: ClienteStateService
  ){}
  @Input()
  clientes: Cliente[] = [];
  @Output()
  eliminar = new EventEmitter<Cliente>();

 editarCliente(cliente: Cliente): void {
   this.clienteStateService.setClienteSeleccionado(cliente);
   this.clienteStateService.activarModoEdicion();
 }

  eliminarCliente(cliente: Cliente): void {
    this.eliminar.emit(cliente);
  }
}
