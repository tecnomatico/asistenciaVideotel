package co.tecnomati.java.asistenciavideotel.dominio;
// Generated 07/10/2014 15:05:01 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Asistencia generated by hbm2java
 */
public class Asistencia  implements java.io.Serializable {


     private Integer aid;
     private Empleado empleado;
     private Date fecha;
     private Byte mcontador;
     private Byte nturno;
     private Set<Marcacion> marcacions = new HashSet<Marcacion>(0);

    public Asistencia() {
    }

    public Asistencia(Empleado empleado, Date fecha, Byte mcontador, Byte nturno, Set<Marcacion> marcacions) {
       this.empleado = empleado;
       this.fecha = fecha;
       this.mcontador = mcontador;
       this.nturno = nturno;
       this.marcacions = marcacions;
    }
   
    public Integer getAid() {
        return this.aid;
    }
    
    public void setAid(Integer aid) {
        this.aid = aid;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Byte getMcontador() {
        return this.mcontador;
    }
    
    public void setMcontador(Byte mcontador) {
        this.mcontador = mcontador;
    }
    public Byte getNturno() {
        return this.nturno;
    }
    
    public void setNturno(Byte nturno) {
        this.nturno = nturno;
    }
    public Set<Marcacion> getMarcacions() {
        return this.marcacions;
    }
    
    public void setMarcacions(Set<Marcacion> marcacions) {
        this.marcacions = marcacions;
    }




}


