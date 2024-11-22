package com.system.proyectoWeb.models.DAOs;

import com.system.proyectoWeb.models.DAOs.IDAOs.IUsuarioDAO;
import com.system.proyectoWeb.models.entities.Rol;
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
        if (usuario.getIdUsuario() == 0) {
            entityManager.persist(usuario);
            return usuario;
        } else {
            return entityManager.merge(usuario);
        }
    }

    @Override
    public void eliminar(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario != null) {
            entityManager.remove(usuario);
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
            usuarioExistente.setTipoDeSangre(usuario.getTipoDeSangre());
            usuarioExistente.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioExistente.setSexo(usuario.getSexo());
            return usuarioExistente;
        } else {
            throw new RuntimeException("Usuario con ID " + usuario.getIdUsuario() + " no encontrado.");
        }
    }
}
