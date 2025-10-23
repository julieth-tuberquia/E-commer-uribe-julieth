package com.example.E_commerce_uribe_julieth.repositorios;

import com.example.E_commerce_uribe_julieth.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IPedidoRepositorio extends JpaRepository<Pedido, Integer> {


    //SECCION DE CONSULTAS O QUERIES PERSONALIZADAS

    List<Pedido> findByMontoTotal(Integer montoTotal);
    List<Pedido> findByFechaCreacion(LocalDate fechaCreacion);
    Optional<Pedido> findByFechaEntrega(LocalDate fechaEntrega);

}
