package com.stringconcatenationperformance;

// class to perform concatenation using string buffer
public class StringBufferConcatenation {
	public static long testConcatenation(int count) {
		// Records the start time before concatenation
		long startTime = System.nanoTime();

		// Creates a StringBuffer instance
		StringBuffer stringBuffer = new StringBuffer();

		// Loops through the specified count to perform concatenation
		for (int i = 0; i < count; i++) {
			stringBuffer.append("A");
		}

		// Records the end time after concatenation
		long endTime = System.nanoTime();

		// Returns the total execution time in milliseconds
		return (endTime - startTime) / 1000000;
	}
}
