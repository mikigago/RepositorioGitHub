package ConcursoCanino;

import java.util.*;

public class ConcursoCanino {

	final static int NUM_PERROS = 4;

	final static int NUM_JURADOS = 3;

	final static int NUM_CATEGORIAS = 3;

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		Random random = new Random();

		int[] sumaPuntosPerros = new int[NUM_PERROS];

		String cat = "";

		String jur = "";

		String dog = "";

		int[][][] puntuaciones = new int[NUM_PERROS][NUM_JURADOS][NUM_CATEGORIAS];

		for (int x = 0; x < NUM_PERROS; x++) {

			for (int y = 0; y < NUM_JURADOS; y++) {

				for (int z = 0; z < NUM_CATEGORIAS; z++) {

					puntuaciones[x][y][z] = random.nextInt(10) + 1;

				} // x

			} // y

		} // z

		for (int x = 0; x < NUM_PERROS; x++) {
			switch (x) {

			case 0:
				dog = "Thor";

				break;

			case 1:
				dog = "Bobby";

				break;

			case 2:
				dog = "Corasario";

				break;

			case 3:
				dog = "Pluto";

				break;

			}
			System.out.println("------------------------------");

			System.out.println("El perro con el nombre de : " + dog);

			System.out.println();

			for (int y = 0; y < NUM_JURADOS; y++) {

				switch (y) {

				case 0:
					jur = "Luisa";

					break;

				case 1:
					jur = "Pedro";

					break;

				case 2:
					jur = "Ana";

					break;

				}

				System.out.println("Segun " + jur + " tiene unas puntuaciones de:");

				System.out.println();

				for (int z = 0; z < NUM_CATEGORIAS; z++) {

					switch (z) {

					case 0:
						cat = "Belleza" + ", ";

						break;

					case 1:
						cat = "Agilidad" + ", ";

						break;

					case 2:
						cat = "Inteligencia" + ", ";

						break;

					}

					System.out.print(cat);

					System.out.println(puntuaciones[x][y][z]);

					System.out.println();

				} // x

			} // y

		} // z

		for (int x = 0; x < NUM_PERROS; x++) {

			for (int y = 0; y < NUM_JURADOS; y++) {

				for (int z = 0; z < NUM_CATEGORIAS; z++) {

					sumaPuntosPerros[x] = sumaPuntosPerros[x] + puntuaciones[x][y][z];

				} // x

			} // y

			switch (x) {

			case 0:
				dog = "Thor";

				break;

			case 1:
				dog = "Bobby";

				break;

			case 2:
				dog = "Corasario";

				break;

			case 3:
				dog = "Pluto";

				break;

			}

			System.out.println("Puntuacion del perro con nombre " + dog + ": " + sumaPuntosPerros[x]);

		} // z

		int perroGanador = Integer.MIN_VALUE;
		int posMax = 0;

		for (int x = 0; x < NUM_PERROS; x++) {
			if (sumaPuntosPerros[x] > perroGanador) {
				perroGanador = sumaPuntosPerros[x];
				posMax = x;
			}
		}

		switch (posMax) {

		case 0:
			dog = "Thor";

			break;

		case 1:
			dog = "Bobby";

			break;

		case 2:
			dog = "Corasario";

			break;

		case 3:
			dog = "Pluto";

			break;

		case 4:
			dog = "Mauro";

			break;

		}
		System.out.println();
		System.out.println("El perro ganador es: " + dog);

	}// class

}// main
