/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.dominio.Diatrabajo;

/**
 *
 * @author joel
 */
public interface DiaTrabajoDao {
     java.util.List<Diatrabajo> listarDiaTrabajo();
  public void addDiatrabajo(Diatrabajo a);
  public void deleteDiatrabajo(Diatrabajo a);
  public void upDateDiatrabajo(Diatrabajo a);
  public Diatrabajo getDiatrabajo(int idDiatrabajo); 
  public Diatrabajo getDiatrabajo_XDia(int indexDia, int idEmpleado);
}
