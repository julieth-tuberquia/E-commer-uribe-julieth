package com.example.E_commerce_uribe_julieth.modelos.mapas;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.EmpleadoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-14T21:34:21-0500",
    comments = "version: 1.6.2, compiler: javac, environment: Java 25 (Eclipse Adoptium)"
)
@Component
public class IEmpleadoMapaImpl implements IEmpleadoMapa {

    @Override
    public EmpleadoDTO convertir_empleado_a_empleadoDTO(Empleado empleado) {
        if ( empleado == null ) {
            return null;
        }

        EmpleadoDTO empleadoDTO = new EmpleadoDTO();

        empleadoDTO.setCargo( empleado.getCargo() );
        empleadoDTO.setSede( empleado.getSede() );

        return empleadoDTO;
    }

    @Override
    public List<EmpleadoDTO> convertir_lista_a_listadtoempleado(List<Empleado> lista) {
        if ( lista == null ) {
            return null;
        }

        List<EmpleadoDTO> list = new ArrayList<EmpleadoDTO>( lista.size() );
        for ( Empleado empleado : lista ) {
            list.add( convertir_empleado_a_empleadoDTO( empleado ) );
        }

        return list;
    }
}
