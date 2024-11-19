package com.system.proyectoWeb.controllers;


import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.Usuario;
import com.system.proyectoWeb.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public UsuarioDTO obtenerProducto(@PathVariable int id) {
        UsuarioDTO usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        return usuario;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuarios());
    }

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody Usuario usuario) {
        usuarioService.createUsuario(usuario);
        return ResponseEntity.ok("Usuario creado exitosamente.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuarioService.updateUsuario(id, usuario);
        return ResponseEntity.ok("Usuario actualizado exitosamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok("Usuario eliminado exitosamente.");
    }
}
