package com.system.proyectoWeb.services;


import com.system.proyectoWeb.models.DAOs.AutencticacionDAO;
import com.system.proyectoWeb.models.DAOs.UsuarioDAO;
import com.system.proyectoWeb.models.DTOs.UsuarioDTO;
import com.system.proyectoWeb.models.entities.Usuario;
import com.system.proyectoWeb.services.IServices.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private AutencticacionDAO autencticacionDAO;

    @Override
    public UsuarioDTO getUsuarioById(Integer idUsuario) {
        Usuario usuario = usuarioDAO.obtenerPorId(idUsuario);
        if (usuario == null) {
            return null;
        }
        return new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo(),
                usuario.getContrasena()
        );
    }


    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> usuarios = usuarioDAO.obtenerTodos();
        return usuarios.stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getIdUsuario(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getCorreo(),
                        usuario.getContrasena()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public UsuarioDTO createUsuario(UsuarioDTO saveUsuario) {
        if (saveUsuario.getNombre() == null || saveUsuario.getCorreo() == null || saveUsuario.getContrasena() == null) {
            throw new IllegalArgumentException("Nombre, Correo son obligatorios y contraseña");
        }
        Usuario usuario = new Usuario(saveUsuario.getNombre(), saveUsuario.getApellido(), saveUsuario.getCorreo(), saveUsuario.getContrasena());
        usuario = usuarioDAO.guardar(usuario);
        return new UsuarioDTO(usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getContrasena());
    }

    @Override
    public void updateUsuario(Integer idUsuario, UsuarioDTO saveUsuario) {
        if (saveUsuario.getNombre() == null || saveUsuario.getCorreo() == null) {
            throw new IllegalArgumentException("Nombre y Correo son obligatorios");
        }

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario.setNombre(saveUsuario.getNombre());
        usuario.setApellido(saveUsuario.getApellido());
        usuario.setCorreo(saveUsuario.getCorreo());
        usuario.setSexo(saveUsuario.getSexo());
        usuario.setTipoDeSangre(saveUsuario.getTipoDeSangre());


        String fechaNacimientoStr = saveUsuario.getFechaNacimiento();
        if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
            try {
                LocalDate fecha = LocalDate.parse(fechaNacimientoStr);
                usuario.setFechaNacimiento(Date.valueOf(fecha));
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Formato de fecha inválido: " + fechaNacimientoStr);
            }
        } else {
            usuario.setFechaNacimiento(null);
        }

        usuarioDAO.actulizar(usuario);
    }



    @Override
    public void deleteUsuario(Integer idUsuario) {
        usuarioDAO.eliminar(idUsuario);
    }

    public UsuarioDTO login(String correo, String contrasena) {
        Usuario usuario = autencticacionDAO.login(correo, contrasena);
        if (usuario != null) {
            return new UsuarioDTO(
                    usuario.getIdUsuario(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getCorreo(),
                    usuario.getContrasena()
            );
        }
        return null;
    }

    public UsuarioDTO obtenerUsuarioPorCorreo(String correo) {
        Usuario usuario = autencticacionDAO.buscarPorCorreo(correo);
        return new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCorreo(),
                usuario.getContrasena()
        );
    }
}
