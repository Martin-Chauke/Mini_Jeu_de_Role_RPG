#Mini Jeu De Role

#The Game Architecture.

Character (abstract base)
├── name: String
├── level: int (min 1)
├── currentHP: int // nombre de points de vie actuels
├── maxHP: int (>0)// Nombre maximum de  maximum
├── abilities: Ability[2] (null-allowed)//espace de  memorization
├── isAlive(): boolean
├── takeDamage(int dmg)
├── heal(int amount)
├── levelUp()
├── displayStatus()
└── attack(Character target)  // Polymorphic

Role subclasses:
├── Warrior
│   ├── strength: integer
│   ├── defense: integer
│   └── attack(): High physical damage, reduce incoming damage(dmg).
├── Wizard
│   ├── mana: int (current/max)
│   ├── magicPower: int
│   └── attack(): Magic dmg if mana sufficient
└── Archer
    ├── precision: int
    ├── agility: int
    └── attack(): Distance dmg w/ crit chance (e.g., 20% bonus if random > threshold)

Ability (interface)
├── String name
├── use(Character user, Character target)  // Effects: dmg, heal, buff
└── Examples: Fireball (dmg), Heal (restore HP), Shield (temp defense)

DemoRPG.main(): Create 2+ chars, assign abilities, run 3-turn battle loop (attack/ability/use), display actions/results, end on KO.
