// IMPORTS
import java.time.LocalDate; // We need this to work with dates (like today's date)
import java.time.LocalTime; // We need this to work with times (like the current time)

// CLASS DECLARATION
// This class represents a transaction (deposit or payment)
public class Transaction {

    // INSTANCE VARIABLES (These are the things that each transaction will have)
    private LocalDate date; // The date of the transaction
    private LocalTime time; // The time of the transaction
    private String description; // A description of the transaction (like "Payment for groceries")
    private String vendor; // The name of the vendor (like the store's name)
    private double amount; // The amount of money for the transaction (can be positive for deposits or negative for payments)

    // CONSTRUCTOR (This is like a blueprint to create a new transaction)
    // It takes the date, time, description, vendor, and amount as inputs
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date; // Set the transaction date
        this.time = time; // Set the transaction time
        this.description = description; // Set the description
        this.vendor = vendor; // Set the vendor's name
        this.amount = amount; // Set the transaction amount
    }

    // Getters and Setters (These are like helpers to get or change the values of the transaction)

    public LocalDate getDate() {
        return date; // Get the date of the transaction
    }

    public void setDate(LocalDate date) {
        this.date = date; // Change the date of the transaction
    }

    public LocalTime getTime() {
        return time; // Get the time of the transaction
    }

    public void setTime(LocalTime time) {
        this.time = time; // Change the time of the transaction
    }

    public String getDescription() {
        return description; // Get the description of the transaction
    }

    public void setDescription(String description) {
        this.description = description; // Change the description of the transaction
    }

    public String getVendor() {
        return vendor; // Get the name of the vendor
    }

    public void setVendor(String vendor) {
        this.vendor = vendor; // Change the name of the vendor
    }

    public double getAmount() {
        return amount; // Get the amount of the transaction
    }

    public void setAmount(double amount) {
        this.amount = amount; // Change the amount of the transaction
    }

    // CONVERT CSV LINE TO A TRANSACTION OBJECT
    // This method takes a string that represents a transaction (from a CSV file) and converts it into a Transaction object
    public static Transaction fromCSV(String line) {

        // Split the line by the "|" character (which is how we separate the data in the CSV file)
        String[] choice = line.split("\\|");

        // Take each part of the line and assign it to a variable
        String dateText = choice[0]; // The first part is the date
        String timeText = choice[1]; // The second part is the time
        String description = choice[2]; // The third part is the description
        String vendor = choice[3]; // The fourth part is the vendor
        String amountText = (choice[4]); // The fifth part is the amount (as a string)

        // Convert the strings into the correct data types
        LocalDate date = LocalDate.parse(dateText); // Convert the date string into a LocalDate object
        LocalTime time = LocalTime.parse(timeText); // Convert the time string into a LocalTime object
        double amount = Double.parseDouble(amountText); // Convert the amount string into a double (number)

        // Return a new Transaction object with all the information we just got
        return new Transaction(date, time, description, vendor, amount);
    }

    // CONVERT A TRANSACTION TO A CSV LINE
    // This method takes the current transaction and turns it into a string in CSV format (so it can be saved to a file)
    public String toCSV() {
        // Return the transaction as a string, with each part separated by a "|"
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }

    // DISPLAY THE TRANSACTION IN A READABLE FORMAT (like showing it on the screen)
    public String toString() {
        // This formats the transaction into a nice string with spaces and dollar signs to make it look good
        return String.format("%s %s | %-20s | %-15s | $%8.2f", date, time, description, vendor, amount);
    }
}
