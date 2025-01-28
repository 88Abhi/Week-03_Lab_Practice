package com.moviemanagementsystem;

// Class representing a node in the doubly linked list
class MovieNode {
	// Stores the title and director of the movie
	String movieTitle;
	String director;

	// Stores the year of release and rating of the movie
	int yearOfRelease;
	double rating;

	// Pointer to the next node in the doubly linked list
	MovieNode next;

	// Pointer to the previous node in the doubly linked list
	MovieNode prev;

	// Constructor to initialize a movie node with details
	public MovieNode(String movieTitle, String director, int yearOfRelease, double rating) {
		this.movieTitle = movieTitle;
		this.director = director;
		this.yearOfRelease = yearOfRelease;
		this.rating = rating;
		this.next = null;
		this.prev = null;
	}
}


