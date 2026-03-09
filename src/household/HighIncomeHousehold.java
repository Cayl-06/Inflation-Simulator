package household;

public class HighIncomeHousehold extends Household {

    public HighIncomeHousehold() {
        super("High Income Household", 25000);
    }

    @Override
    public void dailyNeeds() {
        System.out.println("High income households can afford flexible spending.");
    }
}