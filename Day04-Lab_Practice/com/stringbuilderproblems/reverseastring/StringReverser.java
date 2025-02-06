package com.stringbuilderproblems.reverseastring;

// Class to reverse a string using StringBuilder
class StringReverser {
	// Method to reverse a string using StringBuilder
	public static String reverseString(String input) {
		// Creating a StringBuilder object with the input string
		StringBuilder stringBuilder = new StringBuilder(input);

		// Using the reverse() method to reverse the string
		stringBuilder.reverse();

		// Converting the StringBuilder back to a string
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		// Given input string
		String input = "hello";

		// String before reverse
		System.out.println("Before Reverse: " + input);

		// Printing the resultant reversed string
		System.out.println("Reversed string: " + reverseString(input));
	}
}
