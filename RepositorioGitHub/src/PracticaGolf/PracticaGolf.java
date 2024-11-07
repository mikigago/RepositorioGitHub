package PracticaGolf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PracticaGolf {

    public static void main(String[] args) {

        int golpesJugador = 0;
        int numeroHoyo = 1;
        int puntuacionTotal = 0;
        int puntuacionHoyo = 0;

        char jugadorSeRetira = ' ';

        String clasificacionPuntos = "";
        String clasificacionCompleta = "";
        String Albatros = "Albatros", Eagle = "Eagle", Birdie = "Birdie", Par = "Par", Bogey = "Bogey",
                DoubleBogey = "Double Bogey", TripleBogey = "Triple Bogey";

        Scanner entrada = new Scanner(System.in);

        do {

            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.println("Introduce el número de golpes realizado en el hoyo número " + numeroHoyo + " :");
                    golpesJugador = entrada.nextInt();
                    entradaValida = true;
                } catch (InputMismatchException errorLetra) {
                    System.out.println("Introduce un número por favor");
                    entrada.next();
                }
            }

            if (golpesJugador > 7 || golpesJugador < 1) {
                System.out.println("--Número de golpes nulo, vuelve a introducirlo--");
            } else {
                puntuacionHoyo = golpesJugador - 4;
                puntuacionTotal += puntuacionHoyo;
                numeroHoyo++;
            }

            if (puntuacionHoyo == 0) {
                clasificacionPuntos = Par;
            } else if (puntuacionHoyo == 1) {
                clasificacionPuntos = Bogey;
            } else if (puntuacionHoyo == 2) {
                clasificacionPuntos = DoubleBogey;
            } else if (puntuacionHoyo == 3) {
                clasificacionPuntos = TripleBogey;
            } else if (puntuacionHoyo == -1) {
                clasificacionPuntos = Birdie;
            } else if (puntuacionHoyo == -2) {
                clasificacionPuntos = Eagle;
            } else if (puntuacionHoyo == -3) {
                clasificacionPuntos = Albatros;
            } else {
                clasificacionPuntos = "Sin clasificación";
            }

            if (!clasificacionCompleta.isEmpty()) {
                clasificacionCompleta = clasificacionCompleta.concat(", ");
            }
            clasificacionCompleta = clasificacionCompleta.concat(clasificacionPuntos);

            if (numeroHoyo <= 18) {
                System.out.println("¿Quieres ir al siguiente hoyo? (S/N)");
                jugadorSeRetira = entrada.next().charAt(0);
                entrada.nextLine();

                if (jugadorSeRetira == 'N' || jugadorSeRetira == 'n') {
                    break;
                }
            }

        } while (numeroHoyo <= 18);

        System.out.println("------------------------------PUNTUACIONES---------------------------");
        System.out.println("Número total de golpes: " + (puntuacionTotal + 4 * (numeroHoyo - 1)));
        System.out.println("Puntuación total: " + puntuacionTotal);
        System.out.println("Clasificación por puntos: " + clasificacionCompleta);
        System.out.println("¡Gracias por su participación!");
        System.out.println("--------------------------------------------------------------------");
        entrada.close();
    }//main
}//class
