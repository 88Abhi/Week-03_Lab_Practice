package com.largefilereadingefficiency;

import java.io.FileReader;
import java.io.IOException;

// class to read large files using file reader and calculate time
public class FileReaderMethod {
	public static long computeAndMeasure(String filePath) {
		// Records the start time before reading the file
		long startTime = System.nanoTime();

		// Calls the method to read the file using FileReader
		readFile(filePath);

		// Records the end time after reading the file
		long endTime = System.nanoTime();

		// Calculates and returns the total execution time
		return (endTime - startTime) / 1000000;
	}

	public static void readFile(String filePath) {
		try {
			// Initializes the FileReader with the given file path
			FileReader reader = new FileReader(filePath);

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
