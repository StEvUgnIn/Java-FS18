package readWriteFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An application that randomly generates data record for bank accounts
 * and stores them into files with different formats.
 */
public class BankDataGenerator {

    private static final int NUM_ACCOUNTS = 300;
    private static final double MAX_BALANCE = 100_000;
    private static final String RESOURCE_DIR = "res",
            NAMES_FILE = "Names.txt",
            OUT_FILE1 = "ByteAccounts.dat",
            OUT_FILE2 = "DataAccounts.dat";

    public static void main (String[] args) throws IOException {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        List<String> names =
                Files.readAllLines(Paths.get(RESOURCE_DIR, NAMES_FILE));

        // Open two output files
        try (OutputStream out1 = new FileOutputStream(RESOURCE_DIR +
                File.separator +
                OUT_FILE1);
             DataOutputStream out2 =
                     new DataOutputStream(new FileOutputStream(RESOURCE_DIR +
                             File.separator +
                             OUT_FILE2))) {
            for (int i = 1; i <= NUM_ACCOUNTS; i++) {

                // Generate a unique number for each account
                int number = i + (int)Math.round(Math.random() * 10) * NUM_ACCOUNTS;

                // Get an owner
                String owner = names.get(i % names.size());

                // Generate a random balance value
                double balance = Math.random() * MAX_BALANCE;

                // Generate a random date value between 1. January 1970 and now.
                Date creationDate =
                        new Date(Math.round(Math.random() * System.currentTimeMillis()));

                // Collect the record data, separated by tab characters, into a
                // string and write it as a byte sequence into the first file.
                String record = number + "\t" + owner + "\t" + balance +
                        "\t" + df.format(creationDate) + " / ";
                out1.write(record.getBytes("UTF-8"));

                // Write the record data into the second output file.
                out2.writeInt(number);
                out2.writeChars(owner);
                out2.writeChar('\t');
                out2.writeDouble(balance);
                out2.writeChars(df.format(creationDate));
                out2.writeChars(" / ");
            }
        }
    }
}
