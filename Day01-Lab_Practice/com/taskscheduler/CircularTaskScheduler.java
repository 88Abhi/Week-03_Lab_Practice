package com.taskscheduler;

// CircularTaskScheduler class to demonstrate task operations
class CircularTaskScheduler {
	public static void main(String[] args) {
		// Creates an instance of the TaskScheduler
		TaskScheduler scheduler = new TaskScheduler();

		// Adds tasks to the scheduler
		scheduler.addTaskAtBeginning(1, "Task A", 2, "2025-02-10");
		scheduler.addTaskAtEnd(2, "Task B", 1, "2025-02-15");
		scheduler.addTaskAtPosition(3, "Task C", 3, "2025-02-20", 2);

		// Displays all tasks
		System.out.println("Added Tasks:");
		scheduler.displayAllTasks();

		// Removes a task by Task ID
		System.out.println("\nAfter removing a task: ");
		scheduler.removeTaskById(2);
		scheduler.displayAllTasks();

		// Searches for tasks with priority 2
		System.out.println("\nThe taks of priority 2 is: ");
		scheduler.searchTaskByPriority(2);

		// Views and moves to next task
		System.out.println("\nCurrent tasks are: ");
		scheduler.viewCurrentAndMoveToNext();
	}
}
