package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Entity
@Setter @Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String sexo;
    private String tipoDeSangre;
    private String correo;
    private String contrasena;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InscripcionGrupo> inscripcionesG;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InscripcionTorneo> inscripcionesT;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Ruta ruta;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idRol")
    private Rol rol;

    public Usuario(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rol = new Rol("usuario");
    }

    public Usuario(String nombre, String apellido, String correo, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = new Rol("usuario");
    }

    public Usuario() {

    }

    public Usuario(int idUsuario, String nombre, String apellido, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.rol = new Rol("usuario");
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }





}

