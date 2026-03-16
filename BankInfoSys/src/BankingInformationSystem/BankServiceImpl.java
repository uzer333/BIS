package BankingInformationSystem;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>BankServiceImpl</h1>
 * 
 * This class provides the concrete implementation of the 
 * {@link BankService} interface.
 * 
 * It contains the business logic for:
 * <ul>
 *     <li>Account registration</li>
 *     <li>User authentication (login)</li>
 *     <li>Deposit, withdrawal, and transfer operations</li>
 *     <li>Balance inquiry</li>
 *     <li>Mini statement generation</li>
 * </ul>
 * 
 * Account data is stored in-memory using a HashMap where:
 * <pre>
 *     Key   → Account Number
 *     Value → Account Object
 * </pre>
 * 
 * This implementation simulates a banking system without database persistence.
 * 
 * @author Uzer Shaikh
 * @version 1.0
 */
public class BankServiceImpl implements BankService {

    /**
     * Stores all registered accounts.
     * Key   → Account Number
     * Value → Account object
     */
    Map<Integer, Account> accounts = new HashMap<>();

    /**
     * Static account number generator.
     * Starts from 1001 and auto-increments for each new account.
     */
    private static int accGenerator = 1001;

    /**
     * Registers a new account in the system.
     *
     * @param name     Name of the account holder
     * @param address  Address of the account holder
     * @param contact  Contact number of the account holder
     * @param password Login password
     * @param deposit  Initial deposit amount
     * @return generated account number
     */
    public int register(String name, String address, String contact, String password, double deposit) {

        int accNo = accGenerator++;

        Account acc = new Account(accNo, name, address, contact, password, deposit);

        acc.getTransactions().add(deposit + " Deposited | Balance: " + deposit);

        accounts.put(accNo, acc);

        return accNo;
    }

    /**
     * Authenticates user login credentials.
     *
     * @param accNo    Account number
     * @param password Account password
     * @return Account object if credentials are valid
     * @throws InvalidCredentialsException if account does not exist
     *                                     or password is incorrect
     */
    public Account login(int accNo, String password) throws InvalidCredentialsException {

        Account acc = accounts.get(accNo);

        if (acc == null || !acc.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid Account Number or Password");
        }

        return acc;
    }

    /**
     * Deposits amount into specified account.
     *
     * @param accNo  Account number
     * @param amount Amount to deposit
     */
    @Override
    public void deposit(int accNo, double amount) {

        Account acc = accounts.get(accNo);

        acc.setBalance(acc.getBalance() + amount);

        acc.getTransactions().add(amount + " Deposited | Balance: " + acc.getBalance());

        System.out.println("Deposit Successful");
    }

    /**
     * Withdraws amount from specified account.
     *
     * @param accNo  Account number
     * @param amount Amount to withdraw
     * @throws InsufficientFundsException if withdrawal amount exceeds balance
     */
    @Override
    public void withdraw(int accNo, double amount) {

        Account acc = accounts.get(accNo);

        if (amount > acc.getBalance()) {
            throw new InsufficientFundsException("Insufficient Balance");
        }

        acc.setBalance(acc.getBalance() - amount);

        acc.getTransactions().add(amount + " Withdrawn | Balance: " + acc.getBalance());

        System.out.println("Withdrawal Successful");
    }

    /**
     * Transfers amount from one account to another.
     *
     * @param fromAcc Sender account number
     * @param toAcc   Receiver account number
     * @param amount  Amount to transfer
     * @throws InsufficientFundsException if sender has insufficient balance
     */
    @Override
    public void transfer(int fromAcc, int toAcc, double amount) {

        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (receiver == null) {
            System.out.println("Receiver Account Not Found");
            return;
        }

        if (amount > sender.getBalance()) {
            throw new InsufficientFundsException("Insufficient Balance");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        sender.getTransactions().add(
                amount + " Transferred to " + toAcc + " | Balance: " + sender.getBalance());

        receiver.getTransactions().add(
                amount + " Received from " + fromAcc + " | Balance: " + receiver.getBalance());

        System.out.println("Transfer Successful");
    }

    /**
     * Displays the current balance of the account.
     *
     * @param accNo Account number
     */
    @Override
    public void checkBalance(int accNo) {
        System.out.println("Balance: " + accounts.get(accNo).getBalance());
    }

    /**
     * Displays transaction history of the account.
     *
     * @param accNo Account number
     */
    @Override
    public void miniStatement(int accNo) {

        for (String t : accounts.get(accNo).getTransactions()) {
            System.out.println(t);
        }
    }
}
