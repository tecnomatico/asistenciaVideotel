/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.dominio.Tcategoria;

/**
 *
 * @author joel
 */
public interface CategoriaTurnoDao {
  java.util.List<Tcategoria> listarTcategoria();
  public void addTcategoria(Tcategoria a);
  public void deleteTcategoria(Tcategoria a);
  public void upDateTcategoria(Tcategoria a);
  public Tcategoria getTcategoria(int idTcategoria);
}
