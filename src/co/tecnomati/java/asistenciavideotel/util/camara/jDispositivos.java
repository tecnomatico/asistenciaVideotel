/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.tecnomati.java.asistenciavideotel.util.camara;

/**
 *
 * @author Cmop
 */

import co.tecnomati.java.asistenciavideotel.util.MiJoptionPane;
import co.tecnomati.java.asistenciavideotel.vista.marcacion.GUIMarcacion;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import javax.media.CannotRealizeException;
import javax.media.cdm.CaptureDeviceManager;
import javax.media.CaptureDeviceInfo;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;

import javax.media.control.FormatControl;
import javax.media.format.RGBFormat;
import javax.media.format.YUVFormat;
import javax.swing.JMenu;

public class jDispositivos {
    public static final String  TITULOJPane = "Sistema Control de Asistencia"; 
    public jDispositivos(){}

    /*
     * Método para listar los dispositivos detectados, por su Nombre
     */
    public static String detectaDispositivos()
    {
        String rpta="";
        Vector v=CaptureDeviceManager.getDeviceList(null);
        int t;
        if((t=v.size())>0)
            for(int i=0;i<t;i++)
            {
                rpta+=((CaptureDeviceInfo)v.elementAt(i)).getName()+"\n";
            }
        return rpta;
    }
    /*
     * Devuelve un Objeto CaptureDeviceInfo de un dispositivo
     */
    public static CaptureDeviceInfo retornaDispositivo(String nombre)
    {
        return CaptureDeviceManager.getDevice(nombre);
    }
    /*
     * Devuelve el Locator de un Dispositivo
     */
    public static MediaLocator abredispositivo(CaptureDeviceInfo cdi)
    {
        return cdi.getLocator();
    }
    /*
     * Crea un player a partir de un MediaLocator
     */
    public static Player reproductor(MediaLocator ml)
    {
        Player p = null;
        try {
            p = Manager.createRealizedPlayer(ml);
        } catch (CannotRealizeException ex) {
             MiJoptionPane.mensajeError(null, "No se pudo cargar el Player");
        }catch (IOException ex) {
            MiJoptionPane.mensajeError(null, "Error de Entrada/Salida");
        } catch (NoPlayerException ex) {
            MiJoptionPane.mensajeError(null, "No player Exception!");
        }
        return p;
    }
    /*
     * Crea un Player a partir del nombre del dispositivo
     */
    public static Player reproductor(String dispositivo)
    {
        Player p = null;
        try {
            p = Manager.createPlayer(abredispositivo(retornaDispositivo(dispositivo)));
        } catch (IOException ex) {
            MiJoptionPane.mensajeError(null, "Error de Entrada/Salida");
        } catch (NoPlayerException ex) {
            MiJoptionPane.mensajeError(null, "No player Exception!");
        }
        return p;
    }
    /*
     * Cre un Player a partir del nombre del dispositivo  y
     * del indice del formato que se desea aplicar
     */
    public static Player reproductor(String dispositivo,int f)
    {
        Player p = null;
        try {
            p = Manager.createRealizedPlayer(abredispositivo(retornaDispositivo(dispositivo)));
            Format []formatos=getFormatos(dispositivo);
            FormatControl formatControl = (FormatControl)p.getControl("javax.media.control.FormatControl");
            formatControl.setFormat (formatos[f]);
        } catch (CannotRealizeException ex) {
            MiJoptionPane.mensajeError(null, "Error de Entrada/Salida");
        }catch (IOException ex) {
            MiJoptionPane.mensajeError(null, "Error de Entrada/Salida");
        } catch (NoPlayerException ex) {
            MiJoptionPane.mensajeError(null, "No player Exception!");
        }
        return p;
    }
    /*
     * Retorna los formatos disponibles,pasandole el nombre del Dispositivo
     */
    public static Format []getFormatos(String nombre)
    {
        CaptureDeviceInfo cdi1=retornaDispositivo(nombre);
        Format []formatos=cdi1.getFormats();
        return formatos;
    }
    /*
     * Permite alternar las resoluciones de un Player
     */
    public static void cambiaResolucion(String dispositivo,Player p,int formato)
    {
        if(p!=null)
            p.stop();
        
        Format []formatos=getFormatos(dispositivo);
        FormatControl formatControl = (FormatControl)p.getControl("javax.media.control.FormatControl");
        formatControl.setFormat (formatos[formato]);
        p.start();
    }
    /*
     * Carga los dispositivos detectados en un Menu
     */
    public static void menuDispositivos(GUIMarcacion padre,JMenu dispositivos)
    {
      Vector listaDispositivos = null;
      //Buscamos los dispositivos instalados
      listaDispositivos = CaptureDeviceManager.getDeviceList(null);
      Iterator it = listaDispositivos.iterator();

      String nombre="";
      Format[] cfmts;
      while (it.hasNext())
      {
          CaptureDeviceInfo cdi = (CaptureDeviceInfo)it.next();
          nombre=cdi.getName(); //Obtiene el nombre del Dispositivo Detectado

          if(nombre.indexOf("Image")!=-1)  // si hay ocurrencia
          {
              JMenu menuFormato=new JMenu(nombre);
              JMenuFormato tamanios=null;
              CaptureDeviceInfo dev = CaptureDeviceManager.getDevice(nombre);
              cfmts = dev.getFormats();

              for(int i=0; i<cfmts.length;i++)
              {
                  if(cfmts[i].getEncoding().compareTo("yuv")==0)
                  {tamanios=new JMenuFormato(nombre,cfmts[i].getEncoding()+" "+
                          ((YUVFormat)cfmts[i]).getSize().width+"x"+
                          ((YUVFormat)cfmts[i]).getSize().height,i,
                          ((YUVFormat)cfmts[i]).getSize().width,
                          ((YUVFormat)cfmts[i]).getSize().height,
                          padre,
                          padre.getCamara());
                  }
                  else if(cfmts[i].getEncoding().compareTo("rgb")==0)
                  {tamanios=new JMenuFormato(nombre,cfmts[i].getEncoding()+" "+
                          ((RGBFormat)cfmts[i]).getSize().width+"x"+
                          ((RGBFormat)cfmts[i]).getSize().height,i,
                          ((RGBFormat)cfmts[i]).getSize().width,
                          ((RGBFormat)cfmts[i]).getSize().height,
                          padre,
                          padre.getCamara());
                  }
                  menuFormato.add(tamanios);
              }
              dispositivos.add(menuFormato);
          }
      }
    }
}
