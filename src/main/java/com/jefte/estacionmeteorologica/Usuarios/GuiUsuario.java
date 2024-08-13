/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jefte.estacionmeteorologica.Usuarios;

import com.jefte.estacionmeteorologica.Usuarios.Filtrado;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
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
    private String nombre = "usuarios.json";
    
    private TableRowSorter trsfiltro;
    String filtro;

    public GuiUsuario() {
        this.setUndecorated(true);
        initComponents();
        this.gestionUsuario = new JsonHandler(nombre, new TypeReference<Map<Integer, Usuario>>() {
        });
        String[] nombreColumnas = {"Id", "Id Rol", "Cedula", "Nombre", "Apellido 1", "Apellido 2", "Correo", "Contra"};
        this.modelo.setColumnIdentifiers(nombreColumnas);
        this.tbUsuarios.setModel(modelo);

        actualizarTabla();
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
                this.gestionUsuario.editar(usuario.getId(),se);
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
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Usuarios");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVolver)
                .addGap(267, 267, 267)
                .addComponent(lblTitulo)
                .addContainerGap(311, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo))
                    .addComponent(btnVolver))
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 212, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    
    private void formFiltro() {

        Filtrado guiFiltro = new Filtrado(this, true);
        guiFiltro.setVisible(true);

        if (guiFiltro.confirmacion()) {
            this.modelo.setRowCount(0);

            for (Usuario usuario : this.gestionUsuario.obtenerDatos().values()) {
                boolean filtro = true;
                if (guiFiltro.getCheckId_Rol() && !String.valueOf(usuario.getId_rol()).contentEquals(guiFiltro.getDatos(0))){
                    filtro = false;
                }
                if (guiFiltro.getCheckCedula() && !String.valueOf(usuario.getCedula()).contentEquals(guiFiltro.getDatos(1))){
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
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
