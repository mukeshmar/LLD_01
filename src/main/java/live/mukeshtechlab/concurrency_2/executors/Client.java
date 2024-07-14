package live.mukeshtechlab.concurrency_2.executors;

/*
    We are printing number 1 to 100, using ExecutorService class with 10 Threads
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        NumberPrinter numberPrinterTask = null;

        // Create the ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i = 1; i<=100; i++){
            numberPrinterTask = new NumberPrinter(i);
            executorService.submit(numberPrinterTask);
        }

        // After completing all the task through executorService we need to shut down as well
        executorService.shutdown();
    }
}
