package PracticaVectores;


import java.util.Arrays;

public class OrdenarVectoresFusionados {

	public static void main(String[] args) {
		int maxRango = 0;
		int minRango = 0;

		int[] vectorA = { 1, 20, 24, 41, 57 };
		int[] vectorB = { 60, 72, 12, 9, 19, 11, 18, 17 };

		int[] fusionAB = new int[vectorA.length + vectorB.length];

		int indiceA = 0, indiceB = 0, indiceAB = 0;

		int i = 0;

		for (indiceAB = 0; indiceAB < fusionAB.length; indiceAB++) {
			if (vectorA[indiceA] >= vectorB[indiceB]) {
				fusionAB[indiceAB] = vectorA[indiceA];
				++indiceA;
			} else {
				fusionAB[indiceAB] = vectorB[indiceB];
				++indiceB;
			}
			// salir del bucle cuando alguno de los vectores se agota

			if (indiceA >= vectorA.length || indiceB >= vectorB.length) {
				break;
			} // if

		} // for

		// volcar cola A
		if (indiceA < vectorA.length) {
			for (i = indiceA; i < vectorA.length; i++) {
				fusionAB[indiceAB] = vectorA[i];
				indiceAB++;
			}
		}

		// volcar cola B
		if (indiceB < vectorB.length) {
			for (i = indiceB; i < vectorB.length; i++) {
				fusionAB[indiceAB] = vectorB[i];
				indiceAB++;
			}
		}
		
		
		Arrays.sort(fusionAB);
		System.out.println(Arrays.toString(fusionAB));

	}// class

}// main