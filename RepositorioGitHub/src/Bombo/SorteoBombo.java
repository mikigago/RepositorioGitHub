package Bombo;

import java.util.Random;
import lombok.Getter;
import java.util.Scanner;

public class SorteoBombo {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Scanner entradaTxt = new Scanner(System.in);
		Random numRandom = new Random();

		int[] bombo = new int[100];
		int numElementos = 0;
		int opcion = 0;
		int num = 0;
		int numeroAleatorio = 0;
		int posicion = 0;

		while (opcion != 3) {

			System.out.println("---------MENU----------");
			System.out.println("1º Sacar bola");
			System.out.println("2º Listar ");
			System.out.println("3º Salir");
			System.out.println("-----------------------");
			opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				num = extraerBola(bombo, numElementos, numeroAleatorio, numRandom);
				numElementos = insercionOrdenada(bombo, numElementos, numeroAleatorio, num, posicion);

				break;
			case 2:
				listarNumeros(bombo, numElementos);
				break;
			case 3:
				System.out.println("Saliendo del programa");
				break;

			default:
				System.out.println("Error desconocido");

			}// switch

		} // while

	}// main

	public static int busquedaSecuencial(int[] bombo, int numElementos, int num) {

		for (int i = 0; i < numElementos; i++) {

			if (num == bombo[i]) {

				return i;
			}
		}
		return -1;

	}// busquedaSecuencial

	public static int extraerBola(int[] bombo, int numElementos, int numeroAleatorio, Random numRandom) {

		int comprobacion = 0;

		while (comprobacion != -1) {
			numeroAleatorio = numRandom.nextInt(6000) + 1;

			comprobacion = busquedaSecuencial(bombo, numElementos, numeroAleatorio);

		} // while
		System.out.println("Salio el numero " + numeroAleatorio);
		return numeroAleatorio;

	}// extraerBola1a

	public static int insercionOrdenada(int[] bombo, int numElementos, int numeroAleatorio, int num, int posicion) {

		if (numElementos == 100) {
			System.out.println("El vector esta lleno");
			return -1;
		}

		for (int i = 0; i < numElementos; i++) {
			if (bombo[i] < num) {
				posicion++;
			} else
				break;
		} // for localizar posicion de inserción

		for (int j = numElementos; j > posicion; j--) {
			bombo[j] = bombo[j - 1];
		} // for general el hueco
		bombo[posicion] = num;

		numElementos++;

		return numElementos;
	}// insercionOrdenada

	public static void listarNumeros(int[] bombo, int numElementos) {

		for (int i = 0; i < numElementos; i++) {
			System.out.println("Estos son los numeros que han salido " + i + "º " + bombo[i]);
		}
		
		
		

	}// listarNumeros

}// class
