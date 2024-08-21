package com.jefte.estacionmeteorologica.claseDatosSensor;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;



/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class DatosSensor {
    int id;
    double valor;
    String idSensor;
    String fecha = formatoFecha();
    String hora = formatoHora();
    
   
   
 
    
    public DatosSensor(int id, double valor, String idSensor) {
        this.id = id;
        this.valor = valor;
        this.idSensor = idSensor;
        this.fecha = fecha;
        this.hora =  hora;
    }

    public DatosSensor() {
    }
    
    public String formatoHora(){
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    String hora = dateFormat.format(date);
    
    return hora;
    
    }
    
    public String formatoFecha(){
    LocalDate localDate = LocalDate.now();
   DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
   String formateado = localDate.format(formato);
    
    return formateado;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(String idSensor) {
        this.idSensor = idSensor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "DatosSensor{" + "id=" + id + ", valor=" + valor + ", idSensor=" + idSensor + ", fecha=" + fecha + ", hora=" + hora;
    }
    
    
    
    
}
