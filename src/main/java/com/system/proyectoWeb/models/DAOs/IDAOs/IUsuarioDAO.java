package com.system.proyectoWeb.models.DAOs.IDAOs;

import com.system.proyectoWeb.models.entities.Usuario;

import java.util.List;

public interface IUsuarioDAO {

        List<Usuario> obtenerTodos();
        Usuario obtenerPorId(int id);
        Usuario guardar(Usuario usuario);
        void eliminar(int id);
        Usuario actulizar(Usuario usuario);

}
