//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using synchronized). 
//Also, compare your output without using synchronized.


package assignment_8_3_NoSynchronization;

/**
 * This is a test program that creates threads to process many transactions concurrently.
 */

public class NoSynchro_TransactionTest {
    public static void main(String[] args) {
        NoSynchro_Bank bank = new NoSynchro_Bank();
 
        for (int i = 0; i < NoSynchro_Bank.MAX_ACCOUNT; i++) {
            Thread t = new Thread(new NoSynchro_Transaction(bank, i));
            t.start();
        }
    }
    
}


//As you can see, a Bank instance is created and shared among the threads that perform the transactions. For 
//each account, a new thread is created to transfer money from that account to other randomly chosen accounts. 
//That means there are total 10 threads sharing one instance of Bank class. These threads will run forever until 
//the program is terminated by pressing Ctrl + C. Remember this rule: No matter how many transactions are processed, 
//the total balance of all accounts must remain unchanged. In other words, the program must consistently report this 
//number as 1000.

//You will notice that Somehow the total balance is getting changed. It doesn’t remain at 1000 anymore. 
//It’s getting smaller and smaller over time. 
//That means the shared data may get corrupted when it is updated by multiple threads concurrently.
//A similar problem can happen with the deposit operation. 

//The output is unpredicted: sometimes you see the total balance gets increased, sometimes it gets decreased, 
//and sometimes it goes up and goes down. We need a mechanism that is able to guarantee that code in the transfer() 
//method is executed by only one thread at a time. In other words, we need to synchronize access to shared data.
//Now you understand what kind of problem may happen with unsynchronized code.