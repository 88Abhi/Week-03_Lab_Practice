package com.recursiveanditerativefibonaccicomputation;

// class to iteratively calculate time required for Fibonacci series
public class IterativeFibonacci {
	public static long fibonacciIterative(int n) {
		// Checks if the input is 0
		if (n == 0) {
			return 0;
		}

		// Initializes variables to store the first two Fibonacci numbers
		long a = 0;
		long b = 1;
		long sum = 0;

		// Iterates from 2 to n to compute Fibonacci numbers iteratively
		for (int i = 2; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}

		// Returns the Fibonacci number
		return b;
	}

	// Compute the time taken to calculate fibonacci number
	public static long computeAndMeasure(int n) {
		// Records the start time before computation begins
		long startTime = System.nanoTime();

		// Calls the iterative Fibonacci method to compute the result
		long result = fibonacciIterative(n);

		// Records the end time after computation finishes
		long endTime = System.nanoTime();

		System.out.println("Iterative Fibonacci Result: " + result);

		return (endTime - startTime) / 1000000;
	}
}
