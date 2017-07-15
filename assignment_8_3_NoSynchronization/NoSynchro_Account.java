//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using synchronized). 
//Also, compare your output without using synchronized.

//In this first part, let’s see how multiple threads updating the same data can cause problems.

package assignment_8_3_NoSynchronization;

//This class represents an account in the bank
public class NoSynchro_Account {
    private int balance = 0;
 
    public NoSynchro_Account(int balance) {
        this.balance = balance;
    }
 
    public void withdraw(int amount) {
        this.balance -= amount;
    }
 
    public void deposit(int amount) {
        this.balance += amount;
    }
 
    public int getBalance() {
        return this.balance;
    }
}


//In a multi-threaded application, several threads can access the same data concurrently, which may 
//leave the data in inconsistent state (corrupted or inaccurate). Let’s find out how multi-thread 
//access can be a source of problems by going through an example that demonstrates the processing 
//of transactions in a bank.