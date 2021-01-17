/**
 * @title First Presentation
 * @authors Seyed Hady Asady & Huguenin-Elie Steve André
 * @version v1.0
 * @date April 2018
 */
package readWriteFiles;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * A class representing a bank that has multiple customer accounts
 */
public class Bank {

    public static final String RESOURCE_DIR = "res",
            IN_FILE1 = "ByteAccounts.dat",
            IN_FILE2 = "DataAccounts.dat",
            OUT_FILE1 = "Accounts1.txt",
            OUT_FILE2 = "Accounts2.txt";

    private static final String DELIMITERS = "\t| / ";

    private ArrayList<BankAccount> accounts;

    /**
     * Construct a bank instance from any file containing bank accounts
     *
     * @param input   input
     * @param pattern information group delimiters
     * @return instance of Bank from input
     * @throws IOException
     */
    public static Bank createFrom (File input, String pattern) throws IOException {
        Bank bank = new Bank();
        bank.accounts = new ArrayList<>();
        Scanner in = new Scanner(input).useDelimiter(pattern);

        while (in.hasNext()) {
            bank.accounts.add(BankAccount.createFrom(in));
        }
        in.close();

        return bank;
    }

    /**
     * compute total of balances
     *
     * @return total of balances
     */
    public double total () {
        double tot = 0;
        for (BankAccount account : accounts) tot += account.getBalance();
        return tot;
    }

    /**
     * read the bank account data from the file ByteAccounts.dat and stores them in a text file Accounts1.txt
     *
     * @param input input file in readable format
     * @return Accounts1.txt
     * @throws IOException
     */
    public File readByteAccounts (File input) throws IOException {
        FileInputStream stream = new FileInputStream(input);
        File output = new File(RESOURCE_DIR + File.separator + OUT_FILE1);
        PrintWriter out = new PrintWriter(output);
        out.flush();
        out.print(parse(stream));
        out.printf("TOTAL: %f", total());
        out.close();
        stream.close();
        if (accounts == null) createFrom(output, DELIMITERS);
        return output;
    }

    public void readByteAccounts () throws IOException {
        readByteAccounts(new File(RESOURCE_DIR + File.separator + IN_FILE1));
    }

    /**
     * read the bank account data from the file DataAccounts.dat and stores them in a text file Accounts2.txt
     *
     * @throws IOException
     */
    public File readDataAccounts (File file) throws IOException, InputMismatchException {
        DataInputStream stream = new DataInputStream(new FileInputStream(file));
        File output = new File(RESOURCE_DIR + File.separator + OUT_FILE2);
        PrintWriter out = new PrintWriter(output);
        out.flush();

        Function<Void, String> readString = Void -> {
            StringBuilder builder = new StringBuilder();
            try {
                char c = 0;
                while (c != '\t' && c != '/') {
                    builder.append(c);
                    c = stream.readChar();
                }
                if (c == '/') stream.readChar(); // get rid of unwanted space \u0020
            } catch (IOException | InputMismatchException e) {
                throw new InputMismatchException();
            }
            return builder.toString();
        };

        while (stream.available() != 0)
            out.printf("#: %d \\ %s \\ Balance: %f \\ Creation date: %s\n", stream.readInt(), readString.apply(null), stream.readDouble(), readString.apply(null));
        out.printf("TOTAL: %f", total());
        out.close();
        stream.close();
        if (accounts == null) createFrom(output, DELIMITERS);
        return output;
    }

    public void readDataAccounts () throws IOException {
        readDataAccounts(new File(RESOURCE_DIR + File.separator + IN_FILE2));
    }

    /**
     * read accounts from data and store them into a text file
     *
     * @param stream stream containing file to interpret as comprehensible text
     */
    private char[] parse (InputStream stream) throws InputMismatchException {
        StringBuilder builder = new StringBuilder();
        Scanner in = new Scanner(stream).useDelimiter(DELIMITERS);

        while (in.hasNext()) {
            builder.append("#: ").append(in.nextInt()).append(" \\ ");
            builder.append(in.next()).append(" \\ ");
            builder.append("Balance: ").append(in.nextDouble()).append(" \\ ");
            builder.append("Creation date: ").append(in.next()).append("\n");
        }

        in.close();
        return builder.toString().toCharArray();
    }

    private void sort (File output, Comparator<BankAccount> comparator) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(output);
        ArrayList<BankAccount> temp = new ArrayList<>(accounts);

        accounts.sort(comparator);
        out.print(toString());
        out.printf("TOTAL: %f", total());
        out.close();

        accounts = temp;
    }

    /**
     * sort the account balance values in ascending order and stores the sorted accounts in a new text file. Also append an extra-line with the total balances.
     *
     * @return @return new file containing accounts lists ordered by balance
     * @throws IOException
     */
    public File sortBalances () throws FileNotFoundException {
        File output = new File(RESOURCE_DIR + File.separator + "SortedBalances.dat");
        sort(output, Comparator.comparing(BankAccount::getBalance, Comparator.reverseOrder()));
        return output;
    }

    /**
     * sort the creation dates in ascending order and stores the sorted creation dates in a new text file.
     *
     * @throws IOException
     */
    public File sortDates () throws IOException {
        File output = new File(RESOURCE_DIR + File.separator + "SortedDates.dat");
        sort(output, Comparator.comparing(BankAccount::getDate));
        return output;
    }

    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        for (BankAccount account : accounts) builder.append(account).append('\n');
        return builder.toString();
    }
}
