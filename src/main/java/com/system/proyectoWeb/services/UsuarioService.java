package com.system.proyectoWeb.services;


import com.system.proyectoWeb.models.DAOs.UsuarioDAO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.Usuario;
import com.system.proyectoWeb.services.IServices.IUsuarioService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

private UsuarioDAO usuarioDAO;
    @Override
    public UsuarioDTO getUsuarioById(Integer idUsuario) {
        return (UsuarioDTO) usuarioDAO.obtenerTodos()
                .stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getIdUsuario(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getCorreo()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return List.of();
    }

    @Override
    public void createUsuario(Usuario usuario) {

    }

    @Override
    public void updateUsuario(Integer idUsuario, Usuario usuario) {

    }

    @Override
    public void deleteUsuario(Integer idUsuario) {

    }
}
