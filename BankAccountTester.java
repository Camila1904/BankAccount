public class BankAccountTester {
  public static void main(String[] args) {
    BankAccount ba = new BankAccount(12345678, "My Account");
    System.out.println(ba.getBalance());
    System.out.println(ba.getAccountID());
    System.out.println();
    System.out.println(ba.deposit(253.20));
    System.out.println(ba.getBalance());
    System.out.println(ba.deposit(-20.50));
    System.out.println(ba.getBalance());
    System.out.println();
    System.out.println(ba.withDraw(100.00));
    System.out.println(ba.getBalance());
    System.out.println(ba.withDraw(300.00));
    System.out.println(ba.getBalance());
    System.out.println();
    System.out.println(ba.toString());
  }
}
