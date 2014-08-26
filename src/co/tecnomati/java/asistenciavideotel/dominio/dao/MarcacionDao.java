/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.vista.marcacion.GUIMarcacion;

/**
 *
 * @author joel
 */
public interface MarcacionDao {
  java.util.List<GUIMarcacion> listarMarcacion();
  public void addMarcacion(GUIMarcacion a);
  public void deleteMarcacion(GUIMarcacion a);
  public void upDateMarcacion(GUIMarcacion a);
  public GUIMarcacion getMarcacion(int idMarcacion);
  
}
