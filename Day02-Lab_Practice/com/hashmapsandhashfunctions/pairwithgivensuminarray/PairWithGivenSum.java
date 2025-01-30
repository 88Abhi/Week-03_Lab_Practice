package com.hashmapsandhashfunctions.pairwithgivensuminarray;

import java.util.*;

// Class to check if there exists a pair with the given sum
class PairWithGivenSum {
	// Method to check if a pair with the given sum exists
	public static boolean hasPairWithSum(int[] array, int targetSum) {
		// Creates a hash set to store elements that have been seen
		Set<Integer> seenNumbers = new HashSet<>();

		// Iterates through the array elements
		for (int num : array) {
			// Computes the required pair value
			int requiredPair = targetSum - num;

			// Checks if the required pair already exists in the set
			if (seenNumbers.contains(requiredPair)) {
				System.out.println("Pair for target sum " + targetSum + " found: (" + requiredPair + ", " + num + ")");
				return true;
			}

			// Adds the current number to the set
			seenNumbers.add(num);
		}

		// Prints a message if no pair was found
		System.out.println("No pair with sum " + targetSum + " found.");
		return false;
	}
}
