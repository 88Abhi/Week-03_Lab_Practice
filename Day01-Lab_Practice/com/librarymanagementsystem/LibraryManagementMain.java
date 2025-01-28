package com.librarymanagementsystem;

// LibraryManagementMain class to test the library management system
class LibraryManagementMain {
	public static void main(String[] args) {
		// Creates an instance of the library management system
		LibraryManagementSystem library = new LibraryManagementSystem();

		// Adds books to the library
		library.addBookAtBeginning("Book A", "Author X", "Fiction", 101, true);
		library.addBookAtEnd("Book B", "Author Y", "Non-Fiction", 102, true);
		library.addBookAtEnd("Book C", "Author Z", "Science", 103, false);

		// Displays books in forward order
		System.out.println("\nDisplaying Books (Forward Order):");
		library.displayBooksForward();

		// Displays books in reverse order
		System.out.println("\nDisplaying Books (Reverse Order):");
		library.displayBooksReverse();

		// Counts and prints the total number of books
		System.out.println("\nTotal Books: " + library.countBooks());

		// Searches for a book by title
		String searchTitle = "Book A";
		BookNode foundBook = library.searchBook(searchTitle);
		if (foundBook != null) {
			System.out.println("\nBook Found: " + foundBook.title + " by " + foundBook.author);
		}
		else {
			System.out.println("\nBook Not Found: " + searchTitle);
		}

		// Updates the availability status of a book
		System.out.println("\nUpdating Availability of Book ID 103.");
		library.updateAvailabilityStatus(103, true);

		// Displays updated book list
		System.out.println("\nDisplaying Books After Availability Update:");
		library.displayBooksForward();

		// Removes a book from the library
		System.out.println("\nRemoving Book with ID 102");
		library.removeBook(102);

		// Displays final book list after removal
		System.out.println("\nDisplaying Books After Removal:");
		library.displayBooksForward();

		// Displays total count of books after removal
		System.out.println("\nTotal Books After Removal: " + library.countBooks());
	}
}
