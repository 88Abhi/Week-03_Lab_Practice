package com.librarymanagementsystem;

// Class representing a node in the doubly linked list
class BookNode {
	// Stores the title, genre and author of the book
	String title;
	String author;
	String genre;

	// Stores the unique Book ID
	int bookId;

	// Stores the availability status
	boolean isAvailable;

	// Pointer to the next node in the linked list
	BookNode next;

	// Pointer to the previous node in the linked list
	BookNode prev;

	// Constructor to initialize the book node with given details
	public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.bookId = bookId;
		this.isAvailable = isAvailable;
		this.next = null;
		this.prev = null;
	}
}
