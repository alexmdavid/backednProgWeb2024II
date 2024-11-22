package com.system.proyectoWeb.controllers;

import com.system.proyectoWeb.models.DTOs.TorneoDTO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.services.TorneoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api/torneos")
public class TorneoController {
    @Autowired
    private TorneoService torneoService;

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);


    @GetMapping
    public ResponseEntity<List<TorneoDTO>> listarTorneos() {
        List<TorneoDTO> torneos = torneoService.obtenerTorneos();
        if (torneos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(torneos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TorneoDTO> crearTorneo(@RequestBody TorneoDTO saveUsuarioDTO) {
        try {
            TorneoDTO usuarioDTO = torneoService.createTorneo(saveUsuarioDTO);
            return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al crear el usuario", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
