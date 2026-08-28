import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';
import { ClienteRequest } from '../models/ClienteRequest';
import { ClientePatchRequest } from '../models/ClientePatchRequest';

//@injectable = @service
//en angular @injectable le dice que se instancie un
// unico objeto de autoservicepara toda la aplicacion tal como @service
//ambos tienen scope singleton

@Injectable({
  providedIn:'root'
})

export class ClienteService{

  constructor (private http: HttpClient){

  }
  //llamda al endpoint GET listar todos
  getClientes(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>(
      'http://localhost:8091/api/v1/clientes'
    );
  }

  //llamada al endpoint de guardar POST
  guardarCliente(request:ClienteRequest):Observable<Cliente>{
    return this.http.post<Cliente>(
      'http://localhost:8091/api/v1/clientes', request
    );
  }

  //llamada al endpoint de actualizar PATCH
  actualizarCliente(request: ClientePatchRequest):Observable<Cliente>{
    return this.http.patch<Cliente>(
      'http://localhost:8091/api/v1/clientes', request
    );
  }

  eliminarCliente(clienteId: number): Observable<string>{
    return this.http.delete(
      `http://localhost:8091/api/v1/clientes/${clienteId}`,
      {
        responseType: 'text'
      }
    );
  }
}


