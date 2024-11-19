package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class InscripcionTorneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    @ManyToOne
    @JoinColumn(name = "idTorneo")
    private Torneo torneo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private Date fechaInscripcion;

    // Getters y Setters
}

