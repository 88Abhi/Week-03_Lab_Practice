package com.moviemanagementsystem;

// Class to manage the movie database using a doubly linked list
class MovieManagementSystem {
	// Head pointer to the first movie node in the list
	private MovieNode head;

	// Tail pointer to the last movie node in the list
	private MovieNode tail;

	// Constructor to initialize the doubly linked list
	public MovieManagementSystem() {
		this.head = null;
		this.tail = null;
	}

	// Method to add a movie at the beginning of the list
	public void addMovieAtBeginning(String movieTitle, String director, int yearOfRelease, double rating) {
		// Create a new movie node with the provided details
		MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);

		// Check if the list is empty
		if (head == null) {
			// If empty, set head and tail to the new node
			head = tail = newNode;
		}
		else {
			// Otherwise, update pointers to insert at the beginning
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	// Method to add a movie at the end of the list
	public void addMovieAtEnd(String movieTitle, String director, int yearOfRelease, double rating) {
		// Create a new movie node with the provided details
		MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);

		// Check if the list is empty
		if (tail == null) {
			// If empty, set head and tail to the new node
			head = tail = newNode;
		}
		else {
			// Otherwise, update pointers to insert at the end
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	// Method to remove a movie by its title
	public void removeMovieByTitle(String movieTitle) {
		// Start from the head of the list
		MovieNode temp = head;

		// Traverse the list to find the movie
		while (temp != null) {
			// If the movie title matches, remove the node
			if (temp.movieTitle.equals(movieTitle)) {
				// If it is the head node
				if (temp == head) {
					head = temp.next;
					if (head != null) {
						head.prev = null;
					}
				}
				// If it is the tail node
				else if (temp == tail) {
					tail = temp.prev;
					if (tail != null) {
						tail.next = null;
					}
				}
				// If it is in the middle
				else {
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}
				return;
			}
			temp = temp.next;
		}
	}

	// Method to search for a movie by its director
	public void searchMovieByDirector(String director) {
		// Start from the head of the list
		MovieNode temp = head;

		// Traverse the list to find movies by the director
		while (temp != null) {
			// If director matches, print movie details
			if (temp.director.equals(director)) {
				System.out.println("Movie: " + temp.movieTitle + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
			}
			temp = temp.next;
		}
	}

	// Method to search for a movie by its rating
	public void searchMovieByRating(double rating) {
		// Start from the head of the list
		MovieNode temp = head;

		// Traverse the list to find movies with the given rating
		while (temp != null) {
			// If rating matches, print movie details
			if (temp.rating == rating) {
				System.out.println("Movie: " + temp.movieTitle + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease);
			}
			temp = temp.next;
		}
	}

	// Method to update the rating of a movie based on its title
	public void updateMovieRating(String movieTitle, double newRating) {
		// Start from the head of the list
		MovieNode temp = head;

		// Traverse the list to find the movie
		while (temp != null) {
			// If the movie title matches, update the rating
			if (temp.movieTitle.equals(movieTitle)) {
				temp.rating = newRating;
				return;
			}
			temp = temp.next;
		}
	}

	// Method to display all movie records in forward order
	public void displayMoviesForward() {
		// Start from the head of the list
		MovieNode temp = head;

		// Traverse the list and print movie details
		while (temp != null) {
			System.out.println("Title: " + temp.movieTitle + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
			temp = temp.next;
		}
	}

	// Method to display all movie records in reverse order
	public void displayMoviesReverse() {
		// Start from the tail of the list
		MovieNode temp = tail;

		// Traverse the list in reverse and print movie details
		while (temp != null) {
			System.out.println("Title: " + temp.movieTitle + ", Director: " + temp.director + ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
			temp = temp.prev;
		}
	}
}