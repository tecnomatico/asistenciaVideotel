/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;

import co.tecnomati.java.asistenciavideotel.dominio.dao.EmpresaDao;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import co.tecnomati.java.asistenciavideotel.dominio.Empresa;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class EmpresaDaoImp extends HibernateUtil implements EmpresaDao{

    @Override
    public List<Empresa> listarEmpresa() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empresa.class);
        ArrayList<Empresa> empresa = (ArrayList<Empresa>)criteria.list();
        session.close();
        return empresa;    
    }

    @Override
    public void addEmpresa(Empresa a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    
    }

    @Override
    public void deleteEmpresa(Empresa a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateEmpresa(Empresa a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public Empresa getEmpresa(int idEmpresa) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Empresa a = (Empresa) session.get(Empresa.class,idEmpresa);
        session.getTransaction().commit();
        session.close();
        return a;

    }
    
}
