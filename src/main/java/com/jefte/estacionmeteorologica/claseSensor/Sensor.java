package com.jefte.estacionmeteorologica.claseSensor;

/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class Sensor {
    
    private int id;
    private String tipo, localizacion,identificador;

    public Sensor() {
    }

    public Sensor(int id, String identificador, String tipo, String localizacion) {
        this.identificador = identificador;
        this.id = id;
        this.tipo = tipo;
        this.localizacion = localizacion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

 }