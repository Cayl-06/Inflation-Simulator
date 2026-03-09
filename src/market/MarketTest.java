package market;

public class MarketTest {
    public static void main(String[] args) {
        // 1. Create a new market (this will auto-load the 4 default products)
        Market testMarket = new Market();

        // 2. Test initial display
        System.out.println("=== Initial Market (Day 1) ===");
        testMarket.showProducts();

        // 3. Test retrieving a specific product (e.g., getting Item #1)
        System.out.println("\n=== Testing getProduct() ===");
        Product p = testMarket.getProduct(1); 
        if (p != null) {
            System.out.println("Successfully retrieved: " + p.getName() + " (Category: " + p.getCategory() + ")");
        }

        // 4. Test InflationCalculator (Applying a massive 10% inflation to see clear changes)
        System.out.println("\n=== Applying 10% Inflation ===");
        testMarket.updatePrices(0.10); 
        testMarket.showProducts();

        // 5. Test the Random Event Constraint (Rice Shortage)
        System.out.println("\n=== Triggering Rice Shortage (Price Doubles!) ===");
        testMarket.triggerShortage("Rice", 2.0);
        testMarket.showProducts();
    }
}
