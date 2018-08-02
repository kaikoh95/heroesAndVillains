package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cli.Character;
import cli.WarriorsOfLight;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class for Villain Lair + battle games GUI
 * for rock paper scissors, dice roll, high-lo game environments.
 * If won villain 3 times, user gets to move to next city, or 
 * win the game if the villain is the Super Villain.
 * If all heroes have been killed, sends user home crying by
 * raising the Game Over screen
 * @author Kai and Blue
 *
 */
public class BattleGrounds {
	
	
	private Character villain; //create villains
	
	Random randomNum = new Random();
	private String villainTaunt = "";
	@SuppressWarnings("unused")
	private int villainOption = Math.abs(randomNum.nextInt()) % 3, selectedIndex = 0,
				rockOption = Math.abs(randomNum.nextInt()) % 3, diceOption = Math.abs(randomNum.nextInt()) % 6,
				highOption = Math.abs(randomNum.nextInt()) % 10,
				rockPlayer = 3, dicePlayer = Math.abs(randomNum.nextInt()) % 6;
	private int rockWin = 0, highCount = 2;
	private Character player = new Character(); //placeholder for team heroes
	
	private JFrame frmOasysReady;
	private JTextPane VillainTaunt1 = new JTextPane(), VillainBorder2 = new JTextPane();
	public JPanel panelVillain = new JPanel(), 
				  panelBattle = new JPanel(), panelRock = new JPanel(),
				  panelDice = new JPanel(), panelHigh = new JPanel();
	private JLabel BattleBackground1 = new JLabel(), BattleBackground2 = new JLabel(), 
				   BattleBackground3 = new JLabel();
	private JButton VillainBackground = new JButton(), BattleBackground = new JButton(), BattleFightButton = new JButton("Fight!");
	private JTextField BattleChooseHero = new JTextField();
	
	@SuppressWarnings("rawtypes")
	private JComboBox BattleHeroSel = new JComboBox(), HighPlayerOption = new JComboBox();
	
	private final JLabel RockVillainIcon = new JLabel(""), DiceVillainIcon = new JLabel(""), 
					     HighVillainIcon = new JLabel(""), VillainPic = new JLabel("");
	private JTextField RockVillainHealth = new JTextField(), DiceVillainHealth = new JTextField(),
					   HighVillainHealth = new JTextField();
	private final JLabel RockVillainChoice = new JLabel();
	private final JTextField RockResults = new JTextField(), DiceResults = new JTextField(), HighResults = new JTextField();
	private final JButton RockPaperButton = new JButton(""), RockRockButton = new JButton(""), 
						  RockScissorsButton = new JButton(""), RockPlayButton = new JButton("Go!");
	private final JTextField RockPlayerHealth = new JTextField();
	private final JLabel RockPlayerPic = new JLabel("");
	private final JButton RockNextBattleButton = new JButton("Next Battle!"), DiceNextBattleButton = new JButton("Next Battle!");
	private final JTextField RockBuff = new JTextField();
	private final JButton RockNextCity = new JButton("Next City"), DiceNextCity = new JButton("Next City"), HighNextCity = new JButton("Next City");
	
	private final JLabel DicePlayerOption = new JLabel(""), DiceVillainChoice = new JLabel("");
	private final JTextField DicePlayerHealth = new JTextField(), HighPlayerHealth = new JTextField(),
							 DiceBuff = new JTextField(), HighBuff = new JTextField(), HighVillainChoice = new JTextField("");
	private final JLabel DicePlayerPic = new JLabel(""), HighPlayerPic = new JLabel("");
	
	private final JButton DiceRoll1 = new JButton("Let's Roll!"), GameEndButton = new JButton("");
	
	private final JTextField GameTitleLabel = new JTextField("Click anywhere to go to title screen!");
	private final JButton HighPlayButton2 = new JButton("Guess away!"), HighNextBattleButton = new JButton("Next Battle!");
	private JTextField GameEndTitle;
	
	
	/**
	 * Launch the application.
	 * @param args - main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					BattleGrounds window = new BattleGrounds(myTeam);
					window.frmOasysReady.setVisible(true);
					window.panelVillain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param myTeam - team of heroes
	 */
	public BattleGrounds(WarriorsOfLight myTeam) {
		initialize(myTeam);
		frmOasysReady.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param myTeam - team of heroes
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private void initialize(WarriorsOfLight myTeam) {
		frmOasysReady = new JFrame();
		frmOasysReady.setFont(new Font("Courier", Font.PLAIN, 12));
		frmOasysReady.setTitle("O.A.S.Y.S - Ready Player Two");
		frmOasysReady.setBounds(100, 100, 600, 500);
		frmOasysReady.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOasysReady.getContentPane().setLayout(null);
		
		/*
		 * sets backgrounds, villain details, taunt phrase and image for each city
		 */
		if (myTeam.doneCities == (myTeam.totalCities - 1)) {
			VillainBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainLairBackground6.jpg")));
			VillainPic.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/villain6.jpg")));
			
			BattleBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/BossBackground.jpg")));
			BattleBackground1.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/BossBackground.jpg")));
			BattleBackground2.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/BossBackground.jpg")));
			BattleBackground3.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/BossBackground.jpg")));
			
			RockVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainRaidboss.jpg")));
			DiceVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainRaidboss.jpg")));
			HighVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainRaidboss.jpg")));
			villain = new Character("Sonaht", Character.Type.RAIDBOSS);
			villainTaunt = villain.toString();
		} else {
			if (myTeam.doneCities == 0) {
				VillainBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainLairBackground1.png")));
				VillainPic.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/villain5.png")));
				
				BattleBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground1.jpg")));
				BattleBackground1.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground1.jpg")));
				BattleBackground2.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground1.jpg")));
				BattleBackground3.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground1.jpg")));
				
				RockVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainSturdy.png")));
				DiceVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainSturdy.png")));
				HighVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainSturdy.png")));
				villain = new Character("The Grooter Tree", 1, 1, 3, 1, Character.Type.STURDY);
				villainTaunt = villain.toString();
			} else if (myTeam.doneCities == 1) {
				VillainBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainLairBackground2.jpg")));
				VillainPic.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/villain2.png")));
				
				BattleBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground2.jpg")));
				BattleBackground1.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground2.jpg")));
				BattleBackground2.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground2.jpg")));
				BattleBackground3.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground2.jpg")));
				
				RockVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainOnetrick.png")));
				DiceVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainOnetrick.png")));
				HighVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainOnetrick.png")));
				villain = new Character("Tony Slark", Character.Type.ONETRICK);
				villainTaunt = villain.toString();
			} else if (myTeam.doneCities == 2) {
				VillainBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainLairBackground3.jpg")));
				VillainPic.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/villain4.png")));
				
				BattleBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground3.png")));
				BattleBackground1.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground3.png")));
				BattleBackground2.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground3.png")));
				BattleBackground3.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground3.png")));
				
				RockVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainDispel.png")));
				DiceVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainDispel.png")));
				HighVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainDispel.png")));
				villain = new Character("Fallen Angel Risen Devil", Character.Type.DISPEL);
				villainTaunt = villain.toString();
			} else if (myTeam.doneCities == 3) {
				VillainBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainLairBackground4.png")));
				VillainPic.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/villain1.png")));
				
				BattleBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground4.jpg")));
				BattleBackground1.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground4.jpg")));
				BattleBackground2.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground4.jpg")));
				BattleBackground3.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground4.jpg")));
				
				RockVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainNone.png")));
				DiceVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainNone.png")));
				HighVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainNone.png")));
				villain = new Character("Typical Goblin", 1, 1, 3, 1,Character.Type.NONE);
				villainTaunt = villain.toString();
			} else if (myTeam.doneCities == 4) {
				VillainBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainLairBackground5.png")));
				VillainPic.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/villain3.png")));
				
				BattleBackground.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground5.jpg")));
				BattleBackground1.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground5.jpg")));
				BattleBackground2.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground5.jpg")));
				BattleBackground3.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBackground5.jpg")));
				
				RockVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBerserker.png")));
				DiceVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBerserker.png")));
				HighVillainIcon.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/VillainBerserker.png")));
				villain = new Character("Charging Bowser", 1, 1, 3, 1, Character.Type.BERSERKER);
				villainTaunt = villain.toString();
			}
		}
		
		//sets game to be played this round
		String villainChoice = "";
		villainOption = Math.abs(randomNum.nextInt()) % 3;
		if (villain.charType == Character.Type.ONETRICK) {
			villainOption = 2;
			villainChoice = String.format(" %s: This will be a game of High-Low..\n I'll pick a number and you guess.", villain.charName);
		}
		if (villainOption == 0) {
			villainChoice = String.format(" %s: Don't you just love a classic game\n of rock paper scissors??", villain.charName);
		} else if (villainOption == 1) {
			villainChoice = String.format(" %s: Life is like a dice roll.\n You'll never knoll (ok that was bad).", villain.charName);
		} else {
			villainChoice = String.format(" %s: This will be a game of High-Low..\n I'll pick a number and you guess.", villain.charName);
		}
		ArrayList<String> heroComboBox = new ArrayList<String>();
		BattleHeroSel.removeAllItems();
		for (Character hero: myTeam.teamHeroes) {
			if (!heroComboBox.contains(hero.charName)) {
				BattleHeroSel.addItem(hero.charName);
				heroComboBox.add(hero.charName);
			}
		}
		
		player = new Character(); // placeholder for player character
		
		for (Character hero: myTeam.teamHeroes) {
			if (BattleHeroSel.getSelectedIndex() == 0) {
				player = myTeam.teamHeroes.get(0);
				selectedIndex = 0;
				RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
				DicePlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
				HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
			} else if (BattleHeroSel.getSelectedIndex() == 1) {
				player = myTeam.teamHeroes.get(1);
				selectedIndex = 1;
				RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
				DicePlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
				HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
			} else if (BattleHeroSel.getSelectedIndex() == 2) {
				player = myTeam.teamHeroes.get(2);
				selectedIndex = 2;
				RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
				DicePlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
				HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
			}
		}
		
		String[] highPlayer = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}; //for high-lo game
		
		HighVillainHealth.setEditable(false);
		HighVillainHealth.setHorizontalAlignment(SwingConstants.CENTER);
		HighVillainHealth.setFont(new Font("Courier", Font.BOLD, 21));
		HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
		HighVillainHealth.setBounds(182, 79, 192, 36);
		HighVillainHealth.setColumns(10);
		panelHigh.add(HighVillainHealth);
		HighPlayerOption = new JComboBox(highPlayer);
		HighPlayerOption.setSelectedIndex(0);
		
		JButton HighPlayButton1 = new JButton("Guess away!");
		HighPlayButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HighPlayButton1.setVisible(false);
				highOption = Math.abs(randomNum.nextInt()) % 10;
				if (player.charPower == 1 && villain.charType != Character.Type.DISPEL) {
					highOption = Math.abs(randomNum.nextInt()) % 5;
					player.charPower = 0;
					player.checkBuff();
					myTeam.teamBuffs.remove("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
					myTeam.buffCount--;
				} else {
					highOption = Math.abs(randomNum.nextInt()) % 10;
				}
				HighVillainChoice.setText(String.format("Chose %d", highOption + 1));
				if (player.charPower == 2 && (villain.charType != Character.Type.DISPEL || villain.charType != Character.Type.RAIDBOSS)) {
					HighVillainChoice.setVisible(true);
					player.charPower = 0;
					player.checkBuff();
					myTeam.teamBuffs.remove("Name: Youaremydestiny|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
					myTeam.buffCount--;
				}
				HighPlayerOption.setVisible(true);
				if (HighPlayerOption.getSelectedIndex() == highOption) {
					//win
					if (player.charType == Character.Type.REGEN) {
						player.charCurrentHealth += 1;
						if (player.charCurrentHealth > player.charHealth) {
							player.charCurrentHealth = player.charHealth;
						}
					}
					HighPlayButton2.setVisible(false);
					HighPlayButton1.setVisible(false);
					HighNextBattleButton.setVisible(true);
					highCount = 2;
					HighResults.setText("You Win!");
					HighResults.setVisible(true);
					HighPlayerOption.setVisible(true);
					HighVillainChoice.setVisible(true);
					villain.defeatCount++;
					int dmg = player.charATK - (villain.charDEF - 1);
					if (dmg <= 0) {
						dmg = 1;
					}
					villain.charCurrentHealth -= dmg;
					
					if (villain.charCurrentHealth <= 0 || villain.defeatCount >= 3) {
						villain.charCurrentHealth = 0;
						HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
						myTeam.doneCities++;
						HighResults.setText(String.format("Well done! You've defeated %s", villain.charName));
						if (myTeam.doneCities == myTeam.totalCities) {
							//end game scene
							panelHigh.setVisible(false);
							GameTitleLabel.setText("CONGRATULATIONS YOU'VE DEFEATED THE BOSS! \n Click anywhere to continue!");
							GameEndButton.setVisible(true);
							GameEndTitle.setVisible(true);
							GameTitleLabel.setVisible(true);
						} else {
							HighNextCity.setVisible(true);
							myTeam.mapCount = 0;
							myTeam.teamMaps = new ArrayList<String>();
						}
						HighPlayButton1.setVisible(false);
						HighPlayButton2.setVisible(false);
						HighNextBattleButton.setVisible(false);
					} else {
						HighVillainChoice.setVisible(false);
						HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
						HighPlayButton1.setVisible(false);
						HighPlayButton2.setVisible(false);
						HighNextBattleButton.setVisible(true);
					}
					
				} else if (HighPlayerOption.getSelectedIndex() < highOption) {
					HighPlayButton2.setVisible(true);
					highCount--;
					HighResults.setText(String.format("Go Higher. %d chance left", highCount));
					HighResults.setVisible(true);
					if (highCount >= 0 && HighPlayerOption.getSelectedIndex() == highOption) {
						//win
						if (player.charType == Character.Type.REGEN) {
							player.charCurrentHealth += 1;
							if (player.charCurrentHealth > player.charHealth) {
								player.charCurrentHealth = player.charHealth;
							}
						}
						highCount = 2;
						HighResults.setText("You Win!");
						HighResults.setVisible(true);
						HighPlayerOption.setVisible(true);
						HighVillainChoice.setVisible(true);
						villain.defeatCount++;
						int dmg = player.charATK - (villain.charDEF - 1);
						if (dmg <= 0) {
							dmg = 1;
						}
						villain.charCurrentHealth -= dmg;
						
						if (villain.charCurrentHealth <= 0 || villain.defeatCount >= 3) {
							villain.charCurrentHealth = 0;
							HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
							myTeam.doneCities++;
							HighResults.setText(String.format("Well done! You've defeated %s", villain.charName));
							if (myTeam.doneCities == myTeam.totalCities) {
								//end game scene
								panelHigh.setVisible(false);
								GameTitleLabel.setText("CONGRATULATIONS YOU'VE DEFEATED THE BOSS! \n Click anywhere to continue!");
								GameEndButton.setVisible(true);
								GameEndTitle.setVisible(true);
								GameTitleLabel.setVisible(true);
							} else {
								HighNextCity.setVisible(true);
								myTeam.mapCount = 0;
								myTeam.teamMaps = new ArrayList<String>();
							}
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(false);
						} else {
							HighVillainChoice.setVisible(false);
							HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(true);
						}
					} else if (highCount <= 0) {
						//lose
						HighResults.setText("You lose...");
						HighResults.setVisible(true);
						HighVillainChoice.setVisible(true);
						if (player.charPower != 3 || villain.charType != Character.Type.DISPEL) {
							int dmg = villain.charATK - (player.charDEF - 1);
							if (dmg <= 0) {
								dmg = 1;
							}
							player.charCurrentHealth -= dmg;
							
						} else {
							player.charPower = 0;
							player.checkBuff();
							myTeam.teamBuffs.remove("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
							myTeam.buffCount--;
						}
						if (player.charCurrentHealth <= 0) {
							player.charCurrentHealth = 0;
							HighPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
							myTeam.teamHeroes.remove(BattleHeroSel.getSelectedIndex());
							BattleHeroSel.removeAllItems();
							ArrayList<String> heroComboBox = new ArrayList<String>();
							for (Character hero: myTeam.teamHeroes) {
								if (!heroComboBox.contains(hero.charName)) {
									BattleHeroSel.addItem(hero.charName);
									heroComboBox.add(hero.charName);
								}
							}
							player = new Character();
							for (Character hero: myTeam.teamHeroes) {
								if (BattleHeroSel.getSelectedIndex() == 0) {
									player = myTeam.teamHeroes.get(0);
									selectedIndex = 0;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
								} else if (BattleHeroSel.getSelectedIndex() == 1) {
									player = myTeam.teamHeroes.get(1);
									selectedIndex = 1;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
								} else if (BattleHeroSel.getSelectedIndex() == 2) {
									player = myTeam.teamHeroes.get(2);
									selectedIndex = 2;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
								}
							}
							//check if party still has members to fight
							int counter = 0;
							for (Character hero: myTeam.teamHeroes) {
								counter++;
							}
							if (counter > 0) {
								HighPlayButton1.setVisible(false);
								HighPlayButton2.setVisible(false);
								HighNextBattleButton.setVisible(true);
							} else {
								//game over
								panelHigh.setVisible(false);
								GameTitleLabel.setText("Everyone's dead...we're doomed...\n Click anywhere to continue...");
								GameTitleLabel.setVisible(true);
								GameEndTitle.setVisible(true);
								GameEndButton.setVisible(true);
							}
						} else {
							HighPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(true);
						}
					}
				} else if (HighPlayerOption.getSelectedIndex() > highOption) {
					highCount--;
					HighPlayButton2.setVisible(true);
					HighResults.setText(String.format("Go Lower. %d chance left", highCount));
					HighResults.setVisible(true);
					if (highCount >= 0 && HighPlayerOption.getSelectedIndex() == highOption) {
						//win
						highCount = 2;
						if (player.charType == Character.Type.REGEN) {
							player.charCurrentHealth += 1;
							if (player.charCurrentHealth > player.charHealth) {
								player.charCurrentHealth = player.charHealth;
							}
						}
						HighResults.setText("You Win!");
						HighResults.setVisible(true);
						HighPlayerOption.setVisible(true);
						HighVillainChoice.setVisible(true);
						villain.defeatCount++;
						int dmg = player.charATK - (villain.charDEF - 1);
						if (dmg <= 0) {
							dmg = 1;
						}
						villain.charCurrentHealth -= dmg;
						
						if (villain.charCurrentHealth <= 0 || villain.defeatCount >= 3) {
							villain.charCurrentHealth = 0;
							HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
							myTeam.doneCities++;
							HighResults.setText(String.format("Well done! You've defeated %s", villain.charName));
							if (myTeam.doneCities == myTeam.totalCities) {
								//end game scene
								panelHigh.setVisible(false);
								GameTitleLabel.setText("CONGRATULATIONS YOU'VE DEFEATED THE BOSS! \n Click anywhere to continue!");
								GameEndButton.setVisible(true);
								GameEndTitle.setVisible(true);
								GameTitleLabel.setVisible(true);
							} else {
								HighNextCity.setVisible(true);
								myTeam.mapCount = 0;
								myTeam.teamMaps = new ArrayList<String>();
							}
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(false);
						} else {
							HighVillainChoice.setVisible(false);
							HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(true);
						}
					} else if (highCount <= 0){
						//lose
						HighResults.setText("You lose...");
						HighResults.setVisible(true);
						HighVillainChoice.setVisible(true);
						if (player.charPower != 3 || villain.charType != Character.Type.DISPEL) {
							int dmg = villain.charATK - (player.charDEF - 1);
							if (dmg <= 0) {
								dmg = 1;
							}
							player.charCurrentHealth -= dmg;
							
						} else {
							player.charPower = 0;
							player.checkBuff();
							myTeam.teamBuffs.remove("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
							myTeam.buffCount--;
						}
						if (player.charCurrentHealth <= 0) {
							player.charCurrentHealth = 0;
							HighPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
							myTeam.teamHeroes.remove(BattleHeroSel.getSelectedIndex());
							BattleHeroSel.removeAllItems();
							ArrayList<String> heroComboBox = new ArrayList<String>();
							for (Character hero: myTeam.teamHeroes) {
								if (!heroComboBox.contains(hero.charName)) {
									BattleHeroSel.addItem(hero.charName);
									heroComboBox.add(hero.charName);
								}
							}
							player = new Character();
							for (Character hero: myTeam.teamHeroes) {
								if (BattleHeroSel.getSelectedIndex() == 0) {
									player = myTeam.teamHeroes.get(0);
									selectedIndex = 0;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
								} else if (BattleHeroSel.getSelectedIndex() == 1) {
									player = myTeam.teamHeroes.get(1);
									selectedIndex = 1;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
								} else if (BattleHeroSel.getSelectedIndex() == 2) {
									player = myTeam.teamHeroes.get(2);
									selectedIndex = 2;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
								}
							}
							//check if party still has members to fight
							int counter = 0;
							for (Character hero: myTeam.teamHeroes) {
								counter++;
							}
							if (counter > 0) {
								HighPlayButton1.setVisible(false);
								HighPlayButton2.setVisible(false);
								HighNextBattleButton.setVisible(true);
							} else {
								//game over
								panelHigh.setVisible(false);
								GameTitleLabel.setText("Everyone's dead...we're doomed...\n Click anywhere to continue...");
								GameTitleLabel.setVisible(true);
								GameEndTitle.setVisible(true);
								GameEndButton.setVisible(true);
							}
						} else {
							HighPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(true);
						}
					}
				}
				panelHigh.updateUI();
			}
		});
		HighNextCity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myTeam.teamMaps = new ArrayList<String>();
				myTeam.mapCount = 0;
				highCount = 2;
				HighNextCity.setVisible(false);
				HighResults.setText("");
				HighPlayButton1.setVisible(true);
				HighPlayButton2.setVisible(false);
				HighNextBattleButton.setVisible(false);
				panelHigh.setVisible(false);
				frmOasysReady.dispose();
				MapLayout mapLay = new MapLayout(myTeam);
				mapLay.panel.setVisible(true);
			}
		});
		HighNextCity.setVisible(false);
		HighNextCity.setBounds(222, 206, 140, 29);
		panelHigh.add(HighNextCity);
		HighPlayButton1.setBounds(222, 206, 140, 29);
		panelHigh.add(HighPlayButton1);
		HighPlayButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HighPlayerOption.setVisible(true);
				if (HighPlayerOption.getSelectedIndex() == highOption) {
					//win
					if (player.charType == Character.Type.REGEN) {
						player.charCurrentHealth += 1;
						if (player.charCurrentHealth > player.charHealth) {
							player.charCurrentHealth = player.charHealth;
						}
					}
					highCount = 2;
					HighResults.setText("You Win!");
					HighResults.setVisible(true);
					HighPlayerOption.setVisible(true);
					HighVillainChoice.setVisible(true);
					villain.defeatCount++;
					int dmg = player.charATK - (villain.charDEF - 1);
					if (dmg <= 0) {
						dmg = 1;
					}
					villain.charCurrentHealth -= dmg;
					
					if (villain.charCurrentHealth <= 0 || villain.defeatCount >= 3) {
						villain.charCurrentHealth = 0;
						HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
						myTeam.doneCities++;
						HighResults.setText(String.format("Well done! You've defeated %s", villain.charName));
						if (myTeam.doneCities == myTeam.totalCities) {
							//end game scene
							panelHigh.setVisible(false);
							GameTitleLabel.setText("CONGRATULATIONS YOU'VE DEFEATED THE BOSS! \n Click anywhere to continue!");
							GameEndButton.setVisible(true);
							GameEndTitle.setVisible(true);
							GameTitleLabel.setVisible(true);
						} else {
							HighNextCity.setVisible(true);
							myTeam.mapCount = 0;
							myTeam.teamMaps = new ArrayList<String>();
						}
						HighPlayButton1.setVisible(false);
						HighPlayButton2.setVisible(false);
						HighNextBattleButton.setVisible(false);
					} else {
						HighVillainChoice.setVisible(false);
						HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
						HighPlayButton1.setVisible(false);
						HighPlayButton2.setVisible(false);
						HighNextBattleButton.setVisible(true);
					}
					
				} else if (HighPlayerOption.getSelectedIndex() < highOption) {
					HighPlayButton2.setVisible(true);
					highCount--;
					HighResults.setText(String.format("Go Higher. %d chance left", highCount));
					HighResults.setVisible(true);
					if (highCount >= 0 && HighPlayerOption.getSelectedIndex() == highOption) {
						//win
						if (player.charType == Character.Type.REGEN) {
							player.charCurrentHealth += 1;
							if (player.charCurrentHealth > player.charHealth) {
								player.charCurrentHealth = player.charHealth;
							}
						}
						highCount = 2;
						HighResults.setText("You Win!");
						HighResults.setVisible(true);
						HighPlayerOption.setVisible(true);
						HighVillainChoice.setVisible(true);
						villain.defeatCount++;
						int dmg = player.charATK - (villain.charDEF - 1);
						if (dmg <= 0) {
							dmg = 1;
						}
						villain.charCurrentHealth -= dmg;
						
						if (villain.charCurrentHealth <= 0 || villain.defeatCount >= 3) {
							villain.charCurrentHealth = 0;
							HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
							myTeam.doneCities++;
							HighResults.setText(String.format("Well done! You've defeated %s", villain.charName));
							if (myTeam.doneCities == myTeam.totalCities) {
								//end game scene
								panelHigh.setVisible(false);
								GameTitleLabel.setText("CONGRATULATIONS YOU'VE DEFEATED THE BOSS! \n Click anywhere to continue!");
								GameEndButton.setVisible(true);
								GameEndTitle.setVisible(true);
								GameTitleLabel.setVisible(true);
							} else {
								HighNextCity.setVisible(true);
								myTeam.mapCount = 0;
								myTeam.teamMaps = new ArrayList<String>();
							}
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(false);
						} else {
							HighVillainChoice.setVisible(false);
							HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(true);
						}
					} else if (highCount <= 0) {
						//lose
						HighResults.setText("You lose...");
						HighResults.setVisible(true);
						HighPlayButton2.setVisible(false);
						HighVillainChoice.setVisible(true);
						if (player.charPower != 3 || villain.charType != Character.Type.DISPEL) {
							int dmg = villain.charATK - (player.charDEF - 1);
							if (dmg <= 0) {
								dmg = 1;
							}
							player.charCurrentHealth -= dmg;
							
						} else {
							player.charPower = 0;
							player.checkBuff();
							myTeam.teamBuffs.remove("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
							myTeam.buffCount--;
						}
						if (player.charCurrentHealth <= 0) {
							player.charCurrentHealth = 0;
							HighPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
							myTeam.teamHeroes.remove(BattleHeroSel.getSelectedIndex());
							BattleHeroSel.removeAllItems();
							ArrayList<String> heroComboBox = new ArrayList<String>();
							for (Character hero: myTeam.teamHeroes) {
								if (!heroComboBox.contains(hero.charName)) {
									BattleHeroSel.addItem(hero.charName);
									heroComboBox.add(hero.charName);
								}
							}
							player = new Character();
							for (Character hero: myTeam.teamHeroes) {
								if (BattleHeroSel.getSelectedIndex() == 0) {
									player = myTeam.teamHeroes.get(0);
									selectedIndex = 0;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0)))); 
								} else if (BattleHeroSel.getSelectedIndex() == 1) {
									player = myTeam.teamHeroes.get(1);
									selectedIndex = 1;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
								} else if (BattleHeroSel.getSelectedIndex() == 2) {
									player = myTeam.teamHeroes.get(2);
									selectedIndex = 2;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
								}
							}
							//check if party still has members to fight
							int counter = 0;
							for (Character hero: myTeam.teamHeroes) {
								counter++;
							}
							if (counter > 0) {
								HighPlayButton1.setVisible(false);
								HighPlayButton2.setVisible(false);
								HighNextBattleButton.setVisible(true);
							} else {
								//game over
								panelHigh.setVisible(false);
								GameTitleLabel.setText("Everyone's dead...we're doomed... \n Click anywhere to continue...");
								GameTitleLabel.setVisible(true);
								GameEndTitle.setVisible(true);
								GameEndButton.setVisible(true);
							}
						} else {
							HighPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(true);
						}
					}
				} else if (HighPlayerOption.getSelectedIndex() > highOption) {
					highCount--;
					HighPlayButton2.setVisible(true);
					HighResults.setText(String.format("Go Lower. %d chance left", highCount));
					HighResults.setVisible(true);
					if (highCount >= 0 && HighPlayerOption.getSelectedIndex() == highOption) {
						//win
						if (player.charType == Character.Type.REGEN) {
							player.charCurrentHealth += 1;
							if (player.charCurrentHealth > player.charHealth) {
								player.charCurrentHealth = player.charHealth;
							}
						}
						highCount = 2;
						HighResults.setText("You Win!");
						HighResults.setVisible(true);
						HighPlayerOption.setVisible(true);
						HighVillainChoice.setVisible(true);
						villain.defeatCount++;
						int dmg = player.charATK - (villain.charDEF - 1);
						if (dmg <= 0) {
							dmg = 1;
						}
						villain.charCurrentHealth -= dmg;
						
						if (villain.charCurrentHealth <= 0 || villain.defeatCount >= 3) {
							villain.charCurrentHealth = 0;
							HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
							myTeam.doneCities++;
							HighResults.setText(String.format("Well done! You've defeated %s", villain.charName));
							if (myTeam.doneCities == myTeam.totalCities) {
								//end game scene
								panelHigh.setVisible(false);
								GameTitleLabel.setText("CONGRATULATIONS YOU'VE DEFEATED THE BOSS! \n Click anywhere to continue!");
								GameEndButton.setVisible(true);
								GameEndTitle.setVisible(true);
								GameTitleLabel.setVisible(true);
							} else {
								HighNextCity.setVisible(true);
								myTeam.mapCount = 0;
								myTeam.teamMaps = new ArrayList<String>();
							}
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(false);
						} else {
							HighVillainChoice.setVisible(false);
							HighVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(true);
						}
					} else if (highCount <= 0){
						//lose
						HighPlayButton2.setVisible(false);
						HighResults.setText("You lose...");
						HighResults.setVisible(true);
						HighVillainChoice.setVisible(true);
						if (player.charPower != 3 || villain.charType != Character.Type.DISPEL) {
							int dmg = villain.charATK - (player.charDEF - 1);
							if (dmg <= 0) {
								dmg = 1;
							}
							player.charCurrentHealth -= dmg;
							
						} else {
							player.charPower = 0;
							player.checkBuff();
							myTeam.teamBuffs.remove("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
							myTeam.buffCount--;
						}
						if (player.charCurrentHealth <= 0) {
							player.charCurrentHealth = 0;
							HighPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
							myTeam.teamHeroes.remove(BattleHeroSel.getSelectedIndex());
							BattleHeroSel.removeAllItems();
							ArrayList<String> heroComboBox = new ArrayList<String>();
							for (Character hero: myTeam.teamHeroes) {
								if (!heroComboBox.contains(hero.charName)) {
									BattleHeroSel.addItem(hero.charName);
									heroComboBox.add(hero.charName);
								}
							}
							player = new Character();
							for (Character hero: myTeam.teamHeroes) {
								if (BattleHeroSel.getSelectedIndex() == 0) {
									player = myTeam.teamHeroes.get(0);
									selectedIndex = 0;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
								} else if (BattleHeroSel.getSelectedIndex() == 1) {
									player = myTeam.teamHeroes.get(1);
									selectedIndex = 1;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
								} else if (BattleHeroSel.getSelectedIndex() == 2) {
									player = myTeam.teamHeroes.get(2);
									selectedIndex = 2;
									HighPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
								}
							}
							//check if party still has members to fight
							int counter = 0;
							for (Character hero: myTeam.teamHeroes) {
								counter++;
							}
							if (counter > 0) {
								HighPlayButton1.setVisible(false);
								HighPlayButton2.setVisible(false);
								HighNextBattleButton.setVisible(true);
							} else {
								//game over
								panelHigh.setVisible(false);
								GameTitleLabel.setText("Everyone's dead...we're doomed...\n Click anywhere to continue...");
								GameTitleLabel.setVisible(true);
								GameEndTitle.setVisible(true);
								GameEndButton.setVisible(true);
							}
						} else {
							HighPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
							HighPlayButton1.setVisible(false);
							HighPlayButton2.setVisible(false);
							HighNextBattleButton.setVisible(true);
						}
					}
				}
				panelHigh.updateUI();
			}
		});
		
		HighPlayButton2.setBounds(222, 206, 140, 29);
		
		panelHigh.add(HighPlayButton2);
		HighNextBattleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HighBuff.setVisible(false);
				highCount = 2;
				HighNextBattleButton.setVisible(false);
				HighPlayButton1.setVisible(true);
				HighPlayButton2.setVisible(false);
				HighResults.setVisible(false);
				HighPlayerOption.setVisible(true);
				HighPlayerOption.setSelectedIndex(0);
				HighVillainChoice.setVisible(false);
				panelHigh.setVisible(false);
				String villainChoice = "";
				villainOption = Math.abs(randomNum.nextInt()) % 3;
				if (villain.charType == Character.Type.ONETRICK) {
					villainOption = 2;
					villainChoice = String.format(" %s: This will be a game of High-Low..\n I'll pick a number and you guess.", villain.charName);
				}
				if (villainOption == 0) {
					villainChoice = String.format(" %s: Don't you just love a classic game\n of rock paper scissors??", villain.charName);
				} else if (villainOption == 1) {
					villainChoice = String.format(" %s: Life is like a dice roll.\n You'll never knoll (ok that was bad).", villain.charName);
				} else {
					villainChoice = String.format(" %s: This will be a game of High-Low..\n I'll pick a number and you guess.", villain.charName);
				}
				BattleHeroSel.removeAllItems();
				ArrayList<String> heroComboBox = new ArrayList<String>();
				for (Character hero: myTeam.teamHeroes) {
					if (!heroComboBox.contains(hero.charName)) {
						BattleHeroSel.addItem(hero.charName);
						heroComboBox.add(hero.charName);
					}
				}
				player = new Character();
				for (String hero: heroComboBox) {
					if (BattleHeroSel.getSelectedIndex() == 0) {
						player = myTeam.teamHeroes.get(0);
						selectedIndex = 0;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
					} else if (BattleHeroSel.getSelectedIndex() == 1) {
						player = myTeam.teamHeroes.get(1);
						selectedIndex = 1;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
					} else if (BattleHeroSel.getSelectedIndex() == 2) {
						player = myTeam.teamHeroes.get(2);
						selectedIndex = 2;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
					}
				}
				HighPlayerHealth.setText(String.format("Your health: %d / %d", player.charCurrentHealth, player.charHealth));
				VillainTaunt1.setText(villainChoice);
				VillainTaunt1.setVisible(true);
				VillainBorder2.setVisible(true);
				BattleHeroSel.setVisible(true);
				panelBattle.setVisible(true);
			}
		});
		HighNextBattleButton.setVisible(false);
		HighNextBattleButton.setBounds(222, 206, 140, 29);
		panelHigh.add(HighNextBattleButton);
		
		HighVillainIcon.setBounds(44, 42, 100, 100);
		panelHigh.add(HighVillainIcon);
		HighResults.setVisible(false);
		
		HighResults.setHorizontalAlignment(SwingConstants.CENTER);
		HighResults.setEditable(false);
		HighResults.setBounds(87, 160, 384, 34);
		HighResults.setColumns(10);
		panelHigh.add(HighResults);
		
		HighPlayerOption.setBounds(222, 277, 134, 36);
		panelHigh.add(HighPlayerOption);
		HighVillainChoice.setVisible(false);
		HighVillainChoice.setBounds(442, 54, 128, 85);
		panelHigh.add(HighVillainChoice);
		
		HighPlayerHealth.setText(String.format("Health: %d / 8", player.charHealth));
		HighPlayerHealth.setHorizontalAlignment(SwingConstants.CENTER);
		HighPlayerHealth.setFont(new Font("Courier", Font.BOLD, 18));
		HighPlayerHealth.setEditable(false);
		HighPlayerHealth.setColumns(10);
		HighPlayerHealth.setBounds(144, 399, 230, 44);
		panelHigh.add(HighPlayerHealth);
		
		HighBuff.setText("no buffs in effect!");
		HighBuff.setFont(new Font("Courier", Font.PLAIN, 8));
		HighBuff.setEditable(false);
		HighBuff.setColumns(10);
		HighBuff.setBounds(396, 415, 192, 15);
		panelHigh.add(HighBuff);
		HighPlayerPic.setBounds(44, 345, 100, 99);
		panelHigh.add(HighPlayerPic);
		
		panelHigh.setVisible(false);
		
		//Dice roll
		DiceVillainHealth.setEditable(false);
		DiceVillainHealth.setHorizontalAlignment(SwingConstants.CENTER);
		DiceVillainHealth.setFont(new Font("Courier", Font.BOLD, 21));
		DiceVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
		DiceVillainHealth.setBounds(182, 79, 200, 36);
		DiceVillainHealth.setColumns(10);
		panelDice.add(DiceVillainHealth);
		
		DiceVillainIcon.setBounds(44, 42, 100, 100);
		panelDice.add(DiceVillainIcon);
		
		panelDice.setVisible(false);
		BattleHeroSel.setVisible(false);
		BattleHeroSel.removeAllItems();
		panelBattle.setVisible(false);
		GameTitleLabel.setEditable(false);
		GameTitleLabel.setVisible(false);
		GameTitleLabel.setForeground(Color.BLACK);
		GameTitleLabel.setFont(new Font("Courier", Font.BOLD, 13));
		GameTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GameTitleLabel.setBounds(41, 413, 517, 30);
		frmOasysReady.getContentPane().add(GameTitleLabel);
		
		GameEndTitle = new JTextField();
		GameEndTitle.setHorizontalAlignment(SwingConstants.CENTER);
		GameEndTitle.setEditable(false);
		GameEndTitle.setVisible(false);
		GameEndTitle.setBounds(41, 50, 517, 30);
		frmOasysReady.getContentPane().add(GameEndTitle);
		GameEndTitle.setText("Thank you for bearing with us all the movie references...now one last meme!)");
		GameEndTitle.setColumns(10);
		GameEndButton.setForeground(Color.RED);
		GameEndButton.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/SpongeGame.jpg")));
		GameEndButton.setVisible(false);
		GameEndButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GameTitleLabel.setVisible(false);
				GameEndTitle.setVisible(false);
				GameEndButton.setVisible(false);
				frmOasysReady.dispose();
				EndCredits end = new EndCredits(myTeam);
			}
		});
		GameEndButton.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(GameEndButton);
		GameEndButton.setFont(new Font("Courier", Font.BOLD, 20));
		GameEndButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelVillain.setVisible(false);
		panelVillain.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelVillain);
		panelVillain.setLayout(null);
		
		JTextPane VillainTaunt = new JTextPane();
		VillainTaunt.setVisible(false);
		VillainTaunt.setText(villainTaunt);
		VillainTaunt.setFont(new Font("Courier", Font.BOLD, 21));
		VillainTaunt.setEditable(false);
		VillainTaunt.setBackground(Color.CYAN);
		VillainTaunt.setBounds(6, 377, 582, 89);
		panelVillain.add(VillainTaunt);
		
		JTextPane VillainBorder1 = new JTextPane();
		VillainBorder1.setVisible(false);
		VillainBorder1.setEditable(false);
		VillainBorder1.setBackground(Color.BLACK);
		VillainBorder1.setBounds(0, 370, 600, 108);
		panelVillain.add(VillainBorder1);
		VillainBackground.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (VillainBorder1.isVisible() == false && VillainTaunt.isVisible() == false) {
					VillainBorder1.setVisible(true);
					VillainTaunt.setVisible(true);
					VillainPic.setVisible(true);
				} else {
					if (VillainTaunt.getText().equals(villain.toString())) {
						VillainTaunt.setText(String.format("%s...", villain.toString()));
					} else {
						panelVillain.setVisible(false);
						panelBattle.setVisible(true);
					}
				}
			}
		});
		VillainPic.setVisible(false);
		
		
		VillainPic.setBounds(101, 21, 385, 310);	
		panelVillain.add(VillainPic);
		
		VillainBackground.setBounds(0, 0, 600, 478);
		panelVillain.add(VillainBackground);
		panelBattle.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelBattle);
		panelBattle.setLayout(null);
		
		
		VillainTaunt1.setText(villainChoice);
		VillainTaunt1.setFont(new Font("Courier", Font.BOLD, 21));
		VillainTaunt1.setEditable(false);
		VillainTaunt1.setBackground(Color.CYAN);
		VillainTaunt1.setBounds(6, 377, 582, 89);
		panelBattle.add(VillainTaunt1);
		
		
		VillainBorder2.setEditable(false);
		VillainBorder2.setBackground(Color.BLACK);
		VillainBorder2.setBounds(0, 370, 600, 108);
		panelBattle.add(VillainBorder2);
		BattleHeroSel.setBounds(175, 187, 266, 50);
		BattleHeroSel.setBounds(177, 130, 239, 27);
		panelBattle.add(BattleHeroSel);
		
		BattleFightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> heroComboBox = new ArrayList<String>();
				BattleHeroSel.removeAllItems();
				for (Character hero: myTeam.teamHeroes) {
					if (!heroComboBox.contains(hero.charName)) {
						BattleHeroSel.addItem(hero.charName);
						heroComboBox.add(hero.charName);
					}
				}
				player = new Character();
				for (Character hero: myTeam.teamHeroes) {
					if (BattleHeroSel.getSelectedIndex() == 0) {
						player = myTeam.teamHeroes.get(0);
						selectedIndex = 0;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
					} else if (BattleHeroSel.getSelectedIndex() == 1) {
						player = myTeam.teamHeroes.get(1);
						selectedIndex = 1;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
					} else if (BattleHeroSel.getSelectedIndex() == 2) {
						player = myTeam.teamHeroes.get(2);
						selectedIndex = 2;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
					}
				}
				RockPlayerHealth.setText(String.format("Your health: %d / %d", player.charCurrentHealth, player.charHealth));
				DicePlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
				BattleFightButton.setVisible(false);
				BattleHeroSel.setVisible(false);
				BattleChooseHero.setVisible(false);
				panelBattle.setVisible(false);
				if (villainOption == 0) {
					panelRock.setVisible(true);
					RockResults.setVisible(false);
					RockVillainChoice.setVisible(false);
					if (player.charPower == 0 || villain.charType == Character.Type.DISPEL) {
						RockBuff.setText("no buffs in effect!");
					} else if (player.charPower == 1) {
						RockBuff.setText("50-50 chance of winning!");
					} else if (player.charPower == 2) {
						if (villain.charType != Character.Type.DISPEL || villain.charType != Character.Type.RAIDBOSS) {
							RockBuff.setText("future sight!");
						} else {
							RockBuff.setText("buffs negated by villain!");
						}
					} else if (player.charPower == 3) {
						if (villain.charType != Character.Type.DISPEL) {
							RockBuff.setText("take no damage this round!");
						} else {
							RockBuff.setText("buffs negated by villain!");
						}
					}
				} else if (villainOption == 1) {
					panelDice.setVisible(true);
				} else if (villainOption == 2) {
					panelHigh.setVisible(true);
				}
			}
		});
		BattleFightButton.setVisible(false);
		BattleFightButton.setBounds(236, 293, 117, 29);
		panelBattle.add(BattleFightButton);
		
		BattleChooseHero.setFont(new Font("Courier", Font.BOLD, 23));
		BattleChooseHero.setHorizontalAlignment(SwingConstants.CENTER);
		BattleChooseHero.setVisible(false);
		BattleChooseHero.setText("Choose your Hero!");
		BattleChooseHero.setBounds(175, 40, 254, 38);
		panelBattle.add(BattleChooseHero);
		BattleChooseHero.setColumns(10);
		
		BattleBackground.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (VillainTaunt1.getText().contains("w..")) {
					VillainTaunt1.setText(String.format(" %s: This will be a game of High-Low.\n I'll pick a number and you guess..", villain.charName));
				} else if (VillainTaunt1.getText().contains("guess..")) {
					VillainTaunt1.setText(String.format(" %s: Correct, you win. Wrong, I'll give a hint.\n Wrong again, take the L.", villain.charName));
				} else if (VillainTaunt1.getText().contains("bad).")) {
					VillainTaunt1.setText(String.format(" %s: Life is like a dice roll.\n You'll never knoll...(ok that was bad)", villain.charName));
				} else if (VillainTaunt1.getText().contains("knoll...")) {
					VillainTaunt1.setText(String.format(" %s: Higher number wins!", villain.charName));
				} else if (VillainTaunt1.getText().contains("scissors??")) {
					VillainTaunt1.setText(String.format(" %s: Don't you just love a classic game\n of rock paper scissor?", villain.charName));
				} else if (VillainTaunt1.getText().contains("scissor?")) {
					VillainTaunt1.setText(String.format(" %s: Scissors beats Paper, Paper beats Rock\n Rock beats Scissors (smoldering intensity from Jumanji)", villain.charName));
				} else if (VillainTaunt1.getText().contains("beats") || VillainTaunt1.getText().contains("Wrong again") 
																	|| VillainTaunt1.getText().contains("wins!")) {
					VillainTaunt1.setVisible(false);
					VillainBorder2.setVisible(false);
					ArrayList<String> heroComboBox = new ArrayList<String>();
					BattleHeroSel.removeAllItems();
					for (Character hero: myTeam.teamHeroes) {
						if (!heroComboBox.contains(hero.charName)) {
							BattleHeroSel.addItem(hero.charName);
							heroComboBox.add(hero.charName);
						}
					}
					BattleHeroSel.setVisible(true);
					BattleFightButton.setVisible(true);
					BattleChooseHero.setVisible(true);
					
				}
			}
		});
		
		BattleBackground.setBounds(0, 0, 600, 478);
		panelBattle.add(BattleBackground);
		panelDice.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelDice);
		panelDice.setLayout(null);
		
		DiceResults.setHorizontalAlignment(SwingConstants.CENTER);
		DiceResults.setVisible(false);
		DiceResults.setEditable(false);
		DiceResults.setBounds(87, 160, 415, 34);
		DiceResults.setColumns(10);
		panelDice.add(DiceResults);
		
		DicePlayerOption.setBounds(253, 271, 100, 100);
		panelDice.add(DicePlayerOption);
		DiceVillainChoice.setVisible(false);
		DiceVillainChoice.setBounds(445, 42, 100, 100);
		
		panelDice.add(DiceVillainChoice);
		DicePlayerHealth.setText(String.format("Health: %d / 8", player.charHealth));
		DicePlayerHealth.setHorizontalAlignment(SwingConstants.CENTER);
		DicePlayerHealth.setFont(new Font("Courier", Font.BOLD, 18));
		DicePlayerHealth.setEditable(false);
		DicePlayerHealth.setColumns(10);
		DicePlayerHealth.setBounds(153, 403, 200, 36);
		
		panelDice.add(DicePlayerHealth);
		DiceBuff.setText("no buffs in effect!");
		DiceBuff.setFont(new Font("Courier", Font.PLAIN, 8));
		DiceBuff.setEditable(false);
		DiceBuff.setColumns(10);
		DiceBuff.setBounds(365, 415, 180, 15);
		panelDice.add(DiceBuff);
		DicePlayerPic.setBounds(44, 348, 100, 99);
		panelDice.add(DicePlayerPic);
		
		DiceNextBattleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DiceBuff.setVisible(false);
				DiceNextBattleButton.setVisible(false);
				DiceRoll1.setVisible(true);
				DiceResults.setVisible(false);
				DicePlayerOption.setVisible(false);
				DiceVillainChoice.setVisible(false);
				panelDice.setVisible(false);
				String villainChoice = "";
				villainOption = Math.abs(randomNum.nextInt()) % 3;
				if (villain.charType == Character.Type.ONETRICK) {
					villainOption = 2;
					villainChoice = String.format(" %s: This will be a game of High-Low..\n I'll pick a number and you guess.", villain.charName);
				}
				if (villainOption == 0) {
					villainChoice = String.format(" %s: Don't you just love a classic game\n of rock paper scissors??", villain.charName);
				} else if (villainOption == 1) {
					villainChoice = String.format(" %s: Life is like a dice roll.\n You'll never knoll (ok that was bad).", villain.charName);
				} else {
					villainChoice = String.format(" %s: This will be a game of High-Low..\n I'll pick a number and you guess.", villain.charName);
				}
				BattleHeroSel.removeAllItems();
				ArrayList<String> heroComboBox = new ArrayList<String>();
				for (Character hero: myTeam.teamHeroes) {
					if (!heroComboBox.contains(hero.charName)) {
						BattleHeroSel.addItem(hero.charName);
						heroComboBox.add(hero.charName);
					}
				}
				player = new Character();
				for (String hero: heroComboBox) {
					if (BattleHeroSel.getSelectedIndex() == 0) {
						player = myTeam.teamHeroes.get(0);
						selectedIndex = 0;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
					} else if (BattleHeroSel.getSelectedIndex() == 1) {
						player = myTeam.teamHeroes.get(1);
						selectedIndex = 1;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
					} else if (BattleHeroSel.getSelectedIndex() == 2) {
						player = myTeam.teamHeroes.get(2);
						selectedIndex = 2;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
					}
				}
				DicePlayerHealth.setText(String.format("Your health: %d / %d", player.charCurrentHealth, player.charHealth));
				VillainTaunt1.setText(villainChoice);
				VillainTaunt1.setVisible(true);
				VillainBorder2.setVisible(true);
				BattleHeroSel.setVisible(true);
				panelBattle.setVisible(true);
			}
		});
		DiceNextBattleButton.setVisible(false);
		DiceNextBattleButton.setBounds(222, 206, 131, 29);
		
		panelDice.add(DiceNextBattleButton);
		
		DiceNextCity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myTeam.teamMaps = new ArrayList<String>();
				myTeam.mapCount = 0;
				DiceNextCity.setVisible(false);
				DiceResults.setText("");
				panelDice.setVisible(false);
				frmOasysReady.dispose();
				MapLayout mapLay = new MapLayout(myTeam);
				mapLay.panel.setVisible(true);
				
			}
		});
		DiceNextCity.setVisible(false);
		DiceNextCity.setBounds(222, 206, 131, 29);
		panelDice.add(DiceNextCity);
		
		DiceRoll1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dicePlayer = Math.abs(randomNum.nextInt()) % 6;
				if (player.charPower == 1 && villain.charType != Character.Type.DISPEL) {
					diceOption = Math.abs(randomNum.nextInt()) % 3;
					player.charPower = 0;
					player.checkBuff();
					myTeam.teamBuffs.remove("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
					myTeam.buffCount--;
				} else {
					diceOption = Math.abs(randomNum.nextInt()) % 6;
				}
				if (dicePlayer == 0) {
					DicePlayerOption.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice1.jpg")));
				} else if (dicePlayer == 1) {
					DicePlayerOption.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice2.jpg")));
				} else if (dicePlayer == 2) {
					DicePlayerOption.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice3.jpg")));
				} else if (dicePlayer == 3) {
					DicePlayerOption.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice4.jpeg")));
				} else if (dicePlayer == 4) {
					DicePlayerOption.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice5.jpeg")));
				} else if (dicePlayer == 5) {
					DicePlayerOption.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice6.jpeg")));
				} 
				if (diceOption == 0) {
					DiceVillainChoice.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice1.jpg"))); 
				} else if (diceOption == 1) {
					DiceVillainChoice.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice2.jpg")));
				} else if (diceOption == 2) {
					DiceVillainChoice.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice3.jpg")));
				} else if (diceOption == 3) {
					DiceVillainChoice.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice4.jpeg")));
				} else if (diceOption == 4) {
					DiceVillainChoice.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice5.jpeg")));
				} else if (diceOption == 5) {
					DiceVillainChoice.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/DiceDice6.jpeg")));
				} 
				DicePlayerOption.setVisible(true);
				DiceVillainChoice.setVisible(true);
				if (dicePlayer == diceOption) {
					DiceResults.setText("It's a draw. Go again");
					DiceResults.setVisible(true);
					DicePlayerOption.setVisible(true);
					DiceVillainChoice.setVisible(true);
					
				} else if (dicePlayer > diceOption) {
					DiceResults.setText("You win!");
					DiceResults.setVisible(true);
					DiceVillainChoice.setVisible(true);
					villain.defeatCount++;
					if (player.charType == Character.Type.REGEN) {
						player.charCurrentHealth += 1;
						if (player.charCurrentHealth > player.charHealth) {
							player.charCurrentHealth = player.charHealth;
						}
					}
					int dmg = player.charATK - (villain.charDEF - 1);
					if (dmg <= 0) {
						dmg = 1;
					}
					villain.charCurrentHealth -= dmg;
					
					if (villain.charCurrentHealth <= 0 || villain.defeatCount >= 3) {
						villain.charCurrentHealth = 0;
						DiceVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
						myTeam.doneCities++;
						DiceResults.setText(String.format("Well done! You've defeated %s", villain.charName));
						if (myTeam.doneCities == myTeam.totalCities) {
							//end game scene
							panelDice.setVisible(false);
							GameTitleLabel.setText("CONGRATULATIONS YOU'VE DEFEATED THE BOSS! \n Click anywhere to continue!");
							GameEndButton.setVisible(true);
							GameEndTitle.setVisible(true);
							GameTitleLabel.setVisible(true);
						} else {
							DiceNextCity.setVisible(true);
							myTeam.mapCount = 0;
							myTeam.teamMaps = new ArrayList<String>();
						}
						DiceRoll1.setVisible(false);
						DiceNextBattleButton.setVisible(false);
					} else {
						DiceVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
						DiceRoll1.setVisible(false);
						DiceNextBattleButton.setVisible(true);
					}
				} else if (dicePlayer < diceOption) {
					DiceResults.setText("You lose...");
					DiceResults.setVisible(true);
					DiceVillainChoice.setVisible(true);
					if (player.charPower != 3 || villain.charType != Character.Type.DISPEL) {
						int dmg = villain.charATK - (player.charDEF - 1);
						if (dmg <= 0) {
							dmg = 1;
						}
						player.charCurrentHealth -= dmg;
						
					} else {
						player.charPower = 0;
						player.checkBuff();
						myTeam.teamBuffs.remove("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
						myTeam.buffCount--;
					}
					if (player.charCurrentHealth <= 0) {
						player.charCurrentHealth = 0;
						DicePlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
						myTeam.teamHeroes.remove(BattleHeroSel.getSelectedIndex());
						BattleHeroSel.removeAllItems();
						ArrayList<String> heroComboBox = new ArrayList<String>();
						for (Character hero: myTeam.teamHeroes) {
							if (!heroComboBox.contains(hero.charName)) {
								BattleHeroSel.addItem(hero.charName);
								heroComboBox.add(hero.charName);
							}
						}
						player = new Character();
						for (Character hero: myTeam.teamHeroes) {
							if (BattleHeroSel.getSelectedIndex() == 0) {
								player = myTeam.teamHeroes.get(0);
								selectedIndex = 0;
								DicePlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
							} else if (BattleHeroSel.getSelectedIndex() == 1) {
								player = myTeam.teamHeroes.get(1);
								selectedIndex = 1;
								DicePlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
							} else if (BattleHeroSel.getSelectedIndex() == 2) {
								player = myTeam.teamHeroes.get(2);
								selectedIndex = 2;
								DicePlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
							}
						}
						//check if party still has members to fight
						int counter = 0;
						for (Character hero: myTeam.teamHeroes) {
							counter++;
						}
						if (counter > 0) {
							DiceRoll1.setVisible(false);
							DiceNextBattleButton.setVisible(true);
						} else {
							//game over
							panelDice.setVisible(false);
							GameTitleLabel.setText("Everyone's dead...we're doomed... \n Click anywhere to continue...");
							GameTitleLabel.setVisible(true);
							GameEndTitle.setVisible(true);
							GameEndButton.setVisible(true);
						}
					} else {
						DicePlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
						DiceRoll1.setVisible(false);
						DiceNextBattleButton.setVisible(true);
					}
				}
				
				panelDice.updateUI();
			}
		});
		DiceRoll1.setBounds(222, 206, 131, 29);
		
		panelDice.add(DiceRoll1);
		BattleBackground3.setBounds(0, 0, 600, 478);
		panelDice.add(BattleBackground3);
		DicePlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
		panelHigh.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelHigh);
		panelHigh.setLayout(null);
		BattleBackground1.setBounds(0, 0, 600, 478);
		panelHigh.add(BattleBackground1);
		

		panelRock.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelRock);
		
		panelRock.setVisible(false);
		panelRock.setLayout(null);
		RockNextCity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myTeam.teamMaps = new ArrayList<String>();
				myTeam.mapCount = 0;
				RockNextCity.setVisible(false);
				RockResults.setText("");
				panelRock.setVisible(false);
				frmOasysReady.dispose();
				MapLayout mapLay = new MapLayout(myTeam);
				mapLay.panel.setVisible(true);
				
			}
		});
		RockNextCity.setVisible(false);
		RockVillainChoice.setBounds(459, 61, 100, 100);
		panelRock.add(RockVillainChoice);
		RockVillainChoice.setVisible(false);
		RockNextCity.setBounds(222, 206, 117, 29);
		panelRock.add(RockNextCity);
		RockBuff.setFont(new Font("Courier", Font.PLAIN, 8));
		RockBuff.setText("no buffs in effect!");
		RockBuff.setEditable(false);
		RockBuff.setBounds(394, 417, 162, 15);
		RockBuff.setColumns(10);
		
		panelRock.add(RockBuff);
		
		RockVillainIcon.setBounds(44, 42, 100, 100);
		panelRock.add(RockVillainIcon);
		RockVillainHealth.setEditable(false);
		RockVillainHealth.setHorizontalAlignment(SwingConstants.CENTER);
		
		RockVillainHealth.setFont(new Font("Courier", Font.BOLD, 21));
		RockVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
		RockVillainHealth.setBounds(193, 79, 189, 36);
		RockVillainHealth.setColumns(10);
		panelRock.add(RockVillainHealth);
		RockNextBattleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RockBuff.setVisible(false);
				RockNextBattleButton.setVisible(false);
				RockPlayButton.setVisible(true);
				RockRockButton.setEnabled(true);
				RockPaperButton.setEnabled(true);
				RockScissorsButton.setEnabled(true);
				RockResults.setVisible(false);
				RockVillainChoice.setVisible(false);
				rockWin = 3;
				rockPlayer = 3;
				panelRock.setVisible(false);
				String villainChoice = "";
				villainOption = Math.abs(randomNum.nextInt()) % 3;
				if (villain.charType == Character.Type.ONETRICK) {
					villainOption = 2;
					villainChoice = String.format(" %s: This will be a game of High-Low..\n I'll pick a number and you guess.", villain.charName);
				}
				if (villainOption == 0) {
					villainChoice = String.format(" %s: Don't you just love a classic game\n of rock paper scissors??", villain.charName);
				} else if (villainOption == 1) {
					villainChoice = String.format(" %s: Life is like a dice roll.\n You'll never knoll (ok that was bad).", villain.charName);
				} else {
					villainChoice = String.format(" %s: This will be a game of High-Low..\n I'll pick a number and you guess.", villain.charName);
				}
				BattleHeroSel.removeAllItems();
				ArrayList<String> heroComboBox = new ArrayList<String>();
				for (Character hero: myTeam.teamHeroes) {
					if (!heroComboBox.contains(hero.charName)) {
						BattleHeroSel.addItem(hero.charName);
						heroComboBox.add(hero.charName);
					}
				}
				player = new Character();
				for (String hero: heroComboBox) {
					if (BattleHeroSel.getSelectedIndex() == 0) {
						player = myTeam.teamHeroes.get(0);
						selectedIndex = 0;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
					} else if (BattleHeroSel.getSelectedIndex() == 1) {
						player = myTeam.teamHeroes.get(1);
						selectedIndex = 1;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
					} else if (BattleHeroSel.getSelectedIndex() == 2) {
						player = myTeam.teamHeroes.get(2);
						selectedIndex = 2;
						RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
					}
				}
				RockPlayerHealth.setText(String.format("Your health: %d / %d", player.charCurrentHealth, player.charHealth));
				VillainTaunt1.setText(villainChoice);
				VillainTaunt1.setVisible(true);
				VillainBorder2.setVisible(true);
				BattleHeroSel.setVisible(true);
				panelBattle.setVisible(true);
			}
		});
		RockNextBattleButton.setVisible(false);
		RockNextBattleButton.setBounds(222, 206, 146, 29);
		
		panelRock.add(RockNextBattleButton);
		RockResults.setHorizontalAlignment(SwingConstants.CENTER);
		RockResults.setVisible(false);
		RockResults.setEditable(false);
		RockResults.setBounds(90, 160, 351, 34);
		RockResults.setColumns(10);
		
		panelRock.add(RockResults);
		RockScissorsButton.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/RockScissors.jpeg")));
		RockScissorsButton.setBounds(431, 247, 100, 100);
		RockScissorsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rockPlayer = 0;
				RockScissorsButton.setEnabled(true);
				RockRockButton.setEnabled(false);
				RockPaperButton.setEnabled(false);
				RockResults.setVisible(false);
				RockVillainChoice.setVisible(false);

			}
		});
		panelRock.add(RockScissorsButton);
		RockRockButton.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/RockRock.jpeg")));
		RockRockButton.setBounds(239, 247, 100, 100);
		RockRockButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rockPlayer = 1;
				RockRockButton.setEnabled(true);
				RockScissorsButton.setEnabled(false);
				RockPaperButton.setEnabled(false);
				RockResults.setVisible(false);
				RockVillainChoice.setVisible(false);

			}
		});
		panelRock.add(RockRockButton);
		RockPaperButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rockPlayer = 2;
				RockPaperButton.setEnabled(true);
				RockScissorsButton.setEnabled(false);
				RockRockButton.setEnabled(false);
				RockResults.setVisible(false);
				RockVillainChoice.setVisible(false);

			}
		});
		RockPaperButton.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/RockPaper.jpeg")));
		RockPaperButton.setBounds(44, 247, 100, 100);
		
		panelRock.add(RockPaperButton);
		
		RockPlayButton.setBounds(222, 206, 117, 29);
		
		panelRock.add(RockPlayButton);
		RockPlayerHealth.setText(String.format("Health: %d / 8", player.charHealth));
		RockPlayerHealth.setHorizontalAlignment(SwingConstants.CENTER);
		RockPlayerHealth.setFont(new Font("Courier", Font.BOLD, 18));
		RockPlayerHealth.setEditable(false);
		RockPlayerHealth.setColumns(10);
		RockPlayerHealth.setBounds(182, 403, 200, 36);
		
		panelRock.add(RockPlayerHealth);
		RockPlayerPic.setBounds(44, 359, 100, 99);
		
		panelRock.add(RockPlayerPic);
		BattleBackground2.setBounds(0, 0, 600, 478);
		panelRock.add(BattleBackground2);
		RockPlayerHealth.setText(String.format("Your health: %d / %d", player.charCurrentHealth, player.charHealth));
		RockPlayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rockOption = Math.abs(randomNum.nextInt()) % 3;
				/*
				 * buff check
				 */
				if (player.charPower == 1 && villain.charType != Character.Type.DISPEL) {
					rockOption = Math.abs(randomNum.nextInt()) % 2;
					player.charPower = 0;
					player.checkBuff();
					myTeam.teamBuffs.remove("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
					myTeam.buffCount--;
				}
				if (player.charPower == 2 && (villain.charType != Character.Type.DISPEL || villain.charType != Character.Type.RAIDBOSS)) {
					RockVillainChoice.setVisible(true);
					player.charPower = 0;
					player.checkBuff();
					myTeam.teamBuffs.remove("Name: Youaremydestiny|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
					myTeam.buffCount--;
				}
				if (rockOption == 0) {
					RockVillainChoice.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/RockScissors.jpeg")));
				} else if (rockOption == 1) {
					RockVillainChoice.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/RockRock.jpeg")));
				} else if (rockOption == 2) {
					RockVillainChoice.setIcon(new ImageIcon(BattleGrounds.class.getResource("/img/RockPaper.jpeg")));
				}
				if (rockPlayer == 3) {
					rockWin = 3;
				}else {
					if (rockPlayer == rockOption) {
						rockWin = 0;
					} else if ((rockPlayer == 0 && rockOption == 1) || (rockPlayer == 1 && rockOption == 2) || 
								(rockPlayer == 2 && rockOption == 0)) {
						rockWin = 1;
					} else if ((rockPlayer == 0 && rockOption == 2) || (rockPlayer == 1 && rockOption == 0) ||
								(rockPlayer == 2 && rockOption == 1)) {
						rockWin = 2;
					}
				}
				if (rockWin == 2) {
					RockResults.setText("You win!");
					RockResults.setVisible(true);
					RockVillainChoice.setVisible(true);
					villain.defeatCount++;
					if (player.charType == Character.Type.REGEN) {
						player.charCurrentHealth += 1;
						if (player.charCurrentHealth > player.charHealth) {
							player.charCurrentHealth = player.charHealth;
						}
					}
					int dmg = player.charATK - (villain.charDEF - 1);
					if (dmg <= 0) {
						dmg = 1;
					}
					villain.charCurrentHealth -= dmg;
					
					if (villain.charCurrentHealth <= 0 || villain.defeatCount >= 3) {
						villain.charCurrentHealth = 0;
						RockVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
						myTeam.doneCities++;
						RockResults.setText(String.format("Well done! You've defeated %s", villain.charName));
						if (myTeam.doneCities == myTeam.totalCities) {
							//end game credits scene
							panelRock.setVisible(false);
							GameTitleLabel.setText("CONGRATULATIONS YOU'VE DEFEATED THE BOSS!\n Click anywhere to continue!");
							GameTitleLabel.setVisible(true);
							GameEndTitle.setVisible(true);
							GameEndButton.setVisible(true);
						} else {
						RockNextCity.setVisible(true);
						myTeam.mapCount = 0;
						myTeam.teamMaps = new ArrayList<String>();
						}
						RockPlayButton.setVisible(false);
						RockNextBattleButton.setVisible(false);
					} else {
						RockVillainHealth.setText(String.format("Health: %d / %d", villain.charCurrentHealth, villain.charHealth));
						RockPlayButton.setVisible(false);
						RockNextBattleButton.setVisible(true);
						
					}
				} else if (rockWin == 3) {
					RockResults.setText("Choose something...");
					RockResults.setVisible(true);
					RockVillainChoice.setVisible(false);
				} else if (rockWin == 0) {
					RockResults.setText("It's a draw. Go again");
					RockResults.setVisible(true);
					RockVillainChoice.setVisible(true);
				} else if (rockWin == 1) {
					RockResults.setText("You lose...");
					RockResults.setVisible(true);
					RockVillainChoice.setVisible(true);
					if (player.charPower != 3 || villain.charType != Character.Type.DISPEL) {
						int dmg = villain.charATK - (player.charDEF - 1);
						if (dmg <= 0) {
							dmg = 1;
						}
						player.charCurrentHealth -= dmg;
					} else {
						player.charPower = 0;
						player.checkBuff();
						myTeam.teamBuffs.remove("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
						myTeam.buffCount--;
					}
					if (player.charCurrentHealth <= 0) {
						player.charCurrentHealth = 0;
						RockPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
						myTeam.teamHeroes.remove(BattleHeroSel.getSelectedIndex());
						BattleHeroSel.removeAllItems();
						ArrayList<String> heroComboBox = new ArrayList<String>();
						for (Character hero: myTeam.teamHeroes) {
							if (!heroComboBox.contains(hero.charName)) {
								BattleHeroSel.addItem(hero.charName);
								heroComboBox.add(hero.charName);
							}
						}
						player = new Character();
						for (Character hero: myTeam.teamHeroes) {
							if (BattleHeroSel.getSelectedIndex() == 0) {
								player = myTeam.teamHeroes.get(0);
								selectedIndex = 0;
								RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
							} else if (BattleHeroSel.getSelectedIndex() == 1) {
								player = myTeam.teamHeroes.get(1);
								selectedIndex = 1;
								RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
							} else if (BattleHeroSel.getSelectedIndex() == 2) {
								player = myTeam.teamHeroes.get(2);
								selectedIndex = 2;
								RockPlayerPic.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
							}
						}
						//check if party still has members to fight
						int counter = 0;
						for (Character hero: myTeam.teamHeroes) {
							counter++;
						}
						if (counter > 0) {
							RockPlayButton.setVisible(false);
							RockNextBattleButton.setVisible(true);
						} else {
							//end game lose
							panelRock.setVisible(false);
							GameTitleLabel.setText("Everyone's dead...we're doomed... \n Click anywhere to continue...");
							GameTitleLabel.setVisible(true);
							GameEndTitle.setVisible(true);
							GameEndButton.setVisible(true);
						}
					} else {
						RockPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
						RockPlayButton.setVisible(false);
						RockNextBattleButton.setVisible(true);
					}
				}
				panelRock.updateUI();
				rockWin = 3;
				rockPlayer = 3;
				RockPaperButton.setEnabled(true);
				RockScissorsButton.setEnabled(true);
				RockRockButton.setEnabled(true);
				
			}
		});
		RockPlayerHealth.setText(String.format("Health: %d / %d", player.charCurrentHealth, player.charHealth));
	}
}
