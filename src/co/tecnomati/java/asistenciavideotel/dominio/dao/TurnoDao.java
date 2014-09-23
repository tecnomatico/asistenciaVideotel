/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.dominio.Turno;
import java.util.List;

/**
 *
 * @author joel
 */
public interface TurnoDao {
  java.util.List<Turno> listarTurno();
  java.util.List<Turno> listarTurno(int idEmpleado);
  public List<Turno> listarTurno_ConForaneas();
  public void addTurno(Turno a);
  public void deleteTurno(Turno a);
  public void upDateTurno(Turno a);
  public Turno getTurno(int idTurno);
}
