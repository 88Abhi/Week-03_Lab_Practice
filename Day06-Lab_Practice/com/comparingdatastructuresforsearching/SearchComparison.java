package com.comparingdatastructuresforsearching;

import java.util.Random;

// Class to compare the timing of data structures
public class SearchComparison {
	public static void main(String[] args) {
		// This array will store the size of the big datasets
		int[] dataSize = new int[]{1000, 10000, 1000000};

		// Creating random class object
		Random random = new Random();

		//Assigning random values to the array
		for (int size : dataSize) {
			int[] numbers = new int[size];
			for (int j = 0; j < numbers.length; j++) {
				numbers[j] = random.nextInt();
			}
			int searchKey = random.nextInt(numbers.length);

			// Printing the timings of data structures
			System.out.println("Time taken by Data structures for searching a number in " + size + " elements");
			System.out.println("Array Search Time: " + ArraySearch.computeAndMeasure(numbers, searchKey) + " ms");
			System.out.println("HashSet Search Time: " + HashSetSearch.computeAndMeasure(numbers, searchKey) + " ms");
			System.out.println("TreeSet Search Time: " + TreeSetSearch.computeAndMeasure(numbers, searchKey) + " ms\n");
		}
	}
}
