package elements;

import java.util.ArrayList;

/**
 *
 * @author Francis
 */
public class catalogo {

// Atributos
    private ArrayList <String> discos;
    private float precio;
    private int stock;
    private boolean estado;

// Métodos constructores    
    public catalogo() {
        this.discos = new ArrayList();
    }

    public catalogo(float precio, int stock, boolean estado) {
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.discos = new ArrayList();
    }

// Métodos accesores
    public void setDiscos(ArrayList<String> discos) {
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

    public ArrayList<String> getDiscos() {
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
    public String agregarDiscoCatalogo(ArrayList<disco> diskCatalogo, int selectDisco) {
        return diskCatalogo.get(selectDisco).getNombreDisco();
    }
   
}

