//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using synchronized). 
//Also, compare your output without using synchronized.

package assignment_8_3_NoSynchronization;

/**
  * This class represents a transaction task that can be executed by a thread.
  */
public class NoSynchro_Transaction implements Runnable {
    private NoSynchro_Bank bank;
    private int fromAccount;
 
    public NoSynchro_Transaction(NoSynchro_Bank bank2, int fromAccount) {
        this.bank = bank2;
 
 
        this.fromAccount = fromAccount;
    }
 
    public void Transaction(assignment_8_3_NoSynchronization.NoSynchro_Bank bank2, int i) {
		// TODO Auto-generated constructor stub
	}

	public void run() {
 
        while (true) {
            int toAccount = (int) (Math.random() * NoSynchro_Bank.MAX_ACCOUNT);
 
            if (toAccount == fromAccount) continue;
 
            int amount = (int) (Math.random() * NoSynchro_Bank.MAX_AMOUNT);
 
            if (amount == 0) continue;
 
            bank.transfer(fromAccount, toAccount, amount);
 
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//this Transaction class implements the Runnable interface so the code in its run() 
//method can be executed by a separate thread.
//The source account is passed from the constructor and the target account is chosen 
//randomly, and both source and target cannot be the same.
