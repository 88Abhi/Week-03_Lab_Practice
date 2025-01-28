package com.socialmedia;

// Class representing a friend's ID in a user's friend list
class FriendListNode {
	// Stores the friend ID
	int friendId;

	// Stores the reference to the next friend in the list
	FriendListNode next;

	// Constructor to initialize a friend with a given ID
	public FriendListNode(int friendId) {
		// Initializes the friend ID
		this.friendId = friendId;

		// Sets next pointer to null as default
		this.next = null;
	}
}