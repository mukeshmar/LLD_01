package live.mukeshtechlab.producerConsumer.usingSemaphore;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        // Create the Store
        Queue<Shirt> store = new ArrayDeque<>();
        int maxSize = 6; // This is a Store size, at max 6 shirt can be created in the Store

        // Create Semaphore for Producer and Object
        //  if the store is empty at max maxSize Producer can be there and 0 Consumer
        Semaphore producerSema = new Semaphore(maxSize);
        Semaphore consumerSema = new Semaphore(0);

        // We can create multiple Threads of Consumer and Producer working at the same time,
        // for now we are creating 3 producers and 5 consumers
        Producer p1 = new Producer(store, maxSize, "P1", producerSema, consumerSema);
        Producer p2 = new Producer(store, maxSize, "P2", producerSema, consumerSema);
        Producer p3 = new Producer(store, maxSize, "P3", producerSema, consumerSema);

        Consumer c1 = new Consumer(store, maxSize, "C1", producerSema, consumerSema);
        Consumer c2 = new Consumer(store, maxSize, "C2", producerSema, consumerSema);
        Consumer c3 = new Consumer(store, maxSize, "C3", producerSema, consumerSema);
        Consumer c4 = new Consumer(store, maxSize, "C4", producerSema, consumerSema);
        Consumer c5 = new Consumer(store, maxSize, "C5", producerSema, consumerSema);


        // We can use ExecutorService as well,
        // But to see more Synchronization Problem
        // we are using the same number of Threads = no. Of Producer + no. Of Consumer

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();
        Thread t4 = new Thread(c1);
        t4.start();
        Thread t5 = new Thread(c2);
        t5.start();
        Thread t6 = new Thread(c3);
        t6.start();
        Thread t7 = new Thread(c4);
        t7.start();
        Thread t8 = new Thread(c5);
        t8.start();

    }
}
