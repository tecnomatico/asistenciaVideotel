/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package co.tecnomati.java.asistenciavideotel.util.camara;


import co.tecnomati.java.asistenciavideotel.vista.marcacion.GUIMarcacion;
import javax.media.Player;

/**
 *
 * @author Cmop
 */

/*
 * Es el nexo entre la Clase camara y el Player la primera Vez que se activa
 * la cámara
 */
public class panelCamara {


    public static void estableceCamara(GUIMarcacion camara,String dispositivo,int formato)
    {
        Player player=jDispositivos.reproductor(dispositivo,formato);
        camara.setPlayer(player);
        miPlayer.iniciarPlayer(player);
        camara.getCamara().add(player.getVisualComponent());
    }
}
