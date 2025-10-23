package com.example.E_commerce_uribe_julieth.modelos.mapas;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.EmpleadoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEmpleadoMapa {

    //1. que transforme 1 modelo en 1 DTO
    @Mapping(source = "cargo", target = "cargo")
    @Mapping(source = "sede", target = "sede")
    EmpleadoDTO convertir_empleado_a_empleadoDTO(Empleado empleado);

    //2. que transforme una list<modelo> en una list<dto>
    List<EmpleadoDTO> convertir_lista_a_listadtoempleado(List<Empleado> lista);

}

