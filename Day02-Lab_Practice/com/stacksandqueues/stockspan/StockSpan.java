package com.stacksandqueues.stockspan;

// Importing the stack for using methods
import java.util.Stack;

// Class to calculate the stock span
class StockSpan {
	// Method to calculate span for each stock price
	public static int[] calculateSpan(int[] prices) {
		// Stores the result array containing span values
		int[] span = new int[prices.length];

		// Stack to store indices of stock prices
		Stack<Integer> indexStack = new Stack<>();

		// Loop through each stock price
		for (int i = 0; i < prices.length; i++) {
			// Remove elements from stack while condition is true
			while (!indexStack.isEmpty() && prices[i] >= prices[indexStack.peek()]) {
				indexStack.pop();
			}

			// If stack is empty, span is entire range from start
			if (indexStack.isEmpty()) {
				span[i] = i + 1;
			}
			// Otherwise, calculate span based on previous greater element
			else {
				span[i] = i - indexStack.peek();
			}

			// Push the current index onto the stack
			indexStack.push(i);
		}

		// Return the computed span array
		return span;
	}
}
