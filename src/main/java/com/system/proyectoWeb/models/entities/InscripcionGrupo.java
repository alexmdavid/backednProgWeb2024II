package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class InscripcionGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInscripcion;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idGrupo", nullable = false)
    private Grupo grupo;

    @JoinColumn(name = "fechaInscripcion", nullable = false)
    private LocalDate fechaInscripcion;

}

