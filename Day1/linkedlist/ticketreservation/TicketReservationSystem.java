package linkedlist.ticketreservation;

public class TicketReservationSystem {
    private Ticket head;
    private Ticket tail;
    private int totalTickets;

    // Constructor
    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
        this.totalTickets = 0;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        // If the list is empty
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Maintain circular link
        }

        totalTickets++;
        System.out.println("Ticket added: " + ticketID + " - " + customerName + " - " + movieName);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = null;

        // Traverse the list to find the ticket to remove
        do {
            if (current.ticketID == ticketID) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }

                totalTickets--;
                System.out.println("Ticket removed: " + ticketID);
                return;
            }

            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket not found: " + ticketID);
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        System.out.println("Current tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName +
                    ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchKey) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        System.out.println("Search results for: " + searchKey);

        do {
            if (current.customerName.equalsIgnoreCase(searchKey) || current.movieName.equalsIgnoreCase(searchKey)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName +
                        ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for: " + searchKey);
        }
    }

    // Calculate and display the total number of booked tickets
    public void totalBookedTickets() {
        System.out.println("Total tickets booked: " + totalTickets);
    }

    // Main method for testing
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding tickets
        system.addTicket(1, "Raju", "Hera pheri", "A1", "10:00 AM");
        system.addTicket(2, "Shyam", "Hera pheri", "B2", "12:00 PM");
        system.addTicket(3, "Baburao", "Phir hera pheri", "C3", "02:00 PM");

        // Display tickets
        system.displayTickets();

        // Search for tickets
        system.searchTicket("Interstellar");
        system.searchTicket("John Doe");

        // Remove a ticket
        system.removeTicket(2);
        system.displayTickets();

        // Total booked tickets
        system.totalBookedTickets();
    }
}

