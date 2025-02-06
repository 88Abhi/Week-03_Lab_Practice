package com.stringbufferproblems.concatenatestrings;

// Class to concatenate strings using StringBuffer
class StringConcatenator {
	// Method to concatenate an array of strings using StringBuffer
	public static String concatenateStrings(String[] words) {
		// Creating a StringBuffer object to store concatenated result
		StringBuffer stringBuffer = new StringBuffer();

		// Iterating through each string in the array
		for (String word : words) {
			stringBuffer.append(word);
		}

		// Returning the final concatenated string
		return stringBuffer.toString();
	}

	public static void main(String[] args) {
		// Given array of strings
		String[] words = {"Hello", " World", "!", " Welcome", " to", " Java."};

		// Before Concatenation of array of strings
		System.out.print("Before Concatenation: ");
		for (String word : words) {
			System.out.print(word + ", ");
		}

		// Concatenating strings using StringBuffer and printing the result
		System.out.println("\nConcatenated string: " + concatenateStrings(words));
	}
}
