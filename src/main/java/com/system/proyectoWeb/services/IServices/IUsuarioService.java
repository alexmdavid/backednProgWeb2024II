package com.system.proyectoWeb.services.IServices;

import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    UsuarioDTO getUsuarioById(Integer idUsuario);
    List<UsuarioDTO> getAllUsuarios();
    void createUsuario(Usuario usuario);
    void updateUsuario(Integer idUsuario, Usuario usuario);
    void deleteUsuario(Integer idUsuario);
}
