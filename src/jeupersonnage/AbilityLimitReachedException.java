package jeupersonnage;

public class AbilityLimitReachedException extends Exception {
	
	public AbilityLimitReachedException(String charName) {
        super(charName + " has reached max 2 abilities!");
    }
}
