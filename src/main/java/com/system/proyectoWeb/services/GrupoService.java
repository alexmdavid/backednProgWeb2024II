package com.system.proyectoWeb.services;

import com.system.proyectoWeb.models.DAOs.GrupoDAO;
import com.system.proyectoWeb.models.DTOs.GrupoDTO;
import com.system.proyectoWeb.models.entities.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {

    @Autowired
    private GrupoDAO grupoDAO;

    public void crearGrupo(GrupoDTO saveGrupo) {
        if (saveGrupo.getNombre() == null || saveGrupo.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del grupo es obligatorio.");
        }
        if (saveGrupo.getDescripcion() == null || saveGrupo.getDescripcion().isBlank()) {
            throw new IllegalArgumentException("La descripción del grupo es obligatoria.");
        }
        if (saveGrupo.getModalidad() == null || saveGrupo.getModalidad().isBlank()) {
            throw new IllegalArgumentException("La modalidad del grupo es obligatoria.");
        }


        Grupo grupo = new Grupo(saveGrupo.getNombre(), saveGrupo.getDescripcion(), saveGrupo.getModalidad());


        grupoDAO.crearGrupo(grupo);
    }
}
