/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util.modeloTabla;

import co.tecnomati.java.asistenciavideotel.dominio.Asistencia;
import co.tecnomati.java.asistenciavideotel.dominio.Empleado;
import co.tecnomati.java.asistenciavideotel.dominio.Marcacion;
import co.tecnomati.java.asistenciavideotel.dominio.dao.MarcacionDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.MarcacionDaoImp;
import co.tecnomati.java.asistenciavideotel.util.FechaUtil;
import co.tecnomati.java.asistenciavideotel.vista.marcacion.GUIMarcacion;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author AnahiAramayo
 */
public class ModeloMarcacion extends AbstractTableModel{
    Marcacion marcacion = new Marcacion();
   MarcacionDao marcacionDAO = new MarcacionDaoImp();
    ArrayList<Marcacion> listaMarcacion = new ArrayList<Marcacion>();
    
    
   
    // tipo= 0  todo los conceptos
    //tipo=1   todos los conceptos menos los 5 conceptos de los formularios 
    public ModeloMarcacion() {            
        try {
            
            listaMarcacion = (ArrayList<Marcacion>) marcacionDAO.listarMarcacion();
        } catch (ClassCastException ex) {
            listaMarcacion = new ArrayList<Marcacion>();            
        }
    }
    
    public ModeloMarcacion(Date inicio, Date fin) {            
        try {
            
            listaMarcacion = (ArrayList<Marcacion>) marcacionDAO.listarMarcacion(inicio, fin);
        } catch (ClassCastException ex) {
            listaMarcacion = new ArrayList<Marcacion>();            
        }
    }
    
    public ModeloMarcacion(Empleado e, Date inicio, Date fin) {            
        try {
            if (e==null) {
                listaMarcacion = (ArrayList<Marcacion>) marcacionDAO.listarMarcacion(inicio, fin);
            } else {
                listaMarcacion = (ArrayList<Marcacion>) marcacionDAO.listarMarcacion(e, inicio, fin);
            }
            
        } catch (ClassCastException ex) {
            listaMarcacion = new ArrayList<Marcacion>();            
        }
    }
    
    public final void actualizar() {
        fireTableDataChanged();
    }    
    @Override
    public int getRowCount() {
        return listaMarcacion.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();       
        marcacion = (Marcacion) listaMarcacion.get(rowIndex);
        
        switch (columnIndex) {
            
            case 0:objeto = marcacion.getMaid();break;
            case 1:objeto = marcacion.getAsistencia().getEmpleado().getDni();break;
            case 2:objeto = marcacion.getAsistencia().getEmpleado().getApellido()+" "+marcacion.getAsistencia().getEmpleado().getNombre();break;
            case 3:objeto = FechaUtil.getFechaString10DDMMAAAA(marcacion.getAsistencia().getFecha());break;
            case 4:objeto = getEtiquetaMarcacion( marcacion.getEtimarcacion());break;
            case 5:objeto = FechaUtil.getHora_HHMM(marcacion.getEntrada());break;
            case 6:objeto = FechaUtil.getHora_HHMM(marcacion.getSalida());break;
            case 7:objeto = marcacion.getMintardanzae();break;
            case 8:objeto = marcacion.getMintardanzas();break;
            
         }      
        return objeto;
    }
    
    private String[] cabeceras = {
        "Id", "DNI" , "Empleado", "Fecha", "Etiqueta", "Entrada" , "Salida", "TE" , "TS"      
    };
    
    public Marcacion Consulta(int col) {
        return (Marcacion) listaMarcacion.get(col);
    }
    
    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
    public void addElement(Object nuevoElemento){
        listaMarcacion.add((Marcacion)nuevoElemento);        
        actualizar();
    }
    
    public Marcacion getMarcacion(int fila){
        return listaMarcacion.get(fila);
    }
    
    public void removeElement(Object elemento)
    {
        listaMarcacion.remove(elemento);
        actualizar();
    }

    private String getEtiquetaMarcacion(Byte etimarcacion) {
       String eti="";
          switch (etimarcacion) {
            
            case  GUIMarcacion.ETI_MARCACION_INCOMPLETA: eti= "INCOMPLETA";break;
            case  GUIMarcacion.ETI_MARCACION_NORMAL: eti= "NORMAL";break;
            case  GUIMarcacion.ETI_MARCACION_EXTRA: eti= "EXTRA";break;
            case  GUIMarcacion.ETI_MARCACION_AUSENTE: eti= "AUSENTE";break;
            }      
        
        return eti;
    }
    
    
    
}
