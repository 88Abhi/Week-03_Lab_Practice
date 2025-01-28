package com.roundrobinscheduling;

// Class that manages CPU scheduling using a circular linked list
class RoundRobinScheduler {
	// Head pointer to the circular linked list representing the process queue
	private ProcessNode head;

	// Time quantum for round-robin scheduling
	private final int TIME_QUANTUM;

	// Constructor to initialize an empty process queue and set the time quantum
	public RoundRobinScheduler(int timeQuantum) {
		this.head = null;
		this.TIME_QUANTUM = timeQuantum;
	}

	// Adds a new process at the end of the circular linked list
	public void addProcess(int processId, int burstTime, int priority) {
		// Creates a new process node with given details
		ProcessNode newNode = new ProcessNode(processId, burstTime, priority);

		// Checks if the circular queue is empty
		if (head == null) {
			head = newNode;
			head.next = head;
			return;
		}

		// Initializes a temporary pointer to traverse the circular list
		ProcessNode temp = head;

		// Traverses the list until the last node is reached
		while (temp.next != head) {
			temp = temp.next;
		}

		// Adds the new process node at the end of the list
		temp.next = newNode;

		// circular linkage by pointing the new node's next to head
		newNode.next = head;
	}

	// Removes a process by its Process ID after execution
	public void removeProcess(int processId) {
		// Checks if the circular queue is empty
		if (head == null) {
			return;
		}

		// Checks if the head node is the process to be removed
		if (head.processId == processId) {
			// Finds the last node in the circular list
			ProcessNode temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}

			// If only one node was present, set head to null
			if (head.next == head) {
				head = null;
			}
			else {
				// Updates the last node's next pointer to skip the head
				temp.next = head.next;
				head = head.next;
			}
			return;
		}

		// Initializes two pointers to find the target process
		ProcessNode current = head;
		ProcessNode prev = null;

		// Traverses the circular list to locate the process to be removed
		do {
			if (current.processId == processId) {
				prev.next = current.next;
				return;
			}
			prev = current;
			current = current.next;
		}
		while (current != head);
	}

	// Simulates round-robin scheduling for the processes
	public void simulateScheduling() {
		// Checks if the circular queue is empty
		if (head == null) {
			System.out.println("No processes in the queue.");
			return;
		}

		// Stores the initial number of processes
		int totalProcesses = countProcesses();
		int totalWaitingTime = 0;
		int totalTurnaroundTime = 0;
		int elapsedTime = 0;

		// Keeps executing processes in a round-robin manner
		ProcessNode current = head;

		// Continue processing while there are active processes
		while (head != null) {
			// Stores next process before modifying current
			ProcessNode nextProcess = current.next;

			// Checks if the process burst time is greater than the time quantum
			if (current.burstTime > TIME_QUANTUM) {
				System.out.println("Process " + current.processId + " executed for " + TIME_QUANTUM + " units.");

				// Reduces burst time by time quantum
				current.burstTime -= TIME_QUANTUM;
				elapsedTime += TIME_QUANTUM;
			}
			else {
				System.out.println("Process " + current.processId + " executed completely.");

				// Calculates turnaround time for the completed process
				totalTurnaroundTime += (elapsedTime + current.burstTime);

				// Removes the process after execution
				removeProcess(current.processId);
			}

			// If no processes remain, break the loop
			if (head == null) {
				break;
			}

			// Moves to the next process in the circular list
			current = nextProcess;

			// Ensures that `current` is not null
			if (current == null) {
				current = head;
			}

			// Displays the updated process queue after each round
			System.out.println("\nUpdated Process Queue:");
			displayProcesses();
		}

		// Calculates average waiting and turnaround time correctly
		double avgWaitingTime = (double) (totalTurnaroundTime - elapsedTime) / totalProcesses;
		double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;

		// Displays the average times
		System.out.println("\nFinal Statistics:");
		System.out.println("Average Waiting Time: " + avgWaitingTime);
		System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
	}


	// Displays the list of processes in the circular queue
	public void displayProcesses() {
		// Checks if the circular queue is empty
		if (head == null) {
			System.out.println("No processes in the queue.");
			return;
		}

		// Initializes a temporary pointer to traverse the circular list
		ProcessNode temp = head;

		// Iterates through the circular list and prints process details
		do {
			System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
			temp = temp.next;
		}
		while (temp != head);
	}

	//Create method to Count the total number of processes
	private int countProcesses() {
		if (head == null) {
			return 0;
		}

		int count = 0;
		ProcessNode current = head;
		do {
			count++;
			current = current.next;
		}
		while (current != head);

		return count;
	}
}
