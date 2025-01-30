package com.hashmapsandhashfunctions.allsubarrayswithzerosum;

import java.util.*;

// Class to find all subarrays with zero sum
class ZeroSumSubArrays {
	// Method to find and print all subarrays with zero sum
	public static void findZeroSumSubarrays(int[] array) {
		// Creates a hash map to store cumulative sum and corresponding indices
		Map<Integer, List<Integer>> sumIndicesMap = new HashMap<>();

		// Stores the cumulative sum at each index
		int cumulativeSum = 0;

		// Stores the starting indices of subarrays with zero sum
		List<List<Integer>> result = new ArrayList<>();

		// Adds an initial entry in the hash map
		sumIndicesMap.put(0, new ArrayList<>());
		sumIndicesMap.get(0).add(-1);

		// Iterates through the array elements
		for (int i = 0; i < array.length; i++) {
			// Updates cumulative sum with the current element
			cumulativeSum += array[i];

			// Checks if the cumulative sum has been seen before
			if (sumIndicesMap.containsKey(cumulativeSum)) {
				List<Integer> previousIndices = sumIndicesMap.get(cumulativeSum);

				// Iterates through all previous occurrences of the same sum
				for (int startIndex : previousIndices) {
					result.add(Arrays.asList(startIndex + 1, i));
				}
			}

			// Adds the current index to the list of indices for the cumulative sum
			sumIndicesMap.putIfAbsent(cumulativeSum, new ArrayList<>());
			sumIndicesMap.get(cumulativeSum).add(i);
		}

		// Displays all found subarrays
		printSubarrays(result, array);
	}

	// Method to print the subarrays using their indices
	private static void printSubarrays(List<List<Integer>> subarrays, int[] array) {
		// Checks if there are zero-sum subarrays
		if (subarrays.isEmpty()) {
			System.out.println("No subarrays with zero sum found.");
			return;
		}

		// Iterates through each subarray
		for (List<Integer> indices : subarrays) {
			// Retrieves the starting and ending indices
			int start = indices.get(0);
			int end = indices.get(1);

			// Prints the elements of the subarray
			System.out.print("Zero-sum subarray: [");
			for (int i = start; i <= end; i++) {
				System.out.print(array[i]);
				if (i < end) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}
	}
}



