package com.system.proyectoWeb.services;

import com.system.proyectoWeb.models.DAOs.InscripcionGrupoDAO;
import com.system.proyectoWeb.models.DTOs.GrupoDTO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class InscripcionGrupoService {
    @Autowired
    private InscripcionGrupoDAO inscripcionGrupoDAO;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private GrupoService grupoService;

    public boolean inscribirEnGrupo(Integer usuarioId, Integer grupoId, InscripcionGrupo inscripcionGrupo) {
        UsuarioDTO usuario = usuarioService.getUsuarioById(usuarioId);
        GrupoDTO grupo = grupoService.getGrupoById(grupoId);
        if (usuario == null || grupo == null) {
            throw new IllegalArgumentException("Usuario o Grupo no encontrado.");
        }

        Usuario usuario1 = new Usuario(usuario.getIdUsuario());
        Grupo grupo1 = new Grupo(grupo.getIdGrupo());
        InscripcionGrupo inscripcion = new InscripcionGrupo();
        LocalDate fechaHoraActual = LocalDate.now();
        inscripcion.setUsuario(usuario1);
        inscripcion.setGrupo(grupo1);
        inscripcion.setFechaInscripcion((fechaHoraActual));

        inscripcionGrupoDAO.inscribirseEnGrupo(inscripcion);
        return true;
    }

}
