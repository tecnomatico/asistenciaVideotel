/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnoamti.java.asistenciavideotel.dominio.dao;

import co.tecnoamti.java.asistenciavideotel.vista.marcacion.Marcacion;

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
  
}
