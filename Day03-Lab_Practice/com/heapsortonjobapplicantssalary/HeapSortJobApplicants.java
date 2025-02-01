package com.heapsortonjobapplicantssalary;

// Class to implement Heap Sort for sorting job applicants by salary
class HeapSortJobApplicants {
	// Method to perform Heap Sort on an array
	public static void heapSort(int[] salaries) {
		// Gets the number of elements in the array
		int n = salaries.length;

		// Builds a Max Heap from the array by heapifying
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(salaries, n, i);
		}

		// Extracts elements one by one from the heap
		for (int i = n - 1; i > 0; i--) {
			// Swaps the root with the last element
			swap(salaries, 0, i);

			// Calls heapify to maintain the heap property
			heapify(salaries, i, 0);
		}
	}

	// Method to maintain the heap property for a subtree
	private static void heapify(int[] salaries, int n, int i) {
		// Assumes the largest element is at the root index i
		int largest = i;

		// Finds the left child index
		int left = 2 * i + 1;

		// Finds the right child index
		int right = 2 * i + 2;

		// Checks if the left child exists and is greater than the current largest element
		if (left < n && salaries[left] > salaries[largest]) {
			largest = left;
		}

		// Checks if the right child exists and is greater than the current largest element
		if (right < n && salaries[right] > salaries[largest]) {
			largest = right;
		}

		// Checks if the largest element is not the root
		if (largest != i) {
			swap(salaries, i, largest);

			// Recursively calls heapify on the affected subtree
			heapify(salaries, n, largest);
		}
	}

	// Method to swap two elements in an array
	private static void swap(int[] salaries, int i, int j) {
		// Stores the first element in a temporary variable
		int temp = salaries[i];

		// Replaces the first element with the second element
		salaries[i] = salaries[j];

		// Replaces the second element with temporary variable
		salaries[j] = temp;
	}

	// Method to print the sorted salaries
	public static void printArray(int[] salaries) {
		// Iterates through the sorted array
		for (int salary : salaries) {
			System.out.print(salary + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Defines an array of job applicants' salary demands
		int[] salaries = {50000, 75000, 60000, 45000, 80000};

		// Printing the salaries before sorting
		System.out.print("Before Heap Sort: ");
		printArray(salaries);

		// Calls the sorting method to sort the salary demands
		HeapSortJobApplicants.heapSort(salaries);

		// Calls the method to print the sorted salaries
		System.out.print("After Heap Sort: ");
		printArray(salaries);
	}
}
