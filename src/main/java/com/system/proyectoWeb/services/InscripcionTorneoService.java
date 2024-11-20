package com.system.proyectoWeb.services;



import com.system.proyectoWeb.models.DAOs.InscripcionTorneoDAO;
import com.system.proyectoWeb.models.DTOs.TorneoDTO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.InscripcionTorneo;
import com.system.proyectoWeb.models.entities.Torneo;
import com.system.proyectoWeb.models.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
    public class InscripcionTorneoService {
        @Autowired
        private InscripcionTorneoDAO inscripcionTorneoDAO;
        @Autowired
        private UsuarioService usuarioService;
        @Autowired
        private TorneoService torneoService;
        public boolean inscribirEnTorneo(Integer usuarioId, Integer torneoId, InscripcionTorneo inscripcionTorneo) {
            UsuarioDTO usuario = usuarioService.getUsuarioById(usuarioId);
            TorneoDTO torneo = torneoService.getTorneoById(torneoId);
            if (usuario == null || torneo == null) {
                throw new IllegalArgumentException("Usuario o Torneo no encontrado.");
            }
            Usuario usuario1 = new Usuario(
                    usuario.getIdUsuario()
            );
            Torneo torneo1 = new Torneo(
                    torneo.getIdTorneo()
            );
            LocalDate fechaHoraActual = LocalDate.now();
            InscripcionTorneo inscripcion = new InscripcionTorneo();
            inscripcion.setUsuario(usuario1);
            inscripcion.setTorneo(torneo1);
            inscripcion.setFechaInscripcion(fechaHoraActual);

            inscripcionTorneoDAO.inscribirseTorneo(inscripcion);
            return true;
        }
    }


