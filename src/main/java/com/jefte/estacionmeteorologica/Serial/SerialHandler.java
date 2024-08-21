package com.jefte.estacionmeteorologica.Serial;

import com.fazecast.jSerialComm.SerialPort;

public class SerialHandler {

    private static SerialPort comPort;

    public static void abrirPuerto(String puerto) {
        System.out.println(SerialPort.getCommPorts());
        comPort = SerialPort.getCommPort(puerto);
        comPort.setBaudRate(9600);
        if (!comPort.openPort()) {
            System.out.println("Error al abrir el puerto.");
            
        }
    }

    public static void cerrarPuerto() {
        if (comPort != null && comPort.isOpen()) {
            comPort.closePort();
        }
    }

    public static String[] obtenerDato() {
        String[] split = {"0", "0", "0"};
        try {
            if (comPort.bytesAvailable() > 0) {
                byte[] readBuffer = new byte[comPort.bytesAvailable()];
                int numRead = comPort.readBytes(readBuffer, readBuffer.length);
                String dato = new String(readBuffer, 0, numRead);
                split = dato.split(",");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return split;
    }
}
