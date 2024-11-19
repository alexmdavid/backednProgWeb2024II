package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTorneo;

    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idPatrocinador")
    private Patrocinador patrocinador;

    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL)
    private List<InscripcionTorneo> inscripcionesTorneo;

    // Getters y Setters
}

