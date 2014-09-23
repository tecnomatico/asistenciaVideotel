
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.main;


import co.tecnomati.java.asistenciavideotel.util.CreadorUtil;
import co.tecnomati.java.asistenciavideotel.vista.marcacion.GUIMarcacion;
import javax.swing.JOptionPane;

/**
 *
 * @author joel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         try{
//           if( new DiaDaoImp().listarDia().isEmpty()){
//               CreadorUtil.CrearDias();
//           }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "LA BD NO ESTA INICIADA, POR FAVOR ACTIVE EL SERVICIO Y VUELVA ARRANCAR EL SISTEMA ", "ERROR", JOptionPane.ERROR_MESSAGE);
       }
        
        new GUIMarcacion();
        
    }
}
