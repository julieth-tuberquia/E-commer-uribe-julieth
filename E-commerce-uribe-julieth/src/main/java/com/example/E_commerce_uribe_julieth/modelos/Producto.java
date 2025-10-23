package com.example.E_commerce_uribe_julieth.modelos;

import com.example.E_commerce_uribe_julieth.ayudas.CategoriasProducto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nombre",nullable = false, unique = false, length = 50)
    private String nombre;
    @Column(name="fotografia",nullable = true, unique = false, length = 50)
    private String fotografia;
    @Column(name="descripcion",nullable = true, unique = false, length = 50)
    private String descripcion;
    @Enumerated(EnumType.STRING)
    @Column(name="categoria",nullable = false, unique = false, length = 50)
    private CategoriasProducto categoria;
    @Column(name="precioUniario",nullable = false, unique = false, length = 50)
    private Integer precioUnitario;
    @Column(name="marca",nullable = false, unique = false, length = 50)
    private String marca;
    @Column(name="aplicacionDescuento",nullable = false, unique = false, length = 50)
    private boolean aplicaDescuento;
    @ManyToOne
    @JoinColumn(name = "fk_pedido", referencedColumnName = "id")
    @JsonBackReference(value = "relacionpedidoproducto")
    private Pedido pedido;

    public Producto() {
    }

    public Producto(Integer id, String nombre, String fotografia, String descripcion, CategoriasProducto categoria, Integer precioUnitario, String marca, boolean aplicaDescuento, Pedido pedido) {
        this.id = id;
        this.nombre = nombre;
        this.fotografia = fotografia;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
        this.marca = marca;
        this.aplicaDescuento = aplicaDescuento;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CategoriasProducto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasProducto categoria) {
        this.categoria = categoria;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isAplicaDescuento() {
        return aplicaDescuento;
    }

    public void setAplicaDescuento(boolean aplicaDescuento) {
        this.aplicaDescuento = aplicaDescuento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
