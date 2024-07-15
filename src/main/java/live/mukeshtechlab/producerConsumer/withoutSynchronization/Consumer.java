package live.mukeshtechlab.producerConsumer.withoutSynchronization;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Shirt> store;
    private int maxSize;
    private String consumerName;

    public Consumer(Queue<Shirt> store, int maxSize, String consumerName){
        this.store = store;
        this.maxSize = maxSize;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        // One Consumer can also consume all the shirt in side in Store
        while(true){
            if(store.size() > 0){
                System.out.println("Consumer:- " + this.consumerName + " is consuming, Current Store Size = " + this.store.size());
                store.remove();
            }
        }
    }
}
