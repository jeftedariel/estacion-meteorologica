package com.jefte.estacionmeteorologica.Validaciones;
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
    
    
    public static void inicializar(){
           try {
            FlatLaf.registerCustomDefaultsSource("Propiedades");
            UIManager.setLookAndFeel(new FlatMacLightLaf());
            
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

   }
    
   private static String estiloTabla(){
   String tableStyle = 
        "rowHeight:38;" +
        "intercellSpacing:0,1;" +
        "showHorizontalLines:true;" +
        "foreground:#000000;" + 
        "background:#ffffff;" + 
        "selectionBackground:#f0f0f0;" + 
        "selectionForeground:#000000;" +  
        "selectionInactiveBackground:#f7f7f7;" + 
        "selectionInactiveForeground:#000000;"; 
   
   return tableStyle;
   
   }
   
   private static String estiloTablaHeader(){
    String tableHeader =
        "background:#f5f5f5;" + 
        "height:45;" +
        "separatorColor:#dddddd;" +
        "hoverBackground:null;" +
        "foreground:#000000;" + 
        "pressedBackground:null;";
   
    return tableHeader;
   }
   
   private static void estilosMejorados(JTable table){
    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!isSelected) {
                c.setBackground(row % 2 == 0 ? new Color(245, 245, 245) : new Color(255, 255, 255)); // alterna colores de las filas 
            } else {
               c.setBackground(new Color(230, 230, 230)); 

            }

            return c;
        }
    });
   
   }
   
public static void styleTable(JTable table) {
    String estiloT = estiloTabla();
    String estiloH = estiloTablaHeader();
    table.putClientProperty(FlatClientProperties.STYLE, estiloT);
    table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, estiloH); 
    estilosMejorados(table);
   
}


        
public static DefaultTableModel noEditable() {
    return new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // hacer que todas la celdas sea no editables
        }
    };
}

}
