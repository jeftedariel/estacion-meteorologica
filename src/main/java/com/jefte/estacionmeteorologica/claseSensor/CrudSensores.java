package com.jefte.estacionmeteorologica.claseSensor;

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
public class CrudSensores extends javax.swing.JFrame {

    private JsonHandler<Sensor> gestioSensor;
    private DefaultTableModel modelo = new DefaultTableModel();
    private String nombreJson = "sensores.json";
    
    public CrudSensores() {
        ConfiguracionTablas.inicializar();
        initComponents();
        this.gestioSensor = new JsonHandler(nombreJson, new TypeReference<Map<Integer, Sensor>>() {});
        String[] nombreColumnas = {"id", "Identificador", "Tipo", "Localizacion"};
        this.modelo = ConfiguracionTablas.noEditable();
        this.modelo.setColumnIdentifiers(nombreColumnas);
        this.tbSensores.setModel(modelo); 
        actualizarTabla();
        ConfiguracionTablas.styleTable(tbSensores);
        

    }
    
    public static void initGUI() {
    CrudSensores gui = new CrudSensores();
    gui.setShape(new RoundRectangle2D.Double(0,0,1249, 607, 50,50));
    gui.setResizable(false);
    gui.setLocationRelativeTo(null);
    gui.setVisible(true);
    
  }

    private void actualizarTabla() {
        this.modelo.setRowCount(0);
        for (Sensor sensor : this.gestioSensor.obtenerDatos().values()) {
            this.modelo.addRow(new Object[]{sensor.getId(), sensor.getIdentificador(), sensor.getTipo(), sensor.getLocalizacion()});

        }

    }

    private int obtenerUltimoId() {
        if (this.gestioSensor.obtenerDatos().isEmpty()) {
            return 0;
        }
        return this.gestioSensor.obtenerDatos().values().stream()
                .mapToInt(Sensor::getId)
                .max()
                .orElse(0);
    }

    private void abrirFormularioSensor(Sensor sensor) {

        formularioSensor formulario = new formularioSensor(this, true, sensor, nombreJson);

        formulario.setVisible(true);

        if (formulario.confirmacion()) {
            Sensor se = formulario.consultarTarea();

            if (sensor == null) {

                this.gestioSensor.agregar(se);

            } else {
                se.setId(sensor.getId());

                this.gestioSensor.editar(sensor.getId(), se);
                this.gestioSensor.editar(se.getId(), se);

            }
            actualizarTabla();
        }
    }

    private void eliminarSensor() {

        int filaSeleccionada = this.tbSensores.getSelectedRow();
        if (filaSeleccionada != - 1) {

            String id = String.valueOf(this.tbSensores.getValueAt(filaSeleccionada, 0));
            this.gestioSensor.eliminar(Integer.parseInt(id));
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un propietario para eliminarlo.");
        }
    }

    private void actualizar() {

        if (this.tbSensores.getSelectedRow() != -1) {

            String id = String.valueOf(this.tbSensores.getValueAt(this.tbSensores.getSelectedRow(), 0));
            Sensor se = this.gestioSensor.obtenerObjeto(Integer.parseInt(id));
            System.out.println(id);
            this.abrirFormularioSensor(se);

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una tarea para poder editarla.");
        }

    }

    private void formFiltro() {

        FiltroSensor guiFiltro = new FiltroSensor(this, true);
        guiFiltro.setVisible(true);

        if (guiFiltro.confirmacion()) {
            this.modelo.setRowCount(0);

            for (Sensor sensor : this.gestioSensor.obtenerDatos().values()) {
                boolean filtro = true;
                if (guiFiltro.getCkIdentificador() && !String.valueOf(sensor.getIdentificador()).contentEquals(guiFiltro.getDatos(0))) {
                    filtro = false;
                }
                if (guiFiltro.getCkTipo() && !String.valueOf(sensor.getTipo()).contentEquals(guiFiltro.getDatos(1))) {
                    filtro = false;
                }
                if (guiFiltro.getCkLocalizaciojn() && !String.valueOf(sensor.getLocalizacion()).contentEquals(guiFiltro.getDatos(2))) {
                    filtro = false;
                }

                if (filtro) {
                    this.modelo.addRow(new Object[]{
                        sensor.getId(),
                        sensor.getIdentificador(),
                        sensor.getTipo(),
                        sensor.getLocalizacion()

                    });
                }

            }

            this.tbSensores.setModel(modelo);
            this.tbSensores.repaint();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSensores = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pBotones = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pPrincipal.setBackground(new java.awt.Color(204, 204, 255));
        pPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbSensores.setBackground(new java.awt.Color(51, 51, 51));
        tbSensores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSensores.setFocusable(false);
        tbSensores.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tbSensores);

        pPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 750, 350));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/arrow-left_8196690 (1).png"))); // NOI18N
        jButton2.setToolTipText("");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pPrincipal.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 70, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Principal2.png"))); // NOI18N
        pPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/1.jpeg"))); // NOI18N
        pPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 610));

        getContentPane().add(pPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1000, 610));

        pBotones.setBackground(new java.awt.Color(255, 255, 255));
        pBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Eliminar");
        pBotones.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 70, 30));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Buscar");
        pBotones.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 50, 30));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Agregar");
        pBotones.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 80, 30));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Editar");
        pBotones.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 50, 30));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnActualizar.setBorder(null);
        btnActualizar.setFocusPainted(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        pBotones.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 250, 55));

        btnAgregar.setBackground(new java.awt.Color(255, 0, 0));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnAgregar.setToolTipText("");
        btnAgregar.setBorder(null);
        btnAgregar.setFocusPainted(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pBotones.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 55));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setFocusable(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pBotones.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 250, 55));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (3).png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setFocusable(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pBotones.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 250, 55));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/image (4).png"))); // NOI18N
        pBotones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 90, 70));

        getContentPane().add(pBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        abrirFormularioSensor(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarSensor();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        formFiltro();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         this.dispose();
        GUIMenu.initGui();
    }//GEN-LAST:event_jButton2ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTable tbSensores;
    // End of variables declaration//GEN-END:variables
}
