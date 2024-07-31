package live.mukeshtechlab.assignment.factorial;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Runnable {

    private long factorialNumber;
    long factorial;

    public FactorialCalculator(long factorialNumber){
        this.factorialNumber = factorialNumber;
        this.factorial = 1;
    }

    @Override
    public void run(){
        for(int i = 2; i<= factorialNumber; i++){
            factorial *= i;
        }
    }
    public long getFactorial(){
        return factorial;
    }
}
