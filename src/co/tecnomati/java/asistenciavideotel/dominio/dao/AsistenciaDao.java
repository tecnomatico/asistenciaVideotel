/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.dominio.Asistencia;
import java.util.Date;

/**
 *
 * @author joel
 */
public interface AsistenciaDao {
  java.util.List<Asistencia> listarAsistencia();
  public void addAsistencia(Asistencia a);
  public void deleteAsistencia(Asistencia a);
  public void upDateAsistencia(Asistencia a);
  public Asistencia getAsistencia(int idAsistencia);
  public Asistencia getAsistencia(int idEmpleado, Date date);
 
}
