package com.system.proyectoWeb.services;


import com.system.proyectoWeb.models.DAOs.UsuarioDAO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.Usuario;
import com.system.proyectoWeb.services.IServices.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Override
    public UsuarioDTO getUsuarioById(Integer idUsuario) {
        Usuario usuario = usuarioDAO.obtenerPorId(idUsuario); // Obtener el usuario por ID
        if (usuario == null) {
            return null; // Si no se encuentra el usuario, devuelve null
        }
        return new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo()
        );
    }


    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioDAO.obtenerTodos(); // Obtener todos los usuarios desde el DAO
        return usuarios.stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getIdUsuario(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getCorreo()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public UsuarioDTO createUsuario(UsuarioDTO saveUsuario) {
        if (saveUsuario.getNombre() == null || saveUsuario.getCorreo() == null) {
            throw new IllegalArgumentException("Nombre y Correo son obligatorios");
        }
        Usuario usuario = new Usuario(saveUsuario.getNombre(), saveUsuario.getApellido(), saveUsuario.getCorreo());
        usuario = usuarioDAO.guardar(usuario);
        return new UsuarioDTO(usuario.getNombre(), usuario.getApellido(), usuario.getCorreo());
    }

    @Override
    public void updateUsuario(Integer idUsuario, UsuarioDTO saveUsuario) {
        if (saveUsuario.getNombre() == null || saveUsuario.getCorreo() == null) {
            throw new IllegalArgumentException("Nombre y Correo son obligatorios");
        }
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario); // Asegurarse de que el idUsuario sea correcto
        usuario.setNombre(saveUsuario.getNombre());
        usuario.setApellido(saveUsuario.getApellido());
        usuario.setCorreo(saveUsuario.getCorreo());

        usuarioDAO.actulizar(usuario);
    }




    private UsuarioDTO convertirAUsuarioDTO(Usuario usuarioActualizado) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuarioActualizado.getIdUsuario(),
                usuarioActualizado.getNombre(),
                usuarioActualizado.getApellido(),
                usuarioActualizado.getCorreo()

        );
        return usuarioDTO;
    }


    @Override
    public void deleteUsuario(Integer idUsuario) {
        usuarioDAO.eliminar(idUsuario); // Llamada al método del DAO para eliminar el usuario
    }

}
