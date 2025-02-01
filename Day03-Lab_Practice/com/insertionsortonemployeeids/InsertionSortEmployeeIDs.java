package com.insertionsortonemployeeids;

// Class to implement Insertion Sort for sorting employee IDs
class InsertionSortEmployeeIDs {
	// Method to perform Insertion Sort on an array
	public static void insertionSort(int[] employeeIDs) {
		// Gets the size of the array
		int size = employeeIDs.length;

		// Iterates through the array starting from the second element
		for (int i = 1; i < size; i++) {
			// Stores the current element to be inserted
			int key = employeeIDs[i];

			// Initializes a variable to track the previous index
			int j = i - 1;

			// Shifts elements of the sorted part
			while (j >= 0 && employeeIDs[j] > key) {
				// Moves the larger element one position ahead
				employeeIDs[j + 1] = employeeIDs[j];

				// Decreases the index
				j--;
			}

			// Inserts the key at its correct position
			employeeIDs[j + 1] = key;
		}
	}

	// Method to print the sorted array
	public static void printArray(int[] employeeIDs) {
		// Iterates through the sorted array and print elements
		for (int id : employeeIDs) {
			System.out.print(id + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Defines an array of employee IDs
		int[] employeeIDs = {104, 101, 109, 102, 107};

		// Before sorting employee ids
		System.out.print("Before insertion sort: ");
		printArray(employeeIDs);

		// Calls the sorting method to sort employee IDs
		insertionSort(employeeIDs);

		// Calls the method to print the sorted employee IDs
		System.out.print("After insertion sort: ");
		printArray(employeeIDs);
	}
}
