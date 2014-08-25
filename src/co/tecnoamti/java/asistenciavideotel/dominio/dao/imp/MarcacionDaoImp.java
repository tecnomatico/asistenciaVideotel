/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnoamti.java.asistenciavideotel.dominio.dao.imp;

import co.tecnoamti.java.asistenciavideotel.dominio.dao.MarcacionDao;
import co.tecnoamti.java.asistenciavideotel.vista.marcacion.Marcacion;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class MarcacionDaoImp extends HibernateUtil implements MarcacionDao{

    @Override
    public List<Marcacion> listarMarcacion() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Marcacion.class);
        ArrayList<Marcacion> marcacion = (ArrayList<Marcacion>)criteria.list();
        session.close();
        return marcacion; 
    }

    @Override
    public void addMarcacion(Marcacion a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteMarcacion(Marcacion a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateMarcacion(Marcacion a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public Marcacion getMarcacion(int idMarcacion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Marcacion a = (Marcacion) session.get(Marcacion.class,idMarcacion);
        session.getTransaction().commit();
        session.close();
        return a;
    }
 
}
