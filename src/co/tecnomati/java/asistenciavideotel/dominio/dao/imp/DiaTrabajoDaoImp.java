/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;

import co.tecnomati.java.asistenciavideotel.dominio.Diatrabajo;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class DiaTrabajoDaoImp extends HibernateUtil implements co.tecnomati.java.asistenciavideotel.dominio.dao.DiaTrabajoDao{

    @Override
    public List<Diatrabajo> listarDiaTrabajo() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Diatrabajo.class);
        ArrayList<Diatrabajo> diatrabajo = (ArrayList<Diatrabajo>)criteria.list();
        session.close();
        return diatrabajo; 
    }

    @Override
    public void addDiatrabajo(Diatrabajo a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    
    }

    @Override
    public void deleteDiatrabajo(Diatrabajo a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateDiatrabajo(Diatrabajo a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public Diatrabajo getDiatrabajo(int idDiatrabajo) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Diatrabajo a = (Diatrabajo) session.get(Diatrabajo.class,idDiatrabajo);
        session.getTransaction().commit();
        session.close();
        return a;
    }
    
    
    @Override
    public Diatrabajo getDiatrabajo_XDia(int indexDia, int idEmpleado) {
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Diatrabajo.class);

        Diatrabajo diatrabajo = (Diatrabajo) session.createQuery("FROM Diatrabajo dt\n"
                + "join fetch dt.empleado as e\n"
                + "where dt.did='" + indexDia + "' and e.eid>='" + idEmpleado + "'"
                ).uniqueResult();
        session.close();
        return diatrabajo;
    }
    
    
    
}
