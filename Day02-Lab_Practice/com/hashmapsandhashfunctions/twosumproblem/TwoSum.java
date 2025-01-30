package com.hashmapsandhashfunctions.twosumproblem;

// Importing the HashMap to access all internal methods
import java.util.HashMap;

// Class to implement the Two Sum problem using a Hash Map
class TwoSum {
	// Method to find two indices such that their values sum up to the target
	public int[] twoSum(int[] nums, int target) {
		// Create a hash map to store the value and index
		HashMap<Integer, Integer> map = new HashMap<>();

		// Iterate through the array to find the two numbers
		for (int i = 0; i < nums.length; i++) {
			// Calculate the complement
			int complement = target - nums[i];

			// Check if the complement already exists in the map
			if (map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}

			// If the complement does not exist, add the indexes
			map.put(nums[i], i);
		}

		// If no solution is found, return an empty array
		return new int[]{};
	}
}


