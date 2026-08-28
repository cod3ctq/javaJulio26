import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Cliente } from '../models/cliente.interface'
import { ClienteRequest } from '../models/ClienteRequest.interface'
import { ClientePatchRequest } from '../models/clientepatchrequest.interface';

@Injectable({
    providedIn:'root'
})

export class ClienteService {

    constructor(private http: HttpClient) { } 
        
    getClientes(): Observable<Cliente[]> {
        return this.http.get<Cliente[]>('http://localhost:8088/api/v1/clientes');
    }

    guardarCliente(request: ClienteRequest): Observable<Cliente> {
        return this.http.post<Cliente>('http://localhost:8088/api/v1/clientes', request);
    }

    actualizarCliente(request: ClientePatchRequest): Observable<Cliente> {
        return this.http.patch<Cliente>(`http://localhost:8088/api/v1/clientes`, request);
    }

    eliminarCliente(clienteId: number): Observable<String> {
        return this.http.delete(`http://localhost:8088/api/v1/clientes/${clienteId}`,
            {
            responseType: 'text'
            }
        );
        
    }

}