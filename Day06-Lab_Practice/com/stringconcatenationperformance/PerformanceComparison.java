package com.stringconcatenationperformance;

// class to compare timing of concatenation
public class PerformanceComparison {
	public static void main(String[] args) {
		// This array will store the size of the big datasets
		int[] iterations = new int[]{1000, 10000, 1000000};

		for (int iteration : iterations) {
			// Creates variables to store required execution time
			long stringTime = StringConcatenation.testConcatenation(iteration);
			long stringBufferTime = StringBufferConcatenation.testConcatenation(iteration);
			long stringBuilderTime = StringBuilderConcatenation.testConcatenation(iteration);

			System.out.println("Time taken by different string concatenation on " + iteration + " Datasize");

			// Measures and prints the execution time for String concatenation
			System.out.println("String Concatenation Time: " + stringTime + " ms");

			// Measures and prints the execution time for StringBuilder concatenation
			System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime + " ms");

			// Measures and prints the execution time for StringBuffer concatenation
			System.out.println("StringBuffer Concatenation Time: " + stringBufferTime + " ms\n");
		}
	}
}
