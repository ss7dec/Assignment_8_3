//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking 
//Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using 
//synchronized). Also, compare your output without using synchronized.


package assignment_8_3;

public class Withdrawal extends Transaction
{
  private double amount;
  private Account account;
  
  public Withdrawal(int tNumber, Account acct, double amt)
  {
    super(tNumber);
	account = acct;
    amount = amt;
  }
  
  public void makeTransaction()
  {
    double startingBalance = account.getBalance();
    if(amount <= startingBalance)
	{
		account.setBalance(startingBalance - amount);
		System.out.println("Withdrew Rs." + amount + " from account # " + account.getNumber());
    }
    else
    {
		System.out.println("Insufficient funds for this withdrawal of " + amount + 
		" from account # " + account.getNumber());
    }
  }
}
