import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;

public class LedgerManagement {
    private static final String FILE_PATH = "transaction.csv";
    private final Scanner scanner = new Scanner(System.in);

    // Deposit input
    public void addDeposit() {
        try {
            System.out.println("Input Description: ");
            String description = scanner.nextLine();
            System.out.println("Enter the Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("What's the Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            Transaction deposit = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);
            saveTransaction(deposit);
            System.out.println("Your Deposit is now saved");
        } catch (Exception e) {
            System.out.println("ERROR READING DEPOSIT: " + e.getMessage());
        }
    }

    // Payment input
    public void makePayment() {
        try {
            System.out.println("Input Description: ");
            String description = scanner.nextLine();
            System.out.println("Enter the Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("What's the Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            Transaction payment = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, -Math.abs(amount));
            saveTransaction(payment);
            System.out.println("Okay, Payment is saved");
        } catch (Exception e) {
            System.out.println("Wow, there's an error adding payment: " + e.getMessage());
        }
    }

    // Show ledger menu
    public void showLedger(ReportManagement reports) {
        List<Transaction> transactions = loadTransactions();

        while (true) {
            System.out.println("\nLedger Menu: ");
            System.out.println("A) All Transactions");
            System.out.println("D) Deposits only");
            System.out.println("P) Payments Only");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    printTransactions(transactions);
                    break;
                case "D":
                    printTransactions(filterDeposits(transactions));
                    break;
                case "P":
                    printTransactions(filterPayments(transactions));
                    break;
                case "R":
                    reports.showReports(transactions);
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Read transactions from CSV
    public List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(FILE_PATH));
            for (String line : lines) {
                transactions.add(Transaction.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("Could not load transactions. Starting from beginning.");
        }
        return transactions;
    }

    private void saveTransaction(Transaction t) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(t.toCSV() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    private List<Transaction> filterDeposits(List<Transaction> transactions) {
        List<Transaction> deposits = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() > 0) {
                deposits.add(t);
            }
        }
        return sortByNewest(deposits);
    }

    private List<Transaction> filterPayments(List<Transaction> transactions) {
        List<Transaction> payments = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                payments.add(t);
            }
        }
        return sortByNewest(payments);
    }

    private List<Transaction> sortByNewest(List<Transaction> list) {
        list.sort(Comparator.comparing(Transaction::getDate)
                .thenComparing(Transaction::getTime)
                .reversed());
        return list;
    }

    private void printTransactions(List<Transaction> list) {
        if (list.isEmpty()) {
            System.out.println("No transactions were found.");
        } else {
            for (Transaction t : list) {
                System.out.println(t);
            }
        }
    }
}
