package live.mukeshtechlab.producerConsumer.withoutSynchronization;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Shirt> store;
    private int maxSize;
    private String producerName;

    public Producer(Queue<Shirt> store, int maxSize, String producerName){
        this.store = store;
        this.maxSize = maxSize;
        this.producerName = producerName;
    }

    @Override
    public void run() {
        // One Producer can also produce all the shirt in side the store
        while(true){
            if(store.size() < maxSize){
                System.out.println("Producer:- " + this.producerName + " is producing, Current Store Size = " + this.store.size());
                store.add(new Shirt());
            }
        }
    }
}
