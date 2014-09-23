/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.vista.diatrabajo;

import co.tecnomati.java.asistenciavideotel.cons.Constantes;
import co.tecnomati.java.asistenciavideotel.dominio.Diatrabajo;
import co.tecnomati.java.asistenciavideotel.dominio.Empleado;
import co.tecnomati.java.asistenciavideotel.dominio.Horario;
import co.tecnomati.java.asistenciavideotel.dominio.Turno;
import co.tecnomati.java.asistenciavideotel.dominio.dao.TurnoDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.DiaTrabajoDaoImp;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.HorarioDaoImp;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.TurnoDaoImp;
import co.tecnomati.java.asistenciavideotel.util.FechaUtil;
import co.tecnomati.java.asistenciavideotel.util.MiJoptionPane;
import co.tecnomati.java.asistenciavideotel.util.TablaUtil;
import co.tecnomati.java.asistenciavideotel.util.modeloTabla.ModeloTurno;
import co.tecnomati.java.asistenciavideotel.vista.horario.GUIHorario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author joel
 */
public class GUIDiaTrabajo extends javax.swing.JDialog {

    String paqueteImagen = "/co/tecnomati/java/asistenciavideotel/imagen/";
    Turno turno = null;
    boolean agregado = false; // este es una variable que se pone en verdadero si se guardo con exito los datos 
    private boolean modificar = false;
    boolean eliminado = false;
    javax.swing.ImageIcon iconoGuardar = new javax.swing.ImageIcon(getClass().getResource(paqueteImagen + "Guardar.jpg"));
    javax.swing.ImageIcon iconoModificar = new javax.swing.ImageIcon(getClass().getResource(paqueteImagen + "Modificar.png"));
    // empleado al que pertence el dia de trabajo.
    Empleado empleado;
    int numeroSeleccion;
    ModeloTurno modeloTurno;
    private TableRowSorter sorter;

    public GUIDiaTrabajo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setEnabledVariosDiasTrabajo(false);
        setEnableBotonEditar(true);
        setDatosCmbHorario();

        this.setLocationRelativeTo(this);
        this.setVisible(true);
    }

    public GUIDiaTrabajo(java.awt.Frame parent, boolean modal, Empleado empleado) {
        super(parent, modal);
        initComponents();
//        setEnabledVariosDiasTrabajo(false);
        setDatosCmbHorario();
        limpiarComponentes();
        setEnableBotonEditar(true);
        setEnabledComponentes(false);

        this.empleado = empleado;
        lblNombreEmpleado.setText(empleado.getNombre() + " " + empleado.getApellido());
      //  inicializarTabla();
        new CargaTabla().start();
        
        
        this.setLocationRelativeTo(this);
        this.setVisible(true);
    }

    public GUIDiaTrabajo(java.awt.Frame parent, boolean modal, Turno turno) {

        super(parent, modal);
        initComponents();
        this.turno = turno;
        // se indica que se utiliza este formulario para modificar datos
        modificar = true;
        this.setTitle(Constantes.TITLE_EDITAR_TURNO);
        setDatos(turno);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblDia = new javax.swing.JLabel();
        cmbDia = new javax.swing.JComboBox();
        chkVariosDias = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        chkLunes = new javax.swing.JCheckBox();
        chkMartes = new javax.swing.JCheckBox();
        chkMiercoles = new javax.swing.JCheckBox();
        chkViernes = new javax.swing.JCheckBox();
        chkDomingo = new javax.swing.JCheckBox();
        chkSabado = new javax.swing.JCheckBox();
        chkJueves = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblToleranciaEntrada = new javax.swing.JLabel();
        cmbToleranciaEntrada = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        lblToleranciaSalida = new javax.swing.JLabel();
        cmbToleranciaSalida = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        cmbHorario = new javax.swing.JComboBox();
        btnNuevoHorario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiaTrabajo = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNombreEmpleado = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Turno"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dia de Trabajo"));

        lblDia.setText("Dia");

        cmbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione", "DOMINGO", "LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO", " ", " " }));
        cmbDia.setEnabled(false);

        chkVariosDias.setText("Aplicar Horario a varios Días");
        chkVariosDias.setEnabled(false);
        chkVariosDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVariosDiasActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias Aplicable"));

        chkLunes.setText("Lunes");
        chkLunes.setEnabled(false);

        chkMartes.setText("Martes");
        chkMartes.setEnabled(false);

        chkMiercoles.setText("Miercoles");
        chkMiercoles.setEnabled(false);

        chkViernes.setText("Viernes");
        chkViernes.setEnabled(false);

        chkDomingo.setText("Domingo");
        chkDomingo.setEnabled(false);

        chkSabado.setText("Sabado");
        chkSabado.setEnabled(false);

        chkJueves.setText("Jueves");
        chkJueves.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(chkLunes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkMartes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkMiercoles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkJueves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkViernes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkSabado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkDomingo)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkLunes)
                    .addComponent(chkMartes)
                    .addComponent(chkMiercoles)
                    .addComponent(chkViernes)
                    .addComponent(chkDomingo)
                    .addComponent(chkSabado)
                    .addComponent(chkJueves))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(chkVariosDias)
                        .addGap(375, 375, 375))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDia)
                    .addComponent(cmbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkVariosDias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Horario"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tolerancias De Las Tardanzas"));

        lblToleranciaEntrada.setText("Limite de Tolerancia Para la ENTRADA");

        cmbToleranciaEntrada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));
        cmbToleranciaEntrada.setEnabled(false);

        jLabel15.setText("min");

        lblToleranciaSalida.setText("Limite de Tolerancia Para la SALIDA");

        cmbToleranciaSalida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));
        cmbToleranciaSalida.setEnabled(false);

        jLabel17.setText("min");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblToleranciaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblToleranciaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmbToleranciaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(cmbToleranciaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblToleranciaEntrada)
                    .addComponent(cmbToleranciaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblToleranciaSalida)
                    .addComponent(cmbToleranciaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        lblHorario.setText("Horario");

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cmbHorario.setEnabled(false);
        cmbHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbHorarioActionPerformed(evt);
            }
        });

        btnNuevoHorario.setText("Nuevo Horario");
        btnNuevoHorario.setEnabled(false);
        btnNuevoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoHorarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblHorario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevoHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHorario)
                    .addComponent(btnNuevoHorario))
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblDiaTrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
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
                "id", "Dia", "Entrada", "Salida", "Title 5", "Tolerancia Entrada", "Tolerancia Salida", "Momento"
            }
        ));
        jScrollPane1.setViewportView(tblDiaTrabajo);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(76, 76, 76)
                .addComponent(btnNuevo)
                .addGap(58, 58, 58)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addGap(397, 397, 397))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jLabel1.setText("Empleado");

        lblNombreEmpleado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(45, 45, 45)
                        .addComponent(btnSalir)
                        .addGap(108, 108, 108))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbHorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbHorarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        limpiarComponentes();
        setEnableBotonEditar(true);
        setEnabledComponentes(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //  int opc = JOptionPane.showConfirmDialog(null,"Esta seguro de Eliminar el Concepto: "+turno.getDescripcion(), "ELIMINAR CONCEPTO", JOptionPane.YES_NO_OPTION);
        int opc = new MiJoptionPane().confiramacionMensajeEliminar(this, Constantes.TXT_TURNO, turno.getTid() + "");
        if (opc == JOptionPane.YES_OPTION) {
            new TurnoDaoImp().deleteTurno(turno);
            new MiJoptionPane().mensajeInformacionAtualizacionOK(null);
            setEliminado(true);
            this.dispose();

            // configuarar botones luego de eliminar
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!modificar) {
            //si se ingresa un nueva persona
            turno = new Turno();
            System.err.println("entro a nuevo");
        }

        if (isCompletoDatosObligarios()) {
            // si se ingreso los datos del horario correctamente
            getDatos();
            if (modificar) {
                System.err.println("modificar");
                //MODIFicar
                new TurnoDaoImp().upDateTurno(turno);
                MiJoptionPane.mensajeInformacionAtualizacionOK(this);
            } else {
                System.err.println("nuevo");
                //NUEVO
                ArrayList<Integer> listas_dias = getDiasTrabajo();
                for (Integer index_dia : listas_dias) {
                    //dia de trabajo.
                    getDatos();

//                    String dia = new FechaUtil().getDiaDeLaSemana_String(index_dia);
                    System.err.println("dia elegido ");
                    
                    Diatrabajo dt = new Diatrabajo();
                    // agrego o actualizo dia de Trabajo
                    if (new DiaTrabajoDaoImp().getDiatrabajo_XDia(index_dia, empleado.getEid()) == null) {
                        // creo el dia de trabajo
                        dt.setDid(index_dia);
                        dt.setEmpleado(empleado);
                        dt.setNturno((byte) 1);
                        new DiaTrabajoDaoImp().addDiatrabajo(dt);
                        System.err.println("se creo un dia de trabjo" + dt.getDtid());
                    } else {
                        // hay que arreglar esto
                        dt= new DiaTrabajoDaoImp().getDiatrabajo_XDia(index_dia, empleado.getEid());
                        dt.setNturno((byte)(dt.getNturno() + 1));
                        new DiaTrabajoDaoImp().upDateDiatrabajo(dt);

                    }

                    turno.setDiatrabajo(dt);
                    new TurnoDaoImp().addTurno(turno);
                   
                }
                 new CargaTabla().start();
                 MiJoptionPane.mensajeInformacionAltaOK(this);
//                    modeloTurno.addElement(turno);

            }
            setAgregado(true);

//            modeloHorario.aElement(horario);
            limpiarComponentes();
            setEnabledComponentes(false);
            setEnableBotonEditar(true);
//            if (isLlamadoDesdeOtroLugar()) {
//                setLlamadoDesdeOtroLugar(false); 
//                this.dispose();
//                 
//            }

        } else {
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoHorarioActionPerformed
        GUIHorario guiHorario = new GUIHorario(null, true, true);
        if (guiHorario.isAgregado()) {
            // se agrego un nuevo horario entonces se debe

            // actualizar el cmbHorario
            setDatosCmbHorario();
            // hacer qe el cmbHorario apunte al item correspondiente al hoarario agregado
            Horario h = guiHorario.getHorario();
            cmbHorario.setSelectedItem(getItemCmb(h));
        } else {
        }

    }//GEN-LAST:event_btnNuevoHorarioActionPerformed

    private void chkVariosDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVariosDiasActionPerformed
        if (chkVariosDias.isSelected()) {
            setEnabledVariosDiasTrabajo(true);
        } else {
            setEnabledVariosDiasTrabajo(false);

        }

    }//GEN-LAST:event_chkVariosDiasActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (TablaUtil.isSeleccioFila(tblDiaTrabajo)) {
            // selecciono una fila
            setModificar(true);
            setEnabledComponentes(true);
            //        horario = getHorarioFila();
            setEnableBotonEditar(false);
            //        setDatos();

        } else {
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        setModificar(false); // entra a nuevo
        setEnabledComponentes(true);
        cmbHorario.requestFocus(true);

        setEnableBotonNuevo(false);    }//GEN-LAST:event_btnNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(GUIDiaTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIDiaTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIDiaTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIDiaTrabajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIDiaTrabajo dialog = new GUIDiaTrabajo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnNuevoHorario;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkDomingo;
    private javax.swing.JCheckBox chkJueves;
    private javax.swing.JCheckBox chkLunes;
    private javax.swing.JCheckBox chkMartes;
    private javax.swing.JCheckBox chkMiercoles;
    private javax.swing.JCheckBox chkSabado;
    private javax.swing.JCheckBox chkVariosDias;
    private javax.swing.JCheckBox chkViernes;
    private javax.swing.JComboBox cmbDia;
    private javax.swing.JComboBox cmbHorario;
    private javax.swing.JComboBox cmbToleranciaEntrada;
    private javax.swing.JComboBox cmbToleranciaSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblToleranciaEntrada;
    private javax.swing.JLabel lblToleranciaSalida;
    private javax.swing.JTable tblDiaTrabajo;
    // End of variables declaration//GEN-END:variables

    private void setDatos(Turno turno) {
        //  corregir esto!!!!!!!!!!!
        cmbHorario.setSelectedItem(turno.getHorario());
        cmbToleranciaEntrada.setSelectedItem(turno.getEtolerancia());
        cmbToleranciaSalida.setSelectedItem(turno.getStolerancia());
        cmbDia.setSelectedIndex(turno.getDiatrabajo().getDid());
    }

    /**
     * carga los datos a un objeto turno excepto el el dia de trabajo que se
     * carga manualmente donde se utilice este metodo
     */
    public void getDatos() {
        turno.setHorario(getHorario(cmbHorario.getSelectedIndex()));
        int minTolEntr = Integer.valueOf(cmbToleranciaEntrada.getSelectedItem().toString());
        int minTolSal = Integer.valueOf(cmbToleranciaSalida.getSelectedItem().toString());
        Date dTolEntrada = FechaUtil.getHoraenDATE(0, minTolEntr, 0);
        Date dTolSal = FechaUtil.getHoraenDATE(0, minTolSal, 0);
        turno.setEtolerancia(dTolEntrada);
        turno.setStolerancia(dTolSal);


    }

    public boolean isAgregado() {
        return agregado;
    }

    public void setAgregado(boolean agregado) {
        this.agregado = agregado;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    private void setEnabledVariosDiasTrabajo(boolean b) {
        chkLunes.setEnabled(b);
        chkMartes.setEnabled(b);
        chkMiercoles.setEnabled(b);
        chkJueves.setEnabled(b);
        chkViernes.setEnabled(b);
        chkSabado.setEnabled(b);
        chkDomingo.setEnabled(b);
        if (!chkVariosDias.isSelected()) {
            chkDomingo.setSelected(false);
            chkLunes.setSelected(false);
            chkMartes.setSelected(false);
            chkMiercoles.setSelected(false);
            chkJueves.setSelected(false);
            chkViernes.setSelected(false);
            chkSabado.setSelected(false);

            cmbDia.setEnabled(true);
        } else {
            cmbDia.setSelectedIndex(0);
            cmbDia.setEnabled(false);
        }
    }

    /**
     * Carga el cmbbox con Horarios
     */
    public void setDatosCmbHorario() {
        cmbHorario.removeAllItems();
        cmbHorario.addItem("Seleccione");

        if (new HorarioDaoImp().listarHorarioOrdenadoXMomento().isEmpty()) {
            // si la lista de tipodecomprobante por categoria esta vacia
            cmbHorario.setEditable(false);
        } else {

            for (Horario o : new HorarioDaoImp().listarHorarioOrdenadoXMomento()) {

                cmbHorario.addItem(getItemCmb(o));
            }
        }
    }

    /**
     *
     * @param o
     * @return Devuelve el horario en String en formato HoraInicio a Horafin EJ:
     * 10:00 a 14:00
     */
    private String getItemCmb(Horario o) {
        String item = "";

        String entrada = FechaUtil.getHora_HHMM(o.getEntrada());
        String salida = FechaUtil.getHora_HHMM(o.getSalida());
        item = entrada + "   a    " + salida;
        return item;
    }

    /**
     *
     * @param indexCmb indice del cmb elegido.
     * @return un Objeto Horario de acuerdo al horario elegido en el
     * comboboxHorario
     */
    private Horario getHorario(int indexCmb) {
        return new HorarioDaoImp().listarHorarioOrdenadoXMomento().get(indexCmb - 1);

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

    private void limpiarComponentes() {
        cmbHorario.setSelectedIndex(0);
        cmbDia.setSelectedIndex(0);
        cmbToleranciaEntrada.setSelectedIndex(0);
        cmbToleranciaSalida.setSelectedIndex(0);

        //chk
        chkDomingo.setSelected(false);
        chkLunes.setSelected(false);
        chkMartes.setSelected(false);
        chkMiercoles.setSelected(false);
        chkJueves.setSelected(false);
        chkViernes.setSelected(false);
        chkSabado.setSelected(false);

        chkVariosDias.setSelected(false);

    }

    public void setEnabledComponentes(boolean b) {

        // los datos ingresado por el usuario
        cmbHorario.setEnabled(b);
        cmbDia.setEnabled(b);
        cmbToleranciaEntrada.setEnabled(b);
        cmbToleranciaSalida.setEnabled(b);

        // chk
        chkLunes.setEnabled(b);
        chkMartes.setEnabled(b);
        chkMiercoles.setEnabled(b);
        chkJueves.setEnabled(b);
        chkViernes.setEnabled(b);
        chkSabado.setEnabled(b);
        chkDomingo.setEnabled(b);

        chkVariosDias.setEnabled(b);

        btnNuevoHorario.setEnabled(b);
    }

    public void inicializarTabla() {
        modeloTurno = new ModeloTurno(empleado.getEid());
        sorter = new TableRowSorter(modeloTurno);
        tblDiaTrabajo.setModel(modeloTurno);
        TablaUtil.ocultarIdTabla(tblDiaTrabajo);
    }

    private boolean isCompletoDatosObligarios() {
        boolean b = false;

        boolean bHorario, bToleranciaEntrada, bToleranciaSalida, bDiaTrabajo;

        bHorario = cmbHorario.getSelectedIndex() == 0;
        bToleranciaEntrada = cmbToleranciaEntrada.getSelectedIndex() == 0;
        bToleranciaSalida = cmbToleranciaSalida.getSelectedIndex() == 0;
        bDiaTrabajo = isCompletoDiaTrabajo();

        if (!bHorario && !bToleranciaEntrada && !bToleranciaSalida && bDiaTrabajo) {
            b = true;
        } else {
            if (bHorario) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblHorario.getText());
            } else if (bToleranciaEntrada) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblToleranciaEntrada.getText());
            } else if (bToleranciaSalida) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblToleranciaSalida.getText());
            } else if (!bDiaTrabajo) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblDia.getText().concat(" Trabajo"));
            }
        }

        return b;
    }

    /**
     *
     * @return true si se cargo informacion correcta en el panel Dia de Trabajo
     */
    private ArrayList<Integer> getDiasTrabajo() {

        ArrayList<Integer> listas_dias = new ArrayList();

        if (chkVariosDias.isSelected()) {
            // obtengo la list

            if (chkLunes.isSelected()) {
                listas_dias.add(Calendar.MONDAY);
            }
            if (chkMartes.isSelected()) {
                listas_dias.add(Calendar.TUESDAY);
            }
            if (chkMiercoles.isSelected()) {
                listas_dias.add(Calendar.WEDNESDAY);
            }
            if (chkJueves.isSelected()) {
                listas_dias.add(Calendar.THURSDAY);
            }
            if (chkViernes.isSelected()) {
                listas_dias.add(Calendar.FRIDAY);
            }
            if (chkSabado.isSelected()) {
                listas_dias.add(Calendar.SATURDAY);

            }
             
        } else {
            // obtengo el dia del combo
            int indexDia = cmbDia.getSelectedIndex();
            listas_dias.add(indexDia);

        }


        return listas_dias;
    }

    /**
     *
     * @return true si se cargo un o varios dias de trabajo. false en otro caso
     */
    public boolean isCompletoDiaTrabajo() {
        boolean b = false;

        if (chkVariosDias.isSelected()) {
            // tiene q haber seleccionado por lo menos un chk de dias
            if (chkLunes.isSelected() || chkMartes.isSelected() || chkMiercoles.isSelected() || chkJueves.isSelected() || chkViernes.isSelected() || chkSabado.isSelected() || chkDomingo.isSelected()) {
                b = true;
            }

        } else {
            if (cmbDia.getSelectedIndex() != 0) {
                // si se selecciono un elemento del combo
                b = true;
            }
        }

        return b;
    }
    
    
      private class CargaTabla extends Thread{
        
        @Override
        public void  run(){
            inicializarTabla();
        }
      }   
}
