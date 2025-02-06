package com.stringbuilderstringbufferfilereaderandinputstreamreader;

// Class to compare StringBuilder and StringBuffer performance
class StringPerformanceComparator {
	// Method to concatenate a string 1,000,000 times using StringBuilder
	public static long measureStringBuilderPerformance() {
		// Recording start time
		long startTime = System.nanoTime();

		// Creating a StringBuilder object
		StringBuilder stringBuilder = new StringBuilder();

		// Appending the string "hello" 1,000,000 times
		for (int i = 0; i < 1000000; i++) {
			stringBuilder.append("hello");
		}

		// Recording end time and returning execution time
		return System.nanoTime() - startTime;
	}

	// Method to concatenate a string 1,000,000 times using StringBuffer
	public static long measureStringBufferPerformance() {
		// Recording start time
		long startTime = System.nanoTime();

		// Creating a StringBuffer object
		StringBuffer stringBuffer = new StringBuffer();

		// Appending the string "hello" 1,000,000 times
		for (int i = 0; i < 1000000; i++) {
			stringBuffer.append("hello");
		}

		// Recording end time and returning execution time
		return System.nanoTime() - startTime;
	}
}




