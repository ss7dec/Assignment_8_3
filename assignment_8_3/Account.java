//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking 
//Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using 
//synchronized). Also, compare your output without using synchronized.

package assignment_8_3;


	public class Account {  
		
			  public int accountNumber;
			  public double accountBalance;

			  public Account(int number, double initialBalance)
			  {
			    accountNumber = number;
			    accountBalance = initialBalance;
			  }

			  public int getNumber()
			  {
			    return accountNumber;
			  }

			  public double getBalance()
			  {
			    return accountBalance;
			  }
			  
			  public void setNumber(int number)
			  {
				accountNumber = number;
			  }
			  
			  public void setBalance(double newBalance)
			  {
			    accountBalance = newBalance;
			  }

	}