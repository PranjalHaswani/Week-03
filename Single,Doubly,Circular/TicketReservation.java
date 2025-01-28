package com.day1;
import java.text.SimpleDateFormat;
import java.util.Date;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = getCurrentTime();
        this.next = null;
    }

    // Get the current time in a readable format
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}

class TicketReservationSystem {
    private Ticket head;

    public TicketReservationSystem() {
        head = null;
    }

    // Add a new ticket reservation at the end of the circular linked list
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);

        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Circular link to itself
        } else {
            Ticket temp = head;
            // Traverse to the last ticket node
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head; // Maintain circular link
        }
        System.out.println("Ticket booked successfully. Ticket ID: " + ticketId);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        // Check if head is the ticket to be removed
        if (head.ticketId == ticketId) {
            if (head.next == head) { // Only one node in the list
                head = null;
            } else {
                // Find the last node
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head; // Update last node's next pointer
            }
            System.out.println("Ticket ID " + ticketId + " has been removed.");
            return;
        }

        // Traverse the list to find the ticket to be removed
        prev = temp;
        temp = temp.next;
        while (temp != head) {
            if (temp.ticketId == ticketId) {
                prev.next = temp.next; // Remove the node
                System.out.println("Ticket ID " + ticketId + " has been removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        }

        System.out.println("Ticket ID " + ticketId + " not found.");
    }

    // Display all tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId);
            System.out.println("Customer Name: " + temp.customerName);
            System.out.println("Movie Name: " + temp.movieName);
            System.out.println("Seat Number: " + temp.seatNumber);
            System.out.println("Booking Time: " + temp.bookingTime);
            System.out.println("-----------------------------");
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found:");
                System.out.println("Ticket ID: " + temp.ticketId);
                System.out.println("Customer Name: " + temp.customerName);
                System.out.println("Movie Name: " + temp.movieName);
                System.out.println("Seat Number: " + temp.seatNumber);
                System.out.println("Booking Time: " + temp.bookingTime);
                System.out.println("-----------------------------");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for the search query: " + query);
        }
    }

    // Calculate and display the total number of booked tickets
    public void totalTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total booked tickets: " + count);
    }
}

public class TicketReservation{
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Add some ticket reservations
        system.addTicket(1, "Alice", "Avengers", "A1");
        system.addTicket(2, "Bob", "Batman", "B2");
        system.addTicket(3, "Charlie", "Spider-Man", "C3");
        system.addTicket(4, "David", "Avengers", "D4");

        // Display all tickets
        system.displayTickets();

        // Search for a ticket by Customer Name
        system.searchTicket("Alice");

        // Search for a ticket by Movie Name
        system.searchTicket("Avengers");

        // Remove a ticket by Ticket ID
        system.removeTicket(2);

        // Display all tickets again
        system.displayTickets();

        // Calculate and display total tickets
        system.totalTickets();
    }
}
