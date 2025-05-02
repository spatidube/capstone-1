import java.util.*
import.java.time.*


//THIS IS WHERE I'LL Manage reports- transaction filtering by month /year
public class ReportManagement {
    private Scanner scanner = new Scanner(System.in);

    //display the reports menu and allow user to choose a
    publiv void showReports(List<Transaction> transactions) {
        while (true) {
            System.out.println(" Your Reporting Menu");
            System.out.println( "1. Month to Date");
            System.out.println( "2. Previous Month");
            System.out.println( "3. YTD");
            System.out.println(" 4. Previous Year");
            System.out.println(" 5. Search by Vendor");
            System.out.println(" 0. Go Back");
            System.out.print("Select and Option");
            String input = scanner.nextLine();

            switch(input) {


            }
        }
    }
    // show month-to date, previous month, year to date, previous year, search vendor

}
