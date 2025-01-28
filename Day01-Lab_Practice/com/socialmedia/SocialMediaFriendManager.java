package com.socialmedia;

// Class that manages the social media friend connections
class SocialMediaFriendManager {
	// Head pointer for the list of users
	UserNode head;

	// Constructor to initialize the friend manager with no users
	public SocialMediaFriendManager() {
		this.head = null;
	}

	// Adds a new user to the social media network
	public void addUser(int userId, String name, int age) {
		// Creates a new user node with given details
		UserNode newUser = new UserNode(userId, name, age);

		// Checks if the list is empty
		if (head == null) {
			head = newUser;
			return;
		}

		// Initializes a temporary pointer to traverse the list of users
		UserNode temp = head;

		// Traverses to the end of the list to add the new user
		while (temp.next != null) {
			temp = temp.next;
		}

		// Adds the new user at the end of the list
		temp.next = newUser;
	}

	// Searches for a user by User ID
	private UserNode searchUserById(int userId) {
		// Initializes a temporary pointer to traverse the list of users
		UserNode temp = head;

		// Traverses the list until the user with the given ID is found
		while (temp != null) {
			if (temp.userId == userId) {
				return temp;
			}
			temp = temp.next;
		}

		// Returns null if the user is not found
		return null;
	}

	// Adds a friend connection between two users
	public void addFriendConnection(int userId1, int userId2) {
		// Searches for the two users by their IDs
		UserNode user1 = searchUserById(userId1);
		UserNode user2 = searchUserById(userId2);

		// If both users exist, add each other to their friend lists
		if (user1 != null && user2 != null) {
			user1.addFriend(userId2);
			user2.addFriend(userId1);
		}
	}

	// Removes a friend connection between two users
	public void removeFriendConnection(int userId1, int userId2) {
		// Searches for the two users by their IDs
		UserNode user1 = searchUserById(userId1);
		UserNode user2 = searchUserById(userId2);

		// If both users exist, remove each other from their friend lists
		if (user1 != null && user2 != null) {
			user1.removeFriend(userId2);
			user2.removeFriend(userId1);
		}
	}

	// Finds mutual friends between two users
	public void findMutualFriends(int userId1, int userId2) {
		// Searches for the two users by their IDs
		UserNode user1 = searchUserById(userId1);
		UserNode user2 = searchUserById(userId2);

		// If both users exist, proceed to find mutual friends
		if (user1 == null || user2 == null) {
			return;
		}

		// Traverses the friend list of user 1
		FriendListNode f1 = user1.friends;

		// Traverses the friend list of user 2
		FriendListNode f2 = user2.friends;

		// Prints the mutual friends between the two users
		System.out.println("\nMutual Friends between User " + userId1 + " and User " + userId2 + ":");

		// Iterates over the friends of user1
		while (f1 != null) {
			// Checks if any friend of user1 is also a friend of user2
			FriendListNode temp = f2;
			while (temp != null) {
				if (f1.friendId == temp.friendId) {
					System.out.println("Friend ID: " + f1.friendId);
				}
				temp = temp.next;
			}
			f1 = f1.next;
		}
	}

	// Displays all friends of a specific user
	public void displayFriends(int userId) {
		// Searches for the user by their ID
		UserNode user = searchUserById(userId);

		// If user does not exist, return
		if (user == null) {
			return;
		}

		// Initializes the friend list pointer for the user
		FriendListNode temp = user.friends;

		// Prints all friends of the user
		System.out.println("Friends of User " + userId + ":");

		// Iterates through the user's friend list and prints each friend ID
		while (temp != null) {
			System.out.println("Friend ID: " + temp.friendId);
			temp = temp.next;
		}
	}

	// Counts the number of friends for each user
	public void countFriends() {
		// Traverses through all users in the list
		UserNode temp = head;

		// Iterates through each user to count their friends
		while (temp != null) {
			int count = 0;

			// Traverses the user's friend list to count their friends
			FriendListNode f = temp.friends;

			while (f != null) {
				count++;
				f = f.next;
			}

			// Prints the total number of friends for the user
			System.out.println("User ID: " + temp.userId + " has " + count + " friends.");
			temp = temp.next;
		}
	}

	//Create Helper method to find a user by ID
	private UserNode findUserById(int userId) {
		UserNode current = head;
		while (current != null) {
			if (current.userId == userId) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	//Create Search for a user by Name or User ID
	public void searchUser(String nameOrId) {
		try {
			int userId = Integer.parseInt(nameOrId);
			UserNode user = findUserById(userId);
			if (user != null) {
				System.out.println("User found: " + user.name + ", Age: " + user.age);
			}
			else {
				System.out.println("User not found.");
			}
		}
		catch (NumberFormatException e) {
			UserNode current = head;
			while (current != null) {
				if (current.name.equalsIgnoreCase(nameOrId)) {
					System.out.println("User found: ID: " + current.userId + ", Age: " + current.age);
					return;
				}
				current = current.next;
			}
			System.out.println("User not found.");
		}
	}
}
