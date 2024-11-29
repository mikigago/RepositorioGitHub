package PracticaVectores;

import java.util.*;

public class FusionarVectores {

	public static void main(String[] args) {

		int maxRango = 0;
		int minRango = 0;

		int[] vectorA = { 1, 2, 3, 4, 5 };
		int[] vectorB = { 6, 7, 8, 9, 10, 11, 12, 13 };

		int[] fusionAB = new int[vectorA.length + vectorB.length];

		//max min A
		if (vectorA.length < vectorB.length) {
			maxRango = vectorB.length;
			minRango = vectorA.length;

		} else
		// max min B
		if (vectorA.length > vectorB.length) {
			minRango = vectorB.length;
			maxRango = vectorA.length;

		} else {
			minRango = vectorB.length;
			maxRango = vectorB.length;
		}
		
		int i = 0;

		for (i = 0; i < minRango; i++) {
			fusionAB[2 * i] = vectorA[i];
			fusionAB[(2 * i) + 1] = vectorB[i];
		}
		
		// volcar A
		if (vectorA.length < vectorB.length) {

			for (int j = minRango; j < maxRango; j++) {
				fusionAB[j + minRango] = vectorB[j];
			} // for

		}
		// volcar B
		if (vectorA.length > vectorB.length) {

			for (int j = minRango; j < maxRango; j++) {
				fusionAB[j + minRango] = vectorA[j];
			} // for

		}

	

		System.out.println(Arrays.toString(fusionAB));
		

	}// class

}// main
