package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Setter
@Getter
public class InscripcionGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    private Date fechaInscripcion;

    // Getters y Setters
}

