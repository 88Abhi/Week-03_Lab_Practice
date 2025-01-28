package com.librarymanagementsystem;

// Class that manages the library using a doubly linked list
class LibraryManagementSystem {
	// Head pointer to the doubly linked list representing the library
	private BookNode head;

	// Constructor to initialize an empty library list
	public LibraryManagementSystem() {
		this.head = null;
	}

	// Adds a new book at the beginning of the library list
	public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
		// Creates a new node with book details
		BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);

		// Sets the new node's next pointer to the current head
		newNode.next = head;

		// If the list is not empty, updates the previous pointer of the old head
		if (head != null) {
			head.prev = newNode;
		}
		// Updates the head to the new node
		head = newNode;
	}

	// Adds a new book at the end of the library list
	public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
		// Creates a new node with book details
		BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);

		// Checks if the list is empty, then sets head to the new node
		if (head == null) {
			head = newNode;
			return;
		}
		// Initializes a temporary pointer to traverse the list
		BookNode temp = head;

		// Traverses to the last node
		while (temp.next != null) {
			temp = temp.next;
		}

		// Sets the last node's next pointer to the new node
		temp.next = newNode;

		// Sets the new node's previous pointer to the last node
		newNode.prev = temp;
	}

	// Adds a new book at a specific position in the library list
	public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
		// Creates a new node with book details
		BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);

		// Checks if the position is at the beginning
		if (position == 1) {
			newNode.next = head;
			if (head != null) {
				head.prev = newNode;
			}
			head = newNode;
			return;
		}

		// Initializes a temporary pointer to traverse the list
		BookNode temp = head;

		// Moves to the node just before the desired position
		for (int i = 1; temp != null && i < position - 1; i++) {
			temp = temp.next;
		}

		// Checks if the position is valid
		if (temp == null) {
			return;
		}

		// Inserts the new node at the given position
		newNode.next = temp.next;
		if (temp.next != null) {
			temp.next.prev = newNode;
		}
		temp.next = newNode;
		newNode.prev = temp;
	}

	// Removes a book from the library list based on Book ID
	public void removeBook(int bookId) {
		// Checks if the library is empty
		if (head == null) {
			return;
		}

		// Initializes a temporary pointer to traverse the list
		BookNode temp = head;

		// Traverses the list to find the target book
		while (temp != null && temp.bookId != bookId) {
			temp = temp.next;
		}

		// Checks if the book is found
		if (temp == null) {
			return;
		}

		// Updates pointers to remove the book
		if (temp.prev != null) {
			temp.prev.next = temp.next;
		}
		else {
			head = temp.next;
		}
		if (temp.next != null) {
			temp.next.prev = temp.prev;
		}
	}

	// Searches for a book based on Book Title or Author
	public BookNode searchBook(String query) {
		// Initializes a temporary pointer to traverse the list
		BookNode temp = head;

		// Traverses the list to find a matching book
		while (temp != null) {
			if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	// Updates the availability status of a book
	public void updateAvailabilityStatus(int bookId, boolean newStatus) {
		// Initializes a temporary pointer to traverse the list
		BookNode temp = head;

		// Traverses the list to find the book
		while (temp != null) {
			if (temp.bookId == bookId) {
				temp.isAvailable = newStatus;
				return;
			}
			temp = temp.next;
		}
	}

	// Displays all books in the library in forward order
	public void displayBooksForward() {
		// Initializes a temporary pointer to traverse the list
		BookNode temp = head;

		// Traverses the list and prints book details
		while (temp != null) {
			System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
			temp = temp.next;
		}
	}

	// Displays all books in the library in reverse order
	public void displayBooksReverse() {
		// Initializes a temporary pointer to traverse to the last node
		BookNode temp = head;
		if (temp == null) {
			return;
		}
		while (temp.next != null) {
			temp = temp.next;
		}

		// Traverses the list backward and prints book details
		while (temp != null) {
			System.out.println("Book ID: " + temp.bookId + ", Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
			temp = temp.prev;
		}
	}

	// Counts the total number of books in the library
	public int countBooks() {
		// Initializes a counter
		int count = 0;

		// Initializes a temporary pointer to traverse the list
		BookNode temp = head;

		// Traverses the list and increments the counter
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
}
