/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.jefte.estacionmeteorologica;

import javax.swing.JCheckBox;
/**
 *
 * @author Raul Quesada Morera
 */
public class Filtrado extends javax.swing.JDialog {
    private String[] datos = {"", "", "", "", "", ""};
    private boolean confirmar;

    public Filtrado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        this.confirmar=false;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        checkCedula = new javax.swing.JCheckBox();
        txtCedula = new javax.swing.JTextField();
        checkNombre = new javax.swing.JCheckBox();
        txtNombre = new javax.swing.JTextField();
        checkPApellido = new javax.swing.JCheckBox();
        txtPApellido = new javax.swing.JTextField();
        checkSApellido = new javax.swing.JCheckBox();
        checkCorreo = new javax.swing.JCheckBox();
        checkContrasena = new javax.swing.JCheckBox();
        txtContrasena = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        txtSApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        checkCedula.setText("Cédula");
        checkCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCedulaActionPerformed(evt);
            }
        });

        txtCedula.setEnabled(false);

        checkNombre.setText("Nombre");
        checkNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNombreActionPerformed(evt);
            }
        });

        txtNombre.setEnabled(false);

        checkPApellido.setText("Primer Apellido");
        checkPApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPApellidoActionPerformed(evt);
            }
        });

        txtPApellido.setEnabled(false);

        checkSApellido.setText("Segundo Apellido");
        checkSApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSApellidoActionPerformed(evt);
            }
        });

        checkCorreo.setText("Correo");
        checkCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCorreoActionPerformed(evt);
            }
        });

        checkContrasena.setText("Contraseña");
        checkContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkContrasenaActionPerformed(evt);
            }
        });

        txtContrasena.setEnabled(false);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtSApellido.setEnabled(false);

        txtCorreo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedula)
                            .addComponent(txtNombre)
                            .addComponent(txtPApellido)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                            .addComponent(checkPApellido)
                            .addComponent(checkSApellido)
                            .addComponent(txtSApellido)
                            .addComponent(txtCorreo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btnAceptar)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkPApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkSApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public boolean confirmacion() {
       return this.confirmar;
    }  
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //guarda los datos ingresados en el filtro
        datos[0] = (this.txtCedula.isEnabled()) ? this.txtCedula.getText() : "";
        datos[1] = (this.txtNombre.isEnabled()) ? this.txtNombre.getText() : "";
        datos[2] = (this.txtPApellido.isEnabled()) ? this.txtPApellido.getText() : "";
        datos[3] = (this.txtSApellido.isEnabled()) ? this.txtSApellido.getText() : "";
        datos[4] = (this.txtCorreo.isEnabled()) ? this.txtCorreo.getText() : "";
        datos[5] = (this.txtContrasena.isEnabled()) ? this.txtContrasena.getText() : "";
        this.confirmar = true;
        this.setVisible(false); 
    }//GEN-LAST:event_btnAceptarActionPerformed
      
    public String getDatos(int indice) {
        return datos[indice];
    }
    
    private void checkCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCedulaActionPerformed
        this.txtCedula.setEnabled((this.txtCedula.isEnabled()) ? false : true);
    }//GEN-LAST:event_checkCedulaActionPerformed

    private void checkNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkNombreActionPerformed
        this.txtNombre.setEnabled((this.txtNombre.isEnabled()) ? false : true);
    }//GEN-LAST:event_checkNombreActionPerformed

    private void checkPApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkPApellidoActionPerformed
        this.txtPApellido.setEnabled((this.txtPApellido.isEnabled()) ? false : true);
    }//GEN-LAST:event_checkPApellidoActionPerformed

    private void checkSApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSApellidoActionPerformed
        this.txtSApellido.setEnabled((this.txtSApellido.isEnabled()) ? false : true);
    }//GEN-LAST:event_checkSApellidoActionPerformed

    private void checkCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCorreoActionPerformed
        this.txtCorreo.setEnabled((this.txtCorreo.isEnabled()) ? false : true);
    }//GEN-LAST:event_checkCorreoActionPerformed

    private void checkContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkContrasenaActionPerformed
        this.txtContrasena.setEnabled((this.txtContrasena.isEnabled()) ? false : true);
    }//GEN-LAST:event_checkContrasenaActionPerformed

    public boolean getCheckCedula() {
        return checkCedula.isSelected();
    }

    public boolean getCheckContrasena() {
        return checkContrasena.isSelected();
    }

    public boolean getCheckCorreo() {
        return checkCorreo.isSelected();
    }

    public boolean getCheckNombre() {
        return checkNombre.isSelected();
    }

    public boolean getCheckPApellido() {
        return checkPApellido.isSelected();
    }

    public boolean getCheckSApellido() {
        return checkSApellido.isSelected();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JCheckBox checkCedula;
    private javax.swing.JCheckBox checkContrasena;
    private javax.swing.JCheckBox checkCorreo;
    private javax.swing.JCheckBox checkNombre;
    private javax.swing.JCheckBox checkPApellido;
    private javax.swing.JCheckBox checkSApellido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPApellido;
    private javax.swing.JTextField txtSApellido;
    // End of variables declaration//GEN-END:variables
}
