import java.util.Scanner; // This lets us get input from the keyboard

// This is the main class. Think of it like the main "remote control" for your program.
public class Testing {

    // This is where the program starts running
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // This helps us read what the user types

        LedgerManagement ledger = new LedgerManagement(); // This helps us keep track of money stuff
        ReportManagement reports = new ReportManagement(); // This helps us look at reports about our money

        // This loop will keep going until the user says "Exit"
        while (true) {
            try {
                // Show the main menu to the user
                System.out.println("\n - Accounting Ledger -");
                System.out.println("D) Add Deposits"); // Option to add money
                System.out.println("P) Make Payment"); // Option to spend money
                System.out.println("L) Ledger"); // Option to see the money list
                System.out.println("X) Exit"); // Option to quit the program
                System.out.print("Select an Option: ");

                // Read what the user typed, remove extra spaces, and make it all uppercase
                String choice = scanner.nextLine().trim().toUpperCase();

                // If the user didn’t type anything, show an error message
                if (choice.isEmpty()) {
                    throw new IllegalArgumentException("Input can't be empty. Enter a valid choice.");
                }

                // Depending on what the user picked, do the right thing
                switch (choice) {
                    case "D": // If the user typed "D", let them add a deposit
                        ledger.addDeposit();
                        break;
                    case "P": // If they typed "P", let them make a payment
                        ledger.makePayment();
                        break;
                    case "L": // If they typed "L", show the ledger (money history)
                        ledger.showLedger(reports);
                        break;
                    case "X": // If they typed "X", end the program
                        System.out.println("Thank you, Goodbye");
                        return; // Leave the main loop and end the program
                    default: // If they typed something weird, show this message
                        System.out.println("Invalid option. Please try again.");
                }

            } catch (IllegalArgumentException e) {
                // If there was a small mistake, show the message
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                // If something big went wrong, show this
                System.out.println("Error: something went wrong.");
                e.printStackTrace(); // Print the problem so we can fix it
                return; // Stop the program
            }
        }
    }
}
