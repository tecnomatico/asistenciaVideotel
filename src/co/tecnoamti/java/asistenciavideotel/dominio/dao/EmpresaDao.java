/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnoamti.java.asistenciavideotel.dominio.dao;

import co.tecnoamti.java.asistenciavideotel.dominio.Empresa;

/**
 *
 * @author joel
 */
public interface EmpresaDao {
    java.util.List<Empresa> listarEmpresa();
  public void addEmpresa(Empresa a);
  public void deleteEmpresa(Empresa a);
  public void upDateEmpresa(Empresa a);
  public Empresa getEmpresa(int idEmpresa);
  }
