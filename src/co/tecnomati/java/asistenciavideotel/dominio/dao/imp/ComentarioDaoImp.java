/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.dominio.dao.imp;


import co.tecnomati.java.asistenciavideotel.dominio.Comentario;
import co.tecnomati.java.asistenciavideotel.dominio.dao.ComentarioDao;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class ComentarioDaoImp extends HibernateUtil implements ComentarioDao{

    @Override
    public List<Comentario> listarComentario() {
          Session session = HibernateUtil.getSession();

        session.beginTransaction();
        List<Comentario> listaComentario =  (ArrayList<Comentario>) session.createQuery("FROM Comentario c\n"
            
                + "order by c.sid asc"
        
                ).list();
        session.close();
        return listaComentario;
    }
    @Override
    public List<Comentario> listarComentario(int idSector) {
         Session session = HibernateUtil.getSession();

        session.beginTransaction();
        List<Comentario> listaComentario =  (ArrayList<Comentario>) session.createQuery("FROM Comentario c\n"
//                + "join fetch dt.empleado as e\n"
                + "where c.sid='" + idSector + "'"
                + "order by c.sid asc"
        
                ).list();
        session.close();
        return listaComentario;
    }

    @Override
    public void addComentario(Comentario a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    
    }

    @Override
    public void deleteComentario(Comentario a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateComentario(Comentario a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public Comentario getComentario(int idComentario) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Comentario a = (Comentario) session.get(Comentario.class,idComentario);
        session.getTransaction().commit();
        session.close();
        return a;    }
    
}
