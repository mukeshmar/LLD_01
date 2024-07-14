package live.mukeshtechlab.adderSubtractor.usingLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        // Create the count object, this will be the common data which we will share to both task
        Count count = new Count();

        // Create Lock
        Lock lock = new ReentrantLock();

        // Create Task
        Adder adder = new Adder(count, lock);
        Subtractor subtractor = new Subtractor(count, lock);

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
