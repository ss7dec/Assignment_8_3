//Assignment 8.3
//Write an application to implement the basic functions for the Online Banking 
//Application (Hint: -Use synchronized).
//Expected Output
//Show deposit and withdraw functionality for the Online Banking Application (Using 
//synchronized). Also, compare your output without using synchronized.


package assignment_8_3;

abstract public class Transaction
{
  protected int transactionNumber;
  
  public Transaction(int tNumber)
  {
    transactionNumber = tNumber;
  }
  
  abstract public void makeTransaction();
}
