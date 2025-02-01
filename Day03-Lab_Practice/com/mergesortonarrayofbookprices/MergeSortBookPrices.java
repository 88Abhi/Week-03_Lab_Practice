package com.mergesortonarrayofbookprices;

// Class to implement Merge Sort for sorting book prices
class MergeSortBookPrices {
	// Method to perform Merge Sort on an array
	public static void mergeSort(int[] bookPrices, int left, int right) {
		// Checks if there is more than one element to sort
		if (left < right) {
			// Finds the middle index of the array
			int mid = left + (right - left) / 2;

			// Recursively sorts the left half of the array
			mergeSort(bookPrices, left, mid);

			// Recursively sorts the right half of the array
			mergeSort(bookPrices, mid + 1, right);

			// Merges the sorted halves back together
			merge(bookPrices, left, mid, right);
		}
	}

	// Method to merge two sorted subarrays
	private static void merge(int[] bookPrices, int left, int mid, int right) {
		// Determines the size of the left subarray
		int leftSize = mid - left + 1;

		// Determines the size of the right subarray
		int rightSize = right - mid;

		// Creates temporary arrays to hold the left and right subarrays
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];

		// Copies elements into the left subarray
		for (int i = 0; i < leftSize; i++) {
			leftArray[i] = bookPrices[left + i];
		}

		// Copies elements into the right subarray
		for (int j = 0; j < rightSize; j++) {
			rightArray[j] = bookPrices[mid + 1 + j];
		}

		// Initializes indices for merging process
		int i = 0, j = 0, k = left;

		// Merges elements from both subarrays in sorted order
		while (i < leftSize && j < rightSize) {
			if (leftArray[i] <= rightArray[j]) {
				bookPrices[k] = leftArray[i];
				i++;
			}
			else {
				bookPrices[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// Copies any remaining elements from the left subarray
		while (i < leftSize) {
			bookPrices[k] = leftArray[i];
			i++;
			k++;
		}

		// Copies any remaining elements from the right subarray
		while (j < rightSize) {
			bookPrices[k] = rightArray[j];
			j++;
			k++;
		}
	}

	// Method to print the sorted book prices
	public static void printArray(int[] bookPrices) {
		// Iterates through the sorted array and print elements
		for (int price : bookPrices) {
			System.out.print(price + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Defines an array of book prices
		int[] bookPrices = {500, 150, 200, 450, 300};

		// Before sorting the books prices
		System.out.print("Before Merge Sort: ");
		printArray(bookPrices);

		// Calls the sorting method to sort book prices
		mergeSort(bookPrices, 0, bookPrices.length - 1);

		// Calls the method to print the sorted book prices
		System.out.print("After Merge Sort: ");
		printArray(bookPrices);
	}
}
