package simulation;

public class ExpenseTracker {
    private double totalExpenses = 0;

    public void addExpense(double amount) {
        totalExpenses += amount;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }
}
