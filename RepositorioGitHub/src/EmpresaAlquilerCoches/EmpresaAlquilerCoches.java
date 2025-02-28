package EmpresaAlquilerCoches;

import java.util.*;

public class EmpresaAlquilerCoches {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		double[][] gastos = new double[25][3]; //valores estaticos variables
		double[][] ingresos = new double[25][30]; //valores estaticos variables

		int numVehiculos = 0;
		int opcion = 0;

		while (opcion != 4) {
			System.out.println("----------------------MENU---------------------");
			System.out.println("1º Insertar datos de gastos y alquileres");
			System.out.println("2º Calcular rentabilidad de todos los vehiculos");
			System.out.println("3º Mostrar vehiculos introducidos");
			System.out.println("4º Salir");
			System.out.println("-----------------------------------------------");
			opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				numVehiculos = insertarDatosGastosAlquileres(entrada, gastos, ingresos, numVehiculos);
				break;
			case 2:
				calcularRentabilidad(gastos, ingresos, numVehiculos);
				break;
			case 3:
				mostrarVehiculosIntroducidos(ingresos, gastos, numVehiculos);
				break;
			case 4:
				System.out.println("Saliendo del programa");
				break;
			default:
				System.out.println("Error desconocido (404)");
			}
		}//while
		entrada.close();
	}//main

	public static int insertarDatosGastosAlquileres(Scanner entrada, double[][] gastos, double[][] ingresos,
			int numVehiculos) {
		if (numVehiculos >= 25) {
			System.out.println("Se ha alcanzado el límite de 25 vehículos.");
			return numVehiculos;
		}

		introducirGastosCoche(entrada, gastos, numVehiculos);
		introducirIngresosCoche(entrada, ingresos, numVehiculos);
		numVehiculos++;

		System.out.println("¿Deseas introducir datos de otro vehículo? (S/N)");
		char continuar = entrada.next().charAt(0);

		if (continuar == 'S' || continuar == 's') {
			numVehiculos = insertarDatosGastosAlquileres(entrada, gastos, ingresos, numVehiculos);
		}

		return numVehiculos;
	}// insertarDatosGastosAlquileres

	public static void introducirGastosCoche(Scanner entrada, double[][] gastos, int numVehiculos) {
		System.out.println("Introduce los gastos de compra:");
		gastos[numVehiculos][0] = entrada.nextDouble();
		System.out.println("Introduce los gastos de impuestos:");
		gastos[numVehiculos][1] = entrada.nextDouble();
		System.out.println("Introduce los gastos de seguro:");
		gastos[numVehiculos][2] = entrada.nextDouble();

	}//introducirGastosCoche

	public static void introducirIngresosCoche(Scanner entrada, double[][] ingresos, int numVehiculos) {
		int contadorIngresos = 0;
		int continuar = 0;

		do {
			if (continuar != -1) {
				System.out.println("Introduce los ingresos generados por alquileres:");
				ingresos[numVehiculos][contadorIngresos] = entrada.nextDouble();
				contadorIngresos++;

				System.out.println("¿Deseas continuar? (-1 para salir)");
				continuar = entrada.nextInt();

			}
		} while (continuar != -1 && contadorIngresos < 30);
	}//introducirIngresosCoche

	public static void mostrarVehiculosIntroducidos(double[][] ingresos, double[][] gastos, int numVehiculos) {
		for (int i = 0; i < numVehiculos; i++) {
			System.out.println("Vehículo " + (i + 1) + ":");
			System.out.println("Coste de adquisición: " + gastos[i][0] + ", Impuestos: " + gastos[i][1] + ", Seguro: "
					+ gastos[i][2]);

			System.out.println("Ingresos:");
			for (int j = 0; j < ingresos[i].length; j++) {
				if (ingresos[i][j] > 0) {
					System.out.println("Ingreso " + (j + 1) + ": " + ingresos[i][j]);
				}
			}
			System.out.println("-----------------------------------------------");
		}
	}//mostrarVehiculosIntroducidos

	public static void calcularRentabilidad(double[][] gastos, double[][] ingresos, int numVehiculos) {
		double sumaGastosEmpresa = 0;
		double sumaIngresosEmpresa = 0;

		for (int i = 0; i < numVehiculos; i++) {
			double sumaGastosVehiculo = gastos[i][0] + gastos[i][1] + gastos[i][2];
			double sumaIngresosVehiculo = 0;
			for (int j = 0; j < ingresos[i].length; j++) {
				sumaIngresosVehiculo += ingresos[i][j];
			}
			double rentabilidadVehiculo = sumaIngresosVehiculo - sumaGastosVehiculo;
			System.out.println("Vehículo " + (i + 1) + ":");
			System.out.println("Suma de gastos: " + sumaGastosVehiculo + ", Suma de ingresos: " + sumaIngresosVehiculo
					+ ", Rentabilidad: " + rentabilidadVehiculo);

			sumaGastosEmpresa += sumaGastosVehiculo;
			sumaIngresosEmpresa += sumaIngresosVehiculo;

		} // for

		double rentabilidadEmpresa = sumaIngresosEmpresa - sumaGastosEmpresa;
		System.out.println("-----------------------------------------------");
		System.out.println("Rentabilidad de la empresa:");
		System.out.println("Suma de gastos: " + sumaGastosEmpresa + ", Suma de ingresos: " + sumaIngresosEmpresa
				+ ", Rentabilidad: " + rentabilidadEmpresa);
	}// calcularRentabilidad
}// class
