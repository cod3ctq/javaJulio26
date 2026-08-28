import { ChangeDetectorRef, Component, OnInit, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ClienteService } from '../services/cliente.service';
import { Cliente } from '../models/cliente';
import { ClienteRequest } from '../models/ClienteRequest';
import { ClienteMapper } from './mapper/cliente.mapper';
import { ClientePatchRequest } from '../models/ClientePatchRequest';
import { ClienteLista } from './cliente-lista/cliente.lista';
import { ClienteFormulario } from './cliente-formulario/cliente.formulario';

@Component({
  imports: [FormsModule,
    ClienteLista,
  ClienteFormulario],
  selector: 'app-root',
  styleUrl: './app.css',
  templateUrl: './app.html',
  standalone: true,
})

export class App implements OnInit{
  protected readonly title = signal('angular-fundamentos');

  constructor(
    private clienteService: ClienteService,
    private clienteMapper: ClienteMapper,
    private cdr: ChangeDetectorRef
  ){
  }

  ngOnInit():void{
    this.cargarClientes();
}

clienteParaEditar: ClientePatchRequest | null = null;

  //lista qe guarda la respuesta del GET
  clientes: Cliente[] = [];
  reiniciarFormulario = 0;

  //controla el estado de la accion, decide si se guarda o se edita
  //modoEdicion=false;

  cargarClientes(): void {
    this.clienteService.getClientes().subscribe({
      next: (data) => {
        console.log('success');
        this.clientes = data;
        console.log(this.clientes.length);
      },
      error: (error) => {
        console.log('Error');
        console.log(error);
      },
    });
  }

  guardarCliente(cliente: ClienteRequest):void{
    this.clienteService.guardarCliente(cliente).subscribe({
      next:respuesta =>{
        alert('Cliente guardado Ok');
        //this.clienteFormulario.limpiarNuevoCliente();
        this.reiniciarFormulario++;
        this.cargarClientes();//recarga la tabla
      },
      error:error=>{
        console.log(error);
      }
    });
  }

  editarCliente(cliente:Cliente):void{
    this.clienteParaEditar = this.clienteMapper.clienteToRequest(cliente);
    //this.modoEdicion=true;
  }

  actualizarCliente(cliente: ClientePatchRequest): void{
    this.clienteService.actualizarCliente(cliente).subscribe({
      next: respuesta =>{
        alert("Cliente Actualizado correctamente");
        //this.clienteFormulario.limpiarClienteEditado();
        this.reiniciarFormulario++;
        //this.modoEdicion=false;
        this.cargarClientes();
      },
      error: error=>{
        console.log(error);
      }
    });
  }

  eliminarCliente(cliente: Cliente): void{
    const confirmar =
      confirm(`ELiminar al cliente ${cliente.nombre}?`);

    if (!confirmar){//si el usuario cancela, no hace nada
      return;//salida del flujo
    }
    this.clienteService.eliminarCliente(cliente.clienteId).subscribe({
      next: respuesta =>{
        alert(respuesta);
        this.cargarClientes();
      },
      error: error =>{
        console.log(error);
      }
    });
  }

  get totalClientes(): number {
    return this.clientes.length;
  }

  /*getclienteFormulario(): ClienteRequest | ClientePatchRequest{
    if(this.modoEdicion){
      return this.clienteEditado;
    }
    return this.nuevoCliente;
  }*/
}
