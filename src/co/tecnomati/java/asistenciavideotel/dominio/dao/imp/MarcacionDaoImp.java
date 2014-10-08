/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;

import co.tecnomati.java.asistenciavideotel.dominio.Empleado;
import co.tecnomati.java.asistenciavideotel.dominio.Marcacion;
import co.tecnomati.java.asistenciavideotel.vista.marcacion.GUIMarcacion;
import co.tecnomati.java.asistenciavideotel.dominio.dao.MarcacionDao;
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
public class MarcacionDaoImp extends HibernateUtil implements MarcacionDao {

    @Override
    public List<Marcacion> listarMarcacion() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Marcacion> marcacion = (ArrayList<Marcacion>) session.createQuery("FROM Marcacion m\n"
                + "join fetch m.asistencia  as a\n"
                + "join fetch m.asistencia.empleado  as e\n"
                + "order by t.pturno asc and h.entrada asc\n").list();
        session.close();
        return marcacion;
    }

    @Override
    public void addMarcacion(Marcacion a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

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
        Marcacion a = (Marcacion) session.get(Marcacion.class, idMarcacion);
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
                + "where a.aid='" + idAsistencia + "' and m.estado='" + 0 + "'").uniqueResult();
        session.close();
        return marcacion;

    }

    @Override
    public List<Marcacion> listarMarcacion(Date inicio, Date fin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechainicio = sdf.format(inicio);
        String fechafin = sdf.format(fin);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Marcacion> marcacion = (ArrayList<Marcacion>) session.createQuery("FROM Marcacion m\n"
                + "join fetch m.asistencia  as a\n"
                + "join fetch a.empleado  as e\n"
                + "where a.fecha>='" + fechainicio + "' and a.fecha<='" + fechafin + "'"
                + "order by m.fecha desc asc and e.apellido \n").list();
        session.close();
        return marcacion;
    }

    @Override
    public List<Marcacion> listarMarcacion(Empleado e, Date inicio, Date fin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechainicio = sdf.format(inicio);
        String fechafin = sdf.format(fin);
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Marcacion> marcacion = (ArrayList<Marcacion>) session.createQuery("FROM Marcacion as m\n"
                + "join fetch m.asistencia  as a\n"
                + "join fetch a.empleado  as e\n"
                + "where a.fecha>='" + fechainicio + "' and a.fecha<='" + fechafin + "' and e.eid='" + e.getEid() + "'"
               + "order by a.fecha desc and e.apellido asc \n").list();
        session.close();
        
              
        return marcacion;
    }
}
