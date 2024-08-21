/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jefte.estacionmeteorologica.Roles;

import com.jefte.estacionmeteorologica.ManejoTablas.ConfiguracionTablas;
import com.jefte.estacionmeteorologica.Roles.GUIBuscarRol;
import com.jefte.estacionmeteorologica.Roles.GUIAgregarRol;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.Auth.GUILogin;
import com.jefte.estacionmeteorologica.Auth.GUIMenu;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import java.awt.geom.RoundRectangle2D;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brandon Campos
 */
public class GUIRoles extends javax.swing.JFrame {

    private JsonHandler<Rol> gestionRol;
    private final DefaultTableModel modelo = new DefaultTableModel();
    private String nombreJson = "roles.json";

    public GUIRoles() {
        this.setUndecorated(true);
        ConfiguracionTablas.inicializar();
        initComponents();
        this.gestionRol = new JsonHandler(nombreJson, new TypeReference<Map<Integer, Rol>>() {
        });
        String[] nombreColumnas = new String[]{"Id_Rol", "Nombre", "Sensores", "Datos_Sensores", "Datos_En_Vivo", "Datos_Usuario", "Datos_Roles", "Reportes"};
        this.modelo.setColumnIdentifiers(nombreColumnas);
        this.tbRoles.setModel(modelo);
        this.actualizarTabla();
        ConfiguracionTablas.styleTable(tbRoles);
    }

    public static void initGUI() {
    GUIRoles gui = new GUIRoles();
    gui.setShape(new RoundRectangle2D.Double(0, 0, 1250, 610, 50, 50)); 
    gui.setResizable(false);
    gui.setLocationRelativeTo(null);
    gui.setVisible(true);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRoles = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(tbRoles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 830, 350));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/arrow-left_8196690 (1).png"))); // NOI18N
        jButton2.setToolTipText("");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 70, 70));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Principal2.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/1.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 610));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1000, 610));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Agregar");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.setBorder(null);
        btnCrear.setFocusPainted(false);
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 250, 55));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Editar");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 250, 55));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Eliminar");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 250, 55));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 250, 55));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (4).png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 90, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        this.abrirFormularioRol(null);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.EditarRol();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.eliminarRol();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.formFiltro();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
      GUIMenu.initGui();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    private void formFiltro() {
        GUIBuscarRol guiBuscarRol = new GUIBuscarRol(this, true, "roles.json");
        guiBuscarRol.setVisible(true);

        if (guiBuscarRol.confirmacion()) {
            this.modelo.setRowCount(0);

            for (Rol rol : gestionRol.obtenerDatos().values()) {
                System.out.println(rol.isSensores() + "- " + guiBuscarRol.obtenerDatos(0));

                boolean filtro = true;
                if (guiBuscarRol.getCkSensores() && !String.valueOf(rol.isSensores()).equals(guiBuscarRol.obtenerDatos(0))) {
                    filtro = false;
                }
                if (guiBuscarRol.getCkDatosSensores() && !String.valueOf(rol.isDatosSensores()).equals(guiBuscarRol.obtenerDatos(1))) {
                    filtro = false;
                }
                if (guiBuscarRol.getCkVivo() && !String.valueOf(rol.isDatosEnVivo()).equals(guiBuscarRol.obtenerDatos(2))) {
                    filtro = false;
                }
                if (guiBuscarRol.getCkRol() && !String.valueOf(rol.isDatosRoles()).equals(guiBuscarRol.obtenerDatos(3))) {
                    filtro = false;
                }
                if (guiBuscarRol.getCkReportes() && !String.valueOf(rol.isReportes()).equals(guiBuscarRol.obtenerDatos(4))) {
                    filtro = false;
                }
                if (guiBuscarRol.getCkUsuario() && !String.valueOf(rol.isDatosUsuarios()).equals(guiBuscarRol.obtenerDatos(5))) {
                    filtro = false;
                }
                if (filtro) {
                    this.modelo.addRow(new Object[]{
                        rol.getId(),
                        rol.getNombre(),
                        rol.isSensores(),
                        rol.isDatosSensores(),
                        rol.isDatosEnVivo(),
                        rol.isDatosUsuarios(),
                        rol.isDatosRoles(),
                        rol.isReportes()
                    });
                }

            }

            this.tbRoles.setModel(modelo);
            this.tbRoles.repaint();
        }
    }

    private void actualizarTabla() {
        this.modelo.setRowCount(0);
        for (Rol rol : this.gestionRol.obtenerDatos().values()) {
            this.modelo.addRow(new Object[]{rol.getId(), rol.getNombre(), rol.isSensores(), rol.isDatosSensores(), rol.isDatosEnVivo(), rol.isDatosUsuarios(), rol.isDatosRoles(), rol.isReportes()});

        }

    }

    private void abrirFormularioRol(Rol rol) {

        GUIAgregarRol formulario = new GUIAgregarRol(this, true, rol, "roles.json");

        formulario.setVisible(true);

        if (formulario.confirmacion()) {
            Rol ro = formulario.consultarTarea();

            if (rol == null) {
                System.out.println("agregando");
                this.gestionRol.agregar(ro);

            } else {

                ro.setId(rol.getId());
                this.gestionRol.editar(rol.getId(), ro);
                System.out.println("editando");

            }
            actualizarTabla();
        }
    }

    private void eliminarRol() {

        int filaSeleccionada = this.tbRoles.getSelectedRow();
        if (filaSeleccionada != - 1) {

            String id = String.valueOf(this.tbRoles.getValueAt(filaSeleccionada, 0));
            this.gestionRol.eliminar(Integer.parseInt(id));
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un rol para eliminarlo.");
        }
    }

    private void EditarRol() {
        if (this.tbRoles.getSelectedRow() != -1) {
            System.out.println(this.tbRoles.getSelectedRow());
            Rol rol = this.gestionRol.obtenerObjeto(Integer.parseInt(this.tbRoles.getValueAt(this.tbRoles.getSelectedRow(), 0).toString()));
            this.abrirFormularioRol(rol);

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un rol para poder editarlo.");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRoles;
    // End of variables declaration//GEN-END:variables
}
