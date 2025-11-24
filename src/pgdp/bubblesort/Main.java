package pgdp.bubblesort;

import static pgdp.bubblesort.BubbleSort.bubbleSort;

import java.util.Arrays;

public class Main {

	//TODO: Test your implementation with the examples below.
	public static void main(String[] args) {

		int[] fischbestand1 = { 6, 1, 6, 8, 9, 1, 9, 1, 5 };
		bubbleSort(fischbestand1);
		System.out.println("Fischbestand Nr.1: " + Arrays.toString(fischbestand1));

		int[] fischbestand2 = { 9, 8, 7, 6, 5, 4, 3 };
		bubbleSort(fischbestand2);
		System.out.println("Fischbestand Nr.2: " + Arrays.toString(fischbestand2));


	}
}
