package com.linearsearchproblems.searchspecificwordinsentences;

// class to search a word in a sentence
class SentenceSearch {
	// Method to find the first sentence containing a specific word using linear search
	public static String findSentenceWithWord(String[] sentences, String word) {
		// Iterating through the array of sentences
		for (String sentence : sentences) {
			// Checking if the sentence contains the required word
			if (sentence.contains(word)) {
				return sentence;
			}
		}

		// Returning "Not Found" if the word is not present
		return "Not Found";
	}

	public static void main(String[] args) {
		// Defining an array of sentences
		String[] sentences = {"Java is powerful", "Linear search is easy", "Binary search is efficient"};

		// Defining the target word
		String word = "search";

		// Printing the string array
		System.out.print("String array is: ");
		for (String sentence : sentences) {
			System.out.print(sentence + ", ");
		}

		// Calling the function to find the first sentence containing the word
		String result = findSentenceWithWord(sentences, word);

		// Printing the result
		System.out.println("\nSentence that contains '" + word + "' is: " + result);
	}
}
