import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;

// This class helps us manage deposits and payments and save them to a file
public class LedgerManagement {
    // We set the path to where we will save/load the transactions (in a file named 'transaction.csv')
    private static final String FILE_PATH = "transaction.csv";
    private final Scanner scanner = new Scanner(System.in); // This lets us read user input from the keyboard

    // Method for adding a deposit
    public void addDeposit() {
        try {
            // Ask the user to input details about the deposit
            System.out.println("Input Description: ");
            String description = scanner.nextLine();
            System.out.println("Enter the Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("What's the Amount: ");
            double amount = Double.parseDouble(scanner.nextLine()); // Convert the input to a number

            // Create a new Transaction object for the deposit
            Transaction deposit = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);

            // Save the transaction to the file
            saveTransaction(deposit);
            System.out.println("Your Deposit is now saved");
        } catch (Exception e) {
            // If there’s any error while adding the deposit, show an error message
            System.out.println("ERROR READING DEPOSIT: " + e.getMessage());
        }
    }

    // Method for making a payment
    public void makePayment() {
        try {
            // Ask the user to input details about the payment
            System.out.println("Input Description: ");
            String description = scanner.nextLine();
            System.out.println("Enter the Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("What's the Amount: ");
            double amount = Double.parseDouble(scanner.nextLine()); // Convert the input to a number

            // Create a new Transaction object for the payment (negative amount)
            Transaction payment = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, -Math.abs(amount)); // Payment amounts are negative

            // Save the transaction to the file
            saveTransaction(payment);
            System.out.println("Okay, Payment is saved");
        } catch (Exception e) {
            // If there’s any error while adding the payment, show an error message
            System.out.println("Wow, there's an error adding payment: " + e.getMessage());
        }
    }

    // This shows a menu of options to view different transactions
    public void showLedger(ReportManagement reports) {
        // Load the list of transactions from the file
        List<Transaction> transactions = loadTransactions();

        while (true) { // Keep showing the menu until the user chooses to exit
            System.out.println("\nLedger Menu: ");
            System.out.println("A) All Transactions"); // Option to see all transactions
            System.out.println("D) Deposits only"); // Option to see only deposits
            System.out.println("P) Payments Only"); // Option to see only payments
            System.out.println("R) Reports"); // Option to see reports
            System.out.println("H) Home"); // Option to go back to the main menu
            String choice = scanner.nextLine().toUpperCase(); // Read user input and make it uppercase

            // Handle what happens based on the user's choice
            switch (choice) {
                case "A":
                    // Show all transactions
                    printTransactions(transactions);
                    break;
                case "D":
                    // Show only deposits
                    printTransactions(filterDeposits(transactions));
                    break;
                case "P":
                    // Show only payments
                    printTransactions(filterPayments(transactions));
                    break;
                case "R":
                    // Show reports
                    reports.showReports(transactions);
                    break;
                case "H":
                    // Go back to the main menu
                    return;
                default:
                    // If the user types an invalid choice, show a warning
                    System.out.println("Invalid choice.");
            }
        }
    }

    // This method loads the transactions from the 'transaction.csv' file
    public List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>(); // Create an empty list to store transactions
        try {
            // Read all lines from the CSV file
            List<String> lines = Files.readAllLines(Path.of(FILE_PATH));
            for (String line : lines) {
                // Convert each line into a Transaction object and add it to the list
                transactions.add(Transaction.fromCSV(line));
            }
        } catch (IOException e) {
            // If there’s an error reading the file, show a message and return an empty list
            System.out.println("Could not load transactions. Starting from beginning.");
        }
        return transactions; // Return the list of transactions
    }

    // This method saves a transaction to the 'transaction.csv' file
    private void saveTransaction(Transaction t) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) { // Open the file in 'append' mode
            // Write the transaction's CSV format to the file, adding a new line
            writer.write(t.toCSV() + "\n");
        } catch (IOException e) {
            // If there’s an error saving the transaction, show an error message
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    // This method filters transactions to only show deposits (amount > 0)
    private List<Transaction> filterDeposits(List<Transaction> transactions) {
        List<Transaction> deposits = new ArrayList<>(); // Create a list to hold the deposits
        for (Transaction t : transactions) {
            // If the transaction is a deposit (positive amount)
            if (t.getAmount() > 0) {
                deposits.add(t); // Add it to the deposits list
            }
        }
        return sortByNewest(deposits); // Sort the deposits list by the newest transactions first
    }

    // This method filters transactions to only show payments (amount < 0)
    private List<Transaction> filterPayments(List<Transaction> transactions) {
        List<Transaction> payments = new ArrayList<>(); // Create a list to hold the payments
        for (Transaction t : transactions) {
            // If the transaction is a payment (negative amount)
            if (t.getAmount() < 0) {
                payments.add(t); // Add it to the payments list
            }
        }
        return sortByNewest(payments); // Sort the payments list by the newest transactions first
    }

    // This method sorts transactions by the most recent ones first (newest date and time)
    private List<Transaction> sortByNewest(List<Transaction> list) {
        list.sort(Comparator.comparing(Transaction::getDate) // Sort by date
                .thenComparing(Transaction::getTime) // Then sort by time
                .reversed()); // Reverse the order so newest comes first
        return list; // Return the sorted list
    }

    // This method prints out the details of each transaction in a list
    private void printTransactions(List<Transaction> list) {
        if (list.isEmpty()) {
            // If the list is empty, show a message saying no transactions were found
            System.out.println("No transactions were found.");
        } else {
            // Otherwise, print each transaction in the list
            for (Transaction t : list) {
                System.out.println(t);
            }
        }
    }
}
