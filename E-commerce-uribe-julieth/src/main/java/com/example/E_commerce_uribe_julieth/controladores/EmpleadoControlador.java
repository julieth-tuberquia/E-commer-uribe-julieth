package com.example.E_commerce_uribe_julieth.controladores;


import com.example.E_commerce_uribe_julieth.modelos.DTOS.EmpleadoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Empleado;
import com.example.E_commerce_uribe_julieth.servicios.EmpleadoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
@Tag(name = "controlador para operaciones en la tabla empleados")
public class EmpleadoControlador {

    //llamar al servicio
    @Autowired
    EmpleadoServicio servicio;

    //2.LISTAR LOS POSIBLES LLAMADOS A LS SERVICIOS DISPONIBLES
    //3. SE CREANFUNCIONES POR CADA POSIBLE LLAMADO Y SE LES AGREGA
    //EL METODO HTTP CORRESPONDIENTE (GET,PUT,POST,DELETE)

    //GUARDAR
    @Operation(summary = "crear un empleado en la bd")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmpleadoDTO> guardar(@RequestBody Empleado datos){
        EmpleadoDTO respuesta= this.servicio.guardarEmpleado(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    //LISTAR TODOS
    @Operation(summary = "listar todos los empleados guardados en la bd")
    @GetMapping(produces = "aplication/json", consumes = "application/json")
    public ResponseEntity<List<EmpleadoDTO>>listar(){
        List <EmpleadoDTO> respuesta=this.servicio.buscarTodosLosEmpleados();
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }


    //buscarPorID
    @Operation(summary = "buscar un empleado en la bd")
    @GetMapping(value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmpleadoDTO>buscarPorId(@PathVariable Integer id){
       EmpleadoDTO respuesta= this.servicio.buscarEmpleadoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }


    //ELIMINAR
    @Operation(summary = "eliminar un empleado en la bd")
    @DeleteMapping (value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void>eliminar(@PathVariable Integer id){
        this.servicio.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }


    //MODIFICAR
    @Operation(summary = "modifica cargo, sede y salario  de un empleado en la bd")
    @PutMapping (value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmpleadoDTO>modificar(@PathVariable Integer id, @RequestBody Empleado datos){
        EmpleadoDTO respuesta= this.servicio.actualizarEmpleado(id, datos);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

}