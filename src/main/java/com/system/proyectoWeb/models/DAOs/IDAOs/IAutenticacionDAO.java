package com.system.proyectoWeb.models.DAOs.IDAOs;

import com.system.proyectoWeb.models.entities.Usuario;

import java.util.Optional;

public interface IAutenticacionDAO {
    // Método para encontrar un usuario por su nombre de usuario
    Optional<Usuario> findByUsername(String nombreUsu);

    // Método para encontrar un usuario por su email
    Optional<Usuario> findByEmail(String correo);

    // Verificar si el nombre de usuario ya está en uso
    boolean existsByUsername(String nombreUsu);

    // Verificar si el correo electrónico ya está registrado
    boolean existsByEmail(String correo);
}
