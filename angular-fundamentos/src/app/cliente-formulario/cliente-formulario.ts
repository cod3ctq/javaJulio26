import { Component, EventEmitter, Input, Output, effect, ChangeDetectorRef, input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ClienteRequest } from '../models/ClienteRequest';
import { ClientePatchRequest } from '../models/ClientePatchRequest';
import { ClienteStateService } from '../services/cliente-state.service';
import { Cliente } from '../models/cliente';

@Component({
  selector: 'app-cliente-formulario',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './cliente-formulario.html'
})
export class ClienteFormulario {
  modoEdicion = input<boolean>(false);
  constructor(
    private clienteStateService: ClienteStateService,
    private cdr: ChangeDetectorRef
  ){
    effect(() => {
      const cliente = this.clienteStateService.clienteSeleccionado();
      console.log('Cliente detectado por effect:', cliente);
      if (cliente) {
        this.clienteEditado = {
          clienteId: cliente.clienteId,
          nombre: cliente.nombre,
          apP: cliente.apP,
          apM: cliente.apM,
          direccion: cliente.direccion,
          tel: cliente.tel,
          correo: cliente.correo
        };
        this.cdr.detectChanges();
      }
    });
  }
  nuevoCliente: ClienteRequest = {
    nombre: '',
    apP: '',
    apM: '',
    direccion: '',
    telefono: '',
    correo: '',
    ine: '',
    rfc: '',
    fechaNac: ''
  };

  clienteEditado: ClientePatchRequest = {
    clienteId: 0,
    nombre: '',
    apP: '',
    apM: '',
    direccion: '',
    tel: '', // Mantenido como 'tel' según tu interfaz
    correo: ''
  };

  // Se eliminó el @Input() de modoEdicion porque ya usas el getter del servicio
  @Input() reiniciarFormulario = 0;
  @Input() clienteParaEditar: ClientePatchRequest | null = null;

  @Output() guardar = new EventEmitter<ClienteRequest>();
  @Output() actualizar = new EventEmitter<ClientePatchRequest>();

  ngOnChanges(): void {

  }

  limpiarNuevoCliente(): void {
    this.nuevoCliente = {
      nombre: '',
      apP: '',
      apM: '',
      direccion: '',
      telefono: '',
      correo: '',
      ine: '',
      rfc: '',
      fechaNac: ''
    };
  }

  limpiarClienteEditado(): void {
    this.clienteEditado = {
      clienteId: 0,
      nombre: '',
      apP: '',
      apM: '',
      direccion: '',
      tel: '', // CORREGIDO: Cambiado 'telefono' por 'tel' para coincidir con el tipo
      correo: ''
    };
  }

  cargarClienteSeleccionado(): void {
    const cliente = this.clienteStateService.getClienteSeleccionado();
    if (cliente) {
      this.clienteEditado = {
        clienteId: cliente.clienteId,
        nombre: cliente.nombre,
        apP: cliente.apP, // Ojo: verifica si en tu modelo es app o apP
        apM: cliente.apM,
        direccion: cliente.direccion,
        tel: cliente.tel,  // CORREGIDO: Cambiado 'telefono' por 'tel'
        correo: cliente.correo
      };
    }
  }

  get clienteSeleccionado(): Cliente | null {
    return this.clienteStateService.clienteSeleccionado();
  }
}
