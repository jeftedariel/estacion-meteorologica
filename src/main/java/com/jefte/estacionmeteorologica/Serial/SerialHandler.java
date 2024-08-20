package com.jefte.estacionmeteorologica.Serial;

import com.fazecast.jSerialComm.SerialPort;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jefte
 */
public class SerialHandler {

    public static SerialPort[] obtenerPuertos() {
        if (SerialPort.getCommPorts().length > 0) {
            return SerialPort.getCommPorts();
        }
        return null;
    }

    public static String obtenerDato(int indice, String puerto) {
        SerialPort comPort = SerialPort.getCommPort(puerto);
        comPort.setBaudRate(9600);
        String[] datos={"0","0","0"};
        try {
            // Leer datos del puerto serial
            if (comPort.bytesAvailable() > 0) {
                byte[] readBuffer = new byte[comPort.bytesAvailable()];
                int numRead = comPort.readBytes(readBuffer, readBuffer.length);
                String dato = new String(readBuffer, 0, numRead);
                
                datos = dato.split(", ");
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            comPort.closePort();
            return datos[indice];
        }
    }
}
