package AppPuntuacionesArbitros;

import java.util.Scanner;
import java.util.Random;

class Puntuacion {
	private int estadoFisico;
	private int personalidad;
	private int acierto;
	private int puntosNegativos;

	public Puntuacion(int estadoFisico, int personalidad, int acierto, int puntosNegativos) {
		this.estadoFisico = Math.max(0, Math.min(10, estadoFisico));
		this.personalidad = Math.max(0, Math.min(10, personalidad));
		this.acierto = Math.max(0, Math.min(10, acierto));
		this.puntosNegativos = Math.max(0, puntosNegativos);

	} // Constructor Puntuacion

	public Puntuacion() {
		this.estadoFisico = 0;
		this.personalidad = 0;
		this.acierto = 0;
		this.puntosNegativos = 0;

	} // Ini constructor Puntuacion

	// Getters
	public int getEstadoFisico() {
		return estadoFisico;
	}

	public int getPersonalidad() {
		return personalidad;
	}

	public int getAcierto() {
		return acierto;
	}

	public int getPuntosNegativos() {
		return puntosNegativos;
	}

	// Setters
	public void setEstadoFisico(int estadoFisico) {
		this.estadoFisico = Math.max(0, Math.min(10, estadoFisico));
	}

	public void setPersonalidad(int personalidad) {
		this.personalidad = Math.max(0, Math.min(10, personalidad));
	}

	public void setAcierto(int acierto) {
		this.acierto = Math.max(0, Math.min(10, acierto));
	}

	public void setPuntosNegativos(int puntosNegativos) {
		this.puntosNegativos = Math.max(0, puntosNegativos);
	}

	public double promedio() {
		return (estadoFisico + personalidad + acierto) / 3.0 - (puntosNegativos * 0.25);
	}
}

class Arbitro {
	private String nombre;
	private String numeroColegiado;
	private Puntuacion[] puntuaciones;

	public Arbitro() {
		this.nombre = "";
		this.numeroColegiado = "";
		this.puntuaciones = new Puntuacion[40];
	} // Constructor inicializacion

	public Arbitro(String nombre, String numeroColegiado) {
		this.nombre = nombre;
		this.numeroColegiado = numeroColegiado;
		this.puntuaciones = new Puntuacion[40];
	} // Constructor

	// Getters
	public String getNombre() {
		return nombre;
	}

	public String getNumeroColegiado() {
		return numeroColegiado;
	}

	public Puntuacion[] getPuntuaciones() {
		return puntuaciones;
	}

	// Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNumeroColegiado(String numeroColegiado) {
		this.numeroColegiado = numeroColegiado;
	}

	public void setPuntuaciones(Puntuacion[] puntuaciones) {
		this.puntuaciones = puntuaciones;
	}

	public void generarPuntuacionesAleatorias() {
		Random random = new Random();
		for (int i = 0; i < 40; i++) {
			puntuaciones[i] = new Puntuacion(random.nextInt(11), random.nextInt(11), random.nextInt(11),
					random.nextInt(5));
		}
	} // generarPuntuacionesAleatorias

	public double promedioTemporada() {
		double suma = 0;
		
		for (Puntuacion p : puntuaciones) {
		
		}
		return suma / puntuaciones.length;
		
		
	} // promedioTemporada
	
         
        
}

public class AppPuntuacionesArbitros {
	
	static Arbitro[] arbitros = new Arbitro[10];
	static int contadorArbitros = 0;
	static Scanner scanner = new Scanner(System.in);

	public static void insertarDatosArbitro() {
		if (contadorArbitros >= arbitros.length) {
			System.out.println("No se pueden registrar más árbitros.");
			return;
		}

		System.out.println("Introduce el nombre del árbitro:");
		String nombre = scanner.nextLine();
		System.out.println("Introduce el número de colegiado:");
		String numeroColegiado = scanner.nextLine();
		Arbitro arbitro = new Arbitro(nombre, numeroColegiado);
		arbitro.generarPuntuacionesAleatorias();
		arbitros[contadorArbitros++] = arbitro;
	} // insertarDatosArbitro

	public static void listarDatosArbitro() {
		System.out.println("Introduce el número de colegiado del árbitro:");
		String numeroColegiado = scanner.nextLine();
		for (Arbitro arbitro : arbitros) {
			if (arbitro != null && arbitro.getNumeroColegiado().equals(numeroColegiado)) {
				System.out.println("Nombre: " + arbitro.getNombre());
				System.out.println("Número de colegiado: " + arbitro.getNumeroColegiado());
				System.out.println("Promedio de la temporada: " + arbitro.promedioTemporada());
				return;
			}
		}
		System.out.println("Árbitro no encontrado.");
	} // listarDatosArbitro

	public static void obtenerMejorArbitro() {
		if (contadorArbitros == 0) {
			System.out.println("No hay árbitros registrados.");
			return;
		}

		Arbitro mejor = null;
		for (Arbitro arbitro : arbitros) {
			if (arbitro != null && (mejor == null || arbitro.promedioTemporada() > mejor.promedioTemporada())) {
				mejor = arbitro;
			}
		}

		if (mejor != null) {
			System.out.println(
					"El mejor árbitro es: " + mejor.getNombre() + " con promedio: " + mejor.promedioTemporada());
		}
	} // obtenerMejorArbitro

	public static void mostrarMenu() {
		int opcion;
		do {
			System.out.println("--------------MENU--------------");
			System.out.println("1. Insertar datos de un árbitro");
			System.out.println("2. Listar los datos de un árbitro");
			System.out.println("3. Obtener el mejor árbitro");
			System.out.println("4. Salir");
			System.out.println("--------------------------------");
			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				insertarDatosArbitro();
				break;
			case 2:
				listarDatosArbitro();
				break;
			case 3:
				obtenerMejorArbitro();
				break;
			case 4:
				System.out.println("Saliendo");
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
		} while (opcion != 4);
	} // mostrarMenu

	public static void main(String[] args) {
		mostrarMenu();
	} // main
}// class
