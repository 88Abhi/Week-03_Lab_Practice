package com.binarysearchproblems.linearandbinarysearch;

import java.util.Arrays;

// class to find missing positive integer in array
class MissingIntegerAndBinarySearch {
	// Method to find the first missing positive integer using linear search
	public static int findFirstMissingPositive(int[] numbers) {
		// Finding the length of the array
		int length = numbers.length;

		// Creating an auxiliary array to mark presence of numbers
		boolean[] present = new boolean[length + 1];

		// Iterating through the array to mark existing numbers
		for (int number : numbers) {
			// Checking if the number is in the valid range
			if (number > 0 && number <= length) {
				present[number] = true;
			}
		}

		// Iterating to find the first missing positive number
		for (int index = 1; index <= length; index++) {
			// Returning the first missing number
			if (!present[index]) {
				return index;
			}
		}

		// Returning the next positive integer
		return length + 1;
	}

	// Method to find the index of a target element using binary search
	public static int binarySearch(int[] numbers, int target) {
		// Initializing left and right pointers
		int left = 0;
		int right = numbers.length - 1;

		// Performing binary search
		while (left <= right) {
			// Calculating the middle index
			int mid = left + (right - left) / 2;

			// Checking if the middle element matches the target
			if (numbers[mid] == target) {
				return mid;
			}
			// Checking if the target is smaller than the middle element
			else if (numbers[mid] > target) {
				right = mid - 1;
			}
			// Checking if the target is larger than the middle element
			else {
				left = mid + 1;
			}
		}

		// Returning -1 if the target is not found
		return -1;
	}

	public static void main(String[] args) {
		// Defining an array of integers
		int[] numbers = {3, 4, -1, 1};

		// Printing the original array
		System.out.println("Initial array: " + Arrays.toString(numbers));

		// Finding the first missing positive integer using linear search
		int missingNumber = findFirstMissingPositive(numbers);

		// Displaying the missing number
		System.out.println("Missing number: " + missingNumber);

		// Sorting the array before applying binary search
		Arrays.sort(numbers);

		// Defining the target element
		int target = 3;

		// Printing the sorted array
		System.out.println("Sorted array: " + Arrays.toString(numbers));

		// Finding the index of the target element using binary search
		int targetIndex = binarySearch(numbers, target);

		// Printing the target index
		System.out.println("Index of given target " + target + " is: " + targetIndex);
	}
}
