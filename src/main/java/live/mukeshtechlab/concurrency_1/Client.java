package live.mukeshtechlab.concurrency_1;

public class Client {
    public static void main(String[] args) {
        System.out.println("Thread Name :- " + Thread.currentThread().getName());

        // Creat the Task
        Task task = new Task();
        // Create Thread using Task
        Thread thread = new Thread(task);
        // Run Thread
        thread.start();

    }
}
