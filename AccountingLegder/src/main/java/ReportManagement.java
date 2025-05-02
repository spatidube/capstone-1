import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ReportManagement {
    private final Scanner scanner = new Scanner(System.in);

    public void showReports(List<Transaction> transactions) {
        while (true) {
            System.out.println("\nYour Reporting Menu");
            System.out.println("1. Month to Date");
            System.out.println("2. Previous Month");
            System.out.println("3. YTD");
            System.out.println("4. Previous Year");
            System.out.println("5. Search by Vendor");
            System.out.println("0. Go Back");
            System.out.print("Select an Option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    printTransactions(filterMonthToDate(transactions));
                    break;
                case "2":
                    printTransactions(filterPreviousMonth(transactions));
                    break;
                case "3":
                    printTransactions(filterYearToDate(transactions));
                    break;
                case "4":
                    printTransactions(filterPreviousYear(transactions));
                    break;
                case "5":
                    System.out.print("Enter vendor name: ");
                    String vendor = scanner.nextLine();
                    printTransactions(searchByVendor(transactions, vendor));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Not a valid choice.");
            }
        }
    }

    // Sample filter methods – you’ll need to implement these yourself
    private List<Transaction> filterMonthToDate(List<Transaction> transactions) {
        // Add filtering logic here
        return transactions;
    }

    private List<Transaction> filterPreviousMonth(List<Transaction> transactions) {
        // Add filtering logic here
        return transactions;
    }

    private List<Transaction> filterYearToDate(List<Transaction> transactions) {
        // Add filtering logic here
        return transactions;
    }

    private List<Transaction> filterPreviousYear(List<Transaction> transactions) {
        // Add filtering logic here
        return transactions;
    }

    private List<Transaction> searchByVendor(List<Transaction> transactions, String vendor) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendor)) {
                result.add(t);
            }
        }
        return sortByNewest(result);
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
        list.sort(Comparator.comparing(Transaction::getDate).thenComparing(Transaction::getTime).reversed());
        return list;
    }

    private void printTransactions(List<Transaction> list) {
        if (list.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction t : list) {
                System.out.println(t);
            }
        }
    }
}
