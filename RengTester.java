public class RengTester {
  public static void main(String[] args){
    idTester();
    balanceTester();
    toStringTester();
  }
  public static void errorHorn() {
    System.out.println("ERROR!\nERROR!\nERROR!");
  }
  public static void idEqualityTester( BankAccount bankAccount, int ID){
    if ( ID != bankAccount.getAccountID()) {
      errorHorn();
      System.out.println("Constructor failed at assigning bank ID or getAccountID method failed:" + ID + "\n Returned: " + bankAccount.getAccountID());
    }
    else {
      System.out.println("ID assignement and retrieval works.");
    }
  }
  public static void idTester() {
    int[] AccID = {01234, 12345, 23456, 34567, 0, -12345, -23456};
    System.out.println("POSITIVE ID RANDOMIZED TEST");
    for (int i=0;i<10;i++) {
      int bankID = (int)(Math.random() * 100000000);
      BankAccount acc = new BankAccount(bankID, "Election");
      idEqualityTester(acc, bankID);
    }
    System.out.println("NEGATIVE ID RANDOMIZED TEST");
    for (int i=0; i<10;i++) {
      int bankID = (int)(Math.random() * (-100000000));
      BankAccount acc = new BankAccount(bankID, "Election");
      idEqualityTester(acc, bankID);
    }
  System.out.println("STATIC ID TEST");
  for (int i = 0; i<AccID.length;i++) {
    BankAccount acc = new BankAccount(AccID[i], "");
    idEqualityTester(acc, AccID[i]);
  }
}
public static void balanceTester() {
  double[] depositAmts = {0, 12312312, -123123, -1, 5, Math.PI};
  boolean[] depositTestResults = {true,true,false,false,true,true};
  BankAccount[] bankAcc = new BankAccount[6];
  for (int i=0; i<bankAcc.length;i++) {
    if (bankAcc[i].deposit(depositAmts[i]) == depositTestResults[i]) {
      System.out.println("deposit function succeeded.");
    }
    else {
      errorHorn();
      System.out.println("deposit function failed at index: " + i);
    }
  }
  System.out.println("getBalance() TEST");
  double[] depositedAmt = {0,12312312,0,1,0, Math.PI};
  for (int i = 0; i<bankAcc.length;i++) {
    if (bankAcc[i].getBalance() == depositedAmt[i]) {
      System.out.println("getBalance + deposit function succeeded.");
    }
    else {
      errorHorn();
      System.out.println("deposit or get Balance function failed at index: " + i);
    }
  }
  System.out.println("withDraw() TEST");
  double[] withDrawAmt = {0,100, 2000, -100, -300, Math.PI};
  boolean[] withDrawTestResults = {true, true, true, false, false, true};
  for (int i=0; i<bankAcc.length;i++){
    BankAccount acc = new BankAccount(1,"");
    acc.deposit(10000.);
    bankAcc[i] = acc;
  }
  for (int i= 0; i<bankAcc.length;i++) {
    if (bankAcc[i].withDraw(withDrawAmt[i]) == withDrawTestResults[i]) {
      System.out.println("withdraw function succceeded.");
    }
    else {
      errorHorn();
      System.out.println("withDraw Function failed at index: " + i);
    }
  }
  System.out.println("getBalance() Test 2");
  double[] WithDrawExpected = {10000, 0, (100-150), 10000, 10000, (10000-Math.PI)};
  for (int i=0; i<bankAcc.length;i++) {
    if (bankAcc[i].getBalance() == WithDrawExpected[i]) {
      System.out.println("getBalance and withDraw function succeeded.");
    }
    else {
      errorHorn();
      System.out.println("WithDraw or getBalance function failed at index: " + i);
    }
  }
}
public static void toStringTester() {
  System.out.println("toString() Tester");
  int[] accIDs = new int[10];
  for (int i=0; i< accIDs.length ;i++) {
    accIDs[i] = (int)(Math.random()*100000000);
  }
  double[] accBals = new double[10];
  for (int i=0; i<accBals.length;i++) {
    accBals[i] = Math.random() + Math.pow(10,Math.random()*1000);
  }
  for (int i=0; i<accIDs.length;i++) {
    BankAccount acc = new BankAccount(accIDs[i], "");
    acc.deposit(accBals[i]);
    String expected = accIDs[i] + "\t" + accBals[i];
    if (expected.equals(acc.toString())) {
      System.out.println("toString function succeeded");
    }
    else {
      errorHorn();
      System.out.println("toString function failed.");
      System.out.println("expected: " + accBals[i]);
      System.out.println("Received: " + acc.toString());
    }
  }
}
}
