package com.system.proyectoWeb.controllers;

import com.system.proyectoWeb.models.DTOs.RutaDTO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.services.RutaSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rutas")
public class RutaController {
    @Autowired
    RutaSerivice rutaSerivice;
    @GetMapping
    public ResponseEntity<List<RutaDTO>> listarUsuarios() {
        List<RutaDTO> rutas = rutaSerivice.getRutas();

        if (rutas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rutas, HttpStatus.OK);
    }
}
