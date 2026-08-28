//DTO para mandar datos al actualizar la info
//no contiene el ine, rfc ni fecha de nacimiento
//dado q estos datos no cambian nunca ni deberian

export interface ClientePatchRequest{
  clienteId: number,
  nombre:string,
  apP:string,
  apM:string,
  direccion:string,
  telefono:string,
  correo:string
}
