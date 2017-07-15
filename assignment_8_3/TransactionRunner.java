//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking 
//Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using 
//synchronized). Also, compare your output without using synchronized.


package assignment_8_3;

import java.util.ArrayList;
public class TransactionRunner
{
	public static void main(String[] args)
	{
		ArrayList<Account> accounts = new ArrayList<Account>(100);
		ArrayList<Transaction> transactions = new ArrayList<Transaction>(100);

		for(int k = 0; k < 13; k++)
		{
			accounts.add(new Account(100+k, 1000.00));
			System.out.println("Account Balance for Acct # " + accounts.get(k).getNumber()
			+ ": " + accounts.get(k).getBalance());
		}
	
		for(int k = 0; k < 10; k++)
		{
			transactions.add(new BalanceInquiry(4*k, accounts.get(k)));
			transactions.add(new Withdrawal(4*k+1, accounts.get(k), 100));
			transactions.add(new Deposit(4*k+2, accounts.get(k), 100));
			transactions.add(new Transfer(4*k+3, accounts.get(k), accounts.get(k+1), 100));
		}

//		Try a transfer guaranteed to fail - 2000 from accounts(11) to accounts(12)		
		transactions.add(new Transfer(40, accounts.get(11), accounts.get(12), 2000));
	
		for(int k = 0; k < 41; k++)
		{
			transactions.get(k).makeTransaction();
		}
	
		for(int k = 0; k < 13; k++)
		{
			System.out.println("Balance for account # " + accounts.get(k).getNumber() 
			+ " is " + accounts.get(k).getBalance());
		}
	}
}

//COMPARISION BETWEEN CODE WHEN SYNCHRONIZED IS USED AND WHEN IT IS NOT USED-------
		/*
		 * Here, we are using synchronized block in run method.
		 * The use of that block here is to avoid use of same content of code by two threads at a time.
		 * For example, If we have two threads both are of class Customer.
		 * And if we start executing both threads, We don't know that at which point of time, which thread will be running.
		 * If let's say, You have 1000 Rs. balance in your Account.
		 * You have made two threads ThreadA and ThreadB. 
		 * ThreadA is passed to withdraw 600 Rs and ThreadB is passed to withdraw 500 Rs.
		 * If we execute the program without synchronized block , Then at that time, both threads will be in Runnable State for the function run() 
		 * in Customer class. And condition will be satisfied that (600 < 1000) and (500 < 1000). So both will be executed.
		 * And total withdrawn money will be 1100. But we had only 1000 Rs. in our balance.
		 * This problem occurred because both threads are working on same source code at the same time.
		 * We can encounter this problem by making restriction that at a time, only one thread is allowed to work on that source code.
		 * When the work of that thread completes, then only second thread is allowed to work.
		 * This restriction is called synchronization.
		 * We can use synchronized keyword with variables, methods and we even can make synchronized blocks like above.
		 * We will not be able to say that which Thread will execute first on synchronized block,
		 * But we can say that at a time, Only one thread will be working on that block. 
		 */
