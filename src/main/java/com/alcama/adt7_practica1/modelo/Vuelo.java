package com.alcama.adt7_practica1.modelo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Vuelo {

    @Schema(description = "Identificado del vuelo", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "Origen del vuelo", example = "Aiacor")
    @Column
    private String origen;

    @Schema(description = "Destino del vuelo", example = "Andorra")
    @Column
    private String destino;

    @Schema(description = "Precio del vuelo", example = "69")
    @Column
    private double precio;

    @Schema(description = "Numero de escalas del vuelo", example = "2")
    @Column
    private int numEscalas;

    @Schema(description = "Compañia que gestiona el vuelo", example = "Raynair")
    @Column
    private String companya;

    public Vuelo(String origen, String destino, double precio, int numEscalas, String companya) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.numEscalas = numEscalas;
        this.companya = companya;
    }

    public Vuelo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getCompanya() {
        return companya;
    }

    public void setCompanya(String companya) {
        companya = companya;
    }

    public int getNumEscalas() {
        return numEscalas;
    }

    public void setNumEscalas(int numEscalas) {
        this.numEscalas = numEscalas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
