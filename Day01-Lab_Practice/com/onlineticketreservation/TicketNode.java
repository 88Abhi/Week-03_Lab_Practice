package com.onlineticketreservation;

// Class representing a node in the circular linked list, storing ticket details
class TicketNode {
	// Stores the unique Ticket ID
	int ticketId;

	// Stores the name of the customer who booked the ticket
	String customerName;

	// Stores the name of the movie for which the ticket is booked
	String movieName;

	// Stores the seat number assigned for the booking
	int seatNumber;

	// Stores the booking time in string format
	String bookingTime;

	// Stores the reference to the next ticket node in the circular linked list
	TicketNode next;

	// Constructor to initialize a ticket node with provided details
	public TicketNode(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
		// Initializing all the instance variables by provided values
		this.ticketId = ticketId;
		this.customerName = customerName;
		this.movieName = movieName;
		this.seatNumber = seatNumber;
		this.bookingTime = bookingTime;

		// Sets the next pointer as null initially
		this.next = null;
	}
}
