package market;

import java.util.List;

public class InflationCalculator {
    

    public static void applyInflation(List<Product> products, double rate) {
        for (Product p : products) {
            // Calculate new price: current price + (current price * inflation rate)
            double newPrice = p.getPrice() + (p.getPrice() * rate);
            p.setPrice(newPrice);
        }
    }
}