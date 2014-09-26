/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;

import co.tecnomati.java.asistenciavideotel.dominio.Turno;
import co.tecnomati.java.asistenciavideotel.dominio.dao.TurnoDao;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class TurnoDaoImp extends HibernateUtil implements TurnoDao {

    @Override
    public List<Turno> listarTurno() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Turno.class);
        ArrayList<Turno> diaTurno = (ArrayList<Turno>) criteria.list();
        session.close();
        return diaTurno;
    }

    public List<Turno> listarTurno_ConForaneas() {
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Turno.class);

        ArrayList<Turno> turnos = (ArrayList<Turno>) session.createQuery("FROM Turno t\n"
                + "join fetch t.diatrabajo  as dt\n"
                + "join fetch t.horario as h\n"
                + "order by t.pturno asc and h.entrada asc\n").list();
        session.close();
        return turnos;
    }

    @Override
    public void addTurno(Turno a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteTurno(Turno a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateTurno(Turno a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Turno getTurno(int idTurno) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Turno a = (Turno) session.get(Turno.class, idTurno);
        session.getTransaction().commit();
        session.close();
        return a;
    }

    /**
     * 
     * @param idEmpleado
     * @return  lista de turno con sus foraneas ordenado por dia y 
     */
    @Override
    public List<Turno> listarTurno(int idEmpleado) {
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Turno.class);

        ArrayList<Turno> turnos = (ArrayList<Turno>) session.createQuery("FROM Turno t\n"
                + "join fetch t.diatrabajo  as dt\n"
                + "join fetch dt.empleado as e\n"
                + "join fetch t.horario as h\n"
                + "where e.eid='" + idEmpleado + "'"
                + "order by dt.did asc and h.etihorario \n").list();
        session.close();
        return turnos;
    }
    
    
    @Override
    public List<Turno> listarTurno(int idEmpleado, int idDiaTrabajo) {
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Turno.class);

        ArrayList<Turno> turnos = (ArrayList<Turno>) session.createQuery("FROM Turno t\n"
//                + "join fetch t.diatrabajo  as dt\n"
//                + "join fetch dt.empleado as e\n"
                + "join fetch t.horario as h\n"
                + "where t.diatrabajo.empleado.eid='" + idEmpleado + "' and t.diatrabajo.dtid='" + idDiaTrabajo + "'"
                + "order by t.horario.entrada asc  \n").list();
        session.close();
        return turnos;
    }
    @Override
    public Turno getTurno(int idEmpleado, int idDiaTrabajo,byte numTurno) {
        Session session = HibernateUtil.getSession();

        session.beginTransaction();
        Criteria criteria = session.createCriteria(Turno.class);

        Turno turnos = (Turno) session.createQuery("FROM Turno t\n"
//                + "join fetch t.diatrabajo  as dt\n"
//                + "join fetch dt.empleado as e\n"
                + "join fetch t.horario as h\n"
                + "where t.diatrabajo.empleado.eid='" + idEmpleado + "' and t.diatrabajo.dtid='" + idDiaTrabajo + "'"
                + "order by t.horario.entrada asc  \n").list().get(numTurno-1);
        session.close();
        return turnos;
    }

   
}
