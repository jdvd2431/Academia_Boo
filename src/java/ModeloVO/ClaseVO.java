/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Lanix
 */
public class ClaseVO {
  private String idClase,nombre,estado,cantidadSesiones;

    public ClaseVO() {
    }

    public ClaseVO(String idClase, String nombre, String estado,String cantidadSesiones) {
        this.idClase = idClase;
        this.nombre = nombre;
        this.estado = estado;
        this.cantidadSesiones=cantidadSesiones;
    }

    public String getIdClase() {
        return idClase;
    }

    public void setIdClase(String idClase) {
        this.idClase = idClase;
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

    public String getCantidadSesiones() {
        return cantidadSesiones;
    }

    public void setCantidadSesiones(String cantidadSesiones) {
        this.cantidadSesiones = cantidadSesiones;
    }
    
}
