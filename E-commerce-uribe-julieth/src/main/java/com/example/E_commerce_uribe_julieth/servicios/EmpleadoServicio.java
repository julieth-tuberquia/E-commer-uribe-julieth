package com.example.E_commerce_uribe_julieth.servicios;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.EmpleadoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Empleado;
import com.example.E_commerce_uribe_julieth.modelos.Usuario;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IClienteMapa;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IEmpleadoMapa;
import com.example.E_commerce_uribe_julieth.repositorios.IClienteRepositorio;
import com.example.E_commerce_uribe_julieth.repositorios.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmpleadoServicio {

@Autowired
private IEmpleadoRepositorio Repositorio;

@Autowired
private IEmpleadoMapa Mapa;


    //Declaro funciones para activar los servicios desponibles del Api
    //1. ACTIVADO EL SERVICIO DE GUARDADO DE DATOS
    public EmpleadoDTO guardarEmpleado(Empleado datosEmpleado){

        //validacion de id duplicado
        if (this.Repositorio.findById(datosEmpleado.getId()).isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El empleado se encuentra registrdo.");

        }

        //validacion que el cargo no este vacio el campo
        if (datosEmpleado.getCargo() == null ){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo cargo no puede estar vacio.");

        }

        //Intear guardar el empleado
        Empleado EmpleadoQueGuardoElRepo= this.Repositorio.save(datosEmpleado);
        if (EmpleadoQueGuardoElRepo==null) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al guardar el empleado en la base de datos"
            );

        }

        //Retornar el dto al controlador
        return this.Mapa.convertir_empleado_a_empleadoDTO(EmpleadoQueGuardoElRepo
        );
    }

    }