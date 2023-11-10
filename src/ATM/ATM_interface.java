package ATM;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                if (withdrawalAmount > 0) {
                    if (userAccount.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                    }
                } else {
                    System.out.println("Invalid withdrawal amount.");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
                } else {
                    System.out.println("Invalid deposit amount.");
                }
                break;
            case 3:
                System.out.println("Current balance: " + userAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

public class ATM_interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                atm.performTransaction(choice, scanner);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
