package com.example.E_commerce_uribe_julieth.modelos.mapas;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.ProductoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Producto;
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
public class IProductoMapaImpl implements IProductoMapa {

    @Override
    public ProductoDTO convertir_producto_a_productoDTO(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        ProductoDTO productoDTO = new ProductoDTO();

        productoDTO.setId( producto.getId() );
        productoDTO.setNombre( producto.getNombre() );
        productoDTO.setPrecioUnitario( producto.getPrecioUnitario() );
        productoDTO.setMarca( producto.getMarca() );
        productoDTO.setAplicaDescuento( producto.isAplicaDescuento() );

        return productoDTO;
    }

    @Override
    public List<ProductoDTO> convertir_lista_a_listadtoproducto(List<Producto> lista) {
        if ( lista == null ) {
            return null;
        }

        List<ProductoDTO> list = new ArrayList<ProductoDTO>( lista.size() );
        for ( Producto producto : lista ) {
            list.add( convertir_producto_a_productoDTO( producto ) );
        }

        return list;
    }
}
