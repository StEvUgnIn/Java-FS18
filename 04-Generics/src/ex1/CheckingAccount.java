package ex1;

/**
   A checking account that charges transaction fees.
*/
public class CheckingAccount extends BankAccount {  

   private static final int FREE_TRANSACTIONS = 3;
   private static final double TRANSACTION_FEE = 2.0;

   private int transactionCount;

  /**
     Constructs a checking account with a given balance
     @param initialBalance the initial balance
  */
  public CheckingAccount(double initialBalance) {  
    super(initialBalance);
  }

  @Override
  public void deposit(double amount) {  
    transactionCount++;
    super.deposit(amount); 
  }
   
  @Override
  public void withdraw(double amount) {  
    transactionCount++;
    super.withdraw(amount); 
  }

  /**
     Deducts the accumulated fees and resets the
     transaction count.
  */
  public void deductFees() {  
    if (transactionCount > FREE_TRANSACTIONS) {  
      double fees = TRANSACTION_FEE * (transactionCount - FREE_TRANSACTIONS);
      super.withdraw(fees);
    }
    transactionCount = 0;
  }

  @Override
  public String toString() {
    return super.toString() + "[transactionCount: " + transactionCount + "]";
  }
}
