/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util.modeloTabla;

import co.tecnomati.java.asistenciavideotel.dominio.Empleado;
import co.tecnomati.java.asistenciavideotel.dominio.dao.EmpleadoDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.EmpleadoDaoImp;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloEmpleado extends AbstractTableModel {

    Empleado empleado = new Empleado();
    EmpleadoDao empleadoDAO = new EmpleadoDaoImp();
    ArrayList<Empleado> listaEmpleado = new ArrayList<Empleado>();

    public ModeloEmpleado() {
        try {

            listaEmpleado = (ArrayList<Empleado>) empleadoDAO.listarEmpleadoSector();
        } catch (ClassCastException ex) {
            listaEmpleado = new ArrayList<Empleado>();
        }
    }

    public final void actualizar() {
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaEmpleado.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();
        empleado = (Empleado) listaEmpleado.get(rowIndex);

        switch (columnIndex) {

            case 0:
                objeto = empleado.getEid();
                break;
            case 1:
                objeto = empleado.getDni();
                break;
            case 2:
                objeto = empleado.getApellido();
                break;
            case 3:
                objeto = empleado.getNombre();
                break;
            case 4:
                objeto = empleado.getTelefono();
                break;
            case 5:
                objeto = empleado.getSector().getDescripcion();
                break;

        }
        return objeto;
    }
    private String[] cabeceras = {
        "id", "DNI", "Apellido", "Nombre", "Telefono", "Sector"
    };

    public Empleado Consulta(int col) {
        return (Empleado) listaEmpleado.get(col);
    }

    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }

    public void addElement(Object nuevoElemento) {
        listaEmpleado.add((Empleado) nuevoElemento);
        actualizar();
    }

    public Empleado get(int fila) {
        return listaEmpleado.get(fila);
    }

    public void removeElement(Object elemento) {
        listaEmpleado.remove(elemento);
        actualizar();
    }
}
