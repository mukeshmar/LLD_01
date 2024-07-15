package live.mukeshtechlab.adderSubtractor.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {
    AtomicInteger value; // To achieve synchronization, we can use atomicInteger it will use a locking mechanism
    public Count(){
        value = new AtomicInteger(0);
    }
}
