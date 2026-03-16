package BankingInformationSystem;

/**
 * <h1>InvalidCredentialsException</h1>
 * 
 * This exception is thrown when a user attempts to log in
 * with an invalid account number or incorrect password.
 * 
 * It is a checked exception because it extends {@link Exception}.
 * This means it must be either handled using a try-catch block
 * or declared using the throws keyword.
 * 
 * This exception helps ensure secure authentication by
 * preventing unauthorized access to account operations.
 * 
 * Thrown when:
 * <ul>
 *     <li>Login details are incorrect.</li>
 * </ul>
 * 
 * @author Uzer Shaikh
 * @version 1.0
 */
public class InvalidCredentialsException extends Exception {

    /**
     * Creates a new InvalidCredentialsException with the given message.
     *
     * @param message Explanation describing why login failed
     */
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
