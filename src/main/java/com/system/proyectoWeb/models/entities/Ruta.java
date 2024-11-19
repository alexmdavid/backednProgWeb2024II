package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRuta;

    private String nombreRuta;
    private String descripcion;

    // Relación con RutaLugar
    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<RutaLugar> rutaLugares;

    // Getters y Setters
}
