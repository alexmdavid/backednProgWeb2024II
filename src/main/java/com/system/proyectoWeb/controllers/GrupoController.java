package com.system.proyectoWeb.controllers;


import com.system.proyectoWeb.models.DTOs.GrupoDTO;
import com.system.proyectoWeb.models.DTOs.TorneoDTO;
import com.system.proyectoWeb.services.GrupoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@CrossOrigin("http://localhost:5173/")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);


    @GetMapping
    public ResponseEntity<List<GrupoDTO>> listarGrupos() {
        List<GrupoDTO> grupoDTOS = grupoService.getAllGrupos();
        if (grupoDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(grupoDTOS, HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<GrupoDTO> guardarGrupo(@RequestBody GrupoDTO grupo) {
        try {
            grupoService.crearGrupo(grupo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al crear el usuario", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
