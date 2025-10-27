import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Transaction {
    private Date date;
    private double amount;
    private String type; // "Deposit" or "Withdrawal"
    private double balanceAfter;

    public Transaction(Date date, double amount, String type, double balanceAfter) {
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.balanceAfter = balanceAfter;
    }

    public String toString() {
        return String.format("%s: %s of %.2f | Balance after: %.2f", date, type, amount, balanceAfter);
    }
}

class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction(new Date(), amount, "Deposit", balance));
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction(new Date(), amount, "Withdrawal", balance));
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }
}

// Sample Main class for demonstration
public class BankApp {
    public static void main(String[] args) {
        Account acct = new Account("123456");
        acct.deposit(500.0);
        acct.withdraw(150.0);
        acct.deposit(200.0);
        acct.withdraw(100.0);

        System.out.println("Current Balance: " + acct.getBalance());
        System.out.println("Transaction History:");
        acct.printTransactionHistory();
    }
}
