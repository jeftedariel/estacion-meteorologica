package claseSensor;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
        this.listaSensores = new ArrayList<>();
        
    }
      
    public ArrayList<Sensor> getListaSensores() {
        return listaSensores;
       
    }

    public void setListaSensores(ArrayList<Sensor> listaSensores) {
        this.listaSensores = listaSensores;
    }

    
    public void agregarSensor(Sensor sensor){
         try {
             this.listaSensores.add(sensor);
             guardarDatos(this.listaSensores);
         } catch (IOException ex) {
             Logger.getLogger(GesionSensores.class.getName()).log(Level.SEVERE, null, ex);
         }
 }
    
      public void guardarDatos(ArrayList<Sensor> listaSensores) throws IOException {
        mp.writeValue(new File(nombreJ), listaSensores);
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
    
   
  
    
   

