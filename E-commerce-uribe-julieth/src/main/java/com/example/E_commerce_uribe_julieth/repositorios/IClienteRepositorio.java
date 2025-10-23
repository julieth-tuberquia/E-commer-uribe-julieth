package com.example.E_commerce_uribe_julieth.repositorios;

import com.example.E_commerce_uribe_julieth.modelos.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IClienteRepositorio extends JpaRepository<Cliente, Integer> {

    //SECCION DE CONSULTAS O QUERIES PERSONALIZADAS
    List<Cliente> findByDireccion(String direccion);
    Optional<Cliente> findById(Integer id);

}





