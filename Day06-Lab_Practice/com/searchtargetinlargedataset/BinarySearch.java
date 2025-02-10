package com.searchtargetinlargedataset;

// class to search target using binary search
public class BinarySearch {
	public static int performBinarySearch(int[] numbers, int targetValue) {
		// Initializes the left and right
		int left = 0, right = numbers.length - 1;

		// Continues searching while the search range is valid
		while (left <= right) {
			// Calculate the mid
			int middle = left + (right - left) / 2;

			// Checks if the middle element matches the target value
			if (numbers[middle] == targetValue) {
				return middle;
			}

			// If the middle is smaller search in the right half
			if (numbers[middle] < targetValue) {
				left = middle + 1;
			}
			// Otherwise, search in the left half
			else if (numbers[middle] > targetValue) {
				right = middle - 1;
			}
		}

		// Returns -1 if the target is not found
		return -1;
	}
}

