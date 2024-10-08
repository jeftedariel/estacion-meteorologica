/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.jefte.estacionmeteorologica.Usuarios;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import com.jefte.estacionmeteorologica.Validaciones.Validar;
import java.awt.Color;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul Quesada Morera
 */
public class formulario extends javax.swing.JDialog {
    
    private JsonHandler<Usuario> gestionUsuario;
    private String nombre = "usuarios.json";
    private boolean confirmar;
    private int idUsuario = 1;
    private boolean edicion;
    private String contra;
    private boolean[] checks = {false, false, false, false, false, false, false};

    public formulario(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        
        this.btnGuardar.setEnabled(false);
        this.gestionUsuario = new JsonHandler(nombre, new TypeReference<Map<Integer, Usuario>>() {
        });
        this.inicializarFormulario(usuario);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
    }
    
    private void inicializarFormulario(Usuario usuario) {
        if (usuario != null) {
            Base64.Decoder decoder = Base64.getDecoder();
            
            this.idUsuario = usuario.getId();
            this.txtId_Rol.setText(String.valueOf(usuario.getId_rol()));
            this.txtCedula.setText(String.valueOf(usuario.getCedula()));
            this.txtNombre.setText(usuario.getNombre());
            this.txtPApellido.setText(usuario.getPrimer_apellido());
            this.txtSApellido.setText(usuario.getSegundo_apellido());
            this.txtCorreo.setText(usuario.getCorreo_electronico());
            this.txtContrasena.setText(new String(decoder.decode(usuario.getContrasena())));
            this.edicion = true;
            this.btnGuardar.setEnabled(true);

            //respuesta = new String(Base64.getDecoder().decode(s.getBytes("UTF8")),"UTF-8");
        } else {
            this.edicion = false;
        }
    }
    
    public boolean confirmacion() {
        return this.confirmar;
    }
    
    public Usuario consultarUsuario() {
        Encoder encoder = Base64.getEncoder();        
        return new Usuario(
                this.gestionUsuario.obtenerUltimoId() + 1,
                Integer.parseInt(this.txtId_Rol.getText()),
                Integer.parseInt(this.txtCedula.getText()),
                this.txtNombre.getText(),
                this.txtPApellido.getText(),
                this.txtSApellido.getText(),
                this.txtCorreo.getText(),
                encoder.encodeToString(this.txtContrasena.getText().getBytes())
        );
    }
    
    private boolean isCheck() {
        if (checks[0] && checks[1] && checks[2] && checks[3] && checks[4] && checks[5] && checks[6]) {
            return true;
        }
        
        if(this.edicion){
            return true;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblId_Rol = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblPApellido = new javax.swing.JLabel();
        lblSApellido = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        txtPApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtId_Rol = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtSApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId_Rol.setBackground(new java.awt.Color(255, 255, 255));
        lblId_Rol.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        lblId_Rol.setForeground(new java.awt.Color(255, 255, 255));
        lblId_Rol.setText("Id Rol");
        jPanel2.add(lblId_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, -1));

        lblNombre.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");
        jPanel2.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        lblCedula.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        lblCedula.setForeground(new java.awt.Color(255, 255, 255));
        lblCedula.setText("Cédula");
        jPanel2.add(lblCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblPApellido.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        lblPApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblPApellido.setText("Primer Apellido");
        jPanel2.add(lblPApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        lblSApellido.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        lblSApellido.setForeground(new java.awt.Color(255, 255, 255));
        lblSApellido.setText("Segundo Apellido");
        jPanel2.add(lblSApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo");
        jPanel2.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 70, -1));

        lblContrasena.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        lblContrasena.setForeground(new java.awt.Color(255, 255, 255));
        lblContrasena.setText("Contraseña");
        jPanel2.add(lblContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        txtPApellido.setBackground(new java.awt.Color(240, 237, 255));
        txtPApellido.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtPApellido.setBorder(null);
        txtPApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPApellidoActionPerformed(evt);
            }
        });
        txtPApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPApellidoKeyReleased(evt);
            }
        });
        jPanel2.add(txtPApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 260, 30));

        txtNombre.setBackground(new java.awt.Color(240, 237, 255));
        txtNombre.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtNombre.setBorder(null);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 260, 30));

        txtId_Rol.setBackground(new java.awt.Color(240, 237, 255));
        txtId_Rol.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtId_Rol.setBorder(null);
        txtId_Rol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtId_RolKeyReleased(evt);
            }
        });
        jPanel2.add(txtId_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 260, 30));

        txtCedula.setBackground(new java.awt.Color(240, 237, 255));
        txtCedula.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtCedula.setBorder(null);
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
        });
        jPanel2.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 260, 30));

        txtSApellido.setBackground(new java.awt.Color(240, 237, 255));
        txtSApellido.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtSApellido.setBorder(null);
        txtSApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSApellidoActionPerformed(evt);
            }
        });
        txtSApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSApellidoKeyReleased(evt);
            }
        });
        jPanel2.add(txtSApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 260, 30));

        txtCorreo.setBackground(new java.awt.Color(240, 237, 255));
        txtCorreo.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        txtCorreo.setBorder(null);
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 260, 30));

        txtContrasena.setBackground(new java.awt.Color(240, 237, 255));
        txtContrasena.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContrasena.setBorder(null);
        txtContrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContrasenaKeyReleased(evt);
            }
        });
        jPanel2.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 260, 30));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cancelar");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 552, -1, 30));

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (8).png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 190, 54));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Guardar");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, -1, 30));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (8).png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 190, 54));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 320, 90));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 300, 70));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 290, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 290, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 290, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 280, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtRedem.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 280, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (7).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.confirmar = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.datosValidados();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtPApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPApellidoActionPerformed
        
    }//GEN-LAST:event_txtPApellidoActionPerformed

    private void txtId_RolKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtId_RolKeyReleased
        if (Validar.validaciones(this.txtId_Rol.getText(), "^\\d+$")) {
            this.lblId_Rol.setForeground(Color.white);
            checks[0] = true;
        } else {
            this.lblId_Rol.setForeground(Color.red);
            checks[0] = false;
        }
        this.btnGuardar.setEnabled(isCheck());
    }//GEN-LAST:event_txtId_RolKeyReleased

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        if (Validar.validaciones(this.txtCedula.getText(), "^\\d{9}$")) {
            this.lblCedula.setForeground(Color.white);
            checks[1] = true;
        } else {
            this.lblCedula.setForeground(Color.red);
            checks[1] = false;
        }
        this.btnGuardar.setEnabled(isCheck());
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if (Validar.validaciones(this.txtNombre.getText(), "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
            this.lblNombre.setForeground(Color.white);
            checks[2] = true;
        } else {
            this.lblNombre.setForeground(Color.red);
            checks[2] = false;
        }
        this.btnGuardar.setEnabled(isCheck());
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtPApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPApellidoKeyReleased
        if (Validar.validaciones(this.txtPApellido.getText(), "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
            this.lblPApellido.setForeground(Color.white);
            checks[3] = true;
        } else {
            this.lblPApellido.setForeground(Color.red);
            checks[3] = false;
        }
        this.btnGuardar.setEnabled(isCheck());
    }//GEN-LAST:event_txtPApellidoKeyReleased

    private void txtSApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSApellidoActionPerformed
        
    }//GEN-LAST:event_txtSApellidoActionPerformed

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        if (Validar.validaciones(this.txtCorreo.getText(), "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            this.lblCorreo.setForeground(Color.white);
            checks[5] = true;
        } else {
            this.lblCorreo.setForeground(Color.red);
            checks[5] = false;
        }
        this.btnGuardar.setEnabled(isCheck());
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtSApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSApellidoKeyReleased
        if (Validar.validaciones(this.txtSApellido.getText(), "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")) {
            this.lblSApellido.setForeground(Color.white);
            checks[4] = true;
        } else {
            this.lblSApellido.setForeground(Color.red);
            checks[4] = false;
        }
        this.btnGuardar.setEnabled(isCheck());
    }//GEN-LAST:event_txtSApellidoKeyReleased

    private void txtContrasenaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasenaKeyReleased
        if (Validar.validaciones(this.txtContrasena.getText(), "[\\S]+")) {
            this.lblContrasena.setForeground(Color.white);
            checks[6] = true;
        } else {
            this.lblContrasena.setForeground(Color.red);
            checks[6] = false;
        }
        
        this.btnGuardar.setEnabled(isCheck() || this.edicion);
    }//GEN-LAST:event_txtContrasenaKeyReleased
    
    private void datosValidados() {
        if (!this.txtCedula.getText().isEmpty() && !this.txtContrasena.getText().isEmpty() && !this.txtCorreo.getText().isEmpty() && !this.txtId_Rol.getText().isEmpty() && !this.txtNombre.getText().isEmpty() && !this.txtPApellido.getText().isEmpty() && !this.txtSApellido.getText().isEmpty()) {
            
            this.confirmar = true;
            this.setVisible(false);
            this.btnGuardar.setEnabled(isCheck());
            
        } else {
            JOptionPane.showMessageDialog(null, "Hay algun espacio en blanco");
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblId_Rol;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPApellido;
    private javax.swing.JLabel lblSApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtId_Rol;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPApellido;
    private javax.swing.JTextField txtSApellido;
    // End of variables declaration//GEN-END:variables
}
