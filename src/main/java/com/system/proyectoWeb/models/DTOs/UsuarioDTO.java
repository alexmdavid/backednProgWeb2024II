package com.system.proyectoWeb.models.DTOs;



public class UsuarioDTO {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String correo;

    public UsuarioDTO(Integer idUsuario, String nombre, String apellido, String correo) {
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }


}

