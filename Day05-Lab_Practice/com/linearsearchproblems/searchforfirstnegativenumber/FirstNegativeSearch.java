package com.linearsearchproblems.searchforfirstnegativenumber;

import java.util.Arrays;

// class to find the first negative number using linear search
class FirstNegativeSearch {
	// Method to find the first negative number in an array using linear search
	public static int findFirstNegativeIndex(int[] numbers) {
		// Iterating through the array from the beginning
		for (int index = 0; index < numbers.length; index++) {
			// Checking if the current element is negative
			if (numbers[index] < 0) {
				return index;
			}
		}

		// Returning -1 if no negative number is found
		return -1;
	}

	public static void main(String[] args) {
		// Defining a sample array
		int[] numbers = {5, 7, 2, -4, 9, -1};

		// Printing the array
		System.out.println("Sample array is: " + Arrays.toString(numbers));

		// Calling the function to find the first negative number's index
		int result = findFirstNegativeIndex(numbers);

		// Printing the result
		if (result != -1) {
			System.out.println("Index of first negative element is: " + result);
		}
		else {
			System.out.println("No negative element is found");
		}
	}
}
