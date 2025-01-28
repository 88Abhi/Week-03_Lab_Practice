package com.inventorymanagementsystem;


// Class that manages the inventory using a singly linked list
class InventoryManagementSystem {
	// Head pointer to the linked list representing the inventory
	private InventoryNode head;

	// Constructor to initialize an empty inventory list
	public InventoryManagementSystem() {
		this.head = null;
	}

	// Adds an item at the beginning of the inventory list
	public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
		// Creates a new node with given item details
		InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
		// Sets the new node's next pointer to the current head
		newNode.next = head;
		// Updates the head to point to the new node
		head = newNode;
	}

	// Adds an item at the end of the inventory list
	public void addAtEnd(String itemName, int itemId, int quantity, double price) {
		// Creates a new node with given item details
		InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
		// Checks if the inventory list is empty
		if (head == null) {
			head = newNode;
			return;
		}
		// Initializes a temporary pointer to traverse the list
		InventoryNode temp = head;
		// Traverses the list until the last node is reached
		while (temp.next != null) {
			temp = temp.next;
		}
		// Sets the last node's next pointer to the new node
		temp.next = newNode;
	}

	// Adds an item at a specific position in the inventory list
	public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
		// Creates a new node with given item details
		InventoryNode newNode = new InventoryNode(itemName, itemId, quantity, price);
		// Checks if the position is at the beginning
		if (position == 1) {
			newNode.next = head;
			head = newNode;
			return;
		}
		// Initializes a temporary pointer to traverse the list
		InventoryNode temp = head;
		// Moves to the node just before the desired position
		for (int i = 1; temp != null && i < position - 1; i++) {
			temp = temp.next;
		}
		// Checks if the position is valid
		if (temp == null) {
			return;
		}
		// Inserts the new node at the given position
		newNode.next = temp.next;
		temp.next = newNode;
	}

	// Removes an item based on its unique item ID
	public void removeItem(int itemId) {
		// Checks if the inventory list is empty
		if (head == null) {
			return;
		}
		// Checks if the first node contains the item to be removed
		if (head.itemId == itemId) {
			head = head.next;
			return;
		}
		// Initializes a temporary pointer to find the item
		InventoryNode temp = head;
		// Traverses the list to find the node before the target node
		while (temp.next != null && temp.next.itemId != itemId) {
			temp = temp.next;
		}
		// Checks if the target node is found and removes it
		if (temp.next != null) {
			temp.next = temp.next.next;
		}
	}

	// Updates the quantity of an item based on its item ID
	public void updateQuantity(int itemId, int newQuantity) {
		// Initializes a temporary pointer to traverse the list
		InventoryNode temp = head;
		// Traverses the list to find the target item
		while (temp != null) {
			// Checks if the current node matches the item ID
			if (temp.itemId == itemId) {
				temp.quantity = newQuantity;
				return;
			}
			// Moves to the next node
			temp = temp.next;
		}
	}

	// Searches for an item based on its item ID
	public InventoryNode searchByItemId(int itemId) {
		// Initializes a temporary pointer to traverse the list
		InventoryNode temp = head;
		// Traverses the list to find the item with the given ID
		while (temp != null) {
			if (temp.itemId == itemId) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	// Searches for an item based on its item name
	public InventoryNode searchByItemName(String itemName) {
		// Initializes a temporary pointer to traverse the list
		InventoryNode temp = head;
		// Traverses the list to find the item with the given name
		while (temp != null) {
			if (temp.itemName.equalsIgnoreCase(itemName)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	// Calculates and displays the total value of the inventory
	public double calculateTotalValue() {
		// Initializes a total value accumulator
		double totalValue = 0;
		// Initializes a temporary pointer to traverse the list
		InventoryNode temp = head;
		// Traverses the list and accumulates the total inventory value
		while (temp != null) {
			totalValue += temp.quantity * temp.price;
			temp = temp.next;
		}
		return totalValue;
	}

	// Displays all items in the inventory list
	public void displayInventory() {
		// Initializes a temporary pointer to traverse the list
		InventoryNode temp = head;
		// Traverses the list and prints item details
		while (temp != null) {
			System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
			temp = temp.next;
		}
	}

	// Sorting Function: Sorts inventory based on itemId using Bubble Sort
	public void sortInventoryByItemId() {
		// No need to sort if list is empty or has only one item
		if (head == null || head.next == null) {
			return;
		}
		// swap items to arrange them in ascending order
		boolean swapped;
		do {
			swapped = false;
			InventoryNode current = head;
			InventoryNode prev = null;

			while (current.next != null) {
				if (current.itemId > current.next.itemId) {
					// Swap item details
					String tempName = current.itemName;
					int tempId = current.itemId;
					int tempQuantity = current.quantity;
					double tempPrice = current.price;

					current.itemName = current.next.itemName;
					current.itemId = current.next.itemId;
					current.quantity = current.next.quantity;
					current.price = current.next.price;

					current.next.itemName = tempName;
					current.next.itemId = tempId;
					current.next.quantity = tempQuantity;
					current.next.price = tempPrice;

					swapped = true;
				}
				prev = current;
				current = current.next;
			}
		}
		while (swapped);
	}
}

