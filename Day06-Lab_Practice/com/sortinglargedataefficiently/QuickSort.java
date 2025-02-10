package com.sortinglargedataefficiently;

// class to perform quicksort
public class QuickSort {
	// Method to perform QuickSort
	public static void performQuickSort(int[] numbers, int left, int right) {
		// Ensures at least one element is present for sorting
		if (left >= right) {
			return;
		}

		// Finds the pivot index after partitioning
		int pivotIndex = partition(numbers, left, right);

		// Recursively sorts the left partition
		performQuickSort(numbers, left, pivotIndex - 1);

		// Recursively sorts the right partition
		performQuickSort(numbers, pivotIndex + 1, right);

	}

	// partition of array based on pivot
	private static int partition(int[] numbers, int left, int right) {
		// Chooses the last element as the pivot
		int pivot = numbers[right];
		int partitionIndex = left;

		// Iterates through the array and rearranges elements
		for (int i = left; i < right; i++) {
			if (numbers[i] < pivot) {
				// Swaps current element with partition index element
				int temp = numbers[i];
				numbers[i] = numbers[partitionIndex];
				numbers[partitionIndex] = temp;
				partitionIndex++;
			}
		}

		// Places the pivot element at its correct position
		int temp = numbers[partitionIndex];
		numbers[partitionIndex] = numbers[right];
		numbers[right] = temp;

		// Returns the index of the pivot element
		return partitionIndex;
	}
}

