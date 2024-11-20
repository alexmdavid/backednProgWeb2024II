package com.system.proyectoWeb.models.DAOs;

import com.system.proyectoWeb.models.DAOs.IDAOs.IAutenticacionDAO;
import com.system.proyectoWeb.models.entities.Usuario;

import java.util.Optional;

public class AutencticacionDAO implements IAutenticacionDAO {
    @Override
    public Optional<Usuario> findByUsername(String nombreUsu) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> findByEmail(String correo) {
        return Optional.empty();
    }

    @Override
    public boolean existsByUsername(String nombreUsu) {
        return false;
    }

    @Override
    public boolean existsByEmail(String correo) {
        return false;
    }
}
