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
public class TipoNovedadVO {
    private String idTipoNovedad, tipoNovedad;
    
    public TipoNovedadVO(){
    }

    public TipoNovedadVO(String idTipoNovedad, String tipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
        this.tipoNovedad = tipoNovedad;
    }

    public String getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(String idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
    }

    public String getTipoNovedad() {
        return tipoNovedad;
    }

    public void setTipoNovedad(String tipoNovedad) {
        this.tipoNovedad = tipoNovedad;
    }
    

}
