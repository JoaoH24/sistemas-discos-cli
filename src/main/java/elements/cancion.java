package elements;

import java.io.Serializable;

/**
 *
 * @author Francis
 */
public class cancion implements Serializable {
    
// Atributos
    private String nombreArtista;
    private String nombreDisco;
    private int numeroCancion;
    private String nombreCancion;
    private String tiempoCancion;

// Método constructor
    public cancion(String nombreArtista, String nombreDisco, int numeroCancion, String nombreCancion, String tiempoCancion) {
        this.nombreArtista = nombreArtista;
        this.nombreDisco = nombreDisco;
        this.numeroCancion = numeroCancion;
        this.nombreCancion = nombreCancion;
        this.tiempoCancion = tiempoCancion;
    }

// Métodos accesores
    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public void setNumeroCancion(int numeroCancion) {
        this.numeroCancion = numeroCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public void setTiempoCancion(String tiempoCancion) {
        this.tiempoCancion = tiempoCancion;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public int getNumeroCancion() {
        return numeroCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public String getTiempoCancion() {
        return tiempoCancion;
    }

}
