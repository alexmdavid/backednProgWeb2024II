package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Setter @Getter
public class InscripcionTorneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="idTorneo", nullable = false)
    private Torneo torneo;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;


    @JoinColumn(name = "fechaInscripcion", nullable = false)
    private LocalDate fechaInscripcion;

    public InscripcionTorneo(Torneo torneo, Usuario usuario, LocalDate fechaInscripcion) {
        this.torneo = torneo;
        this.usuario = usuario;
        this.fechaInscripcion = fechaInscripcion;
    }

    public InscripcionTorneo() {

    }
    // Getters y Setters
}

