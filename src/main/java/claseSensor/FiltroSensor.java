/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package claseSensor;



/**
 *
 * @author Justin Rodriguez Gonzalez
 */
public class FiltroSensor extends javax.swing.JDialog {

    private String[] datos = {"", "", "", "", ""};
    private boolean confirmar;

    /**
     * Creates new form FiltroSensor
     */
    public FiltroSensor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setUndecorated(true);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        this.confirmar = false;
    }

    public boolean confirmacion() {
        return this.confirmar;
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
        ckIdentificador = new javax.swing.JCheckBox();
        txtIdentificador = new javax.swing.JTextField();
        ckTipo = new javax.swing.JCheckBox();
        txtTipo = new javax.swing.JTextField();
        ckLocalizaciojn = new javax.swing.JCheckBox();
        txtLocalizacion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pPrincipal.setBackground(new java.awt.Color(204, 204, 255));

        ckIdentificador.setText("Indentificador");
        ckIdentificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckIdentificadorActionPerformed(evt);
            }
        });

        txtIdentificador.setEnabled(false);

        ckTipo.setText("Tipo");
        ckTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckTipoActionPerformed(evt);
            }
        });

        txtTipo.setEnabled(false);

        ckLocalizaciojn.setText("Localizacion");
        ckLocalizaciojn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckLocalizaciojnActionPerformed(evt);
            }
        });

        txtLocalizacion.setEnabled(false);

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
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrincipalLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ckLocalizaciojn)
                            .addComponent(ckIdentificador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdentificador)
                            .addComponent(ckTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txtTipo)
                            .addComponent(txtLocalizacion)))
                    .addGroup(pPrincipalLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrincipalLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(ckIdentificador)
                .addGap(18, 18, 18)
                .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(ckTipo)
                .addGap(18, 18, 18)
                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(ckLocalizaciojn)
                .addGap(32, 32, 32)
                .addComponent(txtLocalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        datos[0] = (this.txtIdentificador.isEnabled()) ? this.txtIdentificador.getText() : "";
        datos[1] = (this.txtTipo.isEnabled()) ? this.txtTipo.getText() : "";
        datos[2] = (this.txtLocalizacion.isEnabled()) ? this.txtLocalizacion.getText() : "";
        
        this.confirmar = true;
        this.setVisible(false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    public String getDatos(int indice) {
        return datos[indice];
    }
    
    private void ckIdentificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckIdentificadorActionPerformed
        this.txtIdentificador.setEnabled((this.txtIdentificador.isEnabled()) ? false : true);
    }//GEN-LAST:event_ckIdentificadorActionPerformed

    private void ckTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckTipoActionPerformed
        this.txtTipo.setEnabled((this.txtTipo.isEnabled()) ? false : true);
    }//GEN-LAST:event_ckTipoActionPerformed

    private void ckLocalizaciojnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckLocalizaciojnActionPerformed
        this.txtLocalizacion.setEnabled((this.txtLocalizacion.isEnabled()) ? false : true);
    }//GEN-LAST:event_ckLocalizaciojnActionPerformed

    public boolean getCkIdentificador() {
        return this.ckIdentificador.isSelected();
    }

    public boolean getCkLocalizaciojn() {
        return ckLocalizaciojn.isSelected();
    }


    public boolean getCkTipo() {
        return ckTipo.isSelected();
    }

    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JCheckBox ckIdentificador;
    private javax.swing.JCheckBox ckLocalizaciojn;
    private javax.swing.JCheckBox ckTipo;
    private javax.swing.JPanel pPrincipal;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtLocalizacion;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
