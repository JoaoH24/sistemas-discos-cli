package elements;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Francis
 */
public class disco implements Serializable {

// Atributos    
    private String codigoDisco;
    private String nombreDisco;
    private String artistaDisco;
    private String[] cancionDisco; 

// Método constructor
    public disco(String codigoDisco, String nombreDisco, String artistaDisco) {
        this.codigoDisco = codigoDisco;
        this.nombreDisco = nombreDisco;
        this.artistaDisco = artistaDisco;
        this.cancionDisco = new String[10];
    }    

// Métodos accesores
    public void setCodigoDisco(String codigoDisco) {
        this.codigoDisco = codigoDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public void setArtistaDisco(String artistaDisco) {
        this.artistaDisco = artistaDisco;
    }

    public void setCancionDisco(String[] cancionDisco) {
        this.cancionDisco = cancionDisco;
    }

    public String getCodigoDisco() {
        return codigoDisco;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public String getArtistaDisco() {
        return artistaDisco;
    }

    public String[] getCancionDisco() {
        return cancionDisco;
    }

// Métodos especiales
    public void agregarCancion(cancion[] nwCancion) {
        int contador = 0;
        for (cancion iter : nwCancion) {
            if(iter != null) {
                if (iter.getNombreDisco().equals(getNombreDisco())) {
                    getCancionDisco()[contador++] = iter.getNombreCancion();
                }
            }
        }
    }
}
