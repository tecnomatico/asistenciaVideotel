/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;

import co.tecnomati.java.asistenciavideotel.dominio.Sector;
import co.tecnomati.java.asistenciavideotel.dominio.dao.SectorDao;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class SectorDaoImp extends  HibernateUtil implements SectorDao {

    @Override
    public List<Sector> listarSector() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Sector.class);
        ArrayList<Sector> sector = (ArrayList<Sector>)criteria.list();
        session.close();
        return sector;     }

    @Override
    public void addSector(Sector a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();     }

    @Override
    public void deleteSector(Sector a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateSector(Sector a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public Sector getSector(int idSector) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Sector a = (Sector) session.get(Sector.class,idSector);
        session.getTransaction().commit();
        session.close();
        return a;    }
    
}
