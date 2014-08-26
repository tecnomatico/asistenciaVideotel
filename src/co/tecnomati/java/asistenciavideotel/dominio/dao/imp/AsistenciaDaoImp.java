/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;

import co.tecnomati.java.asistenciavideotel.dominio.Asistencia;
import co.tecnomati.java.asistenciavideotel.dominio.dao.AsistenciaDao;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class AsistenciaDaoImp extends HibernateUtil implements  AsistenciaDao{

    @Override
    public List<Asistencia> listarAsistencia() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Asistencia.class);
        ArrayList<Asistencia> asistencia = (ArrayList<Asistencia>)criteria.list();
        session.close();
        return asistencia; 
    }

    @Override
    public void addAsistencia(Asistencia a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteAsistencia(Asistencia a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateAsistencia(Asistencia a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public Asistencia getAsistencia(int idAsistencia) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Asistencia a = (Asistencia) session.get(Asistencia.class,idAsistencia);
        session.getTransaction().commit();
        session.close();
        return a;
    }
 
    
}
