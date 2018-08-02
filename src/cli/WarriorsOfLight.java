package cli;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for team of heroes
 *
 * The class is for the team of heroes, have the following variable:
 * The class has access to the hero name, team name, the number of town from the setup class MainGame (CLI) StartGaem (GUI).
 * The amount of gold, buff list and item list.
 * Map position to traverse the town.
 * Buffs that the team has.
 * Number of cities cleared and whether done with the game or not.
 * @author Kai and Blue
 */
public class WarriorsOfLight {
	
	public ArrayList<Character> teamHeroes = new ArrayList<Character>();
	public ArrayList<String> teamBuffs = new ArrayList<String>();
	public ArrayList<String> teamMaps = new ArrayList<String>();
	public ArrayList<String> teamItems = new ArrayList<String>();
	public ArrayList<String> takenNames = new ArrayList<String>();
	
	Scanner scanner = new Scanner(System.in);
	public String heroName, teamName, option, numCities;
	public int count = 0, teamGold = 500, teamCount = 0, opt = 0, numCityCount = 0, mapCount = 0;
	public int itemCount = 0, buffCount = 0;
	public int citiesCleared = 0, clearGame = 0;
	public Boolean isCorrect = false, check = false;
	
	//add-ons for GUI part of team attributes
	public ArrayList<String> itemBag = new ArrayList<String>(), 
							 powerBag = new ArrayList<String>(),
							 teamSprites = new ArrayList<String>(); 
	public int totalCities = 0, doneCities = 0, heroesLeft = 0, originalTeam = 0, cityVersion = 1;
	//end of add-ons	
	
	/**
	 * prints out team attributes,
	 * str1 is list of hero names,
	 * str2 is item list,
	 * str3 is buff list,
	 * str4 is map list
	 * @return str - for team info
	 */
	public String toString() {
		
		String str = String.format("|Team Name: %s|Team Size: %d|Team Gold: %d|", teamName, teamCount, teamGold);
		String str1 = "Team currently has: ";
		String str2 = "\n|Team items:\n";
		String str3 = "\n|Team power-ups:\n";
		String str4 = "\n|Team maps:\n";
		
		count = 0;
		for (Character hero: teamHeroes) {
			str1 += hero.charName;
			count++;
			if (count < teamCount) {
				str1 += ", ";
			} else if (count == teamCount) {
				str1 += "|";
			}
		}
		str += str1;

		count = 0;
		for (String items: teamItems) {
			str2 += String.format("%d) ", count + 1);
			str2 += items;
			str2 += "\n";
			count++;
		}
		if (str2.length() == 14) {
			str2 += " None|";
		}
		str += str2;
		
		count = 0;
		for (String buffs: teamBuffs) {
			str3 += String.format("%d) ", count + 1);
			str3 += buffs;
			str3 += "\n";
			count++;
		}
		if (str3.length() == 18) {
			str3 += " None|";
		}
		str += str3;
		
		count = 0;
		for (String maps: teamMaps) {
			str4 += String.format("%d) ", count + 1);
			str4 += maps;
			str4 += "\n";
			count++;
		}
		if (str4.length() == 13) {
			str4 += " None|";
		}
		str += str4;
		return str;
	}
	
	/**
	 * Initializes team of heroes and
	 * uses Character class to create heroes and allows user to set the desired 
	 * type and name of hero.
	 * Allows user to set name of team and choose number of cities to explore
	 */
	public void setTeamInfo() {
		System.out.println("Morgan Freeman (aka Narrator): Please choose a name for your mighty team: (NO Spaces. And 2-10 characters long only)");
		teamName = scanner.next();
		while (teamName.length() < 2 || teamName.length() > 10) {
			System.out.println("Morgan Freeman (aka Narrator): Come on mate...2-10 characters long...");
			teamName = scanner.next();
		}
		System.out.println(String.format("Morgan Freeman (aka Narrator): The formidable %s! Now, Select the number of cities to explore: (3-6 cities only)", teamName));
		numCities = scanner.next();
		while (check == false) {
			try {
				opt = Integer.parseInt(numCities);
				if (opt < 3 || opt > 6) {
					System.out.println("Morgan Freeman (aka Narrator): Come on mate...3-6 cities only...");
					numCities = scanner.next();
					continue;
				}
			} catch (NumberFormatException nFE) {
				System.out.println("Morgan Freeman (aka Narrator): Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
				numCities = scanner.next();
				continue;
			}
			check = true;
			
		}
		numCityCount = opt;
		System.out.println(String.format("Morgan Freeman (aka Narrator): %d cities chosen! Now, who would you want to recruit? (NO spaces)", numCityCount));
		while (teamCount < 4) {
			check = false;
			addHeroes();
			teamCount++;
			System.out.println("Morgan Freeman (aka Narrator): Do you want to add more members? (0 for No, 1 for Yes): ");
			option = scanner.next();
			while (check == false) {
				try {
					opt = Integer.parseInt(option);
					if (opt > 1 || opt < 0) {
						System.out.println("Morgan Freeman (aka Narrator): Only choose between 0 and 1...");
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
			if (opt == 0) {
				System.out.println("Morgan Freeman (aka Narrator): All set mighty warriors! Let me show you to your first rebel base so that you can prepare for WAR!");
				break;
			} else {
				if (teamCount >= 3) {
					System.out.println("Morgan Freeman (aka Narrator): Party is full...Let me show you to your first rebel base so that you can prepare for WAR!");
					break;
				} else {
					System.out.println("Morgan Freeman (aka Narrator): Who else do you want to recruit?");
					continue;
				}
			}
		}
	}
	
	/**
	 * View character attributes (mainly for CLI part)
	 * @return str - of character attribute
	 */
	public String viewAttributes() {
		Character clone1 = new Character(Character.Type.BERSERKER);
		Character clone2 = new Character(Character.Type.STURDY);
		Character clone3 = new Character(Character.Type.PICKUP);
		Character clone4 = new Character(Character.Type.REGEN);
		Character clone5 = new Character(Character.Type.NAVIGATOR);
		Character clone6 = new Character(Character.Type.LUCKY);
		String str = String.format("1) %s\n2) %s\n3) %s\n4) %s\n5) %s\n6) %s", 
							      clone1.getHeroInfo(), clone2.getHeroInfo(), 
								  clone3.getHeroInfo(), clone4.getHeroInfo(), 
							      clone5.getHeroInfo(), clone6.getHeroInfo());
		return str;
	}
	
	/**
	 * Adds heros to team 
	 * and checks for duplicate names
	 */
	public void addHeroes() {
		heroName = scanner.next();
		while (takenNames.contains(heroName)) {
			System.out.println("Morgan Freeman (aka Narrator): Sorry, this name has been taken. Please use another name...");
			heroName = scanner.next();
		}
		takenNames.add(heroName);
		System.out.println(String.format("Morgan Freeman (aka Narrator): To finish recruiting young padawan %s, Select a special skill for this hero by choosing the number!", heroName));
		System.out.println(viewAttributes());
		option = scanner.next();
		isCorrect = false;
		while (isCorrect == false) {
			try {
				opt = Integer.parseInt(option);
				if (opt > 6 || opt < 1) {
					System.out.println("Morgan Freeman (aka Narrator): Only choose from 1 to 6...");
					option = scanner.next();
					continue;
				}
			} catch (NumberFormatException nFE) {
				System.out.println("Morgan Freeman (aka Narrator): Please select a number! Gosh...such beginner mistakes should not be made while the world is in danger!");
				option = scanner.next();
				continue;
			}
			isCorrect = true;
		}
		Character.Type heroType = Character.Type.NONE;
		if (opt == 1) {
			heroType = Character.Type.BERSERKER;
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s has the Berserker skill.", heroName));
		} else if (opt == 2) {
			heroType = Character.Type.STURDY;
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s has the Sturdy skill.", heroName));
		} else if (opt == 4) {
			heroType = Character.Type.REGEN;
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s has the Sturdy skill.", heroName));
		} else if (opt == 5) {
			heroType = Character.Type.NAVIGATOR;
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s has the Navigator skill.", heroName));
		} else if (opt == 6) {
			heroType = Character.Type.LUCKY;
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s has the Lucky skill.", heroName));
		} else if (opt == 3) {
			heroType = Character.Type.PICKUP;
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s has the Pickup skill.", heroName));
		}
		Character hero = new Character(heroName, heroType);
		teamHeroes.add(hero);
		System.out.println("Morgan Freeman (aka Narrator): Let's welcome our newest recruit!");
		System.out.println(hero);
		System.out.println(hero.getCharInfo());
		isCorrect = false;
	}
	
	/**
	 * main function
	 * @param args - main
	 */
	public static void main(String[] args) {
		WarriorsOfLight myTeam = new WarriorsOfLight();
		myTeam.setTeamInfo();
		System.out.println(myTeam);
	}
}
