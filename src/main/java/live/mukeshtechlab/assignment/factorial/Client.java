package live.mukeshtechlab.assignment.factorial;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> findFactorialList = Arrays.asList(5, 10, 15, 20, 25);

        for(int i = 0; i<findFactorialList.size(); i++){
            FactorialCalculator factorialCalculator = new FactorialCalculator(findFactorialList.get(i));
            Thread thread = new Thread(factorialCalculator);
            thread.start();
            thread.join(2000); // Wait for the thread to finish
            System.out.println("Factorial of " + findFactorialList.get(i) + " is " + factorialCalculator.getFactorial());
        }
    }
}

