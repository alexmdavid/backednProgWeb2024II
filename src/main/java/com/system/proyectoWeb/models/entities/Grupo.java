package com.system.proyectoWeb.models.entities;

import com.system.proyectoWeb.models.entities.Calendario;
import com.system.proyectoWeb.models.entities.InscripcionGrupo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrupo;

    private String nombre;
    private String descripcion;
    private String modalidad;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<InscripcionGrupo> inscripcionesGrupo;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<Calendario> calendarios;

    public Grupo(String nombre, String descripcion, String modalidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
    }

    public Grupo() {

    }

    public Grupo(Integer idGrupo, String nombre, String descripcion, String modalidad) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modalidad = modalidad;
    }

    public Grupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }
}
