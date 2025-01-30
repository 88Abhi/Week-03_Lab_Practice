package com.hashmapsandhashfunctions.pairwithgivensuminarray;

import java.util.Arrays;

// Class containing the main method
class PairWithGivenSumMain {
	public static void main(String[] args) {
		// Defines an array with some integers
		int[] array = {8, 4, 1, 6, 10, 5};

		// Defines the target sum to search for
		int targetSum = 9;

		// Printing the original array
		System.out.println("Original array is: " + Arrays.toString(array));

		// Calls the method to check if a pair exists with the given sum
		PairWithGivenSum.hasPairWithSum(array, targetSum);
	}
}
