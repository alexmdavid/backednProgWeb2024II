package com.system.proyectoWeb.controllers;


import com.system.proyectoWeb.models.DTOs.GrupoDTO;
import com.system.proyectoWeb.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crearGrupo")
public class GrupoController {

    @Autowired
    GrupoService grupoService;

    @PostMapping
    public void crearGrupo(@RequestBody GrupoDTO grupo) {
        grupoService.crearGrupo(grupo);
    }
}
