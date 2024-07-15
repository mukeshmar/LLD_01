package live.mukeshtechlab.adderSubtractor.withoutLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        // Create the count object, this will be the common data which we will share to both task
        Count count = new Count();

        // Create Task
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        // Create Threads
        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        // Start threads
        t1.start();
        t2.start();

        // Wait for Threads to complete the task
        t1.join();
        t2.join();

        // Print the count value
        System.out.println(count.value);
    }
}
