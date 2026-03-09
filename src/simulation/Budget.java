package simulation;

public class Budget {
    private double income;
    private double expenses;

    public Budget(double income) {
        this.income = income;
        this.expenses = 0;
    }

    public void addExpense(double amount) {
        expenses += amount;
    }

    public double getRemaining() {
        return income - expenses;
    }
}
