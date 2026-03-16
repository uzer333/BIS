package BankingInformationSystem;

/**
 * <h1>BankService</h1>
 * 
 * The BankService interface defines the core banking operations 
 * that can be performed in the Banking Information System.
 * 
 * This interface acts as a service layer contract between
 * the user interface (Driver class) and the business logic implementation.
 * 
 * Any class implementing this interface must provide concrete
 * definitions for all banking operations declared here.
 * 
 * This promotes abstraction and makes classes less dependent on each other.
 * 
 * @author Uzer Shaikh
 * @version 1.0
 */
public interface BankService {

    /**
     * Deposits a specified amount into the given account.
     *
     * @param accNo  Account number where amount should be deposited
     * @param amount Amount to be deposited
     */
    abstract void deposit(int accNo, double amount);

    /**
     * Withdraws a specified amount from the given account.
     *
     * @param accNo  Account number from which amount should be withdrawn
     * @param amount Amount to be withdrawn
     */
    void withdraw(int accNo, double amount);

    /**
     * Transfers a specified amount from one account to another.
     *
     * @param fromAcc Account number from which amount will be debited
     * @param toAcc   Account number to which amount will be credited
     * @param amount  Amount to be transferred
     */
    void transfer(int fromAcc, int toAcc, double amount);

    /**
     * Displays the current balance of the given account.
     *
     * @param accNo Account number whose balance is to be checked
     */
    void checkBalance(int accNo);

    /**
     * Displays the recent transaction history of the given account.
     *
     * @param accNo Account number whose mini statement is requested
     */
    void miniStatement(int accNo);
}
