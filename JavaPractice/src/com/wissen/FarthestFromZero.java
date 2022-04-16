package com.wissen;

public class FarthestFromZero {

	public static void main(String[] args) {
		int[] arr = { 1, -2, 4, 2, 0, 6, 79, -1, -6, -2, -69 };
		int minima = 0;
		int maxima = 0;

		for (int i : arr) {
			if (i > maxima) {
				maxima = i;
			}
			if (i < minima) {
				minima = i;
			}
		}

		System.out.println(Math.abs(minima) > maxima ? minima : maxima);
	}

}
