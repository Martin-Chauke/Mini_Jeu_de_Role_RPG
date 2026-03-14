package jeupersonnage;
import java.util.*;


public class DemoRGP {
	public static void main(String [] args) throws InsufficientManaException {
		  System.out.println("=== Mini RPG Combat Demo === [file:1]");
	        
	    try {
	    	Warrior warrior_1 = new Warrior("Warrior 1");
	        Wizard wizard_1 = new Wizard("Wizard 1");
	        Archer archer_1 = new Archer("Archer 1");

	        
	        // Assign abilities while handling errors
	    try {
	        warrior_1.addAbility(new FireBallAbility());
	        warrior_1.addAbility(new HealAbility());
	        wizard_1.addAbility(new FireBallAbility());
	        archer_1.addAbility(new HealAbility());
	        
	   }catch(AbilityLimitReachedException e) {
		   
		System.out.println("Ability assignment failed:"+ e.getMessage());   
	   }
	   
	        
	        
	        // Initial status
	        System.out.println("\nInitial Status:");
	        warrior_1.displayStatus();
	        wizard_1.displayStatus();
	        archer_1.displayStatus();

	        // Battle scenario - 3+ turns
	        System.out.println("\n=== BATTLE STARTS === [file:1]");
	        Character[] fighters = {warrior_1, wizard_1,  archer_1};
	        int turn = 0;
            final int MAX_TURNS = 10;
	        
	        while (turn < MAX_TURNS && warrior_1.isAlive() && archer_1.isAlive()) 
	        { // Stop after 10 turns or KO
	            turn++;
	            System.out.println("\n--- Turn " + turn + " ---");

	            // warrior_1 attacks wizard_1
	            try {
	            	
	            warrior_1.attack(archer_1);
	            
	            }catch(DeadCharacterException e) {
	            	System.out.println("Combat Error: "+ e.getMessage());
	            	break;
	            	
	            }catch(Exception e) {
	               System.out.println("Unexpected attack error: "+ e.getMessage());
	        	}
	            
	            
	            if(archer_1.isAlive()) archer_1.displayStatus();

	            if (!archer_1.isAlive()) break;

	            // archer_1 uses precision on Warrior_1
	            if (archer_1.isAlive()) {
	            
	            try {
	            	archer_1.useAbility(0, warrior_1);
	            	
	            } catch (IllegalArgumentException e) {
	            	 System.out.println("Invalid ability: " + e.getMessage());
	            }
	            
	            
	            if (warrior_1.isAlive()) warrior_1.displayStatus();

	            if (!warrior_1.isAlive()) break;

	            // wizard_1 attacks (demonstrates Archer crit potential)
	            if (turn % 2 ==0 && archer_1.isAlive()) {
	            	
	            try {
	            wizard_1.attack(archer_1);
	            } catch (DeadCharacterException e) {
	            	System.out.println("Archer 1 cannot act: "+e.getMessage());
	            	}
	            }
	            archer_1.displayStatus();

	            
	            // warrior_1 heals self
	            if (warrior_1.isAlive() && warrior_1.getCurrentHP() < warrior_1.getMaxHP() * 0.7) {
                    try {
                    	warrior_1.useAbility(1, warrior_1);  // Heal
                    } catch (Exception e) {
                        System.out.println("Heal failed: " + e.getMessage());
                    }
	            }
	              
	            //Level Up the Winner
	            if (turn % 3 == 0 && warrior_1.isAlive()) {
                    try {
                    	warrior_1.levelUp();
                    } catch (Exception e) {
                        System.out.println("Level up failed: " + e.getMessage());
                    }
                }
	            
	         }
	        }
	          // Final results
	           System.out.println("\n=== BATTLE END ===");
	           printBattleResult(warrior_1, archer_1, turn >= MAX_TURNS);

	      
	        } catch (Exception e) {
	            System.out.println("Critical demo error: " + e.getMessage());
	            e.printStackTrace();
	        }
	    
	       
     }


private static void printBattleResult(Character c1, Character c2, boolean timeLimit) {
    System.out.println("\nFinal Status:");
    c1.displayStatus();
    c2.displayStatus();
    
    if (timeLimit) {
        System.out.println("Battle ended - time limit reached!");
    } else if (c1.isAlive() && !c2.isAlive()) {
        System.out.println("🏆 " + c1.getName() + " WINS! 🏆");
    } else if (!c1.isAlive() && c2.isAlive()) {
        System.out.println("🏆 " + c2.getName() + " WINS! 🏆");
    } else {
        System.out.println("Mutual destruction!");
    }
}
}

	
		



