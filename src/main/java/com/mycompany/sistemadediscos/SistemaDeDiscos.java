package com.mycompany.sistemadediscos;

import elements.artista;
import elements.cancion;
import elements.catalogo;
import elements.disco;
import elements.export;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Francis
 */
public class SistemaDeDiscos {

    public static void main(String[] args) throws IOException {
        
        // Lista de objetos
        ArrayList <artista> listaArtistas = new ArrayList();
        ArrayList <cancion> listaCanciones = new ArrayList();
        ArrayList <disco> listaDiscos = new ArrayList();
        catalogo discosCatalogo = new catalogo();
        export datos = new export();
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        
        // Bucle del programa
        while (flag) {
            
            System.out.print("\033[H\033[2J");
            System.out.flush();
            
            System.out.println("------------------------------------------------");
            System.out.println("BIENDVENIDO A LA CASA DE DISCOS \"EL PIRATIN\"");
            System.out.println("------------------------------------------------");
            
            System.out.println("""
                               1. Registrar artista
                               2. Registrar canciones
                               3. Registrar discos
                               4. Mostrar artista
                               5. Mostrar canciones
                               6. Mostrar discos
                               7. Establecer precio del catalogo
                               8. Agregar disco al catalogo
                               9. Eliminar disco del catalogo
                               10. Vender catalogo
                               11. Exportar datos
                               12. Salir (esc)
                               """);
            System.out.print(">_ ");
            
            byte user = sc.nextByte();
            sc.nextLine();
            
            // Seleccion del usuario
            switch (user) {
                case 1:
                    {
                        System.out.println("------------------------------------------------");
                        
                        System.out.print("Ingrese el dni del artista: ");
                        String dni = sc.nextLine();
                        
                        System.out.print("Ingrese el nombre del artista: ");
                        String nombre = sc.nextLine();
                        
                        System.out.print("Ingrese la nacionalidad del artista: ");
                        String nacionalidad = sc.nextLine();

                        listaArtistas.add(new artista(dni, nombre, nacionalidad));
                        
                    }
                    break;
                case 2:
                    {
                        System.out.println("------------------------------------------------");
                        
                        System.out.print("Ingrese el nombre de la canción: ");
                        String nombreCancion = sc.nextLine();
                        
                        System.out.print("Ingrese el nombre del disco: ");
                        String nombreDisco = sc.nextLine();
                        
                        System.out.print("Ingrese el nombre del artista: ");
                        String nombreArtista = sc.nextLine();
                        
                        System.out.print("Ingrese el tiempo de duración de la canción: ");
                        String tiempoCancion = sc.nextLine();
                        
                        System.out.print("Ingrese el número de la canción: ");
                        byte numeroCancion = sc.nextByte();
                        sc.nextLine();
                        
                        listaCanciones.add(new cancion(nombreArtista, nombreDisco, numeroCancion, nombreCancion, tiempoCancion));
                        
                    }
                    break;
                case 3:
                    {
                        System.out.println("------------------------------------------------");
                        
                        System.out.print("Ingrese el código del disco: ");
                        String codigoDisco = sc.nextLine();
                        
                        System.out.print("Ingrese el nombre del disco: ");
                        String nombreDisco = sc.nextLine();
                        
                        System.out.print("Ingrese el artista del disco: ");
                        String artistaDisco = sc.nextLine();
                        
                        listaDiscos.add(new disco(codigoDisco, nombreDisco, artistaDisco));
                        
                    }
                    break;
                
                case 4:
                    {
                        System.out.println("------------------------------------------------");

                        System.out.println("LOS ARTISTAS REGISTRADOS SON");
                        for (artista artist : listaArtistas) {
                            artist.setDiscosArtista(artist.agregarDisco(listaDiscos));
                            System.out.println("Nombre: " + artist.getNombre());
                            System.out.println("DNI: " + artist.getDni());
                            System.out.println("Nacionalidad: " + artist.getNacionalidad());
                            System.out.println("Discos: " + artist.getDiscosArtista().toString());

//                            System.out.println("------------------------------------------------");
                        }   
                    }   break;
                    
                case 5:
                    {                        
                        System.out.println("------------------------------------------------");
                        
                        System.out.println("LAS CANCIONES REGISTRADAS SON");
                        for (cancion music : listaCanciones) {
                            System.out.println("Canción: " + music.getNombreCancion());
                            System.out.println("Artista: " + music.getNombreArtista());
                            System.out.println("Disco: " + music.getNombreDisco());
                            System.out.println("Duración: " + music.getTiempoCancion());
                            System.out.println("N°: " + music.getNumeroCancion());
                            
//                            System.out.println("------------------------------------------------");
                        }          
                    }
                    break;
                    
                case 6:
                    {                     
                        System.out.println("------------------------------------------------");
                        
                        System.out.println("LOS DISCOS REGISTRADOS SON");
                        for (disco disk : listaDiscos) {
                            disk.setCancionDisco(disk.agregarCancion(listaCanciones));
                            System.out.println("Código: " + disk.getCodigoDisco());
                            System.out.println("Disco: " + disk.getNombreDisco());
                            System.out.println("Artista: " + disk.getArtistaDisco());
                            System.out.println("Canciones: " + disk.getCancionDisco().toString());
                            
//                            System.out.println("------------------------------------------------");
                        }       
                    }
                    break;
                    
                case 7:
                    {  
                        System.out.println("------------------------------------------------");
                        
                        System.out.println("Ingrese el precio del catalogo: ");
                        discosCatalogo.setPrecio(sc.nextFloat());
                        System.out.println("Ingrese la cantidad de stock que tiene el catalogo: ");
                        
                        discosCatalogo.setStock(sc.nextInt());
                        if (discosCatalogo.getStock() > 0) {
                            discosCatalogo.setEstado(true);
                        }
                        else {
                            discosCatalogo.setEstado(false);
                        }
                        
                    }
                    break;
            
                case 8:
                    {
                        
                        System.out.println("------------------------------------------------");
                        System.out.println("LOS DISCOS DISPONIBLES SON");
                        System.out.println("------------------------------------------------");
                        
                        
                        int cont = 0;
                        for (disco disk : listaDiscos) {
                            System.out.println((cont+1) + ". " + disk.getNombreDisco());
                            cont++;
                        }
                        
                        System.out.println("Seleccione el disco que desea agregar al catalogo:");
                        int numeroDisco = sc.nextInt();
                        discosCatalogo.getDiscos().add(discosCatalogo.agregarDiscoCatalogo(listaDiscos, (numeroDisco-1)));   
                        
                        System.out.println("------------------------------------------------");
                        
                    }   
                    break;
                    
                case 9:
                    {    
                        System.out.println("------------------------------------------------");
                        System.out.println("EL CATALOGO TIENE LOS SIGUIENTES DISCOS");
                        System.out.println("------------------------------------------------");
                        
                        int cont = 0;
                        for (String disk:discosCatalogo.getDiscos()) {
                            System.out.println((cont+1) + ". " + disk);
                            cont++;
                        }
                        
                        System.out.println("Seleccione el disco que desea retirar del catalogo:");
                        int numeroDisco = sc.nextInt(); 
                        discosCatalogo.getDiscos().remove((numeroDisco-1));
                        
                    }   
                    break;
                    
                case 10:
                    {
                        System.out.println("-------------------------------------------");
                        System.out.println("EL CATALOGO CONTIENE LOS SIGUIENTES DISCOS");
                        System.out.println("-------------------------------------------");
                        
                        int cont = 0;
                        for (String disk:discosCatalogo.getDiscos()) {
                            System.out.println((cont+1) + ". " + disk);
                            cont++;
                        }
                        
                        System.out.println("-------------------------------------------");
                        
                        System.out.println("Precio catalogo: " + discosCatalogo.getPrecio());
                        System.out.println("Stock disponible: " + discosCatalogo.getStock());
                        System.out.println("Estado: " + discosCatalogo.isEstado());

                        System.out.println("-------------------------------------------");
                        
                        System.out.println("Ingrese la cantidad de catalogos que desea comprar: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();
                        float total = cantidad * discosCatalogo.getPrecio();
                        
                        System.out.println("------------------------------------------------");
                        System.out.println("El MONTO TOTAL A PAGAR ES: " + total);
                        System.out.println("------------------------------------------------");
                        
                    }
                    break;
                    
                case 11:
                    {
                        datos.crearArchivo("Artistas.txt");
                        datos.crearArchivo("Canciones.txt");
                        datos.crearArchivo("Discos.txt");
                        datos.crearArchivo("Venta.txt");
                    
                            try (FileWriter escribirArtistas = new FileWriter("Artistas.txt", true);
                            FileWriter escribirCanciones = new FileWriter("Canciones.txt", true);
                            FileWriter escribirDiscos = new FileWriter("Discos.txt", true);
                            FileWriter escribirVenta = new FileWriter("Venta.txt", true)) {

                            for (artista artist : listaArtistas) {
                                escribirArtistas.write("------------------------------------------------\n");
                                escribirArtistas.write("Nombre: " + artist.getNombre() + "\n");
                                escribirArtistas.write("DNI: " + artist.getDni() + "\n");
                                escribirArtistas.write("Nacionalidad: " + artist.getNacionalidad() + "\n");
                                escribirArtistas.write("Discos: " + artist.getDiscosArtista().toString() + "\n");
                                escribirArtistas.write("------------------------------------------------\n");
                            }

                            for (cancion music : listaCanciones) {
                                escribirCanciones.write("------------------------------------------------\n");
                                escribirCanciones.write("Canción: " + music.getNombreCancion() + "\n");
                                escribirCanciones.write("Artista: " + music.getNombreArtista() + "\n");
                                escribirCanciones.write("Disco: " + music.getNombreDisco() + "\n");
                                escribirCanciones.write("Duración: " + music.getTiempoCancion() + "\n");
                                escribirCanciones.write("N°: " + music.getNumeroCancion() + "\n");
                                escribirCanciones.write("------------------------------------------------\n");
                            }

                            for (disco disk : listaDiscos) {
                                escribirDiscos.write("------------------------------------------------\n");
                                escribirDiscos.write("Código: " + disk.getCodigoDisco() + "\n");
                                escribirDiscos.write("Disco: " + disk.getNombreDisco() + "\n");
                                escribirDiscos.write("Artista: " + disk.getArtistaDisco() + "\n");
                                escribirDiscos.write("Canciones: " + disk.getCancionDisco().toString() + "\n");
                                escribirDiscos.write("------------------------------------------------\n");
                            }

                            escribirVenta.write("------------------------------------------------\n");
                            escribirVenta.write("Precio catalogo: " + discosCatalogo.getPrecio() + "\n");
                            escribirVenta.write("Stock disponible: " + discosCatalogo.getStock() + "\n");
                            escribirVenta.write("Estado: " + discosCatalogo.isEstado() + "\n");
                            escribirVenta.write("------------------------------------------------\n");

                            System.out.println("Los datos se exportaron de manera correcta");

                        } catch (IOException ex) {
                            System.out.println("No se pudieron exportar los datos");
                        }
                    }
                    break;
                    
                default:
                    flag = false;
                    break;
            }
            
        }
        
        sc.close();
 
    }
}