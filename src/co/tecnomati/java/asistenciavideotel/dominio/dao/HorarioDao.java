/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.dominio.Horario;
import java.util.List;

/**
 *
 * @author joel
 */
public interface HorarioDao {
  java.util.List<Horario> listarHorario();
  public void addHorario(Horario a);
  public void deleteHorario(Horario a);
  public void upDateHorario(Horario a);
  public Horario getHorario(int idHorario);
  public List<Horario> listarHorarioOrdenadoXMomento();
}
