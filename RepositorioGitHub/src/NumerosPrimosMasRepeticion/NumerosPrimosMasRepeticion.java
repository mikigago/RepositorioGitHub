package NumerosPrimosMasRepeticion;

import java.util.*;

public class NumerosPrimosMasRepeticion {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int numUsuario = 0;
		int acumulador = 0;

		do {
			System.out.println("Introduce un numero del 1 al 100");
			numUsuario = entrada.nextInt();

			if (numUsuario < 1 || numUsuario > 100) {
				System.out.println("Numero introducidor incorrecto");
			}
		} while (numUsuario < 1 || numUsuario > 100);

		System.out.println("Numero introducido correctamente");
		
		for (int i = 1 ; i <= numUsuario ; i++) {
			
			if (i % 2 !=0 ) {
				
				for (int j = 0 ; j < i ; j++)
					
			System.out.print(i+" ");
			
			}
			System.out.println();
		}//for 
	}// main

}// class
