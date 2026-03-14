package jeupersonnage;

public class InsufficientManaException extends Exception {
	
	 public InsufficientManaException(String charName, int current, int required) {
		 
	        super(charName + " has insufficient mana (" + current + " < " + required + ")!");
	    }
}
