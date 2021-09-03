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
public class DatosVO {
    private String datId,usuId,datNombre ;

    public DatosVO() {
    }

    public DatosVO(String datId, String usuId, String datNombre) {
        this.datId = datId;
        this.usuId = usuId;
        this.datNombre = datNombre;
    }


    public String getDatId() {
        return datId;
    }

    public void setDatId(String datId) {
        this.datId = datId;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getDatNombre() {
        return datNombre;
    }

    public void setDatNombre(String datNombre) {
        this.datNombre = datNombre;
    }
    
    
}
