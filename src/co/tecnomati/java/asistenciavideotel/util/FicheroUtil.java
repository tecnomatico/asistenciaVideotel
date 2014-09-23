/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import sun.awt.image.ToolkitImage;

/**
 *
 * @author joel
 */
public class FicheroUtil {
    
   /**
    *  Adapta el tamñano de la imagen al tamñano del label
    * @param label  representa el recuadro donde se mostrarara la imagen
    * @param img  imagen a mostrar
    */
    public static void adaptarTamaño (JLabel label , Image img){
         Icon iconoAdaptado= new ImageIcon(img.getScaledInstance(label.getWidth(),label.getHeight(),Image.SCALE_DEFAULT)); 
          label.setIcon(iconoAdaptado);//  si manda en pantalla
     }

  /**
   *   Almacena la imagen en la ruta especifiacda
   * 
   * ------------falta corregir esto!!
   * @param img
   * @param imagenArch 
   */
    public static void guardaImagenEnFichero(Image img, File imagenArch) {
        String formato = "JPEG";
        try {
            if (img != null && imagenArch != null) {
//                ImageIO.write((RenderedImage) img, formato, imagenArch);
                ImageIO.write((RenderedImage) img, formato, imagenArch);
            }
        } catch (IOException ex) {
            MiJoptionPane.mensajeError(null, "ERROR DE ESCRITURA EN DISCO");
        }
    }

   
    
    public static void guardarFotoenCarpetaDist(JLabel lblFoto, byte[] imgByte, String nombredelarchivo) {
             //1-guardo en fichero :crea img.jpeg dondoe se encuentra el .jar o sea en la carpeta dist 
            File file = new File(new File (nombredelarchivo).getAbsolutePath ()); 
            System.out.println("nombre del archiov"+ nombredelarchivo);
            ImageIcon b = new ImageIcon(imgByte);
            Image scaledInstance = b.getImage().getScaledInstance(lblFoto.getWidth(),lblFoto.getHeight(),Image.SCALE_DEFAULT);
            guardaImagenEnFichero(scaledInstance, file);
    }
//           //2- lo recupero del fichero para poder convertirlo en byte[]
//            byte[] bFile = new byte[(int) file.length()];
//            try {
//                   FileInputStream fileInputStream = new FileInputStream(file);
//                   //convert file into array of bytes
//                   fileInputStream.read(bFile);
//                   fileInputStream.close();
//                   empleado.setImagen(bFile);
//                 } catch (Exception eio) {
//                   eio.printStackTrace();
//                 }
//                
}
