package com.system.proyectoWeb.models.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
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

    @ManyToOne
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "idRuta")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    public Usuario(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public Usuario() {

    }

    // Getters y Setters


    public int getIdUsuario() {
        return idUsuario;
    }

    public Usuario setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Usuario setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Usuario setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public String getSexo() {
        return sexo;
    }

    public Usuario setSexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    public Usuario setTipoDeSangre(String tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
        return this;
    }

    public String getCorreo() {
        return correo;
    }

    public Usuario setCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public Usuario setGrupo(Grupo grupo) {
        this.grupo = grupo;
        return this;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public Usuario setRuta(Ruta ruta) {
        this.ruta = ruta;
        return this;
    }

    public Rol getRol() {
        return rol;
    }

    public Usuario setRol(Rol rol) {
        this.rol = rol;
        return this;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Usuario setContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }
}

