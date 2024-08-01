package live.mukeshtechlab.assignment.ticketReservation;

public class Seat {
    private boolean available;

    public Seat() {
        this.available = true;
    }

    public synchronized boolean book() {
        // Just adding a waiting period to book a ticket
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted, failed to book the ticket");
            return false;
        }

        // If ticket is booked, we return true
        // If a seat is not available return false
        if (available) {
            available = false;
            return true;
        }

        return false;
    }
}
