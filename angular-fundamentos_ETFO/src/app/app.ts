import { Component, signal, OnInit, ChangeDetectorRef } from '@angular/core';
import { Cliente } from './models/cliente.interface';
import { ClienteRequest } from './models/ClienteRequest.interface';
import { ClienteService } from './services/cliente.service';
import { FormsModule } from '@angular/forms';
import { ClienteMapper } from './cliente.mapper';
import { ClientePatchRequest } from './models/clientepatchrequest.interface';
import { ClienteLista } from './cliente-lista/cliente-lista';
import { ClienteFormulario } from './cliente-formulario/cliente-formulario';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, ClienteLista, ClienteFormulario],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  protected readonly title = signal('angular-fundamentos');

  constructor
  (
    private clienteService: ClienteService,
    private clienteMapper: ClienteMapper,
    private cdr: ChangeDetectorRef
  ) {
  }

  ngOnInit(): void {
    this.cargarClientes();
  }

  clienteParaEditar: ClientePatchRequest | null = null;

  clientes: Cliente[] = [];

  reiniciarFormulario = 0;

  cargarClientes(): void {
    this.clienteService.getClientes().subscribe(
      {
        next: data => {
          console.log('sucess');
          this.clientes = data;
          console.log(this.clientes.length);
          this.cdr.detectChanges();
        },
        error: error => {
          console.error('Error');
          console.log(error);
        }
      }
    );
  }

  get totalClientes(): number {
    return this.clientes.length;
  }

  guardarCliente(cliente: ClienteRequest):void {
    this.clienteService.guardarCliente(cliente).subscribe(
      {
        next: response => {
          alert("Cliente guardado con éxito");
          //this.clienteFormulario.limpiarNuevoCliente();
          this.reiniciarFormulario++;
          this.cargarClientes();
        },
        error: error => {
          console.error('Error al guardar el cliente');
          console.log(error);
        }
      }
    );
  }

  editarCliente(cliente: Cliente): void {
    this.clienteParaEditar = this.clienteMapper.clienteToRequest(cliente);
  }

  /*getclienteFormulario(): ClienteRequest | ClientePatchRequest {
    if (this.modoEdicion) {
      return this.clienteEditado;
    }
      return this.nuevoCliente;
  }*/

  actualizarCliente(cliente: ClientePatchRequest): void {
    this.clienteService.actualizarCliente(cliente).subscribe(
      {
        next: response => {
          alert("Cliente actualizado con éxito");
          //this.clienteFormulario.limpiarClienteEditado();
          this.reiniciarFormulario++;
          this.cargarClientes();
        },
        error: error => {
          console.error('Error al actualizar el cliente');
          console.log(error);
        }   
      }
    );
    }

    eliminarCliente(cliente: Cliente): void {
      const confirmar = confirm('Eliminar al cliente ${cliente.nombre} ?');

      if(!confirmar) {
        return;
      }
      this.clienteService.eliminarCliente(cliente.clienteId).subscribe(
        {
          next: response => {
            alert(response);
            this.cargarClientes();
          },
          error: error => {
            console.error('Error al eliminar el cliente');
            console.log(error);
          }
        }
      );
    }

}