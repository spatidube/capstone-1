import java.util.Scanner;


import java.util.Scanner;

public class Testing {
    //print hoome screen
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ledgerManagement ledgerManagement = new ledgerManagement();
        reportManagement reportManagement   =  new reportManagement();


    }


    public static void main(String[] args) {
        while(true) {
            System.out.println("\n - Accounting Legder -");
            System.out.println("D) Add Deposits");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.println("Select and Option: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    ledgerManager.addDeposit();
                    break;


    }

        }
    }


        }

