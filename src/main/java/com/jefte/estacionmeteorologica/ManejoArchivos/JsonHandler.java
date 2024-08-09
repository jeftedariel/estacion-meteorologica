/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefte.estacionmeteorologica.ManejoArchivos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author jefte
 */
public class JsonHandler<T> {

    private ObjectMapper ObjMap;
    private Map<Integer, T> listas;
    //crear una referecia global para manejar con la que viene por parametros 
    private TypeReference<Map<Integer, T>> tipoRef;
    private File archivo;

    //Crea archivo para definir esta vara no sé
    //Se debe pasar por parametro el nombre del archivo que se quiere crear.
    //se pasa por parametros el tipo de objeto con el que se va a trabajar le llega en al mapa se manda en el crud
    public JsonHandler(String nombre, TypeReference<Map<Integer, T>> tipoRef) {
        this.archivo = new File(nombre);
        this.ObjMap = new ObjectMapper();
        this.crearJson(archivo);
        this.tipoRef = tipoRef;
        this.listas = (this.archivo.exists()) ? obtenerDatos() : new HashMap<>();

    }

    //Simplemente crea el archivo
    private void crearJson(File archivo) {
        if (!this.archivo.exists()) {

            try {
                this.archivo.createNewFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se pudo crear el archivo json:" + archivo.getName() + "\n" + e);
            }

        }
    }

    private boolean existe(int key) {
        if (this.listas.containsKey(key)) {
            return true;
        }
        return false;

    }
    
     private boolean existe(T objeto) {
        if (this.listas.containsValue(objeto)) {
            return true;
        }
        return false;

    }

    //metodo para escribir dentro del json
    public void agregar(T objeto) {
        try {
            //Si el objeto no existe en la lista, procede a intentar agregarlo.
            if (!existe(objeto)) {

                this.listas.put(obtenerUltimoId()+1, objeto);
                //Se llama al objectMapper para que escriba sobre el archivo la lista actualizada.
                this.ObjMap.writeValue(archivo, this.listas);
            } else {
                JOptionPane.showMessageDialog(null, "El objeto ya existia, no se pueden agregar datos duplicados.");
            }
            //Algun problema de lectura del archivo json
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar agregar el objeto." + "\n" + e);
        }
    }

    //Devuelve una lista con las entradas del json.
    public Map<Integer, T> obtenerDatos() {
        if (this.archivo.exists()) {
            try {
                //cambie la referencia que esta ya en el programa
                return this.ObjMap.readValue(this.archivo, this.tipoRef);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar cargar el archivo." + "\n" + e);
                return new HashMap<>();
            }
        } else {
            return new HashMap<>();
        }
    }

    //Devuelve un objeto específico.
    public T obtenerObjeto(int key) {
        if (this.archivo.exists()) {
            return this.listas.get(key);
        }
        JOptionPane.showMessageDialog(null, "No se pudo encontrar el objeto");
        return null;
    }

    //metodo para escribir dentro del json
    public void eliminar(int key) {
        
        //agrego a la lista
        try {
            //Si el objeto no existe en la lista, procede a intentar agregarlo.
            if (existe(key)) {
                this.listas.remove(key);
                //Se llama al objectMapper para que escriba sobre el archivo la lista actualizada.
                this.ObjMap.writeValue(archivo, this.listas);
            } else {
                JOptionPane.showMessageDialog(null, "El objeto no fue encontrado");
            }

            //Algun problema de lectura del archivo json
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar eliminar el objeto." + "\n" + e);
        }
    }

    public void editar(int key, T objeto) {
        
        
        if (existe(key)) {
            this.listas.put(key, objeto);
            try {
                //reescribe el arch con la entrada editada
                this.ObjMap.writeValue(archivo, this.listas);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Hubo un problema al intentar escribir en el archivo." + archivo.getName() + "\n" + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El objeto no fue encontrado");
        }
        
    }

    public int obtenerUltimoId() {
        
        if (this.listas.isEmpty()) {
            return 0;
        }
        return Collections.max(this.listas.keySet());
    }
}
