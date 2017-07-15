//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using synchronized). 
//Also, compare your output without using synchronized.


package assignment_8_3_NoSynchronization;

/**
 * This class represents a bank that manages accounts and provides money transfer function.
 */
public class NoSynchro_Bank {
    public static final int MAX_ACCOUNT = 10;
    public static final int MAX_AMOUNT = 10;
    public static final int INITIAL_BALANCE = 100;
 
    private NoSynchro_Account[] accounts = new NoSynchro_Account[MAX_ACCOUNT];
 
    public NoSynchro_Bank() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new NoSynchro_Account(INITIAL_BALANCE);
        }
    }
 
    public void transfer(int from, int to, int amount) {
        if (amount <= accounts[from].getBalance()) {
            accounts[from].withdraw(amount);
            accounts[to].deposit(amount);
 
            String message = "%s transfered %d from %s to %s. Total balance: %d\n";
            String threadName = Thread.currentThread().getName();
            System.out.printf(message, threadName, amount, from, to, getTotalBalance());
        }
    }
 
    public int getTotalBalance() {
        int total = 0;
 
        for (int i = 0; i < accounts.length; i++) {
            total += accounts[i].getBalance();
        }
 
        return total;
    }
}

//As you can see, this bank consists of 10 accounts for each is initialized with a balance amount 
//of 100. So the total balance of these 10 accounts is 10 x 100 = 1000.
//The transfer() method withdraws a specified amount from an account and deposit that amount to 
//the target account. The transfer will be processed if and only if the source account has enough balance.
// And after the transfer has been done, a log message is printed to let us know the transaction details.
//The getTotalBalance() method returns the total amount of all accounts, which must be always 1000. We 
//check this number after every transaction to make sure that the program runs correctly.