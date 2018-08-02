package cli;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class for the city 
 * - holds base, power-up den, hospital, 
 * item shop and villain's lair
 * -allows movement between locations
 * -map lookup
 * -base random events
 * @author Kai and Blue
 *
 */
public class CityMap {
	
	public int currentLoc = 0, shopLoc = 0, denLoc = 0, hosLoc = 0;
	public int lairLoc = 0, opt = -1, opt1 = 0, baseLoc = 0, cityVersion;
	public int milli = 1000;
	public Boolean check;
	public String option, cityName;
	Scanner scanner = new Scanner(System.in);
	Random randomNum = new Random();
	
	/**
	 * Looks up map and tells direction.
	 * If no map or undiscovered, the respective directions 
	 * will be set to 'unknown'
	 * @param myTeam - team of heroes
	 */
	@SuppressWarnings("unused")
	public void mapLookUp(WarriorsOfLight myTeam) {
		myTeam.mapCount = 0;
		for (Character hero: myTeam.teamHeroes) {
			if (hero.charType == Character.Type.NAVIGATOR) {
				if (!myTeam.teamMaps.contains("North")) {
					myTeam.teamMaps.add("North");
				} 
				if (!myTeam.teamMaps.contains("West")) {
					myTeam.teamMaps.add("West");
				} 
				if (!myTeam.teamMaps.contains("East")) {
					myTeam.teamMaps.add("East");
				} 
				if (!myTeam.teamMaps.contains("South")) {
					myTeam.teamMaps.add("South");
				}
				myTeam.mapCount = 4;
			}
		}
		for (String maps: myTeam.teamMaps) {
			myTeam.mapCount++;
		}
		if (myTeam.mapCount > 4) {
			myTeam.mapCount = 4;
		}
		if (myTeam.mapCount == 0) {
			System.out.println("Morgan Freeman (aka Narrator): No maps to use for this city. Boo...");
		} else {
			for (String maps: myTeam.teamMaps) {
				if (maps == "West") {
					if (cityVersion == 1) {
						System.out.println("Morgan Freeman (aka Narrator): West side contains <Item Shop>");
					} else if (cityVersion == 2) {
						System.out.println("Morgan Freeman (aka Narrator): West side contains <Hospital>");
					} else if (cityVersion == 3) {
						System.out.println("Morgan Freeman (aka Narrator): West side contains <Power-Up Den>");
					} else if (cityVersion == 4) {
						System.out.println("Morgan Freeman (aka Narrator): West side contains <Hospital>");
					} else if (cityVersion == 5) {
						System.out.println("Morgan Freeman (aka Narrator): West side contains <Villain's Lair>");
					} else if (cityVersion == 6) {
						System.out.println("Morgan Freeman (aka Narrator): West side contains <Villain's Lair>");
					} 
				} else if (maps == "North") {
					if (cityVersion == 1) {
						System.out.println("Morgan Freeman (aka Narrator): North side contains <Villain's Lair>");
					} else if (cityVersion == 2) {
						System.out.println("Morgan Freeman (aka Narrator): North side contains <Power-Up Den>");
					} else if (cityVersion == 3) {
						System.out.println("Morgan Freeman (aka Narrator): North side contains <Item Shop>");
					} else if (cityVersion == 4) {
						System.out.println("Morgan Freeman (aka Narrator): North side contains <Power-Up Den>");
					} else if (cityVersion == 5) {
						System.out.println("Morgan Freeman (aka Narrator): North side contains <Item Shop>");
					} else if (cityVersion == 6) {
						System.out.println("Morgan Freeman (aka Narrator): North side contains <Hospital>");
					} 
				} else if (maps == "East") {
					if (cityVersion == 1) {
						System.out.println("Morgan Freeman (aka Narrator): East side contains <Hospital>");
					} else if (cityVersion == 2) {
						System.out.println("Morgan Freeman (aka Narrator): East side contains <Villain's Lair>");
					} else if (cityVersion == 3) {
						System.out.println("Morgan Freeman (aka Narrator): East side contains <Hospital>");
					} else if (cityVersion == 4) {
						System.out.println("Morgan Freeman (aka Narrator): East side contains <Item Shop>");
					} else if (cityVersion == 5) {
						System.out.println("Morgan Freeman (aka Narrator): East side contains <Power-Up Den>");
					} else if (cityVersion == 6) {
						System.out.println("Morgan Freeman (aka Narrator): East side contains <Power-Up Den>");
					} 
				} else if (maps == "South") {
					if (cityVersion == 1) {
						System.out.println("Morgan Freeman (aka Narrator): South side contains <Power-Up Den>");
					} else if (cityVersion == 2) {
						System.out.println("Morgan Freeman (aka Narrator): South side contains <Item Shop>");
					} else if (cityVersion == 3) {
						System.out.println("Morgan Freeman (aka Narrator): South side contains <Villain's Lair>");
					} else if (cityVersion == 4) {
						System.out.println("Morgan Freeman (aka Narrator): South side contains <Villain's Lair>");
					} else if (cityVersion == 5) {
						System.out.println("Morgan Freeman (aka Narrator): South side contains <Hospital>");
					} else if (cityVersion == 6) {
						System.out.println("Morgan Freeman (aka Narrator): South side contains <Item Shop>");
					} 
				}
			}
		}
	}
	
	/**
	 * For base interactions 
	 * - view team status, hero attributes, map lookup and select next destination
	 * @param myTeam - team of heroes
	 */
	public void base(WarriorsOfLight myTeam) {
		opt = -1;
		System.out.println(String.format("Morgan Freeman (aka Narrator): We have arrived at %s", cityName));
		while (opt != 4) {
			System.out.println("Morgan Freeman (aka Narrator): This is your Secret Base. What would you like to do? Choose a number from the options below: ");
			System.out.println("1) View Team Status\n2) View Hero Attributes\n3) Open Map\n4) Select next destination");
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt = Integer.parseInt(option);
					if (opt > 4 || opt < 1) {
						System.out.println("Morgan Freeman (aka Narrator): Only choose between 1 to 4...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Morgan Freeman (aka Narrator): Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			if (opt == 1) {
				System.out.println(myTeam);
				System.out.println();
			} else if (opt == 2) {
				for (Character hero: myTeam.teamHeroes) {
					System.out.println(hero.getCharInfo());
				}
				System.out.println();
			} else if (opt == 3) {
				mapLookUp(myTeam);
				System.out.println();
			} else if (opt == 4) {
				break;
			}
		}
		System.out.println("Morgan Freeman (aka Narrator): Where to?");
		System.out.println("1) West\n2) North\n3) East\n4) South");
		option = scanner.next();
		check = false;
		while (check == false) {
			try {
				opt = Integer.parseInt(option);
				if (opt > 4 || opt < 1) {
					System.out.println("Morgan Freeman (aka Narrator): Only choose between 1 to 4...");
					option = scanner.next();
					continue;
				}
			} catch (NumberFormatException nFE) {
				System.out.println("Morgan Freeman (aka Narrator): Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
				option = scanner.next();
				continue;
			}
			check = true;
		}
		move(opt, myTeam);
		if (opt == 1) {
			if (cityVersion == 1) {
				System.out.println("Morgan Freeman (aka Narrator): West side contains <Item Shop>");
			} else if (cityVersion == 2) {
				System.out.println("Morgan Freeman (aka Narrator): West side contains <Hospital>");
			} else if (cityVersion == 3) {
				System.out.println("Morgan Freeman (aka Narrator): West side contains <Power-Up Den>");
			} else if (cityVersion == 4) {
				System.out.println("Morgan Freeman (aka Narrator): West side contains <Hospital>");
			} else if (cityVersion == 5) {
				System.out.println("Morgan Freeman (aka Narrator): West side contains <Villain's Lair>");
			} else if (cityVersion == 6) {
				System.out.println("Morgan Freeman (aka Narrator): West side contains <Villain's Lair>");
			} 
		} else if (opt == 2) {
			if (cityVersion == 1) {
				System.out.println("Morgan Freeman (aka Narrator): North side contains <Villain's Lair>");
			} else if (cityVersion == 2) {
				System.out.println("Morgan Freeman (aka Narrator): North side contains <Power-Up Den>");
			} else if (cityVersion == 3) {
				System.out.println("Morgan Freeman (aka Narrator): North side contains <Item Shop>");
			} else if (cityVersion == 4) {
				System.out.println("Morgan Freeman (aka Narrator): North side contains <Power-Up Den>");
			} else if (cityVersion == 5) {
				System.out.println("Morgan Freeman (aka Narrator): North side contains <Item Shop>");
			} else if (cityVersion == 6) {
				System.out.println("Morgan Freeman (aka Narrator): North side contains <Hospital>");
			} 
		} else if (opt == 3) {
			if (cityVersion == 1) {
				System.out.println("Morgan Freeman (aka Narrator): East side contains <Hospital>");
			} else if (cityVersion == 2) {
				System.out.println("Morgan Freeman (aka Narrator): East side contains <Villain's Lair>");
			} else if (cityVersion == 3) {
				System.out.println("Morgan Freeman (aka Narrator): East side contains <Hospital>");
			} else if (cityVersion == 4) {
				System.out.println("Morgan Freeman (aka Narrator): East side contains <Item Shop>");
			} else if (cityVersion == 5) {
				System.out.println("Morgan Freeman (aka Narrator): East side contains <Power-Up Den>");
			} else if (cityVersion == 6) {
				System.out.println("Morgan Freeman (aka Narrator): East side contains <Power-Up Den>");
			} 
		} else if (opt == 4) {
			if (cityVersion == 1) {
				System.out.println("Morgan Freeman (aka Narrator): South side contains <Power-Up Den>");
			} else if (cityVersion == 2) {
				System.out.println("Morgan Freeman (aka Narrator): South side contains <Item Shop>");
			} else if (cityVersion == 3) {
				System.out.println("Morgan Freeman (aka Narrator): South side contains <Villain's Lair>");
			} else if (cityVersion == 4) {
				System.out.println("Morgan Freeman (aka Narrator): South side contains <Villain's Lair>");
			} else if (cityVersion == 5) {
				System.out.println("Morgan Freeman (aka Narrator): South side contains <Hospital>");
			} else if (cityVersion == 6) {
				System.out.println("Morgan Freeman (aka Narrator): South side contains <Item Shop>");
			} 
		}
	}
	
	/**
	 * Allows team to shop for adventurer items like
	 * healing items, buffs and maps.
	 * If already contains a particular map will state 'already exists'.
	 * If not enough gold, shame on ya' stop stealing
	 * @param myTeam - team of heroes
	 * @param misc - prices for items, buffs and maps from Misc Class
	 */
	public void shop(WarriorsOfLight myTeam, Misc misc) {
		currentLoc = 9;
		opt = -1;
		System.out.println("Cloud - the retired Adventurer: Welcome to my Inn! As the saying goes: An item a city keeps the L away!");
		System.out.println("Cloud - the retired Adventurer: The Team's Current Status: ");
		System.out.println(myTeam);
		System.out.println();
		while (opt != 0) {
			System.out.println("Cloud - the retired Adventurer: Would you like to buy something? 0 - No (Returns to Base), 1 - Yes");
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt = Integer.parseInt(option);
					if (opt > 1 || opt < 0) {
						System.out.println("Cloud - the retired Adventurer: Only choose between 0 and 1...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Cloud - the retired Adventurer: Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			if (opt == 0) {
				break;
			}
			System.out.println("Cloud - the retired Adventurer: How can I help?");
			for (Character hero: myTeam.teamHeroes) {
				if (hero.charType == Character.Type.LUCKY) {
					System.out.println("Cloud - the retired Adventurer: Meh, You've got a price-haggler in your party? How annoying...");
					break;
				}
			}
			int buff1 = misc.buffs(1, myTeam);
			int buff2 = misc.buffs(2, myTeam);
			int buff3 = misc.buffs(3, myTeam);
			int item1 = misc.heals(1, myTeam);
			int item2 = misc.heals(2, myTeam);
			int item3 = misc.heals(3, myTeam);
			int map1 = misc.maps(1, myTeam);
			int map2 = misc.maps(2, myTeam);
			int map3 = misc.maps(3, myTeam);
			int map4 = misc.maps(4, myTeam);
			System.out.println();
			System.out.println("0) To exit shop and return to Base.");
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt = Integer.parseInt(option);
					if (opt > 10 || opt < 0) {
						System.out.println("Cloud - the retired Adventurer: Only choose between 0 to 10...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Cloud - the retired Adventurer: Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			if (opt == 0) {
				break;
			} else if (opt == 1) {
				if (myTeam.teamGold >= buff1) {
					myTeam.teamGold -= buff1;
					myTeam.buffCount++;
					myTeam.teamBuffs.add("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
					System.out.println("Cloud - the retired Adventurer: Bought 50-50 Lemon Squeezy");
				} else {
					System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
				}
			} else if (opt == 2) {
				if (myTeam.teamGold >= buff2) {
					myTeam.teamGold -= buff2;
					myTeam.buffCount++;
					myTeam.teamBuffs.add("Name: Youaremydestiny|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
					System.out.println("Cloud - the retired Adventurer: Bought YouaremyDestiny");
				} else {
					System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
				}
			} else if (opt == 3) {
				if (myTeam.teamGold >= buff3) {
					myTeam.teamGold -= buff3;
					myTeam.buffCount++;
					myTeam.teamBuffs.add("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
					System.out.println("Cloud - the retired Adventurer: Bought Iron Maiden Potent");
				} else {
					System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
				}
			} else if (opt == 4) {
				if (myTeam.teamGold >= item1) {
					myTeam.teamGold -= item1;
					myTeam.itemCount++;
					myTeam.teamItems.add("Name: Small Salve|Time taken to heal: 10 seconds|");
					System.out.println("Cloud - the retired Adventurer: Bought Small Salve");
				} else {
					System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
				}
			} else if (opt == 5) {
				if (myTeam.teamGold >= item2) {
				myTeam.teamGold -= item2;
				myTeam.itemCount++;
				myTeam.teamItems.add("Name: Mighty Morphine|Time taken to heal: 5 seconds|");
				System.out.println("Cloud - the retired Adventurer: Bought Mighty Morphine");
				} else {
					System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
				}
			} else if (opt == 6) {
				if (myTeam.teamGold >= item3) {
					myTeam.teamGold -= item3;
					myTeam.itemCount++;
					myTeam.teamItems.add("Name: Name: Fountain of Life|Time taken to heal: 3 seconds|");
					System.out.println("Cloud - the retired Adventurer: Bought Fountain of Life");
				} else {
					System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
				}
			} else if (opt == 7) {
				if (!myTeam.teamMaps.contains("West")) {
					if (myTeam.teamGold >= map1) {
						myTeam.teamGold -= map1;
						myTeam.teamMaps.add("West");
						myTeam.mapCount++;
						System.out.println("Cloud - the retired Adventurer: Bought West map");
					} else {
						System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
					}
				} else {
					System.out.println("Cloud - the retired Adventurer: Mate, you already have this map...");
				}
			
			} else if (opt == 8) {
				if (!myTeam.teamMaps.contains("North")) {
					if (myTeam.teamGold >= map2) {
						myTeam.teamGold -= map2;
						myTeam.teamMaps.add("North");
						myTeam.mapCount++;
						System.out.println("Cloud - the retired Adventurer: Bought North map");
					} else {
						System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
					}
				} else {
					System.out.println("Cloud - the retired Adventurer: Mate, you already have this map...");
				}
			
			} else if (opt == 9) {
				if (!myTeam.teamMaps.contains("East")) {
					if (myTeam.teamGold >= map3) {
						myTeam.teamGold -= map3;
						myTeam.teamMaps.add("East");
						myTeam.mapCount++;
						System.out.println("Cloud - the retired Adventurer: Bought East map");
					} else {
						System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
					}
				} else {
					System.out.println("Cloud - the retired Adventurer: Mate, you already have this map...");
				}
			
			} else if (opt == 10) {
				if (!myTeam.teamMaps.contains("South")) {
					if (myTeam.teamGold >= map4) {
						myTeam.teamGold -= map4;
						myTeam.teamMaps.add("South");
						myTeam.mapCount++;
						System.out.println("Cloud - the retired Adventurer: Bought South map");
					} else {
						System.out.println("Cloud - the retired Adventurer: Buying without gold? I call thief!"); 
					}
				} else {
					System.out.println("Cloud - the retired Adventurer: Mate, you already have this map...");
				}
			}
			System.out.println();
			System.out.println("Cloud - the retired Adventurer: The Team's Current Status: ");
			System.out.println(myTeam);
			System.out.println();
		}
		if (opt == 0) {
			move(0, myTeam); /*Returns to Base*/
		}
	}
	
	/**
	 * Allows user to select and use power-ups 
	 * on a hero and 
	 * removes the power-up used from inventory
	 * @param myTeam - team of heroes
	 */
	public void den(WarriorsOfLight myTeam) {
		opt = -1;
		currentLoc = 9;
		System.out.println("Dr Doom: Hehehe...come forth to use a power-up! Hehehe...");
		System.out.println("Dr Doom: The Team's Current Status: ");
		System.out.println(myTeam);
		for (Character hero: myTeam.teamHeroes) {
			System.out.println(hero.getCharInfo());
		}
		System.out.println();
		while (opt != 0 && myTeam.buffCount > 0) {
			System.out.println("Dr Doom: Each Hero can only have one power-up! Hehehe...");
			System.out.println("Dr Doom: Use a power-up? 0 - No (Returns to Base), 1 - Yes");
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt = Integer.parseInt(option);
					if (opt > 1 || opt < 0) {
						System.out.println("Dr Doom: Only choose between 0 and 1...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Dr Doom: Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			if (opt == 0 || myTeam.buffCount == 0) {
				break;
			}
			System.out.println("Dr Doom: Choose buff to use: ");
			int count = 0;
			for (String buff: myTeam.teamBuffs) {
				count++;
				System.out.println(String.format("%d) ", count) + buff);
			}
			System.out.println("\n0) Exit and return to Base.");
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt = Integer.parseInt(option);
					if (opt > myTeam.buffCount || opt < 0) {
						System.out.println("Dr Doom: Only choose from the given options...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Dr Doom: Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			count = 0;
			System.out.println("Dr Doom: Who would you like to use it on?");
			for (Character hero: myTeam.teamHeroes) {
				count++;
				System.out.println(String.format("%d) ", count) + hero);
			}
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt1 = Integer.parseInt(option);
					if (opt1 > myTeam.teamCount || opt1 < 1) {
						System.out.println("Dr Doom: Only choose from the given heroes...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Dr Doom: Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			//see what buff is used
			String temp = myTeam.teamBuffs.get(opt - 1);
			if (myTeam.teamBuffs.get(opt - 1).contains("Lemon")) {
				
				myTeam.teamHeroes.get(opt1 - 1).charPower = 1;
				myTeam.teamHeroes.get(opt1 - 1).checkBuff();
				myTeam.teamBuffs.remove(opt - 1);
				myTeam.buffCount--;
			} else if (myTeam.teamBuffs.get(opt - 1).contains("destiny")) {
				myTeam.teamHeroes.get(opt1 - 1).charPower = 2;
				myTeam.teamHeroes.get(opt1 - 1).checkBuff();
				myTeam.teamBuffs.remove(opt - 1);
				myTeam.buffCount--;
			} else if (myTeam.teamBuffs.get(opt - 1).contains("Maiden")) {
				myTeam.teamHeroes.get(opt1 - 1).charPower = 3;
				myTeam.teamHeroes.get(opt1 - 1).checkBuff();
				myTeam.teamBuffs.remove(opt - 1);
				myTeam.buffCount--;
			}
			System.out.println();
			System.out.println(String.format("Dr Doom: Used %s", temp));
			System.out.println("Dr Doom: The Team's Current Status: ");
			System.out.println(myTeam);
			for (Character hero: myTeam.teamHeroes) {
				System.out.println(hero.getCharInfo());
			}
			System.out.println();
		}
		if (opt == 0 || myTeam.buffCount == 0) {
			move(0, myTeam); /*Returns to Base*/
		}
	}
	
	/**
	 * Healing function because who doesn't need one
	 * when you're out in the wild.
	 * Allows user to select and use an item on a hero
	 * then removes that item from inventory
	 * @param myTeam - team of heroes
	 */
	public void hospital(WarriorsOfLight myTeam) {
		opt = -1;
		currentLoc = 9;
		System.out.println("Nurse Joy: Welcome to the Hero-mon center! Chansey and I can help you heal up!");
		System.out.println("Nurse Joy: The Team's Current Status: ");
		System.out.println(myTeam);
		for (Character hero: myTeam.teamHeroes) {
			System.out.println(hero.getCharInfo());
		}
		System.out.println();
		while (opt != 0 && myTeam.itemCount > 0) {
			System.out.println("Nurse Joy: Use a healing item? 0 - No (Returns to Base), 1 - Yes");
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt = Integer.parseInt(option);
					if (opt > 1 || opt < 0) {
						System.out.println("Nurse Joy: Only choose between 0 and 1...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Nurse Joy: Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			if (opt == 0 || myTeam.itemCount == 0) {
				break;
			}
			System.out.println("Nurse Joy: Choose item to use: ");
			int count = 0;
			for (String buff: myTeam.teamItems) {
				count++;
				System.out.println(String.format("%d) ", count) + buff);
			}
			System.out.println("\n0) Exit and return to Base.");
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt = Integer.parseInt(option);
					if (opt > myTeam.itemCount || opt < 0) {
						System.out.println("Nurse Joy: Only choose from the given options...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Nurse Joy: Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			count = 0;
			System.out.println("Nurse Joy: Who would you like to use it on?");
			for (Character hero: myTeam.teamHeroes) {
				count++;
				System.out.println(String.format("%d) ", count) + hero);
			}
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt1 = Integer.parseInt(option);
					if (opt1 > myTeam.teamCount || opt1 < 1) {
						System.out.println("Nurse Joy: Only choose from the given heroes...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Nurse Joy: Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			long currentTime = System.currentTimeMillis();
			long elapsedTime = System.currentTimeMillis();
			long diffTime = elapsedTime - currentTime;
			int timer;
			long check1 = diffTime % milli;
			ArrayList<Long> times = new ArrayList<>();
			String temp1 = myTeam.teamItems.get(opt - 1);
			if (myTeam.teamItems.get(opt - 1).contains("Salve")) {
				timer = 10;
				while (diffTime < 11 * milli) {
					if (check1 == 0 && !times.contains(diffTime)) {
						times.add(diffTime);
						System.out.println(timer + " seconds left to full Health!");
						timer--;
						if (diffTime % (2 * milli) == 0) {
							if (myTeam.teamHeroes.get(opt1 - 1).charCurrentHealth < myTeam.teamHeroes.get(opt1 - 1).charHealth) {
								myTeam.teamHeroes.get(opt1 - 1).charCurrentHealth += 2;
							} else {
								myTeam.teamHeroes.get(opt1 - 1).charCurrentHealth = myTeam.teamHeroes.get(opt1 - 1).charHealth;
							}
						}
					}
					elapsedTime = System.currentTimeMillis();
					diffTime = elapsedTime - currentTime;
					check1 = diffTime % milli;
				}
				myTeam.teamItems.remove(opt - 1);
				myTeam.itemCount--;
			} else if (myTeam.teamItems.get(opt - 1).contains("Morphine")) {
				timer = 5;
				while (diffTime < 6 * milli) {
					if (check1 == 0 && !times.contains(diffTime)) {
						times.add(diffTime);
						System.out.println(timer + " seconds left to full Health!");
						timer--;
						if (diffTime % (2 * milli) == 0) {
							if (myTeam.teamHeroes.get(opt1 - 1).charCurrentHealth < myTeam.teamHeroes.get(opt1 - 1).charHealth) {
								myTeam.teamHeroes.get(opt1 - 1).charCurrentHealth += 4;
							} else {
								myTeam.teamHeroes.get(opt1 - 1).charCurrentHealth = myTeam.teamHeroes.get(opt1 - 1).charHealth;
							}
						}
					}
					elapsedTime = System.currentTimeMillis();
					diffTime = elapsedTime - currentTime;
					check1 = diffTime % milli;
				}
				myTeam.teamItems.remove(opt - 1);
				myTeam.itemCount--;
			} else if (myTeam.teamItems.get(opt - 1).contains("Fountain")) {
				timer = 3;
				while (diffTime < 4 * milli) {
					if (check1 == 0 && !times.contains(diffTime)) {
						times.add(diffTime);
						System.out.println(timer + " seconds left to full Health!");
						timer--;
						if (myTeam.teamHeroes.get(opt1 - 1).charCurrentHealth < myTeam.teamHeroes.get(opt1 - 1).charHealth) {
							myTeam.teamHeroes.get(opt1 - 1).charCurrentHealth += 2;
						} else {
							myTeam.teamHeroes.get(opt1 - 1).charCurrentHealth = myTeam.teamHeroes.get(opt1 - 1).charHealth;
						}
					}
					elapsedTime = System.currentTimeMillis();
					diffTime = elapsedTime - currentTime;
					check1 = diffTime % milli;
				}
				myTeam.teamItems.remove(opt - 1);
				myTeam.itemCount--;
			}
			System.out.println(String.format("Nurse Joy: Used %s", temp1));
			System.out.println(String.format("Nurse Joy: %s is back to full health now!", myTeam.teamHeroes.get(opt1 - 1).charName));
			System.out.println();
			System.out.println("Nurse Joy: The Team's Current Status: ");
			System.out.println(myTeam);
			for (Character hero: myTeam.teamHeroes) {
				System.out.println(hero.getCharInfo());
			}
			System.out.println();
		}
		if (opt == 0 || myTeam.itemCount == 0) {
			move(0, myTeam); /*Returns to Base*/
		}
	}
	
	/**
	 * We all need this function to move on to the next city.
	 * Defeat the villain that stands in our way!
	 * Calls BattleScenes class to battle it out with the villain.
	 * @param villain - villain for the current city
	 * @param myTeam - team of heroes
	 */
	public void lair(Character villain, WarriorsOfLight myTeam) {
		opt = -1;
		currentLoc = 9;
		BattleScenes battle = new BattleScenes(); //create new battle game scene challenge
		System.out.println(villain); 
		System.out.println(String.format("Villain Type: %s!", villain.charType.toString()));
		villain.defeatCount = 0;
		if (villain.charType == Character.Type.RAIDBOSS) {
			System.out.println(String.format("%s: I'm surprised you've made it so far. Guess I'll have to do it myself. Hmph.", villain.charName));
		}
		while (opt != 0 && villain.defeatCount < 3 && !myTeam.teamHeroes.isEmpty()) {
			System.out.println(String.format("%s: Battle me? 1 - Yes. 0 - No (Returns to Base)", villain.charName));
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					opt = Integer.parseInt(option);
					if (opt > 1 || opt < 0) {
						System.out.println("Morgan Freeman (aka Narrator): Dude! Stop fooling around...");
						option = scanner.next();
						continue;
					}
				} catch (NumberFormatException nFE) {
					System.out.println("Morgan Freeman (aka Narrator): Dude! Stop fooling around...");
					option = scanner.next();
					continue;
				}
				check = true;
			}
			if (opt == 0) {
				break;
			}
			while (villain.defeatCount < 3 && !myTeam.teamHeroes.isEmpty()) {
				if (villain.defeatCount < 1) {
					System.out.println(String.format("%s: Fools! Now who wanna die first?", villain.charName));
				} else {
					System.out.println(String.format("%s: Not bad...who's next?", villain.charName));
				}
				int count = 0;
				for (Character hero: myTeam.teamHeroes) {
					count++;
					System.out.println(String.format("%d) ", count) + hero);
				}
				option = scanner.next();
				check = false;
				while (check == false) {
					try {
						opt1 = Integer.parseInt(option);
						if (opt1 > myTeam.teamCount || opt1 < 1) {
							System.out.println("Morgan Freeman (aka Narrator): Dude! Stop fooling around...");
							option = scanner.next();
							continue;
						}
					} catch (NumberFormatException nFE) {
						System.out.println("Morgan Freeman (aka Narrator): Dude! Stop fooling around...");
						option = scanner.next();
						continue;
					}
					check = true;
				}
				int villainOption = Math.abs(randomNum.nextInt()) % 3;
				if (villain.charType == Character.Type.ONETRICK) {
					villainOption = 2;
				}
				if (villainOption == 0) {
					battle.rockPaperScissors(myTeam.teamHeroes.get(opt1 - 1), villain, myTeam);
				} else if (villainOption == 1) {
					battle.rollDice(myTeam.teamHeroes.get(opt1 - 1), villain, myTeam);
				} else {
					battle.highLow(myTeam.teamHeroes.get(opt1 - 1), villain, myTeam);
				}
			}
		}
		if (opt == 0 || villain.defeatCount >= 3) {
			if (villain.defeatCount >= 3) {
				System.out.println("Morgan Freeman (aka Narrator): Well done! You've cleared this city!");
				myTeam.citiesCleared++;
				if (myTeam.citiesCleared == myTeam.numCityCount) {
					System.out.println("Morgan Freeman (aka Narrator): WOW! You've done it aye? You've saved the world!");
					myTeam.clearGame = 1;
				}
			}
			move(0, myTeam); /*Returns to Base*/
		}
	}
	
	/**
	 * Without this, you cant move from one place to another,
	 * so rejoice!
	 * @param choice - used for 'select destination' part from base, 
	 * other numbers simply return you to base because 
	 * those are the specs of the game
	 * @param myTeam - team of heroes
	 */
	public void move(int choice, WarriorsOfLight myTeam) {
		opt = -1;
		if (currentLoc != 0) {
			//returns to base and random event occurs
			System.out.println("Morgan Freeman (aka Narrator): Returning to base");
			int randEvent = Math.abs(randomNum.nextInt()) % 7;
			if (randEvent == 1) {
				System.out.println("Morgan Freeman (aka Narrator): Who the F didn't lock the door??? Sheez!");
				if (!myTeam.teamItems.isEmpty()) {
					String lost = myTeam.teamItems.remove(0);
					myTeam.itemCount--;
					System.out.println(String.format("(a minion has stolen: %s)", lost.substring(9)));
				}
			} else if (randEvent == 2) {
				System.out.println("Morgan Freeman (aka Narrator): Who the F didn't lock the door??? Sheez!");
				if (!myTeam.teamBuffs.isEmpty()) {
					String lost = myTeam.teamBuffs.remove(0);
					myTeam.buffCount--;
					System.out.println(String.format("(a minion has stolen: %s)", lost.substring(9)));
				}
			} else if (randEvent == 3) {
				System.out.println("Morgan Freeman (aka Narrator): Wow look at what doggo fetched us today!");
				String gain;
				int randItem = Math.abs(randomNum.nextInt()) % 3;
				if (randItem == 0) {
					gain = "Small Salve";
					myTeam.teamItems.add("Name: Small Salve|Time taken to heal: 10 seconds|");
				} else if (randItem == 1) {
					gain = "Mighty Morphine";
					myTeam.teamItems.add("Name: Mighty Morphine|Time taken to heal: 5 seconds|");
				} else {
					gain = "Fountain of Life";
					myTeam.teamItems.add("Name: Fountain of Life|Time taken to heal: 3 seconds|");
				}
				myTeam.itemCount++;
				System.out.println(String.format("(received: %s)", gain));
			} else if (randEvent == 4) {
				System.out.println("Morgan Freeman (aka Narrator): Wow look at what doggo fetched us today!");
				String gain;
				int randItem = Math.abs(randomNum.nextInt()) % 3;
				if (randItem == 0) {
					gain = "50-50 Lemon Squeezy";
					myTeam.teamBuffs.add("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
				} else if (randItem == 1) {
					gain = "Youaremydestiny";
					myTeam.teamBuffs.add("Youaremydestiny|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
				} else {
					gain = "Iron Maiden Potent";
					myTeam.teamBuffs.add("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
				}
				myTeam.buffCount++;
				System.out.println(String.format("(received: %s)", gain));
			}
			currentLoc = 0;
		}
		else {
			currentLoc = choice;
			if (choice == 1) {
				System.out.println("Morgan Freeman (aka Narrator): Moving West");
				if (!myTeam.teamMaps.contains("West")) {
					myTeam.mapCount++;
					myTeam.teamMaps.add("West");
				}
			} else if (choice == 2) {
				System.out.println("Morgan Freeman (aka Narrator): Moving North");
				if (!myTeam.teamMaps.contains("North")) {
					myTeam.mapCount++;
					myTeam.teamMaps.add("North");
				}
			} else if (choice == 3) {
				System.out.println("Morgan Freeman (aka Narrator): Moving East");
				if (!myTeam.teamMaps.contains("East")) {
					myTeam.mapCount++;
					myTeam.teamMaps.add("East");
				}
			} else if (choice == 4) {
				System.out.println("Morgan Freeman (aka Narrator): Moving South");
				if (!myTeam.teamMaps.contains("South")) {
					myTeam.mapCount++;
					myTeam.teamMaps.add("South");
				}
			}
		}
	}

	/**
	 * Map Layouts for each of the 6 cities
	 * @param version - which layout to use
	 */
	public CityMap(int version) {
		cityVersion = version;
		if (version == 1) {
			/* Variation 1
			 *       lair
			 *         |
			 * shop - base - hospital
			 *         |
			 *        den
			 */
			cityName = "Palette Town";
			shopLoc = 1;
			denLoc = 4;
			hosLoc = 3;
			lairLoc = 2; 
			
			
		} else if (version == 2) {
			/* Variation 2
			 *            den
			 *             |
			 * hospital - base - lair
			 *             |
			 *            shop
			 */
			cityName = "Vacante City";
			shopLoc = 4;
			denLoc = 2;
			hosLoc = 1;
			lairLoc = 3; 
			
		} else if (version == 3) {
			/* Variation 3
			 *       shop
			 *        |
			 * den - base - hospital
			 *        |
			 *       lair
			 */
			cityName = "Henesis-Genesys";
			shopLoc = 2;
			denLoc = 1;
			hosLoc = 3;
			lairLoc = 4; 
			
		} else if (version == 4) {
			/* Variation 4
			 *            den
			 *             |
			 * hospital - base - shop
			 *             |
			 *            lair
			 */
			cityName = "Got-them City";
			shopLoc = 3;
			denLoc = 2;
			hosLoc = 1;
			lairLoc = 4; 
			
		} else if (version == 5) {
			/* Variation 5
			 *        shop
			 *         |
			 * lair - base - den
			 *         |
			 *       hospital
			 */
			cityName = "Summoner's Bay";
			shopLoc = 2;
			denLoc = 3;
			hosLoc = 4;
			lairLoc = 1; 
			
		} else if (version == 6) {
			/* Variation 6
			 *        hospital
			 *         |
			 * lair - base - den
			 *         |
			 *       shop
			 */
			cityName = "Shiganshina Dome";
			shopLoc = 4;
			denLoc = 3;
			hosLoc = 2;
			lairLoc = 1; 
			
		}
		
	}
	
	/**
	 * main function
	 * @param args - main
	 */
	public static void main(String[] args) {
		CityMap gotham = new CityMap(4);
		Character fallen = new Character("Fallen Angel Risen Devil", Character.Type.DISPEL);
		WarriorsOfLight myTeam = new WarriorsOfLight();
		Misc misc = new Misc();
		myTeam.setTeamInfo();
		gotham.base(myTeam);
		gotham.shop(myTeam, misc);
		gotham.den(myTeam);
		gotham.hospital(myTeam);
		gotham.lair(fallen, myTeam);
	}
}
