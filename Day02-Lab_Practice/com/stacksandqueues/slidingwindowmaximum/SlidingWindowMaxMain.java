package com.stacksandqueues.slidingwindowmaximum;

// Class containing the main method
class SlidingWindowMaxMain {
	public static void main(String[] args) {
		// Input array containing elements
		int[] array = {1, 3, -1, -3, 5, 3, 6, 7};

		// Defines the window size
		int k = 3;

		// Calls the method to compute the sliding window maximum
		int[] result = SlidingWindowMax.findMaxSlidingWindow(array, k);

		// Prints the array whose maximum will be calculated
		System.out.println("Original array: ");
		for (int value : array) {
			System.out.print(value + " ");
		}

		// Prints the computed maximum values for each window
		System.out.println("\nSliding Window Maximums: ");
		for (int value : result) {
			System.out.print(value + " ");
		}
	}
}
