package aeropuerto;

import java.util.Scanner;

public class Aeropuerto {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int[] puertas = new int[20];
        boolean continuar = true;
        inicializarVector(puertas);

        while (continuar) {
            menu();
            int opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    gestionarAterrizaje(puertas, entrada);
                    break;
                case 2:
                    gestionarDespegue(puertas, entrada);
                    break;
                case 3:
                    listarPuertas(puertas);
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    continuar = false;
                    break;
                default:
                    System.out.println("ERROR - Opción no válida. Inténtalo de nuevo.");
            }
        }
        entrada.close();
    }//main

    private static void listarPuertas(int[] puertas) {
        for (int i = 0; i < puertas.length; i++) {
            if (puertas[i] == 0) {
                System.out.println("Puerta " + i + " libre");
            } else {
                System.out.println("Puerta " + i + " ocupada por vuelo " + puertas[i]);
            }
        }
    }//listarPuertas

    private static int buscarVuelo(int[] puertas, int numVuelo) {
        for (int i = 0; i < puertas.length; i++) {
            if (puertas[i] == numVuelo) {
                return i;
            }
        }
        return -1;
    }//buscarVuelo

    private static void gestionarDespegue(int[] puertas, Scanner entrada) {
        System.out.println("Introduce número de vuelo : ");
        int vuelo = entrada.nextInt();
        int puerta = buscarVuelo(puertas, vuelo);

        if (puerta == -1) {
            System.out.println("Vuelo no encontrado");
        } else {
            puertas[puerta] = 0;
            System.out.println("La puerta " + puerta + " ha quedado libre por el vuelo " + vuelo);
        }
    }//gestionarDespegue

    private static void gestionarAterrizaje(int[] puertas, Scanner entrada) {
        int puerta = buscarPuertaEmbarqueLibre(puertas);

        if (puerta != -1) {
            System.out.println("Introduce número de vuelo :");
            int vuelo = entrada.nextInt();
            puertas[puerta] = vuelo;
            System.out.println("El vuelo " + vuelo + " se ha asignado a la puerta " + puerta);
        } else {
            System.out.println("Todas las puertas de embarque ocupadas");
        }
    }//gestionarAterrizaje

    private static int buscarPuertaEmbarqueLibre(int[] puertas) {
        for (int i = 0; i < puertas.length; i++) {
            if (puertas[i] == 0) {
                return i;
            }
        }
        return -1;
    }//buscarPuertaLibre

    private static void inicializarVector(int[] puertas) {
        for (int i = 0; i < puertas.length; i++) {
            puertas[i] = 0;
        }
    }//inicializarVector

    private static void menu() {
        System.out.println("----------------- Menú ------------------");
        System.out.println("1. Gestionar el aterrizaje de un vuelo ");
        System.out.println("2. Gestionar el despegue de un vuelo");
        System.out.println("3. Mostrar estado de puertas de embarque");
        System.out.println("4. Salir");
        System.out.println("-----------------------------------------");
    }//menu
}
