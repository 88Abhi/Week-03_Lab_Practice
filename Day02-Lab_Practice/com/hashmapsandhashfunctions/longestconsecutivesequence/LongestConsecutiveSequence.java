package com.hashmapsandhashfunctions.longestconsecutivesequence;

import java.util.*;

// Class to find the longest consecutive sequence in an unsorted array
class LongestConsecutiveSequence {
	// Method to find the length of the longest consecutive elements sequence
	public static int findLongestConsecutiveSequence(int[] inputArray) {
		// Creates a HashMap to store elements and their visits
		Map<Integer, Boolean> elementPresenceMap = new HashMap<>();

		// Iterates through the input array inserts each element into the HashMap
		for (int element : inputArray) {
			elementPresenceMap.put(element, true);
		}

		// Variable to store maximum length of consecutive sequence
		int longestSequenceLength = 0;

		// Iterates through each element in the input array
		for (int element : inputArray) {
			// Checks if the element is the starting point
			if (!elementPresenceMap.containsKey(element - 1)) {
				int currentSequenceLength = 1;

				// Initializes a variable to store consecutive elements
				int nextElement = element + 1;

				// Expands the sequence by checking for consecutive numbers
				while (elementPresenceMap.containsKey(nextElement)) {
					currentSequenceLength++;
					nextElement++;
				}

				// Updates the longest sequence length
				longestSequenceLength = Math.max(longestSequenceLength, currentSequenceLength);
			}
		}

		// Returns the length of the longest consecutive sequence
		return longestSequenceLength;
	}
}