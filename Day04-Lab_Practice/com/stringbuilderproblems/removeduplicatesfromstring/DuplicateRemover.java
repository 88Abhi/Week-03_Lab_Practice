package com.stringbuilderproblems.removeduplicatesfromstring;

import java.util.HashSet;

// Class to remove duplicate characters from a string
class DuplicateRemover {
	// Method to remove duplicate characters while maintaining order
	public static String removeDuplicates(String input) {
		// Creating a StringBuilder to store the result
		StringBuilder stringBuilder = new StringBuilder();

		// Creating a HashSet to track unique characters
		HashSet<Character> seenCharacters = new HashSet<>();

		// Iterating through each character in the string
		for (char ch : input.toCharArray()) {
			// Checking if the character is already seen
			if (!seenCharacters.contains(ch)) {
				stringBuilder.append(ch);
				seenCharacters.add(ch);
			}
		}

		// Returning the modified string without duplicates
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		// Given input string
		String input = "programming";

		// Printing String with duplicates
		System.out.println("String with duplicates: " + input);

		// Removing duplicates and printing the result
		System.out.println("String without duplicates: " + removeDuplicates(input));
	}
}
