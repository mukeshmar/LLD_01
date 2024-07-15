package live.mukeshtechlab.producerConsumer.usingSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Shirt> store;
    private int maxSize;
    private String producerName;
    private Semaphore producerSema;
    private Semaphore consumerSema;

    public Producer(Queue<Shirt> store, int maxSize, String producerName, Semaphore producerSema, Semaphore consumerSema){
        this.store = store;
        this.maxSize = maxSize;
        this.producerName = producerName;
        this.producerSema = producerSema;
        this.consumerSema = consumerSema;
    }

    @Override
    public void run() {
        // One Producer can also produce all the shirt in side the store
        while(true){
            // Producer can only produce if there producerSema > 0
            try {
                producerSema.acquire(); //  this will do producerSema--
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Producer:- " + this.producerName + " is producing, Current Store Size = " + this.store.size());
            store.add(new Shirt());


            // as soon as producer produces shirt, consumer can consume means we need to consumerSema++
            consumerSema.release(); // this will do consumerSema++
        }
    }
}
