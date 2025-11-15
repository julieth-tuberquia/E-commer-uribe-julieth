package com.example.E_commerce_uribe_julieth.modelos.mapas;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.PedidoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Pedido;
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
public class IPedidoMapaImpl implements IPedidoMapa {

    @Override
    public PedidoDTO convertir_pedido_a_pedidoDTO(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setId( pedido.getId() );
        pedidoDTO.setMontoTotal( pedido.getMontoTotal() );
        pedidoDTO.setCostoEnvio( pedido.getCostoEnvio() );

        return pedidoDTO;
    }

    @Override
    public List<PedidoDTO> convertir_lista_a_listadtopedido(List<Pedido> lista) {
        if ( lista == null ) {
            return null;
        }

        List<PedidoDTO> list = new ArrayList<PedidoDTO>( lista.size() );
        for ( Pedido pedido : lista ) {
            list.add( convertir_pedido_a_pedidoDTO( pedido ) );
        }

        return list;
    }
}
