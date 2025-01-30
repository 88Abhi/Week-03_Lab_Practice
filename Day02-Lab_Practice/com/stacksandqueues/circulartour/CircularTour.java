package com.stacksandqueues.circulartour;

// Importing queue to use internal methods
import java.util.LinkedList;
import java.util.Queue;

// Class to determine the starting point of the circular tour
class CircularTour {
	// Method to find the starting petrol pump index
	public static int findStartingPump(int[] petrol, int[] distance) {
		// Creates a queue to store petrol pump indices
		Queue<Integer> petrolPumpQueue = new LinkedList<>();

		// Variable to track the total petrol available
		int totalPetrol = 0;

		// Variable to track the total distance
		int totalDistance = 0;

		// Variable to track the current surplus petrol
		int currentSurplus = 0;

		// Variable to store the starting index
		int startIndex = 0;

		// Iterates through each petrol pump in the circular path
		for (int i = 0; i < petrol.length; i++) {
			// Updates total petrol available
			totalPetrol += petrol[i];
			totalDistance += distance[i];
			currentSurplus += petrol[i] - distance[i];

			// Adds the current petrol pump index to the queue
			petrolPumpQueue.add(i);

			// Checks if the current surplus is negative
			if (currentSurplus < 0) {
				petrolPumpQueue.clear();
				startIndex = i + 1;
				currentSurplus = 0;
			}
		}

		// Checks if the total petrol is greater than or equal to the total distance
		if (totalPetrol >= totalDistance) {
			return startIndex;
		}

		// Returns -1 if no valid circular tour is possible
		return -1;
	}
}
