package com.roundrobinscheduling;

// Class representing a process node in the circular linked list
class ProcessNode {
	// Stores the unique process ID
	int processId;

	// Stores the burst time required by the process
	int burstTime;

	// Stores the priority of the process
	int priority;

	// Pointer to the next process in the circular linked list
	ProcessNode next;

	// Constructor to initialize a process node with given values
	public ProcessNode(int processId, int burstTime, int priority) {
		this.processId = processId;
		this.burstTime = burstTime;
		this.priority = priority;
		this.next = null;
	}
}