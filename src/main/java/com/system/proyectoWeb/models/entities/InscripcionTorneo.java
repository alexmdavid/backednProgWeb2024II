package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Setter @Getter
public class InscripcionTorneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Torneo torneo;


    @ManyToOne(cascade = CascadeType.PERSIST)  // o CascadeType.ALL si prefieres
    private Usuario usuario;



    private Date fechaInscripcion;

    public InscripcionTorneo(Torneo torneo, Usuario usuario, Date fechaInscripcion) {
        this.torneo = torneo;
        this.usuario = usuario;
        this.fechaInscripcion = fechaInscripcion;
    }

    public InscripcionTorneo() {

    }
    // Getters y Setters
}

