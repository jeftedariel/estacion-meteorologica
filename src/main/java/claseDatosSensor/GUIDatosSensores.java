/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package claseDatosSensor;

import claseSensor.Sensor;
import claseSensor.formularioSensor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class GUIDatosSensores extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private JsonHandler<DatosSensor> gestionDatosSensor;
    private String nombreJson = "datosSensores.json";
    
    public GUIDatosSensores() {
        initComponents();
        this.gestionDatosSensor = new JsonHandler(nombreJson, new TypeReference<Map<Integer, DatosSensor>>() {});
        String[] columnas = {"id", "Valor", "Id Sensor", "Fecha", "Hora"};
        this.modelo.setColumnIdentifiers(columnas);
        tbDatosSensores.setModel(modelo);
        actualizarTabla();
        
    }
    
    private void actualizarTabla() {
        this.modelo.setRowCount(0);
        for (DatosSensor datos : this.gestionDatosSensor.obtenerDatos().values()) {
            this.modelo.addRow(new Object[]{datos.getId(), datos.getValor(), datos.getIdSensor(), datos.getFecha(), datos.getHora()});
            
        }
    }
    
    private void abrirFormularioDatosSensor(DatosSensor datosSensor) {
         
    FormularioDatosSensor formulario = new FormularioDatosSensor(this, true,nombreJson,datosSensor);
    
    formulario.setVisible(true);

    if (formulario.confirmacion()) {
        DatosSensor ds = formulario.consultarTarea();

        if (datosSensor == null) {
            
            this.gestionDatosSensor.agregar(ds);
           
        }else{
               ds.setId(datosSensor.getId());
               
            this.gestionDatosSensor.editar(datosSensor.getId(), ds);
            this.gestionDatosSensor.editar(ds.getId(),ds);
            
            }
       actualizarTabla();
    }
}
        private void eliminarDatoSensor() {
     
    int filaSeleccionada = this.tbDatosSensores.getSelectedRow();
    if (filaSeleccionada != - 1) {
        
        String id = String.valueOf(this.tbDatosSensores.getValueAt(filaSeleccionada, 0)); 
        this.gestionDatosSensor.eliminar(Integer.parseInt(id));
        actualizarTabla();
    } else {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un propietario para eliminarlo.");
    }
}
        
          private void actualizar(){

       if(this.tbDatosSensores.getSelectedRow()!= -1){
          
           String id = String.valueOf(this.tbDatosSensores.getValueAt(this.tbDatosSensores.getSelectedRow(), 0));
           DatosSensor ds = this.gestionDatosSensor.obtenerObjeto(Integer.parseInt(id));
           System.out.println(id);
           this.abrirFormularioDatosSensor(ds);
         
       }else{
           JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea para poder editarla.");
       }
 
 }
   
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatosSensores = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setText("Agregar");
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

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");

        tbDatosSensores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbDatosSensores);

        btnVolver.setText("Volver");

        javax.swing.GroupLayout pPrincipalLayout = new javax.swing.GroupLayout(pPrincipal);
        pPrincipal.setLayout(pPrincipalLayout);
        pPrincipalLayout.setHorizontalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnBuscar)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnVolver)
                .addGap(29, 29, 29))
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
        abrirFormularioDatosSensor(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      eliminarDatoSensor();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       actualizar();
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTable tbDatosSensores;
    // End of variables declaration//GEN-END:variables
}
