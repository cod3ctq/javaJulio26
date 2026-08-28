//DTO que captura la informacion del formulario
//que sera enviada al backend
//contiene los datos que no se pueden autogenerar
//los que si se autogeneran se toman de sistema, no deben estar aqui

export interface ClienteRequest{
  nombre:string,
  apP:string,
  apM:string,
  direccion:string,
  telefono:string,
  correo:string,
  ine:string,
  rfc:string,
  fechaNac:string
}
