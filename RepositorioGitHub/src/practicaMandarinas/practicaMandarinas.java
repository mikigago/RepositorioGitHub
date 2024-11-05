package practicaMandarinas;

import java.util.*;

public class practicaMandarinas {
//actualizado
	public static void main(String[] args) {

		double cantidad_satsumas = 0;
		double cantidad_clemenules = 0;
		double cantidad_oronull = 0;

		double stock_satsumas = 0;
		double stock_clemenules = 0;
		double stock_oronull = 0;

		double meter_satsumas = 0;
		double meter_clemenules = 0;
		double meter_oronull = 0;

		double total_meter_satsumas = 0;
		double total_meter_clemenules = 0;
		double total_meter_oronull = 0;

		double sacar_satsumas = 0;
		double sacar_clemenules = 0;
		double sacar_oronull = 0;

		double total_sacar_satsumas = 0;
		double total_sacar_clemenules = 0;
		double total_sacar_oronull = 0;

		int camion_entrada = 0;
		int camion_salida = 0;

		int opcion_tipo_mandarina = 0;
		String entradaSalidaMandarinas;
		char usuarioContinua = ' ';

		boolean continuar = true;

		Scanner entrada = new Scanner(System.in);

		while (continuar) {

			System.out.println("------------MENU-----------");
			System.out.println("1. Mandarina Satsumma");
			System.out.println("2. Mandarina Clemenules");
			System.out.println("3. Mandarina Oronull");
			System.out.println("4. Salir del programa");
			System.out.println("---------------------------");
			opcion_tipo_mandarina = entrada.nextInt();

			switch (opcion_tipo_mandarina) {

			case 1:
				System.out.println("¿ Quieres introducir o extraer Mandarina Satsumma? (I/E)");
				entradaSalidaMandarinas = entrada.next();

				if (entradaSalidaMandarinas.equalsIgnoreCase("introducir")
						|| entradaSalidaMandarinas.equalsIgnoreCase("I")) {

					try {
						System.out.println(
								"Introduce la cantidad que quieres meter en el stock de Mandarina Satsumma : ");
						meter_satsumas = entrada.nextDouble();

						stock_satsumas = stock_satsumas + meter_satsumas;

						camion_entrada++;

						total_meter_satsumas = total_meter_satsumas + meter_satsumas;

						System.out.println("Inserccion completada");

					} catch (InputMismatchException insercion_erronea) {
						System.out.println("La inserccion no se ha podido completar, vuelve a intentarlo");
						entrada.next();
					} // catch

				} // entrada if

				if (entradaSalidaMandarinas.equalsIgnoreCase("extraer")
						|| entradaSalidaMandarinas.equalsIgnoreCase("E")) {

					try {
						System.out.println(
								"Introduce la cantidad que quieres extraer en el stock de Mandarina Satsumma : ");
						sacar_satsumas = entrada.nextDouble();

						stock_satsumas = stock_satsumas - sacar_satsumas;

						camion_salida++;

						total_sacar_satsumas = total_sacar_satsumas + sacar_satsumas;

						System.out.println("Extraccion completada");

					} catch (InputMismatchException extraccion_erronea) {
						System.out.println("La extraccion no se ha podido completar, vuelve a intentarlo");
						entrada.next();

					} // catch

				} // salida if
				break;

			case 2:

				System.out.println("¿ Quieres introducir o extraer Mandarina Clemenules? (I/E)");
				entradaSalidaMandarinas = entrada.next();

				if (entradaSalidaMandarinas.equalsIgnoreCase("introducir")
						|| entradaSalidaMandarinas.equalsIgnoreCase("I")) {

					try {
						System.out.println(
								"Introduce la cantidad que quieres meter en el stock de Mandarina Clemenules: ");
						meter_clemenules = entrada.nextDouble();

						stock_clemenules = stock_clemenules + meter_clemenules;

						camion_entrada++;

						total_meter_clemenules = total_meter_clemenules + meter_clemenules;

						System.out.println("Inserccion completada");

					} catch (InputMismatchException insercion_erronea) {
						System.out.println("La inserccion no se ha podido completar, vuelve a intentarlo");
						entrada.next();
					} // catch

				} // entrada if

				if (entradaSalidaMandarinas.equalsIgnoreCase("extraer")
						|| entradaSalidaMandarinas.equalsIgnoreCase("E")) {

					try {
						System.out.println(
								"Introduce la cantidad que quieres extraer en el stock de Mandarina Clemenules : ");
						sacar_clemenules = entrada.nextDouble();

						stock_clemenules = stock_clemenules - sacar_clemenules;

						camion_salida++;

						total_sacar_clemenules = total_sacar_clemenules + sacar_clemenules;

						System.out.println("Extraccion completada");

					} catch (InputMismatchException extraccion_erronea) {
						System.out.println("La extraccion no se ha podido completar, vuelve a intentarlo");
						entrada.next();

					} // catch

				} // salida if
				break;

			case 3:

				System.out.println("¿ Quieres introducir o extraer Mandarina Oronull? (I/E)");
				entradaSalidaMandarinas = entrada.next();

				if (entradaSalidaMandarinas.equalsIgnoreCase("introducir")
						|| entradaSalidaMandarinas.equalsIgnoreCase("I")) {

					try {
						System.out
								.println("Introduce la cantidad que quieres meter en el stock de Mandarina Oronull: ");
						meter_oronull = entrada.nextDouble();

						stock_oronull = stock_oronull + meter_oronull;

						camion_entrada++;

						total_meter_oronull = total_meter_oronull + meter_oronull;

						System.out.println("Inserccion completada");

					} catch (InputMismatchException insercion_erronea) {
						System.out.println("La inserccion no se ha podido completar, vuelve a intentarlo");
						entrada.next();
					} // catch

				} // entrada if

				if (entradaSalidaMandarinas.equalsIgnoreCase("extraer")
						|| entradaSalidaMandarinas.equalsIgnoreCase("E")) {

					try {
						System.out.println(
								"Introduce la cantidad que quieres extraer en el stock de Mandarina Oronull : ");
						sacar_oronull = entrada.nextDouble();

						stock_oronull = stock_oronull - sacar_oronull;

						camion_salida++;

						total_sacar_oronull = total_sacar_oronull + sacar_oronull;

						System.out.println("Extraccion completada");

					} catch (InputMismatchException extraccion_erronea) {
						System.out.println("La extraccion no se ha podido completar, vuelve a intentarlo");
						entrada.next();

					} // catch

				} // salida if
				break;

			case 4:
				continuar = false;
				break;

			default:
				System.out.println("ERROR 404");
				break;
			}

			if (continuar) {
				try {
					System.out.println("¿ Deseas continuar ? (S/N)");
					usuarioContinua = entrada.next().charAt(0);

					if (usuarioContinua == 'N' || usuarioContinua == 'n') {
						continuar = false;
					} else if (usuarioContinua != 'S' && usuarioContinua != 's') {
						System.out.println("Introduce S o N por favor, no otro caracter");
					}
				} catch (InputMismatchException charErroneo) {
					System.out.println("Introduce S o N por favor, no un numero");
					entrada.next();
				} // catch
			}
		} // while

		System.out.println("----------------------Stock---------------------");
		System.out.println("Tienes en stock un total de : " + stock_satsumas + " Kg");
		System.out.println("Tienes en stock un total de : " + stock_clemenules + " Kg");
		System.out.println("Tienes en stock un total de : " + stock_oronull + " Kg \n");

		System.out.println("----------------------Entarda---------------------");
		System.out.println("Acaba de entrar un total de : " + total_meter_satsumas + " Kg de Satsumas");
		System.out.println("Acaba de entrar un total de : " + total_meter_clemenules + " Kg de Clemenules");
		System.out.println("Acaba de entrar un total de : " + total_meter_oronull + " Kg de Oronull \n");

		System.out.println("----------------------Salida---------------------");
		System.out.println("Acaba de entrar un total de : " + total_sacar_satsumas + " Kg de Satsumas");
		System.out.println("Acaba de entrar un total de : " + total_sacar_clemenules + " Kg de Clemenules");
		System.out.println("Acaba de entrar un total de : " + total_sacar_oronull + " Kg de Oronull \n");

		System.out.println("----------------------Camiones entrada-----------");
		System.out.println("El numero de camiones que han entrado es de : " + camion_entrada + "\n");
		System.out.println("----------------------Camiones salida------------");
		System.out.println("El numero de camiones que han salido es de : " + camion_salida);

	}// main

}// class
