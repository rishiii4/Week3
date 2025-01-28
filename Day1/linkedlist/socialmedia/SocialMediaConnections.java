package linkedlist.socialmedia;

public class SocialMediaConnections {
    private UserNode head;

    // Add a new user to the list
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    // Find a user node by User ID
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

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.friendIds.remove(Integer.valueOf(userId2));
        user2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friendIds) {
            UserNode friend = findUserById(friendId);
            if (friend != null) {
                System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ":");
        for (int friendId1 : user1.friendIds) {
            if (user2.friendIds.contains(friendId1)) {
                UserNode mutualFriend = findUserById(friendId1);
                if (mutualFriend != null) {
                    System.out.println("- " + mutualFriend.name + " (ID: " + mutualFriend.userId + ")");
                }
            }
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, int userId) {
        UserNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name) || current.userId == userId) {
                System.out.println("User found: " + current.name + " (ID: " + current.userId + "), Age: " + current.age);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("User not found.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode current = head;
        System.out.println("Number of friends for each user:");
        while (current != null) {
            System.out.println(current.name + " (ID: " + current.userId + ") has " + current.friendIds.size() + " friends.");
            current = current.next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SocialMediaConnections smc = new SocialMediaConnections();

        // Add users
        smc.addUser(1, "Raju", 25);
        smc.addUser(2, "Shyam", 28);
        smc.addUser(3, "Sher", 22);
        smc.addUser(4, "Tiger", 30);

        // Add friend connections
        smc.addFriendConnection(1, 2);
        smc.addFriendConnection(1, 3);
        smc.addFriendConnection(2, 4);

        // Display friends
        smc.displayFriends(1);
        smc.displayFriends(2);

        // Find mutual friends
        smc.findMutualFriends(1, 2);

        // Search for users
        smc.searchUser("Rakesh", 0);
        smc.searchUser("", 4);

        // Count friends
        smc.countFriends();

        // Remove friend connection
        smc.removeFriendConnection(1, 3);
        smc.displayFriends(1);
    }
}