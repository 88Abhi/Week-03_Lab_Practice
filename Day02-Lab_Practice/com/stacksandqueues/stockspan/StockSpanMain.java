package com.stacksandqueues.stockspan;

// Class containing the main method
class StockSpanMain {
	public static void main(String[] args) {
		// Input stock prices array
		int[] prices = {100, 80, 60, 70, 60, 75, 85};

		// Calls the calculateSpan method to get span values
		int[] span = StockSpan.calculateSpan(prices);

		// Pointer to reverse the array of span
		int start = 0, end = span.length - 1;

		// loop through the array and swap to get reversed array
		while (start < end) {
			// swapping elements of index start and end
			int temp = span[start];
			span[start] = span[end];
			span[end] = temp;

			// Increment and decrement of the pointers
			start++;
			end--;
		}

		// Prints the current prices values
		System.out.println("Stock Prices: ");
		for (int value : prices) {
			System.out.print(value + " ");
		}

		// Prints the computed span values
		System.out.println("\nStock Span: ");
		for (int value : span) {
			System.out.print(value + " ");
		}
	}
}

