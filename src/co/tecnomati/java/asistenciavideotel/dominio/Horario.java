package co.tecnomati.java.asistenciavideotel.dominio;
// Generated 26/09/2014 17:58:10 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Horario generated by hbm2java
 */
public class Horario  implements java.io.Serializable {


     private Integer hid;
     private Date entrada;
     private Date salida;
     private Byte etihorario;
     private Set<Turno> turnos = new HashSet<Turno>(0);

    public Horario() {
    }

    public Horario(Date entrada, Date salida, Byte etihorario, Set<Turno> turnos) {
       this.entrada = entrada;
       this.salida = salida;
       this.etihorario = etihorario;
       this.turnos = turnos;
    }
   
    public Integer getHid() {
        return this.hid;
    }
    
    public void setHid(Integer hid) {
        this.hid = hid;
    }
    public Date getEntrada() {
        return this.entrada;
    }
    
    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }
    public Date getSalida() {
        return this.salida;
    }
    
    public void setSalida(Date salida) {
        this.salida = salida;
    }
    public Byte getEtihorario() {
        return this.etihorario;
    }
    
    public void setEtihorario(Byte etihorario) {
        this.etihorario = etihorario;
    }
    public Set<Turno> getTurnos() {
        return this.turnos;
    }
    
    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }




}


