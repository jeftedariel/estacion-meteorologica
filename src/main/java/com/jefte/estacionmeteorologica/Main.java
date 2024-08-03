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
        JsonHandler json = new JsonHandler("animal.json");
        
        animal a1 = new animal(1, "pato");
        animal a2 = new animal(2, "perico");
        
        
        
        json.agregar(a1);
        
        json.eliminar(a2);
        
        
        
        
        
       
    }
}
