package com.countingsortonstudentages;

// Class to implement Counting Sort for sorting student ages
class CountingSortStudentAges {
	// Method to perform Counting Sort on an array of ages
	public static void countingSort(int[] ages, int minAge, int maxAge) {
		// Calculates the range of ages
		int range = maxAge - minAge + 1;

		// Creates an array to store the count of each age
		int[] countArray = new int[range];

		// Creates an output array to store the sorted ages
		int[] sortedAges = new int[ages.length];

		// Iterates through the original array to count occurrences of each age
		for (int age : ages) {
			countArray[age - minAge]++;
		}

		// Computes the cumulative count to determine positions
		for (int i = 1; i < range; i++) {
			countArray[i] += countArray[i - 1];
		}

		// Iterates through the original array in reverse order
		for (int i = ages.length - 1; i >= 0; i--) {
			// Finds the correct position of the current age
			int position = countArray[ages[i] - minAge] - 1;

			// Places the age at its correct position
			sortedAges[position] = ages[i];

			// Decrements the count to handle duplicate values
			countArray[ages[i] - minAge]--;
		}

		// Copies the sorted array back to the original array
		System.arraycopy(sortedAges, 0, ages, 0, ages.length);
	}

	// Method to print the sorted ages
	public static void printArray(int[] ages) {
		// Iterates through the sorted array
		for (int age : ages) {
			System.out.print(age + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Defines an array of student ages
		int[] ages = {12, 15, 10, 18, 13, 14, 12, 16, 10, 17};

		// Defines the minimum and maximum age range
		int minAge = 10;
		int maxAge = 18;

		// Before sorting student's ages
		System.out.print("Before countingSort: ");
		printArray(ages);

		// Calls the sorting method to sort student ages
		CountingSortStudentAges.countingSort(ages, minAge, maxAge);

		// Calls the method to print the sorted ages
		System.out.print("After countingSort: ");
		CountingSortStudentAges.printArray(ages);
	}
}
