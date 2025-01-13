package ProgramacionModular;

import java.util.*;

public class AppSueldos {

	public static void mostrarMenu() {
		System.out.println("------------APLICACION SUELDOS----------");
		System.out.println("1º Añadir un trabajador ");
		System.out.println("2º Obtener la posición de un trabajador ");
		System.out.println("3º Obtener el sueldo de un trabajador");
		System.out.println("4º Borrar un trabajador ");
		System.out.println("5º Modificar el sueldo de un trabajador");
		System.out.println("6º Listar los sueldos");
		System.out.println("7º Salir");
		System.out.println("---------------------------------------");
	}

	private static int insertarTrabajador(Scanner entrada, String[] nombres, double[] sueldos, int numElementos) {
	    System.out.println("Introduce el nombre del trabajador");
	    String nombre = entrada.nextLine().trim();
	    if (nombre.isEmpty()) {
	        System.out.println("El nombre no puede estar vacío");
	        return numElementos;
	    }

	    System.out.println("Introduce el sueldo ");
	    double sueldo = entrada.nextDouble();
	    entrada.nextLine();
	    if (sueldo <= 0) {
	        System.out.println("El sueldo debe ser positivo");
	        return numElementos;
	    }

	    if (buscarTrabajador(nombres, nombre, numElementos) == -1) {
	        int pos = numElementos;
	        for (int i = 0; i < numElementos; i++) {
	            if (nombres[i].compareTo(nombre) > 0) {
	                pos = i;
	                break;
	            }
	        }

	        for (int i = numElementos; i > pos; i--) {
	            nombres[i] = nombres[i - 1];
	            sueldos[i] = sueldos[i - 1];
	        }

	        nombres[pos] = nombre;
	        sueldos[pos] = sueldo;
	        numElementos++;
	    } else {
	        System.out.println("El trabajador ya existe y no se puede insertar");
	    }
	    return numElementos;
	}//insertarTrabajador


	private static void listarTrabajadores(String[] nombres, double[] sueldos, int numElementos) {
		for (int i = 0; i < numElementos; i++) {
			System.out.println("Trabajador: " + nombres[i] + " sueldo: " + sueldos[i]);
		}
	}// listarTrabajador

	private static int buscarTrabajador(String[] nombres, String nombre, int numElementos) {
		for (int i = 0; i < numElementos; i++) {
			if (nombres[i].equalsIgnoreCase(nombre))
				return i;
		}
		return -1;
	}// buscarTrabajador

	private static int obtenerSueldo(Scanner entrada, String[] nombres, double[] sueldos, int numElementos) {
		System.out.println("Introduce el nombre del trabajador");
		String nombre = entrada.nextLine();

		int pos = buscarTrabajador(nombres, nombre, numElementos);
		if (pos == -1) {
			System.out.println("No se ha encontrado");
		} else {
			System.out.println("El sueldo de " + nombres[pos] + " es " + sueldos[pos]);
		}
		return pos;
	}// ordenarSueldo

	private static void modificarSueldo(Scanner entrada, String[] nombres, double[] sueldos, int numElementos) {
		System.out.println("Introduce el nombre del trabajador para modificar su sueldo");
		String nombre = entrada.nextLine();
		System.out.println("Introduce el sueldo a modificar");
		double sueldo = entrada.nextDouble();
		entrada.nextLine();

		int pos = buscarTrabajador(nombres, nombre, numElementos);
		if (pos == -1) {
			System.out.println("Trabajador no encontrado");
		} else {
			sueldos[pos] = sueldo;
			System.out.println("Cambio de sueldo realizado");
		}
	}// modificarSueldo

	private static int borrarTrabajador(Scanner entrada, String[] nombres, double[] sueldos, int numElementos) {
		System.out.println("Introduce el nombre del trabajador a borrar");
		String nombre = entrada.nextLine();

		int pos = buscarTrabajador(nombres, nombre, numElementos);
		if (pos == -1) {
			System.out.println("Trabajador no encontrado, no se pudo borrar");
			return numElementos;
		} else {
			for (int i = pos; i < numElementos - 1; i++) {
				nombres[i] = nombres[i + 1];
				sueldos[i] = sueldos[i + 1];
			}
			numElementos--;
			return numElementos;
		}
	}// borrarTrabajadores

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		final int MAXSIZE = 100;
		String[] nombres = new String[MAXSIZE];
		double[] sueldos = new double[MAXSIZE];
		int numElementos = 4;
		int opcion;
		boolean continuar = true;

		nombres[0] = "Paco";
		nombres[1] = "Fernando";
		nombres[2] = "Maria";
		nombres[3] = "Marta";

		sueldos[0] = 1080;
		sueldos[1] = 2500;
		sueldos[2] = 2000;
		sueldos[3] = 1800;

		while (continuar) {
			mostrarMenu();
			opcion = entrada.nextInt();
			entrada.nextLine();

			switch (opcion) {
			case 1:
				numElementos = insertarTrabajador(entrada, nombres, sueldos, numElementos);
				break;
			case 2:
				System.out.println("Introduce un nombre");
				String nombre = entrada.nextLine();
				int res = buscarTrabajador(nombres, nombre, numElementos);
				if (res == -1)
					System.out.println("No encontrado");
				else
					System.out.println("Encontrado en la posicion: " + res);
				break;
			case 3:
				obtenerSueldo(entrada, nombres, sueldos, numElementos);
				break;
			case 4:
				numElementos = borrarTrabajador(entrada, nombres, sueldos, numElementos);
				break;
			case 5:
				modificarSueldo(entrada, nombres, sueldos, numElementos);
				break;
			case 6:
				listarTrabajadores(nombres, sueldos, numElementos);
				break;
			case 7:
				continuar = false;
				break;
			default:
				System.out.println("Opción no válida");
				break;
				
			}//switch
		}//while
		System.out.println("Saliendo del programa");
		entrada.close();
	}//main
}//class
