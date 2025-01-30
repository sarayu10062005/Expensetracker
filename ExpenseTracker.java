import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    static ArrayList<String> expenseNames = new ArrayList<>();
    static ArrayList<Double> expenseAmounts = new ArrayList<>();
    static double totalExpense = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expense");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character after nextInt()

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    viewTotalExpense();
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    public static void addExpense(Scanner scanner) {
        System.out.print("Enter the name of the expense: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter the amount for the expense: ");
        double amount = scanner.nextDouble();
        
        expenseNames.add(name);
        expenseAmounts.add(amount);
        totalExpense += amount;

        System.out.println("Expense added successfully.");
    }

    public static void viewExpenses() {
        if (expenseNames.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("List of Expenses:");
            for (int i = 0; i < expenseNames.size(); i++) {
                System.out.println((i + 1) + ". " + expenseNames.get(i) + " - $" + expenseAmounts.get(i));
            }
        }
    }

    public static void viewTotalExpense() {
        System.out.println("Total Expense: $" + totalExpense);
    }
}
