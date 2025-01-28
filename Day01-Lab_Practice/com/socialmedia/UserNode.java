package com.socialmedia;

// Class representing a user in the social media network
class UserNode {
	// Stores the unique user ID and age of the user
	int userId;
	int age;

	// Stores the name of the user
	String name;

	// Stores the list of friend IDs for the user
	FriendListNode friends;

	// Stores the reference to the next user in the singly linked list
	UserNode next;

	// Constructor to initialize a user with user ID, name, and age
	public UserNode(int userId, String name, int age) {
		// Initializing the user details
		this.userId = userId;
		this.name = name;
		this.age = age;

		// Initializing the friend list as null
		this.friends = null;

		// Initializing next node as null
		this.next = null;
	}

	// Adds a friend ID to the user's friend list
	public void addFriend(int friendId) {
		// Creates a new node for the friend ID
		FriendListNode newFriend = new FriendListNode(friendId);

		// Checks if the user has no friends yet
		if (friends == null) {
			friends = newFriend;
			return;
		}

		// Traverses to the end of the friend's list
		FriendListNode temp = friends;

		while (temp.next != null) {
			temp = temp.next;
		}

		// Adds the new friend at the end of the list
		temp.next = newFriend;
	}

	// Removes a friend ID from the user's friend list
	public void removeFriend(int friendId) {
		// Checks if the user has no friends
		if (friends == null) {
			return;
		}

		// Checks if the first friend in the list is the one to be removed
		if (friends.friendId == friendId) {
			friends = friends.next;
			return;
		}

		// Initializes current and previous pointers to traverse the friend list
		FriendListNode current = friends;
		FriendListNode prev = null;

		// Traverses the list to find the friend with the given friend ID
		while (current != null && current.friendId != friendId) {
			prev = current;
			current = current.next;
		}

		// If the friend is found, remove it by updating the next pointer of the previous node
		if (current != null) {
			prev.next = current.next;
		}
	}
}