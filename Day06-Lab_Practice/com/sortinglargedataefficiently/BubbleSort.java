package com.sortinglargedataefficiently;

// class to perform bubble sort
public class BubbleSort {
	public static void performBubbleSort(int[] numbers) {
		// Gets the total number of elements in the array
		int length = numbers.length;

		// Outer loop controls the number of passes required
		for (int i = 0; i < length - 1; i++) {
			boolean swapped = false;
			// Inner loop compares adjacent elements
			for (int j = 0; j < length - i - 1; j++) {
				// If the current element is greater than the next, swap them
				if (numbers[j] > numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
					swapped = true;
				}
			}

			// If no swaps occurred in a pass
			if (!swapped) {
				break;
			}
		}
	}
}

