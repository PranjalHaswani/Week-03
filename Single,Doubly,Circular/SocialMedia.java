package com.day1;
import java.util.*;

class FriendListNode {
    int friendId;
    FriendListNode next;

    public FriendListNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendListNode friends;  // Linked list to store friend IDs
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}

class SocialMediaSystem {
    private UserNode head;

    public SocialMediaSystem() {
        head = null;
    }

    // Add a user
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Add a friend connection between two users
    public void addFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            addFriendToUser(user1, userId2);
            addFriendToUser(user2, userId1);
            System.out.println("Friendship added between " + userId1 + " and " + userId2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Helper method to add a friend to a user's friend list
    private void addFriendToUser(UserNode user, int friendId) {
        FriendListNode newFriend = new FriendListNode(friendId);
        if (user.friends == null) {
            user.friends = newFriend;
        } else {
            FriendListNode temp = user.friends;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newFriend;
        }
    }

    // Remove a friend connection between two users
    public void removeFriend(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            removeFriendFromUser(user1, userId2);
            removeFriendFromUser(user2, userId1);
            System.out.println("Friendship removed between " + userId1 + " and " + userId2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Helper method to remove a friend from a user's friend list
    private void removeFriendFromUser(UserNode user, int friendId) {
        if (user.friends == null) return;

        // Check if the friend to be removed is the first in the list
        if (user.friends.friendId == friendId) {
            user.friends = user.friends.next;
            return;
        }

        FriendListNode temp = user.friends;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            Set<Integer> user1Friends = getFriendsSet(user1);
            Set<Integer> user2Friends = getFriendsSet(user2);

            user1Friends.retainAll(user2Friends); // Find the intersection (mutual friends)

            if (user1Friends.isEmpty()) {
                System.out.println("No mutual friends between " + userId1 + " and " + userId2);
            } else {
                System.out.println("Mutual friends between " + userId1 + " and " + userId2 + ": " + user1Friends);
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Helper method to get the set of friends for a user
    private Set<Integer> getFriendsSet(UserNode user) {
        Set<Integer> friendsSet = new HashSet<>();
        FriendListNode temp = user.friends;
        while (temp != null) {
            friendsSet.add(temp.friendId);
            temp = temp.next;
        }
        return friendsSet;
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user != null) {
            System.out.print("Friends of " + user.name + ": ");
            FriendListNode temp = user.friends;
            if (temp == null) {
                System.out.println("No friends.");
            } else {
                while (temp != null) {
                    System.out.print(temp.friendId + " ");
                    temp = temp.next;
                }
                System.out.println();
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Search for a user by User ID
    public UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Search for a user by Name
    public UserNode findUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode temp = head;
        while (temp != null) {
            int count = 0;
            FriendListNode friendTemp = temp.friends;
            while (friendTemp != null) {
                count++;
                friendTemp = friendTemp.next;
            }
            System.out.println(temp.name + " has " + count + " friends.");
            temp = temp.next;
        }
    }
}

public class SocialMedia{
    public static void main(String[] args) {
        SocialMediaSystem system = new SocialMediaSystem();

        // Add users
        system.addUser(1, "Alice", 25);
        system.addUser(2, "Bob", 30);
        system.addUser(3, "Charlie", 22);
        system.addUser(4, "David", 28);

        // Add friend connections
        system.addFriend(1, 2); // Alice and Bob are friends
        system.addFriend(1, 3); // Alice and Charlie are friends
        system.addFriend(2, 4); // Bob and David are friends
        system.addFriend(3, 4); // Charlie and David are friends

        // Display friends of Alice
        system.displayFriends(1); // Alice's friends

        // Find mutual friends between Alice and Bob
        system.findMutualFriends(1, 2);

        // Remove a friend connection
        system.removeFriend(1, 3); // Alice and Charlie are no longer friends

        // Display friends of Alice after removal
        system.displayFriends(1); // Alice's friends after removal

        // Search for a user by name
        UserNode user = system.findUserByName("David");
        if (user != null) {
            System.out.println("Found user: " + user.name + ", Age: " + user.age);
        }

        // Count the number of friends for each user
        system.countFriends();
    }
}

