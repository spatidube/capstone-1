import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.time.*;

// allows us add , filter and view transactions
public class LedgerManagement {
    private static final String filePath = "src/main/resources/trascation.csv";
    private final Scanner scanner = new Scanner(System.in);
    //user inputs deposit information and saves it
    public void addDeposit() {
        System.out.println("Input Description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the Vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("What's the Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        Transaction deposit = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount);
        saveTransaction(deposit);
        System.out.println("Your Deposit is now saved");
    }
        // SCENE: Make a payment - need user info and need to save it all
    public void makePayment() {
            System.out.println("Input Description: ");
            String description = scanner.nextLine();
            System.out.println("Enter the Vendor: ");
            String vendor = scanner.nextLine();
            System.out.println("What's the Amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            Transaction payment = new Transaction(LocalDate.now(), LocalTime.now(), description, vendor,-Math.abs(amount));

        }
        // we want to now show ledgeer menu with options to see the transactions

    public void showLedger(ReportManagement reports) {
        //Make an array of transactions
        List<Transaction> transactions = loadTransactions();

        while (true) {
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


 //load transctions from csv
public List<Transaction> loadTransactions() {

    List<Transaction> transactions = new ArrayList<>();
    try{
        List<String> lines = Files.readAllLines((Paths.get(C:\Users\Student\pluralsight\capstone-1\AccountingLegder\src\main\resources\transaction.csv));
        for (String line : lines) {
            transactions.add(Transaction.fromCSV(line));







