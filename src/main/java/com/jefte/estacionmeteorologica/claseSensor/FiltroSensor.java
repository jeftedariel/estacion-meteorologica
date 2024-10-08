/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.jefte.estacionmeteorologica.claseSensor;




/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class FiltroSensor extends javax.swing.JDialog {

    private String[] datos = {"", "", "", "", ""};
    private boolean confirmar;

    /**
     * Creates new form FiltroSensor
     */
    public FiltroSensor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.confirmar = false;
    }

    public boolean confirmacion() {
        return this.confirmar;
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
        ckIdentificador = new javax.swing.JCheckBox();
        txtTipo = new javax.swing.JTextField();
        txtIdentificador = new javax.swing.JTextField();
        txtLocalizacion = new javax.swing.JTextField();
        ckLocalizaciojn = new javax.swing.JCheckBox();
        ckTipo = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pPrincipal.setBackground(new java.awt.Color(204, 204, 255));
        pPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ckIdentificador.setBackground(new java.awt.Color(240, 237, 255));
        ckIdentificador.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ckIdentificador.setForeground(new java.awt.Color(0, 0, 0));
        ckIdentificador.setText("Indentificador");
        ckIdentificador.setContentAreaFilled(false);
        ckIdentificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckIdentificadorActionPerformed(evt);
            }
        });
        pPrincipal.add(ckIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 210, 40));

        txtTipo.setBackground(new java.awt.Color(240, 237, 255));
        txtTipo.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtTipo.setBorder(null);
        txtTipo.setEnabled(false);
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        pPrincipal.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 320, 40));

        txtIdentificador.setBackground(new java.awt.Color(240, 237, 255));
        txtIdentificador.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtIdentificador.setBorder(null);
        txtIdentificador.setEnabled(false);
        pPrincipal.add(txtIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 320, 40));

        txtLocalizacion.setBackground(new java.awt.Color(240, 237, 255));
        txtLocalizacion.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtLocalizacion.setForeground(new java.awt.Color(0, 0, 0));
        txtLocalizacion.setBorder(null);
        txtLocalizacion.setEnabled(false);
        txtLocalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalizacionActionPerformed(evt);
            }
        });
        pPrincipal.add(txtLocalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 320, 40));

        ckLocalizaciojn.setBackground(new java.awt.Color(240, 237, 255));
        ckLocalizaciojn.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ckLocalizaciojn.setForeground(new java.awt.Color(0, 0, 0));
        ckLocalizaciojn.setText("Localizacion");
        ckLocalizaciojn.setBorder(null);
        ckLocalizaciojn.setContentAreaFilled(false);
        ckLocalizaciojn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ckLocalizaciojn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckLocalizaciojnActionPerformed(evt);
            }
        });
        pPrincipal.add(ckLocalizaciojn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 210, 40));

        ckTipo.setBackground(new java.awt.Color(240, 237, 255));
        ckTipo.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        ckTipo.setForeground(new java.awt.Color(0, 0, 0));
        ckTipo.setText("Tipo");
        ckTipo.setBorder(null);
        ckTipo.setContentAreaFilled(false);
        ckTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckTipoActionPerformed(evt);
            }
        });
        pPrincipal.add(ckTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 210, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtField2.png"))); // NOI18N
        pPrincipal.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 370, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtField2.png"))); // NOI18N
        pPrincipal.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 390, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtField2.png"))); // NOI18N
        pPrincipal.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 390, 60));

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar");
        pPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 570, 119, 44));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (8).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pPrincipal.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 289, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (7).png"))); // NOI18N
        pPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        datos[0] = (this.txtIdentificador.isEnabled()) ? this.txtIdentificador.getText() : "";
        datos[1] = (this.txtTipo.isEnabled()) ? this.txtTipo.getText() : "";
        datos[2] = (this.txtLocalizacion.isEnabled()) ? this.txtLocalizacion.getText() : "";
        
        this.confirmar = true;
        this.setVisible(false);
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    public String getDatos(int indice) {
        return datos[indice];
    }
    
    private void ckIdentificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckIdentificadorActionPerformed
        this.txtIdentificador.setEnabled((this.txtIdentificador.isEnabled()) ? false : true);
    }//GEN-LAST:event_ckIdentificadorActionPerformed

    private void ckTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckTipoActionPerformed
        this.txtTipo.setEnabled((this.txtTipo.isEnabled()) ? false : true);
    }//GEN-LAST:event_ckTipoActionPerformed

    private void ckLocalizaciojnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckLocalizaciojnActionPerformed
        this.txtLocalizacion.setEnabled((this.txtLocalizacion.isEnabled()) ? false : true);
    }//GEN-LAST:event_ckLocalizaciojnActionPerformed

    private void txtLocalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalizacionActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    public boolean getCkIdentificador() {
        return this.ckIdentificador.isSelected();
    }

    public boolean getCkLocalizaciojn() {
        return ckLocalizaciojn.isSelected();
    }


    public boolean getCkTipo() {
        return ckTipo.isSelected();
    }

    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JCheckBox ckIdentificador;
    private javax.swing.JCheckBox ckLocalizaciojn;
    private javax.swing.JCheckBox ckTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtLocalizacion;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
