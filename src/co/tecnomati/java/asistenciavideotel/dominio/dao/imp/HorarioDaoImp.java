/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;

import co.tecnomati.java.asistenciavideotel.dominio.Horario;
import co.tecnomati.java.asistenciavideotel.dominio.dao.HorarioDao;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class HorarioDaoImp extends HibernateUtil implements HorarioDao{

    @Override
    public List<Horario> listarHorario() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Horario.class);
        ArrayList<Horario> horario = (ArrayList<Horario>)criteria.list();
        session.close();
        return horario; 
    }

    @Override
    public void addHorario(Horario a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }
    

    @Override
    public void deleteHorario(Horario a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateHorario(Horario a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public Horario getHorario(int idHorario) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Horario a = (Horario) session.get(Horario.class,idHorario);
        session.getTransaction().commit();
        session.close();
        return a;
    }
    
     @Override
    public List<Horario> listarHorarioOrdenadoXMomento() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Horario.class);
        ArrayList<Horario> comprobante = (ArrayList<Horario>) session.createQuery("from Horario h \n"
                      + "order by h.etihorario asc and h.entrada asc").list();
        session.close();
        return comprobante;
    }
}
