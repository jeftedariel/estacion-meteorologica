package claseSensor;

import com.fasterxml.jackson.core.type.TypeReference;
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
 * @author Justin Rodriguez Gonzalez
 */
public class GesionSensores {
    private String nombreJ = "SensoresListas.json";
    private ObjectMapper mp;
    private List<Sensor> listaSensores;
   
    
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
       
        actualizar();
    }
    
    public void actualizar(){
     try {      
            mp.writeValue(new File(nombreJ),this.listaSensores);
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    }
    
    public void eliminarSensor(int id){  
       this.listaSensores.removeIf(lista -> lista.getId() == id);  
       actualizar();  
    }
    
    public void editar(Sensor sensor){
            for(int i = 0; i < this.listaSensores.size(); i++){
           if (this.listaSensores.get(i).getId() == sensor.getId()){
               this.listaSensores.set(i, sensor);
    
           }  
        }
    
    }
    
       public Sensor obtenerSensor(int  id) {
         
           boolean encontrado = false;
           for(int i = 0; i < this.listaSensores.size(); i++){
           if (this.listaSensores.get(i).getId() == id){
               encontrado = true;
               return this.listaSensores.get(i);
    
           }  
        }
           
         return null;
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