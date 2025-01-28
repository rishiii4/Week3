package linkedlist.librarymanagement;

public class LibraryManagement {
    private BookNode head;
    private BookNode tail;

    // Add a book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a book at the end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a book at a specific position
    public void addAtPosition(int position, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        BookNode newNode = new BookNode(title, author, genre, bookId, isAvailable);
        BookNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position exceeds the size of the library.");
        } else {
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    // Remove a book by Book ID
    public void removeById(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        System.out.println("Book with ID " + bookId + " removed.");
    }

    // Search for a book by Title or Author
    public void searchBook(String title, String author) {
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title) || current.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: [Title: " + current.title + ", Author: " + current.author +
                        ", Genre: " + current.genre + ", Book ID: " + current.bookId +
                        ", Availability: " + (current.isAvailable ? "Available" : "Not Available") + "]");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    // Update a book's Availability Status
    public void updateAvailability(int bookId, boolean isAvailable) {
        BookNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Availability status updated for Book ID " + bookId);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author +
                    ", Genre: " + current.genre + ", Book ID: " + current.bookId +
                    ", Availability: " + (current.isAvailable ? "Available" : "Not Available"));
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        BookNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author +
                    ", Genre: " + current.genre + ", Book ID: " + current.bookId +
                    ", Availability: " + (current.isAvailable ? "Available" : "Not Available"));
            current = current.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        // Add books
        library.addAtEnd("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101, true);
        library.addAtBeginning("1984", "George Orwell", "Dystopian", 102, true);
        library.addAtPosition(2, "To Kill a Mockingbird", "Harper Lee", "Classic", 103, false);

        // Display all books
        System.out.println("Books in forward order:");
        library.displayForward();

        // Display all books in reverse order
        System.out.println("\nBooks in reverse order:");
        library.displayReverse();

        // Update availability
        library.updateAvailability(101, false);

        // Search for a book
        System.out.println("\nSearching for books by 'Harper Lee':");
        library.searchBook("", "Harper Lee");

        // Count total books
        System.out.println("\nTotal number of books in the library: " + library.countBooks());

        // Remove a book
        library.removeById(102);

        // Display all books after removal
        System.out.println("\nBooks after removal:");
        library.displayForward();
    }
}

