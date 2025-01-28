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
			// Points the next of the new node to itself to maintain circularity
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

				// Moves head to the next node
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

		// Initializes time counters
		int totalProcesses = 0;
		int totalWaitingTime = 0;
		int totalTurnaroundTime = 0;

		// Keeps executing processes in a round-robin manner
		ProcessNode current = head;
		do {
			// Checks if the process burst time is greater than the time quantum
			if (current.burstTime > TIME_QUANTUM) {
				System.out.println("Process " + current.processId + " executed for " + TIME_QUANTUM + " units.");

				// Reduces burst time by time quantum
				current.burstTime -= TIME_QUANTUM;
			}
			else {
				System.out.println("Process " + current.processId + " executed completely.");

				// Adds waiting time calculation (turnaround time - burst time)
				totalTurnaroundTime += current.burstTime;

				// Removes the process after execution
				removeProcess(current.processId);
			}

			// Moves to the next process in the circular list
			current = current.next;
		}
		while (head != null);

		// Calculates average waiting and turnaround time
		double avgWaitingTime = (double) totalWaitingTime / totalProcesses;
		double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;

		// Displays the average times
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
}
