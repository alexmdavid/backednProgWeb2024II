package com.system.proyectoWeb.models.DAOs;

import com.system.proyectoWeb.models.DAOs.IDAOs.IAutenticacionDAO;
import com.system.proyectoWeb.models.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@Transactional
public class AutencticacionDAO  {
    @PersistenceContext
    private EntityManager em;

    public Usuario buscarPorCorreo(String correo) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo", Usuario.class)
                    .setParameter("correo", correo)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public  Usuario login(String correo, String contrasena) {
        Usuario usuario = buscarPorCorreo(correo);
        if(usuario != null) {
            if(contrasena.equals(usuario.getContrasena())) {
                return usuario;
            }
        }
        return null;
    }



}
