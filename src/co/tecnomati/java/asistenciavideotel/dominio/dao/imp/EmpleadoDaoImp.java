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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author joel
 */
public class EmpleadoDaoImp extends HibernateUtil implements EmpleadoDao {

    @Override
    public List<Empleado> listarEmpleado() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
        ArrayList<Empleado> empleado = (ArrayList<Empleado>) criteria.list();
        session.close();
        return empleado;
    }

    @Override
    public List<Empleado> listarEmpleadoSector() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
        ArrayList<Empleado> comprobante = (ArrayList<Empleado>) session.createQuery("from Empleado e \n"
                + "join fetch e.sector\n"
                + "order by e.apellido asc and c.nombre asc").list();
        session.close();
        return comprobante;
    }

    @Override
    public void addEmpleado(Empleado a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

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
        Empleado a = (Empleado) session.get(Empleado.class, idEmpleado);
        session.getTransaction().commit();
        session.close();
        return a;
    }
    
    
     public Empleado getEmpleadoAdministrador(int dni,boolean adm,String clave){
        Empleado e = null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
        criteria.add(Restrictions.eq("dni", dni));
        criteria.add(Restrictions.eq("administrador", adm));
        criteria.add(Restrictions.eq("clave",clave));
        
        List<Empleado> lista = (List<Empleado>)criteria.list();
        if (lista.size()!=0) {
            e = lista.get(0);
        }         
        session.getTransaction().commit();
        session.close();
        return e;
    }
     public Empleado getEmpleado_XDni(int dni){
        Empleado e = null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Empleado.class);
        criteria.add(Restrictions.eq("dni", dni));
        
        List<Empleado> lista = (List<Empleado>)criteria.list();
        if (lista.size()!=0) {
            e = lista.get(0);
        }         
        session.getTransaction().commit();
        session.close();
        return e;
    }
}
