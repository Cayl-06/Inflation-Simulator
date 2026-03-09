package simulation;

import market.Market;
import market.Product;
import household.Household;
import household.LowIncomeHousehold;
import household.MiddleIncomeHousehold;
import household.HighIncomeHousehold;

import java.util.Scanner;

public class SimulationManager {
    public void run() {
        Scanner sc = new Scanner(System.in);

        // 1. SETUP PHASE

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
        playerHousehold.dailyNeeds(); 

        int totalDays = 5; 
        double dailyInflationRate = 0.05; // 5% daily inflation
        int survivalScore = 0;

        // 2. THE DAILY LOOP
        for (int day = 1; day <= totalDays; day++) {
            System.out.println("\n==========================================");
            System.out.println("                  DAY " + day);
            System.out.println("==========================================");

            // Apply inflation at the start of Day 2 onward
            if (day > 1) {
                // Member 2's market update
                localMarket.updatePrices(dailyInflationRate); 
                System.out.println(">>> ALERT: Inflation has increased prices by " + (dailyInflationRate * 100) + "%! <<<");
            }

            // Trigger a shortage
            if (day == 3) {
                System.out.println(">>> BREAKING NEWS: Severe Rice Shortage! <<<");
                localMarket.triggerShortage("Rice", 2.0); 
            }

            // Check if they are already broke
            if (playerHousehold.getBudget() <= 0) {
                System.out.println("\n❌ BANKRUPTCY! You have no money left to survive.");

                printFinalReport(survivalScore, playerHousehold);
                
                return; 
            }

            boolean boughtFood = false;
            boolean boughtTransport = false;
            boolean doneShopping = false;
            boolean cannotAffordAnything = false;

            // Daily shopping loop
            while (!doneShopping) {
                
                if (playerHousehold.getBudget() < localMarket.getCheapestPrice()) {
                        System.out.println("\n⚠️ You cannot afford any more items (Cheapest item: ₱" 
                                            + String.format("%.2f", localMarket.getCheapestPrice()) + ").");
                        doneShopping = true;
                        cannotAffordAnything = true;
                        continue;
                    }
                

                System.out.println("\nCurrent Budget: ₱" + String.format("%.2f", playerHousehold.getBudget())); 
                System.out.println("Daily Goals: Need at least 1 Food & 1 Transport item.");

                localMarket.showProducts();
                System.out.println("0. Finish shopping for the day");
                System.out.print("Enter the ID of the item to buy: ");
                
                int choice = sc.nextInt();

                if (choice == 0) {
                    doneShopping = true;
                    continue;
                }

                Product selectedItem = localMarket.getProduct(choice);

                if (selectedItem != null) {
                     //contraints
                    try {
                        // Member 1's spend method throws an Exception if they can't afford it
                        playerHousehold.spend(selectedItem.getPrice());
                        
                        System.out.println("-> You successfully bought: " + selectedItem.getName());

                        // Track categories for survival score logic
                        String category = selectedItem.getCategory();
                        if (category.equalsIgnoreCase("Food")) {
                            boughtFood = true;
                        } else if (category.equalsIgnoreCase("Transport")) {
                            boughtTransport = true;
                        }
                        
                    } catch (Exception e) {
                        // Catches the overspending error from Household.java
                        System.out.println("-> [FAILED] " + e.getMessage());
                    }
                } else {
                    System.out.println("-> Invalid item ID. Please try again.");
                }
            }

            // End of day Survival Check
            if (cannotAffordAnything) {
                System.out.println("\n❌ You can no longer afford any essential goods. Ending the simulation early.");
                printFinalReport(survivalScore, playerHousehold);
                sc.close();
                return;
            }

            System.out.println("\n--- End of Day " + day + " Report ---");
            if (boughtFood && boughtTransport) {
                System.out.println("Result: You met all your daily survival needs!");
                survivalScore += 20; 
            } else {
                System.out.println("Result: WARNING! You failed to secure essential needs today.");
                survivalScore -= 10; 
            }
        }

        printFinalReport(survivalScore, playerHousehold);
        sc.close();




        
    }
    // 4. FINAL REPORT
    private void printFinalReport(int survivalScore, Household household) {
        System.out.println("\n==========================================");
        System.out.println("             SIMULATION OVER");
        System.out.println("==========================================");
        System.out.println("Final Survival Score: " + survivalScore);
        System.out.println("Total Expenses: ₱" + String.format("%.2f", household.getTotalExpenses()));
        System.out.println("Remaining Budget: ₱" + String.format("%.2f", household.getBudget()));
    }
    
}