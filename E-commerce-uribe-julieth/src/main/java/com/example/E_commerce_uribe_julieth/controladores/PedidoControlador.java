package com.example.E_commerce_uribe_julieth.controladores;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.PedidoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Pedido;
import com.example.E_commerce_uribe_julieth.servicios.PedidoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
@Tag(name = "controlador para operaciones en la tabla pedido")
public class PedidoControlador {

    //llamar al servicio
    @Autowired
    PedidoServicio servicio;

    //2.LISTAR LOS POSIBLES LLAMADOS A LS SERVICIOS DISPONIBLES
    //3. SE CREANFUNCIONES POR CADA POSIBLE LLAMADO Y SE LES AGREGA
    //EL METODO HTTP CORRESPONDIENTE (GET,PUT,POST,DELETE)

    //GUARDAR
    @Operation(summary = "crear un pedido en la bd")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PedidoDTO> guardar(@RequestBody Pedido datos){
        PedidoDTO respuesta= this.servicio.guardarPedido(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    //LISTAR TODOS
    @Operation(summary = "listar todos los productos guardados en la bd")
    @GetMapping(produces = "aplication/json", consumes = "application/json")
    public ResponseEntity<List<PedidoDTO>>listar(){
        List <PedidoDTO> respuesta=this.servicio.buscarTodosPedidos();
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }


    //buscarPorID
    @Operation(summary = "buscar un pedido en la bd")
    @GetMapping(value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<PedidoDTO>buscarPorId(@PathVariable Integer id){
        PedidoDTO respuesta= this.servicio.buscarPedidoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }


    //ELIMINAR
    @Operation(summary = "eliminar un pedido en la bd")
    @DeleteMapping (value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void>eliminar(@PathVariable Integer id){
        this.servicio.eliminarpedido(id);
        return ResponseEntity.noContent().build();
    }


    //MODIFICAR
    @Operation(summary = "modifica costo de envio, cliente y producto de un pedido en la bd")
    @PutMapping (value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<PedidoDTO>modificar(@PathVariable Integer id, @RequestBody Pedido datos){
        PedidoDTO respuesta= this.servicio.actualizarPedido(id, datos);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

}