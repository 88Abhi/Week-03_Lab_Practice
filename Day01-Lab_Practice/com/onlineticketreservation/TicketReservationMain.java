package com.onlineticketreservation;

// TicketReservationMain class to demonstrate the online ticket reservation system
public class TicketReservationMain {
	public static void main(String[] args) {
		// Initializes the Ticket Reservation System instance
		TicketReservationSystem system = new TicketReservationSystem();

		// Adds multiple ticket reservations
		system.addTicket(101, "Abhishek", "Avengers", 12, "10:00 AM");
		system.addTicket(102, "Ajeet", "Batman", 18, "1:00 PM");
		system.addTicket(103, "Amit", "Superman", 25, "3:00 PM");

		// Displays all booked tickets
		System.out.println("Initial booked tickets are: ");
		system.displayTickets();

		// Searches for a ticket by customer name
		System.out.println("\nTicket of Abhishek is: ");
		system.searchTicket("Abhishek");

		// Searches for a ticket by movie name
		System.out.println("\nTicket of movie Superman is: ");
		system.searchTicket("Superman");

		// Removes a ticket by Ticket ID
		System.out.println("\nRemoving ticket of id 102.");
		system.removeTicket(102);

		// Displays all tickets after removal
		System.out.println("\nAfter removal remaining tickets: ");
		system.displayTickets();

		// Displays the total number of tickets booked
		System.out.println("\nTotal Booked Tickets: " + system.countTickets());
	}
}
