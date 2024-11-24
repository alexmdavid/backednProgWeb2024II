package com.system.proyectoWeb.services;

import com.system.proyectoWeb.models.DAOs.RutaDAO;
import com.system.proyectoWeb.models.DTOs.RutaDTO;
import com.system.proyectoWeb.models.DTOs.TorneoDTO;
import com.system.proyectoWeb.models.entities.Ruta;
import com.system.proyectoWeb.models.entities.Torneo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RutaSerivice {
    @Autowired
    RutaDAO rutaDAO;

    public List<RutaDTO> getRutas() {
        List<Ruta> rutas = rutaDAO.listarRutas();
        return rutas.stream().map(
                ruta -> new RutaDTO(
                        ruta.getIdRuta(),
                        ruta.getNombreRuta(),
                        ruta.getDescripcion(),
                        ruta.getRutaLugares()
                )
        ).collect(Collectors.toList());
    }

    public List<RutaDTO> getRutasPorNombre(String nombre) {
        List<Ruta> rutas = rutaDAO.buscarRutasPorNombre(nombre);
        return rutas.stream().map(
                ruta -> new RutaDTO(
                        ruta.getIdRuta(),
                        ruta.getNombreRuta(),
                        ruta.getDescripcion(),
                        ruta.getRutaLugares()
                )
        ).collect(Collectors.toList());
    }

    public RutaDTO guardarRuta(RutaDTO saveRuta) {
        if (saveRuta.getNombreRuta() == null ) {
            throw new IllegalArgumentException("Nombre  obligatorio");
        }
        Ruta ruta = new Ruta(saveRuta.getNombreRuta(), saveRuta.getDescripcion());
        ruta = rutaDAO.guardar(ruta);
        return new RutaDTO(ruta.getNombreRuta(), ruta.getDescripcion());
    }

}
