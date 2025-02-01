package com.bubblesortonstudentmarks;

// Class to implement Bubble Sort for sorting student marks
class BubbleSortStudentMarks {
	// Method to perform Bubble Sort on an array
	public static void bubbleSort(int[] marks) {
		// Gets the total number of elements in the array
		int sizeOfArray = marks.length;

		// Iterates through the array
		for (int i = 0; i < sizeOfArray - 1; i++) {
			// Tracks whether any swaps occurred in this pass
			boolean swapped = false;

			// Compares adjacent elements and swaps if needed
			for (int j = 0; j < sizeOfArray - i - 1; j++) {
				// Checks if the current element is greater than the next element
				if (marks[j] > marks[j + 1]) {
					// Swaps the elements
					int temp = marks[j];
					marks[j] = marks[j + 1];
					marks[j + 1] = temp;

					// Marks that a swap has occurred
					swapped = true;
				}
			}

			// Breaks the loop if no swaps occurred
			if (!swapped) {
				break;
			}
		}
	}

	// Method to print the sorted array
	public static void printArray(int[] marks) {
		// Iterates through the sorted array
		for (int mark : marks) {
			System.out.print(mark + " ");
		}
	}

	public static void main(String[] args) {
		// Defines an array of student marks
		int[] marks = {75, 89, 60, 92, 70, 85};

		// Print unsorted marks
		System.out.print("Before sorting: ");
		printArray(marks);

		// Calls the sorting method to sort student marks
		bubbleSort(marks);

		// Print the sorted marks
		System.out.print("\nAfter sorting: ");
		printArray(marks);

	}
}
