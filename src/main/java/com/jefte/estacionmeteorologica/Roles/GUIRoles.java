/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jefte.estacionmeteorologica.Roles;

import com.jefte.estacionmeteorologica.Roles.GUIBuscarRol;
import com.jefte.estacionmeteorologica.Roles.GUIAgregarRol;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
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
        initComponents();
        this.gestionRol = new JsonHandler(nombreJson, new TypeReference<Map<Integer, Rol>>() {
        });
        String[] nombreColumnas = new String[]{"Id_Rol", "Nombre", "Sensores", "Datos_Sensores", "Datos_En_Vivo", "Datos_Usuario", "Datos_Roles", "Reportes"};
        this.modelo.setColumnIdentifiers(nombreColumnas);
        this.tbRoles.setModel(modelo);
        this.actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRoles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Gestión Roles");

        btnVolver.setText("Volver");

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnCrear)
                        .addGap(39, 39, 39)
                        .addComponent(btnEditar)
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminar)
                        .addGap(41, 41, 41)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1)))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbRoles;
    // End of variables declaration//GEN-END:variables
}
