package live.mukeshtechlab.assignment.ticketReservation;

public class TicketBookingTask implements Runnable {
    private String user;
    private int ticketId;
    private TicketReservationSystem ticketReservationSystem;

    public TicketBookingTask(TicketReservationSystem ticketReservationSystem, String user, int ticketId) {
        this.ticketReservationSystem = ticketReservationSystem;
        this.user = user;
        this.ticketId = ticketId;
    }

    @Override
    public void run() {
        ticketReservationSystem.bookTicket(user, ticketId);
    }
}
