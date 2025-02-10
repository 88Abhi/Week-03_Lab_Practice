package com.comparingdatastructuresforsearching;

// class to search the target in array and calculate time
public class ArraySearch {
	public static boolean searchArray(int[] array, int key) {
		// Iterates through the array to find the key
		for (int num : array) {
			if (num == key) {
				return true;
			}
		}

		// Returns false if the key is not found
		return false;
	}

	// Compute the time required to search element in array
	public static long computeAndMeasure(int[] array, int key) {
		// Records the start time before the search operation begins
		long startTime = System.nanoTime();

		// Performs a linear search in the array
		boolean found = searchArray(array, key);

		// Records the end time after the search operation finishes
		long endTime = System.nanoTime();

		System.out.println("Array Search Result: " + found);

		return (endTime - startTime) / 1000000;
	}
}
