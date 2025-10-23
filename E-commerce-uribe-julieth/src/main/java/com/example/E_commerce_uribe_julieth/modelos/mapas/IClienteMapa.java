package com.example.E_commerce_uribe_julieth.modelos.mapas;

import com.example.E_commerce_uribe_julieth.modelos.Cliente;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClienteMapa {


    //1. que transforme 1 modelo en 1 DTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "direccion", target = "direccion")
    @Mapping(source = "refrenciaPago", target = "refrenciaPago")
    @Mapping(source = "ciudad", target = "ciudad")
    ClienteDTO convertir_cliente_a_clienteDTO(Cliente cliente);

    //2. que transforme una list<modelo> en una list<dto>
    List<ClienteDTO> convertir_lista_a_listadtocliete(List<Cliente> lista);

}
