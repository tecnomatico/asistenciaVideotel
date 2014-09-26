/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.tecnomati.java.asistenciavideotel.util.modeloTabla;

import co.tecnomati.java.asistenciavideotel.dominio.Turno;
import co.tecnomati.java.asistenciavideotel.dominio.dao.TurnoDao;
import co.tecnomati.java.asistenciavideotel.dominio.dao.imp.TurnoDaoImp;
import co.tecnomati.java.asistenciavideotel.util.FechaUtil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joel
 */
public class ModeloTurno extends AbstractTableModel {
      Turno turno = new Turno();
    TurnoDao turnoDAO = new TurnoDaoImp();
    ArrayList<Turno> listaTurno = new ArrayList<Turno>();

    public ModeloTurno(int idEmpleado) {
        try {

            listaTurno = (ArrayList<Turno>) turnoDAO.listarTurno(idEmpleado);
        } catch (ClassCastException ex) {
            listaTurno = new ArrayList<Turno>();
        }
    }

    public final void actualizar() {
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaTurno.size();
    }

    @Override
    public int getColumnCount() {
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objeto = new Object();
        turno = (Turno) listaTurno.get(rowIndex);

        switch (columnIndex) {

            case 0:
                objeto = turno.getTid();
                break;
            case 1:
                objeto = FechaUtil.getDiaDeLaSemana_String(turno.getDiatrabajo().getDid());
                break;
            case 2:
                // hora de entrada
                objeto = FechaUtil.getHora_HHMM(turno.getHorario().getEntrada());
                break;
            case 3:
                //hora de salida
                objeto = FechaUtil.getHora_HHMM(turno.getHorario().getSalida());
                break;
            case 4:
                // minutos de tolerancia
                 objeto = FechaUtil.getMM(turno.getEtolerancia())+"'";
                break;
            case 5:
                objeto =  FechaUtil.getMM(turno.getStolerancia())+"'";
                break;
            case 6:
                // momento mañana tarde o noche
                 objeto = FechaUtil.getMomentoDelDia(turno.getHorario().getEtihorario());
                break;
            }
        return objeto;
    }
    private String[] cabeceras = {
        "id", "Dia", "Entrada", "Salida", "Tolerancia Entrada", "Tolerancia Salida","Momento"
    };

    public Turno Consulta(int col) {
        return (Turno) listaTurno.get(col);
    }

    @Override
    public String getColumnName(int column) {
        return cabeceras[column];
    }

    public void addElement(Object nuevoElemento) {
        listaTurno.add((Turno) nuevoElemento);
        actualizar();
    }

    public Turno get(int fila) {
        return listaTurno.get(fila);
    }

    public void removeElement(Object elemento) {
        listaTurno.remove(elemento);
        actualizar();
    }
}
