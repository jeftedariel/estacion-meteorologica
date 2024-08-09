package claseSensor;

/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class Sensor {
    
    private int identificador, id;
    private String tipo, localizacion;

    public Sensor() {
    }

    public Sensor(int id, int identificador, String tipo, String localizacion) {
        this.identificador = identificador;
        this.id = id;
        this.tipo = tipo;
        this.localizacion = localizacion;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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

 }