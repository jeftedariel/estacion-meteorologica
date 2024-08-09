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
    public int id, id_rol; 
    public String nombre,correo_electronico,contrasena;

    public Usuario(int id,String nombre,String correo_electronico, String contrasena) {
        this.id = id;
        this.id_rol = 0;
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
    }

    public Usuario() {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Usuario{" + "id=" + id + ", id_rol=" + id_rol + ", nombre=" + nombre + ", correo_electronico=" + correo_electronico + ", contrasena=" + contrasena + '}';
    }
    
    

   
    
    
}
