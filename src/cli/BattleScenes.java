package cli;
import java.util.Random;
import java.util.Scanner;

/**
 * class for all 3 battle games
 * rock paper scissors, dice roll, high-low.
 * If at any stage you lose all characters, the Hall of Shame welcomes you (means game over).
 * If you win 3 times (different or same game), you defeat the villain and move to next city
 * @author Kai and Blue
 */
public class BattleScenes {

	public int villainOption, opt, playerOption;
	Random randomNum = new Random();
	Scanner scanner = new Scanner(System.in);
	public String option;
	public Boolean check = false, defeated = false;
	public int i = 0;
	
	/**
	 * rock paper scissors
	 * checks for buffs and character types
	 * @param player - challenger of this game
	 * @param villain - villain for this city
	 * @param myTeam - team of heroes where the challenger came from
	 */
	public void rockPaperScissors(Character player, Character villain, WarriorsOfLight myTeam) {
		
		System.out.println(String.format("%s: For this game, you are required to choose a number from 0 to 2 inclusive. 0 - Scissors, 1 - Paper, 2 - Stone", villain.charName));
		System.out.println(String.format("%s: Scissors beats Paper, Paper beats Rock and Rock beats Scissors.", villain.charName));
		System.out.println(String.format("%s: What's your choice?", villain.charName));
		villainOption = Math.abs(randomNum.nextInt()) % 3;
		//check for buffs and char types
		if (player.charPower == 1 && villain.charType != Character.Type.DISPEL) {
			villainOption = Math.abs(randomNum.nextInt()) % 2;
			System.out.println("Morgan Freeman (aka Narrator): Lucky buff activated! Villain will only choose Scissors or Paper! Now's your chance!");
			player.charPower = 0;
			player.checkBuff();
		}
		if (player.charPower == 2 && (villain.charType != Character.Type.DISPEL || villain.charType != Character.Type.RAIDBOSS)) {
			System.out.println("Morgan Freeman (aka Narrator): With the Truthseeker's power, you have foreseen the future!");
			if (villainOption == 0) {
				System.out.println(String.format("Morgan Freeman (aka Narrator): %s will choose Scissors!", villain.charName));
			} else if (villainOption == 1) {
				System.out.println(String.format("Morgan Freeman (aka Narrator): %s will choose Paper!", villain.charName));
			} else {
				System.out.println(String.format("Morgan Freeman (aka Narrator): %s will choose Rock!", villain.charName));
			}
			player.charPower = 0;
			player.checkBuff();
		}
		option = scanner.next();
		check = false;
		while (check == false) {
			try {
				opt = Integer.parseInt(option);
				if (opt > 2 || opt < 0) {
					System.out.println("Morgan Freeman (aka Narrator): Only choose between 0 to 2...");
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
			System.out.println(String.format("Morgan Freeman (aka Narrator): You (%s) chose Scissors!", player.charName));
		} else if (opt == 1) {
			System.out.println(String.format("Morgan Freeman (aka Narrator): You (%s) chose Paper!", player.charName));
		} else if (opt == 2) {
			System.out.println(String.format("Morgan Freeman (aka Narrator): You (%s) chose Rock!", player.charName));
		} 
		if (villainOption == 0) {
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s chooses Scissors!", villain.charName));
		} else if (villainOption == 1) {
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s chooses Paper!", villain.charName));
		} else {
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s chooses Rock!", villain.charName));
		}
		if (opt == villainOption) {
			System.out.println("Morgan Freeman (aka Narrator): It's a tie this round. Booooring...");
			villain.checkHealth();
			player.checkHealth();
		} else if ((opt == 0 && villainOption == 1) || (opt == 1 && villainOption == 2) || (opt == 2 && villainOption == 0)) {
			System.out.println("Morgan Freeman (aka Narrator): You've won this round!");
			player.dealDamage(villain);
			if (player.charType == Character.Type.REGEN) {
				player.charCurrentHealth += 1;
			}
			player.checkHealth();
			villain.deadAlive();
			villain.defeatCount++;
		} else if ((opt == 0 && villainOption == 2) || (opt == 1 && villainOption == 0) || (opt == 2 && villainOption == 1)) {
			int index1 = 0;
			System.out.println("Morgan Freeman (aka Narrator): You've lost this round...");
			villain.dealDamage(player);
			villain.checkHealth();
			Boolean bool = player.deadAlive();
			if (bool == true) {
				while (i < myTeam.teamCount) {
					if (myTeam.teamHeroes.get(i).charName == player.charName) {
						index1 = i;
						break;
					}
					i++;
				}
				myTeam.teamHeroes.remove(index1);
			}
		}
	}
	
	/**
	 * dice roll game
	 * @param player - challenger for this game
	 * @param villain - villain for this city
	 * @param myTeam - team of heroes where challenger came from
	 */
	public void rollDice(Character player, Character villain, WarriorsOfLight myTeam) {
		System.out.println(String.format("%s: This is a game of luck! Dice rolls let's go!", villain.charName));
		playerOption = Math.abs(randomNum.nextInt()) % 6;
		villainOption = Math.abs(randomNum.nextInt()) % 6;
		//buff and character type check
		if (player.charPower == 1 && villain.charType != Character.Type.DISPEL) {
			villainOption = Math.abs(randomNum.nextInt()) % 3;
			System.out.println("Morgan Freeman (aka Narrator): Lucky buff activated! Villain can only roll up to 3! Here's your chance!");
			player.charPower = 0;
			player.checkBuff();
		}
		System.out.println(String.format("Morgan Freeman (aka Narrator): You (%s) rolled %d! %s rolled %d!", 
										player.charName, playerOption + 1,
										villain.charName, villainOption + 1));
		if (playerOption == villainOption) {
			System.out.println("Morgan Freeman (aka Narrator): It's a tie this round. Booooring...");
			villain.checkHealth();
			player.checkHealth();
		} else if (playerOption > villainOption) {
			System.out.println("Morgan Freeman (aka Narrator): You've won this round!");
			player.dealDamage(villain);
			if (player.charType == Character.Type.REGEN) {
				player.charCurrentHealth += 1;
			}
			player.checkHealth();
			villain.deadAlive();
			villain.defeatCount++;
		} else {
			int index1 = 0;
			System.out.println("Morgan Freeman (aka Narrator): You've lost this round...");
			villain.dealDamage(player);
			villain.checkHealth();
			Boolean bool = player.deadAlive();
			if (bool == true) {
				while (i < myTeam.teamCount) {
					if (myTeam.teamHeroes.get(i).charName == player.charName) {
						index1 = i;
						break;
					}
					i++;
				}
				myTeam.teamHeroes.remove(index1);
			}
		}
	}
	
	/**
	 * @param player - challenger for this game
	 * @param villain - villain for this city
	 * @param myTeam - team of heroes where challenger came from
	 */
	public void highLow(Character player, Character villain, WarriorsOfLight myTeam) {
		int tries = 2;
		System.out.println(String.format("This is a binary game. Are you up for the gamble? Choose a number between 1 and 10!", villain.charName));
		villainOption = Math.abs(randomNum.nextInt()) % 10 + 1;
		if (player.charPower == 1 && villain.charType != Character.Type.DISPEL) {
			villainOption = Math.abs(randomNum.nextInt()) % 5 + 1;
			System.out.println("Morgan Freeman (aka Narrator): Lucky buff activated! Villain can only choose from 1-5! Now's your chance!");
			player.charPower = 0;
			player.checkBuff();
		}
		if (player.charPower == 2 && (villain.charType != Character.Type.DISPEL || villain.charType != Character.Type.RAIDBOSS)) {
			System.out.println("Morgan Freeman (aka Narrator): With the Truthseeker's power, you have foreseen the future!");
			System.out.println(String.format("Morgan Freeman (aka Narrator): %s will choose %d!", villainOption, villainOption));
			player.charPower = 0;
			player.checkBuff();
		}
		while (tries > 0 && myTeam.teamHeroes.contains(player) && villain.defeatCount < 3) {
			option = scanner.next();
			check = false;
			while (check == false) {
				try {
					playerOption = Integer.parseInt(option);
					if (playerOption > 10 || playerOption < 1) {
						System.out.println("Morgan Freeman (aka Narrator): Only choose between 1 and 10...");
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
			if (playerOption != villainOption) {
				tries--;
				System.out.println(String.format("%s: HAH! Wrong! (%d tries left.)", villain.charName, tries));
				if (playerOption > villainOption) {
					System.out.println(String.format("%s: Lower, lol...", villain.charName));
				} else {
					System.out.println(String.format("%s: Try higher...hehehe", villain.charName));
				}
			} else {
				System.out.println(String.format("%s: Well-played son. Well-played *claps*", villain.charName));
				break;
			}
		}
		if (tries == 0) {
			System.out.println("Morgan Freeman (aka Narrator): You've lost this round...");
			villain.dealDamage(player);
			villain.checkHealth();
			Boolean bool = player.deadAlive();
			if (bool == true) {
				myTeam.teamHeroes.remove(player);
			}
		} else {
			System.out.println("Morgan Freeman (aka Narrator): You've won this round!");
			player.dealDamage(villain);
			if (player.charType == Character.Type.REGEN) {
				player.charCurrentHealth += 1;
			}
			player.checkHealth();
			villain.deadAlive();
			villain.defeatCount++;
		}
	}
	
	/**
	 * main function	
	 * @param args - main
	 */
	public static void main(String[] args) {
		BattleScenes battles = new BattleScenes();
		WarriorsOfLight myTeam = new WarriorsOfLight();
		myTeam.setTeamInfo();
		Character player = myTeam.teamHeroes.get(0);
		Character villain = new Character("Thanos", 1, 1, 3, 1, Character.Type.RAIDBOSS);
		battles.rockPaperScissors(player, villain, myTeam);
		battles.rollDice(player, villain, myTeam);
		battles.highLow(player, villain, myTeam);
	}
	
}
