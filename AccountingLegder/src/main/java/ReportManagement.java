import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// This class helps us look at different reports about our money transactions
public class ReportManagement {
    private final Scanner scanner = new Scanner(System.in); // This lets us read what the user types on the keyboard

    // This is a menu that shows options for looking at reports
    public void showReports(List<Transaction> transactions) {
        while (true) { // Keep showing the menu until the user chooses to go back
            System.out.println("\nYour Reporting Menu");
            System.out.println("1. Month to Date"); // Show transactions from the start of this month to today
            System.out.println("2. Previous Month"); // Show transactions from last month
            System.out.println("3. YTD"); // Show all transactions from the start of the year to today (Year To Date)
            System.out.println("4. Previous Year"); // Show transactions from last year
            System.out.println("5. Search by Vendor"); // Look up transactions for a specific vendor
            System.out.println("0. Go Back"); // Leave the menu and go back
            System.out.print("Select an Option: ");

            String input = scanner.nextLine(); // Read the user’s choice

            switch (input) {
                case "1":
                    // Show only this month’s transactions
                    printTransactions(filterMonthToDate(transactions));
                    break;
                case "2":
                    // Show last month’s transactions
                    printTransactions(filterPreviousMonth(transactions));
                    break;
                case "3":
                    // Show transactions from the beginning of the year until now
                    printTransactions(filterYearToDate(transactions));
                    break;
                case "4":
                    // Show transactions from last year
                    printTransactions(filterPreviousYear(transactions));
                    break;
                case "5":
                    // Ask for a vendor name and show transactions for that vendor
                    System.out.print("Enter vendor name: ");
                    String vendor = scanner.nextLine();
                    printTransactions(searchByVendor(transactions, vendor));
                    break;
                case "0":
                    // Exit the report menu
                    return;
                default:
                    // If the user types something that doesn’t match, show a warning
                    System.out.println("Not a valid choice.");
            }
        }
    }

    // These next methods are just placeholders – you will write real filtering code later
    private List<Transaction> filterMonthToDate(List<Transaction> transactions) {
        // This would keep only the transactions from this month
        return transactions;
    }

    private List<Transaction> filterPreviousMonth(List<Transaction> transactions) {
        // This would keep only the transactions from last month
        return transactions;
    }

    private List<Transaction> filterYearToDate(List<Transaction> transactions) {
        // This would keep only the transactions from the start of the year to now
        return transactions;
    }

    private List<Transaction> filterPreviousYear(List<Transaction> transactions) {
        // This would keep only the transactions from the year before this one
        return transactions;
    }

    // This looks through the transactions to find ones that match a vendor’s name
    private List<Transaction> searchByVendor(List<Transaction> transactions, String vendor) {
        List<Transaction> result = new ArrayList<>(); // A list to hold the matching results
        for (Transaction t : transactions) {
            // If the vendor name matches what the user typed (not case-sensitive)
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                result.add(t); // Add it to the results
            }
        }
        return sortByNewest(result); // Sort them so the newest ones are first
    }

    // This filters out all the payments (negative money)
    private List<Transaction> filterPayments(List<Transaction> transactions) {
        List<Transaction> payments = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) { // If the money amount is less than zero
                payments.add(t);
            }
        }
        return sortByNewest(payments);
    }

    // This sorts any list of transactions so the most recent ones come first
    private List<Transaction> sortByNewest(List<Transaction> list) {
        list.sort(Comparator.comparing(Transaction::getDate)
                .thenComparing(Transaction::getTime)
                .reversed());
        return list;
    }

    // This shows all the transactions in the list
    private void printTransactions(List<Transaction> list) {
        if (list.isEmpty()) {
            System.out.println("No transactions found."); // If there are none, say so
        } else {
            for (Transaction t : list) {
                System.out.println(t); // Otherwise, print each one
            }
        }
    }
}
