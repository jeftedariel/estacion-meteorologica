package claseSensor;

/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class Sensor {
    
    private int id;
    private String tipo, localizacion;

    public Sensor() {
    }

    
    public Sensor(int id, String tipo, String localizacion) {
        this.id = id;
        this.tipo = tipo;
        this.localizacion = localizacion;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    @Override
    public String toString() {
        
        return "Sensor{" +
                "tipo='" + tipo + '\'' +
                ", localizacion='" + localizacion + '\'' +
                '}';
    
    }
     
}
