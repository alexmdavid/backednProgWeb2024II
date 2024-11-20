package com.system.proyectoWeb.services;

import com.system.proyectoWeb.models.DAOs.TorneoDAO;
import com.system.proyectoWeb.models.DTOs.TorneoDTO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.Torneo;
import com.system.proyectoWeb.models.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TorneoService {
    @Autowired
    TorneoDAO torneoDAO;

    public List<TorneoDTO> obtenerTorneos(){
        List<Torneo> torneos = torneoDAO.listarTorneo();
        return torneos.stream().
                map(torneo -> new TorneoDTO(
                    torneo.getIdTorneo(),
                    torneo.getNombre(),
                    torneo.getDescripcion()
        )).collect(Collectors.toList());
    }

    public TorneoDTO getTorneoById(Integer idTorneo) {
        Torneo torneo = torneoDAO.obtenerPorId(idTorneo);
        if (torneo == null) {
            return null;
        }
        torneoDAO.refresh(torneo);
        return new TorneoDTO(
                torneo.getIdTorneo(),
                torneo.getNombre(),
                torneo.getDescripcion()
        );
    }

    public TorneoDTO createTorneo(TorneoDTO saveTorneo) {
        if (saveTorneo.getNombre() == null ) {
            throw new IllegalArgumentException("Nombre  obligatorio");
        }
        Torneo torneo = new Torneo(saveTorneo.getNombre(), saveTorneo.getDescripcion());
        torneo = torneoDAO.guardar(torneo);
        return new TorneoDTO(torneo.getNombre(), torneo.getDescripcion());
    }
}
