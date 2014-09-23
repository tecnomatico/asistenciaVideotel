/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util;

import co.tecnomati.java.asistenciavideotel.util.modeloTabla.ModeloEmpleado;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author joel
 */
public class TablaUtil {
     /**
  * Oculta la primer columna de la tabla
  * @param tabla nombre de la tabla
  */   
 public static void ocultarIdTabla(JTable tabla){
        // hago que la columna 0 no sea visible
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
 /**
  * Setea el tamaño de una columna determinada de una tabla
  * @param tabla nombre de la tabla
  * @param col  numero de la columna dentro de la tabla
  * @param size tamaño que se quiere setear a la  columna col 
  */
 
 public static void setSizeColumnaTabla(JTable tabla, int col, int size){
        // hago que la columna 0 no sea visible
        tabla.getColumnModel().getColumn(col).setMaxWidth(size+50);
        tabla.getColumnModel().getColumn(col).setMinWidth(size);
        tabla.getColumnModel().getColumn(col).setPreferredWidth(size);
    }
    
 /**
  * Se utiliza para filtrar los registros de una tabla.
  * @param tabla tabla a filtrar
  * @param sorter 
  * @param caja caja donde se ingresa el texto para que la tabla realice filtro de acuerdo a una semejanza con el valor ingresado
  */ 
 public static void filtro(JTable tabla , TableRowSorter sorter,JTextField caja){
          if (tabla.getModel().getRowCount() != 0) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i).*" + caja.getText() + ".*"));
            tabla.setRowSorter(sorter);

    }
    }
 
/**
 * 
 * @param tbl
 * @return  devuelve true si se selecciono un registro de la tabla.
 * false de otro modo.
 */

 public static boolean isSeleccioFila(JTable tbl){
     boolean b= false;
     if (tbl.getSelectedRow()!=-1) {
         b= true;
     }
     return b;
 }
 
  
}
