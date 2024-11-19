package com.system.proyectoWeb.models.DAOs;

import com.system.proyectoWeb.models.DAOs.IDAOs.IUsuarioDAO;
import com.system.proyectoWeb.models.entities.Usuario;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {
    EntityManager entityManager;
    @Override
    public List<Usuario> obtenerTodos() {
        return entityManager.createQuery("FROM Usuario", Usuario.class).getResultList();
    }

    @Override
    public Usuario obtenerPorId(int id) {
        return null;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Usuario actulizar(Usuario usuario) {
        return null;
    }
}
