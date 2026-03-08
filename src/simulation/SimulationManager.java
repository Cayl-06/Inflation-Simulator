package simulation;

import java.util.Scanner;

public class SimulationManager {
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Inflation & Cost of Living Simulator ===");
        System.out.println("Choose household type:");
        System.out.println("1. Low Income Household");
        System.out.println("2. Middle Income Household");
        System.out.println("3. High Income Household");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        double budget = 5000; 
        System.out.println("Starting budget: ₱" + budget);

        System.out.print("Enter number of days to survive: ");
        int days = sc.nextInt();

        for (int day = 1; day <= days; day++) {
            System.out.println("\nDay " + day);

           
            System.out.println("Market prices (placeholder): Rice ₱40, Meat ₱150");

          
            System.out.print("Enter expense for today: ");
            double expense = sc.nextDouble();
            budget -= expense;

            if (budget < 0) {
                System.out.println("Budget went negative! Game Over.");
                return;
            }
            System.out.println("Remaining budget: ₱" + budget);
        }

        System.out.println("\nSimulation complete!");
        System.out.println("Final budget: ₱" + budget);
    }
}
