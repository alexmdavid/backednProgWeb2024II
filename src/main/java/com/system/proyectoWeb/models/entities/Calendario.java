package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalendario;

    @ManyToOne
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Ruta ruta;

    private Date fecha;
    private Time hora;

    // Getters y Setters
}

