package co.tecnomati.java.asistenciavideotel.dominio;
// Generated 23/09/2014 15:09:47 by Hibernate Tools 3.2.1.GA



/**
 * Comentario generated by hbm2java
 */
public class Comentario  implements java.io.Serializable {


     private Integer cid;
     private Integer sid;
     private String descripcion;

    public Comentario() {
    }

    public Comentario(Integer sid, String descripcion) {
       this.sid = sid;
       this.descripcion = descripcion;
    }
   
    public Integer getCid() {
        return this.cid;
    }
    
    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public Integer getSid() {
        return this.sid;
    }
    
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


