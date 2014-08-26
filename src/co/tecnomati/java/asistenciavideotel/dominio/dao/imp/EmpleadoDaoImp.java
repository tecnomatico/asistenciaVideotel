/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;

import co.tecnomati.java.asistenciavideotel.dominio.Empleado;
import co.tecnomati.java.asistenciavideotel.dominio.dao.EmpleadoDao;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class EmpleadoDaoImp extends HibernateUtil implements EmpleadoDao{

    @Override
    public List<Empleado> listarEmpleado() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
        ArrayList<Empleado> empleado = (ArrayList<Empleado>)criteria.list();
        session.close();
        return empleado; 
    }

    @Override
    public void addEmpleado(Empleado a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    }

    @Override
    public void deleteEmpleado(Empleado a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateEmpleado(Empleado a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public Empleado getEmpleado(int idEmpleado) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Empleado a = (Empleado) session.get(Empleado.class,idEmpleado);
        session.getTransaction().commit();
        session.close();
        return a;
    }
    
}
