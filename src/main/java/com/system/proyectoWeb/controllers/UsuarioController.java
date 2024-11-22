package com.system.proyectoWeb.controllers;


import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.InscripcionGrupo;
import com.system.proyectoWeb.models.entities.InscripcionTorneo;
import com.system.proyectoWeb.services.InscripcionGrupoService;
import com.system.proyectoWeb.services.InscripcionTorneoService;
import com.system.proyectoWeb.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private InscripcionTorneoService inscripcionTorneoService;
    @Autowired
    private InscripcionGrupoService inscripcionGrupoService;

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);


    @GetMapping("/{id}")
    public UsuarioDTO obtenerProducto(@PathVariable int id) {
        UsuarioDTO usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        return usuario;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.getAllUsuarios();

        if (usuarios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO saveUsuarioDTO) {
        try {
            UsuarioDTO usuarioDTO = usuarioService.createUsuario(saveUsuarioDTO);
            return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al crear el usuario", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioDTO usuario) {
        try {
            usuarioService.updateUsuario(id, usuario);
            return ResponseEntity.ok("Usuario actualizado exitosamente.");
        } catch (Exception e) {
            log.error("Error al actualizar el usuario con ID: " + id, e);
            return new ResponseEntity<>("Error al actualizar el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente.");
    }

    @PostMapping("/{idUsuario}/torneos/{idTorneo}/inscribir")
    public ResponseEntity<String> inscribirEnTorneo(
            @PathVariable Integer idUsuario,
            @PathVariable Integer idTorneo,
            @RequestBody InscripcionTorneo inscripcionTorneo
    ) {
        inscripcionTorneoService.inscribirEnTorneo(idUsuario, idTorneo, inscripcionTorneo);
        return ResponseEntity.ok("Inscripción exitosa");
    }

    @PostMapping("/{idUsuario}/grupos/{idGrupo}/inscribir")
    public ResponseEntity<String> inscribirEnGrupo(
            @PathVariable Integer idUsuario,
            @PathVariable Integer idGrupo,
            @RequestBody InscripcionGrupo inscripcionGrupo

    ) {
        inscripcionGrupoService.inscribirEnGrupo(idUsuario, idGrupo, inscripcionGrupo);
        return ResponseEntity.ok("Inscripción exitosa");
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO usuario1 = usuarioService.login(usuario.getCorreo(), usuario.getContrasena());
        if (usuario1 != null) {
            // Devuelve el usuario sin información sensible
            usuario1.setContrasena(null);
            return ResponseEntity.ok(usuario1);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}