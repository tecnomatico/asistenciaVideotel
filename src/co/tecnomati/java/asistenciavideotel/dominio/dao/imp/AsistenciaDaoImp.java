/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;

import co.tecnomati.java.asistenciavideotel.dominio.Asistencia;
import co.tecnomati.java.asistenciavideotel.dominio.dao.AsistenciaDao;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    @Override
    public Asistencia getAsistencia(int idEmpleado, Date date) {
       // convierto en string al date y lo formateo para qu muestre en formato año-mes-dia
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String fecha = sdf.format(date);
       //////////////////////////////////////
       
        Session session = HibernateUtil.getSession();
       session.beginTransaction();
        Criteria criteria = session.createCriteria(Asistencia.class);
        Asistencia diatrabajo = (Asistencia) session.createQuery("FROM Asistencia a\n"
                + "where a.empleado.eid='" + idEmpleado + "' and a.fecha='" + fecha + "'"
                ).uniqueResult();
        session.close();
        return diatrabajo;
    }
 
//    public Asistencia listarAsistencia(Empleado e ,Date fechaInicio, Date fechaFin) {
//        Session session = HibernateUtil.getSession();
//         Criteria criteria = session.createCriteria(Asistencia.class);
////        criteria.addOrder(Order.asc("fecha"));
//         criteria.addOrder(Order.asc("idAsistencia"));
//         criteria.add(Restrictions.eq("empleado", e));
//         criteria.add( Restrictions.ge("fecha", fechaInicio) );
//         criteria.add( Restrictions.le("fecha", fechaFin) ); 
//         Asistencia lista = (Asistencia)criteria.uniqueResult();
//         
//         session.close();
//          return lista;
//    }
}
