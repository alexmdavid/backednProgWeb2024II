package com.system.proyectoWeb.services;

import com.system.proyectoWeb.models.DAOs.GrupoDAO;
import com.system.proyectoWeb.models.DTOs.GrupoDTO;
import com.system.proyectoWeb.models.DTOs.TorneoDTO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.Grupo;
import com.system.proyectoWeb.models.entities.Torneo;
import com.system.proyectoWeb.models.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoService {

    @Autowired
    private GrupoDAO grupoDAO;

    public void crearGrupo(GrupoDTO saveGrupo) {
        if (saveGrupo.getNombre() == null || saveGrupo.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del grupo es obligatorio.");
        }
        Grupo grupo = new Grupo(saveGrupo.getNombre(), saveGrupo.getDescripcion(), saveGrupo.getModalidad());
        grupoDAO.crearGrupo(grupo);
    }

    public GrupoDTO getGrupoById(Integer idGrupo) {
        Grupo grupo = grupoDAO.obtenerGrupoPorId(idGrupo);
        if (grupo == null) {
            return null;
        }
        return new GrupoDTO(
                grupo.getIdGrupo(),
                grupo.getNombre(),
                grupo.getDescripcion(),
                grupo.getModalidad()
        );
    }
    public List<GrupoDTO> getAllGrupos() {
            List<Grupo> grupos = grupoDAO.listarGruoo();
            return grupos.stream()
                    .map(grupo -> new GrupoDTO(
                            grupo.getIdGrupo(),
                            grupo.getNombre(),
                            grupo.getDescripcion(),
                            grupo.getModalidad()
                    ))
                    .collect(Collectors.toList());
    }
}

