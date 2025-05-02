import java.util.Scanner;

public class Testing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LedgerManagement ledger = new LedgerManagement();
        ReportManagement reports = new ReportManagement();

        while (true) {
            try {
                System.out.println("\n - Accounting Ledger -");
                System.out.println("D) Add Deposits");
                System.out.println("P) Make Payment");
                System.out.println("L) Ledger");
                System.out.println("X) Exit");
                System.out.print("Select an Option: ");
                String choice = scanner.nextLine().trim().toUpperCase();

                if (choice.isEmpty()) {
                    throw new IllegalArgumentException("Input can't be empty. Enter a valid choice.");
                }

                switch (choice) {
                    case "D":
                        ledger.addDeposit();
                        break;
                    case "P":
                        ledger.makePayment();
                        break;
                    case "L":
                        ledger.showLedger(reports);
                        break;
                    case "X":
                        System.out.println("Thank you, Goodbye");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: something went wrong.");
                e.printStackTrace();
                return;
            }
        }
    }
}
