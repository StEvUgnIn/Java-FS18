package ex1;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount implements Comparable<BankAccount> {

  private double balance;

  /**
     Constructs a bank account with a zero balance.
  */
  public BankAccount() {   
    balance = 0;
  }

  /**
     Constructs a bank account with a given balance.
     @param initialBalance the initial balance
  */
  public BankAccount(double initialBalance) {   
    balance = initialBalance;
  }

  /**
     Deposits money into the bank account.
     @param amount the amount to deposit
  */
  public void deposit(double amount) {  
    balance += amount;
  }

  /**
     Withdraws money from the bank account.
     @param amount the amount to withdraw
  */
  public void withdraw(double amount) {   
    balance -= amount;
  }

  /**
     Gets the current balance of the bank account.
     @return the current balance
  */
  public double getBalance() {   
    return balance;
  }
  
  @Override
  public String toString() {
    return getClass().getName() + "[balance: " + balance + "]";
  }

  @Override
  public int compareTo (BankAccount o) {
    if (balance > o.getBalance())
      return 1;
    else if (balance < o.getBalance())
      return -1;
    return 0;
  }
}
