package live.mukeshtechlab.concurrency_1;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread Name:- " + Thread.currentThread().getName());
    }
}
