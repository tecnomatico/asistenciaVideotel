/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnoamti.java.asistenciavideotel.dominio.dao;

import co.tecnoamti.java.asistenciavideotel.dominio.Sector;

/**
 *
 * @author joel
 */
public interface SectorDao {
  java.util.List<Sector> listarSector();
  public void addSector(Sector a);
  public void deleteSector(Sector a);
  public void upDateSector(Sector a);
  public Sector getSector(int idSector);
}
