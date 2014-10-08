/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.dominio.Empleado;
import co.tecnomati.java.asistenciavideotel.dominio.Marcacion;
import java.util.Date;

/**
 *
 * @author joel
 */
public interface MarcacionDao {
  java.util.List<Marcacion> listarMarcacion();
  java.util.List<Marcacion> listarMarcacion(Date inicio , Date fin);
  java.util.List<Marcacion> listarMarcacion(Empleado e,Date inicio , Date fin);
  public void addMarcacion(Marcacion a);
  public void deleteMarcacion(Marcacion a);
  public void upDateMarcacion(Marcacion a);
  public Marcacion getMarcacion(int idMarcacion);
  public Marcacion getUtlimaMarcacionIncompleta(int idAsistencia);
  
}
