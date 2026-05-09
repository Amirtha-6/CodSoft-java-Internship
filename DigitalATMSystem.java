/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

class CustomerAccount {

    private String accountHolder;
    private int pinNumber;
    private double accountBalance;

    // Constructor
    CustomerAccount(String name, int pin, double balance) {
        accountHolder = name;
        pinNumber = pin;
        accountBalance = balance;
    }

    // PIN Verification
    boolean verifyPin(int enteredPin) {
        return enteredPin == pinNumber;
    }

    // Deposit Method
    void addMoney(double amount) {

        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Amount Deposited Successfully.");
        } else {
            System.out.println("Invalid Deposit Amount!");
        }
    }

    // Withdraw Method
    void withdrawMoney(double amount) {

        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
        } else if (amount > accountBalance) {
            System.out.println("Insufficient Balance!");
        } else {
            accountBalance -= amount;
            System.out.println("Please collect your cash.");
        }
    }

    // Balance Display
    void showBalance() {
        System.out.printf("Current Balance : ₹%.2f\n", accountBalance);
    }

    String getName() {
        return accountHolder;
    }
}

public class DigitalATMSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Sample Account
        CustomerAccount user =
                new CustomerAccount("Amirtha", 1234, 15000);

        System.out.println("=================================");
        System.out.println("        SMART ATM MACHINE");
        System.out.println("=================================");

        // Login Section
        int attempts = 3;
        boolean accessGranted = false;

        while (attempts > 0) {

            System.out.print("Enter 4-Digit ATM PIN: ");
            int enteredPin = sc.nextInt();

            if (user.verifyPin(enteredPin)) {
                accessGranted = true;
                break;
            } else {
                attempts--;
                System.out.println("Wrong PIN!");
                System.out.println("Attempts Left: " + attempts);
            }
        }

        if (!accessGranted) {
            System.out.println("\nATM Blocked! Too many incorrect attempts.");
            sc.close();
            return;
        }

        System.out.println("\nWelcome, " + user.getName());

        int option;

        do {

            System.out.println("\n========= ATM MENU =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.println("============================");

            System.out.print("Choose an option: ");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    user.showBalance();
                    break;

                case 2:

                    System.out.print("Enter deposit amount: ₹");
                    double deposit = sc.nextDouble();

                    user.addMoney(deposit);
                    user.showBalance();
                    break;

                case 3:

                    System.out.print("Enter withdrawal amount: ₹");
                    double withdraw = sc.nextDouble();

                    user.withdrawMoney(withdraw);
                    user.showBalance();
                    break;

                case 4:

                    System.out.println("\n------ MINI STATEMENT ------");
                    System.out.println("Account Holder : " + user.getName());
                    user.showBalance();
                    System.out.println("Status          : Active");
                    System.out.println("-----------------------------");
                    break;

                case 5:

                    System.out.println("\nThank you for using Smart ATM.");
                    break;

                default:

                    System.out.println("Invalid Option! Please try again.");
            }

        } while (option != 5);

        sc.close();
    }
}