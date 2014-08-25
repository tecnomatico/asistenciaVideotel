/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnoamti.java.asistenciavideotel.dominio.dao.imp;

import co.tecnoamti.java.asistenciavideotel.dominio.Comentario;
import co.tecnoamti.java.asistenciavideotel.dominio.Empresa;
import co.tecnoamti.java.asistenciavideotel.dominio.Tcategoria;
import co.tecnoamti.java.asistenciavideotel.dominio.dao.CategoriaTurnoDao;
import co.tecnomati.java.asistenciavideotel.hibernateUtil.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author joel
 */
public class CategoriaTurnoDaoImp extends HibernateUtil implements CategoriaTurnoDao{

    @Override
    public List<Tcategoria> listarTcategoria() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Tcategoria.class);
        ArrayList<Tcategoria> tcategoria = (ArrayList<Tcategoria>)criteria.list();
        session.close();
        return tcategoria; 
    }

    @Override
    public void addTcategoria(Tcategoria a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(a);
        session.getTransaction().commit();
        session.close();    
    }

    @Override
    public void deleteTcategoria(Tcategoria a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(a);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void upDateTcategoria(Tcategoria a) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(a);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public Tcategoria getTcategoria(int idTcategoria) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Tcategoria a = (Tcategoria) session.get(Tcategoria.class,idTcategoria);
        session.getTransaction().commit();
        session.close();
        return a;   
    }
    
}
