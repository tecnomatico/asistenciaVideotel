/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.vista.asistencia;

import co.tecnomati.java.asistenciavideotel.cons.Constantes;
import co.tecnomati.java.asistenciavideotel.dominio.Empleado;
import co.tecnomati.java.asistenciavideotel.dominio.Marcacion;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.EmpleadoDaoImp;
import co.tecnomati.java.asistenciavideotel.util.Exporter;
import co.tecnomati.java.asistenciavideotel.util.FechaUtil;
import co.tecnomati.java.asistenciavideotel.util.FiltroUtil;
import co.tecnomati.java.asistenciavideotel.util.MiJoptionPane;
import co.tecnomati.java.asistenciavideotel.util.TablaUtil;
import co.tecnomati.java.asistenciavideotel.util.modeloTabla.ModeloEmpleado;
import co.tecnomati.java.asistenciavideotel.util.modeloTabla.ModeloMarcacion;
import co.tecnomati.java.asistenciavideotel.vista.empleado.GUIEmpleado;
import co.tecnomati.java.asistenciavideotel.vista.empleado.GUIGestorEmpleado;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author joel
 */
public class GUIGestorAsistencia extends javax.swing.JDialog {

    int numeroSeleccion;
    Marcacion marcacion;
    ModeloMarcacion modeloMarcacion;
    boolean agregado = false;
    private TableRowSorter sorter;
    //
    boolean paraSeleccionar;
    // 
    Empleado empleado;

    /**
     * Creates new form GUIGestorAsistencia
     */
    public GUIGestorAsistencia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        rdbSemana.setSelected(true);
        setFechaEstaSemana();
        this.setTitle(Constantes.TITLE_GESTOR_ASISTENCIA);

////        inicializarTabla();
        setEnabledBusqueda(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public GUIGestorAsistencia(java.awt.Frame parent, boolean modal, boolean paraSeleccionar) {
        super(parent, modal);
        initComponents();
        this.paraSeleccionar = paraSeleccionar;
        setFechaEstaSemana();
        rdbSemana.setSelected(true);
        this.setTitle(Constantes.TITLE_GESTOR_ASISTENCIA);
         
////        inicializarTabla();
        setEnabledBusqueda(false);
        this.setLocationRelativeTo(null);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblBusqueda = new javax.swing.JLabel();
        cmbBusqueda = new javax.swing.JComboBox();
        txtBusqueda = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rdbHoy = new javax.swing.JRadioButton();
        rdbMes = new javax.swing.JRadioButton();
        rdbSemana = new javax.swing.JRadioButton();
        rdbEntreFechas = new javax.swing.JRadioButton();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAsistencia = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExportarExcel = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscarEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblBusqueda.setText("Busqueda");

        cmbBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODO LOS EMPLEADOS", "DNI" }));
        cmbBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBusquedaActionPerformed(evt);
            }
        });

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        buttonGroup1.add(rdbHoy);
        rdbHoy.setText("Hoy");
        rdbHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbHoyActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbMes);
        rdbMes.setText("Este Mes");
        rdbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbMesActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbSemana);
        rdbSemana.setText("Esta Semana");
        rdbSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbSemanaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbEntreFechas);
        rdbEntreFechas.setText("Entre las Fechas");
        rdbEntreFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEntreFechasActionPerformed(evt);
            }
        });

        fechaInicio.setBackground(new java.awt.Color(255, 255, 255));
        fechaInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fechaInicio.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        fechaInicio.setMaxSelectableDate(new Date());

        fechaFin.setBackground(new java.awt.Color(255, 255, 255));
        fechaFin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fechaFin.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        fechaFin.setMaxSelectableDate(new Date());

        jLabel1.setText("Y");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rdbHoy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbSemana)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdbEntreFechas)
                .addGap(22, 22, 22)
                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdbHoy)
                                    .addComponent(rdbMes)
                                    .addComponent(rdbSemana)
                                    .addComponent(rdbEntreFechas))
                                .addGap(3, 3, 3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblAsistencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Empleado", "Fecha", "Momento", "Entrada", "Salida", "TE", "TS"
            }
        ));
        jScrollPane1.setViewportView(tblAsistencia);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExportarExcel.setText("Exportar a Excel");
        btnExportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarExcelActionPerformed(evt);
            }
        });

        btnCancelar.setText("Atras");

        btnBuscarEmpleado.setText("Buscar Empleado");
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExportarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusqueda)
                    .addComponent(cmbBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbHoyActionPerformed
        if (rdbHoy.isSelected()) {
            setFechaHoy();

        }
    }//GEN-LAST:event_rdbHoyActionPerformed

    private void rdbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMesActionPerformed
        if (rdbMes.isSelected()) {
            setFechaEsteMes();

        }
    }//GEN-LAST:event_rdbMesActionPerformed

    private void rdbEntreFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEntreFechasActionPerformed
        if (rdbEntreFechas.isSelected()) {
            setEnabledFechas(true);

        }
    }//GEN-LAST:event_rdbEntreFechasActionPerformed

    private void rdbSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbSemanaActionPerformed
        if (rdbSemana.isSelected()) {
            setFechaEstaSemana();

        }
    }//GEN-LAST:event_rdbSemanaActionPerformed

    private void cmbBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBusquedaActionPerformed
        if (cmbBusqueda.getSelectedIndex() == 1) {
            // busqueda de marcacion por legajo

            setEnabledBusqueda(true);
        } else {
            // todos los empleados
            empleado = null;
            setEnabledBusqueda(false);
        }


    }//GEN-LAST:event_cmbBusquedaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblAsistencia.getSelectedRow() != -1) {
            numeroSeleccion = sorter.convertRowIndexToModel(tblAsistencia.getSelectedRow());
            marcacion = modeloMarcacion.getMarcacion(numeroSeleccion);
            GUIAsistencia guiAsistencia = new GUIAsistencia(null, agregado, marcacion);
            // actulizar la tabla con los datos modificados
            if (guiAsistencia.isAgregado() || guiAsistencia.isEliminado()) {
                guiAsistencia.dispose();
                inicializarTabla();
            }

        } else {
            new MiJoptionPane().showDialogSeleccioneFila(this);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (!txtBusqueda.getText().trim().isEmpty()) {
            int dni = Integer.valueOf(txtBusqueda.getText().trim());
            empleado = new EmpleadoDaoImp().getEmpleado_XDni(dni);
        }

        if (empleado != null) {
            inicializarTabla();
        } else {
            MiJoptionPane.mensajeError(this, MiJoptionPane.IDENTIFICACION_ERRONEA);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        FiltroUtil.permitirSoloNumero(evt, txtBusqueda, 8);
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        GUIGestorEmpleado guiEmpleado = new GUIGestorEmpleado(null, true, true);
        if (guiEmpleado.isAgregado()) {
            // se agrego un nuevo horario entonces se debe

            // actualizar el cmbHorario
            txtBusqueda.setText(String.valueOf(guiEmpleado.getEmpleado().getDni()));
            // hacer qe el cmbHorario apunte al item correspondiente al hoarario agregado
           setFechaEstaSemana();
        } else {
        }
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void btnExportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarExcelActionPerformed
        if (tblAsistencia.getRowCount()==0) {
            MiJoptionPane.mensajeAdvertencia(this, "NO HAY DATOS EN LA TABLA PARA EXPORTAR");
            txtBusqueda.grabFocus();
            return;
        }
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar Archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null)== JFileChooser.APPROVE_OPTION) {
            List<JTable> tb = new ArrayList<>();
            List<String> nom = new ArrayList<>();
            tb.add(tblAsistencia);
            nom.add( "Planilla de Asistencia");
            String file = chooser.getSelectedFile().toString().concat(".xls");
            try{
                Exporter exporter = new Exporter(new File(file), tb, nom);
                if (exporter.export()) {
                    MiJoptionPane.mensajeInformacionAltaOK(this);
                }
            }catch(Exception e ){
                MiJoptionPane.mensajeError(this, "Error al Exportar los Datos");
            }
        }
               
    }//GEN-LAST:event_btnExportarExcelActionPerformed

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
            java.util.logging.Logger.getLogger(GUIGestorAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIGestorAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIGestorAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIGestorAsistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIGestorAsistencia dialog = new GUIGestorAsistencia(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExportarExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbBusqueda;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JRadioButton rdbEntreFechas;
    private javax.swing.JRadioButton rdbHoy;
    private javax.swing.JRadioButton rdbMes;
    private javax.swing.JRadioButton rdbSemana;
    private javax.swing.JTable tblAsistencia;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables

    private void setEnabledFechas(boolean b) {
        fechaInicio.setEnabled(b);
        fechaFin.setEnabled(b);

    }

    private void setEnabledBusqueda(boolean b) {
        txtBusqueda.setEditable(b);
        //obtnego el foco

        btnBuscarEmpleado.setEnabled(b);
        if (b == true) {
            txtBusqueda.requestFocus();
            //cambio el color
            txtBusqueda.setBackground(Color.white);
            txtBusqueda.requestFocus();
        } else {
            //borro el contendido de la caja de texto
            txtBusqueda.setText("");
            txtBusqueda.setBackground(Color.DARK_GRAY);

        }



    }

    private void inicializarTabla() {
        modeloMarcacion = new ModeloMarcacion(empleado, fechaInicio.getDate(), fechaFin.getDate());
        sorter = new TableRowSorter(modeloMarcacion);
        tblAsistencia.setModel(modeloMarcacion);
        TablaUtil.ocultarIdTabla(tblAsistencia);
    }

    /**
     * coloca la fecha de hoy en los datechooser
     */
    private void setFechaHoy() {
        fechaInicio.setDate(new Date());
        fechaFin.setDate(new Date());
        setEnabledFechas(false);
    }

    /**
     * coloca la fecha de esta semana
     */
    private void setFechaEstaSemana() {
        fechaInicio.setDate(FechaUtil.getPrimerDiaSemana(new Date()));
        fechaFin.setDate(new Date());
        
        setEnabledFechas(false);
    }

    private void setFechaEsteMes() {
        fechaInicio.setDate(new Date(new Date().getYear(), new Date().getMonth(), 1, 0, 0, 0));
        fechaFin.setDate(new Date());
        setEnabledFechas(false);
    }
}
