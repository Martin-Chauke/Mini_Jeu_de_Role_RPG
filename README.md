# Mini RPG Combat System
 
A scalable object-oriented Java implementation of a mini role-playing game combat system featuring **Warrior**, **Wizard**, and **Archer** characters with abilities, exception handling, and console-based battle demo.

## Features Implemented
-  **General character modeling**: name, level, HP (current/max), 2-slot ability system
-  **Role differentiation**: 
  - **Warrior**: High strength/defense, damage reduction
  - **Wizard**: Mana-based magic attacks  
  - **Archer**: Precision-based attacks with 20% critical hit chance
-  **Ability system**: Dynamic add/use/display (Fireball, Heal)
-  **Robustness**: Dead char blocking, mana limits, array bounds, HP clamping
-  **Exception handling**: `DeadCharacterException`, `InsufficientManaException`, `AbilityLimitReachedException`
-  **Demo scenario**: 3+ turn battle with status display after each action

##  Project Structure
```
**MiniRPG**/
├── Ability.java (Interface)
├── FireballAbility.java (Damage ability)
├── HealAbility.java (Self-heal ability)
├── Character.java (Abstract base)
├── Warrior.java (Melee tank)
├── Wizard.java (Mana caster)
├── Archer.java (Ranged DPS)
├── DeadCharacterException.java (Custom exception)
├── InsufficientManaException.java
├── AbilityLimitReachedException.java
└── DemoRPG.java (Main demo + battle)
```

## Quick Start - Complete Execution Guide

### Prerequisites
- **Java 8+** installed (JDK, not just JRE)
- **Command line/terminal** access
- All `.java` files in **same folder**

### Step-by-Step Instructions

#### **Method 1: Command Line (Recommended)**

```bash
# 1. Navigate to project folder
cd path/to/MiniRPG

# 2. Compile all Java files
javac *.java

# 3. Run the battle demo
java DemoRPG
```

## **Method 2** : IDE(IntelliJ/Ecplise/VSCode)
```
1. Open folder as Java project
2. All files auto-compile
3. Right-click DemoRPG.java → "Run DemoRPG.main()"
```




## Battle Mechanics
| Role    | Stats                     | Attack Formula            | Special Rule                        |
| ------- | ------------------------- | ------------------------- | ----------------------------------- |
| Warrior | strength=15, defense=8    | 15 + strength + level×2   | Defense reduces incoming damage     |
| Wizard  | mana=50/50, magicPower=12 | 10 + magicPower + level×3 | 10 mana cost, fails if insufficient |
| Archer  | precision=14, agility=10  | 12 + precision/2 + level  | 20% crit chance (double damage)     |

## Exception Handling
```
> DeadCharacterException: Blocks dead char actions
> InsufficientManaException: Wizard mana validation  
> AbilityLimitReachedException: Max 2 abilities enforced
> try-catch blocks ensure graceful battle continuation
```

## 🔧 Key Design Decisions
```
1. Polymorphism: attack(Character) varies by role
2. Encapsulation: Private stats, public getters
3. Defense system: getDefenseValue() in Character (0 default)
4. Ability interface: Easy extension (add ShieldAbility, etc.)
5. Constraint enforcement: HP 0-maxHP, level≥1, alive checks
```
## 📈 Extensibility
```**Easy to add**:
├── New roles: `Paladin extends Character`
├── New abilities: `ShieldAbility implements Ability`  
├── Multiplayer: `Player vs Player` battle loop
└── GUI: Swing/JavaFX integration
```




