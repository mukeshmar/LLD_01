package live.mukeshtechlab.concurrency_2.print1to100;

/*
    We are printing 1 to 100 using 100 Threads
 */

public class Client {
    public static void main(String[] args) {
        NumberPrinter numberPrinterTask = null;
        Thread thread = null;
        for(int i = 1; i<=100; i++){
            numberPrinterTask = new NumberPrinter(i);
            thread = new Thread(numberPrinterTask);
            thread.start();
        }
    }
}
