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
 
	//Must be implemented with ConstraintValidator interface, but not required here.
	@Override
	public void boolean isValid(Object regAmount, 
		      ConstraintValidatorContext context) {
		
	}
	
	public void boolean invalidAmount(Object regAmount, ConstraintValidator context){
		String nonNumber = ("\D");
		if (regAmount.getFrequency() != null && regAmount.getAmount() == "" || regAmount.getAmount() == nonNumber) {
			return true;
		}
	}
    
    public void boolean nullFrequency(Object regAmount, ConstraintValidator context) {
    	if(regAmount.getFrequency()== null && regAmount.getAmount() != "") {
    		return true;
    	}
    }
    
    public void boolean weekly(Object regAmount, ConstraintValidator context) {
    	Frequency freqTimePeriod = Frequency.WEEK;
    	if(regAmount.getFrequency() == freqTimePeriod && regAmount.getAmount() != null) {
    		return true;
    	}
    }
 
    public void boolean monthly(Object regAmount, ConstraintValidator context) {
    	Frequency freqTimePeriod = Frequency.MONTH;
    	if(regAmount.getFrequency() == freqTimePeriod && regAmount.getAmount() != null) {
    		return true;
    	}
    }
    
    public void boolean validatedAsValid(Object regAmount, ConstraintValidator context) {
    	Frequency freq = regAmount.getFrequency();
    	String amount = regAmount.getAmount();
    	int intAmount=Integer.parseInt(amount);  
    	if(assocaitedNumber.containsKey(freq) && intAmount % freq ==0) {
    		return true;
    	}
    }
    
    public void boolean validatedAsInvalid(Object regAmount, ConstraintValidator context) {
    	Frequency freq = regAmount.getFrequency();
    	String amount = regAmount.getAmount();
    	int intAmount=Integer.parseInt(amount);  
    	if(assocaitedNumber.containsKey(freq) && intAmount % freq !=0) {
    		context.message();
    		return false;
    	}
    }
    
}


	