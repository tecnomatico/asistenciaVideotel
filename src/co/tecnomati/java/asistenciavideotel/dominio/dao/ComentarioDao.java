/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao;

import co.tecnomati.java.asistenciavideotel.dominio.Comentario;
import java.util.List;

/**
 *
 * @author joel
 */
public interface ComentarioDao {
  java.util.List<Comentario> listarComentario();
  public void addComentario(Comentario a);
  public void deleteComentario(Comentario a);
  public void upDateComentario(Comentario a);
  public Comentario getComentario(int idComentario);
  public List<Comentario> listarComentario(int idSector);
  public Comentario getComentario(int idSector,String motivo);
}
