package com.roundrobinscheduling;

// RoundRobinMain class to test the Round Robin Scheduling system
class RoundRobinMain {
	public static void main(String[] args) {
		// Creates an instance of the round-robin scheduler with a fixed time quantum
		RoundRobinScheduler scheduler = new RoundRobinScheduler(4);

		// Adds processes to the scheduling queue
		scheduler.addProcess(1, 4, 3);
		scheduler.addProcess(2, 5, 2);
		scheduler.addProcess(3, 8, 1);
		scheduler.addProcess(4, 6, 4);

		// Displays the initial process queue
		System.out.println("Initial Process Queue:");
		scheduler.displayProcesses();

		// Simulates the round-robin scheduling
		System.out.println("\nSimulating Round Robin Scheduling:");
		scheduler.simulateScheduling();

		// Displays the final state of the process queue
		System.out.println("\nFinal Process Queue:");
		scheduler.displayProcesses();
	}
}

