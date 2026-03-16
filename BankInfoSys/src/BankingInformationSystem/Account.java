package BankingInformationSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Account</h1>
 * 
 * The Account class represents a bank customer's account in the 
 * Banking Information System.
 * 
 * It stores customer personal details, login credentials,
 * account balance, and transaction history.
 * 
 * Each Account object is uniquely identified by an account number.
 * 
 * This class represents a bank account in the system.
 * 
 * @author Uzer Shaikh
 * @version 1.0
 */
public class Account {

    /** Unique account number assigned to each customer */
    private int accountNumber;

    /** Name of the account holder */
    private String name;

    /** Residential address of the account holder */
    private String address;

    /** Contact number of the account holder */
    private String contact;

    /** Login password for authentication */
    private String password;

    /** Current available balance in the account */
    private double balance;

    /** 
     * List to maintain transaction history.
     * Each transaction is stored as a String description.
     */
    private List<String> transactions = new ArrayList<>();

    /**
     * Parameterized constructor to initialize an Account object.
     *
     * @param accountNumber Unique account number
     * @param name          Name of the account holder
     * @param address       Address of the account holder
     * @param contact       Contact number of the account holder
     * @param password      Account login password
     * @param balance       Initial account balance
     */
    public Account(int accountNumber, String name, String address, String contact, String password, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.password = password;
        this.balance = balance;
    }

    /**
     * Returns the account number.
     *
     * @return account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Returns the account password.
     * Used internally for authentication.
     *
     * @return account password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the current account balance.
     *
     * @return current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Updates the account balance.
     *
     * @param balance updated balance amount
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns the transaction history list.
     *
     * @return list of transaction descriptions
     */
    public List<String> getTransactions() {
        return transactions;
    }
}
