package claseSensor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import java.util.Map;

/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class formularioSensor extends javax.swing.JDialog {
    private boolean edicion;
    private boolean confirmar;
    private JsonHandler <Sensor> gestionSensor; 
    /**
     * Creates new form formularioSensor
     */
    public formularioSensor(java.awt.Frame parent, boolean modal, Sensor sensor, String nombreJson) {
        super(parent, modal);
        initComponents();
        this.gestionSensor = new JsonHandler(nombreJson, new TypeReference<Map<Integer,Sensor>>(){});
        guardarDatos(sensor);
      
    }
    
    public void guardarDatos(Sensor sensor){
    
        if (sensor != null){
       
        this.txtIdentificadorS.setText(String.valueOf(sensor.getId()));
        this.txtTipo.setText(sensor.getTipo());
        this.txtLocalizacion.setText(sensor.getLocalizacion());
        
        this.edicion = true;
        
        }
        
        this.edicion = false;
    
    }

    public boolean confirmacion(){
     return this.confirmar;
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pSensor = new javax.swing.JPanel();
        txtTipo = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLocalizacion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtIdentificadorS = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTipo.setText("Tipo");

        jLabel1.setText("Localizacion");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel2.setText("Identificador");

        javax.swing.GroupLayout pSensorLayout = new javax.swing.GroupLayout(pSensor);
        pSensor.setLayout(pSensorLayout);
        pSensorLayout.setHorizontalGroup(
            pSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSensorLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSensorLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(pSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSensorLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSensorLayout.createSequentialGroup()
                        .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSensorLayout.createSequentialGroup()
                        .addGroup(pSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdentificadorS, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSensorLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))))
        );
        pSensorLayout.setVerticalGroup(
            pSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSensorLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(txtIdentificadorS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTipo)
                .addGap(18, 18, 18)
                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pSensorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVolver))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Sensor consultarTarea() {
        return new Sensor(
            gestionSensor.obtenerUltimoId()+1,
            Integer.parseInt(this.txtIdentificadorS.getText()),
            txtTipo.getText(),
            txtLocalizacion.getText()
        );
    }
    
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.confirmar = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.confirmar = true;
        this.setVisible(false);
    }//GEN-LAST:event_btnGuardarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pSensor;
    private javax.swing.JTextField txtIdentificadorS;
    private javax.swing.JTextField txtLocalizacion;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
