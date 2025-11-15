package com.example.E_commerce_uribe_julieth.controladores;


import com.example.E_commerce_uribe_julieth.modelos.DTOS.ProductoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Producto;
import com.example.E_commerce_uribe_julieth.servicios.ProductoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "controlador para operaciones en la tabla productos")
public class ProductoControlador {

    //llamar al servicio
    @Autowired
    ProductoServicio servicio;

//2.LISTAR LOS POSIBLES LLAMADOS A LS SERVICIOS DISPONIBLES
//3. SE CREANFUNCIONES POR CADA POSIBLE LLAMADO Y SE LES AGREGA
//EL METODO HTTP CORRESPONDIENTE (GET,PUT,POST,DELETE)

    //GUARDAR
    @Operation(summary = "crear un producto en la bd")
    @PostMapping (produces = "application/json", consumes = "application/json")
    public ResponseEntity<ProductoDTO> guardar(@RequestBody Producto datos){
      ProductoDTO respuesta= this.servicio.guardarProducto(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }


    //LISTAR TODOS
    @Operation(summary = "listar todos los productos guardados en la bd")
    @GetMapping  (produces = "aplication/json", consumes = "application/json")
    public ResponseEntity<List<ProductoDTO>>listar(){
        List <ProductoDTO> respuesta=this.servicio.buscarTodosLosProductos();
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    //buscarPorID
    @Operation(summary = "buscar un producto en la bd")
    @GetMapping(value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<ProductoDTO>buscarPorId(@PathVariable Integer id){
        ProductoDTO respuesta= this.servicio.buscarProductoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

    //ELIMINAR
    @Operation(summary = "eliminar un producto en la bd")
    @DeleteMapping (value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void>eliminar(@PathVariable Integer id){
        this.servicio.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }


    //MODIFICAR
    @Operation(summary = "modifica precio unitario, marca y descripcion de un producto en la bd")
    @PutMapping (value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<ProductoDTO>modificar(@PathVariable Integer id, @RequestBody Producto datos){
        ProductoDTO respuesta= this.servicio.actualizarProducto(id, datos);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }



}

