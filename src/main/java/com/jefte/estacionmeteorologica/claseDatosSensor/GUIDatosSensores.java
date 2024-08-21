/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jefte.estacionmeteorologica.claseDatosSensor;

import com.jefte.estacionmeteorologica.ManejoTablas.ConfiguracionTablas;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.Auth.GUIMenu;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import java.awt.geom.RoundRectangle2D;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class GUIDatosSensores extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private JsonHandler<DatosSensor> gestionDatosSensor;
    private String nombreJson = "datosSensores.json";

    public GUIDatosSensores() {
        ConfiguracionTablas.inicializar();
        initComponents();
        this.gestionDatosSensor = new JsonHandler(nombreJson, new TypeReference<Map<Integer, DatosSensor>>() {
        });
        String[] columnas = {"id", "Valor", "Id Sensor", "Fecha", "Hora"};
        this.modelo = ConfiguracionTablas.noEditable();
        this.modelo.setColumnIdentifiers(columnas);
        tbDatosSensores.setModel(modelo);
        actualizarTabla();
        ConfiguracionTablas.styleTable(tbDatosSensores);

    }

    public static void initGUI() {
        GUIDatosSensores gui = new GUIDatosSensores();
        gui.setShape(new RoundRectangle2D.Double(0, 0, 1250, 610, 50, 50));
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);

    }

    private void actualizarTabla() {
        this.modelo.setRowCount(0);
        for (DatosSensor datos : this.gestionDatosSensor.obtenerDatos().values()) {
            this.modelo.addRow(new Object[]{datos.getId(), datos.getValor(), datos.getIdSensor(), datos.getFecha(), datos.getHora()});

        }
    }

    private void abrirFormularioDatosSensor(DatosSensor datosSensor) {

        FormularioDatosSensor formulario = new FormularioDatosSensor(this, true, nombreJson, datosSensor);

        formulario.setVisible(true);

        if (formulario.confirmacion()) {
            DatosSensor ds = formulario.consultarTarea();

            if (datosSensor == null) {

                this.gestionDatosSensor.agregar(ds);

            } else {
                ds.setId(datosSensor.getId());

                this.gestionDatosSensor.editar(datosSensor.getId(), ds);
                this.gestionDatosSensor.editar(ds.getId(), ds);

            }
            actualizarTabla();
        }
    }

    private void eliminarDatoSensor() {

        int filaSeleccionada = this.tbDatosSensores.getSelectedRow();
        if (filaSeleccionada != - 1) {

            String id = String.valueOf(this.tbDatosSensores.getValueAt(filaSeleccionada, 0));
            this.gestionDatosSensor.eliminar(Integer.parseInt(id));
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un propietario para eliminarlo.");
        }
    }

    private void actualizar() {

        if (this.tbDatosSensores.getSelectedRow() != -1) {

            String id = String.valueOf(this.tbDatosSensores.getValueAt(this.tbDatosSensores.getSelectedRow(), 0));
            DatosSensor ds = this.gestionDatosSensor.obtenerObjeto(Integer.parseInt(id));
            System.out.println(id);
            this.abrirFormularioDatosSensor(ds);

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea para poder editarla.");
        }

    }

    private void formFiltro() {

        Filtro guiFiltro = new Filtro(this, true);
        guiFiltro.setVisible(true);

        if (guiFiltro.confirmacion()) {
            this.modelo.setRowCount(0);

            for (DatosSensor datosSensor : this.gestionDatosSensor.obtenerDatos().values()) {
                boolean filtro = true;
                if (guiFiltro.getCkIdentificador() && !String.valueOf(datosSensor.getIdSensor()).contentEquals(guiFiltro.getDatos(0))) {
                    filtro = false;
                }
                if (guiFiltro.getCkFecha() && !String.valueOf(datosSensor.getFecha()).contentEquals(guiFiltro.getDatos(1))) {
                    filtro = false;
                }
                if (guiFiltro.getCkHora() && !String.valueOf(datosSensor.getHora()).contentEquals(guiFiltro.getDatos(2))) {
                    filtro = false;
                }

                if (filtro) {
                    this.modelo.addRow(new Object[]{
                        datosSensor.getId(),
                        datosSensor.getValor(),
                        datosSensor.getIdSensor(),
                        datosSensor.getFecha(),
                        datosSensor.getHora()

                    });
                }

            }

            this.tbDatosSensores.setModel(modelo);
            this.tbDatosSensores.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatosSensores = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbDatosSensores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbDatosSensores.setFocusable(false);
        tbDatosSensores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbDatosSensores);

        pPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 710, 350));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/arrow-left_8196690 (1).png"))); // NOI18N
        jButton2.setToolTipText("");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pPrincipal.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 60, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Principal2.png"))); // NOI18N
        pPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/1.jpeg"))); // NOI18N
        pPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 610));

        getContentPane().add(pPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1000, 610));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Editar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 110, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (4).png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 90, 70));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 110, 30));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Eliminar");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 120, 40));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Agregar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 110, 30));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 55));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 250, 55));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 250, 55));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 250, 55));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        abrirFormularioDatosSensor(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarDatoSensor();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        formFiltro();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
        GUIMenu gui = new GUIMenu();
        gui.setShape(new RoundRectangle2D.Double(0, 0, 1250, 610, 50, 50));
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTable tbDatosSensores;
    // End of variables declaration//GEN-END:variables
}
