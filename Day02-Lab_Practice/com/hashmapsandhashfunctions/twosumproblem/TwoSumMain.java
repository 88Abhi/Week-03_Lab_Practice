package com.hashmapsandhashfunctions.twosumproblem;

import java.util.Arrays;

// Class to test the Two Sum solution
class TwoSumMain {
	public static void main(String[] args) {
		// Create an instance of the TwoSum class
		TwoSum solution = new TwoSum();

		// Array of numbers and the target sum
		int[] nums = {2, 7, 11, 15};
		int target = 9;

		// Call the twoSum method and store the result
		int[] result = solution.twoSum(nums, target);

		// Printing original array
		System.out.println("Original array: " + Arrays.toString(nums));

		// Print the indices of the two numbers that sum up to the target
		System.out.println("Indices of pair of elements whose sum is " + target + " are: [" + result[0] + ", " + result[1] + "]");
	}
}