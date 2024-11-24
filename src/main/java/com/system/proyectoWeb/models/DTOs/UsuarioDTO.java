package com.system.proyectoWeb.models.DTOs;

import com.system.proyectoWeb.models.entities.Rol;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class UsuarioDTO {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String sexo;
    private String fechaNacimiento;
    private String tipoDeSangre;
    private Rol rol;


    public UsuarioDTO(Integer idUsuario, String nombre, String apellido, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public UsuarioDTO(String nombre, String apellido, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public UsuarioDTO() {
    }

    public UsuarioDTO(int idUsuario, String nombre, String apellido, String correo, String contrasenia, String ts, String sexo, String fe) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasenia;
        this.tipoDeSangre = ts;
        this.fechaNacimiento = fe;
        this.sexo = sexo;
    }

    public UsuarioDTO(int idUsuario, String nombre, String apellido, String correo, String contrasena, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }
}