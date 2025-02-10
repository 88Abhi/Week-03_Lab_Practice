package com.recursiveanditerativefibonaccicomputation;

// class to compare efficiency of iterative and recursive Fibonacci series
public class FibonacciComparison {
	public static void main(String[] args) {
		// This array will store the numbers of series
		int[] dataSize = new int[]{10, 30, 50};

		// Display the time taken by fibonacci series of different numbers
		for (int k : dataSize) {
			System.out.println("Time taken by Fibonacci Series on " + k + "th Number");
			System.out.println("Recursive Fibonacci Time: " + RecursiveFibonacci.computeAndMeasure(k) + " ms");
			System.out.println("Iterative Fibonacci Time: " + IterativeFibonacci.computeAndMeasure(k) + " ms\n");
		}
	}
}
