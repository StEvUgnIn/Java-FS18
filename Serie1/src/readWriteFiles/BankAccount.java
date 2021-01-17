/**
 * @title First Presentation
 * @authors Seyed Hady Asady & Huguenin-Elie Steve André
 * @version v1.0
 * @date April 2018
 */
package readWriteFiles;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    private int number;
    private String owner;
    private double balance;
    private LocalDate date;

    /**
     * Private constructor
     *
     * @param number  number
     * @param owner   name of the owner
     * @param balance balance
     * @param date    date
     */
    BankAccount (int number, String owner, double balance, LocalDate date) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
        this.date = date;
    }

    /**
     * create bank account from text file. Also does not close buffer
     *
     * @param input buffered file
     * @return bankaccount instance converted from data
     */
    public static BankAccount createFrom (Scanner input) throws InputMismatchException {
        if (input != null) {
            int id = input.nextInt();
            String owner = input.next();
            double balance = input.nextDouble();
            LocalDate date = LocalDate.parse(input.next(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            return new BankAccount(id, owner, balance, date);
        }
        return null;
    }

    byte[] parse () throws UnsupportedEncodingException {
        return toString().getBytes("UTF-8");
    }

    public int getNumber () {
        return number;
    }

    public String getOwner () {
        return owner;
    }

    public double getBalance () {
        return balance;
    }

    public LocalDate getDate () {
        return date;
    }

    @Override
    public String toString () {
        return String.format("#: %d \\ %s \\ Balance: %f \\ Creation date: %s\n", number, owner, balance, DateTimeFormatter.ofPattern("dd-MM-yyyy").format(date));
    }
}
