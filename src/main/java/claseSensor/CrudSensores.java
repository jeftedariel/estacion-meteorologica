package claseSensor;

import com.fasterxml.jackson.core.type.TypeReference;
import com.jefte.estacionmeteorologica.ManejoArchivos.JsonHandler;
import com.jefte.estacionmeteorologica.Validaciones.ConfiguracionTablas;


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
        initComponents();
        this.gestioSensor = new JsonHandler(nombreJson, new TypeReference<Map<Integer, Sensor>>() {});
        String[] nombreColumnas = {"id", "Identificador", "Tipo", "Localizacion"};
        this.modelo.setColumnIdentifiers(nombreColumnas);
        this.tbSensores.setModel(modelo); 
        actualizarTabla();
        

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
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSensores = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregar.setText("Agregar");
        btnAgregar.setToolTipText("");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

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

        btnActualizar.setText("Editar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pPrincipalLayout = new javax.swing.GroupLayout(pPrincipal);
        pPrincipal.setLayout(pPrincipalLayout);
        pPrincipalLayout.setHorizontalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrincipalLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addGap(84, 84, 84)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(102, 102, 102)
                .addComponent(btnEliminar)
                .addGap(58, 58, 58))
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTable tbSensores;
    // End of variables declaration//GEN-END:variables
}
