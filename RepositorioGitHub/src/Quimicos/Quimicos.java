package Quimicos;

import java.util.*;

public class Quimicos {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		Scanner entradaChar = new Scanner(System.in);

		double capacidadCuba, nitrogenoNecesario, FosforoNecesario, potasioNecesario ;
		double fosforoStock = 0, nitrogenoStock = 0, potasioStock = 0, cantidadRecibida = 0;
		
		int seleccion;
		
		boolean continuar = true;
		
		System.out.println("Introduce la capacidad de la cuba");
		capacidadCuba = entrada.nextDouble();

		nitrogenoNecesario = capacidadCuba * 0.45;
		FosforoNecesario = capacidadCuba * 0.25;
		potasioNecesario = capacidadCuba * 0.3;

		do {

			System.out.println("FABRICA DE FERTILIZANTES");
			System.out.println("1. Entrada Nitrato Fosforico ");
			System.out.println("2. Entrada Urea ");
			System.out.println("3. Entrada Nitrato Potasico ");
			System.out.println("4. Entrada Potasio nitrico fosforico ");
			System.out.println("5. Salir ");
			seleccion = entrada.nextInt();

			if (seleccion != 5) {
				System.out.println("¿Cantidad recibida?");
				cantidadRecibida = entrada.nextDouble();
			}

			switch (seleccion) {

			case 1:
				nitrogenoStock = nitrogenoStock + cantidadRecibida * 0.10;
				fosforoStock = fosforoStock + cantidadRecibida * 0.25;

				break;

			case 2:
				nitrogenoStock = nitrogenoStock + cantidadRecibida * 0.20;
				potasioStock = potasioStock + cantidadRecibida * 0.15;
				break;

			case 3:

				nitrogenoStock = nitrogenoStock + cantidadRecibida * 0.40;
				potasioStock = potasioStock + cantidadRecibida * 0.10;
				break;

			case 4:
				nitrogenoStock = nitrogenoStock + cantidadRecibida * 0.11;
				fosforoStock = fosforoStock + cantidadRecibida * 0.30;
				fosforoStock = fosforoStock + cantidadRecibida * 0.15;
				break;

			case 5:
				continuar = false;
				break;

			}// switch

		} while (continuar);

		if (nitrogenoStock >= nitrogenoNecesario && fosforoStock >= FosforoNecesario
				&& potasioStock >= potasioNecesario) {
			System.out.println("Podemos iniciar el proceso de creacion del fertilizante");
			continuar = false;
		} else {
			System.out.println("Finalizado el programa sin iniciar creacion");
		}

	}// main

}// class