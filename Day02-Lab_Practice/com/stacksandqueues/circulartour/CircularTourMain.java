package com.stacksandqueues.circulartour;

import java.util.Arrays;

// Class containing the main method to test the solution
class CircularTourMain {
	public static void main(String[] args) {

		// Defines an array representing petrol available at each pump
		int[] petrol = {4, 6, 7, 4};

		// Defines an array representing the distance to the next petrol pump
		int[] distance = {6, 5, 3, 5};

		// Calls the method to find the starting petrol pump index
		int startingPumpIndex = CircularTour.findStartingPump(petrol, distance);
		
		// Printing Petrol array
		System.out.println("Petrol Array: " + Arrays.toString(petrol));

		// Prints the result showing the index of the starting petrol pump
		System.out.println("\nStarting Petrol Pump Index: " + startingPumpIndex);
	}
}

