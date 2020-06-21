import java.util.HashMap;

public class Validator implements ConstraintValidator<RegularAmountConstraint, Object> {
	
	private Frequency frequency;
	private String amount;
	private HashMap<Frequency, Integer> associatedNumber;
	
	@Override
    public void initialize(RegularAmountConstraint frequency, amount) {
		this.frequency = constraintAnnotation.getFrequency();
        this.amount = constraintAnnotation.getAmount();
        associatedNumber = new HashMap<Frequency, Integer>();
    	associatedNumber.put("TWO_WEEK", 2);
    	associatedNumber.put("FOUR_WEEK", 4);
    	associatedNumber.put("QUARTER", 13);
    	associatedNumber.put("YEAR", 52);
    }
 
	@Override
	public void boolean isValid(Object regAmount, 
		      ConstraintValidatorContext context) {
		Frequency freq = regAmount.getFrequency();
    	String amount = regAmount.getAmount();
    	
		String nonNumber = ("\D");
		if (freq != null && amount == "" || amount == nonNumber) {
			return true;
		}
		if(freq== null && amount != "") {
    		return true;
    	}
		Frequency freqTimePeriodWeek = Frequency.WEEK;
    	if(freq == freqTimePeriod && amount != null) {
    		return true;
    	}
    	Frequency freqTimePeriodMonth = Frequency.MONTH;
    	if(freq == freqTimePeriod && amount != null) {
    		return true;
    	}
    	int intAmount=Integer.parseInt(amount);  
    	if(associatedNumber.containsKey(freq) && intAmount % freq ==0) {
    		return true;
    	}
    	int intAmount=Integer.parseInt(amount);  
    	if(assocaitedNumber.containsKey(freq) && intAmount % freq !=0) {
    		context.message();
    		return false;
    	}
	}
}
	
	
	
    
   
    
    
    
 
    
    
   
    
    
    
    



	