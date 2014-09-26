/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util.modeloTabla;

import co.tecnomati.java.asistenciavideotel.dominio.Comentario;
import co.tecnomati.java.asistenciavideotel.dominio.Sector;
import co.tecnomati.java.asistenciavideotel.dominio.dao.ComentarioDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.SectorDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.ComentarioDaoImp;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.SectorDaoImp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author AnahiAramayo
 */
public class ModeloComentario extends AbstractTableModel{
    Comentario comentario = new Comentario();
   ComentarioDao comentarioDAO = new ComentarioDaoImp();
    ArrayList<Comentario> listaComentario = new ArrayList<Comentario>();
   
    // tipo= 0  todo los conceptos
    //tipo=1   todos los conceptos menos los 5 conceptos de los formularios 
    public ModeloComentario() {            
        try {
            
            listaComentario = (ArrayList<Comentario>) comentarioDAO.listarComentario();
        } catch (ClassCastException ex) {
            listaComentario = new ArrayList<Comentario>();            
        }
    }
    
    public final void actualizar() {
        fireTableDataChanged();
    }    
    @Override
    public int getRowCount() {
        return listaComentario.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();       
        comentario = (Comentario) listaComentario.get(rowIndex);
        
        switch (columnIndex) {
          
            case 0:objeto = comentario.getCid();break;
            case 1:objeto = new SectorDaoImp().getSector(comentario.getSid()).getDescripcion();break;
            case 2:objeto = comentario.getDescripcion();break;

            
        }      
        return objeto;
    }
    
    private String[] cabeceras = {
        "Codigo", "Sector", "Motivo"        
    };
    
    public Comentario Consulta(int col) {
        return (Comentario) listaComentario.get(col);
    }
    
    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
    public void addElement(Object nuevoElemento){
        listaComentario.add((Comentario)nuevoElemento);        
        actualizar();
    }
    
    public Comentario getComentario(int fila){
        return listaComentario.get(fila);
    }
    
    public void removeElement(Object elemento)
    {
        listaComentario.remove(elemento);
        actualizar();
    }
    
    
}
