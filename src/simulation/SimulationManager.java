package simulation;

import java.util.Scanner;

public class SimulationManager {
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Inflation & Cost of Living Simulator ===");

        // --- Household selection ---
        // TODO: Replace with actual Household objects once Member 1 finishes their classes
        System.out.println("Choose household type:");
        System.out.println("1. Low Income Household");
        System.out.println("2. Middle Income Household");
        System.out.println("3. High Income Household");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        // Placeholder budget (will later come from Household.getBudget())
        double budget = 5000; 
        System.out.println("Starting budget: ₱" + budget);

        // --- Survival duration ---
        System.out.print("Enter number of days to survive: ");
        int days = sc.nextInt();

        // --- Daily loop ---
        for (int day = 1; day <= days; day++) {
            System.out.println("\nDay " + day);

            // TODO: Replace with Market.showProducts() once Member 2 finishes their classes
            System.out.println("Market prices (placeholder): Rice ₱40, Meat ₱150");

            // TODO: Replace with actual buying logic using Household.spend() and ExpenseTracker
            System.out.print("Enter expense for today: ");
            double expense = sc.nextDouble();
            budget -= expense;

            // --- Constraint check ---
            if (budget < 0) {
                System.out.println("Budget went negative! Game Over.");
                return;
            }
            System.out.println("Remaining budget: ₱" + budget);
        }

        // --- End of simulation ---
        // TODO: Add scoring system and final report once integration is complete
        System.out.println("\nSimulation complete!");
        System.out.println("Final budget: ₱" + budget);
    }
}
