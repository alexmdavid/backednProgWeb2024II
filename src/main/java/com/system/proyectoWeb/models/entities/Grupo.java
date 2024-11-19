package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
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

    // Getters y Setters
}
