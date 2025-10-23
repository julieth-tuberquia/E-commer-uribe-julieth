package com.example.E_commerce_uribe_julieth.servicios;

import com.example.E_commerce_uribe_julieth.modelos.Cliente;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.ClienteDTO;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.ProductoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Producto;
import com.example.E_commerce_uribe_julieth.modelos.Usuario;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IProductoMapa;
import com.example.E_commerce_uribe_julieth.repositorios.IProductoRepositorio;
import com.example.E_commerce_uribe_julieth.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service

public class ProductoServicio {
    @Autowired
    private IProductoRepositorio Repositorio;
    @Autowired
    private IProductoMapa Mapa;

    //Declaro funciones para activar los productos desponibles del Api

    // 1. ACTIVADO EL PRODUCTO PARA GUARDAR DATOS
    public ProductoDTO guardarProducto(Producto datosProducto) {

        // 2. Validación de ID duplicado
        if (this.Repositorio.findById(datosProducto.getId()).isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El producto se encuentra registrado."
            );
        }

        //VALIDACION DE QUE EL NOMBRE NO ESTE VACIA
        if (datosProducto.getNombre()==null || datosProducto.getNombre().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre del usuario no puede estar vacio");

        }

        //VALIDACION DE QUE EL CAMPO MARCA NO ESTE VACIA
        if (datosProducto.getMarca()==null || datosProducto.getMarca().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre la marca no puede puede estar vacio");

        }
        //Intear guardar el producto
        Producto ProductoQueGuardoElRepo= this.Repositorio.save(datosProducto);
        if (ProductoQueGuardoElRepo==null) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al guardar el producto en la base de datos"
            );

        }

        //Retornar el dto al controlador
        return this.Mapa.convertir_producto_a_productoDTO(ProductoQueGuardoElRepo);

    }


}
