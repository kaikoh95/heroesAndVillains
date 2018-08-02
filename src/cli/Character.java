package cli;
/**
 * Class to initialize Heroes and Villains.
 * key variables are name, type, skill, buff, health, atk, def
 * and defeatCount for villain
 * @author Kai and Blue
 */
public class Character {
	public String charName, charTypeStr, charSkill, charBuff;
	public int charHealth, charCurrentHealth, charATK, charDEF, charRole;
	public int charDead = 0, charPower = 0, defeatCount = 0;
	
	/**
	 * Enum Type for types of Character there are in the game. Includes types for Heroes and Villains.
	 * function getType uses this enum to get the type of Character.
	 */
	public enum Type {
		NONE, PICKUP, NAVIGATOR, LUCKY, REGEN, BERSERKER, STURDY, ONETRICK, DISPEL, RAIDBOSS
	}
	
	public Type charType; //allows it to be referenced by other classes
	
	/**
	 * gets type of character (heroes and villains alike) 
	 * and sets respective stats
	 */
	public void getType() {
		switch (charType) {
			case PICKUP:
				charTypeStr = String.format(" %s: I have a knack for picking up random items from the ground.", charName);
				charSkill = "Pickup random items";
				charATK = charDEF = 1;
				break;
			case NAVIGATOR:
				charTypeStr = String.format(" %s: With eyes like Heimdall, I can see the entire map.", charName);
				charSkill = "Able to see the entire World Map";
				charATK = charDEF = 1;
				break;
			case LUCKY:
				charTypeStr = String.format( "%s: I get cheaper prices everywhere! Yippee!", charName);
				charSkill = "Very good at bargaining";
				charATK = charDEF = 1;
				break;
			case REGEN:
				charTypeStr = String.format(" %s: Don't worry about me, I patch myself up easily.", charName);
				charSkill = "Regen 1 health upon winning a battle";
				charATK = charDEF = 1;
				break;
			case BERSERKER:
				charTypeStr = String.format(" %s: RAAAAAAMPAGE MODE LET'S GO!", charName);
				charSkill = "Hard-hitter";
				charATK = 2;
				if (charRole == 1) {
					charHealth = charCurrentHealth = 3;
				}
				if (charRole == 0) {
					charDEF = 0;
				}
				break;
			case STURDY:
				charTypeStr = String.format(" %s: I am Groot. (I have strong defenses.)", charName);
				charSkill = "Iron-skin";
				charDEF = 2;
				if (charRole == 1) {
					charHealth = charCurrentHealth = 3;
				}
				break;
			case ONETRICK:
				charTypeStr = String.format(" %s: I'm a one-trick pony. I only fight in my favourite battle ground!", charName);
				charSkill = "Excels in only one game";
				charRole = 1;
				charHealth = charCurrentHealth = 3;
				break;
			case DISPEL:
				charTypeStr = String.format(" %s: Your specialties don't work against me HAH!", charName);
				charSkill = "Negates special powers and buffs";
				charHealth = charCurrentHealth = 3;
				charRole = 1;
				break;
			case RAIDBOSS:
				charTypeStr = String.format(" %s: I'm not as kind as Thanos. When I'm done, NONE of humanity will exist. MUAHAHA!", charName);
				charSkill ="He's the boss, what else?";
				charATK = 3;
				charDEF = 2;
				charRole = 1;
				charHealth = charCurrentHealth = 5;
				break;
			default:
				charTypeStr = String.format(" %s: Come on, why don't I get a specialty? I will still kill ALL of you!", charName);
				charSkill = "None";
				if (charRole == 1) {
					charHealth = charCurrentHealth = 3;
				}
				break;
		}
	}
	
	/**
	 * character constructor - default
	 */
	public Character() {
		charName = "Rambo";
		charATK = charDEF = 1;
		charHealth = charCurrentHealth = 8;
		charType = Type.BERSERKER;
		charRole = 0;
		getType();
		checkBuff();
	}
	
	/**
	 * character constructor - modified default
	 * @param type - allows user to set type of character
	 */
	public Character(Type type) {
		charName = "Devious Sin";
		charATK = charDEF = 1;
		charHealth = charCurrentHealth = 8;
		charType = type;
		charRole = 0;
		getType();
		checkBuff();
	}
	
	/**
	 * character constructor - slightly liberated default
	 * @param name - allows name to be set
	 * @param type - allows character type to be set
	 */
	public Character(String name, Type type) {
		charName = name;
		charATK = charDEF = 1;
		charHealth = charCurrentHealth = 8;
		charType = type;
		charRole = 0;
		getType();
		checkBuff();
	}
	
	/**
	 * Main Character constructor
	 * @param name - takes in string for name
	 * @param atk - integer for attack power
	 * @param def - integer for defence power
	 * @param health - integer for max health
	 * @param role - villain (1), or hero (0)
	 * @param type - type of character
	 */
	public Character(String name, int atk, int def, int health, int role, Type type) {
		charName = name;
		charHealth = health;
		charCurrentHealth = charHealth;
		charATK = atk;
		charDEF = def;
		charRole = role;
		charType = type;
		getType();
		checkBuff();
	}
	
	/**
	 * allows printout of Character 
	 * prints name and character type
	 */
	public String toString() {
		String str = String.format(" %s: I am %s!\n%s", charName, charName, charTypeStr);
		if (charType == Type.STURDY) {
			str = String.format(" %s: I am Groot! (I am %s!)\n%s", charName, charName, charTypeStr);
		}
		return str;
	}
	
	/**
	 * For comparing between different Hero classes.
	 * @return character info
	 */
	public String getHeroInfo() {
		String str = String.format("Class: %s|Max Health: %d|Attack: %d|Defence: %d|Skill: %s|", 
								  charType, charHealth, charATK, charDEF, charSkill);
		return str;
	}
	
	/**
	 * Attributes page of the character.
	 * @return character info
	 */
	public String getCharInfo() {
		String role;
		if (charRole == 0) {
			role = "Hero - ";
		} else {
			role = "Villain - ";
		}
		role += charType;
		String str = String.format("|Class: %s|Name: %s|Health: %d/%d|Attack: %d|Defence: %d|Skill: %s|Buff: %s", role, charName, charCurrentHealth, 
				charHealth, charATK, charDEF, charSkill, charBuff);
		return str;
	}
	
	/**
	 * Checks what power-up does the character have in effect.
	 */
	public void checkBuff() {
		if (charPower == 0) {
			charBuff = "None";
		} else if (charPower == 1) {
			charBuff = "50% chance of winning the next round";
		} else if (charPower == 2) {
			charBuff = "Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)";
		} else if (charPower == 3) {
			charBuff = "Takes no damage when you lose the next round";
		}
	}
	
	/**
	 * checks Character Health.
	 */
	public void checkHealth() {
		System.out.println(String.format("Morgan Freeman (aka Narrator): %s has %d/%d HP left.", charName, charCurrentHealth, charHealth));
	}
	
	/**
	 * Checks if character is dead, prints final breath of the character.
	 * @return - true(dead) or false(alive)
	 */
	public Boolean deadAlive() {
		if (charCurrentHealth <= 0) {
			if (charRole == 0) {
				System.out.println("Morgan Freeman (aka Narrator): You have been killed...");
				charDead = 1;
			} else if (charRole == 1 && charType == Type.RAIDBOSS) {
				System.out.println(String.format("Sonaht: No...this cannot be! The prophecy was real...You have my respect..."));
				charDead = 1;
			} else if (charRole == 1) {
				System.out.println(String.format("%s: You pathetic fools, you can't stop the Great Lord...", charName));
				charDead = 1;
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * where the character attacks the defender upon winning a game round
	 * @param defender - the one taking damage
	 */
	public void dealDamage(Character defender) {
		defender.deadAlive();
		if (charCurrentHealth > 0) {
			int dmg = charATK - (defender.charDEF - 1);
			if (charPower == 3) {
				System.out.println("Morgan Freeman (aka Narrator): By the Norse Gods' protection, you take no damge!");
				charPower = 0;
				checkBuff();
				dmg = 0;
			} else {
				if (dmg <= 0) {
					dmg = 1;
				}
				System.out.println(String.format("Morgan Freeman (aka Narrator): %s dealt %d damage to %s!", charName, dmg, defender.charName));
			}
			defender.charCurrentHealth -= dmg;
		}
		defender.checkHealth();
	}
	
	/**
	 * main function
	 * @param args - main function
	 */
	public static void main(String[] args) {
		Character hero1 = new Character();
		System.out.println(hero1);
		System.out.println(hero1.getCharInfo());
		Character hero2 = new Character(Type.PICKUP);
		
		System.out.println(hero2);
		System.out.println(hero2.getCharInfo());
		
		Character villain1 = new Character("Lord Sonaht", 1, 1, 3, 1, Type.RAIDBOSS);
		System.out.println(villain1);
		System.out.println(villain1.getCharInfo());
		hero1.dealDamage(villain1);
		hero1.dealDamage(villain1);
		hero1.dealDamage(villain1);
		villain1.deadAlive();
		
	}
	
}
