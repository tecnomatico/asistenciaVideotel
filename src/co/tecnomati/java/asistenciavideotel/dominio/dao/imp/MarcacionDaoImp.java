/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;


import co.tecnomati.java.asistenciavideotel.dominio.Marcacion;
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

    @Override
    public Marcacion getUtlimaMarcacionIncompleta(int idAsistencia) {
       
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Marcacion marcacion = (Marcacion) session.createQuery("FROM Marcacion m\n"
                + "join fetch m.asistencia  as a\n"
                + "where a.aid='" + idAsistencia + "' and m.estado='" + 0 + "'"
                ).uniqueResult();
        session.close();
        return marcacion;
    
    }
 
}
