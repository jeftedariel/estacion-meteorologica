package claseSensor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import com.jefte.estacionmeteorologica.Validaciones.Validar;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class formularioSensor extends javax.swing.JDialog {

    private boolean edicion;
    private boolean confirmar;
    private JsonHandler<Sensor> gestionSensor;

    /**
     * Creates new form formularioSensor
     */
    public formularioSensor(java.awt.Frame parent, boolean modal, Sensor sensor, String nombreJson) {
        super(parent, modal);
        initComponents();
        this.gestionSensor = new JsonHandler(nombreJson, new TypeReference<Map<Integer, Sensor>>() {
        });
        guardarDatos(sensor);

    }

    public void guardarDatos(Sensor sensor) {

        if (sensor != null) {

            this.txtIdentificadorS.setText(String.valueOf(sensor.getIdentificador()));
            this.txtTipo.setText(sensor.getTipo());
            this.txtLocalizacion.setText(sensor.getLocalizacion());

            this.edicion = true;

        }

        this.edicion = false;

    }

    public boolean confirmacion() {
        return this.confirmar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pSensor = new javax.swing.JPanel();
        txtIdentificadorS = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtLocalizacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pSensor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdentificadorS.setBackground(new java.awt.Color(240, 237, 255));
        txtIdentificadorS.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtIdentificadorS.setForeground(new java.awt.Color(0, 0, 0));
        txtIdentificadorS.setBorder(null);
        pSensor.add(txtIdentificadorS, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 320, 40));

        txtTipo.setBackground(new java.awt.Color(240, 237, 255));
        txtTipo.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtTipo.setForeground(new java.awt.Color(0, 0, 0));
        txtTipo.setBorder(null);
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        pSensor.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 320, 40));

        txtLocalizacion.setBackground(new java.awt.Color(240, 237, 255));
        txtLocalizacion.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtLocalizacion.setForeground(new java.awt.Color(0, 0, 0));
        txtLocalizacion.setBorder(null);
        pSensor.add(txtLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 320, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtField2.png"))); // NOI18N
        pSensor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 390, 60));

        lblTipo.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("Tipo");
        pSensor.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 110, 60));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Identificador");
        pSensor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 130, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtField2.png"))); // NOI18N
        pSensor.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 390, 60));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Localizacion");
        pSensor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 130, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtField2.png"))); // NOI18N
        pSensor.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 390, 60));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cancelar");
        pSensor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, -1, -1));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Guardar");
        pSensor.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, -1, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (8).png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pSensor.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, 190, 54));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (8).png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.setFocusPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pSensor.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 190, 54));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (7).png"))); // NOI18N
        pSensor.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Sensor consultarTarea() {
        return new Sensor(
                gestionSensor.obtenerUltimoId() + 1,
                this.txtIdentificadorS.getText(),
                txtTipo.getText(),
                txtLocalizacion.getText()
        );
    }

    public void iniciar() {
        if (!this.txtIdentificadorS.getText().isEmpty() && !this.txtLocalizacion.getText().isEmpty() && !this.txtTipo.getText().isEmpty()) {
            if(Validar.validaciones(this.txtTipo.getText(), "Solo se aceptan letras", "^[a-zA-Z\\p{P}\\p{S}]+$")){
                if(Validar.validaciones(this.txtLocalizacion.getText(), "Solo se aceptan letras", "^[a-zA-Z\\p{P}\\p{S}]+$")){
            this.confirmar = true;
            this.setVisible(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Dejo uno de los campos de texto vacios");

        }
    }


    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.confirmar = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       // iniciar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JPanel pSensor;
    private javax.swing.JTextField txtIdentificadorS;
    private javax.swing.JTextField txtLocalizacion;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
