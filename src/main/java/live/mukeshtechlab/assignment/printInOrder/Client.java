package live.mukeshtechlab.assignment.printInOrder;

import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Foo foo = new Foo(new Semaphore(1), new Semaphore(0), new Semaphore(0));

        // Create Task for Thread
        FooFirstTask callFirst = new FooFirstTask(foo);
        FooSecondTask callSecond = new FooSecondTask(foo);
        FooThirdTask callThird = new FooThirdTask(foo);

        Thread t1 = new Thread(callFirst);
        Thread t2 = new Thread(callSecond);
        Thread t3 = new Thread(callThird);

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException ex){
            throw new RuntimeException(ex);
        }

    }
}
