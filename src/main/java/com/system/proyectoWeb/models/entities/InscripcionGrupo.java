package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class InscripcionGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    private Date fechaInscripcion;

    // Getters y Setters
}

