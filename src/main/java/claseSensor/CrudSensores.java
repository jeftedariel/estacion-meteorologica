package claseSensor;

import ManejoTablas.ConfiguracionTablas;
import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;




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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSensores = new javax.swing.JTable();
        pBotones = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pPrincipal.setBackground(new java.awt.Color(204, 204, 255));
        pPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pPrincipal.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        pPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 670, 300));

        getContentPane().add(pPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 0, 890, 490));

        pBotones.setBackground(new java.awt.Color(255, 255, 255));
        pBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActualizar.setText("Editar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        pBotones.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 48, 302, 34));

        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pBotones.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 167, 302, 35));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pBotones.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 288, 302, 38));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pBotones.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 412, 302, 36));

        getContentPane().add(pBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 480, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        abrirFormularioSensor(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarSensor();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        formFiltro();
    }//GEN-LAST:event_btnBuscarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pBotones;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTable tbSensores;
    // End of variables declaration//GEN-END:variables
}
