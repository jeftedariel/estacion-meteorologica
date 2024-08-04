/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefte.estacionmeteorologica.ManejoArchivos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author jefte
 */
public class JsonHandler {

    private ObjectMapper ObjMap;
    private Map<Integer, Object> listas;

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
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se pudo crear el archivo json:" + archivo.getName() + "\n" + e);
            }
        }
    }

    private boolean existe(int key) throws ObjetoNoEncontrado {
        if (this.listas.containsKey(key)) {
            return true;
        }
        throw new ObjetoNoEncontrado("EL objeto ingresado no existe.");
    }

    //metodo para escribir dentro del json
    public void agregar(Object objeto, int key) {
        //agrego a la lista
        try {
            //Si el objeto no existe en la lista, procede a intentar agregarlo.
            if (!existe(key)) {
                this.listas.put(key, objeto);
                //Se llama al objectMapper para que escriba sobre el archivo la lista actualizada.
                this.ObjMap.writeValue(archivo, this.listas);
            }
            //Si el obj ya se encontraba en el archivo
        } catch (ObjetoNoEncontrado e) {
            JOptionPane.showMessageDialog(null, "El objeto ya existe \n No se permiten objetos duplicados");
            //Algun problema de lectura del archivo json
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar agregar el objeto." + "\n" + e);
        }
    }

    //Devuelve una lista con las entradas del json.
    public Map<Integer, Object> cargarDatos() {
        if (this.archivo.exists()) {
            try {
                return this.ObjMap.readValue(this.archivo, new TypeReference<Map<Integer, Object>>() {
                });
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar cargar el archivo." + "\n" + e);
                return null;
            }
        } else {
            return new HashMap<>();
        }
    }

    //metodo para escribir dentro del json
    public void eliminar(int key) {
        if (existe(key)) {
            this.listas.remove(key);

            try {
                this.ObjMap.writeValue(this.archivo, this.listas);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar editar el archivo." + "\n" + e);
            }
        }

    }

    public void editar(Object objeto, int key) {
        if (existe(key)) {
            this.listas.replace(key, objeto);

            try {
                //reescribe el arch con la entrada editada
                this.ObjMap.writeValue(archivo, this.listas);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar escribir el archivo." + "\n" + e);
            }
        }
    }

}
