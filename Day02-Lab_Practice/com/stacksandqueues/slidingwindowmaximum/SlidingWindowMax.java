package com.stacksandqueues.slidingwindowmaximum;

// importing Deque and LinkedList to access collection's methods
import java.util.Deque;
import java.util.LinkedList;

// Class to find the maximum element in each sliding window
class SlidingWindowMax {
	// Method to compute the maximum in each sliding window
	public static int[] findMaxSlidingWindow(int[] nums, int k) {
		// Stores the result array containing maximum values
		int[] result = new int[nums.length - k + 1];

		// Double-ended queue to store indices of elements
		Deque<Integer> deque = new LinkedList<>();

		// Iterates through each element in the array
		for (int i = 0; i < nums.length; i++) {
			// Removes elements from front of deque
			if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
				deque.pollFirst();
			}

			// Removes elements from back of deque
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}

			// Adds current index to the deque
			deque.addLast(i);

			// Starts adding results to array once the first window is completed
			if (i >= k - 1) {
				result[i - k + 1] = nums[deque.peekFirst()];
			}
		}

		// Returns the result array
		return result;
	}
}