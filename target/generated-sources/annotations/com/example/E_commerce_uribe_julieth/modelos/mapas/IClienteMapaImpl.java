package com.example.E_commerce_uribe_julieth.modelos.mapas;

import com.example.E_commerce_uribe_julieth.modelos.Cliente;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.ClienteDTO;
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
public class IClienteMapaImpl implements IClienteMapa {

    @Override
    public ClienteDTO convertir_cliente_a_clienteDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( cliente.getId() );
        clienteDTO.setDireccion( cliente.getDireccion() );
        clienteDTO.setRefrenciaPago( cliente.getRefrenciaPago() );
        clienteDTO.setCiudad( cliente.getCiudad() );

        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> convertir_lista_a_listadtocliete(List<Cliente> lista) {
        if ( lista == null ) {
            return null;
        }

        List<ClienteDTO> list = new ArrayList<ClienteDTO>( lista.size() );
        for ( Cliente cliente : lista ) {
            list.add( convertir_cliente_a_clienteDTO( cliente ) );
        }

        return list;
    }
}
