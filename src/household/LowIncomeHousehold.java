package household;

public class LowIncomeHousehold extends Household {

    public LowIncomeHousehold() {
        super("Low Income Household", 5000);
    }

    @Override
    public void dailyNeeds() {
        System.out.println("Low income households prioritize only essential goods.");
    }
}