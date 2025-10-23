package com.example.E_commerce_uribe_julieth.modelos.DTOS;

import com.example.E_commerce_uribe_julieth.ayudas.CargosEmpleados;
import com.example.E_commerce_uribe_julieth.ayudas.Sedes;

public class EmpleadoDTO {

    private CargosEmpleados cargo;
    private Sedes sede;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(CargosEmpleados cargo, Sedes sede) {
        this.cargo = cargo;
        this.sede = sede;
    }

    public CargosEmpleados getCargo() {
        return cargo;
    }

    public void setCargo(CargosEmpleados cargo) {
        this.cargo = cargo;
    }

    public Sedes getSede() {
        return sede;
    }

    public void setSede(Sedes sede) {
        this.sede = sede;
    }
}

