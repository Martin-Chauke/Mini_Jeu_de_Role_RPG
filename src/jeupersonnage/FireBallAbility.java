package jeupersonnage;

public class FireBallAbility implements Ability{
	
	@Override
	public String getName() {
		return "FireBall";
		}
	public void use(Character user, Character target) {
		if(!user.isAlive()) {
			System.out.println(user.getName()+ " is dead and cannot use "+ getName());
			
			return;
			
		}
		
		int damage=25+ user.getLevel() *5;
		target.takeDamage(damage);
		System.out.println(user.getName()+"uses "+ getName()+"on "+ target.getName()+ "for " +damage+" damage!");;
		
	}
	

}
