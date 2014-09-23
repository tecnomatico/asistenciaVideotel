/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.vista.empresa;

import co.tecnomati.java.asistenciavideotel.cons.Constantes;
import co.tecnomati.java.asistenciavideotel.dominio.Empresa;
import co.tecnomati.java.asistenciavideotel.dominio.dao.EmpresaDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.EmpresaDaoImp;
import co.tecnomati.java.asistenciavideotel.util.FiltroUtil;
import co.tecnomati.java.asistenciavideotel.util.MiJoptionPane;
import java.util.Calendar;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class GUIEmpresa extends javax.swing.JDialog {

    String paqueteImagen = "/co/tecnomati/java/asistenciavideotel/imagen/";
    Empresa empresa=null;
   
    boolean operacionOk = false; // este es una variable que se pone en verdadero si se guardo con exito los datos 
    private boolean modificar=false;
    
    javax.swing.ImageIcon iconoGuardar= new javax.swing.ImageIcon(getClass().getResource(paqueteImagen +"Guardar.jpg"));
    javax.swing.ImageIcon iconoModificar= new javax.swing.ImageIcon(getClass().getResource(paqueteImagen +"Modificar.png"));
    
   
    public GUIEmpresa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        List<Empresa> lista = new EmpresaDaoImp().listarEmpresa();
        if (!lista.isEmpty()) {
            empresa = lista.get(0);
            setDatos(empresa);
            modificar = true;
            // cambiar las etiquetas para que mensionen q se hara una actualizacion de datos
            btnGuardar.setText(Constantes.TXT_MODIFICAR);            
            btnGuardar.setIcon(iconoModificar);            
            this.setTitle(Constantes.TITLE_EDITAR_EMPRESA);
        }else{
            modificar = false;
            btnGuardar.setText(Constantes.TXT_GUARDAR);            
            btnGuardar.setIcon(iconoGuardar);
        }            
        
        this.setTitle(Constantes.TITLE_NUEVO_EMPRESA);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDenominacion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLocalidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Denominacion");

        txtDenominacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDenominacionKeyTyped(evt);
            }
        });

        jLabel2.setText("Domicilio");

        jLabel3.setText("Localidad");

        jLabel4.setText("Telefono");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setText("Foto");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLocalidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDenominacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new MiJoptionPane().mensajeInformacionAltaOK(this);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
          EmpresaDao empresaDAO = new EmpresaDaoImp();
        if (!isModificar()) {
           //si se ingresa un nueva persona
           empresa = new Empresa();    
        }
            getDatos();
            if (isModificar()) {
                empresaDAO.upDateEmpresa(empresa);
            } else {
                empresaDAO.addEmpresa(empresa);
            }
            setOperacionOk(true);
            new MiJoptionPane().mensajeInformacionAltaOK(this);
            this.dispose();
        }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtDenominacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDenominacionKeyTyped
        FiltroUtil.permitirTodo(evt, txtDenominacion, 100);
    }//GEN-LAST:event_txtDenominacionKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        FiltroUtil.permitirTodo(evt, txtTelefono, 20);
    }//GEN-LAST:event_txtTelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(GUIEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIEmpresa dialog = new GUIEmpresa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDenominacion;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    private void setDatos(Empresa cooperativa) {
        txtDenominacion.setText(cooperativa.getNombre());
        txtDomicilio.setText(cooperativa.getDomicilio());
        txtTelefono.setText(cooperativa.getTelefono());
        
    }
    
     public void getDatos(){
        empresa.setNombre(txtDenominacion.getText());
        empresa.setDomicilio(txtDomicilio.getText());
        empresa.setTelefono(txtTelefono.getText());
        
    }
 public boolean isOperacionOk() {
        return operacionOk;
    }

    public void setOperacionOk(boolean operacionOk) {
        this.operacionOk = operacionOk;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    
    
}
