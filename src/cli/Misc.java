package cli;
/**
 * For healing items, buffs, maps etc.
 * Contains list and prices of buff and is mainly
 * called in Shop function from CityMap 
 * @author Kai and
 *  Blue
 *
 */
public class Misc {

	/**
	 * gets buff choice from user
	 * @param choice - user option of buff
	 * @param myTeam - team of heroes
	 * @return price - price of buff selected
	 */
	public int buffs(int choice, WarriorsOfLight myTeam) {
		int price = 0;
		for (Character hero: myTeam.teamHeroes) {
			if (hero.charType == Character.Type.LUCKY) {
				if (choice == 1) {
					System.out.println("1) Name: 50-50 Lemon Squeezy|Price: 210 (was 300)|Attribute: 50% chance of winning the next round|");
					price = 210;
				} else if (choice == 2) {
					System.out.println("2) Name: Youaremydestiny|Price: 700 (was 1000)|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
					price = 700;
				} else if (choice == 3) {
					System.out.println("3) Name: Iron Maiden Potent|Price: 350 (was 500)|Attribute: Takes no damage when you lose the next round|");
					price = 350;
				}
				break;
			} else {
				if (choice == 1) {
					System.out.println("1) Name: 50-50 Lemon Squeezy|Price: 300|Attribute: 50% chance of winning the next round|");
					price = 300;
				} else if (choice == 2) {
					System.out.println("2) Name: Youaremydestiny|Price: 1000|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
					price = 1000;
				} else if (choice == 3) {
					System.out.println("3) Name: Iron Maiden Potent|Price: 500|Attribute: Takes no damage when you lose the next round|");
					price = 500;
				}
			}
		}
		return price;
	}
	
	/**
	 * gets item choice from user 
	 * @param choice - user choice of item
	 * @param myTeam - team of heroes
	 * @return price - of item selected
	 */
	public int heals(int choice, WarriorsOfLight myTeam) {
		int price = 0;
		for (Character hero: myTeam.teamHeroes) {
			if (hero.charType == Character.Type.LUCKY) {
				if (choice == 1) {
					System.out.println("4) Name: Small Salve|Price: 80 (was 100)|Time taken to heal: 10 seconds|");
					price = 80;
				} else if (choice == 2) {
					System.out.println("5) Name: Mighty Morphine|Price: 480 (was 600)|Time taken to heal: 5 seconds|");
					price = 480;
				} else if (choice == 3) {
					System.out.println("6) Name: Fountain of Life|Price: 960 (was 1200)|Time taken to heal: 3 seconds|");
					price = 960;
				}
				break;
			} else {
				if (choice == 1) {
					System.out.println("4) Name: Small Salve|Price: 100|Time taken to heal: 10 seconds|");
					price = 100;
				} else if (choice == 2) {
					System.out.println("5) Name: Mighty Morphine|Price: 600|Time taken to heal: 5 seconds|");
					price = 600;
				} else if (choice == 3) {
					System.out.println("6) Name: Fountain of Life|Price: 1200|Time taken to heal: 3 seconds|");
					price = 1200;
				}
			}
		}
		return price;
	}
	
	/**
	 * gets map choice from user
	 * @param choice - user choice
	 * @param myTeam - team of heroes
	 * @return price - of maps
	 */
	public int maps(int choice, WarriorsOfLight myTeam) {
		int price = 200;
		for (Character hero: myTeam.teamHeroes) {
			if (hero.charType == Character.Type.LUCKY) {
				if (choice == 1) {
					System.out.println("7) Name: West Map|Price: 160 (was 200)|");
				} else if (choice == 2) {
					System.out.println("8) Name: North Map|Price: 160 (was 200)|");
				} else if (choice == 3) {
					System.out.println("9) Name: East Map|Price: 160 (was 200)|");
				} else if (choice == 4) {
					System.out.println("10) Name: South Map|Price: 610 (was 200)|");
				}
				price = 160;
				break;
			} else {
				if (choice == 1) {
					System.out.println("7) Name: West Map|Price: 200|");
				} else if (choice == 2) {
					System.out.println("8) Name: North Map|Price: 200|");
				} else if (choice == 3) {
					System.out.println("9) Name: East Map|Price: 200|");
				} else if (choice == 4) {
					System.out.println("10) Name: South Map|Price: 200|");
				}
			}
		}
		return price;
	}
	
	/**
	 * main function
	 * @param args - main 
	 */
	public static void main(String[] args) {
		Misc misc = new Misc();
		WarriorsOfLight myTeam = new WarriorsOfLight();
		myTeam.setTeamInfo();
		misc.buffs(1, myTeam);
		misc.heals(3, myTeam);
		misc.buffs(3, myTeam);
		misc.buffs(2, myTeam);
	}
}
