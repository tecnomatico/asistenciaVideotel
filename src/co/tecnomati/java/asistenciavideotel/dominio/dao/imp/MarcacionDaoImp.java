/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;


import co.tecnomati.java.asistenciavideotel.vista.marcacion.GUIMarcacion;
import co.tecnomati.java.asistenciavideotel.dominio.dao.MarcacionDao;
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
    public List<GUIMarcacion> listarMarcacion() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(GUIMarcacion.class);
        ArrayList<GUIMarcacion> marcacion = (ArrayList<GUIMarcacion>)criteria.list();
        session.close();
        return marcacion; 
    }

    @Override
    public void addMarcacion(GUIMarcacion a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteMarcacion(GUIMarcacion a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateMarcacion(GUIMarcacion a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public GUIMarcacion getMarcacion(int idMarcacion) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        GUIMarcacion a = (GUIMarcacion) session.get(GUIMarcacion.class,idMarcacion);
        session.getTransaction().commit();
        session.close();
        return a;
    }
 
}
