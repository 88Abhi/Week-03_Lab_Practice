package com.largefilereadingefficiency;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// class to read file using input stream reader and calculate time
public class InputStreamReaderMethod {
	public static long computeAndMeasure(String filePath) {
		// Records the start time before reading the file
		long startTime = System.nanoTime();

		// Calls the method to read the file using InputStreamReader
		readFile(filePath);

		// Records the end time after reading the file
		long endTime = System.nanoTime();

		// Calculates and returns the total execution time
		return (endTime - startTime) / 1000000;
	}

	public static void readFile(String filePath) {
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath));

			// Reads characters one by one from the file
			while (reader.read() != -1) {
			}
		}
		catch (IOException e) {
			// Handles exceptions if the file is not found or cannot be read
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}
