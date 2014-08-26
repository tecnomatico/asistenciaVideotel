package co.tecnomati.java.asistenciavideotel.dominio;
// Generated 24/08/2014 18:19:14 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Empresa generated by hbm2java
 */
public class Empresa  implements java.io.Serializable {


     private byte id;
     private String nombre;
     private String telefono;
     private String domicilio;
     private byte[] logo;
     private Set<Sector> sectors = new HashSet<Sector>(0);

    public Empresa() {
    }

	
    public Empresa(byte id) {
        this.id = id;
    }
    public Empresa(byte id, String nombre, String telefono, String domicilio, byte[] logo, Set<Sector> sectors) {
       this.id = id;
       this.nombre = nombre;
       this.telefono = telefono;
       this.domicilio = domicilio;
       this.logo = logo;
       this.sectors = sectors;
    }
   
    public byte getId() {
        return this.id;
    }
    
    public void setId(byte id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDomicilio() {
        return this.domicilio;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public byte[] getLogo() {
        return this.logo;
    }
    
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    public Set<Sector> getSectors() {
        return this.sectors;
    }
    
    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
    }




}

