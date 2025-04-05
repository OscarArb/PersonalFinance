
package Clases;

public class clsObjeto {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    private String id;
    private String detalle;
    private String fecha;
    private String valor;

    public clsObjeto() {
    }

    public clsObjeto(String id,String detalle, String fecha, String valor) {
        this.id = id;
        this.detalle = detalle;
        this.fecha = fecha;
        this.valor = valor;
    }
}
    