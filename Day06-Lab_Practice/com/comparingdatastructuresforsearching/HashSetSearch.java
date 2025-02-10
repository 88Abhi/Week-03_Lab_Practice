package com.comparingdatastructuresforsearching;

import java.util.HashSet;

// Class to calculate the time required to search target in HashSet
public class HashSetSearch {
	public static boolean searchHashSet(HashSet<Integer> hashSet, int key) {
		// Uses HashSet's contains() method to check for key existence
		return hashSet.contains(key);
	}

	// Method to compute time for searching an element
	public static long computeAndMeasure(int[] arr, int key) {
		// Creates a HashSet of integers
		HashSet<Integer> hashSet = new HashSet<>();

		for (int j : arr) {
			hashSet.add(j);
		}

		// Records the start time before the search operation begins
		long startTime = System.nanoTime();

		// Performs a search in the HashSet
		boolean found = searchHashSet(hashSet, key);

		// Records the end time after the search operation finishes
		long endTime = System.nanoTime();

		System.out.println("HashSet Search Result: " + found);

		return (endTime - startTime) / 1000000;
	}
}
