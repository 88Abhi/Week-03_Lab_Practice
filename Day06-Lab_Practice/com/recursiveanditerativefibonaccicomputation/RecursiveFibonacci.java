package com.recursiveanditerativefibonaccicomputation;

// class to recursively calculate time required for Fibonacci series
public class RecursiveFibonacci {
	public static long fibonacciRecursive(int n) {
		// Checks if the input is 0 or 1
		if (n <= 1) {
			return n;
		}

		// Computes Fibonacci recursively by summing previous two numbers
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	// Compute the time taken to calculate fibonacci number
	public static long computeAndMeasure(int n) {
		// Records the start time before computation begins
		long startTime = System.nanoTime();

		// Calls the recursive Fibonacci method to compute the result
		long result = fibonacciRecursive(n);

		// Records the end time after computation finishes
		long endTime = System.nanoTime();

		System.out.println("Recursive Fibonacci Result: " + result);

		return (endTime - startTime) / 1000000;
	}
}
