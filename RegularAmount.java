import Package javax.validation.constraints;

public class RegularAmount {
	
	@RegularAmountConstraint
    private Frequency frequency;
    
    @RegularAmountConstraint
    private String amount;
    
    
    public Frequency getFrequency() {
        return frequency;
    }
    
    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
} }
public enum Frequency {
    WEEK, TWO_WEEK, FOUR_WEEK, MONTH, QUARTER, YEAR;
}