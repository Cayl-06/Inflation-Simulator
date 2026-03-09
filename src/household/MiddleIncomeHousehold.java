package household;

public class MiddleIncomeHousehold extends Household {

    public MiddleIncomeHousehold() {
        super("Middle Income Household", 12000);
    }

    @Override
    public void dailyNeeds() {
        System.out.println("Middle income households balance needs and savings.");
    }
}