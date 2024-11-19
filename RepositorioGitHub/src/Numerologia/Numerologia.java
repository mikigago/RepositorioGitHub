package Numerologia;

import java.util.*;

public class Numerologia {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Scanner entradaChar = new Scanner(System.in);

		String fraseUsuario = "";

		char continuar = ' ';

		do {

			System.out.println("Introduce una frase para analizar tu aura:");
			fraseUsuario = entrada.nextLine();

			boolean esPrimo = true;
			int longitud = fraseUsuario.length();

			esPrimo = true;

			if (longitud > 2) {

				for (int i = 2; i <= Math.sqrt(longitud); i++) {
					if (longitud % i == 0) {
						esPrimo = false;
						break;
					}
					//

				} // for

			} // if

			if (esPrimo) {
				System.out.println("Tu texto simboliza - Autoridad y gobierno");
				
			} else if (longitud % 2 != 0) {
				
				System.out.println("Tu texto simboliza - Perfección y Totalidad");
				
			} else {

				System.out.println("Tu texto simboliza - Entrega e Integridad");
			}

			System.out.println("¿ Deseas continuar ?");
			continuar = entradaChar.next().charAt(0);

		} while (continuar == 'S' || continuar == 's');

		entrada.close();
		entradaChar.close();
	}// main

}// class
