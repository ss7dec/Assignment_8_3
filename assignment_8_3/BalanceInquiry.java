//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking 
//Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using 
//synchronized). Also, compare your output without using synchronized.


package assignment_8_3;

public class BalanceInquiry extends Transaction
{
  private Account account;
  
  public BalanceInquiry(int tNumber, Account acct)
  {
    super(tNumber);
	account = acct;
  }
  
  public void makeTransaction()
  {
	System.out.println("Balance for account # " + account.getNumber() + " is " + account.getBalance());
  }
}
