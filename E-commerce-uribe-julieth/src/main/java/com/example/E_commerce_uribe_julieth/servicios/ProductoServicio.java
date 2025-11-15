package com.example.E_commerce_uribe_julieth.servicios;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.ProductoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Producto;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IProductoMapa;
import com.example.E_commerce_uribe_julieth.repositorios.IProductoRepositorio;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    // CONTROLADORES

    //Buscar todos los productos (Lista)
    public List<ProductoDTO> buscarTodosLosProductos(){
        List<Producto> listaDeProductosConsultados=this.Repositorio.findAll();
        return this.Mapa.convertir_lista_a_listadtoproducto(listaDeProductosConsultados);
    }

    //Buscar Un producto por ID
    public  ProductoDTO buscarProductoPorId(Integer id){
        Optional<Producto> ProductoQueEstoyBuscando = this.Repositorio.findById(id);
        if(ProductoQueEstoyBuscando.isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El producto no fue encontrado"+id+" suministrado"
            );
        }
        Producto productoEncontrado= ProductoQueEstoyBuscando.get();
        return this.Mapa.convertir_producto_a_productoDTO(productoEncontrado);
    }


    //Eliminar un producto
    public void eliminarProducto(Integer id){
        Optional<Producto> ProductoQueEstoyBuscando = this.Repositorio.findById(id);
        if(ProductoQueEstoyBuscando.isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El productono  no fue encontrado" + id + " suministrado"
            );
        }
        Producto productoEncontrado= ProductoQueEstoyBuscando.get();
        try {
            this.Repositorio.delete(productoEncontrado);
        }catch(Exception error){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se puedo eliminar el producto" + error.getMessage()
            );
        }

    }


    // Modificar algunos datos de un producto

    public  ProductoDTO actualizarProducto(Integer id, Producto datosAtualizados){
        Optional<Producto> ProductoQueEstoyBuscando = this.Repositorio.findById(id);
        if(!ProductoQueEstoyBuscando.isPresent()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El producto no fue encontrado"+id+" suministrado"
            );
        }
        Producto productoEncontrado= ProductoQueEstoyBuscando.get();
        //Aplique validaciones sobre los datos que mandaron desde el front

        //Actualizo los campos que se permitieron modificar
        //Descripcion
        //precio unitario
        //marca

        productoEncontrado.setMarca(datosAtualizados.getMarca());
        productoEncontrado.setDescripcion(datosAtualizados.getDescripcion());
        productoEncontrado.setPrecioUnitario(datosAtualizados.getPrecioUnitario());

        //  Concluyo la operacion en la base d datos

        Producto productoAtualizado = this.Repositorio.save(productoEncontrado);
        if(productoAtualizado==null){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al actualizar el producto en la base de datos, intentelo de nuevo"
            );
        }
     return this.Mapa.convertir_producto_a_productoDTO(productoAtualizado);
    }

















}
