package com.stringbufferproblems.comparestringbufferwithstringbuilder;

// Class to compare performance of StringBuffer and StringBuilder
class PerformanceComparator {
	// Method to measure time taken by StringBuffer for concatenation
	public static long measureStringBufferTime(int iterations) {
		// Creating a StringBuffer object
		StringBuffer stringBuffer = new StringBuffer();

		// Recording start time
		long startTime = System.nanoTime();

		// Performing concatenation for given number of iterations
		for (int i = 0; i < iterations; i++) {
			stringBuffer.append("hello");
		}

		// Calculate end time and return
		return System.nanoTime() - startTime;
	}

	// Method to measure time taken by StringBuilder for concatenation
	public static long measureStringBuilderTime(int iterations) {
		// Creating a StringBuilder object
		StringBuilder stringBuilder = new StringBuilder();

		// Recording start time
		long startTime = System.nanoTime();

		// Performing concatenation for given number of iterations
		for (int i = 0; i < iterations; i++) {
			stringBuilder.append("hello");
		}

		// Calculate end time and return
		return System.nanoTime() - startTime;
	}

	public static void main(String[] args) {
		// Defining number of iterations for testing
		int iterations = 1000000;

		// Measuring time taken by StringBuffer
		long bufferTime = measureStringBufferTime(iterations);

		// Measuring time taken by StringBuilder
		long builderTime = measureStringBuilderTime(iterations);

		// Printing the time taken by both approaches
		System.out.println("Time taken by StringBuffer: " + bufferTime + " nanoseconds");
		System.out.println("Time taken by StringBuilder: " + builderTime + " nanoseconds");
	}
}
