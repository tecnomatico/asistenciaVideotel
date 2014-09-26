/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.dominio.Marcacion;

/**
 *
 * @author joel
 */
public interface MarcacionDao {
  java.util.List<Marcacion> listarMarcacion();
  public void addMarcacion(Marcacion a);
  public void deleteMarcacion(Marcacion a);
  public void upDateMarcacion(Marcacion a);
  public Marcacion getMarcacion(int idMarcacion);
  public Marcacion getUtlimaMarcacionIncompleta(int idAsistencia);
  
}
