package com.studentrecordmanagement;

// StudentRecordManagement class to manage student records
public class StudentRecordManagement {
	public static void main(String[] args) {
		// Creates an instance of StudentRecordList
		StudentRecordList studentList = new StudentRecordList();

		// Adds student records with default values
		studentList.addAtEnd(101, "Abhishek", 20, "A");
		studentList.addAtEnd(102, "Ajeet", 21, "B");
		studentList.addAtEnd(103, "Amit", 22, "C");

		// Displays initial student records
		System.out.println("Initial Student Records:");
		studentList.displayRecords();

		// Adds a student at the beginning
		studentList.addAtBeginning(100, "Rohan", 19, "A+");

		// Displays student records after insertion
		System.out.println("\nStudent Records after Insertion:");
		studentList.displayRecords();

		// Updates a student's grade
		studentList.updateGrade(102, "A");

		// Displays student records after update
		System.out.println("\nStudent Records after Grade Update:");
		studentList.displayRecords();

		System.out.println("\nStudent of roll no 101 is: ");
		System.out.println(studentList.searchByRollNumber(101).name);

		// Deletes a student by roll number
		studentList.deleteByRollNumber(103);

		// Displays student records after deletion
		System.out.println("\nStudent Records after Deletion:");
		studentList.displayRecords();
	}
}
