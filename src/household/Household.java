package household;

public abstract class Household {

    protected String householdType;
    protected double income;
    protected double budget;
    protected double totalExpenses;

    public Household(String householdType, double income) {
        this.householdType = householdType;
        this.income = income;
        this.budget = income;
        this.totalExpenses = 0;
    }

    // Spend money on a product
    public void spend(double amount) throws Exception {
        if (amount > budget) {
            throw new Exception("Error: Not enough budget for this purchase.");
        }

        budget -= amount;
        totalExpenses += amount;
    }

    // Add income if needed
    public void addIncome(double amount) {
        income += amount;
        budget += amount;
    }

    public double getBudget() {
        return budget;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public String getHouseholdType() {
        return householdType;
    }

    public double getIncome() {
        return income;
    }

    // Each household type behaves differently
    public abstract void dailyNeeds();
    
}