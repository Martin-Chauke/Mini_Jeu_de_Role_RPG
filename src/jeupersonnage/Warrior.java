package jeupersonnage;

public class Warrior extends Character{
	public int strength=15;
	public int defense=8;
	
	
	public  Warrior(String name) {
		super(name,120);
	}
	
	
	@Override
	public int getDefenseValue() {
		return defense + getLevel();
	}
		
	
	///Deals damage based on strength
	@Override
	public void attack(Character target) throws DeadCharacterException {
		if(!isAlive()) {
			throw new DeadCharacterException(getName());
			}
		
		int damage=15 + strength + getLevel() * 2;
		damage=Math.max(1, damage-target.getDefenseValue());//Target defense reduces damage.
		
		target.takeDamage(damage);
		System.out.println(getName() + " attacks "+ target.getName() + " for " + damage +"  damage!");
		
	}
	
	
	
	 
	 
}
