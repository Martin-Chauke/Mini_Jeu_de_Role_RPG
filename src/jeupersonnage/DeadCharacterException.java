package jeupersonnage;

public class DeadCharacterException extends Exception {

	public DeadCharacterException(String charName) {
      super(charName + " is dead and cannot attack or perform any actions!");
	}
}
