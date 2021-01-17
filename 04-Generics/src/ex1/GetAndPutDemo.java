package ex1;

public class GetAndPutDemo {

    public static void main (String[] args) {
        CheckingAccount checking1 = new CheckingAccount(2000);
        CheckingAccount checking2 = new CheckingAccount(3000);
        Object obj;
        BankAccount account;
        CheckingAccount checking;

        //Pair p1
        Pair<? extends BankAccount> p1 = new Pair<>(checking1, checking2);

        // Getting element from p1
        obj = p1.getFirst();
        account = p1.getFirst();

        // checking = p1.getFirst();

        // Setting element in p1
        obj = new BankAccount(500);

        // p1.setFirst(account)
        checking = new CheckingAccount(500);
        // p1.setFirst(checking)

        // p1.setFirst(null);

        // Pair p2
        Pair<? extends CheckingAccount> p2 = new Pair<>(checking1, checking2);
    }
}
