package com.example.E_commerce_uribe_julieth.servicios;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.UsuarioGenericoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Usuario;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IUsuarioMapa;
import com.example.E_commerce_uribe_julieth.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioServicio {
    @Autowired
    private IUsuarioRepositorio Repositorio;

    @Autowired
    private IUsuarioMapa Mapa;

    //Declaro funciones para activar los servicios desponibles del Api

    //1. ACTIVADO EL SERVICIO DE GUARDADO DE DATOS
    public UsuarioGenericoDTO guardarUsuariogenerico(Usuario datosUsuario){
        //LOGICA DE NEGOCIO

        //validacion de correo duplicado
        if (this.Repositorio.findByCorreo(datosUsuario.getCorreo()).isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un usuario resgistrado con el correo ingresado");

        }

        //VALIDACION DE QUE EL NOMBRE NO ESTE VACIA
        if (datosUsuario.getNombres()==null || datosUsuario.getNombres().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El nombre del usuario no puede estar vacio");

        }

        //Validacion de que la contraseña sea minima
        if (datosUsuario.getContraseña().length()<6) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La contraseña debe tener al menos 6 caracteres");

        }

        //Intear guardar el usuario
        Usuario usuarioQueGuardoElRepo= this.Repositorio.save(datosUsuario);
        if (usuarioQueGuardoElRepo==null) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al guardar el usuario en la base de datos"
            );

        }

        //Retornar el dto al controlador
        return this.Mapa.convertir_usuario_a_usuariogenericodto(usuarioQueGuardoElRepo);

    }
}
