package com.stringbuilderstringbufferfilereaderandinputstreamreader;

import java.io.IOException;

// PerformanceComparisonMain class to execute the comparison tests
public class PerformanceComparisonMain {
	public static void main(String[] args) {
		// Measuring performance of StringBuilder
		long stringBuilderTime = StringPerformanceComparator.measureStringBuilderPerformance();

		// Measuring performance of StringBuffer
		long stringBufferTime = StringPerformanceComparator.measureStringBufferPerformance();

		// Printing the time taken by StringBuilder and StringBuffer
		System.out.println("StringBuilder Time (ns): " + stringBuilderTime);
		System.out.println("StringBuffer Time (ns): " + stringBufferTime);

		// File path for reading (ensure this file exists and is 100MB)
		String filePath = "example.txt";

		try {
			// Measuring performance of FileReader
			long[] fileReaderTime = FileReaderComparator.countWordsUsingFileReader(filePath);

			// Measuring performance of InputStreamReader
			long inputStreamReaderTime = FileReaderComparator.countWordsUsingInputStreamReader(filePath);

			// Printing the time taken by FileReader and InputStreamReader
			System.out.println("\nCount of words in a file: " + fileReaderTime[0]);
			System.out.println("FileReader Time (ns): " + fileReaderTime[1]);
			System.out.println("InputStreamReader Time (ns): " + inputStreamReaderTime);

		}
		catch (IOException e) {
			// Handling file reading exceptions
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}

