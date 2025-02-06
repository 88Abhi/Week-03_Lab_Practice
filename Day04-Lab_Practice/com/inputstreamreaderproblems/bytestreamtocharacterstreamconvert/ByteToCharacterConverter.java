package com.inputstreamreaderproblems.bytestreamtocharacterstreamconvert;

import java.io.*;

// Class to read a file as a character stream using InputStreamReader
class ByteToCharacterConverter {
	// Method to read a file and print characters
	public static void readFile(String filePath) throws IOException {
		// Creating a FileInputStream object to read byte data from file
		FileInputStream fileInputStream = new FileInputStream(filePath);

		// Wrapping FileInputStream in InputStreamReader to convert bytes to characters
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

		// Wrapping InputStreamReader in BufferedReader
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		// Variable to store each line read from the file
		String line;

		// Reading each line from the file and printing it to the console
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
			readFile(filePath);
		}
		catch (IOException e) {
			// Handling exceptions if file reading fails
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}
