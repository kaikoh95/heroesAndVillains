package gui;

import cli.WarriorsOfLight;

/**
 * Initializes and starts the game - Have fun! And please bear with us for the movie references hahaha
 * @author Kai and Blue
 *
 */
public class StartGame {
	@SuppressWarnings("unused")
	public static void main(String[] args){
		WarriorsOfLight myTeam = new WarriorsOfLight(); //create new empty Team
		TitleGUI newGame = new TitleGUI(myTeam);
    }

}
