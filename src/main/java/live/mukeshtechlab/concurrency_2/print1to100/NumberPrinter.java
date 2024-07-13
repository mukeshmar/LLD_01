package live.mukeshtechlab.concurrency_2.print1to100;

public class NumberPrinter implements Runnable {
    private int numberToPrint;
    public NumberPrinter(int numberToPrint){
        this.numberToPrint = numberToPrint;
    }
    @Override
    public void run() {
        System.out.println(numberToPrint + " - Printed By " + Thread.currentThread().getName());
    }
}
