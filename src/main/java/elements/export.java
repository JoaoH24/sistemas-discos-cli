package elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francis
 */
public class export {

// Métodos constructor
    public export() {
    }

// Métodos especiales    
    public void crearArchivo(String nameFile) throws IOException{
        File archivo = new File(nameFile);
        try {
            if (archivo.createNewFile()) {
                System.out.println("Se creo el archivo de manera correcta");
            }
        } catch (Exception e) {
            System.out.println("No se pudo crear el archivo");
        }
    }
}
