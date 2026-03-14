package jeupersonnage;

public class Wizard extends Character {
     public int maxMana=50;
     public int magicPower=12;
     public int currentMana=50;
     
     
     
     public Wizard(String name) {
    	 super(name,80);
     }
     
     
     @Override
     public void attack(Character target) throws DeadCharacterException, InsufficientManaException {
    	 if (!isAlive()) {
    		 throw new DeadCharacterException(getName());
    	 }
    	 
    	 //Check if there is enough mana
    	 if (currentMana < 10) {
    		 throw new InsufficientManaException(getName(),currentMana,10);
    	 }
    	 
    	 //use mana and calculate the damage
    	 currentMana-=10;
         int damage=1-+ magicPower + getLevel() * 3;
         
         target.takeDamage(damage);
         System.out.println(getName() + " casts magic at "+ target.getName() + " for " + damage + "damage! Mana: "+ currentMana + "/" + maxMana);
     }
     
     
  
     @Override
     public void useAbility(int index, Character target) {
    	 return ;
     }
     
     //A method for regenerating the mana
     public void regenMana(int amount) {}
     
}
