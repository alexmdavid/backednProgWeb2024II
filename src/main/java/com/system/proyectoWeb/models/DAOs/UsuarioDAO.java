package com.system.proyectoWeb.models.DAOs;

import com.system.proyectoWeb.models.DAOs.IDAOs.IUsuarioDAO;
import com.system.proyectoWeb.models.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UsuarioDAO implements IUsuarioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> obtenerTodos() {
        return entityManager.createQuery("FROM Usuario", Usuario.class).getResultList();
    }

    @Override
    public Usuario obtenerPorId(int id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        if (usuario.getIdUsuario() == 0) { // Si es un nuevo usuario
            entityManager.persist(usuario);  // Persistir el nuevo usuario
            return usuario;
        } else {
            return entityManager.merge(usuario);  // Si ya existe, actualizar
        }
    }

    @Override
    public void eliminar(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario != null) {
            entityManager.remove(usuario); // Eliminar el usuario de la base de datos
        } else {
            throw new RuntimeException("Usuario con ID " + id + " no encontrado.");
        }
    }

    @Override
    public Usuario actulizar(Usuario usuario) {
        Usuario usuarioExistente = entityManager.find(Usuario.class, usuario.getIdUsuario());

        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setCorreo(usuario.getCorreo());
            return usuarioExistente;
        } else {
            throw new RuntimeException("Usuario con ID " + usuario.getIdUsuario() + " no encontrado.");
        }
    }
}
