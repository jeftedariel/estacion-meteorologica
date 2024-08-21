/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jefte.estacionmeteorologica.Auth;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import com.jefte.estacionmeteorologica.Usuarios.Usuario;
import com.jefte.estacionmeteorologica.Validaciones.Validar;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Brandon Campos
 */
public class GUILogin extends javax.swing.JFrame {

  private JsonHandler<Usuario> gestionUsuario;
  private String nombreJson = "Usuarios.json";
  private boolean[] checks = { false, false };

  public GUILogin() {
    this.setUndecorated(true);
    initComponents();
    this.btnIngresar.setEnabled(false);
    this.gestionUsuario = new JsonHandler(nombreJson, new TypeReference<Map<Integer, Usuario>>() {
    });
    

  }

  public static void initGUI() {
    GUILogin gui = new GUILogin();
    gui.setShape(new RoundRectangle2D.Double(0,0,1294, 730, 50,50));
    gui.setResizable(false);
    gui.setLocationRelativeTo(null);
    gui.setVisible(true);
    
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIniciarSesion = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        lblQuiereRegistrarse = new javax.swing.JLabel();
        btnRegistreseAqui = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIniciarSesion.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        lblIniciarSesion.setText("INICIAR SESION");
        jPanel1.add(lblIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        txtCorreoElectronico.setBackground(new java.awt.Color(243, 241, 255));
        txtCorreoElectronico.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtCorreoElectronico.setToolTipText("Correo Electronico");
        txtCorreoElectronico.setActionCommand("<Not Set>");
        txtCorreoElectronico.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtCorreoElectronico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoElectronicoFocusGained(evt);
            }
        });
        txtCorreoElectronico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCorreoElectronicoMousePressed(evt);
            }
        });
        txtCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElectronicoActionPerformed(evt);
            }
        });
        txtCorreoElectronico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoElectronicoKeyReleased(evt);
            }
        });
        jPanel1.add(txtCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 290, 30));

        txtContraseña.setBackground(new java.awt.Color(243, 241, 255));
        txtContraseña.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        txtContraseña.setToolTipText("Contraseña");
        txtContraseña.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusGained(evt);
            }
        });
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyReleased(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 290, -1));

        btnIngresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/login.png"))); // NOI18N
        btnIngresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 130, 70));

        lblQuiereRegistrarse.setBackground(new java.awt.Color(187, 187, 187));
        lblQuiereRegistrarse.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lblQuiereRegistrarse.setText("¿No tienes cuenta?, Registrate!");
        jPanel1.add(lblQuiereRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, -1, -1));

        btnRegistreseAqui.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistreseAqui.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistreseAqui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/registro.png"))); // NOI18N
        btnRegistreseAqui.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnRegistreseAqui.setContentAreaFilled(false);
        btnRegistreseAqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistreseAquiActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistreseAqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 250, 70));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(82, 82, 82));
        jLabel6.setText("Debes iniciar sesión para ingresar al sistema");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 135, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/usuario.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/contraseña.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtField.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/txtField.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        lblContraseña.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lblContraseña.setText("Contraseña");
        jPanel1.add(lblContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        lblCorreo.setText("Correo Electronico");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 730));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Estación Meteorológica.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/estacion.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconoRayo.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/fondoTexto.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/fondoSideLogin.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 730));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void txtCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtCorreoElectronicoActionPerformed
    // TODO add your handling code here:
  }// GEN-LAST:event_txtCorreoElectronicoActionPerformed

  private void txtCorreoElectronicoFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtCorreoElectronicoFocusGained
    if (this.txtCorreoElectronico.getText().equals("Correo Electronico")) {
      this.txtCorreoElectronico.setText("");
    }
  }// GEN-LAST:event_txtCorreoElectronicoFocusGained

  private void txtContraseñaFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtContraseñaFocusGained
    if (this.txtContraseña.getText().equals("Contraseña")) {
      this.txtContraseña.setText("");
    }

  }// GEN-LAST:event_txtContraseñaFocusGained

  private void txtCorreoElectronicoMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_txtCorreoElectronicoMousePressed

  }// GEN-LAST:event_txtCorreoElectronicoMousePressed

  private boolean isCheck() {
    if (checks[0] && checks[1]) {
      return true;
    }
    return false;
  }

  private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtContraseñaActionPerformed
    // TODO add your handling code here:
  }// GEN-LAST:event_txtContraseñaActionPerformed

  private void btnRegistreseAquiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRegistreseAquiActionPerformed
    GUIRegistro.initGui();
    this.dispose();
  }// GEN-LAST:event_btnRegistreseAquiActionPerformed

  private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnIngresarActionPerformed
    boolean existe = false, passCorrecta = false;
    Decoder decoder = Base64.getDecoder();
    for (Usuario usuario : this.gestionUsuario.obtenerDatos().values()) {

        
      if (usuario.getCorreo_electronico().equals(this.txtCorreoElectronico.getText())) {
        existe = true;
      }
      
      if (new String(decoder.decode(usuario.getContrasena())).equals(this.txtContraseña.getText())) {
        passCorrecta = true;
        
      }

      if (passCorrecta && existe) {
        this.dispose();
        GUIMenu guimenu = new GUIMenu(usuario.getId_rol());
        guimenu.setVisible(true);
        guimenu.setLocationRelativeTo(null);
        guimenu.setResizable(false);
      }
    }

    if (!existe) {
      JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado.");
    } else if (!passCorrecta) {
      JOptionPane.showMessageDialog(null, "La contraseña no es correcta.");
    }
  }// GEN-LAST:event_btnIngresarActionPerformed

  private void txtCorreoElectronicoKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCorreoElectronicoKeyReleased
    if (Validar.validaciones(this.txtCorreoElectronico.getText(),
        "[A-Za-z0-9\\._%+\\-]+@[A-Za-z0-9\\.\\-]+\\.[A-Za-z]{2,}")) {
      this.lblCorreo.setForeground(Color.black);
      this.checks[0] = true;
    } else {
      this.checks[0] = false;
      this.lblCorreo.setForeground(Color.red);

    }
    this.btnIngresar.setEnabled(isCheck());

  }// GEN-LAST:event_txtCorreoElectronicoKeyReleased

  private void txtContraseñaKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtContraseñaKeyReleased
    if (Validar.validaciones(this.txtContraseña.getText(), "[\\S]+")) {
      this.lblContraseña.setForeground(Color.black);
      this.checks[1] = true;
    } else {
      this.checks[1] = false;
      this.lblContraseña.setForeground(Color.red);
    }

    this.btnIngresar.setEnabled(isCheck());
  }// GEN-LAST:event_txtContraseñaKeyReleased

  /**
   * @param args the command line arguments
   */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton btnIngresar;
    javax.swing.JButton btnRegistreseAqui;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JLabel lblContraseña;
    javax.swing.JLabel lblCorreo;
    javax.swing.JLabel lblIniciarSesion;
    javax.swing.JLabel lblQuiereRegistrarse;
    javax.swing.JTextField txtContraseña;
    javax.swing.JTextField txtCorreoElectronico;
    // End of variables declaration//GEN-END:variables
}
