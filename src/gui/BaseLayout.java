package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import cli.Character;
import cli.WarriorsOfLight;

/**
 * Class for Base GUI - 
 * Generates random events whenever user leaves and enters the base.
 * Starting point for all cities.
 * User can go to world map to move to another location or choose to
 * look at team stats and character attributes.
 * User can also save file (not yet implemented in this current version)
 * @author Kai and Blue
 *
 */
public class BaseLayout {

	private JFrame frmOasysReady;
	
	public JPanel panelBase = new JPanel();
	
	private JLabel BaseBackground = new JLabel();
	private JButton TeamAttButton = new JButton("View Team"), CheckMapButton = new JButton("To World Map");
	private JTextField BaseTitle1 = new JTextField("This is your secret hideout"), 
					   BaseTitle2 = new JTextField("What do you want to do?");
	private JTextPane BaseRand = new JTextPane(); //text for random events
	
	Random randomNum = new Random();
	private int randEvent = Math.abs(randomNum.nextInt()) % 10;

	/**
	 * Launch the application.
	 * @param args - main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					BaseLayout window = new BaseLayout(myTeam);
					window.frmOasysReady.setVisible(true);
					window.panelBase.setVisible(true);
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
	public BaseLayout(WarriorsOfLight myTeam) {
		initialize(myTeam);
		frmOasysReady.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param myTeam - team of heroes
	 */
	@SuppressWarnings("unused")
	private void initialize(WarriorsOfLight myTeam) {
		frmOasysReady = new JFrame();
		frmOasysReady.setFont(new Font("Courier", Font.PLAIN, 12));
		frmOasysReady.setTitle("O.A.S.Y.S - Ready Player Two");
		frmOasysReady.setBounds(100, 100, 600, 500);
		frmOasysReady.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOasysReady.getContentPane().setLayout(null);
		
		/*
		 * check for navigator skill
		 */
		
		for (Character hero: myTeam.teamHeroes) {
			if (hero.charType == Character.Type.NAVIGATOR) {
				if (!myTeam.teamMaps.contains("North")) {
					myTeam.teamMaps.add("North");
				} else if (!myTeam.teamMaps.contains("West")) {
					myTeam.teamMaps.add("West");
				} else if (!myTeam.teamMaps.contains("East")) {
					myTeam.teamMaps.add("East");
				} else if (!myTeam.teamMaps.contains("South")) {
					myTeam.teamMaps.add("South");
				}
				myTeam.mapCount = 4;	
			}	
		}
		
		/*
		 * team strength checker
		 */
		myTeam.heroesLeft = 0;
		for (Character hero: myTeam.teamHeroes) {
			myTeam.heroesLeft++;
		}
		
		/*
		 * simple map count checker
		 */
		if (myTeam.mapCount > 4) {
			myTeam.mapCount = 4;
		} else if (myTeam.mapCount <= 0) {
			myTeam.mapCount = 0;
		}
		
		/*
		 * Sets background for power-up den according to current city
		 */
		if (myTeam.doneCities == (myTeam.totalCities - 1)) {
			BaseBackground.setIcon(new ImageIcon(BaseLayout.class.getResource("/img/BaseTitan.jpg")));
		} else {
			if (myTeam.doneCities == 0) {
				BaseBackground.setIcon(new ImageIcon(BaseLayout.class.getResource("/img/BasePalletTown.png")));
			} else if (myTeam.doneCities == 1) {
				BaseBackground.setIcon(new ImageIcon(BaseLayout.class.getResource("/img/BaseVacantCity.jpg")));
			} else if (myTeam.doneCities == 2) {
				BaseBackground.setIcon(new ImageIcon(BaseLayout.class.getResource("/img/BaseHenesys.jpg")));
			} else if (myTeam.doneCities == 3) {
				BaseBackground.setIcon(new ImageIcon(BaseLayout.class.getResource("/img/BaseGotham.jpg")));
			} else if (myTeam.doneCities == 4) {
				BaseBackground.setIcon(new ImageIcon(BaseLayout.class.getResource("/img/BaseRift.jpg")));
			}
		}
		
		panelBase.setVisible(false);
		panelBase.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelBase);
		panelBase.setLayout(null);
		
		CheckMapButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelBase.setVisible(false);
				frmOasysReady.dispose();
				MapLayout mapLay = new MapLayout(myTeam);
				mapLay.panel.setVisible(false);
				mapLay.panelMap.setVisible(true);
			}
		});
		CheckMapButton.setBounds(211, 350, 147, 29);
		panelBase.add(CheckMapButton);
		
		TeamAttButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//simple map count checker
				if (myTeam.mapCount > 4) {
					myTeam.mapCount = 4;
				} else if (myTeam.mapCount <= 0) {
					myTeam.mapCount = 0;
				}
				
				panelBase.setVisible(false);
				frmOasysReady.dispose();
				TeamInfo teamInfo = new TeamInfo(0, myTeam);
				teamInfo.panel.setVisible(true);
			}
		});
		BaseRand.setEditable(false);
		BaseRand.setText(" Calm day today...(Inb4 storm lmao)  Feels good when nothing gets stolen...\n Or bad when nothing has been found...Boooring...");
		
		//random events
		randEvent = Math.abs(randomNum.nextInt()) % 6;
		if (randEvent == 1) {
			if (!myTeam.teamItems.isEmpty()) {
				String lost;
				int randItem = Math.abs(randomNum.nextInt()) % 3;
				if (randItem == 0) {
					lost = "Small Salve";
					if (myTeam.teamItems.contains("Salve")) {
						myTeam.itemCount--;
						BaseRand.setText(String.format(" Who the F didn't lock the door??? Sheez!\n (a minion has stolen: %s)", lost));
						myTeam.teamItems.remove("Name: Small Salve|Time taken to heal: 10 seconds|");
					} else {
						BaseRand.setText(" Someone wanted to steal something but we're too broke. HAH hah.. ha...sobs");
					}
				} else if (randItem == 1) {
					lost = "Mighty Morphine";
					if (myTeam.teamItems.contains("Morphine")) {
						myTeam.itemCount--;
						BaseRand.setText(String.format(" Who the F didn't lock the door??? Sheez!\n (a minion has stolen: %s)", lost));
						myTeam.teamItems.remove("Name: Mighty Morphine|Time taken to heal: 5 seconds|");
					} else {
						BaseRand.setText(" Someone wanted to steal something but we're too broke. HAH hah.. ha...sobs");
					}
				} else {
					lost = "Fountain of Life";
					if (myTeam.teamItems.contains("Fountain")) {
						myTeam.itemCount--;
						BaseRand.setText(String.format(" Who the F didn't lock the door??? Sheez!\n (a minion has stolen: %s)", lost));
						myTeam.teamItems.remove("Name: Fountain of Life|Time taken to heal: 3 seconds|");
					} else {
						BaseRand.setText(" Someone wanted to steal something but we're too broke. HAH hah.. ha...sobs");
					}
				}
			}
		} else if (randEvent == 2) {
			if (!myTeam.teamBuffs.isEmpty()) {
				String lost;
				int randItem = Math.abs(randomNum.nextInt()) % 3;
				if (randItem == 0) {
					lost = "50-50 Lemon Squeezy";
					if (myTeam.teamBuffs.contains("Lemon")) {
						myTeam.teamBuffs.remove("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
						myTeam.buffCount--;
						BaseRand.setText(String.format(" Who the F didn't lock the door??? Sheez!\n (a minion has stolen: %s)", lost));
					} else {
						BaseRand.setText(" Someone wanted to steal something but we're too broke. HAH hah.. ha...sobs");
					}
				} else if (randItem == 1) {
					lost = "Youaremydestiny";
						if (myTeam.teamBuffs.contains("destiny")) {
							BaseRand.setText(String.format(" Who the F didn't lock the door??? Sheez!\n (a minion has stolen: %s)", lost));
							myTeam.buffCount--;
							myTeam.teamItems.remove("Youaremydestiny|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
					} else {
						BaseRand.setText(" Someone wanted to steal something but we're too broke. HAH hah.. ha...sobs");
					}
				} else {
					lost = "Iron Maiden Potent";
					if (myTeam.teamBuffs.contains("Maiden")) {
						myTeam.teamBuffs.remove("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
						myTeam.buffCount--;
						BaseRand.setText(String.format(" Who the F didn't lock the door??? Sheez!\n (a minion has stolen: %s)", lost));
					} else {
						BaseRand.setText(" Someone wanted to steal something but we're too broke. HAH hah.. ha...sobs");
					}
				}
			}
		} else if (randEvent == 3) {
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
			BaseRand.setText(String.format(" Wow look at what doggo fetched us today!\n (received: %s)", gain));
		} else if (randEvent == 4) {
			String gain;
			int randItem = Math.abs(randomNum.nextInt()) % 3;
			if (randItem == 0) {
				gain = "50-50 Lemon Squeezy";
				myTeam.teamBuffs.add("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
			} else if (randItem == 1) {
				gain = "Youaremydestiny";
				myTeam.teamBuffs.add("Name: Youaremydestiny|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
			} else {
				gain = "Iron Maiden Potent";
				myTeam.teamBuffs.add("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
			}
			myTeam.buffCount++;
			BaseRand.setText(String.format(" Wow look at what doggo fetched us today!\n (received: %s)", gain));
		}
		BaseRand.setBounds(33, 214, 522, 62);
		panelBase.add(BaseRand);
		TeamAttButton.setBounds(225, 288, 117, 29);
		panelBase.add(TeamAttButton);
		
		BaseTitle2.setEditable(false);
		BaseTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		BaseTitle2.setFont(new Font("Courier", Font.BOLD, 21));
		BaseTitle2.setBounds(124, 125, 332, 29);
		panelBase.add(BaseTitle2);
		
		BaseTitle1.setEditable(false);
		BaseTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		BaseTitle1.setFont(new Font("Courier", Font.BOLD, 21));
		BaseTitle1.setBounds(89, 65, 387, 29);
		panelBase.add(BaseTitle1);
		
		JButton BaseSaveGame = new JButton("Save Game");
		BaseSaveGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * We didn't have time to implement this section
				 * but the gist of it is to create and write a text file 
				 * created by clicking on the "Save Game" by writing the
				 * key data from into the text file
				 * into a team by using the WarriorsOfLight and Character constructors
				 */
			}
		});
		BaseSaveGame.setBounds(225, 418, 117, 29);
		panelBase.add(BaseSaveGame);
		
		BaseBackground.setBounds(0, 0, 600, 478);
		panelBase.add(BaseBackground);
	}
}
