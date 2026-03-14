package jeupersonnage;

public class Archer extends Character{
   
	public int precision=14;
	public int agility=10; // portee ou vitesse 
	
	
	public Archer(String name) {
		super(name,90);
	}
	
	@Override
	public void attack(Character target) throws DeadCharacterException{
		if (!isAlive()) {
			
			throw new DeadCharacterException(getName());
		}
		int damage = 12 + (precision/2) + getLevel();
		
		// 20% criticizing chance
		if (Math.random()< 0.20) {}
		damage*=2;
		
		System.out.println(getName()+ " shoots "+ target.getName() + " for " + damage + "damages!");
	}

	
	
}
