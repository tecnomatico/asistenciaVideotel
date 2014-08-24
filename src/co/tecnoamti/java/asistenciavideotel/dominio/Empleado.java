package co.tecnoamti.java.asistenciavideotel.dominio;
// Generated 24/08/2014 18:19:14 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private byte eid;
     private Sector sector;
     private Integer dni;
     private String telefono;
     private String apellido;
     private String nombre;
     private byte[] foto;
     private Boolean estado;
     private Boolean administrador;
     private String clave;
     private Set<Horario> horarios = new HashSet<Horario>(0);
     private Set<Asistencia> asistencias = new HashSet<Asistencia>(0);

    public Empleado() {
    }

	
    public Empleado(byte eid) {
        this.eid = eid;
    }
    public Empleado(byte eid, Sector sector, Integer dni, String telefono, String apellido, String nombre, byte[] foto, Boolean estado, Boolean administrador, String clave, Set<Horario> horarios, Set<Asistencia> asistencias) {
       this.eid = eid;
       this.sector = sector;
       this.dni = dni;
       this.telefono = telefono;
       this.apellido = apellido;
       this.nombre = nombre;
       this.foto = foto;
       this.estado = estado;
       this.administrador = administrador;
       this.clave = clave;
       this.horarios = horarios;
       this.asistencias = asistencias;
    }
   
    public byte getEid() {
        return this.eid;
    }
    
    public void setEid(byte eid) {
        this.eid = eid;
    }
    public Sector getSector() {
        return this.sector;
    }
    
    public void setSector(Sector sector) {
        this.sector = sector;
    }
    public Integer getDni() {
        return this.dni;
    }
    
    public void setDni(Integer dni) {
        this.dni = dni;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public byte[] getFoto() {
        return this.foto;
    }
    
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Boolean getAdministrador() {
        return this.administrador;
    }
    
    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public Set<Horario> getHorarios() {
        return this.horarios;
    }
    
    public void setHorarios(Set<Horario> horarios) {
        this.horarios = horarios;
    }
    public Set<Asistencia> getAsistencias() {
        return this.asistencias;
    }
    
    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }




}


