/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.jefte.estacionmeteorologica.Usuarios;

import com.jefte.estacionmeteorologica.Usuarios.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import com.jefte.estacionmeteorologica.Validaciones.Validar;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Raul Quesada Morera
 */
public class formulario extends javax.swing.JDialog {

    private JsonHandler<Usuario> gestionUsuario;
    private String nombre = "Usuarios.json";
    private boolean confirmar;
    private int idUsuario = 1;
    private boolean edicion;

    public formulario(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        this.gestionUsuario = new JsonHandler(nombre, new TypeReference<Map<Integer, Usuario>>() {
        });
        this.inicializarFormulario(usuario);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
    }

    private void inicializarFormulario(Usuario usuario) {
        if (usuario != null) {
            this.idUsuario = usuario.getId();
            this.txtId_Rol.setText(String.valueOf(usuario.getId_rol()));
            this.txtCedula.setText(String.valueOf(usuario.getCedula()));
            this.txtNombre.setText(usuario.getNombre());
            this.txtPApellido.setText(usuario.getPrimer_apellido());
            this.txtSApellido.setText(usuario.getSegundo_apellido());
            this.txtCorreo.setText(usuario.getCorreo_electronico());
            this.txtContrasena.setText(usuario.getContrasena());
        } else {
            this.edicion = false;
        }
    }

    public boolean confirmacion() {
        return this.confirmar;
    }

    public Usuario consultarUsuario() {
        return new Usuario(
                this.gestionUsuario.obtenerUltimoId() + 1,
                Integer.parseInt(this.txtId_Rol.getText()),
                Integer.parseInt(this.txtCedula.getText()),
                this.txtNombre.getText(),
                this.txtPApellido.getText(),
                this.txtSApellido.getText(),
                this.txtCorreo.getText(),
                this.txtContrasena.getText()
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblPApellido = new javax.swing.JLabel();
        lblSApellido = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPApellido = new javax.swing.JTextField();
        txtSApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        lblId_Rol = new javax.swing.JLabel();
        txtId_Rol = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        lblCedula.setText("Cédula");

        lblNombre.setText("Nombre");

        lblPApellido.setText("Primer Apellido");

        lblSApellido.setText("Segundo Apellido");

        lblCorreo.setText("Correo");

        lblContrasena.setText("Contraseña");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblId_Rol.setText("Id Rol");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContrasena)
                    .addComponent(lblCorreo)
                    .addComponent(lblSApellido)
                    .addComponent(lblPApellido)
                    .addComponent(lblNombre)
                    .addComponent(lblCedula)
                    .addComponent(lblId_Rol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(txtPApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addComponent(txtId_Rol))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId_Rol)
                    .addComponent(txtId_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPApellido))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSApellido))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContrasena))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(29, 29, 29))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.confirmar = false;
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.datosValidados();
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void datosValidados(){
    if(!this.txtCedula.getText().isEmpty() && !this.txtContrasena.getText().isEmpty() && !this.txtCorreo.getText().isEmpty() && !this.txtId_Rol.getText().isEmpty() && !this.txtNombre.getText().isEmpty() && !this.txtPApellido.getText().isEmpty() && !this.txtSApellido.getText().isEmpty()){
        if(Validar.validaciones(this.txtId_Rol.getText(),"Error de formato del id", "^\\d+$")){
            if(Validar.validaciones(this.txtCedula.getText(), "Error de formato de la cedula", "^\\d{9}$")){
                if(Validar.validaciones(this.txtNombre.getText(), "Error de formato del nombre", "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")){
                    if(Validar.validaciones(this.txtPApellido.getText(), "Error de formato del primer apellido", "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")){
                        if(Validar.validaciones(this.txtSApellido.getText(), "Error de formato del segundo apellido", "^[A-Za-záéíóúÁÉÍÓÚñÑ ]+$")){
                            if(Validar.validaciones(this.txtCorreo.getText(), "Error de formato del correo", "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
                                if(Validar.validaciones(this.txtContrasena.getText(), "Error de formato de la contrasena", "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")){
            this.confirmar = true;
            this.setVisible(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Hay algun espacio en blanco");
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
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
