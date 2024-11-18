package practicaGenerica;

import java.util.*;

public class PracticaGenerica {

	public static void main(String[] args) {

		// int
		Scanner entradaInt = new Scanner(System.in);
		int numerosDNI = 0;
		int numerosRelleno = 0;
		int opciones = 0;
		// char
		Scanner entrarChar = new Scanner(System.in);
		char entrarCuenta = ' ';
		char letraDNI = ' ';
		// Random
		Random random = new Random();
		// String
		Scanner entrarString = new Scanner(System.in);
		String nombreUsuario = "";
		String paisProvinciaLocalidad;
		String estadoCivil;
		String correoElectronico;

		for (int i = 0; i <= 4; i++) {
			numerosRelleno = random.nextInt(10000);
		}
		letraDNI = (char) (random.nextInt(26) + 'A');

		do {
			System.out.println("Introduce los cuatro primero numeros de tu DNI :");
			numerosDNI = entradaInt.nextInt();

			if (numerosDNI >= 1000 && numerosDNI <= 9999) {
				System.out.println("--Numero introducido correctamente-- ");
			} else {
				System.out.println("--Error al introudir el DNI, porfavor intentalo de nuevo-- \n");
			}

		} while (numerosDNI < 1000 || numerosDNI > 9999);

		System.out.println("¿ Quieres entrar en tu cuenta ? (S/N)");
		entrarCuenta = entrarChar.next().charAt(0);

		if (entrarCuenta == 'S' || entrarCuenta == 's') {
			System.out.println("--Entrando en tu cuenta--");

			System.out.println("Bienvenido " + numerosDNI + numerosRelleno + letraDNI);
			System.out.println("Indica que tipo de gestión quieres hacer porfavor :");
			System.out.println("1. Introducir tu nombre y apellidos");
			System.out.println("2. Introducir tu pais, provincia y localidad");
			System.out.println("3. Introducir tu estado civil");
			System.out.println("4. Introducir tu correo electronico");
			System.out.println("5. Salir del programa");
			opciones = entradaInt.nextInt();

			switch (opciones) {

			case 1:
				System.out.println("Introduce tu nombre y apellidos");
				nombreUsuario = entrarString.nextLine();
				break;
			case 2:
				System.out.println("Introduce tu pais, provincia y localidad");
				paisProvinciaLocalidad = entrarString.nextLine();
				break;
			case 3:
				System.out.println("Introduce tu estado civil");
				estadoCivil = entrarString.nextLine();
				break;
			case 4:
				System.out.println("Introduce tu correo electronico");
				correoElectronico = entrarString.nextLine();
				break;

			case 5:
				System.out.println("Saliendo del programa");
				return;
				

			}

		} else {
			System.out.println("--Saliendo del sistema--");
		}

	}// main

}// class
