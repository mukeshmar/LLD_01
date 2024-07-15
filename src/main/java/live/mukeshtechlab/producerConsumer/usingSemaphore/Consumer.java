package live.mukeshtechlab.producerConsumer.usingSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Shirt> store;
    private int maxSize;
    private String consumerName;
    private Semaphore producerSema;
    private Semaphore consumerSema;


    public Consumer(Queue<Shirt> store, int maxSize, String consumerName, Semaphore producerSema, Semaphore consumerSema){
        this.store = store;
        this.maxSize = maxSize;
        this.consumerName = consumerName;
        this.producerSema = producerSema;
        this.consumerSema = consumerSema;
    }

    @Override
    public void run() {
        // One Consumer can also consume all the shirt in side in Store
        while(true){
            try {
                consumerSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Consumer:- " + this.consumerName + " is consuming, Current Store Size = " + this.store.size());
            store.remove();

            producerSema.release();

        }
    }
}
