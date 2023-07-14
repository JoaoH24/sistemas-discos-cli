package elements;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Francis
 */
public class artista {
    
// Atributos
    private String dni;
    private String nombre;
    private String nacionalidad;
    private ArrayList <String> discosArtista;

// Método constructor
    public artista(String dni, String nombre, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.discosArtista = new ArrayList();
    }

// Métodos accesores
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDiscosArtista(ArrayList<String> discosArtista) {
        this.discosArtista = discosArtista;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public ArrayList<String> getDiscosArtista() {
        return discosArtista;
    }

// Métodos especiales
    public ArrayList<String> agregarDisco(ArrayList <disco> nwDisk) {
        ArrayList <String> discosAutor = new ArrayList();
        for (disco iter : nwDisk) {
            if (iter.getArtistaDisco().equals(getNombre())) {
                discosAutor.add(iter.getNombreDisco());
            }
        }
        return discosAutor;
    }
}
