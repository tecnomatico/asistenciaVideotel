/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.vista.horario;

import co.tecnomati.java.asistenciavideotel.cons.Constantes;
import co.tecnomati.java.asistenciavideotel.dominio.Horario;
import co.tecnomati.java.asistenciavideotel.dominio.dao.HorarioDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.HorarioDaoImp;
import co.tecnomati.java.asistenciavideotel.util.FechaUtil;
import co.tecnomati.java.asistenciavideotel.util.MiJoptionPane;
import co.tecnomati.java.asistenciavideotel.util.TablaUtil;
import co.tecnomati.java.asistenciavideotel.util.modeloTabla.ModeloHorario;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author joel
 */
public class GUIHorario extends javax.swing.JDialog {

    String paqueteImagen = "/co/tecnomati/java/asistenciavideotel/imagen/";
    Horario horario = null;
    boolean agregado = false; // este es una variable que se pone en verdadero si se guardo con exito los datos 
    private boolean modificar = false;
    boolean eliminado = false;
    boolean llamadoDesdeOtroLugar= false;
    javax.swing.ImageIcon iconoGuardar = new javax.swing.ImageIcon(getClass().getResource(paqueteImagen + "Guardar.jpg"));
    javax.swing.ImageIcon iconoModificar = new javax.swing.ImageIcon(getClass().getResource(paqueteImagen + "Modificar.png"));
    // datos para la tabla
    int numeroSeleccion;
    ModeloHorario modeloHorario;
    private TableRowSorter sorter;

    public GUIHorario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setDatosCmbMomento();
//        inicializarTabla();
        CargaTabla ct = new CargaTabla();
        ct.start();
        setEnabledComponentes(false);
         this.setTitle(Constantes.TITLE_NUEVO_HORARIO);
        this.setLocationRelativeTo(this);
        this.setVisible(true);
    }
    
    /**
     * 
     * @param parent
     * @param modal
     * @param llamado true si esta ventana es llamada desde otra ventana 
     */
    public GUIHorario(java.awt.Frame parent, boolean modal, boolean llamado) {
        super(parent, modal);
        initComponents();
        this.llamadoDesdeOtroLugar= llamado;
        setDatosCmbMomento();
//        inicializarTabla();
        CargaTabla ct = new CargaTabla();
        ct.start();
        setEnabledComponentes(false);
         this.setTitle(Constantes.TITLE_NUEVO_HORARIO);
        this.setLocationRelativeTo(this);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbMinutoSalida = new javax.swing.JComboBox();
        cmbHoraEntrada = new javax.swing.JComboBox();
        cmbHoraSalida = new javax.swing.JComboBox();
        cmbMinutoEntrada = new javax.swing.JComboBox();
        lblEntrada = new javax.swing.JLabel();
        lblHs = new javax.swing.JLabel();
        lblSalida = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblMomento = new javax.swing.JLabel();
        cmbMomento = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Horiario"));

        jLabel7.setText("min");

        jLabel6.setText("Hs ");

        cmbMinutoSalida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMinutoSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMinutoSalidaActionPerformed(evt);
            }
        });

        cmbHoraEntrada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbHoraEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHoraEntradaActionPerformed(evt);
            }
        });

        cmbHoraSalida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbHoraSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHoraSalidaActionPerformed(evt);
            }
        });

        cmbMinutoEntrada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        lblEntrada.setText("Entrada");

        lblHs.setText("Hs ");

        lblSalida.setText("Salida");

        lblMin.setText("min ");

        lblMomento.setText("Momento");

        cmbMomento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "DIA", "TARDE", "NOCHE" }));
        cmbMomento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMomentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEntrada)
                        .addGap(16, 16, 16)
                        .addComponent(cmbHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbMinutoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMomento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMomento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cmbHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cmbMinutoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHs)
                        .addComponent(cmbMinutoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMin)
                        .addComponent(cmbHoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEntrada, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(cmbHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalida)
                    .addComponent(cmbMinutoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMomento)
                    .addComponent(cmbMomento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Entrada", "Salida", "Momento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHorario);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addGap(33, 33, 33)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnSalir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMinutoSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMinutoSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMinutoSalidaActionPerformed

    private void cmbHoraSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHoraSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHoraSalidaActionPerformed

    private void cmbMomentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMomentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMomentoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        HorarioDao horarioDAO = new HorarioDaoImp();
        if (!modificar) {
            //si se ingresa un nueva persona
            horario = new Horario();
        }

        if (isCompletoDatosObligarios()) {
            // si se ingreso los datos del horario correctamente
            getDatos();
            if (modificar) {
                horarioDAO.upDateHorario(horario);
                MiJoptionPane.mensajeInformacionAtualizacionOK(this);
            } else {
                horarioDAO.addHorario(horario);
                MiJoptionPane.mensajeInformacionAltaOK(this);
                modeloHorario.addElement(horario);
            }
            setAgregado(true);
           
//            modeloHorario.aElement(horario);
            limpiarComponentes();
            setEnabledComponentes(false);
            setEnableBotonEditar(true);
            if (isLlamadoDesdeOtroLugar()) {
                setLlamadoDesdeOtroLugar(false); 
                this.dispose();
                 
            }
           
        } else {
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbHoraEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHoraEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHoraEntradaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (TablaUtil.isSeleccioFila(tblHorario)) {
            horario = getHorarioFila();
            

            int opc = new MiJoptionPane().confiramacionMensajeEliminar(this, Constantes.TXT_HORARIO, horario.getEntrada() + " " + horario.getSalida());
            if (opc == JOptionPane.YES_OPTION) {
                new HorarioDaoImp().deleteHorario(horario);
                new MiJoptionPane().mensajeInformacionAtualizacionOK(null);
                modeloHorario.removeElement(horario);
                setEliminado(true);
                //  this.dispose();
                setEnableBotonNuevo(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Horario de la tabla");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        setModificar(false); // entra a nuevo
        setEnabledComponentes(true);
        cmbHoraEntrada.requestFocus(true);

        setEnableBotonNuevo(false);

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarComponentes();
        setEnableBotonEditar(true);
        setEnabledComponentes(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (TablaUtil.isSeleccioFila(tblHorario)) {
            // selecciono una fila
            setModificar(true);
            setEnabledComponentes(true);
            horario = getHorarioFila();
            setEnableBotonEditar(false);
            setDatos();

        } else {
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(GUIHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIHorario dialog = new GUIHorario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbHoraEntrada;
    private javax.swing.JComboBox cmbHoraSalida;
    private javax.swing.JComboBox cmbMinutoEntrada;
    private javax.swing.JComboBox cmbMinutoSalida;
    private javax.swing.JComboBox cmbMomento;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEntrada;
    private javax.swing.JLabel lblHs;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblMomento;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JTable tblHorario;
    // End of variables declaration//GEN-END:variables

    /**
     * Carga el combobox Momento con sus datos.
     */
    public void setDatosCmbMomento() {
        cmbMomento.removeAllItems();
        cmbMomento.addItem("Seleccione");
        cmbMomento.addItem(Constantes.HORARIO_TURNO_MAÑANA);
        cmbMomento.addItem(Constantes.HORARIO_TURNO_TARDE);
        cmbMomento.addItem(Constantes.HORARIO_TURNO_NOCHE);


    }

    private boolean isCompletoDatosObligarios() {
        boolean b = false;

        boolean bHoraEntrada, bMinEntrada, bHoraSalida, bMinSalida, bMomento;
        bHoraEntrada = cmbHoraEntrada.getSelectedIndex() == 0;
        bMinEntrada = cmbMinutoEntrada.getSelectedIndex() == 0;

        bHoraSalida = cmbHoraSalida.getSelectedIndex() == 0;
        bMinSalida = cmbMinutoSalida.getSelectedIndex() == 0;
        bMomento = cmbMomento.getSelectedIndex() == 0;

        if (!bHoraEntrada && !bHoraSalida && !bMinEntrada && !bMinSalida && !bMomento) {
            b = true;
        } else {
            if (bHoraEntrada) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblHs.getText().concat(lblEntrada.getText()));
            } else if (bMinEntrada) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblMin.getText().concat(lblEntrada.getText()));
            } else if (bHoraSalida) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblHs.getText().concat(lblSalida.getText()));
            } else if (bMinSalida) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblMin.getText().concat(lblSalida.getText()));
            } else if (bMomento) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblMomento.getText());
            }
        }

        return b;

    }

    private void getDatos() {
        int hora, min;

        hora = Integer.valueOf(cmbHoraEntrada.getSelectedItem().toString());
        min = Integer.valueOf(cmbMinutoEntrada.getSelectedItem().toString());
        Date horaEntrada = FechaUtil.getHoraenDATE(hora, min, 0);
        hora = Integer.valueOf(cmbHoraSalida.getSelectedItem().toString());
        min = Integer.valueOf(cmbMinutoSalida.getSelectedItem().toString());
        Date horaSalida = FechaUtil.getHoraenDATE(hora, min, 0);

        String momento = (String) cmbMomento.getSelectedItem();

        horario.setEntrada(horaEntrada);
        horario.setSalida(horaSalida);
        horario.setEtihorario((byte) cmbMomento.getSelectedIndex());

    }

    public void setAgregado(boolean agregado) {
        this.agregado = agregado;
    }

    public boolean isAgregado() {
        return agregado;
    }

    
    public void inicializarTabla() {
        modeloHorario = new ModeloHorario();
        sorter = new TableRowSorter(modeloHorario);
        tblHorario.setModel(modeloHorario);
        TablaUtil.ocultarIdTabla(tblHorario);
    }

    public Horario getHorarioFila() {
        Horario horario = new Horario();
        numeroSeleccion = sorter.convertRowIndexToModel(tblHorario.getSelectedRow());

        horario = modeloHorario.getHorario(numeroSeleccion);
        System.err.println("horario elegido " + horario.toString());
        return horario;

    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    private void limpiarComponentes() {
        cmbHoraEntrada.setSelectedIndex(0);
        cmbHoraSalida.setSelectedIndex(0);
        cmbMinutoEntrada.setSelectedIndex(0);
        cmbMinutoSalida.setSelectedIndex(0);
        cmbMomento.setSelectedIndex(0);
    }

    public void setEnabledComponentes(boolean b) {

        // los datos ingresado por el usuario
        cmbHoraEntrada.setEnabled(b);
        cmbMinutoEntrada.setEnabled(b);
        cmbHoraSalida.setEnabled(b);
        cmbMinutoSalida.setEnabled(b);
        cmbMomento.setEnabled(b);
        // los botones


    }

    public void setEnableBotonNuevo(boolean b) {
        btnNuevo.setEnabled(b);
        btnEditar.setEnabled(b);
        btnEliminar.setEnabled(b);

        btnGuardar.setEnabled(!b);

        btnCancelar.setEnabled(!b);
        btnSalir.setEnabled(true);
        
    }

    public void setEnableBotonEditar(boolean b) {
        btnNuevo.setEnabled(b);
        btnEditar.setEnabled(b);
        btnEliminar.setEnabled(!b);

        btnGuardar.setEnabled(!b);

        btnCancelar.setEnabled(!b);
        btnSalir.setEnabled(true);
        
    }

    private void setDatos() {
        cmbHoraEntrada.setSelectedItem(FechaUtil.getHH(horario.getEntrada()));
        cmbMinutoEntrada.setSelectedItem(FechaUtil.getMM(horario.getEntrada()));
        cmbHoraSalida.setSelectedItem(FechaUtil.getHH(horario.getSalida()));
        cmbMinutoSalida.setSelectedItem(FechaUtil.getMM(horario.getSalida()));
        cmbMomento.setSelectedItem(FechaUtil.getMomentoDelDia(horario.getEtihorario()));
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public Horario getHorario() {
        return horario;
    }
    
    
    
    
    private class CargaTabla extends Thread{
        
        @Override
        public void  run(){
            inicializarTabla();
        }
        
        
        
        
    }

    public boolean isLlamadoDesdeOtroLugar() {
        return llamadoDesdeOtroLugar;
    }

    public void setLlamadoDesdeOtroLugar(boolean llamadoDesdeOtroLugar) {
        this.llamadoDesdeOtroLugar = llamadoDesdeOtroLugar;
    }
    
    
    
}
