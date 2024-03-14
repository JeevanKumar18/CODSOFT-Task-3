import java.util.Scanner;

// Class to represent the user's bank account
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Successfully deposited " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= account.getBalance()) {
            account.withdraw(amount);
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is " + account.getBalance());
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter initial bank balance:");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();  // Add this line

        Account account = new Account(initialBalance);
        ATM atm = new ATM(account);

        String userChoice;
        do {
            System.out.println("Choose an option: deposit, withdraw, check balance, quit");
            userChoice = scanner.nextLine();

            switch (userChoice.toLowerCase()) {
                case "deposit":
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();  // Add this line
                    atm.deposit(depositAmount);
                    atm.checkBalance();
                    break;
                case "withdraw":
                    System.out.println("Enter withdrawal amount:");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine();  // Add this line
                    atm.withdraw(withdrawalAmount);
                    atm.checkBalance();
                    break;
                case "check balance":
                    atm.checkBalance();
                    break;
                case "quit":
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        } while (!userChoice.equalsIgnoreCase("quit"));

        scanner.close();
    }
}
