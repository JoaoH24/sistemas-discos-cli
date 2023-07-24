package com.mycompany.sistemadediscos;

import elements.artista;
import elements.cancion;
import elements.catalogo;
import elements.disco;
import elements.export;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaDeDiscos {

    public static void main(String[] args) throws IOException {
        
        final int N_ARTISTAS = 5;
        final int N_CANCIONES = 50;
        final int N_DISCOS = 5;
        
        artista[] listaArtistas = new artista[N_ARTISTAS];
        cancion[] listaCanciones = new cancion[N_CANCIONES];
        disco[] listaDiscos = new disco[N_DISCOS];
        catalogo discosCatalogo = new catalogo();
        export datos = new export();
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        byte contadorArtistas = 0;
        byte contadorCanciones = 0;
        byte contadorDiscos = 0;

        while (flag) {
            try {
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("------------------------------------------------");
                System.out.println("BIENVENIDO A LA CASA DE DISCOS \"EL PIRATIN\"");
                System.out.println("------------------------------------------------");

                System.out.println("""
                        1. Registrar artista
                        2. Registrar canciones
                        3. Registrar discos
                        4. Mostrar artistas
                        5. Mostrar canciones
                        6. Mostrar discos
                        7. Establecer precio del catálogo
                        8. Agregar disco al catálogo
                        9. Eliminar disco del catálogo
                        10. Vender catálogo
                        11. Exportar datos
                        12. Salir
                        """);
                System.out.print(">_ ");

                byte user = sc.nextByte();
                sc.nextLine();

                switch (user) {
                    case 1:
                        
                        if(contadorArtistas < listaArtistas.length) {
                            System.out.println("------------------------------------------------");

                            System.out.print("Ingrese el DNI del artista: ");
                            String dni = sc.nextLine();

                            System.out.print("Ingrese el nombre del artista: ");
                            String nombre = sc.nextLine();

                            System.out.print("Ingrese la nacionalidad del artista: ");
                            String nacionalidad = sc.nextLine();
                            listaArtistas[contadorArtistas++] = new artista(dni, nombre, nacionalidad);
                        }
                        else {
                            System.out.println("La lista de artistas esta llena");
                        }
                        
                        
                        break;

                    case 2:
                        
                        if(contadorCanciones < listaCanciones.length) {
                            System.out.println("------------------------------------------------");

                            System.out.print("Ingrese el nombre de la canción: ");
                            String nombreCancion = sc.nextLine();

                            System.out.print("Ingrese el nombre del disco: ");
                            String nombreDisco = sc.nextLine();

                            System.out.print("Ingrese el nombre del artista: ");
                            String nombreArtista = sc.nextLine();

                            System.out.print("Ingrese la duración de la canción: ");
                            String tiempoCancion = sc.nextLine();

                            System.out.print("Ingrese el número de la canción: ");
                            byte numeroCancion = sc.nextByte();
                            sc.nextLine();
                            
                            listaCanciones[contadorCanciones++] = new cancion(nombreArtista, nombreDisco, numeroCancion, nombreCancion, tiempoCancion);
                        }
                        else {
                            System.out.println("La lista de canciones esta llena");
                        }
                        
                        break;

                    case 3:

                        if(contadorDiscos < listaDiscos.length) {
                            System.out.println("------------------------------------------------");

                            System.out.print("Ingrese el código del disco: ");
                            String codigoDisco = sc.nextLine();

                            System.out.print("Ingrese el nombre del disco: ");
                            String nombreDiscoNuevo = sc.nextLine();

                            System.out.print("Ingrese el nombre del artista: ");
                            String nombreArtistaDisco = sc.nextLine();
                            listaDiscos[contadorDiscos++] = new disco(codigoDisco, nombreDiscoNuevo, nombreArtistaDisco);
                        }
                        else {
                            System.out.println("La lista de discos esta llena");
                        }
                        
                        break;

                    case 4:
                        System.out.println("------------------------------------------------");
                        System.out.println("LOS ARTISTAS REGISTRADOS SON");
                        System.out.println("------------------------------------------------");

                        for (artista artist : listaArtistas) {
                            if(artist != null) {
                                artist.agregarDisco(listaDiscos);
                                System.out.println("Nombre: " + artist.getNombre());
                                System.out.println("DNI: " + artist.getDni());
                                System.out.println("Nacionalidad: " + artist.getNacionalidad());
                                System.out.println("Discos: " + Arrays.toString(artist.getDiscosArtista()));
                                System.out.println("------------------------------------------------");
                            }
                        }
                        break;

                    case 5:
                        System.out.println("------------------------------------------------");
                        System.out.println("LAS CANCIONES REGISTRADAS SON");
                        System.out.println("------------------------------------------------");

                        for (cancion music : listaCanciones) {
                            if(music != null){
                                System.out.println("Canción: " + music.getNombreCancion());
                                System.out.println("Artista: " + music.getNombreArtista());
                                System.out.println("Disco: " + music.getNombreDisco());
                                System.out.println("Duración: " + music.getTiempoCancion());
                                System.out.println("N°: " + music.getNumeroCancion());
                                System.out.println("------------------------------------------------");
                            }
                        }
                        break;

                    case 6:
                        System.out.println("------------------------------------------------");
                        System.out.println("LOS DISCOS REGISTRADOS SON");
                        System.out.println("------------------------------------------------");

                        for (disco disk : listaDiscos) {
                            if(disk != null) {
                                disk.agregarCancion(listaCanciones);
                                System.out.println("Código: " + disk.getCodigoDisco());
                                System.out.println("Disco: " + disk.getNombreDisco());
                                System.out.println("Artista: " + disk.getArtistaDisco());
                                System.out.println("Canciones: " + Arrays.toString(disk.getCancionDisco()));
                                System.out.println("------------------------------------------------");
                            }
                        }
                        break;

                    case 7:
                        System.out.println("------------------------------------------------");
                        System.out.print("Ingrese el precio del catálogo: ");
                        discosCatalogo.setPrecio(sc.nextFloat());

                        System.out.print("Ingrese la cantidad de stock que tiene el catálogo: ");
                        discosCatalogo.setStock(sc.nextInt());
                        discosCatalogo.setEstado(discosCatalogo.getStock() > 0);
                        break;

                    case 8:
                        System.out.println("------------------------------------------------");
                        System.out.println("LOS DISCOS DISPONIBLES SON");
                        System.out.println("------------------------------------------------");

                        for (int i = 0; i < listaDiscos.length; i++) {
                            if(listaDiscos[i] != null){
                                System.out.println((i + 1) + ". " + listaDiscos[i].getNombreDisco());
                            }
                        }

                        System.out.println("Seleccione el disco que desea agregar al catálogo:");
                        int numeroDisco = sc.nextInt();

                        if (numeroDisco >= 1 && numeroDisco <= listaDiscos.length) {
                            String discoSeleccionado = listaDiscos[numeroDisco - 1].getNombreDisco();
                            discosCatalogo.agregarDiscoCatalogo(discoSeleccionado);
                        } else {
                            System.out.println("Opción inválida");
                        }
                        break;

                    case 9:
                        System.out.println("------------------------------------------------");
                        System.out.println("EL CATÁLOGO TIENE LOS SIGUIENTES DISCOS");
                        System.out.println("------------------------------------------------");

                        for (int i = 0; i < discosCatalogo.getDiscos().length; i++) {
                            if(discosCatalogo.getDiscos()[i] != null) {
                                System.out.println((i + 1) + ". " + discosCatalogo.getDiscos()[i]);
                            }
                        }

                        System.out.println("Seleccione el disco que desea retirar del catálogo:");
                        int numeroDiscoEliminar = sc.nextInt();

                        if (numeroDiscoEliminar >= 1 && numeroDiscoEliminar <= discosCatalogo.getDiscos().length) {
                            discosCatalogo.getDiscos()[numeroDiscoEliminar - 1] = null;
                        } else {
                            System.out.println("Opción inválida");
                        }
                        break;

                    case 10:
                        System.out.println("-------------------------------------------");
                        System.out.println("EL CATÁLOGO CONTIENE LOS SIGUIENTES DISCOS");
                        System.out.println("-------------------------------------------");

                        for (int i = 0; i < discosCatalogo.getDiscos().length; i++) {
                            System.out.println((i + 1) + ". " + discosCatalogo.getDiscos()[i]);
                        }

                        System.out.println("-------------------------------------------");

                        System.out.println("Precio del catálogo: " + discosCatalogo.getPrecio());
                        System.out.println("Stock disponible: " + discosCatalogo.getStock());
                        System.out.println("Estado: " + discosCatalogo.isEstado());

                        System.out.println("-------------------------------------------");

                        System.out.print("Ingrese la cantidad de catálogos que desea comprar: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();
                        discosCatalogo.setStock(discosCatalogo.getStock()-cantidad);
                        float total = cantidad * discosCatalogo.getPrecio();

                        System.out.println("------------------------------------------------");
                        System.out.println("EL MONTO TOTAL A PAGAR ES: " + total);
                        break;

                    case 11:
                        datos.crearArchivo("Artistas.txt");
                        datos.crearArchivo("Canciones.txt");
                        datos.crearArchivo("Discos.txt");
                        datos.crearArchivo("Venta.txt");

                        try (FileWriter escribirArtistas = new FileWriter("Artistas.txt", true);
                                FileWriter escribirCanciones = new FileWriter("Canciones.txt", true);
                                FileWriter escribirDiscos = new FileWriter("Discos.txt", true);
                                FileWriter escribirVenta = new FileWriter("Venta.txt", true)) {

                            for (artista artist : listaArtistas) {
                                if(artist != null) {
                                    escribirArtistas.write("------------------------------------------------\n");
                                    escribirArtistas.write("Nombre: " + artist.getNombre() + "\n");
                                    escribirArtistas.write("DNI: " + artist.getDni() + "\n");
                                    escribirArtistas.write("Nacionalidad: " + artist.getNacionalidad() + "\n");
                                    escribirArtistas.write("Discos: " + Arrays.toString(artist.getDiscosArtista()) + "\n");
                                    escribirArtistas.write("------------------------------------------------\n");
                                }
                            }

                            for (cancion music : listaCanciones) {
                                if(music != null) {
                                    escribirCanciones.write("------------------------------------------------\n");
                                    escribirCanciones.write("Canción: " + music.getNombreCancion() + "\n");
                                    escribirCanciones.write("Artista: " + music.getNombreArtista() + "\n");
                                    escribirCanciones.write("Disco: " + music.getNombreDisco() + "\n");
                                    escribirCanciones.write("Duración: " + music.getTiempoCancion() + "\n");
                                    escribirCanciones.write("N°: " + music.getNumeroCancion() + "\n");
                                    escribirCanciones.write("------------------------------------------------\n");
                                }
                            }

                            for (disco disk : listaDiscos) {
                                if(disk != null) {
                                    escribirDiscos.write("------------------------------------------------\n");
                                    escribirDiscos.write("Código: " + disk.getCodigoDisco() + "\n");
                                    escribirDiscos.write("Disco: " + disk.getNombreDisco() + "\n");
                                    escribirDiscos.write("Artista: " + disk.getArtistaDisco() + "\n");
                                    escribirDiscos.write("Canciones: " + Arrays.toString(disk.getCancionDisco()) + "\n");
                                    escribirDiscos.write("------------------------------------------------\n");
                                }
                            }

                            escribirVenta.write("------------------------------------------------\n");
                            escribirVenta.write("Precio catálogo: " + discosCatalogo.getPrecio() + "\n");
                            escribirVenta.write("Stock disponible: " + discosCatalogo.getStock() + "\n");
                            escribirVenta.write("Estado: " + discosCatalogo.isEstado() + "\n");
                            escribirVenta.write("------------------------------------------------\n");

                            System.out.println("Los datos se exportaron correctamente");

                        } catch (IOException ex) {
                            System.out.println("No se pudieron exportar los datos");
                        }
                        break;

                    case 12:
                        flag = false;
                        break;

                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Introduce un número válido.");
                sc.nextLine(); // Limpiar el búfer del escáner
            }
        }

        sc.close();
    }
}
