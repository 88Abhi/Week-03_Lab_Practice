package com.filereaderproblems.readfilelinebyline;

import java.io.*;

// Class to read a file line by line using FileReader
class FileLineReader {
	// Method to read a file line by line and print each line
	public static void readFile(String filePath) throws IOException {
		// Creating a FileReader object to read the file
		FileReader fileReader = new FileReader(filePath);

		// Wrapping FileReader in BufferedReader for reading
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Variable to store each line read from the file
		String line;

		// Reading each line from the file until the end is reached
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

		// Closing the BufferedReader
		bufferedReader.close();
	}

	public static void main(String[] args) {
		// Specifying the file path
		String filePath = "example.txt";

		try {
			// Reading the file and printing its content
			System.out.println("Reading file line by line: ");
			FileLineReader.readFile(filePath);
		}
		catch (IOException e) {
			// Handling exceptions if file reading fails
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}