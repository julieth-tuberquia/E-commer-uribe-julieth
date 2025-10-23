package com.example.E_commerce_uribe_julieth.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

        import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="montoTotal",nullable = false, unique = false, length = 50)
    private Integer montoTotal;
    @Column(name="fechaCreacion",nullable = false, unique = false, length = 50)
    private LocalDate fechaCreacion;
    @Column(name="fechaEntrega",nullable = false, unique = false, length = 50)
    private LocalDate fechaEntrega;
    @Column(name="costoEnvio",nullable = false, unique = false, length = 50)
    private Integer costoEnvio;

    @OneToMany(mappedBy = "pedido")
    @JsonManagedReference(value = "relacionpedidoproducto")
    private List<Producto> producto;
    @ManyToOne
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id")
    @JsonBackReference(value = "relacionclientepedido")
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Integer id, Integer montoTotal, LocalDate fechaCreacion, LocalDate fechaEntrega, Integer costoEnvio, List<Producto> producto, Cliente cliente) {
        this.id = id;
        this.montoTotal = montoTotal;
        this.fechaCreacion = fechaCreacion;
        this.fechaEntrega = fechaEntrega;
        this.costoEnvio = costoEnvio;
        this.producto = producto;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Integer montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(Integer costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
