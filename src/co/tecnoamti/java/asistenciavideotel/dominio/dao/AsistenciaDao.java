/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnoamti.java.asistenciavideotel.dominio.dao;

import co.tecnoamti.java.asistenciavideotel.dominio.Asistencia;

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
 
}
