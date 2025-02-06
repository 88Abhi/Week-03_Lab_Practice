package com.binarysearchproblems.firstandlastoccurrenceofelementinsortedarray;

import java.util.Arrays;

// class to find the first and last occurrence of target
class FirstLastOccurrenceFinder {
	// Method to find the first occurrence of a target element using binary search
	public static int findFirstOccurrence(int[] numbers, int target) {
		// Initializing left and right pointers
		int left = 0;
		int right = numbers.length - 1;

		// Initializing variable to store the first occurrence index
		int firstOccurrence = -1;

		// Performing binary search
		while (left <= right) {
			// Calculating the middle index
			int mid = left + (right - left) / 2;

			// Checking if the middle element matches the target
			if (numbers[mid] == target) {
				firstOccurrence = mid;
				right = mid - 1;
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

		// Returning the first occurrence index
		return firstOccurrence;
	}

	// Method to find the last occurrence of a target element using binary search
	public static int findLastOccurrence(int[] numbers, int target) {
		// Initializing left and right pointers
		int left = 0;
		int right = numbers.length - 1;

		// Initializing variable to store the last occurrence index
		int lastOccurrence = -1;

		// Performing binary search
		while (left <= right) {
			// Calculating the middle index
			int mid = left + (right - left) / 2;

			// Checking if the middle element matches the target
			if (numbers[mid] == target) {
				lastOccurrence = mid;
				left = mid + 1;
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

		// Returning the last occurrence index
		return lastOccurrence;
	}

	public static void main(String[] args) {
		// Defining a sorted array
		int[] numbers = {2, 4, 4, 4, 6, 8, 10};

		// Defining the target element
		int target = 4;

		// Calling the function to find the first occurrence of the target element
		int firstOccurrence = findFirstOccurrence(numbers, target);

		// Calling the function to find the last occurrence of the target element
		int lastOccurrence = findLastOccurrence(numbers, target);

		// Printing original array
		System.out.println("Initial Array: " + Arrays.toString(numbers));

		// Printing the first and last occurrence indices
		System.out.println("First occurrence of " + target + " is at index: " + firstOccurrence);
		System.out.println("Last occurrence of " + target + " is at index: " + lastOccurrence);
	}
}
