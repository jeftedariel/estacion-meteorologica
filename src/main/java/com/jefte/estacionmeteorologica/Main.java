/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jefte.estacionmeteorologica;
import Roles.GUIRoles;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;

/**
 *
 * @author jefte
 */
public class Main {

    public static void main(String[] args){  
        //JsonHandler json = new JsonHandler("animales.json");
        
        //animal a1 = new animal(1,"pato"); 
        //animal a2 = new animal(2,"perico");
        
        
        //json.agregar(a1, a1.getId());
        //json.agregar(a2, a2.getId());
        
        //json.eliminar(a1.getId());
        //json.eliminar(a2.getId());
        
        
        //json.editar(1, a2);
        //System.out.println(json.obtenerDatos());
        GUIRoles g = new GUIRoles();
        g.setVisible(true);
    }
}