// IMPORORTS
import java.time.LocalDate;
import java.time.LocalTime;

//CLASS DECLARATION
public class Transaction {

    // INSTANCE VARIABLES
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    //CONSTRUCTOR
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //Getters and Setters baby! right click and generate it
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    //CONVERT CSV lint to a transaction
    public static Transaction fromCSV(String line) {

        // i want to split each part of data with a pipe (delimiter)
        String[] choice = line.split("\\|");

        //parse + assign each value from the array
        String dateText = choice[0];
        String timeText = choice[1];
        String description = choice[2];
        String vendor = choice[3];
        String amountText = (choice[4]);

        //Convert strings to correct data types
        LocalDate date = LocalDate.parse(dateText);
        LocalTime time = LocalTime.parse(timeText);
        double amount = Double.parseDouble(amountText);

//return this transaction obect with parsed data
        return new Transaction(date, time, description, vendor,amount);
    }
        //Convert Transaction to CSV LINE
        public String toCSV() {
            return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
        }
// to now display on the screen with parameters we need to set them
    public String toString() {
        return String.format("%s %s | %-20s | %-15s | $%8.2f", date, time, description, vendor,amount);

    }
}

