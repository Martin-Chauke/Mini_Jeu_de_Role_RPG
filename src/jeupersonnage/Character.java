package jeupersonnage;
import java.util.*;

public abstract class Character {
	private String name;
	private int level;
	private int currentHP;
	private int maxHP;
	protected Ability[] abilities=new Ability[2];
	protected int abilityCount=0;
	
	
	
	
	public Character(String name,int maxHP) {
		this.name=name;
		this.level=1;
		this.maxHP=Math.max(maxHP, 1); //must be greater than 1
		this.currentHP=this.maxHP;
	}
		
	
	//getters and setters
		public int getLevel() {
			return level;
		}
		
		public String getName() {
			return name;
		}
		
		
		public int getCurrentHP() {
			return currentHP;
		}
		
		public int getMaxHP() {
			return maxHP;
		}
		
		//Return the state of the character if it is alive or dead.
		public boolean isAlive() {
			return currentHP>0;
		}
		
		
	 
	//Reduces the HP, ensures it never drops below 0
	public void takeDamage(int damage) {
		if(damage<0) damage=0;
		currentHP=Math.max(0, Math.min(maxHP, currentHP-damage));
		System.out.println(name + " takes "+ damage+ "damage. HP: "+ currentHP +"/"+ maxHP);
		
		if (currentHP==0) System.out.println(name+ " has been defeated!"); 
		
	}
	
	 //restore the power
	public void heal(int amount) {
		if(amount<0) amount=0;
		currentHP=Math.min(maxHP, currentHP + amount);
		
	}
	
	//Increases level and adjusts max HP(e.g by a formula)
	public void levelUp(){
		level=Math.max(1, level + 1 );
	    maxHP +=10 * level;
	    currentHP=maxHP;
	    System.out.println(name + " leveled up to" + level+ "! Max HP increased to "+ maxHP);
	}
	
	//Adds an ability if a free slot exists
	public void addAbility(Ability ability) throws AbilityLimitReachedException  {
		
		if(abilityCount>=2) throw new AbilityLimitReachedException(getName());
			abilities[abilityCount++]=ability;
			System.out.println(name+ " learned "+ ability.getName()+"!");
		}
		
	//Attempts to use the ability at the given slot, handles
	//missing ability ability role-specific resources(like mana) if needed, and delegates to the ability's logic
	public void useAbility(int index, Character target) throws DeadCharacterException{
		
		if(!isAlive()) throw new DeadCharacterException(getName());
		
		if(index<0 || index >=abilityCount) {
			System.out.println("No ability at position "+ index);
			return;
		}
		abilities[index].use(this, target); 
	}

	//Display Character's characteristics
	public void displayStatus() { 
		System.out.println(name + "(Level " + level +") HP:"+ currentHP + "/" + maxHP +  (isAlive() ? "[ALIVE]": "[ DEAD]"));
		
		for(int i=0; i<abilityCount; i++) {
			System.out.println(" " + i +": " + abilities[i].getName());
		}
	}
	
	
	
	//attack and damage method.
	public abstract void attack(Character target) throws DeadCharacterException, InsufficientManaException;
	
	//Default no defense
	public int getDefenseValue() {
		return 0;
	}
	
	


}
