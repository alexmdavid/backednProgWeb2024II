package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
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

    public Torneo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Torneo() {

    }

    public Torneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }
}

