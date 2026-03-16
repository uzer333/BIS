package BankingInformationSystem;

/**
 * <h1>OOPConceptExplanation</h1>
 *
 * This class explains how the Banking Information System implements the four
 * pillars of Object-Oriented Programming (OOP).
 *
 * <h2>1. Encapsulation</h2> Encapsulation is achieved in the Account class.
 * <ul>
 * <li>All data members are declared private.</li>
 * <li>Access is provided through getter and setter methods.</li>
 * </ul>
 * Example:
 * 
 * <pre>
 * private double balance;
 * public double getBalance()
 * </pre>
 * 
 * This protects data from direct modification.
 *
 * <h2>2. Abstraction</h2> Abstraction is implemented using the BankService
 * interface.
 * <ul>
 * <li>Only method declarations are defined in the interface.</li>
 * <li>Implementation details are hidden inside BankServiceImpl.</li>
 * </ul>
 * This hides internal logic from the user.
 *
 * <h2>3. Inheritance</h2> Inheritance is used in custom exception classes.
 * <ul>
 * <li>InvalidCredentialsException extends Exception.</li>
 * <li>InsufficientFundsException extends RuntimeException.</li>
 * </ul>
 * These classes inherit properties of Java's built-in exception classes.
 *
 * <h2>4. Polymorphism</h2> Polymorphism is achieved through method overriding.
 * <ul>
 * <li>BankServiceImpl implements BankService.</li>
 * <li>Methods like deposit(), withdraw(), transfer() are overridden.</li>
 * </ul>
 * Example:
 * 
 * <pre>
 * BankService bank = new BankServiceImpl();
 * </pre>
 * 
 * This allows runtime polymorphism.
 *
 * Overall, the project follows all four pillars of OOP in a structured and
 * modular way.
 *
 * @author Uzer Shaikh
 * @version 1.0
 */
public class OOPConceptExplanation {
	public static void main(String[] args) {

	}

	// This class is created only for documentation purpose.

}
