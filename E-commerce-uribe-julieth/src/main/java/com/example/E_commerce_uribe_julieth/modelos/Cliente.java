package com.example.E_commerce_uribe_julieth.modelos;

import com.example.E_commerce_uribe_julieth.ayudas.Departamentos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table (name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="direccion",nullable = false, unique = false, length = 50)
    private String direccion;
    @Column(name="calificacion",nullable = true, unique = false, length = 50)
    private Double calificacion;
    @Column(name="refrenciaPago",nullable = false, unique = true, length = 50)
    private String refrenciaPago;
    @Enumerated(EnumType.STRING)
    @Column(name="departamento",nullable = false, unique = false, length = 50)
    private Departamentos departamentos;
    @Column(name="ciudad",nullable = false, unique = false, length = 50)
    private String ciudad;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference(value = "relacionclientepedido")
    private List<Pedido> pedido;
    @OneToOne(mappedBy = "cliente")
    @JsonBackReference(value = "relacionclienteUsuario")
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(Integer id, String direccion, Double calificacion, String refrenciaPago, Departamentos departamentos, String ciudad) {
        this.id = id;
        this.direccion = direccion;
        this.calificacion = calificacion;
        this.refrenciaPago = refrenciaPago;
        this.departamentos = departamentos;
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public String getRefrenciaPago() {
        return refrenciaPago;
    }

    public void setRefrenciaPago(String refrenciaPago) {
        this.refrenciaPago = refrenciaPago;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}

