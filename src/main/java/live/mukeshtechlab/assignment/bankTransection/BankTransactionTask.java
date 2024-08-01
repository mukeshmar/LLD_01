package live.mukeshtechlab.assignment.bankTransection;

public class BankTransactionTask implements Runnable {

    private BankAccount bankAccount;
    private int transactionAmount;

    public BankTransactionTask(BankAccount bankAccount, int transactionAmount){
        this.bankAccount = bankAccount;
        this.transactionAmount = transactionAmount;
    }

    public void run(){
        if(transactionAmount < 0){
            // Withdraw Amount from Bank
            bankAccount.withdraw(Math.abs(transactionAmount));
        }
        else{
            // Deposit Amount to Bank
            bankAccount.deposit(transactionAmount);
        }
    }
}
