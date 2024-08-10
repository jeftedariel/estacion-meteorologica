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
        txtTipo = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtLocalizacion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtIdentificadorS = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pSensor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pSensor.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 184, -1));

        lblTipo.setText("Tipo");
        pSensor.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 41, -1));

        jLabel1.setText("Localizacion");
        pSensor.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 85, -1));
        pSensor.add(txtLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 184, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pSensor.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 130, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pSensor.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 130, -1));
        pSensor.add(txtIdentificadorS, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 184, -1));

        jLabel2.setText("Identificador");
        pSensor.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 89, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pSensor, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pSensor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
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
            this.confirmar = true;
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Dejo uno de los campos de texto vacios");

        }
    }


    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.confirmar = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        iniciar();
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
