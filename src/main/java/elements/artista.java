package elements;

import java.io.Serializable;

/**
 *
 * @author Francis
 */
public class artista implements Serializable {
    
// Atributos
    private String dni;
    private String nombre;
    private String nacionalidad;
    private String[] discosArtista;

// Método constructor
    public artista(String dni, String nombre, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.discosArtista = new String[10];
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

    public void setDiscosArtista(String[] discosArtista) {
        this.discosArtista = discosArtista;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String[] getDiscosArtista() {
        return discosArtista;
    }
    

// Métodos especiales
    public void agregarDisco(disco[] nwDisk) {
        if (nwDisk == null) {
            System.out.println("[!] No se detectaron discos Registrados");
            return;
        }

        int contador = 0;
        for (disco iter : nwDisk) {
            if (iter != null) {
                if (iter.getArtistaDisco().equals(getNombre())) {
                    getDiscosArtista()[contador++] = iter.getNombreDisco();
                }
            }
        }
    }
}
