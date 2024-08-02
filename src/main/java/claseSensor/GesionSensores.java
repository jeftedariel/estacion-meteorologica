package claseSensor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Justin Rodriguez Gonzalez
 */
public class GesionSensores {
    private String nombreJ = "Sensores.json";
    private ObjectMapper mp;
    private List<Sensor> listaSensores;
    private ObjectMapper obM = new ObjectMapper();
    
    public GesionSensores() {        
         mp = new ObjectMapper();
    
        try {
            revisarExistencia();
        } catch (IOException ex) {
            Logger.getLogger(GesionSensores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Sensor> getListaSensores() {
        return listaSensores;
    }

    public void setListaSensores(List<Sensor> listaSensores) {
        this.listaSensores = listaSensores;
    }

    private int obtenerUltimoId() {
        if (this.listaSensores.isEmpty()) {
            return 0; 
        }
        return this.listaSensores.stream()
                .mapToInt(Sensor::getId)
                .max()
                .orElse(0); 
    }
    
    public void agregarSensor(Sensor sensor){
        sensor.setId(obtenerUltimoId() + 1);
        this.listaSensores.add(sensor);     
        try {      
            mp.writeValue(new File(nombreJ), listaSensores);    
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void eliminarSensor(int id){
      
        
        this.listaSensores.removeIf(s -> s.getId() == id);
        
        
        try {
            mp.writeValue(new File(nombreJ), listaSensores);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        //return encontrado;
    }

    public List<Sensor> cargarDatos() throws IOException {
        File arch = new File(nombreJ);
        if (arch.exists()) {
            return mp.readValue(arch, new TypeReference<List<Sensor>>() {});
        } else {
            return new ArrayList<>();
        }
    }
    
    private void revisarExistencia() throws IOException {
        File arch = new File(nombreJ);
        if (arch.exists()) {    
            this.listaSensores = cargarDatos();
        } else {    
            this.listaSensores = new ArrayList<>();
        }
    }
}