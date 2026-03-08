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


        System.out.println("\nSimulation complete!");
        System.out.println("Final budget: ₱" + budget);
    }
}
