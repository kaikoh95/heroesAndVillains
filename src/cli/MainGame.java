package cli;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for Main Game -
 * Runs each chapter accordingly to number of cities set
 * like a story book.
 * Allows user to set team name, name and type of heroes, cities to explore
 * before jumping into the first city where the adventure begins!
 * @author Kai and Blue
 *
 */
public class MainGame {
	
	public ArrayList<Character> teamVillains = new ArrayList<Character>();
	public WarriorsOfLight myTeam = new WarriorsOfLight();
	public int cityCount = 0;
	public Boolean restart = false;
	
	/*
	 * create villains using Character constructors
	 */
	public Character sonaht = new Character("Sonaht", Character.Type.RAIDBOSS);
	public Character slark = new Character("Tony Slark", Character.Type.ONETRICK);
	public Character fallen = new Character("Fallen Angel Risen Devil", Character.Type.DISPEL);
	public Character oldie = new Character("The Grooter Tree", 1, 1, 3, 1, Character.Type.STURDY);
	public Character bowser = new Character("Charging Bowser", 1, 1, 3, 1, Character.Type.BERSERKER);
	public Character goblin = new Character("Typical Goblin", 1, 1, 3, 1,Character.Type.NONE);
	
	/**
	 * Introduction -
	 * story-telling
	 */
	public void chapter1_intro() {
		System.out.println("---Chapter 1: Dusk of a new Ending---");
		System.out.println();
		System.out.println("Morgan Freeman (aka Narrator): Not so long ago, in a Galaxy not so far away...");
		System.out.println("Morgan Freeman (aka Narrator): Planet O.A.S.Y.S faces an invasion by Sanoht and his great-grand children...");
		System.out.println("BOOM BOOM POW");
		System.out.println("Sonaht: Skrt skrrrt! Everybody put'cha hands up! I am Lord Sonaht, King of Ass-guard!");
		System.out.println("Sonaht: And I have come here for your salvation for you mere mortals only know");
		System.out.println("Sonaht: how to code all day err day, and do not know how to live a FUN life!");
		System.out.println("Sonaht: *deadpool voice while jumping off the chopper* Now, cue the music!");
		System.out.println();
	}
	
	/**
	 * Sets up team.
	 * More story-telling,
	 * creates team of heroes by calling setTeamInfo from WarriorsOfLight
	 */
	public void chapter2_teamSetup() {
		System.out.println("---Chapter 2: Ready Player Two---");
		System.out.println();
		System.out.println("Morgan Freeman (aka Narrator): We must hurry! Sonaht's forces have already begun their invasion!");
		
		/*
		 * create team of heroes
		 */
		myTeam.setTeamInfo();
		System.out.println();
		cityCount = myTeam.numCityCount;
	}
	
	/**
	 * Starts the game by telling more stories
	 */
	public void chapter3_gameStart() {
		System.out.println("---Chapter 3: Let's save the world---");
		System.out.println();
		System.out.println("Morgan Freeman (aka Narrator): Come inside! Stop sending snaps of the apocalypse geez!");
		System.out.println("Morgan Freeman (aka Narrator): I'll quickly explain the game to you...");
		System.out.println(String.format("Morgan Freeman (aka Narrator): You have chosen to clear %d cities.", cityCount));
		System.out.println("Morgan Freeman (aka Narrator): In each city, our Supreme Recce team has already found a hideout to make preparations for the battle.");
		System.out.println("Morgan Freeman (aka Narrator): There is a Convenience Store (Okay, an Item Shop) where you can buy various items to aid in your conquest.");
		System.out.println("Morgan Freeman (aka Narrator): The Power-Up den is where you must go to in order to use a power-up.");
		System.out.println("Morgan Freeman (aka Narrator): Only a Hospital allows you to use healing items.");
		System.out.println("Morgan Freeman (aka Narrator): But most importantly, see that peak over there? THERE!");
		System.out.println("Morgan Freeman (aka Narrator): A villain guards the crystal shard at the summit.");
		System.out.println("Morgan Freeman (aka Narrator): Kill it and take the shard. This lets you clear the city and move on to the next.");
		System.out.println("Morgan Freeman (aka Narrator): See how the city is in the shape of a cross? *sings HALLELUJAH*");
		System.out.println("Morgan Freeman (aka Narrator): But yea, each city is a crossed-shaped with your base right smack in the middle(design-requirements lol)");
		System.out.println("Morgan Freeman (aka Narrator): You can only move from place to place passing through your home base then selecting another destination.");
		System.out.println();
		System.out.println("Morgan Freeman (aka Narrator): Alright, time's a wastin', off you go!");
		System.out.println();
	}
	
	/**
	 * First city - 
	 * calls CityMap class for map traversal and sequence of events
	 */
	@SuppressWarnings("unused")
	public void chapter4_city1() {
		myTeam.teamMaps = new ArrayList<String>();
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
		System.out.println("---Chapter 4: Beginner's Woes---");
		System.out.println();
		CityMap city = new CityMap(1);
		Misc misc = new Misc();
		while (fallen.charCurrentHealth > 0 && !myTeam.teamHeroes.isEmpty()) {
			if (city.currentLoc == city.baseLoc) {
				city.base(myTeam);
			} else if (city.currentLoc == city.shopLoc) {
				city.shop(myTeam, misc);
			} else if (city.currentLoc == city.denLoc) {
				city.den(myTeam);
			} else if (city.currentLoc == city.hosLoc) {
				city.hospital(myTeam);
			} else if (city.currentLoc == city.lairLoc) {
				city.lair(fallen, myTeam);
			}
		}
		
		//reward for beating the villain
		System.out.println("Morgan Freeman (aka Narrator): Good job! Here's your reward! Let's move on now!");
		System.out.println("(received Small Salve x 2)");
		myTeam.itemCount += 2;
		myTeam.teamItems.add("Name: Small Salve|Time taken to heal: 10 seconds|");
		myTeam.teamItems.add("Name: Small Salve|Time taken to heal: 10 seconds|");
	}
	
	/**
	 * Second city - 
	 * calls CityMap class for map traversal and sequence of events
	 */
	@SuppressWarnings("unused")
	public void chapter5_city2() {
		myTeam.teamMaps = new ArrayList<String>();
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
		System.out.println("---Chapter 5: Jaguar Town---");
		System.out.println();
		CityMap city = new CityMap(2);
		Misc misc = new Misc();
		while (bowser.charCurrentHealth > 0 && !myTeam.teamHeroes.isEmpty()) {
			if (city.currentLoc == city.baseLoc) {
				city.base(myTeam);
			} else if (city.currentLoc == city.shopLoc) {
				city.shop(myTeam, misc);
			} else if (city.currentLoc == city.denLoc) {
				city.den(myTeam);
			} else if (city.currentLoc == city.hosLoc) {
				city.hospital(myTeam);
			} else if (city.currentLoc == city.lairLoc) {
				city.lair(bowser, myTeam);
			}
		}
		
		//reward
		System.out.println("Morgan Freeman (aka Narrator): Good job! Here's your reward! Let's move on now!");
		System.out.println("(received 1000 gold)");
		myTeam.teamGold += 1000;
	}
	
	/**
	 * Third city (skipped if cities set = 3 and goes straight to final city) - 
	 * calls CityMap class for map traversal and sequence of events
	 */
	@SuppressWarnings("unused")
	public void chapter6_city3() {
		myTeam.teamMaps = new ArrayList<String>();
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
		System.out.println("---Chapter 6: Ol' MapleStory---");
		System.out.println();
		CityMap city = new CityMap(3);
		Misc misc = new Misc();
		while (oldie.charCurrentHealth > 0 && !myTeam.teamHeroes.isEmpty()) {
			if (city.currentLoc == city.baseLoc) {
				city.base(myTeam);
			} else if (city.currentLoc == city.shopLoc) {
				city.shop(myTeam, misc);
			} else if (city.currentLoc == city.denLoc) {
				city.den(myTeam);
			} else if (city.currentLoc == city.hosLoc) {
				city.hospital(myTeam);
			} else if (city.currentLoc == city.lairLoc) {
				city.lair(oldie, myTeam);
			}
		}
		
		//reward
		System.out.println("Morgan Freeman (aka Narrator): Good job! Here's your reward! Let's move on now!");
		System.out.println("(received Iron Maiden Potent x 1)");
		myTeam.buffCount++;
		myTeam.teamBuffs.add("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
	}
	
	
	/**
	 * Fourth city (skipped if cities set = 4 and goes right to final city) - 
	 * calls CityMap class for map traversal and sequence of events
	 */
	@SuppressWarnings("unused")
	public void chapter7_city4() {
		myTeam.teamMaps = new ArrayList<String>();
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
		System.out.println("---Chapter 7: Batman's city needs saving too?---");
		System.out.println();
		CityMap city = new CityMap(4);
		Misc misc = new Misc();
		while (goblin.charCurrentHealth > 0 && !myTeam.teamHeroes.isEmpty()) {
			if (city.currentLoc == city.baseLoc) {
				city.base(myTeam);
			} else if (city.currentLoc == city.shopLoc) {
				city.shop(myTeam, misc);
			} else if (city.currentLoc == city.denLoc) {
				city.den(myTeam);
			} else if (city.currentLoc == city.hosLoc) {
				city.hospital(myTeam);
			} else if (city.currentLoc == city.lairLoc) {
				city.lair(goblin, myTeam);
			}
		}
		
		//reward
		System.out.println("Morgan Freeman (aka Narrator): Good job! Here's your reward! Let's move on now!");
		System.out.println("(received 500 gold, Mighty Morphine x 1, Youaremydestiny x 1)");
		myTeam.itemCount++;
		myTeam.buffCount++;
		myTeam.teamItems.add("Name: Mighty Morphine|Time taken to heal: 5 seconds|");
		myTeam.teamBuffs.add("Name: Youaremydestiny|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
		myTeam.teamGold += 500;
		
	}
	
	/**
	 * Fifth city (skipped if cities set = 5, goes right to final city) -
	 * calls CityMap class for map traversal and sequence of events
	 */
	@SuppressWarnings("unused")
	public void chapter8_city5() {
		myTeam.teamMaps = new ArrayList<String>();
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
		System.out.println("---Chapter 8: For ALL League of Legends feeders---");
		System.out.println();
		CityMap city = new CityMap(5);
		Misc misc = new Misc();
		while (slark.charCurrentHealth > 0 && !myTeam.teamHeroes.isEmpty()) {
			if (city.currentLoc == city.baseLoc) {
				city.base(myTeam);
			} else if (city.currentLoc == city.shopLoc) {
				city.shop(myTeam, misc);
			} else if (city.currentLoc == city.denLoc) {
				city.den(myTeam);
			} else if (city.currentLoc == city.hosLoc) {
				city.hospital(myTeam);
			} else if (city.currentLoc == city.lairLoc) {
				city.lair(slark, myTeam);
			}
		}
		System.out.println("Morgan Freeman (aka Narrator): Good job! Here's your reward! Let's move on now!");
		System.out.println("(received 1000 gold, Fountain of Life x 1, 50-50 Lemon Squeezy x 1)");
		myTeam.teamItems.add("Name: Name: Fountain of Life|Time taken to heal: 3 seconds|");
		myTeam.teamBuffs.add("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
		myTeam.teamGold += 1000;
		myTeam.itemCount++;
		myTeam.buffCount++;
		
	}
	
	/**
	 * Final city where 'super Thanos' awaits - 
	 * calls CityMap class for map traversal and sequence of events
	 */
	@SuppressWarnings("unused")
	public void chapter9_city6() {
		myTeam.teamMaps = new ArrayList<String>();
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
		System.out.println("---Final Chapter: The Last Stand---");
		System.out.println();
		CityMap city = new CityMap(6);
		Misc misc = new Misc();
		while (sonaht.charCurrentHealth > 0 && !myTeam.teamHeroes.isEmpty()) {
			if (city.currentLoc == city.baseLoc) {
				city.base(myTeam);
			} else if (city.currentLoc == city.shopLoc) {
				city.shop(myTeam, misc);
			} else if (city.currentLoc == city.denLoc) {
				city.den(myTeam);
			} else if (city.currentLoc == city.hosLoc) {
				city.hospital(myTeam);
			} else if (city.currentLoc == city.lairLoc) {
				city.lair(sonaht, myTeam);
			}
		}
	}
	
	/**
	 * End game scene with more yakking
	 * if the player has won the game
	 */
	public void chapter10_endCredits() {
		System.out.println("---End Game: Thanos-sonahT and the Avengers (half) will return---");
		System.out.println();
		System.out.println("Morgan Freeman (aka Narrator): Congratulations! You've successfully fought of Sonaht and his forces!");
		System.out.println("Morgan Freeman (aka Narrator): The O.A.S.Y.S thanks you for your greatness!");
		System.out.println("Morgan Freeman (aka Narrator): And I can finally go back to making great voiceovers again...");
		System.out.println("Morgan Freeman (aka Narrator): Until next time, ciao!");
		System.out.println("---THE END---");
		System.out.println("---THANK YOU FOR PLAYING THE GAME---");
	}
	
	/**
	 * Game over if everyone died BOOM -
	 * Didn't reach end game? Hall of Shame for you
	 */
	public void chapter11_gameOver() {
		Scanner scanner = new Scanner(System.in);
		String option;
		Boolean check = false;
		int opt = 0;
		System.out.println("---Lost Chapter: Game over---");
		System.out.println();
		System.out.println("Morgan Freeman (aka Narrator): Oh no...your foolishness allowed Sonaht to destroy the entire universe!");
		System.out.println("Morgan Freeman (aka Narrator): Luckily! The Time Stone is with me! Dormamu, I've come to bargain!");
		System.out.println("Morgan Freeman (aka Narrator): Restart? I'll pretend we've never met to save you from the blushes...0 - No, 1 - Yes");
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
				System.out.println("Morgan Freeman (aka Narrator): For Morgan's Sake! Please choose a number...");
				option = scanner.next();
				continue;
			}
			check = true;
		}
		scanner.close();
		if (opt == 0) {
			System.out.println("Morgan Freeman (aka Narrator) (low-key Super Villain): Goodbye fools! MUAHAHAHA the world is MINE!");
			System.out.println("---GAME OVER---");
			System.out.println("---THANK YOU FOR PLAYING---");
			restart = false;
		} else {
			System.out.println("Morgan Freeman (aka Narrator): Game Restarting in. . .");
			long currentTime = System.currentTimeMillis();
			long elapsedTime = System.currentTimeMillis();
			long diffTime = elapsedTime - currentTime;
			int timer = 5;
			long check1 = diffTime % 1000;
			ArrayList<Long> times = new ArrayList<>();
			while (diffTime < 6 * 1000) {
				if (check1 == 0 && !times.contains(diffTime)) {
					times.add(diffTime);
					System.out.println(timer + ". . .");
					timer--;
				}
				elapsedTime = System.currentTimeMillis();
				diffTime = elapsedTime - currentTime;
				check1 = diffTime % 1000;
			}
			restart = true;
		}
	}
	
	/**
	 * main function
	 * @param args - main
	 */
	public static void main(String[] args) {
		long currentTime = System.currentTimeMillis(); //keep track of time spent on this game
		long elapsedTime = System.currentTimeMillis();
		long diffTime;
		MainGame mainGame = new MainGame();
		mainGame.chapter1_intro();
		mainGame.chapter2_teamSetup();
		mainGame.chapter3_gameStart();
		while (true) {
			if (mainGame.myTeam.teamHeroes.isEmpty()) {
				mainGame.chapter11_gameOver();
				if (mainGame.restart == true) {
					mainGame.chapter1_intro();
					mainGame.chapter2_teamSetup();
					mainGame.chapter3_gameStart();
					continue;
				} else {
					break;
				}
			}
			mainGame.chapter4_city1();
			mainGame.chapter5_city2();
			
			//if cities set is 3, 4 or 5 respectively
			if (mainGame.myTeam.numCityCount == 4) {
				mainGame.chapter6_city3();
			} else if (mainGame.myTeam.numCityCount == 5) {
				mainGame.chapter6_city3();
				mainGame.chapter7_city4();
			} else if (mainGame.myTeam.numCityCount == 6) {
				mainGame.chapter6_city3();
				mainGame.chapter7_city4();
				mainGame.chapter8_city5();
			}
			mainGame.chapter9_city6();
			if (mainGame.myTeam.clearGame == 1) {
				mainGame.chapter10_endCredits();
				diffTime = (elapsedTime - currentTime) / 1000;
				System.out.println(String.format("Stan Lee (just for the sake of appearing): The Almighty %s has taken %d seconds to complete the game!",
												mainGame.myTeam.teamName, diffTime));
				break;
			}
		}
	}
}
