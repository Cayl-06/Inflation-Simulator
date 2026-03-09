package market;

public class Product {
    private String name;
    private double price;
    private String category; // e.g., "Food" or "Transport"

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

}