package live.mukeshtechlab.assignment.bankTransection;

import java.util.concurrent.locks.Lock;

public class BankAccount {
    private final int accountNumber;
    private int balance;
    private Lock lock;

    public BankAccount(int accountNumber, int balance, Lock lock){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lock = lock;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int amount){
        lock.lock();
        try{
            balance += amount;
            System.out.println("Deposited Rs.: " + amount + " to account " + accountNumber + ". New Balance : " + balance);
        }
        finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount){
        lock.lock();
        try{
            if(amount > balance){
                System.out.println("Insufficient funds for withdrawal from account: " + accountNumber);
            }
            else {
                balance -= amount;
                System.out.println("Withdrawal Rs.: " + amount + " from account " + accountNumber + ". New Balance : " + balance);
            }
        }
        finally {
            lock.unlock();
        }
    }
}
