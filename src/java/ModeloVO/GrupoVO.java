

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author David
 */
public class GrupoVO {
    private String idGrupo,nombre;
    private String estado, fechaInicio,fechaFin;
   
   public GrupoVO() {
    }

    public GrupoVO(String idGrupo, String nombre) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
    }
   
    public GrupoVO(String idGrupo,String nombre, String estado, String fechaInicio, String fechaFin) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }
    
     public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}
     