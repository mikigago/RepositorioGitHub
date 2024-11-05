package CompeticionDardos;

import java.util.*;

public class CompeticionDardos {
	public static void main(String[] args) {

		String nombreEquipo = "";
		double puntuacion = 0.0;
		char introducirMasPuntuacionesJugadores = ' ';

		char introducirOtroEquipo = ' ';
		double puntuaciónMaxima = 0.0;
		String equipoGanador = "";

		Scanner entrada = new Scanner(System.in);

		System.out.println("Introduce el nombre del equipo :");
		nombreEquipo = entrada.nextLine();

		do {

			System.out.println("Introduce la puntuacion de los jugadores : ");
			puntuacion = entrada.nextDouble();

			if (puntuacion < 0 || puntuacion > 12) {
				System.out.println("Introduce una puntuación correcta");
				entrada.close();
				return;
			} else {
				System.out.println("--Puntuación introducida correctamente-- \n");

				System.out.println("¿ Quieres introducir otra puntuacion ? (S/N) ");
				introducirMasPuntuacionesJugadores = entrada.next().charAt(0);
				entrada.nextLine();

				if (puntuacion > puntuaciónMaxima) {
					puntuaciónMaxima = puntuacion;
					equipoGanador = nombreEquipo;
				}
			}

		} while (introducirMasPuntuacionesJugadores == 'S' || introducirMasPuntuacionesJugadores == 's');

		do {

			System.out.println(" ¿ Quieres introducir otro equipo ?");
			introducirOtroEquipo = entrada.next().charAt(0);
			entrada.nextLine();
			if (introducirOtroEquipo == 'S' || introducirOtroEquipo == 's') {

				System.out.println("Introduce el nombre del equipo :");
				nombreEquipo = entrada.nextLine();

			} else {
				System.out.println(
						"El equipo ganador es " + equipoGanador + " con una puntuacion de :" + puntuaciónMaxima);

				entrada.close();
				return;

			}

			System.out.println("Introduce la puntuacion de los jugadores : ");
			puntuacion = entrada.nextDouble();

			if (puntuacion < 0 || puntuacion > 12) {
				System.out.println("Introduce una puntuación correcta");
				entrada.close();
				return;
			} else {
				System.out.println("--Puntuación introducida correctamente-- \n");

				System.out.println("¿ Quieres introducir otra puntuacion ? (S/N) ");
				introducirMasPuntuacionesJugadores = entrada.next().charAt(0);
				entrada.nextLine();

				if (puntuacion > puntuaciónMaxima) {
					puntuaciónMaxima = puntuacion;
					equipoGanador = nombreEquipo;
				}
			}

		} while (introducirOtroEquipo == 'S' || introducirOtroEquipo == 's');

		System.out.println("El equipo ganador es " + equipoGanador + " con una puntuacion de :" + puntuaciónMaxima);
		entrada.close();
	}// class
}// main
