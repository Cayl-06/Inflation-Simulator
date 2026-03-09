package simulation;

import market.Market;
import market.Product;
import household.Household;
import household.LowIncomeHousehold;
import household.MiddleIncomeHousehold;
import household.HighIncomeHousehold;

import java.util.Scanner;

public class SimulationManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ==========================================
        // 1. SETUP PHASE
        // ==========================================
        System.out.println("=== Welcome to the Inflation & Cost of Living Simulator ===");
        
        Market localMarket = new Market();
        Household playerHousehold = null;

        System.out.println("Choose your household type:");
        System.out.println("1. Low Income (₱5,000)");
        System.out.println("2. Middle Income (₱12,000)");
        System.out.println("3. High Income (₱25,000)");
        System.out.print("Choice: ");
        
        int hhChoice = sc.nextInt();
        switch (hhChoice) {
            case 1:
                playerHousehold = new LowIncomeHousehold();
                break;
            case 2:
                playerHousehold = new MiddleIncomeHousehold();
                break;
            case 3:
                playerHousehold = new HighIncomeHousehold();
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Low Income.");
                playerHousehold = new LowIncomeHousehold();
        }

        System.out.println("\nYou are playing as a: " + playerHousehold.getHouseholdType());
        playerHousehold.dailyNeeds(); // Trigger subclass-specific behavior

        int totalDays = 5; 
        double dailyInflationRate = 0.05; // 5% daily inflation
        int survivalScore = 0;

        
    }
}