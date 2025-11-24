package pgdp.bubblesort;

public class BubbleSort {

	public static void bubbleSort(int[] fish) {
		int length = fish.length;

		while (length != 1) {
			for (int i = 0; i < length - 1; i++) {
				if (fish[i] > fish[i + 1]) {
					int tmp = fish[i];
					fish[i] = fish[i + 1];
					fish[i + 1] = tmp;
				}
			}
			length--;
		}
	}
}
//dhiadhiadhia