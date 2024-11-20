package com.system.proyectoWeb.services;

import com.system.proyectoWeb.models.DAOs.RutaDAO;
import com.system.proyectoWeb.models.DTOs.RutaDTO;
import com.system.proyectoWeb.models.entities.Ruta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
