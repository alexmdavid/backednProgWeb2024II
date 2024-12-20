package com.system.proyectoWeb.models.DTOs;

import lombok.Getter;
import lombok.Setter;

public class GrupoDTO {

    @Setter @Getter
    private Integer idGrupo;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String descripcion;
    @Getter @Setter
    private String modalidad;

    public GrupoDTO() {
    }

    public GrupoDTO(Integer idGrupo, String nombre, String descripcion, String modalidad) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
    }
}
