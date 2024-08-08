package claseSensor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class CrudSensores extends javax.swing.JFrame {
    private JsonHandler<Sensor> gestioSensor;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String nombreJson = "sensores.json"; 
    
   
    public CrudSensores() {
        initComponents();
        this.gestioSensor = new JsonHandler(nombreJson, new TypeReference<Map<Integer,Sensor>>(){});
        String [] nombreColumnas = {"ID","Tipo","Localizacion"};
        this.modelo.setColumnIdentifiers(nombreColumnas);
        this.tbSensores.setModel(modelo);
        actualizarTabla();
    }
    
    
   private void actualizarTabla(){
        this.modelo.setRowCount(0);
        for(Sensor sensor: this.gestioSensor.obtenerDatos().values()){
            this.modelo.addRow(new Object[] {sensor.getId(),sensor.getTipo(),sensor.getLocalizacion()});
        
        }
    
    }
    
    
    private void abrirFormularioAnimal(Sensor sensor) {
         
    formularioSensor formulario = new formularioSensor(this, true, sensor);
    
    formulario.setVisible(true);

    if (formulario.confirmacion()) {
        Sensor se = formulario.consultarTarea();

        if (sensor == null) {
            
            this.gestioSensor.agregar(se.getId(),se);
           
        }else{
            
            this.gestioSensor.editar(se.getId(),se);
            
            }
       actualizarTabla();
    }
}
    
       private void eliminarSensor() {
     
    int filaSeleccionada = this.tbSensores.getSelectedRow();
    if (filaSeleccionada != - 1) {
        
        String id = String.valueOf(this.tbSensores.getValueAt(filaSeleccionada, 0)); 
        this.gestioSensor.eliminar(Integer.parseInt(id));
        actualizarTabla();
    } else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un propietario para eliminarlo.");
    }
}
       
        private void actualizar(){

       if(this.tbSensores.getSelectedRow()!= -1){
          
           String id = String.valueOf(this.tbSensores.getValueAt(this.tbSensores.getSelectedRow(), 0));
           Sensor se = this.gestioSensor.obtenerObjeto(Integer.parseInt(id));
           this.abrirFormularioAnimal(se);
         
       }else{
           JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea para poder editarla.");
       }
 
 }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSensores = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tbSensores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbSensores);

        btnActualizar.setText("Editar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPrincipalLayout = new javax.swing.GroupLayout(pPrincipal);
        pPrincipal.setLayout(pPrincipalLayout);
        pPrincipalLayout.setHorizontalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrincipalLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrincipalLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnAgregar))
                .addGap(45, 45, 45)
                .addComponent(btnActualizar)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
     abrirFormularioAnimal(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
     eliminarSensor();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
     actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTable tbSensores;
    // End of variables declaration//GEN-END:variables
}
