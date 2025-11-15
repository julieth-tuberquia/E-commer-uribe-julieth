package com.example.E_commerce_uribe_julieth.servicios;


import com.example.E_commerce_uribe_julieth.modelos.Pedido;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.PedidoDTO;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IPedidoMapa;
import com.example.E_commerce_uribe_julieth.repositorios.IPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {
    @Autowired
    private IPedidoRepositorio Repositorio;
    @Autowired
    private IPedidoMapa Mapa;
    //Declaro funciones para activar los servicios desponibles del Api

    //1. ACTIVADO EL SERVICIO DE GUARDADO DE DATOS
    public PedidoDTO guardarPedido(Pedido datosPedido) {

        //validacion de id duplicado
        if (this.Repositorio.findById(datosPedido.getId()).isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El nuemro de pedido ya se encuentra registrdo.");

        }

        // VALIDACIÓN DE QUE EL COSTO DE ENVÍO NO ESTÉ VACÍO NI SEA NEGATIVO
        if (datosPedido.getCostoEnvio() == null || datosPedido.getCostoEnvio() <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El costo de envío no puede estar vacío ni estar en cero");
        }


        //Intear guardar la  informacion de pediodp
        Pedido PedidoQueGuardoElRepo = this.Repositorio.save(datosPedido);
        if (PedidoQueGuardoElRepo == null) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al guardar la infor,acion del pedido"
            );

        }

        //Retornar el dto al controlador
        return this.Mapa.convertir_pedido_a_pedidoDTO(PedidoQueGuardoElRepo);

    }


    //CONTROLADORES

    //Buscar todos los pedidos (Lista)
    public List<PedidoDTO> buscarTodosPedidos() {
        List<Pedido> listaDePedidosConsultados = this.Repositorio.findAll();
        return this.Mapa.convertir_lista_a_listadtopedido(listaDePedidosConsultados);
    }


    //Buscar Un pedido por ID
    public PedidoDTO buscarPedidoPorId(Integer id) {
        Optional<Pedido> pedidoQueEstoyBuscando = this.Repositorio.findById(id);
        if (!pedidoQueEstoyBuscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El pedido no fue encontrado" + id + " suministrado"
            );
        }
        Pedido usuarioEncontrado = pedidoQueEstoyBuscando.get();
        return this.Mapa.convertir_pedido_a_pedidoDTO(usuarioEncontrado);
    }


    //Eliminar un pedido
    public void eliminarpedido(Integer id) {
        Optional<Pedido> pedidoQueEstoBuscando = this.Repositorio.findById(id);
        if (!pedidoQueEstoBuscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El pedido no fue encontrado" + id + " suministrado"
            );
        }
        Pedido pedidoEncontrado = pedidoQueEstoBuscando.get();
        try {
            this.Repositorio.delete(pedidoEncontrado);
        } catch (Exception error) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "No se puedo eliminar el pedido" + error.getMessage()
            );
        }
    }


    // Modificar algunos datos de un pedido
    public PedidoDTO actualizarPedido(Integer id, Pedido datosActualizados) {
        Optional<Pedido> pedidoQueEstoyBuscando = this.Repositorio.findById(id);
        if (!pedidoQueEstoyBuscando.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "El pedido no fue encontrado" + id + " suministrado"
            );
        }
        Pedido pedidoEncontrado = pedidoQueEstoyBuscando.get();

        //Aplique validaciones sobre los datos que mandaron desde el front

        //Actualizo los campos que se permitieron modificar
        //Costo de envio
        //cliente
        // Producto

        pedidoEncontrado.setCostoEnvio(datosActualizados.getCostoEnvio());
        pedidoEncontrado.setCliente(datosActualizados.getCliente());
        pedidoEncontrado.setProducto(datosActualizados.getProducto());

        //  Concluyo la operacion en la base d datos
        Pedido pedidoActualizado = this.Repositorio.save(pedidoEncontrado);
        if (pedidoActualizado == null) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error al actualizar el pedido en la base de datos, intentelo nuevamente"
            );
        }
        return this.Mapa.convertir_pedido_a_pedidoDTO(pedidoActualizado);
    }
}






