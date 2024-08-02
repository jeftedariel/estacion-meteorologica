/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefte.estacionmeteorologica;

/**
 *
 * @author Raul Quesada Morera
 */
public class Usuario {
    public int id, id_rol, cedula; 
    public String nombre, primer_apellido, segundo_apellido, correo_electronico,contrasena;

    public Usuario(int id, int id_rol, int cedula, String nombre, String primer_apellido, String segundo_apellido, String correo_electronico, String contrasena) {
        this.id = id;
        this.id_rol = id_rol;
        this.cedula = cedula;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", id_rol=" + id_rol + ", cedula=" + cedula + ", nombre=" + nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + segundo_apellido + ", correo_electronico=" + correo_electronico + ", contrasena=" + contrasena + '}';
    }
    
    
}
