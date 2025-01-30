package com.hashmapsandhashfunctions.customhashmap;

// Class containing the main method to test the custom hash map
class CustomHashMapMain {
	public static void main(String[] args) {
		// Creates an instance of the custom hash map
		CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();

		// Inserts key-value pairs into the hash map
		hashMap.put("Ajeet", 25);
		hashMap.put("Abhishek", 30);
		hashMap.put("Amit", 22);

		// Retrieves values associated with keys
		System.out.println("Age of Ajeet: " + hashMap.get("Ajeet"));
		System.out.println("Age of Abhishek: " + hashMap.get("Abhishek"));

		// Removes a key-value pair from the hash map
		hashMap.remove("Ankit");

		// Tries to retrieve the removed key
		System.out.println("Age of Ankit after removal: " + hashMap.get("Ankit"));

		// Displays the current size of the hash map
		System.out.println("Current size of HashMap: " + hashMap.size());
	}
}
