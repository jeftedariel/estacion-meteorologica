/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jefte.estacionmeteorologica.Usuarios;

import com.jefte.estacionmeteorologica.ManejoTablas.ConfiguracionTablas;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.Auth.GUIMenu;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import java.awt.geom.RoundRectangle2D;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Raul Quesada Morera
 */
public class GuiUsuario extends javax.swing.JFrame {

    private JsonHandler<Usuario> gestionUsuario;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String nombre = "Usuarios.json";
    private Usuario usuario;
    private TableRowSorter trsfiltro;
    String filtro;

    public GuiUsuario(Usuario usuario) {
        this.setUndecorated(true);
        ConfiguracionTablas.inicializar();
        initComponents();
        this.gestionUsuario = new JsonHandler(nombre, new TypeReference<Map<Integer, Usuario>>() {
        });
        String[] nombreColumnas = {"Id", "Id Rol", "Cedula", "Nombre", "Apellido 1", "Apellido 2", "Correo", "Contra"};
        this.modelo = ConfiguracionTablas.noEditable();
        this.modelo.setColumnIdentifiers(nombreColumnas);
        this.tbUsuarios.setModel(modelo);
        ConfiguracionTablas.styleTable(tbUsuarios);

        actualizarTabla();
        
        this.usuario = usuario;
    }

    public static void initGUI(Usuario usuario) {
        GuiUsuario gui = new GuiUsuario(usuario);

        gui.setShape(new RoundRectangle2D.Double(0, 0, 1250, 610, 50, 50));
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);

    }

    private void actualizarTabla() {
        this.modelo.setRowCount(0);
        this.gestionUsuario.obtenerDatos();

        for (Usuario usuario : this.gestionUsuario.obtenerDatos().values()) {
            this.modelo.addRow(new Object[]{usuario.getId(), usuario.getId_rol(), usuario.getCedula(), usuario.getNombre(), usuario.getPrimer_apellido(), usuario.getSegundo_apellido(), usuario.getCorreo_electronico(), usuario.getContrasena()});
        }
    }

    private void abrirFormularioUsuario(Usuario usuario) {

        formulario formulario = new formulario(this, true, usuario);

        formulario.setVisible(true);

        if (formulario.confirmacion()) {
            Usuario se = formulario.consultarUsuario();

            if (usuario == null) {

                this.gestionUsuario.agregar(se);

            } else {
                se.setId(usuario.getId());
                this.gestionUsuario.editar(usuario.getId(), se);
            }
            actualizarTabla();
        }
    }

    private void eliminarUsuario() {

        int filaSeleccionada = this.tbUsuarios.getSelectedRow();
        if (filaSeleccionada != - 1) {

            String id = String.valueOf(this.tbUsuarios.getValueAt(filaSeleccionada, 0));
            this.gestionUsuario.eliminar(Integer.parseInt(id));
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario para eliminarlo.");
        }
        actualizarTabla();
    }

    private void editar() {
        if (this.tbUsuarios.getSelectedRow() != -1) {

            String id = String.valueOf(this.tbUsuarios.getValueAt(this.tbUsuarios.getSelectedRow(), 0));
            Usuario us = this.gestionUsuario.obtenerObjeto(Integer.parseInt(id));
            System.out.println(id);
            this.abrirFormularioUsuario(us);

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea para poder editarla.");
        }
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(204, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Editar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 250, 55));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Buscar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 250, 55));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Eliminar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 250, 55));

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Agregar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 55));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (4).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 100, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 610));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Id Rol", "Cédula", "Nombre", "1° Apellido", "2° Apellido", "Correo", "Contraseña"
            }
        ));
        jScrollPane1.setViewportView(tbUsuarios);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 750, 350));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/arrow-left_8196690 (1).png"))); // NOI18N
        jButton2.setToolTipText("");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 80, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Principal2.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/1.jpeg"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 610));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1000, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.abrirFormularioUsuario(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.eliminarUsuario();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.formFiltro();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        GUIMenu gui = new GUIMenu(this.usuario);
        gui.setShape(new RoundRectangle2D.Double(0, 0, 1250, 610, 50, 50));
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formFiltro() {

        Filtrado guiFiltro = new Filtrado(this, true);
        guiFiltro.setVisible(true);

        if (guiFiltro.confirmacion()) {
            this.modelo.setRowCount(0);

            for (Usuario usuario : this.gestionUsuario.obtenerDatos().values()) {
                boolean filtro = true;
                if (guiFiltro.getCheckId_Rol() && !String.valueOf(usuario.getId_rol()).contentEquals(guiFiltro.getDatos(0))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckCedula() && !String.valueOf(usuario.getCedula()).contentEquals(guiFiltro.getDatos(1))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckNombre() && !String.valueOf(usuario.getNombre()).contentEquals(guiFiltro.getDatos(2))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckPApellido() && !String.valueOf(usuario.getPrimer_apellido()).contentEquals(guiFiltro.getDatos(3))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckSApellido() && !String.valueOf(usuario.getSegundo_apellido()).contentEquals(guiFiltro.getDatos(4))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckCorreo() && !String.valueOf(usuario.getCorreo_electronico()).contentEquals(guiFiltro.getDatos(5))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckContrasena() && !String.valueOf(usuario.getContrasena()).contentEquals(guiFiltro.getDatos(6))) {
                    filtro = false;
                }

                if (filtro) {
                    this.modelo.addRow(new Object[]{
                        usuario.getId(),
                        usuario.getId_rol(),
                        usuario.getCedula(),
                        usuario.getNombre(),
                        usuario.getPrimer_apellido(),
                        usuario.getSegundo_apellido(),
                        usuario.getCorreo_electronico(),
                        usuario.getContrasena()
                    });
                }

            }

            this.tbUsuarios.setModel(modelo);
            this.tbUsuarios.repaint();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
