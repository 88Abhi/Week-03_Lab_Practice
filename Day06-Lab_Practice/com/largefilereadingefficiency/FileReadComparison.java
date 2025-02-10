package com.largefilereadingefficiency;

// class to compare file reading time
public class FileReadComparison {
	public static void main(String[] args) {
		int size = 1;

		// Defines the file path to be read
		for (int i = 1; i < 4; i++) {
			String filePath = "example" + i + ".txt";

			System.out.println("Time taken to read the file of: " + size + "MB");

			// Measures and prints execution time for FileReader method
			System.out.println("FileReader Time: " + FileReaderMethod.computeAndMeasure(filePath) + " ms");

			// Measures and prints execution time for InputStreamReader method
			System.out.println("InputStreamReader Time: " + InputStreamReaderMethod.computeAndMeasure(filePath) + " ms\n");

			if (size == 1) {
				size *= 100;
			}
			else {
				size *= 5;
			}
		}
	}
}
