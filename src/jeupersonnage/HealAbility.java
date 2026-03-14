package jeupersonnage;

public class HealAbility implements Ability {
   
	public String getName() {return "Heal.";}
	
	public void use(Character user, Character target) {
		if(!user.isAlive()) {
			System.out.println(user.getName()+" is dead and cannot use."+ getName());
			
			return;
		}
		int healAmount=30+ user.getLevel();
		target.heal(healAmount);
		System.out.println(user.getName()+ " uses "+ getName()+ " on "+ target.getName()+ " for "+ healAmount+ "HP(hit points) restored.");
		
	}
}
