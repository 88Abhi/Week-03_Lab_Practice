package com.hashmapsandhashfunctions.longestconsecutivesequence;

import java.util.Arrays;

// Class containing the main method to test the solution
class LongestConsecutiveSequenceMain {
	public static void main(String[] args) {
		// Defines an unsorted array containing integer values
		int[] inputArray = {100, 4, 200, 1, 3, 2, 5, 6, 7, 8, 9};

		// Calls the method to find the longest consecutive sequence length
		int longestSequenceLength = LongestConsecutiveSequence.findLongestConsecutiveSequence(inputArray);

		// Printing original array
		System.out.println("Original array: " + Arrays.toString(inputArray));

		// Displaying the length of the longest consecutive sequence
		System.out.println("\nLength of the Longest Consecutive Sequence: " + longestSequenceLength);
	}
}
