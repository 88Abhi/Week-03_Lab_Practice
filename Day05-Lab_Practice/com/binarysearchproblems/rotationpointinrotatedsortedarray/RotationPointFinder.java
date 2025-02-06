package com.binarysearchproblems.rotationpointinrotatedsortedarray;

import java.util.Arrays;

// Class to find the minimum element in rotated sorted array
class RotationPointFinder {
	// Method to find the index of the smallest element using binary search
	public static int findRotationPoint(int[] numbers) {
		// Initializing left and right pointers
		int left = 0;
		int right = numbers.length - 1;

		// Performing binary search
		while (left < right) {
			// Calculating the middle index
			int mid = left + (right - left) / 2;

			// Checking if the middle element is greater than the last element
			if (numbers[mid] > numbers[right]) {
				// Searching in the right half
				left = mid + 1;
			}
			else {
				// Searching in the left half
				right = mid;
			}
		}

		// Returning the index of the rotation point
		return left;
	}

	public static void main(String[] args) {
		// Defining a rotated sorted array
		int[] numbers = {6, 7, 8, 1, 2, 3, 4};

		// Printing original array
		System.out.println("Sorted array is: " + Arrays.toString(numbers));

		// Calling the function to find the rotation point
		int result = findRotationPoint(numbers);

		// Printing the result
		System.out.println("Index of rotational point is: " + result);
	}
}
