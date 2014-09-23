/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util.modeloTabla;

import co.tecnomati.java.asistenciavideotel.dominio.Sector;
import co.tecnomati.java.asistenciavideotel.dominio.dao.SectorDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.SectorDaoImp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author AnahiAramayo
 */
public class ModeloSector extends AbstractTableModel{
    Sector sector = new Sector();
    SectorDao sectorDAO = new SectorDaoImp();
    ArrayList<Sector> listaSector = new ArrayList<Sector>();
   
    // tipo= 0  todo los conceptos
    //tipo=1   todos los conceptos menos los 5 conceptos de los formularios 
    public ModeloSector() {            
        try {
            
            listaSector = (ArrayList<Sector>) sectorDAO.listarSector();
        } catch (ClassCastException ex) {
            listaSector = new ArrayList<Sector>();            
        }
    }
    
    public final void actualizar() {
        fireTableDataChanged();
    }    
    @Override
    public int getRowCount() {
        return listaSector.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();       
        sector = (Sector) listaSector.get(rowIndex);
        
        switch (columnIndex) {
          
            case 0:objeto = sector.getSid();break;
            case 1:objeto = sector.getDescripcion();break;

            
        }      
        return objeto;
    }
    
    private String[] cabeceras = {
        "Codigo", "Descrpcion"      
    };
    
    public Sector Consulta(int col) {
        return (Sector) listaSector.get(col);
    }
    
    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }
    
    public void addElement(Object nuevoElemento){
        listaSector.add((Sector)nuevoElemento);        
        actualizar();
    }
    
    public Sector getSector(int fila){
        return listaSector.get(fila);
    }
    
    public void removeElement(Object elemento)
    {
        listaSector.remove(elemento);
        actualizar();
    }
    
    
}
