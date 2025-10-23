package com.example.E_commerce_uribe_julieth.modelos.DTOS;

public class ProductoDTO {
    private Integer id;
    private String nombre;
    private Integer precioUnitario;
    private String marca;
    private boolean aplicaDescuento;

    public ProductoDTO() {
    }

    public ProductoDTO(Integer id, String nombre, Integer precioUnitario, String marca, boolean aplicaDescuento) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.marca = marca;
        this.aplicaDescuento = aplicaDescuento;
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
}

