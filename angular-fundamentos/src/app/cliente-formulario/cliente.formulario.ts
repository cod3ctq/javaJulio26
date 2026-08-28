import { ChangeDetectorRef, Component, effect, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ClienteRequest } from '../../models/ClienteRequest';
import { ClientePatchRequest } from '../../models/ClientePatchRequest';
import { ClienteStateService } from '../../services/cliente-state.service';
import { Cliente } from '../../models/cliente';

@Component({
  selector: 'app-cliente-formulario',
  standalone: true,
  imports: [FormsModule],
  templateUrl: 'cliente-formulario.html',
})
export class ClienteFormulario {

  constructor(private clienteStateService: ClienteStateService,
  private cdr: ChangeDetectorRef){
    effect(() => {
      const cliente = this.clienteStateService.clienteSeleccionado();

      if (cliente){
        this.clienteEditado = {
          clienteId: cliente.clienteId,
          nombre: cliente.nombre,
          apP: cliente.apP,
          apM: cliente.apM,
          direccion: cliente.direccion,
          telefono: cliente.tel,
          correo: cliente.correo
        };
        this.cdr.detectChanges;
      }
    });
  }

  //el operador ! indica que el valor sera proporicionado despues por el padre
  nuevoCliente: ClienteRequest = {
    nombre: '',
    apP: '',
    apM: '',
    direccion: '',
    telefono: '',
    correo: '',
    ine: '',
    rfc: '',
    fechaNac: '',
  };

  clienteEditado: ClientePatchRequest = {
    clienteId: 0,
    nombre: '',
    apP: '',
    apM: '',
    direccion: '',
    telefono: '',
    correo: ''
  };

  @Input()
  modoEdicion = false;

  @Input()
  reiniciarFormulario = 0;

  @Input()
  clienteParaEditar: ClientePatchRequest | null = null;

  @Output()
  guardar = new EventEmitter<ClienteRequest>();

  @Output()
  actualizar = new EventEmitter<ClientePatchRequest>();

  ngOnChanges(): void {
  }

  limpiarNuevoCliente(): void{
    this.nuevoCliente = {
      nombre: '',
      apP: '',
      apM: '',
      direccion: '',
      telefono: '',
      correo: '',
      ine: '',
      rfc: '',
      fechaNac: '',
    };
  }

  limpiarClienteEditado(): void{
    this.clienteEditado = {
      clienteId: 0,
      nombre: '',
      apP: '',
      apM: '',
      direccion: '',
      telefono: '',
      correo: ''
    };
  }

  cargarClienteSeleccionado(): void{
    const cliente = this.clienteStateService.getClienteSeleccionado();
    if (cliente){
      this.clienteEditado = {
        clienteId: cliente.clienteId,
        nombre: cliente.nombre,
        apP: cliente.apP,
        apM: cliente.apM,
        direccion: cliente.direccion,
        telefono: cliente.tel,
        correo: cliente.correo
      };
    }
  }

  get ModoEdicion(): boolean{
    return this.clienteStateService.modoEdicion();
  }

  get clienteSeleccionado(): Cliente | null{
    return this.clienteStateService.clienteSeleccionado();
  }
}
