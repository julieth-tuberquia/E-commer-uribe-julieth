package com.example.E_commerce_uribe_julieth.repositorios;

import com.example.E_commerce_uribe_julieth.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmpleadoRepositorio  extends  JpaRepository<Empleado, Integer> {

    //SECCION DE CONSULTAS O QUERIES PERSONALIZADAS
    List<Empleado> findByCargo(String cargo);
    List<Empleado> findBySede(String sede);
    List<Empleado> findBySalario(Integer salario);
    Optional<Empleado> findByDireccion(String direccion);
}

