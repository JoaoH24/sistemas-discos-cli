package elements;

import java.util.ArrayList;

/**
 *
 * @author Francis
 */
public class venta {
    
// Atributos
    private String codigoVenta;
    private catalogo catalogoVenta;
    private float montoTotal;
    private String fechaVenta;

// Método constructor
    public venta(String codigoVenta, catalogo catalogoVenta, float montoTotal, String fechaVenta) {
        this.codigoVenta = codigoVenta;
        this.catalogoVenta = catalogoVenta;
        this.montoTotal = montoTotal;
        this.fechaVenta = fechaVenta;
    }

// Métodos accesores
    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public void setCatalogoVenta(catalogo catalogoVenta) {
        this.catalogoVenta = catalogoVenta;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public catalogo getCatalogoVenta() {
        return catalogoVenta;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }
   
}
