package com.system.proyectoWeb.controllers;

import com.system.proyectoWeb.models.DTOs.RutaDTO;
import com.system.proyectoWeb.models.DTOs.TorneoDTO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.services.RutaSerivice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/rutas")

public class RutaController {
    @Autowired
    RutaSerivice rutaSerivice;
    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @GetMapping
    public ResponseEntity<List<RutaDTO>> listarUsuarios() {
        List<RutaDTO> rutas = rutaSerivice.getRutas();

        if (rutas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rutas, HttpStatus.OK);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<RutaDTO>> buscarRuta(@RequestParam String nombre) {
        List<RutaDTO> rutas = rutaSerivice.getRutasPorNombre(nombre);
        if(rutas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rutas, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RutaDTO> guardarRuta(@RequestBody RutaDTO saveRutaDTO) {
        try {
            RutaDTO rutaDTO = rutaSerivice.guardarRuta(saveRutaDTO);
            return new ResponseEntity<>(rutaDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al crear el usuario", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
