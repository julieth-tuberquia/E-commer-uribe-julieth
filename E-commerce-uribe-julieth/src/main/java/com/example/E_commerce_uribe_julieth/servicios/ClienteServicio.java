package com.example.E_commerce_uribe_julieth.servicios;

import com.example.E_commerce_uribe_julieth.modelos.Cliente;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.ClienteDTO;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IClienteMapa;
import com.example.E_commerce_uribe_julieth.repositorios.IClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteServicio {

@Autowired
private IClienteRepositorio Repositorio;
@Autowired
private IClienteMapa Mapa;

    //Declaro funciones para activar los servicios desponibles del Api
    //1. ACTIVADO EL SERVICIO DE GUARDADO DE DATOS
    public ClienteDTO guardarCliente(Cliente datosCliente) {
        //validacion de id duplicado
        if (this.Repositorio.findById(datosCliente.getId()).isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El cliente se encuentra registrdo.");

        }

        //validacion que la direccion no este vacia el campo
        if (datosCliente.getDireccion() == null || datosCliente.getDireccion().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El campo direccion no puede estar vacio.");

        }

        //validcion que la referencia de pago tenga todos lso campos
        if (datosCliente.getRefrenciaPago().length()<10){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La refrencia pago no puede estar incompleta");

        }
        //intentar guardar el usuario
        Cliente clientequeGuardoElRepo= this.Repositorio.save(datosCliente);
        if (clientequeGuardoElRepo==null) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al guardar el cliente en la base de datos"
            );

        }
        //Retorno el dto al controlador
        return this.Mapa.convertir_cliente_a_clienteDTO(clientequeGuardoElRepo);
    }


}
