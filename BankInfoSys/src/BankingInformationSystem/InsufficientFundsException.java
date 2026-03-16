package BankingInformationSystem;

/**
 * <h1>InsufficientFundsException</h1>
 * 
 * This exception is thrown when a withdrawal or transfer operation
 * is attempted with an amount greater than the available account balance.
 * 
 * It is an unchecked exception because it extends RuntimeException.
 * This means it does not require mandatory handling using try-catch,
 * but can be handled optionally by the calling code.
 * 
 * This exception ensures that invalid debit operations
 * do not allow the account balance to become negative.
 * 
 * Typically thrown during:
 * <ul>
 *     <li>Withdrawal operation</li>
 *     <li>Fund transfer operation</li>
 * </ul>
 * 
 * @author Uzer Shaikh
 * @version 1.0
 */
public class InsufficientFundsException extends RuntimeException {

    /**
     * Creates a new InsufficientFundsException with the given message.
     *
     * @param message Explanation of the exception cause
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
