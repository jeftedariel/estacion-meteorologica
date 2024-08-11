/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package claseDatosSensor;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;


/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class DatosSensor {
    int id;
    double valor;
    String idSensor;
    LocalDate fecha;
    String hora;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    
    public DatosSensor(int id, double valor, String idSensor) {
        this.id = id;
        this.valor = valor;
        this.idSensor = idSensor;
        this.fecha = LocalDate.now();
        this.hora =  dateFormat.format(date);
    }

    public DatosSensor() {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    

   
    @Override
    public String toString() {
        return "DatosSensor{" + "id=" + id + ", valor=" + valor + ", idSensor=" + idSensor + ", fecha=" + fecha + ", hora=" + hora + ", dateFormat=" + dateFormat + ", date=" + date + '}';
    }
    
    
    
    
}
