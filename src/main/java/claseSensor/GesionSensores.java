package claseSensor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    private ArrayList<Sensor> listaSensores;
    private ObjectMapper obM = new ObjectMapper();

    
    
    public GesionSensores() {
            mp = new ObjectMapper();
    try {
        this.listaSensores = cargarDatos();
    } catch (IOException e) {
        this.listaSensores = new ArrayList<>();
        e.printStackTrace();
    }
        
    }
      
    public ArrayList<Sensor> getListaSensores() {
        return listaSensores;
       
    }

    public void setListaSensores(ArrayList<Sensor> listaSensores) {
        this.listaSensores = listaSensores;
    }

    
    public void agregarSensor(Sensor sensor){
        
        this.listaSensores.add(sensor);
        try {
            
             mp.writeValue(new File(nombreJ), listaSensores);
       }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
    }
 }
    
   

    public ArrayList<Sensor> cargarDatos() throws IOException {
        File file = new File(nombreJ);
        if (file.exists()) {
            return mp.readValue(file, new TypeReference<ArrayList<Sensor>>() {});
        } else {
            return new ArrayList<>();
        }
    }
    
   
}
    
   
  
    
   

