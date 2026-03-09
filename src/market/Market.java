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

    
}