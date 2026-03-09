package market;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat; // Imported DecimalFormat

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
        
        // Create a DecimalFormat object to force 2 decimal places
        DecimalFormat df = new DecimalFormat("0.00"); 
        
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            
            // Uses df.format() instead of printf
            System.out.println((i + 1) + ". " + p.getName() + ": ₱" + df.format(p.getPrice()) + " (" + p.getCategory() + ")");
        }
    }
}