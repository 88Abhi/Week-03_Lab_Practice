package com.onlineticketreservation;

// Class that manages the circular linked list for ticket reservations
class TicketReservationSystem {
	// Stores the reference to the head node (first ticket) of the circular linked list
	private TicketNode head;

	// Constructor to initialize an empty ticket reservation system
	public TicketReservationSystem() {
		this.head = null;
	}

	// Adds a new ticket reservation at the end of the circular linked list
	public void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
		// Creates a new ticket node with provided details
		TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);

		// Checks if the circular linked list is empty
		if (head == null) {
			head = newTicket;

			// Establishes circular connection
			head.next = head;
			return;
		}

		// Initializes a temporary pointer to traverse the list
		TicketNode temp = head;

		// Traverses the list until reaching the last node
		while (temp.next != head) {
			temp = temp.next;
		}

		// Adds the new ticket at the end of the list
		temp.next = newTicket;

		// Maintains circularity by linking the new ticket's next to the head
		newTicket.next = head;
	}

	// Removes a ticket by its Ticket ID
	public void removeTicket(int ticketId) {
		// Checks if the circular linked list is empty
		if (head == null) {
			return;
		}

		// Checks if the head node contains the ticket to be removed
		if (head.ticketId == ticketId) {
			TicketNode temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}

			// If only one ticket exists, set head to null
			if (head.next == head) {
				head = null;
			}
			else {
				temp.next = head.next;

				// Moves the head pointer to the next ticket
				head = head.next;
			}
			return;
		}

		// Initializes two pointers to find the target ticket
		TicketNode current = head;
		TicketNode prev = null;

		// Traverses the circular linked list to locate the ticket for removal
		do {
			if (current.ticketId == ticketId) {
				prev.next = current.next;
				return;
			}
			prev = current;
			current = current.next;
		}
		while (current != head);
	}

	// Searches for a ticket by Customer Name or Movie Name
	public void searchTicket(String query) {
		// Checks if the circular linked list is empty
		if (head == null) {
			System.out.println("No tickets available.");
			return;
		}

		// Initializes a pointer to traverse the circular linked list
		TicketNode temp = head;

		// Iterates through the list and searches for the query
		do {
			if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
				System.out.println("Ticket Found - Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
				return;
			}
			temp = temp.next;
		}
		while (temp != head);

		// Displays message if no matching ticket is found
		System.out.println("No matching ticket found.");
	}

	// Displays the current tickets in the circular linked list
	public void displayTickets() {
		// Checks if the circular linked list is empty
		if (head == null) {
			System.out.println("No tickets available.");
			return;
		}

		// Initializes a pointer to traverse the circular linked list
		TicketNode temp = head;

		// Iterates through the list and prints ticket details
		do {
			System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
			temp = temp.next;
		}
		while (temp != head);
	}

	// Counts the total number of booked tickets
	public int countTickets() {
		// Checks if the circular linked list is empty
		if (head == null) {
			return 0;
		}

		// Initializes the count variable
		int count = 0;

		// Initializes a pointer to traverse the circular linked list
		TicketNode temp = head;

		// Iterates through the list to count the total tickets
		do {
			count++;
			temp = temp.next;
		}
		while (temp != head);

		// Returns the total number of tickets
		return count;
	}
}

