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

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false) // usuario_id será la clave foránea
    private Usuario usuario;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    @JoinColumn(name = "fechaInscripcion", nullable = false)
    private LocalDate fechaInscripcion;

}

