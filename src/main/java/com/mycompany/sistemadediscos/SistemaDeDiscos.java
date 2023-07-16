package com.mycompany.sistemadediscos;

import elements.artista;
import elements.cancion;
import elements.catalogo;
import elements.disco;
import elements.export;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaDeDiscos {

    public static void main(String[] args) throws IOException {

        ArrayList<artista> listaArtistas = new ArrayList<>();
        ArrayList<cancion> listaCanciones = new ArrayList<>();
        ArrayList<disco> listaDiscos = new ArrayList<>();
        catalogo discosCatalogo = new catalogo();
        export datos = new export();
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

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
                        12. Salir (esc)
                        """);
                System.out.print(">_ ");

                byte user = sc.nextByte();
                sc.nextLine();

                switch (user) {
                    case 1:
                        System.out.println("------------------------------------------------");

                        System.out.print("Ingrese el DNI del artista: ");
                        String dni = sc.nextLine();

                        System.out.print("Ingrese el nombre del artista: ");
                        String nombre = sc.nextLine();

                        System.out.print("Ingrese la nacionalidad del artista: ");
                        String nacionalidad = sc.nextLine();

                        listaArtistas.add(new artista(dni, nombre, nacionalidad));
                        break;

                    case 2:
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

                        listaCanciones.add(new cancion(nombreArtista, nombreDisco, numeroCancion, nombreCancion, tiempoCancion));
                        break;

                    case 3:
                        System.out.println("------------------------------------------------");

                        System.out.print("Ingrese el código del disco: ");
                        String codigoDisco = sc.nextLine();

                        System.out.print("Ingrese el nombre del disco: ");
                        String nombreDiscoNuevo = sc.nextLine();

                        System.out.print("Ingrese el nombre del artista: ");
                        String nombreArtistaDisco = sc.nextLine();

                        listaDiscos.add(new disco(codigoDisco, nombreDiscoNuevo, nombreArtistaDisco));
                        break;

                    case 4:
                        System.out.println("------------------------------------------------");
                        System.out.println("LOS ARTISTAS REGISTRADOS SON");
                        System.out.println("------------------------------------------------");

                        for (artista artist : listaArtistas) {
                            artist.setDiscosArtista(artist.agregarDisco(listaDiscos));
                            System.out.println("Nombre: " + artist.getNombre());
                            System.out.println("DNI: " + artist.getDni());
                            System.out.println("Nacionalidad: " + artist.getNacionalidad());
                            System.out.println("Discos: " + artist.getDiscosArtista().toString());
                            System.out.println("------------------------------------------------");
                        }
                        break;

                    case 5:
                        System.out.println("------------------------------------------------");
                        System.out.println("LAS CANCIONES REGISTRADAS SON");
                        System.out.println("------------------------------------------------");

                        for (cancion music : listaCanciones) {
                            System.out.println("Canción: " + music.getNombreCancion());
                            System.out.println("Artista: " + music.getNombreArtista());
                            System.out.println("Disco: " + music.getNombreDisco());
                            System.out.println("Duración: " + music.getTiempoCancion());
                            System.out.println("N°: " + music.getNumeroCancion());
                            System.out.println("------------------------------------------------");
                        }
                        break;

                    case 6:
                        System.out.println("------------------------------------------------");
                        System.out.println("LOS DISCOS REGISTRADOS SON");
                        System.out.println("------------------------------------------------");

                        for (disco disk : listaDiscos) {
                            disk.setCancionDisco(disk.agregarCancion(listaCanciones));
                            System.out.println("Código: " + disk.getCodigoDisco());
                            System.out.println("Disco: " + disk.getNombreDisco());
                            System.out.println("Artista: " + disk.getArtistaDisco());
                            System.out.println("Canciones: " + disk.getCancionDisco().toString());
                            System.out.println("------------------------------------------------");
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

                        for (int i = 0; i < listaDiscos.size(); i++) {
                            System.out.println((i + 1) + ". " + listaDiscos.get(i).getNombreDisco());
                        }

                        System.out.println("Seleccione el disco que desea agregar al catálogo:");
                        int numeroDisco = sc.nextInt();

                        if (numeroDisco >= 1 && numeroDisco <= listaDiscos.size()) {
                            String discoSeleccionado = listaDiscos.get(numeroDisco - 1).getNombreDisco();
                            discosCatalogo.getDiscos().add(discoSeleccionado);
                        } else {
                            System.out.println("Opción inválida");
                        }
                        break;

                    case 9:
                        System.out.println("------------------------------------------------");
                        System.out.println("EL CATÁLOGO TIENE LOS SIGUIENTES DISCOS");
                        System.out.println("------------------------------------------------");

                        for (int i = 0; i < discosCatalogo.getDiscos().size(); i++) {
                            System.out.println((i + 1) + ". " + discosCatalogo.getDiscos().get(i));
                        }

                        System.out.println("Seleccione el disco que desea retirar del catálogo:");
                        int numeroDiscoEliminar = sc.nextInt();

                        if (numeroDiscoEliminar >= 1 && numeroDiscoEliminar <= discosCatalogo.getDiscos().size()) {
                            discosCatalogo.getDiscos().remove(numeroDiscoEliminar - 1);
                        } else {
                            System.out.println("Opción inválida");
                        }
                        break;

                    case 10:
                        System.out.println("-------------------------------------------");
                        System.out.println("EL CATÁLOGO CONTIENE LOS SIGUIENTES DISCOS");
                        System.out.println("-------------------------------------------");

                        for (int i = 0; i < discosCatalogo.getDiscos().size(); i++) {
                            System.out.println((i + 1) + ". " + discosCatalogo.getDiscos().get(i));
                        }

                        System.out.println("-------------------------------------------");

                        System.out.println("Precio del catálogo: " + discosCatalogo.getPrecio());
                        System.out.println("Stock disponible: " + discosCatalogo.getStock());
                        System.out.println("Estado: " + discosCatalogo.isEstado());

                        System.out.println("-------------------------------------------");

                        System.out.print("Ingrese la cantidad de catálogos que desea comprar: ");
                        int cantidad = sc.nextInt();
                        sc.nextLine();
                        float total = cantidad * discosCatalogo.getPrecio();

                        System.out.println("------------------------------------------------");
                        System.out.println("EL MONTO TOTAL A PAGAR ES: " + total);
                        System.out.println("------------------------------------------------");
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
