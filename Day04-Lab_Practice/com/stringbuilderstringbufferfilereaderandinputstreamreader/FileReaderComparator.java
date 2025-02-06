package com.stringbuilderstringbufferfilereaderandinputstreamreader;

import java.io.*;

// Class to compare FileReader and InputStreamReader performance
class FileReaderComparator {

	// Method to count words in a file using FileReader
	public static long[] countWordsUsingFileReader(String filePath) throws IOException {
		// Recording start time
		long startTime = System.nanoTime();

		// Creating a FileReader object to read the file
		FileReader fileReader = new FileReader(filePath);

		// Wrapping FileReader in BufferedReader for efficient reading
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Variable to store each line read from the file
		String line;

		// Counter to store the total number of words
		long wordCount = 0;

		// Reading the file line by line
		while ((line = bufferedReader.readLine()) != null) {
			// Splitting the line into words and counting them
			wordCount += line.split("\\s+").length;
		}

		// Closing the BufferedReader
		bufferedReader.close();

		// Recording end time and returning execution time
		return new long[]{wordCount, System.nanoTime() - startTime};
	}

	// Method to count words in a file using InputStreamReader
	public static long countWordsUsingInputStreamReader(String filePath) throws IOException {
		// Recording start time
		long startTime = System.nanoTime();

		// Creating a FileInputStream object to read the binary data
		FileInputStream fileInputStream = new FileInputStream(filePath);

		// Wrapping FileInputStream in InputStreamReader to convert bytes to characters
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

		// Wrapping InputStreamReader in BufferedReader for efficient reading
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		// Variable to store each line read from the file
		String line;

		// Counter to store the total number of words
		long wordCount = 0;

		// Reading the file line by line
		while ((line = bufferedReader.readLine()) != null) {
			// Splitting the line into words and counting them
			wordCount += line.split("\\s+").length;
		}

		// Closing the BufferedReader
		bufferedReader.close();

		// Recording end time and returning execution time
		return System.nanoTime() - startTime;
	}
}