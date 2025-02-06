package com.inputstreamreaderproblems.readandwriteuserinputfromconsole;

import java.io.*;

// Class to read user input and write it to a file using InputStreamReader
class UserInputWriter {
	// Method to read user input and write to a file
	public static void writeUserInputToFile(String filePath) throws IOException {
		// Creating an InputStreamReader to read input from console
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);

		// Wrapping InputStreamReader in BufferedReader
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		// Creating a FileWriter object to write input to a file
		FileWriter fileWriter = new FileWriter(filePath);

		// Variable to store user input
		String userInput;

		System.out.println("Enter text (type 'exit' to stop):");

		// Reading user input until "exit" is entered
		while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
			fileWriter.write(userInput + "\n");
		}

		// Closing the FileWriter
		fileWriter.close();

		// Closing the BufferedReader
		bufferedReader.close();

		System.out.println("User input successfully written to file.");
	}

	public static void main(String[] args) {
		// Specifying the file path
		String filePath = "example.txt";

		try {
			// Writing user input to the specified file
			writeUserInputToFile(filePath);
		}
		catch (IOException e) {
			// Handling exceptions if file writing fails
			System.out.println("Error writing to file: " + e.getMessage());
		}
	}
}
