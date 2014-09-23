package co.tecnomati.java.asistenciavideotel.dominio;
// Generated 23/09/2014 15:09:47 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Marcacion generated by hbm2java
 */
public class Marcacion  implements java.io.Serializable {


     private Integer maid;
     private Asistencia asistencia;
     private Date entrada;
     private Date salida;
     private Byte etolerancia;
     private Byte stolerancia;
     private Boolean modificado;
     private Date fmodificado;
     private Boolean estado;
     private Boolean etimarcacion;
     private Byte mintardanzae;
     private Byte mintardanzas;
     private Boolean etiextram;
     private Boolean etiextrad;

    public Marcacion() {
    }

    public Marcacion(Asistencia asistencia, Date entrada, Date salida, Byte etolerancia, Byte stolerancia, Boolean modificado, Date fmodificado, Boolean estado, Boolean etimarcacion, Byte mintardanzae, Byte mintardanzas, Boolean etiextram, Boolean etiextrad) {
       this.asistencia = asistencia;
       this.entrada = entrada;
       this.salida = salida;
       this.etolerancia = etolerancia;
       this.stolerancia = stolerancia;
       this.modificado = modificado;
       this.fmodificado = fmodificado;
       this.estado = estado;
       this.etimarcacion = etimarcacion;
       this.mintardanzae = mintardanzae;
       this.mintardanzas = mintardanzas;
       this.etiextram = etiextram;
       this.etiextrad = etiextrad;
    }
   
    public Integer getMaid() {
        return this.maid;
    }
    
    public void setMaid(Integer maid) {
        this.maid = maid;
    }
    public Asistencia getAsistencia() {
        return this.asistencia;
    }
    
    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
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
    public Byte getEtolerancia() {
        return this.etolerancia;
    }
    
    public void setEtolerancia(Byte etolerancia) {
        this.etolerancia = etolerancia;
    }
    public Byte getStolerancia() {
        return this.stolerancia;
    }
    
    public void setStolerancia(Byte stolerancia) {
        this.stolerancia = stolerancia;
    }
    public Boolean getModificado() {
        return this.modificado;
    }
    
    public void setModificado(Boolean modificado) {
        this.modificado = modificado;
    }
    public Date getFmodificado() {
        return this.fmodificado;
    }
    
    public void setFmodificado(Date fmodificado) {
        this.fmodificado = fmodificado;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Boolean getEtimarcacion() {
        return this.etimarcacion;
    }
    
    public void setEtimarcacion(Boolean etimarcacion) {
        this.etimarcacion = etimarcacion;
    }
    public Byte getMintardanzae() {
        return this.mintardanzae;
    }
    
    public void setMintardanzae(Byte mintardanzae) {
        this.mintardanzae = mintardanzae;
    }
    public Byte getMintardanzas() {
        return this.mintardanzas;
    }
    
    public void setMintardanzas(Byte mintardanzas) {
        this.mintardanzas = mintardanzas;
    }
    public Boolean getEtiextram() {
        return this.etiextram;
    }
    
    public void setEtiextram(Boolean etiextram) {
        this.etiextram = etiextram;
    }
    public Boolean getEtiextrad() {
        return this.etiextrad;
    }
    
    public void setEtiextrad(Boolean etiextrad) {
        this.etiextrad = etiextrad;
    }




}


