/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.tecnomati.java.asistenciavideotel.util;

/**
 *
 * @author Cmop
 */
import co.tecnomati.java.asistenciavideotel.cons.Constantes;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class MiJoptionPane extends JOptionPane{
   String paqueteImagen = "/co/tecnomati/java/asistenciavideotel/imagen/";
   Icon iconoModificar= new javax.swing.ImageIcon(getClass().getResource(paqueteImagen +"Modificar.png"));
  
   
   public static final String ACCION_ALTA = "ALTA";
   public static final String ACCION_BAJA = "BAJA";
   public static final String ACCION_ACTUALIZACION = "ACTUALIZACION";
   public static final String OPERACION_OK = "LA OPERACION SE REALIZO EXITOSAMENTE";
   public static final String SELECCIONE_FILA = "SELECCIONE UNA FILA";
   public static final String MENSAJE_VACIO1 = " EL CAMPO ";
   public static final String MENSAJE_VACIO2= " NO PUEDE ESTAR VACIO";
   public static final String IDENTIFICACION_ERRONEA = " SU IDENTIFICACION ES INCORRECTA, POR FAVOR INGRESE DE NUEVO";
   public static final String IDENTIFICACION_VACIA = " NO PUEDEN ESTAR VACIOS SUS DATOS DE  IDENTIDAD";
   public static final String CLAVES_DISTINTAS = " NO COINCIDE LAS CLAVES";
   
   
   
    public static void mensajeError(Component padre,String mensaje)
    {
        JOptionPane.showMessageDialog(padre,mensaje,Constantes.TITLE_APP,JOptionPane.ERROR_MESSAGE);
    }
    public static void mensajeAdvertencia(Component padre,String mensaje)
    {
        JOptionPane.showMessageDialog(padre,mensaje,Constantes.TITLE_APP,JOptionPane.WARNING_MESSAGE);
    }
    public static void mensajeInformacionAtualizacionOK(Component padre){
        JOptionPane.showMessageDialog(padre,OPERACION_OK,ACCION_ACTUALIZACION,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mensajeInformacionBajaOK(Component padre){
        JOptionPane.showMessageDialog(padre,OPERACION_OK,ACCION_BAJA,JOptionPane.INFORMATION_MESSAGE);
    }
    public static void mensajeInformacionAltaOK(Component padre){

        JOptionPane.showMessageDialog(padre,OPERACION_OK,ACCION_ALTA,JOptionPane.INFORMATION_MESSAGE);
       // JOptionPane.showMessageDialog(padre, UNINITIALIZED_VALUE, ACCION_ALTA, JOptionPane.INFORMATION_MESSAGE,iconoModificar);
        
    }
    
   /**
    * 
    * @param padre
    * @param objeto  indica cual es el objeto a eliminar . Ej: una persona 
    * @param descripcion una referencia del objeto , puede ser el nombre o descricion o identificador . Ej: nombre de la persona, el id , dni, etc.
    * @return 
    */
    public int confiramacionMensajeEliminar(Component padre, String objeto, String descripcion){
        String mensj1= "Esta seguro de Eliminar el "+ objeto+": "+ descripcion;
        String mensj2= "ELIMINAR "+ objeto;
        
          int opc = JOptionPane.showConfirmDialog(null,mensj1,mensj2, JOptionPane.YES_NO_OPTION);
  
          return opc;
          
    }
    
    public void showDialogSeleccioneFila(Component padre){
         JOptionPane.showMessageDialog(this, SELECCIONE_FILA);
    }

    /**
     * 
     * @param object
     * @param objetoVaciio representa el nombre del  elemnento que esta vacio 
     */
    public void mensajeErrorCampoVacio(Component padre, String objetoVaciio) {
        JOptionPane.showMessageDialog(padre,MENSAJE_VACIO1+objetoVaciio +MENSAJE_VACIO2,Constantes.TITLE_APP,JOptionPane.WARNING_MESSAGE);
    }
}
