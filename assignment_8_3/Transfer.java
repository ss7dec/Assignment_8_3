//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking 
//Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using 
//synchronized). Also, compare your output without using synchronized.


package assignment_8_3;

public class Transfer extends Transaction
{
	private double amount;
	private Account fromAccount;
	private Account toAccount;
  
	public Transfer(int tNumber, Account fromAcct, Account toAcct, double amt)
	{
		super(tNumber);
		fromAccount = fromAcct;
		toAccount = toAcct;
		amount = amt;
	}
  
	public void makeTransaction()
	{
		double fromStartingBalance = fromAccount.getBalance();
		if(amount <= fromStartingBalance)
		{
			fromAccount.setBalance(fromStartingBalance - amount);
			System.out.println("Withdrew Rs." + amount + " from account # " + fromAccount.getNumber());
		}
		else
		{
			System.out.println("Insufficient funds for this transfer of " + amount + 
			" from account # " + fromAccount.getNumber());
			return;
		}
	
		double toStartingBalance = toAccount.getBalance();
		toAccount.setBalance(toStartingBalance + amount);
		System.out.println("Deposited Rs." + amount + " to account # " + toAccount.getNumber());
	}
}