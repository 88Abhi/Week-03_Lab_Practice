package com.searchtargetinlargedataset;

import java.util.Arrays;
import java.util.Random;

// class to compare the time taken by binary and linear search
public class SearchComparison {
	public static void main(String[] args) {
		// This array will store the size of the big datasets
		int[] dataSize = new int[]{1000, 10000, 1000000};

		// Creating random class object
		Random random = new Random();

		//Assigning random values to the array
		for (int k : dataSize) {
			int[] numbers = new int[k];
			for (int j = 0; j < numbers.length; j++) {
				numbers[j] = random.nextInt();
			}

			// Selects a random value from the array to be searched
			int targetValue = numbers[random.nextInt(k)];

			// Measures the time taken for linear search execution
			long linearStartTime = System.nanoTime();
			int linearResult = LinearSearch.performLinearSearch(numbers, targetValue);
			long linearEndTime = System.nanoTime();

			// Sorts the array for binary search
			Arrays.sort(numbers);

			// Measures the time taken for binary search execution
			long binaryStartTime = System.nanoTime();
			int binaryResult = BinarySearch.performBinarySearch(numbers, targetValue);
			long binaryEndTime = System.nanoTime();

			System.out.println("Time taken by searching algorithms on " + k + " Datasize");

			// Displays the results and execution times of both search methods
			System.out.println("Linear Search Index: " + linearResult + " | Time: " + (linearEndTime - linearStartTime) / 1000000 + " ms");
			System.out.println("Binary Search Index: " + binaryResult + " | Time: " + (binaryEndTime - binaryStartTime) / 1000000 + " ms\n");
		}
	}
}
