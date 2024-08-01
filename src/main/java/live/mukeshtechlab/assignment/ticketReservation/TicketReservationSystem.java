package live.mukeshtechlab.assignment.ticketReservation;

import java.util.concurrent.ConcurrentHashMap;

public class TicketReservationSystem {
    private String showName;
    private ConcurrentHashMap<Integer, Seat> availableTickets;

    public TicketReservationSystem(String showName, int totalTickets) {
        this.showName = showName;
        availableTickets = new ConcurrentHashMap<>();

        for (int i = 1; i <= totalTickets; i++) {
            availableTickets.put(i, new Seat());
        }
    }

    public void bookTicket(String user, int ticketId) {
        Seat ticket = availableTickets.get(ticketId);

        if (ticket != null && ticket.book()) {
            System.out.println(user + " successfully booked ticket: " + ticketId + " for " + showName + " show");
        } else {
            System.out.println(user + " failed to book ticket " + ticketId + " for " + showName + " show");
        }
    }
}
