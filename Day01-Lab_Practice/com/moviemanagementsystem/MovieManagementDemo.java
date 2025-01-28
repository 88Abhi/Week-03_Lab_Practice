package com.moviemanagementsystem;

// MovieManagementDemo class containing the main method
class MovieManagementDemo {
	public static void main(String[] args) {
		// Create an instance of the MovieManagementSystem
		MovieManagementSystem movieSystem = new MovieManagementSystem();

		// Add some movies to the list
		movieSystem.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
		movieSystem.addMovieAtEnd("Titanic", "James Cameron", 1997, 7.8);
		movieSystem.addMovieAtBeginning("The Godfather", "Francis Ford Coppola", 1972, 9.2);

		// Display all movies in forward order
		System.out.println("Movies in forward order:");
		movieSystem.displayMoviesForward();

		// Display all movies in reverse order
		System.out.println("\nMovies in reverse order:");
		movieSystem.displayMoviesReverse();

		// Search for a movie by director
		System.out.println("\nMovies by Christopher Nolan:");
		movieSystem.searchMovieByDirector("Christopher Nolan");

		// Remove a movie from the list
		movieSystem.removeMovieByTitle("Inception");

		// Update the rating of a movie
		System.out.println("\nTitanic's Rating Updated.");
		movieSystem.updateMovieRating("Titanic", 8.0);

		// Display all movies after removal
		System.out.println("\nMovies after removing Inception:");
		movieSystem.displayMoviesForward();
	}
}
