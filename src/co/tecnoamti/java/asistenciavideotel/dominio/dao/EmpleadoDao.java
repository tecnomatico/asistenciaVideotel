/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnoamti.java.asistenciavideotel.dominio.dao;

import co.tecnoamti.java.asistenciavideotel.dominio.Empleado;

/**
 *
 * @author joel
 */
public interface EmpleadoDao {
  java.util.List<Empleado> listarEmpleado();
  public void addEmpleado(Empleado a);
  public void deleteEmpleado(Empleado a);
  public void upDateEmpleado(Empleado a);
  public Empleado getEmpleado(int idEmpleadoo);
}
