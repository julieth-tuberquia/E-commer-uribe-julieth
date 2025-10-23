package com.example.E_commerce_uribe_julieth.repositorios;

import com.example.E_commerce_uribe_julieth.modelos.Producto;
import com.example.E_commerce_uribe_julieth.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoRepositorio extends JpaRepository<Producto, Integer> {


    // Consultas personalizadas
    List<Producto> findByNombre(String nombre);
    List<Producto> findByPrecioUnitario(Integer precioUnitario);
    List<Producto> findByMarca(String marca);
    List<Producto> findByAplicaDescuento(boolean aplicaDescuento);
    Optional<Producto> findByFotografia(String fotografia);
}
