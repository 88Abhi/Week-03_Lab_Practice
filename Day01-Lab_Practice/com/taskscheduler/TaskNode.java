package com.taskscheduler;

// Represents a single task in the circular linked list
class TaskNode {
	// Stores the unique task ID
	int taskId;

	// Stores the task name
	String taskName;

	// Stores the priority of the task
	int priority;

	// Stores the due date of the task
	String dueDate;

	// Points to the next task in the circular linked list
	TaskNode next;

	// Constructor to initialize a task node with given details
	public TaskNode(int taskId, String taskName, int priority, String dueDate) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.priority = priority;
		this.dueDate = dueDate;
		this.next = null;
	}
}
