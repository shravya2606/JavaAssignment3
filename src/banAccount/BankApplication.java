package banAccount;

import java.util.Scanner;

class Account {
    private String type;
    private double balance;

    public Account(String type) {
        this.type = type;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn:" + amount);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
        displayBalance();
    }

    public void displayBalance() {
        System.out.println("Current Balance:" + balance);
    }
}

class FixedDeposit {
    private double amount;
    private int durationMonths;
    private double interestRate;

    public FixedDeposit(double amount, int durationMonths, double interestRate) {
        this.amount = amount;
        this.durationMonths = durationMonths;
        this.interestRate = interestRate;
    }

    public double calculateMaturityAmount() {
        return amount + (amount * interestRate * durationMonths / 12 / 100);
    }
}

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("Welcome, " + userName + "!");
        System.out.println("Choose an account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.println("3. Demat Account");
        System.out.println("4. Fixed Deposit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                operateSavings();
                break;
            case 2:
                operateCurrent();
                break;
            case 3:
                operateDemat();
                break;
            case 4:
                operateFixedDeposit();
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
        }

        scanner.close();
    }

    private static void operateSavings() {
        Account savings = new Account("Savings Account");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nSavings Operations:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        savings.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        savings.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.println("Exiting Savings...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private static void operateCurrent() {
        Account current = new Account("Current Account");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nCurrent Operations:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        current.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        current.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.println("Exiting Current...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private static void operateDemat() {
        Account demat = new Account("Demat Account");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nDemat Operations:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        demat.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        demat.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.println("Exiting Demat...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

    private static void operateFixedDeposit() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter deposit amount for Fixed Deposit:");
            double depositAmount = scanner.nextDouble();

            System.out.print("Enter duration of Fixed Deposit in months: ");
            int durationMonths = scanner.nextInt();

            System.out.print("Enter interest rate for Fixed Deposit (%): ");
            double interestRate = scanner.nextDouble();

            FixedDeposit fixed = new FixedDeposit(depositAmount, durationMonths, interestRate);
            double maturityAmount = fixed.calculateMaturityAmount();

            System.out.println("Fixed Deposit Details:");
            System.out.println("Principal Amount:" + depositAmount);
            System.out.println("Duration: " + durationMonths + " months");
            System.out.println("Interest Rate: " + interestRate + "%");
            System.out.println("Maturity Amount:" + maturityAmount);
        }
    }
}
