package com.example.E_commerce_uribe_julieth.controladores;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.UsuarioGenericoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Usuario;
import com.example.E_commerce_uribe_julieth.servicios.UsuarioServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "controlador para operaciones en la tabla usuario")
public class UsuarioControlador {

    //llamar al servicio
    @Autowired
    UsuarioServicio servicio;

    //2.LISTAR LOS POSIBLES LLAMADOS A LS SERVICIOS DISPONIBLES
    //3. SE CREANFUNCIONES POR CADA POSIBLE LLAMADO Y SE LES AGREGA
    //EL METODO HTTP CORRESPONDIENTE (GET,PUT,POST,DELETE)

    //GUARDAR
    @Operation(summary = "crear un usuario en la bd")
    @PostMapping (produces = "application/json", consumes = "application/json")
    public ResponseEntity<UsuarioGenericoDTO> guardar(@RequestBody Usuario datos){
        UsuarioGenericoDTO respuesta= this.servicio.guardarUsuariogenerico(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    //LISTAR TODOS
    @Operation(summary = "listar todos los usuarios guardados en la bd")
    @GetMapping  (produces = "aplication/json", consumes = "application/json")
    public ResponseEntity<List<UsuarioGenericoDTO>>listar(){
        List <UsuarioGenericoDTO> respuesta=this.servicio.buscarTodosLosUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }


    //buscarPorID
    @Operation(summary = "buscar un usuario en la bd")
    @GetMapping(value = "{id}",produces = "application/json", consumes = "application/json")
    public ResponseEntity<UsuarioGenericoDTO>buscarPorId(@PathVariable Integer id){
        UsuarioGenericoDTO respuesta= this.servicio.buscarUsuarioGnericoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }


    //ELIMINAR
    @Operation(summary = "eliminr un usuario en la bd")
    @DeleteMapping (value = "{id",produces = "application/json", consumes = "application/json")
    public ResponseEntity<Void>eliminar(@PathVariable Integer id){
         this.servicio.elimiarUsuario(id);
         return ResponseEntity.noContent().build();
    }


    //MODIFICAR
    @Operation(summary = "modifica nombre y correo de un usuario en la bd")
    @PutMapping (value = "{id",produces = "application/json", consumes = "application/json")
    public ResponseEntity<UsuarioGenericoDTO>modificar(@PathVariable Integer id, @RequestBody Usuario datos){
        UsuarioGenericoDTO respuesta= this.servicio.actulalizarUsuario(id, datos);
        return ResponseEntity.status(HttpStatus.OK).body(respuesta);
    }

}
