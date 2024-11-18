package ProyectoCarerasFormulaUno;

import java.util.*;

public class ProyectoCarerasFormulaUno {
	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Scanner entradaChar = new Scanner(System.in);

		int minutosIdelfonso = 0;
		int segundosIdelfonso = 0;
		int totalSegundosIdelfonso = 0;
		int contadorIdelfonso = 0;
		int mejorTiempoIdelfonso = 0;

		int minutosDestapen = 0;
		int segundosDestapen = 0;
		int totalSegundosDestapen = 0;
		int contadorDestapen = 0;
		int mejorTiempoDestapen = 0;

		int contadorVueltas = 0;

		char continuar = ' ';

		int diferenciaSegundos = 0;

		System.out.println("Introduce los minutos de Idelfonso :");
		minutosIdelfonso = entrada.nextInt();

		System.out.println("Introduce los segundos de Idelfonso :");
		segundosIdelfonso = entrada.nextInt();

		System.out.println("Introduce los minutos de Destapen :");
		minutosDestapen = entrada.nextInt();

		System.out.println("Introduce los segundos de Destapen :");
		segundosDestapen = entrada.nextInt();

		totalSegundosIdelfonso = (minutosIdelfonso * 60) + segundosIdelfonso;
		totalSegundosDestapen = (minutosDestapen * 60) + segundosDestapen;

		do {
			contadorVueltas++;

			if (totalSegundosDestapen < totalSegundosIdelfonso) {

				diferenciaSegundos = totalSegundosDestapen - totalSegundosIdelfonso;

				System.out.println("El ganador de la vuelta " + contadorVueltas + " es Destapen por un diferecia de : "
						+ diferenciaSegundos);

				contadorDestapen++;

			} else {

				diferenciaSegundos = totalSegundosIdelfonso - totalSegundosDestapen;

				System.out.println("El ganador de la vuelta " + contadorVueltas
						+ " es Idelfonso por una diferencia de : " + diferenciaSegundos);

				contadorIdelfonso++;
			}

			if (totalSegundosIdelfonso < mejorTiempoIdelfonso) {

				mejorTiempoIdelfonso = totalSegundosIdelfonso;
				
				System.out.println("Idelfonso tiene una mejor vuelta "+contadorVueltas+" con un mejor tiempo de : "+mejorTiempoIdelfonso);
				
			} else if (mejorTiempoIdelfonso < totalSegundosIdelfonso -(totalSegundosIdelfonso*0.10)) {
				
				System.out.println("Idelfonso tiene una vuelta ,MUY BUENA");
				
			}else if (mejorTiempoIdelfonso <= (totalSegundosIdelfonso)) {
				
				System.out.println("Idelfonso tiene una vuelta BUENA");
				
			}else {
				
				System.out.println("Idelfonso tiene una vuelta MALA");
			}

			

			System.out.println("¿ Quieres continuar ?");
			continuar = entradaChar.next().charAt(0);

		} while (continuar == 'S' || continuar == 's');

	}// main
}// class
