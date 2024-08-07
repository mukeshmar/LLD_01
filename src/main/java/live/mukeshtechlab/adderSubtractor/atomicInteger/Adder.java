package live.mukeshtechlab.adderSubtractor.atomicInteger;

public class Adder implements Runnable {
    private Count count;
    public Adder(Count count){
        this.count = count;
    }

    @Override
    public void run() {
        for(int i = 1; i<= 100000; i++){
            int currentValue = count.value.get();
            count.value.addAndGet(i);
        }
    }
}
