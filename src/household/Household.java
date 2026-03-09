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

    
}