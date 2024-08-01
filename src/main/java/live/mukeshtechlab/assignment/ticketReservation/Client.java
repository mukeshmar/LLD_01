package live.mukeshtechlab.assignment.ticketReservation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        // Create an instance of a Show
        TicketReservationSystem fastAndFurious = new TicketReservationSystem("Fast & Furious", 10);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Generating multiple requests to book tickets
        for (int i = 1; i <= 10; i++) { // Only attempt to book existing tickets
            executorService.execute(new TicketBookingTask(fastAndFurious, "User" + i, i));
        }

        // Another set of requests
        for (int i = 1; i <= 10; i++) { // Only attempt to book existing tickets
            executorService.execute(new TicketBookingTask(fastAndFurious, "User" + (i + 10), i));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("All tasks completed");
    }
}
