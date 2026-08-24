package com.ms_catalogos.service;


import com.ms_catalogos.dto.TipoPrestamoRequest;
import com.ms_catalogos.dto.TipoPrestamoResponse;


import java.util.List;
import java.util.Optional;

public interface TipoPrestamoService {

    List<TipoPrestamoResponse> mostrar ();
    TipoPrestamoResponse guardar(TipoPrestamoRequest request);
    TipoPrestamoResponse buscar(String descripcion);

    //esta funcionalidad debera ser enrutada en el controller con el verbo patch
    //dentro del mismo JSON recibirá el nuevo interes y el plazo, además del
    //tipoprestamoId
    TipoPrestamoResponse actualizarDatos (TipoPrestamoRequest request);


}
