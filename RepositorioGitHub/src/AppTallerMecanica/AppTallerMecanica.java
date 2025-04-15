package AppTallerMecanica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AppTallerMecanica {

	static Scanner entrada = new Scanner(System.in);
	static Scanner entradaTXT = new Scanner(System.in);
	
	static ArrayList<Componente> historialMontaje = new ArrayList<>();

	public static void main(String[] args) {

		LinkedList<Componente> llmontajeDesmontaje = new LinkedList<>();
		

		boolean desmontajeRealizado = false;
		boolean continuar = true;
		int opcion;

		while (continuar) {
			System.out.println("------MENU-----");
			System.out.println("0. Salir");
			System.out.println("1. Desmontaje");
			System.out.println("2. Montaje");
			System.out.println("3. Historial");
			System.out.println("---------------");
			opcion = entrada.nextInt();

			switch (opcion) {

			case 0:
				break;

			case 1:

				if (desmontajeRealizado) {
					System.out.println("Ya se ha registrado un montaje");
				} else {
					registrarComponenteDesmontado(llmontajeDesmontaje);
					desmontajeRealizado = true;
				}
				break;

			case 2:
				registrarComponenteMontado(llmontajeDesmontaje);
				break;
				
			case 3:
				
				registrarHistorialMontaje();
				
				break;

			}// switch
		} // while

	}// main

	private static void registrarComponenteMontado(LinkedList<Componente> llmontajeDesmontaje) {

		Componente siguienteComponente = llmontajeDesmontaje.peek();

		char siguiente = ' ';

		if (llmontajeDesmontaje.isEmpty()) {
			System.out.println("Error - No hay ningun elemento a montar");
		} else {

			while (!llmontajeDesmontaje.isEmpty()) {

				siguienteComponente = llmontajeDesmontaje.pop();

				System.out.println("Este es el omponente a montar : " + siguienteComponente.toString());
				
                historialMontaje.add(siguienteComponente);

				System.out.println("¿Quieres ver cual es la proxima pieza a montar ? (S/N)");
				siguiente = entradaTXT.nextLine().charAt(0);

				if (siguiente != 'S' && siguiente != 's') {

					System.out.println("Montaje detenido");
					return;

				}
			} // while
			System.out.println("Montaje completado");
		} // else

	}// registrarComponenteMontado

	private static void registrarComponenteDesmontado(LinkedList<Componente> llmontajeDesmontaje) {

		
		boolean desmontajeTerminado = false;
		char respuesta = ' ';

		if (llmontajeDesmontaje.isEmpty()) {
			System.out.println("No hay ninguna pieza");
		}

		while (desmontajeTerminado == false) {

			System.out.println("Introuce el numero de serie de la pieza :");
			int numeroDeSerie = entrada.nextInt();

			System.out.println("Introduce el nombre de la pieza : ");
			String nombre = entradaTXT.nextLine();

			System.out.println("Introduce una breve descripcion :");
			String descripcion = entradaTXT.nextLine();

			Componente componente = new Componente(numeroDeSerie, nombre, descripcion);
			llmontajeDesmontaje.push(componente);

			System.out.println("¿ El desmontaje a terminado ? (S/N)");
			respuesta = entradaTXT.nextLine().charAt(0);

			if (respuesta == 'S' || respuesta == 's') {
				desmontajeTerminado = true;
			}
		} // while

		System.out.println("Desmontaje registrado correctamente");

	}// registrarCompoenteDesmontado
	
	 private static void registrarHistorialMontaje() {
	        if (historialMontaje.isEmpty()) {
	            System.out.println("No hay historial de piezas montadas.");
	        } else {
	            System.out.println("Historial de piezas montadas:");
	            for (Componente componente : historialMontaje) {
	                System.out.println(componente);
	            }
	        }
	    }// registrarHistorialMontaje
	 
}// AppTallerMecanica

class Componente {

	int numeroDeSerie;
	String nombre;
	String descripcion;

	public Componente() {

		this.numeroDeSerie = 0;
		this.nombre = "";
		this.descripcion = "";
	}

	public Componente(int numeroDeSerie, String nombre, String descripcion) {
		super();
		this.numeroDeSerie = numeroDeSerie;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Componente numeroDeSerie: " + numeroDeSerie + ", nombre: " + nombre + ", descripcion: " + descripcion;
	}

}// Componente
