package com.searchtargetinlargedataset;

// class to search a target using linear search
public class LinearSearch {
	public static int performLinearSearch(int[] numbers, int targetValue) {
		// Iterates through the entire array and search for target
		for (int index = 0; index < numbers.length; index++) {
			if (numbers[index] == targetValue) {
				return index;
			}
		}
		// Returns -1 if the target no found
		return -1;
	}
}
