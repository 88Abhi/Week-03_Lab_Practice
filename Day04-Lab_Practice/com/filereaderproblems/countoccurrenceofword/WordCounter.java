package com.filereaderproblems.countoccurrenceofword;

import java.io.*;

// Class to count occurrences of a specific word in a file
class WordCounter {
	// Method to count occurrences of a given word in a file
	public static int countWordOccurrences(String filePath, String targetWord) throws IOException {
		// Creating a FileReader object to read the file
		FileReader fileReader = new FileReader(filePath);

		// Wrapping FileReader in BufferedReader for efficient reading
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// Variable to store each line read from the file
		String line;

		// Counter to track occurrences of the target word
		int count = 0;

		// Reading each line from the file
		while ((line = bufferedReader.readLine()) != null) {
			// Splitting the line into words
			String[] words = line.split("\\s+");

			// Checking each word in the line
			for (String word : words) {
				if (word.equalsIgnoreCase(targetWord)) {
					count++;
				}
			}
		}

		// Closing the BufferedReader
		bufferedReader.close();

		// Returning the final word count
		return count;
	}

	public static void main(String[] args) {
		// Specifying the file path
		String filePath = "example.txt";

		// Defining the word to count occurrences for
		String targetWord = "Java";

		try {
			// Counting occurrences of the word and printing the result
			int occurrences = countWordOccurrences(filePath, targetWord);
			System.out.println("Occurrences of '" + targetWord + "': " + occurrences);
		}
		catch (IOException e) {
			// Handling exceptions if file reading fails
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}

