/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jefte.estacionmeteorologica;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import java.io.IOException;
/**
 *
 * @author jefte
 */
public class Main {

    public static void main(String[] args){
        String animal = "animalP.jason";
        
        
        JsonHandler json = new JsonHandler(animal);
        
        animal a1 = new animal(1, "pato");
        animal a2 = new animal(2, "perico");
        
        json.agregarContenido(a1,animal);
        json.agregarContenido(a2,animal);
        
        
        
        
        
       
    }
}
