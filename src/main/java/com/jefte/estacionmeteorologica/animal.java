
package com.jefte.estacionmeteorologica;

import java.util.Objects;

/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class animal {
    private int id;
    private String nombre;

    public animal(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "animal{" + "id=" + id + ", nombre=" + nombre + '}';
    }

     @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        animal that = (animal) obj;
        return id == that.id && Objects.equals(nombre, that.nombre);
    }
    
}
