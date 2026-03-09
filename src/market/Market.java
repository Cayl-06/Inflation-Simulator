package market;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat; 

public class Market {
    private List<Product> products;

    public Market() {
        this.products = new ArrayList<>();
        initializeDefaultProducts();
    }

    // Sets up the initial items for Day 1
    private void initializeDefaultProducts() {
        products.add(new Product("Rice", 40.0, "Food"));
        products.add(new Product("Meat", 150.0, "Food"));
        products.add(new Product("Vegetables", 60.0, "Food"));
        products.add(new Product("Transportation", 20.0, "Transport"));
    }

    // Displays items available for purchase (Requested in PR)
    public void showProducts() {
        System.out.println("\n--- Market Prices ---");
                DecimalFormat df = new DecimalFormat("0.00"); 
        
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            
            System.out.println((i + 1) + ". " + p.getName() + ": ₱" + df.format(p.getPrice()) + " (" + p.getCategory() + ")");
        }
    }

    // Returns a selected product based on user input (Requested in PR)
    public Product getProduct(int id) {
        int index = id - 1; // Convert 1-based user choice to 0-based array index
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        }
        return null; // Return null if the user types an invalid number
    }

    // Updates prices using the InflationCalculator (Requested in PR)
    public void updatePrices(double rate) {
        InflationCalculator.applyInflation(products, rate);
    }

    // The Random Event Shortage method we discussed to help with constraints
    public void triggerShortage(String productName, double multiplier) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                p.setPrice(p.getPrice() * multiplier);
                System.out.println("⚠️ MARKET EVENT: " + productName + " shortage! Price spiked to ₱" + p.getPrice());
            }
        }
    }
}