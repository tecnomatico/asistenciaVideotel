package co.tecnomati.java.asistenciavideotel.dominio;
// Generated 07/10/2014 15:05:01 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Diatrabajo generated by hbm2java
 */
public class Diatrabajo  implements java.io.Serializable {


     private Integer dtid;
     private Empleado empleado;
     private Integer did;
     private Byte nturno;
     private Set<Turno> turnos = new HashSet<Turno>(0);

    public Diatrabajo() {
    }

    public Diatrabajo(Empleado empleado, Integer did, Byte nturno, Set<Turno> turnos) {
       this.empleado = empleado;
       this.did = did;
       this.nturno = nturno;
       this.turnos = turnos;
    }
   
    public Integer getDtid() {
        return this.dtid;
    }
    
    public void setDtid(Integer dtid) {
        this.dtid = dtid;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Integer getDid() {
        return this.did;
    }
    
    public void setDid(Integer did) {
        this.did = did;
    }
    public Byte getNturno() {
        return this.nturno;
    }
    
    public void setNturno(Byte nturno) {
        this.nturno = nturno;
    }
    public Set<Turno> getTurnos() {
        return this.turnos;
    }
    
    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }




}


