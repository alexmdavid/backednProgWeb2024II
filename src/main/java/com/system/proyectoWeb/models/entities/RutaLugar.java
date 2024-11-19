package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

@Entity
public class RutaLugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name = "idLugar")
    private Lugar lugar;

    // Getters y Setters
}
