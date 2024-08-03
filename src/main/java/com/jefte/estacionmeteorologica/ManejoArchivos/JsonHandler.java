/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefte.estacionmeteorologica.ManejoArchivos;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jefte
 */
public class JsonHandler {

    private ObjectMapper ObjMap;
    private List<Object> listas;
    //Crea archivo para definir esta vara no sé
    //Se debe pasar por parametro el nombre del archivo que se quiere crear.
    public JsonHandler(String nombre){
        File archivo = new File(nombre);
        this.crearJson(archivo);
        ObjMap = new ObjectMapper();
        this.listas = new ArrayList<>();
    }
    
    //Simplemente crea el archivo
    private void crearJson(File archivo) {
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo crear el archivo json:"+ archivo.getName() + "\n" + ex);
        } 
    }
    
      public void agregarContenido(Object objeto,String nombre){
        this.listas.add(objeto);
        File arch = new File(nombre);
        try {
            ObjMap.writeValue(arch, objeto);
            System.out.println("escribio");
        } catch (IOException ex) {
            Logger.getLogger(JsonHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

