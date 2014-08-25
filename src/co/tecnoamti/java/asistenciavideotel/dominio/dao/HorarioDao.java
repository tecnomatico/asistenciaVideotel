/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnoamti.java.asistenciavideotel.dominio.dao;

import co.tecnoamti.java.asistenciavideotel.dominio.Horario;

/**
 *
 * @author joel
 */
public interface HorarioDao {
  java.util.List<Horario> listarHorario();
  public void addTcategoria(Horario a);
  public void deleteTcategoria(Horario a);
  public void upDateTcategoria(Horario a);
  public Horario getTcategoria(int idHorario);
}
