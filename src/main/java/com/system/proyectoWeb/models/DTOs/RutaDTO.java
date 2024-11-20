package com.system.proyectoWeb.models.DTOs;

import com.system.proyectoWeb.models.entities.RutaLugar;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class RutaDTO {
    private int idRuta;
    private String nombre;
    private String descripcion;
    private List<RutaLugar> rutaLugares;
    public RutaDTO(Integer idRuta, String nombreRuta, String descripcion, List<RutaLugar> rutaLugares) {
        this.idRuta = idRuta;
        this.nombre = nombreRuta;
        this.descripcion = descripcion;
        this.rutaLugares = rutaLugares;
    }
}
