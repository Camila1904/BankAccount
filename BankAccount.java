public class BankAccount {
  private double balance;
  private int accountID;
  private String password;
  // constructor for accountID and password
  public BankAccount (int a, String p) {
    accountID = a;
    password = p;
    balance = 0;
  }
  public double getBalance() {
    return balance;
  }
  public int getAccountID() {
    return accountID;
  }
  public void setPassword(String pass) {
    password = pass;
  }
  public boolean deposit (double amount) {
    if (amount >= 0) {
      balance += amount;
      return true;
    }
    return false;
  }
  public boolean withDraw(double amount) {
    if (amount>=0 && amount <= balance) {
      balance -= amount;
      return true;
    }
    return false;
  }
  public String toString() {
    return accountID + "\t" + balance;
  }
}
