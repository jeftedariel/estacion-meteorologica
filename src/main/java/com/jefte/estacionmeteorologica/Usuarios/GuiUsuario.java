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
    private String nombre = "Usuarios.json";
    
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
            JOptionPane.showMessageDialog(null, "Debe seleccionar un propietario para eliminarlo.");
        }
    }

    private void actualizar() {

        if (this.tbUsuarios.getSelectedRow() != -1) {

            String id = String.valueOf(this.tbUsuarios.getValueAt(this.tbUsuarios.getSelectedRow(), 0));
            //Sensor se = this.gestioSensor.obtenerSensor(Integer.parseInt(id));
            //this.abrirFormularioAnimal(se);

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea para poder editarla.");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Usuarios");

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

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(322, 322, 322))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo))
                    .addComponent(btnVolver))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 328, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.abrirFormularioUsuario(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.actualizarTabla();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
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
                if (guiFiltro.getCheckCedula() && !String.valueOf(usuario.getCedula()).contentEquals(guiFiltro.getDatos(0))){
                    filtro = false;
                }
                if (guiFiltro.getCheckNombre() && !String.valueOf(usuario.getNombre()).contentEquals(guiFiltro.getDatos(1))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckPApellido() && !String.valueOf(usuario.getPrimer_apellido()).contentEquals(guiFiltro.getDatos(2))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckSApellido() && !String.valueOf(usuario.getSegundo_apellido()).contentEquals(guiFiltro.getDatos(3))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckCorreo() && !String.valueOf(usuario.getCorreo_electronico()).contentEquals(guiFiltro.getDatos(4))) {
                    filtro = false;
                }
                if (guiFiltro.getCheckContrasena() && !String.valueOf(usuario.getContrasena()).contentEquals(guiFiltro.getDatos(5))) {
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
