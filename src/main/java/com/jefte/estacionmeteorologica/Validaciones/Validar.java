/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefte.estacionmeteorologica.Validaciones;

import javax.swing.JOptionPane;

/**
 *
 * @author Brandon Campos
 */
public class Validar {
    public static boolean validaciones(String dato, String er, String regex){
        if(dato.matches(regex)){
            return true;
        }else{
            mensajeError(er);
            return false;
        }
    }
    
    public static void mensajeError(String err){
        JOptionPane.showMessageDialog(null, err);
    }

}
