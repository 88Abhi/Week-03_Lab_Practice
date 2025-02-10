package com.comparingdatastructuresforsearching;

import java.util.TreeSet;

// Class to calculate time for searching an element in tree set
public class TreeSetSearch {
	public static boolean searchTreeSet(TreeSet<Integer> treeSet, int key) {
		// Uses TreeSet's contains() method to check for key existence
		return treeSet.contains(key);
	}

	// Method to compute searching time
	public static long computeAndMeasure(int[] arr, int key) {
		// Creates a TreeSet to store values in a sorted manner
		TreeSet<Integer> treeSet = new TreeSet<>();

		for (int j : arr) {
			treeSet.add(j);
		}

		// Records the start time before the search operation begins
		long startTime = System.nanoTime();

		// Performs a search in the TreeSet
		boolean found = searchTreeSet(treeSet, key);

		// Records the end time after the search operation finishes
		long endTime = System.nanoTime();

		System.out.println("TreeSet Search Result: " + found);

		return (endTime - startTime) / 1000000;
	}
}
