package ManejoTablas;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class ConfiguracionTablas {
    
    //inicializar la libreria flatfal con el mono blanco esto se tiene que llamar antes del inits components
    public static void inicializar(){
        
           try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());    
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

   }
  // generar el estilo que le quiero por a la tabla colores y demas se puede modificar depensiendo la gestion que se vaya a usar
  private static String estiloTabla() {
    String tableStyle =
        "rowHeight:38;" +
        "intercellSpacing:0,1;" +
        "showHorizontalLines:true;" +
        "foreground:#000000;" + 
        "background:#ffffff;" + 
        "selectionBackground:#f0f0f0;" + 
        "selectionForeground:#000000;" +  
        "selectionInactiveBackground:#f7f7f7;" + 
        "selectionInactiveForeground:#000000;" +
        "font: Poppins, 12;"; 
   
    return tableStyle;
}

private static String estiloTablaHeader() {
    String tableHeader =
        "background:#f5f5f5;" + 
        "height:45;" +
        "separatorColor:#dddddd;" +
        "hoverBackground:null;" +
        "foreground:#000000;" + 
        "pressedBackground:null;" +
        "font: Poppins, 14;"; 
   
    return tableHeader;
}

   
   // esteme metodso lo que hace es mejor varias partes voy a escribir dentro
   private static void estilosMejorados(JTable table){
    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            //crea la instancia que va a tener de tipo component para tener acceso y modificarlos
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
           //si no esta selecciona hace eso alternar los colorees de cada fila
            if (!isSelected) {
                c.setBackground(row % 2 == 0 ? new Color(245, 245, 245) : new Color(255, 255, 255)); // alterna colores de las filas 
            } else {
                //si esta seleccionada lo que hace es ponerla de ese color brr
               c.setBackground(new Color(230, 230, 230)); 

            }

            return c;
        }
    });
   
   }
   // aqui es el metodo que se va a llamar aqui llamo a los demas metodos que contenia estilos y ademas modificaciones y lo que hago es dafrles el estilo y ademas traer el aspecto mejora
public static void styleTable(JTable table) {
    String estiloT = estiloTabla();
    String estiloH = estiloTablaHeader();
    table.putClientProperty(FlatClientProperties.STYLE, estiloT);
    table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, estiloH); 
    estilosMejorados(table);
   
}


     //esto lo que hace de forma manual que la persona no pueda modificar tablanas    
public static DefaultTableModel noEditable() {
    return new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // hacer que todas la celdas sea no editables
        }
    };
}

//asi lo van a aplicar e el constructor brr
// ConfiguracionTablas.inicializar(); este siempre antes del inicializar porque lo que hace es cargar el estilo
//this.modelo = ConfiguracionTablas.noEditable(); este siempre despues de donde se definen las columnas de la tabla 
//  ConfiguracionTablas.styleTable(tbDatosSensores); y este si puede ser ya al final 

}
