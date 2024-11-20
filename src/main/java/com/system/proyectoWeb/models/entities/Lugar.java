package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLugar;

    private String nombre;
    private String descripcion;
    private String coordenadas;

    // Relación con RutaLugar
    @OneToMany(mappedBy = "lugar", cascade = CascadeType.ALL)
    private List<RutaLugar> rutaLugares;

}

