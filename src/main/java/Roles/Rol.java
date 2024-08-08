/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Roles;

/**
 *
 * @author Brandon Campos
 */
public class Rol {
    private int id;
    private String nombre;
    private boolean reportes, sensores, datosSensores, datosEnVivo, datosUsuarios,datosRoles;

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", nombre=" + nombre + ", reportes=" + reportes + ", sensores=" + sensores + ", datosSensores=" + datosSensores + ", datosEnVivo=" + datosEnVivo + ", datosUsuarios=" + datosUsuarios + ", datosRoles=" + datosRoles + '}';
    }

    public Rol(int id, String nombre, boolean reportes, boolean sensores, boolean datosSensores, boolean datosEnVivo, boolean datosUsuarios, boolean datosRoles) {
        this.id = id;
        this.nombre = nombre;
        this.reportes = reportes;
        this.sensores = sensores;
        this.datosSensores = datosSensores;
        this.datosEnVivo = datosEnVivo;
        this.datosUsuarios = datosUsuarios;
        this.datosRoles = datosRoles;
    }

    public Rol() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isReportes() {
        return reportes;
    }

    public void setReportes(boolean reportes) {
        this.reportes = reportes;
    }

    public boolean isSensores() {
        return sensores;
    }

    public void setSensores(boolean sensores) {
        this.sensores = sensores;
    }

    public boolean isDatosSensores() {
        return datosSensores;
    }

    public void setDatosSensores(boolean datosSensores) {
        this.datosSensores = datosSensores;
    }

    public boolean isDatosEnVivo() {
        return datosEnVivo;
    }

    public void setDatosEnVivo(boolean datosEnVivo) {
        this.datosEnVivo = datosEnVivo;
    }

    public boolean isDatosUsuarios() {
        return datosUsuarios;
    }

    public void setDatosUsuarios(boolean datosUsuarios) {
        this.datosUsuarios = datosUsuarios;
    }

    public boolean isDatosRoles() {
        return datosRoles;
    }

    public void setDatosRoles(boolean datosRoles) {
        this.datosRoles = datosRoles;
    }
    
    
}
