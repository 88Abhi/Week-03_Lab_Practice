package com.sortinglargedataefficiently;

import java.util.Random;
import java.util.Arrays;

// class to compare the complexities of sorting algorithms
public class SortingComparison {
	public static void main(String[] args) {
		// This array will store the size of the big datasets
		int[] dataSize = new int[]{1000, 10000, 1000000};

		// Creating random class object
		Random random = new Random();

		//Assigning random values to the array of different data size
		for (int size : dataSize) {
			int[] numbers = new int[size];
			for (int j = 0; j < numbers.length; j++) {
				numbers[j] = random.nextInt();
			}

			// Creates copies of the original array to use for each sorting algorithm
			int[] bubbleSortArray = Arrays.copyOf(numbers, numbers.length);
			int[] mergeSortArray = Arrays.copyOf(numbers, numbers.length);
			int[] quickSortArray = Arrays.copyOf(numbers, numbers.length);

			// Measures execution time for Bubble Sort
			long bubbleStart = System.nanoTime();
			BubbleSort.performBubbleSort(bubbleSortArray);
			long bubbleEnd = System.nanoTime();

			// Measures execution time for Merge Sort
			long mergeStart = System.nanoTime();
			MergeSort.performMergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
			long mergeEnd = System.nanoTime();

			// Measures execution time for Quick Sort
			long quickStart = System.nanoTime();
			QuickSort.performQuickSort(quickSortArray, 0, quickSortArray.length - 1);
			long quickEnd = System.nanoTime();

			System.out.println("Time taken by sorting algorithms to sort " + size + " elements");

			// Displays the sorting times for performance comparison
			System.out.println("Bubble Sort Time: " + (bubbleEnd - bubbleStart) / 1000000 + " ms");
			System.out.println("Merge Sort Time: " + (mergeEnd - mergeStart) / 1000000 + " ms");
			System.out.println("Quick Sort Time: " + (quickEnd - quickStart) / 1000000 + " ms\n");
		}
	}
}
