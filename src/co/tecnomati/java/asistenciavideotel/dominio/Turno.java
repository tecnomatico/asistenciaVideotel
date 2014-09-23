package co.tecnomati.java.asistenciavideotel.dominio;
// Generated 23/09/2014 15:09:47 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Turno generated by hbm2java
 */
public class Turno  implements java.io.Serializable {


     private Integer tid;
     private Diatrabajo diatrabajo;
     private Horario horario;
     private Date etolerancia;
     private Date stolerancia;
     private Byte pturno;

    public Turno() {
    }

    public Turno(Diatrabajo diatrabajo, Horario horario, Date etolerancia, Date stolerancia, Byte pturno) {
       this.diatrabajo = diatrabajo;
       this.horario = horario;
       this.etolerancia = etolerancia;
       this.stolerancia = stolerancia;
       this.pturno = pturno;
    }
   
    public Integer getTid() {
        return this.tid;
    }
    
    public void setTid(Integer tid) {
        this.tid = tid;
    }
    public Diatrabajo getDiatrabajo() {
        return this.diatrabajo;
    }
    
    public void setDiatrabajo(Diatrabajo diatrabajo) {
        this.diatrabajo = diatrabajo;
    }
    public Horario getHorario() {
        return this.horario;
    }
    
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    public Date getEtolerancia() {
        return this.etolerancia;
    }
    
    public void setEtolerancia(Date etolerancia) {
        this.etolerancia = etolerancia;
    }
    public Date getStolerancia() {
        return this.stolerancia;
    }
    
    public void setStolerancia(Date stolerancia) {
        this.stolerancia = stolerancia;
    }
    public Byte getPturno() {
        return this.pturno;
    }
    
    public void setPturno(Byte pturno) {
        this.pturno = pturno;
    }




}


