package com.example.E_commerce_uribe_julieth.servicios;

import com.example.E_commerce_uribe_julieth.modelos.DTOS.EmpleadoDTO;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.PedidoDTO;
import com.example.E_commerce_uribe_julieth.modelos.Empleado;
import com.example.E_commerce_uribe_julieth.modelos.Pedido;
import com.example.E_commerce_uribe_julieth.modelos.Usuario;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IClienteMapa;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IEmpleadoMapa;
import com.example.E_commerce_uribe_julieth.repositorios.IClienteRepositorio;
import com.example.E_commerce_uribe_julieth.repositorios.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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



    //CONTROLADORES

    //Buscar todos los empleados (Lista)
    public List<EmpleadoDTO> buscarTodosLosEmpleados() {
        List<Empleado> listaDeEmpleadosConsultados = this.Repositorio.findAll();
        return this.Mapa.convertir_lista_a_listadtoempleado(listaDeEmpleadosConsultados);
    }


    //Buscar Un empleado por ID
    public EmpleadoDTO buscarEmpleadoPorId(Integer id){
        Optional<Empleado> empleadoQueEstoyBuscando = this.Repositorio.findById(id);
        if (!empleadoQueEstoyBuscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El empleado no fue encontrado" + id + " suministrado"
            );
        }
        Empleado empleadoEncontrado = empleadoQueEstoyBuscando.get();
        return this.Mapa.convertir_empleado_a_empleadoDTO(empleadoEncontrado);
    }


    //Eliminar un empleado
    public void eliminarEmpleado(Integer id){
        Optional<Empleado> empleadoQueEstoyBuscando = this.Repositorio.findById(id);
        if (!empleadoQueEstoyBuscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El empleado no fue encontrado" + id + " suministrado"
            );
        }
        Empleado empleadoEncontrado = empleadoQueEstoyBuscando.get();
        try {
            this.Repositorio.delete(empleadoEncontrado);
        } catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se puedo eliminar el empleado" + error.getMessage()
            );
        }
    }


    // Modificar algunos datos de un empleado
    public EmpleadoDTO actualizarEmpleado(Integer id,Empleado datosActualizados){
        Optional<Empleado> empleadoQueEstoyBuscando = this.Repositorio.findById(id);
        if (!empleadoQueEstoyBuscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El empleado no fue encontrado" + id + " suministrado"
            );
        }
        Empleado empleadoEncontrado = empleadoQueEstoyBuscando.get();
        //Aplique validaciones sobre los datos que mandaron desde el front

        //Actualizo los campos que se permitieron modificar
        // Cargo
        // Sede
        // Salario

        empleadoEncontrado.setCargo(datosActualizados.getCargo());
        empleadoEncontrado.setSede(datosActualizados.getSede());
        empleadoEncontrado.setSalario(datosActualizados.getSalario());

        //  Concluyo la operacion en la base d datos
        Empleado empleadoActualizado = this.Repositorio.save(empleadoEncontrado);
        if (empleadoActualizado == null) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al actualizar el empleado en la base de datos, intentelo nuevamente"
            );
        }
        return this.Mapa.convertir_empleado_a_empleadoDTO(empleadoActualizado);
    }

}



