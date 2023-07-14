package elements;

import java.util.ArrayList;

/**
 *
 * @author Francis
 */
public class disco {

// Atributos    
    private String codigoDisco;
    private String nombreDisco;
    private String artistaDisco;
    private ArrayList <String> cancionDisco; 

// Método constructor
    public disco(String codigoDisco, String nombreDisco, String artistaDisco) {
        this.codigoDisco = codigoDisco;
        this.nombreDisco = nombreDisco;
        this.artistaDisco = artistaDisco;
        this.cancionDisco = new ArrayList();
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

    public void setCancionDisco(ArrayList <String> cancionDisco) {
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

    public ArrayList<String> getCancionDisco() {
        return cancionDisco;
    }

// Métodos especiales
    public ArrayList<String> agregarCancion(ArrayList <cancion> nwCancion) {
        ArrayList <String> cancionesDisco = new ArrayList();
        for (cancion iter : nwCancion) {
            if (iter.getNombreDisco().equals(getNombreDisco())) {
                cancionesDisco.add(iter.getNombreCancion());
            }
        }
        return cancionesDisco;
    }
}
