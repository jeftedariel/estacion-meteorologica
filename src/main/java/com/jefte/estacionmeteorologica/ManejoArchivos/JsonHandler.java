/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jefte.estacionmeteorologica.ManejoArchivos;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author jefte
 */
public class JsonHandler {

    private static JsonHandler instanciaJsonHandler;

    private ObjectMapper ObjMap;

    public JsonHandler() {
        ObjMap = new ObjectMapper();
    }

    public static JsonHandler getInstance(String archivo) {
        if (instanciaJsonHandler == null) {
            instanciaJsonHandler = new JsonHandler();

        }
        return instanciaJsonHandler;
    }

    public static JsonHandler getInstance() {
        if (instanciaJsonHandler == null) {
            instanciaJsonHandler = new JsonHandler();
        }
        return instanciaJsonHandler;
    }

    public void fileHandler(String archivo) {
        new File(archivo);
    }

}
