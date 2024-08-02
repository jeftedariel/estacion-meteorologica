package claseSensor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Justin Rodriguez Gonzalez
 */
public class GesionSensores1 {
    private String nombreJ = "SensoresHashMaps.json";
    private ObjectMapper mp;
    private Map<Integer,Sensor> listaSensores;
   
    
    public GesionSensores1() {        
         mp = new ObjectMapper();
    
        try {
            revisarExistencia();
        } catch (IOException ex) {
            Logger.getLogger(GesionSensores1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  Map<Integer,Sensor> getListaSensores() {
        return listaSensores;
    }

    public void setListaSensores( Map<Integer,Sensor> listaSensores) {
        this.listaSensores = listaSensores;
    }
  
     private int obtenerUltimoId() {
        if (this.listaSensores.isEmpty()) {
            return 0; 
        }
        return this.listaSensores.values().stream()
                .mapToInt(Sensor::getId)
                .max()
                .orElse(0); 
    }
     
    
    public void agregarSensor(Sensor sensor){
        sensor.setId(obtenerUltimoId() + 1);
        this.listaSensores.put(sensor.getId(),sensor);     
       
        actualizarJson();
    }
    
    public void actualizarJson(){
     try {      
            mp.writeValue(new File(nombreJ),this.listaSensores);
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }
    
    public void eliminarSensor(int id){  
       this.listaSensores.remove(id);  
       actualizarJson();  
    }
    
       public Sensor obtenerSensor(int id) {
           
           return this.listaSensores.get(id);
     
    }
       
       public void EditarSensores(Sensor sensor){
       this.listaSensores.put(sensor.getId(), sensor);
       actualizarJson();
       }
     

    public Map<Integer,Sensor> cargarDatos() throws IOException {
        File arch = new File(nombreJ);
        if (arch.exists()) {
            return mp.readValue(arch, new TypeReference<Map<Integer,Sensor>>() {});
        } else {
            return new HashMap();
        }
    }
    
    private void revisarExistencia() throws IOException {
        File arch = new File(nombreJ);
        if (arch.exists()) {    
            this.listaSensores = cargarDatos();
        } else {    
            this.listaSensores = new HashMap();
        }
    }


}