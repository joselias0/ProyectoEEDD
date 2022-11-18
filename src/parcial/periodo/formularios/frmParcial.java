package parcial.periodo.formularios;

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import parcial.periodo.clases.Conexion;
import parcial.periodo.clases.equipoDeFutbol;
import parcial.periodo.clases.fichajes;

public class frmParcial extends javax.swing.JFrame {

    public Conexion conex;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private equipoDeFutbol equipo;
    private fichajes ficha;
    private int id_fichaje;
    
    public frmParcial() {
        initComponents();
        this.conex=new Conexion();
        model = (DefaultTableModel) this.tablaEquipos.getModel();
        model2 = (DefaultTableModel) this.tablaFichajes.getModel();
        this.equipo=new equipoDeFutbol();
        this.ficha=new fichajes();
        this.consultaEquipos(equipo.getTodo(conex));
        this.cargarFichajes();
        getContentPane().setBackground(Color.gray);
        this.setLocationRelativeTo(null);
    }
    
    private void consultaEquipos(ResultSet pRes)
    {
        try
        {
          model.setRowCount(0);
          Object Datos[]= new Object[5];
          
          while (pRes.next())
          {
              for (int i=0;i<5;i++) Datos[i]=pRes.getObject(i+1).toString().trim();
              model.addRow(Datos);
          }
          this.tablaEquipos.setModel(model);
          
        }
        catch(Exception e) {}
        
    }
    

    
    private void cargarFichajes()
    {
        // zona de cargar reparaciones
        try
        {
          model2.setRowCount(0);
          Object Datos[]= new Object[6];
          ResultSet pRes= equipo.buscarFichaje(conex.getConex());
          
          while (pRes.next())
          {
              for (int i=0;i<6;i++) Datos[i]=pRes.getObject(i+1).toString().trim();
              model2.addRow(Datos);
          }
          this.tablaFichajes.setModel(model2);
          
        }
        catch(Exception e) {}
    }
    
    private void cargarFichajesID(int id_equipo)
    {
        // zona de cargar reparaciones
        try
        {
          model2.setRowCount(0);
          Object Datos[]= new Object[6];
          ResultSet pRes= equipo.buscarFichajeID(conex.getConex(), id_equipo);
          while (pRes.next())
          {
              for (int i=0;i<6;i++) Datos[i]=pRes.getObject(i+1).toString().trim();
              model2.addRow(Datos);
          }
          this.tablaFichajes.setModel(model2);
          
        }
        catch(Exception e) {}
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLastName = new javax.swing.JTextField();
        txtNacio = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnAddEquipo = new javax.swing.JButton();
        btnDelEquipo = new javax.swing.JButton();
        btnAddJuga = new javax.swing.JButton();
        btnDelJuga = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNameEquip = new javax.swing.JTextField();
        txtPaisEquipo = new javax.swing.JTextField();
        txtEstadio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFichajes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNameJuga = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1088, 625));

        jLabel12.setText("Agregar fichaje");

        btnAddEquipo.setText("Agregar");
        btnAddEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEquipoActionPerformed(evt);
            }
        });

        btnDelEquipo.setText("Eliminar");
        btnDelEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelEquipoActionPerformed(evt);
            }
        });

        btnAddJuga.setText("Agregar");
        btnAddJuga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddJugaActionPerformed(evt);
            }
        });

        btnDelJuga.setText("Eliminar");
        btnDelJuga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelJugaActionPerformed(evt);
            }
        });

        jLabel5.setText("Pais al que pertenece:");

        jLabel6.setText("Estadio del equipo:");

        jLabel8.setText("Nombres del jugador:");

        jLabel9.setText("Apellidos del jugador:");

        jLabel10.setText("Nacionalidad:");

        jLabel1.setText("Lista de equipos");

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Equipo", "País", "Estadio", "Gastos en fichajes"
            }
        ));
        tablaEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEquiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEquipos);

        tablaFichajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Nombres", "Apellidos", "Nacionalidad", "Precio de transferencia", "ID Equipo"
            }
        ));
        jScrollPane2.setViewportView(tablaFichajes);

        jLabel2.setText("Lista de fichajes");

        jLabel3.setText("Agregar equipo");

        jLabel4.setText("Nombre del equipo:");

        jLabel11.setText("Precio de transferencia:");

        jButton2.setText("Mostrar Todo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("EQUIPOS DE FUTBOL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNameEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPaisEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelEquipo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNameJuga, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNacio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelJuga)))
                    .addComponent(jLabel12)
                    .addComponent(btnAddJuga)
                    .addComponent(jLabel3)
                    .addComponent(btnAddEquipo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 660, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jButton2))
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel1))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNameEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPaisEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEstadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddEquipo)
                            .addComponent(btnDelEquipo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNameJuga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNacio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddJuga)
                            .addComponent(btnDelJuga))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEquipoActionPerformed
        String nombreEquipo = this.txtNameEquip.getText().trim().toUpperCase();
        String pais = this.txtPaisEquipo.getText().trim().toUpperCase();
        String nombreEstadio = this.txtEstadio.getText().trim().toUpperCase();
        equipo.insert(conex.getConex(),nombreEquipo, pais, nombreEstadio);
        this.consultaEquipos(equipo.getTodo(conex));
        txtNameEquip.setText(null);
        txtPaisEquipo.setText(null);
        txtEstadio.setText(null);
    }//GEN-LAST:event_btnAddEquipoActionPerformed

    private void btnAddJugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddJugaActionPerformed
        int iRow=this.tablaEquipos.getSelectedRow();
        String nombre = this.txtNameJuga.getText().trim().toUpperCase();
        String apellido = this.txtLastName.getText().trim().toUpperCase();
        String nacionalidad = this.txtNacio.getText().trim().toUpperCase();
        float precioTrans=Float.parseFloat(this.txtPrecio.getText().trim());
        int id_equipo=Integer.parseInt(this.tablaEquipos.getValueAt(iRow, 0).toString());
        equipo.addFichaje(conex.getConex(), nombre, apellido, nacionalidad, precioTrans, id_equipo);
        this.cargarFichajesID(id_equipo);
        this.consultaEquipos(equipo.getTodo(conex));
        txtNameJuga.setText(null);
        txtLastName.setText(null);
        txtNacio.setText(null);
        txtPrecio.setText(null);
    }//GEN-LAST:event_btnAddJugaActionPerformed

    private void btnDelEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelEquipoActionPerformed
        int iRow=this.tablaEquipos.getSelectedRow();
        int id_equipo=Integer.parseInt(this.tablaEquipos.getValueAt(iRow, 0).toString());
        equipo.delete(conex.getConex(), id_equipo);
        this.cargarFichajes();
        this.consultaEquipos(equipo.getTodo(conex));
    }//GEN-LAST:event_btnDelEquipoActionPerformed

    private void btnDelJugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelJugaActionPerformed
        int iRow=this.tablaFichajes.getSelectedRow();
        int id_fichaje=Integer.parseInt(this.tablaFichajes.getValueAt(iRow, 0).toString());; 
        int id_equipo=Integer.parseInt(this.tablaFichajes.getValueAt(iRow, 5).toString());
        equipo.deleteFichaje(conex.getConex(), id_fichaje);
        this.cargarFichajesID(id_equipo);
        this.consultaEquipos(equipo.getTodo(conex));
    }//GEN-LAST:event_btnDelJugaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.cargarFichajes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tablaEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEquiposMouseClicked
        int iRow=this.tablaEquipos.getSelectedRow();
        int id_fichaje=Integer.parseInt(this.tablaEquipos.getValueAt(iRow, 0).toString());
        this.cargarFichajesID(id_fichaje);
    }//GEN-LAST:event_tablaEquiposMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmParcial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmParcial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmParcial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmParcial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmParcial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEquipo;
    private javax.swing.JButton btnAddJuga;
    private javax.swing.JButton btnDelEquipo;
    private javax.swing.JButton btnDelJuga;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTable tablaFichajes;
    private javax.swing.JTextField txtEstadio;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNacio;
    private javax.swing.JTextField txtNameEquip;
    private javax.swing.JTextField txtNameJuga;
    private javax.swing.JTextField txtPaisEquipo;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
