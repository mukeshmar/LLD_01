package live.mukeshtechlab.assignment.bankTransection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) {
        // Create Bank Account
        BankAccount account_1 = new BankAccount(101, 2000, new ReentrantLock());
        BankAccount account_2 = new BankAccount(102, 2000, new ReentrantLock());

        // 2 Threads Try to access the same Account
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new BankTransactionTask(account_1, -2200));
        executorService.execute(new BankTransactionTask(account_1, 200));

        executorService.shutdown();

    }
}
