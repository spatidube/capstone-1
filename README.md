
# **Accounting Ledger System**

This is a simple **Accounting Ledger System** designed to manage financial transactions such as deposits and payments. The system allows you to add, view, and generate reports based on your transactions. All transaction data is stored in a CSV file, which can be loaded and saved as you interact with the system.

## **Features**

1. **Add Deposits and Payments**
   - Add **deposits** (money added to the account) and **payments** (money spent or deducted from the account).
   - Each transaction includes details such as **date**, **time**, **description**, **vendor**, and **amount**.
   ![image](https://github.com/user-attachments/assets/60a7cff1-c59e-4e28-a6f2-9feb4bc0f197)


2. **Manage the Ledger**
   - View all transactions in the **ledger**.
   - Filter transactions based on type (Deposits, Payments) or specific periods (Month to Date, Previous Month, Year to Date, Previous Year).![image]![image]



3. **Generate Reports**
   - Generate **reports** that summarize transactions in specific periods.
     - **Month to Date**
     - **Previous Month**
     - **Year to Date (YTD)**
     - **Previous Year**
     - **Search by Vendor**



4. **Data Persistence**
   - All transactions are saved in a **CSV file** (`transaction.csv`), which allows transactions to persist between program runs.

## **Project Structure**

### **Files & Classes**

1. **`Testing.java`**
   - This is the **entry point** of the program. It displays a main menu for the user to select different actions such as adding deposits, making payments, viewing the ledger, and generating reports.
   - It handles user input and calls appropriate functions to process commands.
![image](https://github.com/user-attachments/assets/7a168e46-06e6-4890-9305-8080804a68ef)

2. **`LedgerManagement.java`**
   - Manages **adding deposits** and **making payments**.
   - Handles the **ledger** (list of all transactions).
   - Reads and writes transactions to the `transaction.csv` file.
(https://github.com/user-attachments/assets/7085d985-d8e0-44a5-ab80-258d4715d7d3)

3. **`ReportManagement.java`**
   - Handles **generating reports** for different periods like "Month to Date", "Previous Year", etc.
   - Filters transactions by vendor or type (deposit vs. payment).
   - Sorts transactions by date and time.
![image](https://github.com/user-attachments/assets/b7a53dbe-ff78-484b-bfa3-38cc8edb23fa)
4. **`Transaction.java`**
   - Represents a **transaction** with attributes like **date**, **time**, **description**, **vendor**, and **amount**.
   - Provides methods to **convert transactions to/from CSV format** and **display the transaction** in a human-readable format.
![image](https://github.com/user-attachments/assets/b18ef098-6b6e-42f4-89b2-0a9ad8ed6931)

## **How It Works**

### **Adding Transactions**
- **Deposits**: You can add a deposit by entering a description, vendor, and amount. The amount is added to your account balance.
- **Payments**: You can make a payment by entering a description, vendor, and the amount you paid. The amount is deducted from your account balance (recorded as a negative number).

### **Viewing Transactions**
- View all transactions or filter them based on type (Deposits or Payments) or specific time periods (e.g., Month to Date, Previous Year).
  
### **Generating Reports**
- The system provides the ability to generate detailed reports summarizing your financial activities in specific periods (Month to Date, Previous Year, etc.).

### **Data Persistence**
- All transactions are saved to a CSV file called **`transaction.csv`**. This ensures that your data is saved and can be loaded even after the program is closed and reopened.

## **Getting Started**

### **Prerequisites**
- You need to have **Java** installed to run this project.

### **Running the Project**
1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/your-username/AccountingLedgerSystem.git
````

2. Navigate to the project directory:

   ```bash
   cd AccountingLedgerSystem
   ```

3. Compile and run the project using Java:

   ```bash
   javac Testing.java
   java Testing
   ```

### **Features in Action**

* **Add Deposit**: Adds money to your account.
* **Make Payment**: Deducts money from your account.
* **View Ledger**: Displays all transactions, or filters by deposits, payments, or time period.
* **Generate Reports**: Summarizes your transactions based on selected filters.

## **Example of Transactions**

Here’s an example of a transaction in the system:

```
2025-05-02 12:30:00 | Deposit        | VendorX           | $500.00
2025-05-03 09:45:00 | Payment        | VendorY           | -$150.00
```

### **File Format** (CSV):

Each transaction is saved in a CSV format:

```
2025-05-02|12:30:00|Deposit|VendorX|500.00
2025-05-03|09:45:00|Payment|VendorY|-150.00
```

## **Contributing**

Feel free to fork the repository, create pull requests, or submit issues for bug fixes or feature requests.

## **License**

This project is open-source and available under the MIT License.
