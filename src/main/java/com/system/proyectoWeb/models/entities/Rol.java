package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    private String nombre;
    private String descripcion;

    // Getters y Setters
}