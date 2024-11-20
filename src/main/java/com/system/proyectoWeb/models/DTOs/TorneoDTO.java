package com.system.proyectoWeb.models.DTOs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TorneoDTO {
    private Integer idTorneo;

    private String nombre;
    private String descripcion;

    public TorneoDTO(Integer idTorneo, String nombre, String descripcion) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TorneoDTO() {
    }

    public TorneoDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
