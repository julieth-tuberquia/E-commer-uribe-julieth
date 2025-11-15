package com.example.E_commerce_uribe_julieth.controladores;


import com.example.E_commerce_uribe_julieth.modelos.Cliente;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.ClienteDTO;
import com.example.E_commerce_uribe_julieth.servicios.ClienteServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@Tag(name = "controlador para operaciones en la tabla cliente")
public class ClienteControlador {

    //llamar al servicio
    @Autowired
    ClienteServicio servicio;

    //2.LISTAR LOS POSIBLES LLAMADOS A LS SERVICIOS DISPONIBLES
    //3. SE CREANFUNCIONES POR CADA POSIBLE LLAMADO Y SE LES AGREGA
    //EL METODO HTTP CORRESPONDIENTE (GET,PUT,POST,DELETE)

    //GUARDAR
    @Operation(summary = "crear un cliente en la bd")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ClienteDTO> guardar(@RequestBody Cliente datos){
        ClienteDTO respuesta= this.servicio.guardarCliente(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    //LISTAR TODOS
    @Operation(summary = "listar todos los cliente guardados en la bd")
    @GetMapping(produces = "aplication/json", consumes = "application/json")
    public ResponseEntity<List<ClienteDTO>>listar(){
        List <ClienteDTO> respuesta=this.servicio.buscaTodosLosClientes();
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }


    //buscarPorID
    @Operation(summary = "buscar un cliente en la bd")
    @GetMapping(value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<ClienteDTO>buscarPorId(@PathVariable Integer id){
        ClienteDTO respuesta= this.servicio.buscaClientePorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }


    //ELIMINAR
    @Operation(summary = "eliminar un clente en la bd")
    @DeleteMapping (value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void>eliminar(@PathVariable Integer id){
        this.servicio.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }


    //MODIFICAR
    @Operation(summary = "modifica  la clasificacion, la direccion y la referencia de pago  de uncliente en la bd")
    @PutMapping (value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<ClienteDTO>modificar(@PathVariable Integer id, @RequestBody Cliente datos){
        ClienteDTO respuesta= this.servicio.actualizarCliente(id, datos);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

}