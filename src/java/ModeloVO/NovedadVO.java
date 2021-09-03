/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;


public class NovedadVO {
    private String idNovedad, descripcion, fechaInicio, fechaFin, idTipoNovedad, idAsistencia;

    public NovedadVO() {
    }

    public NovedadVO(String idNovedad, String descripcion, String fechaInicio, String fechaFin, String idTipoNovedad, String idAsistencia) {
        this.idNovedad = idNovedad;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idTipoNovedad = idTipoNovedad;
        this.idAsistencia = idAsistencia;
    }

    
    
    public String getIdNovedad() {
        return idNovedad;
    }

    public void setIdNovedad(String idNovedad) {
        this.idNovedad = idNovedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(String idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
    }

    public String getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(String idAsistencia) {
        this.idAsistencia = idAsistencia;
    }
    
}
