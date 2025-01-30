package com.hashmapsandhashfunctions.allsubarrayswithzerosum;

import java.util.Arrays;

// Class containing the main method
class ZeroSumSubarraysMain {
	public static void main(String[] args) {
		// Defines an array with some positive and negative integers
		int[] array = {3, 4, -7, 3, 1, 3, -4, -2, 2};

		// Printing original array
		System.out.println("Original array: " + Arrays.toString(array));

		// Calls the method to find all zero-sum subarrays
		ZeroSumSubArrays.findZeroSumSubarrays(array);
	}
}