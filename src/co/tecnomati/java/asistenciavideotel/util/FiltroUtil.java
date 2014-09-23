/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util;

import javax.swing.JTextField;

/**
 *
 * @author joel
 */
public class FiltroUtil {
    
     public static void permitirSoloNumero(java.awt.event.KeyEvent evt) {
        // permitir solo el ingreso de numero
        char caracter = evt.getKeyChar();
        if(((caracter < '0') ||
            (caracter > '9')) &&
            (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
             evt.consume();  // ignorar el evento de teclado
        }
       
     }    
    
    /**
     * Este metodo solo permitie el ingreso de N numeros 
     * @param evt
     * @param n es la cantidad de numeros permitidos 
     * @param campo es una textfield  donde se ingresa los n numeros.
     *  
     */
     public static void permitirSoloNumero(java.awt.event.KeyEvent evt,JTextField campo, int n) {
        // permitir solo el ingreso de numero
        permitirSoloNumero(evt);
       if (campo.getText().length() == n) {
            evt.consume();
        }
     }
     
      /**filtra cualquier caracter excepto los numeros. es decir permite solo entrada de numero.
     * 
     * @param evt  evento 
     */
    public static void permitirSoloLetras(java.awt.event.KeyEvent evt) {
        // conusmir los caracteres del legajo excepto los numeros
        char caracter = evt.getKeyChar();
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }
     /**
      * 
      * @param evt
      * @param campo es la jtexfield que necesita que se realiza los filtros de caracteres
      * @param n   longitud maxima de numeros que permite el jtextfield
      */
     public static void permitirSoloLetras(java.awt.event.KeyEvent evt, JTextField campo, int n) {
          permitirSoloLetras(evt);
        if (campo.getText().length() == n) {
            evt.consume();
        }
     }
    
     
     /**
      * Permite solo el ingreso de N  caracteres (numeros, letras, caracteres especiales...) . 
      * @param evt
      * @param campo  textfiel donde se ingresa datos
      */
     public static  void permitirTodo(java.awt.event.KeyEvent evt,JTextField campo, int n){
         if(campo.getText().length()>=n){
            evt.consume();
       }
     }
     
     
      /**
    * Permite el ingreso de cualquier caracter y tambien
    * Consume cualquier caracter luego de haber ingresado n caracteres.
    * @param evt
    * @param campo
    * @param n 
    */
     public static void consumirAll(java.awt.event.KeyEvent evt, JTextField campo, int n){
         if (evt.getKeyChar()!='.' || countChar(".", campo.getText())>1) {
             permitirSoloLetras(evt);
         }
         if (campo.getText().length() == n) {
            evt.consume();
        } 
    }
     
     
      public static int countChar(String c, String s){
        return s.split(c).length - 1;
     }
}
