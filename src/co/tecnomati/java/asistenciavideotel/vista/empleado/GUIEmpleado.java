/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.vista.empleado;

import co.tecnomati.java.asistenciavideotel.cons.Constantes;
import co.tecnomati.java.asistenciavideotel.dominio.Empleado;
import co.tecnomati.java.asistenciavideotel.dominio.Sector;
import co.tecnomati.java.asistenciavideotel.dominio.dao.EmpleadoDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.EmpleadoDaoImp;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.SectorDaoImp;
import co.tecnomati.java.asistenciavideotel.util.FicheroUtil;
import co.tecnomati.java.asistenciavideotel.util.FiltroUtil;
import co.tecnomati.java.asistenciavideotel.util.MiJoptionPane;
import co.tecnomati.java.asistenciavideotel.vista.diatrabajo.GUIDiaTrabajo;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

// falta las fotos 
/**
 *
 * @author joel
 */
public class GUIEmpleado extends javax.swing.JDialog {

    String paqueteImagen = "/co/tecnomati/java/asistenciavideotel/imagen/";
    Empleado empleado = null;
    boolean agregado = false; // este es una variable que se pone en verdadero si se guardo con exito los datos 
    private boolean modificar = false;
    boolean eliminado = false;
    javax.swing.ImageIcon iconoGuardar = new javax.swing.ImageIcon(getClass().getResource(paqueteImagen + "Guardar.jpg"));
    javax.swing.ImageIcon iconoModificar = new javax.swing.ImageIcon(getClass().getResource(paqueteImagen + "Modificar.png"));
    
    
    // necesarios para la carga de la foto del empleado
    private ImageIcon icono;
    byte[] imgByte;
    private String pathFoto;
    
    private boolean seleccionofoto=false;
     private String nombredelarchivo;

    public GUIEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        btnEliminar.setVisible(false);
        setDatosCmbSector();
        this.setTitle(Constantes.TITLE_EDITAR_EMPLEADO);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public GUIEmpleado(java.awt.Frame parent, boolean modal, Empleado empleado) {

        super(parent, modal);
        initComponents();
        this.empleado = empleado;
        // se indica que se utiliza este formulario para modificar datos
        modificar = true;
        this.setTitle(Constantes.TITLE_EDITAR_SECTOR);
        setDatos(empleado);
        setDatosCmbSector();
        cmbSector.setSelectedItem(empleado.getSector().getDescripcion());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        elegirFichero = new javax.swing.JFileChooser();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblClave = new javax.swing.JLabel();
        txtPasswordAdmin = new javax.swing.JTextField();
        txtPasswordConfirmAdmin = new javax.swing.JTextField();
        lblRepetirClave = new javax.swing.JLabel();
        chkAdministrador = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        lblApellido = new javax.swing.JLabel();
        lblDni = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblConfigurarDiaTrabajo = new javax.swing.JLabel();
        btnHorarios = new javax.swing.JButton();
        lblSector = new javax.swing.JLabel();
        cmbSector = new javax.swing.JComboBox();
        lblFoto = new javax.swing.JLabel();
        btnCargarFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setText("Atras");
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

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cuenta de Adminsitrador"));

        lblClave.setText("Clave");

        txtPasswordAdmin.setEditable(false);

        txtPasswordConfirmAdmin.setEditable(false);

        lblRepetirClave.setText("Repetir Clave");

        chkAdministrador.setText("Administrador");
        chkAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAdministradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRepetirClave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkAdministrador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPasswordAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txtPasswordConfirmAdmin))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(chkAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblClave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPasswordConfirmAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRepetirClave)))
                    .addComponent(txtPasswordAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Personales"));

        lblApellido.setText("Apellido");

        lblDni.setText("DNI");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });

        lblTelefono.setText("Telefono");

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        lblNombre.setText("Nombre");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTelefono)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblApellido)
                            .addComponent(lblNombre)
                            .addComponent(lblDni))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDni)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Interno"));

        lblConfigurarDiaTrabajo.setText("Dias y Hoararios De Trabajo");

        btnHorarios.setText("Ver/Configurar");
        btnHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHorariosActionPerformed(evt);
            }
        });

        lblSector.setText("Sector de la Empresa");

        cmbSector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cmbSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSector)
                    .addComponent(lblConfigurarDiaTrabajo))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbSector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSector)
                    .addComponent(cmbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(lblConfigurarDiaTrabajo))
                .addContainerGap())
        );

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(new javax.swing.border.MatteBorder(null));

        btnCargarFoto.setText("cargar foto");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(btnCargarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCargarFoto)
                        .addGap(39, 39, 39)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        EmpleadoDao empleadoDAO = new EmpleadoDaoImp();
        if (!modificar) {
            //si se ingresa un nueva persona
            empleado = new Empleado();
        }

        if (isCompletoDatosObligarios()&& validarAdministrador()) {
           // si se ingreso los datos del empleado correctamente
            getDatos();
            if (modificar) {
                empleadoDAO.upDateEmpleado(empleado);
                MiJoptionPane.mensajeInformacionAtualizacionOK(this);
            } else {
                empleadoDAO.addEmpleado(empleado);
                MiJoptionPane.mensajeInformacionAltaOK(this);
            }
            setAgregado(true);
            
            this.dispose();
        } else {
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        FiltroUtil.permitirSoloNumero(evt, txtDni, 8);
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        FiltroUtil.permitirTodo(evt, txtApellido, 30);
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        FiltroUtil.permitirTodo(evt, txtTelefono, 30);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        FiltroUtil.permitirTodo(evt, txtTelefono, 20);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void chkAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAdministradorActionPerformed
        if (chkAdministrador.isSelected()) {
            txtPasswordAdmin.setEditable(true);
            txtPasswordConfirmAdmin.setEditable(true);
        } else {
            // 
            txtPasswordAdmin.setText("");
            txtPasswordAdmin.setEditable(false);

            txtPasswordConfirmAdmin.setText("");
            txtPasswordConfirmAdmin.setEditable(false);
        }

    }//GEN-LAST:event_chkAdministradorActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opc = new MiJoptionPane().confiramacionMensajeEliminar(this, Constantes.TXT_EMPLEADO, empleado.getApellido() + " " + empleado.getNombre());
        if (opc == JOptionPane.YES_OPTION) {
            new EmpleadoDaoImp().deleteEmpleado(empleado);
            new MiJoptionPane().mensajeInformacionAtualizacionOK(null);
            setEliminado(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSectorActionPerformed

    private void btnHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHorariosActionPerformed
      GUIDiaTrabajo diaTrabajo =  new GUIDiaTrabajo(null, true,empleado);
    }//GEN-LAST:event_btnHorariosActionPerformed

    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        int resp;// respuesta  si agrego o no una foto el empleado,  
        FileNameExtensionFilter filter=new FileNameExtensionFilter("png", "jpg", "jpeg");
//        FileNameExtensionFilter filter=new FileNameExtensionFilter("png","JPEG file", "jpg", "jpeg");
        elegirFichero.addChoosableFileFilter(filter);
        elegirFichero.setFileFilter(filter);
        resp=elegirFichero.showOpenDialog(this);
        
        if (resp==JFileChooser.APPROVE_OPTION) {
               seleccionofoto= true;
               pathFoto = elegirFichero.getSelectedFile().toString();
               File fichero=elegirFichero.getSelectedFile();
               nombredelarchivo = fichero.getName();
               imgByte = new byte[(int) fichero.length()];
               icono=new ImageIcon(fichero.getPath());
               FicheroUtil.adaptarTamaño(lblFoto, icono.getImage()); 
//               FicheroUtil.guardarFotoenCarpetaDist(lblFoto, imgByte, nombredelarchivo);
               System.err.println("se guardo la foto "+ nombredelarchivo);
        } else if (resp==JFileChooser.CANCEL_OPTION) {
               seleccionofoto = false;
        }
    }//GEN-LAST:event_btnCargarFotoActionPerformed

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
            java.util.logging.Logger.getLogger(GUIEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIEmpleado dialog = new GUIEmpleado(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHorarios;
    private javax.swing.JCheckBox chkAdministrador;
    private javax.swing.JComboBox cmbSector;
    private javax.swing.JFileChooser elegirFichero;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblConfigurarDiaTrabajo;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRepetirClave;
    private javax.swing.JLabel lblSector;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPasswordAdmin;
    private javax.swing.JTextField txtPasswordConfirmAdmin;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void setDatos(Empleado empleado) {
        txtApellido.setText(empleado.getApellido());
        txtNombre.setText(empleado.getNombre());
        txtDni.setText(String.valueOf(empleado.getDni()));
        txtTelefono.setText(empleado.getTelefono());
        txtPasswordAdmin.setText(empleado.getClave());
        txtPasswordConfirmAdmin.setText(empleado.getClave());
        chkAdministrador.setSelected(empleado.getAdministrador());
        cmbSector.setSelectedItem(empleado.getSector().getDescripcion());
    }

    public void getDatos() {
        empleado.setNombre(txtNombre.getText());
        empleado.setApellido(txtApellido.getText());
        empleado.setDni(Integer.valueOf(txtDni.getText()));
        empleado.setTelefono(txtTelefono.getText());
        empleado.setClave(txtPasswordAdmin.getText());  // ver si esta bien esto!!!!!!
        empleado.setAdministrador(chkAdministrador.isSelected());
        empleado.setEstado(true); // true - empleado activo,  false- empleado de baja
        //sector
        empleado.setSector(new SectorDaoImp().getSector(cmbSector.getSelectedItem().toString()));
     
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

    /**
     * 
     * @return Comprueba que se ingresaron los datos obligatorios del empleado.
     * true si se lleno los datos obligatorios
     * false en otro caso.
     */
    private boolean isCompletoDatosObligarios() {
        boolean b = false;
        boolean bapellido, bnombre, bdni,bSector;
        bapellido = txtApellido.getText().trim().isEmpty();
        bnombre = txtNombre.getText().trim().isEmpty();
        bdni = txtDni.getText().trim().isEmpty();
        bSector = cmbSector.getSelectedIndex() == 0;
        if (!bapellido && !bnombre && !bdni && !bSector) {
            b = true;
        } else {
            if (bapellido) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblApellido.getText());
            } else if (bnombre) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblNombre.getText());
            } else if (bdni) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblDni.getText());
            } else if (bSector) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblSector.getText());
            }
        }
        return b;
    }

    
    
    
    /**
     *
     * @return true si no hay problemmas con el ingreso de claves false en otro
     * caso
     */
    public boolean isCompletoDatosAdmin() {
        boolean b = false;
        boolean badmin, bconfiradmin, bClavesAdminEqual;
        // adminisitrador
        badmin = txtPasswordAdmin.getText().trim().isEmpty();
        bconfiradmin = txtPasswordConfirmAdmin.getText().trim().isEmpty();
        // claves iguales.
        bClavesAdminEqual = (txtPasswordAdmin.getText().equals(txtPasswordConfirmAdmin.getText()));

        // si no esta vacio
        if (!(badmin && bconfiradmin)) {
            // si son iguales
            if (bClavesAdminEqual) {
                // todo ok
                b = true;
            } else {
                // claves diferentes
//               JOptionPane.showMessageDialog(null, "NO COINCIDE LAS CLAVES",Constantes.TITLE_APP , JOptionPane.WARNING_MESSAGE);
               MiJoptionPane.mensajeError(this, MiJoptionPane.CLAVES_DISTINTAS);
            }
        } else {
            // indicar donde esta vacio
            if (badmin) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblClave.getText());
            } else if (bconfiradmin) {
                new MiJoptionPane().mensajeErrorCampoVacio(null, lblRepetirClave.getText());
            }
        }
        return b;
    }
    
  /**
   * 
   * @return  retorna true si realizo los pasos correctamentte  para darse de alta como adminsitrador 
   */
    public boolean validarAdministrador(){
        boolean b=false;
        
        if (chkAdministrador.isSelected()) {
            // si es un administrador se debe verfiicar que los datos de claves esten correcto
            b= isCompletoDatosAdmin();
        } else {
            //si no es administrador no se debe validar nada, esta todo correcto.
            b=true;
        }
        
        return b;
    }
    
    
    
    /**
     * Carga el combobox Sector con sus datos.
     */
    public void setDatosCmbSector() {
        cmbSector.removeAllItems();
        cmbSector.addItem("Seleccione");
               
        if (new SectorDaoImp().listarSector().isEmpty()) {
             // si la lista de tipodecomprobante por categoria esta vacia
            cmbSector.setEditable(false);
        } else {
           
            for (Sector o : new SectorDaoImp().listarSector()) {

                cmbSector.addItem(o.getDescripcion());
            }
        }
    }
    
    
    
}
