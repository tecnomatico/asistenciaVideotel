/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util.modeloTabla;

import co.tecnomati.java.asistenciavideotel.dominio.Horario;
import co.tecnomati.java.asistenciavideotel.dominio.Sector;
import co.tecnomati.java.asistenciavideotel.dominio.dao.HorarioDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.SectorDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.HorarioDaoImp;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.SectorDaoImp;
import co.tecnomati.java.asistenciavideotel.util.FechaUtil;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author AnahiAramayo
 */
public class ModeloHorario extends AbstractTableModel{
    Horario horario = new Horario();
    HorarioDao horarioDAO = new HorarioDaoImp();
    ArrayList<Horario> listaHorario = new ArrayList<Horario>();
   
    // tipo= 0  todo los conceptos
    //tipo=1   todos los conceptos menos los 5 conceptos de los formularios 
    public ModeloHorario() {            
        try {
            
            listaHorario = (ArrayList<Horario>) horarioDAO.listarHorarioOrdenadoXMomento();
        } catch (ClassCastException ex) {
            listaHorario = new ArrayList<Horario>();            
        }
    }
    
    public final void actualizar() {
        fireTableDataChanged();
    }    
    @Override
    public int getRowCount() {
        return listaHorario.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();       
        horario = (Horario) listaHorario.get(rowIndex);
        Calendar horaEntrada = FechaUtil.getCalendar(horario.getEntrada());
        Calendar horaSalida = FechaUtil.getCalendar(horario.getSalida());
        
        switch (columnIndex) {
          
            case 0:objeto = horario.getHid();break;
            case 1:objeto = FechaUtil.getHora_HHMM(horario.getEntrada());break;
            case 2:objeto = FechaUtil.getHora_HHMM(horario.getSalida());break;
            case 3:objeto = FechaUtil.getMomentoDelDia(horario.getEtihorario().intValue());
            break;

                    }      
        return objeto;
    }
    
    private String[] cabeceras = {
        "Codigo", "Entrada" , "Salida", "Momento"     
    };
    
    public Horario Consulta(int col) {
        return (Horario) listaHorario.get(col);
    }
    
    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
    public void addElement(Object nuevoElemento){
        listaHorario.add((Horario)nuevoElemento);        
        actualizar();
    }
    
    public Horario getHorario(int fila){
        return listaHorario.get(fila);
    }
    
    public void removeElement(Object elemento)
    {
        listaHorario.remove(elemento);
        actualizar();
    }
    
    
    
}
