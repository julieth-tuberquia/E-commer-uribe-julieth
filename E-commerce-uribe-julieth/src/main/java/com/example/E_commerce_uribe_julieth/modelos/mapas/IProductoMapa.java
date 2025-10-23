package com.example.E_commerce_uribe_julieth.modelos.mapas;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.ProductoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductoMapa {


    //1. que transforme 1 modelo en 1 DTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "nombre", target = "nombre")
    @Mapping(source = "precioUnitario", target = "precioUnitario")
    @Mapping(source = "marca", target = "marca")
    @Mapping(source = "aplicaDescuento", target = "aplicaDescuento")
    ProductoDTO convertir_producto_a_productoDTO(Producto producto);

    //2. que transforme una list<modelo> en una list<dto>
    List<ProductoDTO> convertir_lista_a_listadtoproducto(List<Producto> lista);

}
