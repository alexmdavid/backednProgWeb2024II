package com.system.proyectoWeb.services.IServices;

import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    UsuarioDTO getUsuarioById(Integer idUsuario);
    List<UsuarioDTO> getAllUsuarios();
    UsuarioDTO createUsuario(UsuarioDTO usuario);
    void updateUsuario(Integer idUsuario, UsuarioDTO usuario);
    void deleteUsuario(Integer idUsuario);
}
