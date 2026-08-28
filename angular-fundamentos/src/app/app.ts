import { ChangeDetectorRef, Component, OnInit, signal } from '@angular/core';
import { Cliente } from './models/cliente';
import { ClienteRequest } from './models/ClienteRequest';
import { ClienteService } from './services/cliente.service';
import { FormsModule } from '@angular/forms';
import { ClientePatchRequest } from './models/ClientePatchRequest';
import { ClienteMapper } from './mapper/cliente.mapper';
import { ClienteLista } from './cliente-lista/cliente-lista';
import { ClienteFormulario } from './cliente-formulario/cliente-formulario';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule,
    ClienteLista,
    ClienteFormulario],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App implements OnInit{
  protected readonly title = signal('angular-fundamentos');
  constructor(
    private clienteService:ClienteService,
    private clienteMapper: ClienteMapper,
    private cdr: ChangeDetectorRef
  ){
  }

  ngOnInit():void{
    this.cargarClientes();
  }

 clienteParaEditar: ClientePatchRequest | null = null;
 clientes: Cliente[] = [];
 reiniciarFormulario = 0;

  //controla el estado de la accion, decide si se guarda o edita
  modoEdicion = false;

  cargarClientes():void{
    this.clienteService.getClientes()
    .subscribe({
      next: data => {
        console.log('success');
        this.clientes = data;
        console.log(this.clientes.length);

      },
      error: error =>{
        console.log('Error');
        console.log(error);
      }
    });
  }
  get totalClientes(): number{
    return this.clientes.length;
  }

 guardarCliente(cliente: ClienteRequest):void{
   this.clienteService.guardarCliente(cliente)
   .subscribe({
     next: respuesta =>{
       alert("Cliente guardado OK");
       //this.clienteFormulario.limpiarNuevoCliente();
       this.reiniciarFormulario++;
       this.cargarClientes(); //recarga la tabla
     },
     error: error =>{
       console.log(error);
     }
   });
 }

  editarCliente(cliente: Cliente): void{
    this.clienteParaEditar = this.clienteMapper.clienteToRequest(cliente);
    this.modoEdicion = true;
  }
/*
get clienteFormulario(): ClienteRequest | ClientePatchRequest {
  if (this.modoEdicion) {
    return this.clienteEditado;
  }
  return this.nuevoCliente;
}
*/
actualizarCliente(cliente: ClientePatchRequest):void{
  this.clienteService.actualizarCliente(cliente)
  .subscribe({
    next: respuesta =>{
      alert("Cliente Actualizado correctamente");
      //this.clienteFormulario.limpiarClienteEditado();
      this.modoEdicion = false;
      this.reiniciarFormulario++;
      this.cargarClientes();
    },
    error: error =>{
      console.log(error);
    }
  });
}

eliminarCliente(cliente: Cliente): void {
  const confirmar = confirm(`Eliminar al cliente ${cliente.nombre} ?`);

  if(!confirmar){//si el usuario cancela, no se manda
    return ; //ninguna peticion, se sale del flujo
  }
  this.clienteService.eliminarCliente(cliente.clienteId)
  .subscribe({
    next: respuesta => {
      alert(respuesta);
      this.cargarClientes();
    },
    error: error => {
      console.log(error);
    }
  });
}

}
