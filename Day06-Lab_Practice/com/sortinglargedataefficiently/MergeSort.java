package com.sortinglargedataefficiently;

// class to sort array using merge sort
public class MergeSort {
	// Method to perform merge sort
	public static void performMergeSort(int[] numbers, int left, int right) {
		// Base case: Ensures there is at least one element to sort
		if (left < right) {
			int middle = left + (right - left) / 2;

			// Recursively sorts the left half of the array
			performMergeSort(numbers, left, middle);

			// Recursively sorts the right half of the array
			performMergeSort(numbers, middle + 1, right);

			// Merges the two sorted halves together
			merge(numbers, left, middle, right);
		}
	}

	// Method to merge the divided arrays
	private static void merge(int[] numbers, int left, int middle, int right) {
		// Determines sizes of the two subarrays
		int leftSize = middle - left + 1;
		int rightSize = right - middle;

		// Creates temporary arrays to hold data
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];

		// Copies elements into the left subarray
		for (int i = 0; i < leftSize; i++) {
			leftArray[i] = numbers[left + i];
		}

		// Copies elements into the right subarray
		for (int j = 0; j < rightSize; j++) {
			rightArray[j] = numbers[middle + 1 + j];
		}

		int i = 0, j = 0, k = left;

		// Merges elements from both subarrays in sorted order
		while (i < leftSize && j < rightSize) {
			if (leftArray[i] <= rightArray[j]) {
				numbers[k] = leftArray[i];
				i++;
			}
			else {
				numbers[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// Copies remaining elements from left subarray
		while (i < leftSize) {
			numbers[k] = leftArray[i];
			i++;
			k++;
		}

		// Copies remaining elements from right subarray
		while (j < rightSize) {
			numbers[k] = rightArray[j];
			j++;
			k++;
		}
	}
}
