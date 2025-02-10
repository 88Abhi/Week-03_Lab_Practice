package com.stringconcatenationperformance;

// class to perform concatenation using strings
public class StringConcatenation {
	public static long testConcatenation(int count) {
		// Records the start time before concatenation
		long startTime = System.nanoTime();

		// Initializes an empty string for concatenation
		String result = "";

		// Loops through the specified count to perform concatenation
		for (int i = 0; i < count; i++) {
			result += "A";
		}

		// Records the end time after concatenation
		long endTime = System.nanoTime();

		// Returns the total execution time in milliseconds
		return (endTime - startTime) / 1000000;
	}
}
