import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;

// allows us add , filter and view transactions
public class LedgerManagement {
    private static final String FILE_PATH = "src/main/resources/transaction.csv";
    private final Scanner scanner = new Scanner(System.in);
    //user inputs deposit information and saves it
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
        System.out.println(" ERROR READING DEPOSIT: " + e.getMessage());
    }

        // SCENE: Make a payment - need user info and need to save it all
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
           System.out.println("okaay, Payment is saved");
       } catch (Exception e) {
           System.out.println(" wow, there's and error adding payment: " + e.getMessage());
       }
    }
        // we want to now show ledgeer menu with options to see the transactions

    public void showLedger(ReportManagement reports) {
        //Make an array of transactions
        List<Transaction> transactions = loadTransactions();

        while (true) {
            System.out.println("\nLedger Menu: ");
            System.out.println("A) All Transactions");
            System.out.println("D) Deposits only");
            System.out.println("P) Payments Only");
            System.out.println("H) Home");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    printTransactions(transactions);
                case "D":
                    printTransactions(filterDeposits(transactions));
                case "P":
                    printTransactions(filerPayments(transactions));
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

public List<Transaction> loadTransaction()
   List<Transcation> transcations = new ArrayList<>();
   try {
       List<String> lines = Files.readAllLines(Path.get(FILE_PATH));
       for (String line : lines) {
           transcations.add(Transaction.fromCSV(line));
       }
   } catch (IOException e) {
            System.out.println("Could not load transactions. Starting from beginning.");
        }
        return transcations;
        }
private List<Transaction> filterDeposits(List<Transaction> transactions) {
        List<Transaction> deposits = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() > 0) {
                deposits.add(t);
            }
        }
        return sortByNewest(deposits);

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
private void printTransactions(List<>)


 //load transctions from csv
public List<Transaction> loadTransactions() {

    List<Transaction> transactions = new ArrayList<>();
    try{
        List<String> lines = Files.readAllLines((Paths.get(C:\Users\Student\pluralsight\capstone-1\AccountingLegder\src\main\resources\transaction.csv));
        for (String line : lines) {
            transactions.add(Transaction.fromCSV(line));







