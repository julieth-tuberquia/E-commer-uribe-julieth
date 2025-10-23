package com.example.E_commerce_uribe_julieth.modelos.DTOS;

import com.example.E_commerce_uribe_julieth.ayudas.Departamentos;

public class ClienteDTO {

    private Integer id;
    private String direccion;
    private String refrenciaPago;
    private String ciudad;

    public ClienteDTO() {
    }

    public ClienteDTO(Integer id, String direccion, String refrenciaPago, String ciudad) {
        this.id = id;
        this.direccion = direccion;
        this.refrenciaPago = refrenciaPago;

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

    public String getRefrenciaPago() {
        return refrenciaPago;
    }

    public void setRefrenciaPago(String refrenciaPago) {
        this.refrenciaPago = refrenciaPago;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
