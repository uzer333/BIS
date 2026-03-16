package BankingInformationSystem;

import java.util.Scanner;

/**
 * <h1>BankDriver</h1>
 * 
 * This class acts as the entry point for the Banking Information System.
 * It provides a console-based user interface that allows users to:
 * <ul>
 *     <li>Register a new bank account</li>
 *     <li>Login using account credentials</li>
 *     <li>Perform banking operations such as deposit, withdraw, transfer</li>
 *     <li>Check balance and view mini statement</li>
 * </ul>
 * 
 * The class interacts with {@link BankServiceImpl} to perform all business operations.
 * 
 * @author Uzer Shaikh
 * @version 1.0
 */
public class BankDriver {

    /**
     * Main method – execution starts from here.
     * 
     * This method:
     * <ol>
     *     <li>Displays the main menu</li>
     *     <li>Handles user input</li>
     *     <li>Invokes appropriate banking service methods</li>
     *     <li>Manages login session flow</li>
     * </ol>
     * 
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // Scanner object for taking user input from console
        Scanner sc = new Scanner(System.in);

        // Service implementation object to perform banking operations
        BankServiceImpl bank = new BankServiceImpl();

        // Infinite loop to keep application running until user exits
        while (true) {
            System.out.println("1.Register\n2.Login\n3.Exit\nEnter your choice:");
            int choice = sc.nextInt();

            switch (choice) {

            /**
             * Case 1: Register a new user
             * 
             * Collects user details such as name, address, contact,
             * password, and initial deposit amount.
             * 
             * Calls register() method of BankServiceImpl to create account.
             */
            case 1: {
                System.out.println("Name:");
                String name = sc.next();

                System.out.println("Address:");
                String address = sc.next();

                System.out.println("Contact:");
                String contact = sc.next();

                System.out.println("Password:");
                String pass = sc.next();

                System.out.println("Initial Deposit:");
                double dep = sc.nextDouble();

                int accNo = bank.register(name, address, contact, pass, dep);

                System.out.println("Account Created Successfully");
                System.out.println("Your Account Number: " + accNo);
                break;
            }

            /**
             * Case 2: Login existing user
             * 
             * Validates account number and password.
             * If login is successful, displays banking operations menu.
             * 
             * Throws:
             * @throws InvalidCredentialsException if login details are incorrect
             */
            case 2: {
                try {
                    System.out.println("Account Number:");
                    int accNo = sc.nextInt();

                    System.out.println("Password:");
                    String pass = sc.next();

                    // Validates login credentials
                    bank.login(accNo, pass);

                    boolean loggedIn = true;

                    /**
                     * Logged-in session loop.
                     * Continues until user selects Logout.
                     */
                    while (loggedIn) {
                        System.out.println(
                                "1.Deposit\n2.Withdraw\n3.Transfer\n4.Balance\n5.MiniStatement\n6.Logout");
                        int ch = sc.nextInt();

                        switch (ch) {

                        /**
                         * Deposit operation.
                         * Adds specified amount to user's account.
                         */
                        case 1:
                            System.out.println("Enter the amount u want to deposit:");
                            bank.deposit(accNo, sc.nextDouble());
                            break;

                        /**
                         * Withdraw operation.
                         * Deducts specified amount from user's account.
                         */
                        case 2:
                            System.out.println("Enter the amount u want to withdraw:");
                            bank.withdraw(accNo, sc.nextDouble());
                            break;

                        /**
                         * Transfer operation.
                         * Transfers specified amount to another account.
                         */
                        case 3:
                            System.out.println("Enter the acc no and amount u want to transfer:");
                            bank.transfer(accNo, sc.nextInt(), sc.nextDouble());
                            break;

                        /**
                         * Balance inquiry operation.
                         * Displays current account balance.
                         */
                        case 4:
                            bank.checkBalance(accNo);
                            break;

                        /**
                         * Mini statement operation.
                         * Displays recent transaction history.
                         */
                        case 5:
                            bank.miniStatement(accNo);
                            break;

                        /**
                         * Logout operation.
                         * Ends current session and returns to main menu.
                         */
                        case 6:
                            loggedIn = false;
                            break;
                        }
                    }

                } catch (InvalidCredentialsException e) {
                    // Displays error message if login fails
                    System.out.println(e.getMessage());
                }
                break;
            }

            /**
             * Case 3: Exit application
             * 
             * Terminates the program execution.
             */
            case 3:
                System.out.println("Thank You");
                System.exit(0);
            }
        }
    }
}

