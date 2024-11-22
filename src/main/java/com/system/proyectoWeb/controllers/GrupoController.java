package com.system.proyectoWeb.controllers;


import com.system.proyectoWeb.models.DTOs.GrupoDTO;
import com.system.proyectoWeb.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupo")
@CrossOrigin("http://localhost:5173/")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @PostMapping
    public void crearGrupo(@RequestBody GrupoDTO grupo) {
        grupoService.crearGrupo(grupo);
    }

    @GetMapping
    public ResponseEntity<List<GrupoDTO>> listarGrupos() {
        List<GrupoDTO> grupoDTOS = grupoService.getAllGrupos();
        if (grupoDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(grupoDTOS, HttpStatus.OK);
        }
    }
}
