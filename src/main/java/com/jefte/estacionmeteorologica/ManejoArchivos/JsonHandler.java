/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefte.estacionmeteorologica.ManejoArchivos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author jefte
 */
public class JsonHandler {

    private ObjectMapper ObjMap;
    private Map<Integer,Object> listas;

    private File archivo;

    //Crea archivo para definir esta vara no sé
    //Se debe pasar por parametro el nombre del archivo que se quiere crear.
    public JsonHandler(String nombre) {
        this.archivo = new File(nombre);
        this.ObjMap = new ObjectMapper();
        
        this.listas = (this.archivo.exists()) ? cargarDatos() : new HashMap<>();
        
        this.crearJson(archivo);
    }

    //Simplemente crea el archivo
    private void crearJson(File archivo) {
        if (!this.archivo.exists()) {
            try {
                this.archivo.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo crear el archivo json:" + archivo.getName() + "\n" + ex);
            }
        }
    }

    //metodo para escribir dentro del json
    public void agregar(Object objeto, int key) {
        //agrego a la lista
        this.listas.put(key,objeto);

        try {
            //metodo pa escribir mando el archivo y el objeto
            this.ObjMap.writeValue(archivo, this.listas);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar escribir el archivo.");
        }
    }

    //Devuelve una lista con las entradas del json.
    public Map<Integer,Object> cargarDatos() {
        if (this.archivo.exists()) {
            try {
                return this.ObjMap.readValue(this.archivo, new TypeReference<Map<Integer,Object>>() {
                });
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar cargar el archivo.");
                return null;
            }
        } else {
            return new HashMap<>();
        }
    }

    //metodo para escribir dentro del json
    public void eliminar(int key) {
       this.listas.remove(key);
        
        try {
            this.ObjMap.writeValue(this.archivo, this.listas);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar editar el archivo.");
        }

    }

}
