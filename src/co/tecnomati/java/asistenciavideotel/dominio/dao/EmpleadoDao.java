/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.dominio.Empleado;
import java.util.List;

/**
 *
 * @author joel
 */
public interface EmpleadoDao {
  java.util.List<Empleado> listarEmpleado();
  public List<Empleado> listarEmpleadoSector();
  public void addEmpleado(Empleado a);
  public void deleteEmpleado(Empleado a);
  public void upDateEmpleado(Empleado a);
  public Empleado getEmpleado(int idEmpleadoo);
  public Empleado getEmpleadoAdministrador(int dni,boolean adm,String clave);
   public Empleado getEmpleado_XDni(int dni);
}
