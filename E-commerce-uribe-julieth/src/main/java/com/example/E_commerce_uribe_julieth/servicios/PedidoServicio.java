package com.example.E_commerce_uribe_julieth.servicios;


import com.example.E_commerce_uribe_julieth.modelos.Pedido;
import com.example.E_commerce_uribe_julieth.modelos.DTOS.PedidoDTO;
import com.example.E_commerce_uribe_julieth.modelos.mapas.IPedidoMapa;
import com.example.E_commerce_uribe_julieth.repositorios.IPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (datosPedido.getCostoEnvio() == null || datosPedido.getCostoEnvio() <= 0){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El costo de envío no puede estar vacío ni estar en cero");
        }



    //Intear guardar la  informacion de pediodp
    Pedido PedidoQueGuardoElRepo= this.Repositorio.save(datosPedido);
        if (PedidoQueGuardoElRepo==null) {
        throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Error al guardar la infor,acion del pedido"
        );

    }

    //Retornar el dto al controlador
        return this.Mapa.convertir_pedido_a_pedidoDTO(PedidoQueGuardoElRepo);

}
}