package com.example.E_commerce_uribe_julieth.modelos.DTOS;

import java.time.LocalDate;

public class PedidoDTO {

    private Integer id;
    private Integer montoTotal;
    private Integer costoEnvio;

    public PedidoDTO() {
    }

    public PedidoDTO(Integer id, Integer montoTotal, Integer costoEnvio) {
        this.id = id;
        this.montoTotal = montoTotal;
        this.costoEnvio = costoEnvio;
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

    public Integer getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(Integer costoEnvio) {
        this.costoEnvio = costoEnvio;
    }
}
