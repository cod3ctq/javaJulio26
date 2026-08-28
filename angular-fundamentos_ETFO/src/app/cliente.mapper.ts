import { Injectable } from '@angular/core';
import { Cliente } from './models/cliente.interface';
import { ClientePatchRequest } from './models/clientepatchrequest.interface';

@Injectable({
  providedIn: 'root'
})

export class ClienteMapper {

    clienteToRequest(cliente: Cliente): ClientePatchRequest {
        return {
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