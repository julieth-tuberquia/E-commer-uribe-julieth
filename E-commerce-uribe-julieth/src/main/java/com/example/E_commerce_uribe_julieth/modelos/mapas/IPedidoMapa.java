package com.example.E_commerce_uribe_julieth.modelos.mapas;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.PedidoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPedidoMapa {

    //1. que transforme 1 modelo en 1 DTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "montoTotal", target = "montoTotal")
    @Mapping(source = "costoEnvio", target = "costoEnvio")
    PedidoDTO convertir_pedido_a_pedidoDTO(Pedido pedido);

    //2. que transforme una list<modelo> en una list<dto>
    List<PedidoDTO> convertir_lista_a_listadtopedido(List<Pedido> lista);


}

