package com.example.E_commerce_uribe_julieth.modelos;

import com.example.E_commerce_uribe_julieth.ayudas.CargosEmpleados;
import com.example.E_commerce_uribe_julieth.ayudas.Sedes;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name="cargo",nullable = false, unique = false)
    private CargosEmpleados cargo;
    @Column(name="salario",nullable = false, unique = false)
    private Integer salario;
    @Enumerated(EnumType.STRING)
    @Column(name="sede",nullable = false, unique = false)
    private Sedes sede;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @JsonManagedReference(value = "relacionempleadousuario")
    private Usuario usuario;

    public Empleado() {
    }

    public Empleado(Integer id, CargosEmpleados cargo, Integer salario, Sedes sede) {
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
        this.sede = sede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CargosEmpleados getCargo() {
        return cargo;
    }

    public void setCargo(CargosEmpleados cargo) {
        this.cargo = cargo;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Sedes getSede() {
        return sede;
    }

    public void setSede(Sedes sede) {
        this.sede = sede;
    }
}
