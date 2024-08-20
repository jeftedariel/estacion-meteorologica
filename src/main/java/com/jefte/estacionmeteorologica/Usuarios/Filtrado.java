/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.jefte.estacionmeteorologica.Usuarios;

import javax.swing.JCheckBox;
/**
 *
 * @author Raul Quesada Morera
 */
public class Filtrado extends javax.swing.JDialog {
    private String[] datos = {"", "", "", "", "", "", ""};
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
        checkId_Rol = new javax.swing.JCheckBox();
        checkCedula = new javax.swing.JCheckBox();
        checkNombre = new javax.swing.JCheckBox();
        checkPApellido = new javax.swing.JCheckBox();
        checkSApellido = new javax.swing.JCheckBox();
        checkCorreo = new javax.swing.JCheckBox();
        checkContrasena = new javax.swing.JCheckBox();
        txtSApellido = new javax.swing.JTextField();
        txtPApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtId_Rol = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkId_Rol.setBackground(new java.awt.Color(255, 255, 255));
        checkId_Rol.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        checkId_Rol.setForeground(new java.awt.Color(255, 255, 255));
        checkId_Rol.setText("Id Rol");
        checkId_Rol.setContentAreaFilled(false);
        checkId_Rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkId_RolActionPerformed(evt);
            }
        });
        jPanel1.add(checkId_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 85, -1));

        checkCedula.setBackground(new java.awt.Color(255, 255, 255));
        checkCedula.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        checkCedula.setForeground(new java.awt.Color(255, 255, 255));
        checkCedula.setText("Cédula");
        checkCedula.setContentAreaFilled(false);
        checkCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCedulaActionPerformed(evt);
            }
        });
        jPanel1.add(checkCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 85, -1));

        checkNombre.setBackground(new java.awt.Color(255, 255, 255));
        checkNombre.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        checkNombre.setForeground(new java.awt.Color(255, 255, 255));
        checkNombre.setText("Nombre");
        checkNombre.setBorder(null);
        checkNombre.setContentAreaFilled(false);
        checkNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkNombreActionPerformed(evt);
            }
        });
        jPanel1.add(checkNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 85, -1));

        checkPApellido.setBackground(new java.awt.Color(255, 255, 255));
        checkPApellido.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        checkPApellido.setForeground(new java.awt.Color(255, 255, 255));
        checkPApellido.setText("Primer Apellido");
        checkPApellido.setBorder(null);
        checkPApellido.setContentAreaFilled(false);
        checkPApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkPApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(checkPApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        checkSApellido.setBackground(new java.awt.Color(255, 255, 255));
        checkSApellido.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        checkSApellido.setForeground(new java.awt.Color(255, 255, 255));
        checkSApellido.setText("Segundo Apellido");
        checkSApellido.setContentAreaFilled(false);
        checkSApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(checkSApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        checkCorreo.setBackground(new java.awt.Color(255, 255, 255));
        checkCorreo.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        checkCorreo.setForeground(new java.awt.Color(255, 255, 255));
        checkCorreo.setText("Correo");
        checkCorreo.setContentAreaFilled(false);
        checkCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(checkCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 85, -1));

        checkContrasena.setBackground(new java.awt.Color(255, 255, 255));
        checkContrasena.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        checkContrasena.setForeground(new java.awt.Color(255, 255, 255));
        checkContrasena.setText("Contraseña");
        checkContrasena.setContentAreaFilled(false);
        checkContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkContrasenaActionPerformed(evt);
            }
        });
        jPanel1.add(checkContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 130, -1));

        txtSApellido.setBackground(new java.awt.Color(240, 237, 255));
        txtSApellido.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtSApellido.setBorder(null);
        txtSApellido.setEnabled(false);
        jPanel1.add(txtSApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 260, 30));

        txtPApellido.setBackground(new java.awt.Color(240, 237, 255));
        txtPApellido.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtPApellido.setBorder(null);
        txtPApellido.setEnabled(false);
        jPanel1.add(txtPApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 260, 30));

        txtNombre.setBackground(new java.awt.Color(240, 237, 255));
        txtNombre.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.setEnabled(false);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 260, 30));

        txtCedula.setBackground(new java.awt.Color(240, 237, 255));
        txtCedula.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtCedula.setBorder(null);
        txtCedula.setEnabled(false);
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 260, 30));

        txtId_Rol.setBackground(new java.awt.Color(240, 237, 255));
        txtId_Rol.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtId_Rol.setBorder(null);
        txtId_Rol.setEnabled(false);
        jPanel1.add(txtId_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 260, 30));

        txtCorreo.setBackground(new java.awt.Color(240, 237, 255));
        txtCorreo.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtCorreo.setBorder(null);
        txtCorreo.setEnabled(false);
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 450, 260, 30));

        txtContrasena.setBackground(new java.awt.Color(240, 237, 255));
        txtContrasena.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtContrasena.setBorder(null);
        txtContrasena.setEnabled(false);
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 260, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 280, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 280, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 280, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 280, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 280, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 280, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 280, 50));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Buscar");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, -1, -1));

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (8).png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(null);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 600, 160, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (7).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 650));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 500, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public boolean confirmacion() {
       return this.confirmar;
    }  
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //guarda los datos ingresados en el filtro
        datos[0] = (this.txtId_Rol.isEnabled()) ? this.txtId_Rol.getText() : "";
        datos[1] = (this.txtCedula.isEnabled()) ? this.txtCedula.getText() : "";
        datos[2] = (this.txtNombre.isEnabled()) ? this.txtNombre.getText() : "";
        datos[3] = (this.txtPApellido.isEnabled()) ? this.txtPApellido.getText() : "";
        datos[4] = (this.txtSApellido.isEnabled()) ? this.txtSApellido.getText() : "";
        datos[5] = (this.txtCorreo.isEnabled()) ? this.txtCorreo.getText() : "";
        datos[6] = (this.txtContrasena.isEnabled()) ? this.txtContrasena.getText() : "";
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

    private void checkId_RolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkId_RolActionPerformed
        this.txtId_Rol.setEnabled((this.txtId_Rol.isEnabled()) ? false : true);
    }//GEN-LAST:event_checkId_RolActionPerformed

    public boolean getCheckId_Rol() {
        return checkId_Rol.isSelected();
    }
    
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
    private javax.swing.JCheckBox checkId_Rol;
    private javax.swing.JCheckBox checkNombre;
    private javax.swing.JCheckBox checkPApellido;
    private javax.swing.JCheckBox checkSApellido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtId_Rol;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPApellido;
    private javax.swing.JTextField txtSApellido;
    // End of variables declaration//GEN-END:variables
}
