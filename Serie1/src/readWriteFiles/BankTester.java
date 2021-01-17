package readWriteFiles;

import java.io.File;
import java.io.IOException;

public class BankTester {

    public static void main (String[] args) throws IOException {
        File input1 = new File(Bank.RESOURCE_DIR + File.separator + Bank.IN_FILE1);
        File input2 = new File(Bank.RESOURCE_DIR + File.separator + Bank.IN_FILE2);

        Bank bank = Bank.createFrom(input1, "\t| / "); // OK

        File output1 = bank.readByteAccounts(input1); // OK

        File output2 = bank.readDataAccounts(input2); // OK

        bank.sortBalances(); // OK
        bank.sortDates(); // OK
    }
}
