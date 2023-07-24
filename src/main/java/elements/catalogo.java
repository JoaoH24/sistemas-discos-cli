package elements;

import java.util.ArrayList;

/**
 *
 * @author Francis
 */
public class catalogo {

// Atributos
    private String[] discos;
    private float precio;
    private int stock;
    private boolean estado;

// Métodos constructores    
    public catalogo() {
        this.discos = new String[10];
    }

// Métodos accesores
    public void setDiscos(String[] discos) {
        this.discos = discos;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String[] getDiscos() {
        return discos;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean isEstado() {
        return estado;
    }

// Métodos especiales    
    int contador = 0;
    public void agregarDiscoCatalogo(String discoSeleccionado) {
        if(contador>= 0 && contador < getDiscos().length){
            getDiscos()[contador++] = discoSeleccionado;
        }
        else {
            System.out.println("[!] El catalogo excedio la cantida de discos que puede almacenar");
        }
    }
}

