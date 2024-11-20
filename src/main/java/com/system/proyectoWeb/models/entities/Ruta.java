package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter @Getter
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRuta;

    private String nombreRuta;
    private String descripcion;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<RutaLugar> rutaLugares;

}
