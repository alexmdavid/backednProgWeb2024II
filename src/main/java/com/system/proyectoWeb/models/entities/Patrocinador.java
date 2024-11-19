package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Patrocinador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatrocinador;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "patrocinador", cascade = CascadeType.ALL)
    private List<Torneo> torneos;

    // Getters y Setters
}

