package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cli.Character;
import cli.WarriorsOfLight;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class for World Map GUI - 
 * greets user if user just moved into new map and sends user to base.
 * Allows user to click and move to the various locations and
 * upon exiting the locations, sends user back to base before user can select another destination.
 * No turning back if user selected villain's lair
 * @author Kai and Blue
 *
 */
public class MapLayout {
	
	public JFrame frmOasysReady;
	private ShopLayout shopLayout;
	private DenLayout denLayout;
	private BaseLayout baseLayout;
	private HospitalLayout hosLayout;
	private BattleGrounds battles;
	
	public JPanel panel = new JPanel(), panelMap = new JPanel();
	public int cityVersion = 1;
	public JButton ArrivalScreen = new JButton();
	private JButton BaseButton = new JButton("");
	private JButton NorthButton = new JButton("NORTH");
	private JButton WestButton = new JButton("WEST");
	private JButton EastButton = new JButton("EAST");
	private JButton SouthButton = new JButton("SOUTH ");
	

	/**
	 * Launch the application.
	 * @param args - main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					MapLayout window = new MapLayout(myTeam);
					window.frmOasysReady.setVisible(true);
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
	public MapLayout(WarriorsOfLight myTeam) {
		initialize(myTeam);
		frmOasysReady.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param myTeam - team of heroes
	 */
	private void initialize(WarriorsOfLight myTeam) {
		
		frmOasysReady = new JFrame();
		frmOasysReady.setFont(new Font("Courier", Font.PLAIN, 12));
		frmOasysReady.setTitle("O.A.S.Y.S - Ready Player Two");
		frmOasysReady.setBounds(100, 100, 600, 500);
		frmOasysReady.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOasysReady.getContentPane().setLayout(null);
		
		myTeam.heroesLeft = 0;
		for (@SuppressWarnings("unused") Character hero: myTeam.teamHeroes) {
			myTeam.heroesLeft++;
		}
		panelMap.setVisible(false);
		panelMap.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelMap);
		panelMap.setLayout(null);
		
		JTextField WestComment = new JTextField("-unexplored-");
		WestComment.setEditable(false);
		WestComment.setHorizontalAlignment(SwingConstants.CENTER);
		WestComment.setFont(new Font("Courier", Font.PLAIN, 11));
		WestComment.setBounds(39, 289, 100, 16);
		panelMap.add(WestComment);
		
		JTextField NorthComment = new JTextField("-unexplored-");
		NorthComment.setEditable(false);
		NorthComment.setHorizontalAlignment(SwingConstants.CENTER);
		NorthComment.setFont(new Font("Courier", Font.PLAIN, 11));
		NorthComment.setBounds(253, 121, 100, 16);
		panelMap.add(NorthComment);
		
		JTextField EastComment = new JTextField("-unexplored-");
		EastComment.setEditable(false);
		EastComment.setHorizontalAlignment(SwingConstants.CENTER);
		EastComment.setFont(new Font("Courier", Font.PLAIN, 11));
		EastComment.setBounds(463, 288, 100, 16);
		panelMap.add(EastComment);
		
		JTextField BaseComment = new JTextField("Base");
		BaseComment.setEditable(false);
		BaseComment.setHorizontalAlignment(SwingConstants.CENTER);
		BaseComment.setFont(new Font("Courier", Font.PLAIN, 11));
		BaseComment.setBounds(253, 288, 100, 16);
		panelMap.add(BaseComment);
		
		JTextField SouthComment = new JTextField("-unexplored-");
		SouthComment.setEditable(false);
		SouthComment.setHorizontalAlignment(SwingConstants.CENTER);
		SouthComment.setFont(new Font("Courier", Font.PLAIN, 11));
		SouthComment.setBounds(253, 441, 100, 16);
		panelMap.add(SouthComment);
		NorthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		NorthButton.setBackground(Color.WHITE);
		NorthButton.setBounds(253, 16, 100, 100);
		NorthButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!myTeam.teamMaps.contains("North")) {
					myTeam.teamMaps.add("North");
					if (myTeam.mapCount < 4) {
						myTeam.mapCount++;
					} else {
						myTeam.mapCount = 4;
					}
				}
				if (cityVersion == 1) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					battles = new BattleGrounds(myTeam);
					battles.panelVillain.setVisible(true);
				} else if (cityVersion == 2) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					denLayout = new DenLayout(myTeam);
					denLayout.panelDen.setVisible(true);
				}  else if (cityVersion == 3) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					shopLayout = new ShopLayout(myTeam);
					shopLayout.panelShop.setVisible(true);
				}  else if (cityVersion == 4) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					denLayout = new DenLayout(myTeam);
					denLayout.panelDen.setVisible(true);
				}  else if (cityVersion == 5) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					shopLayout = new ShopLayout(myTeam);
					shopLayout.panelShop.setVisible(true);
				}  else if (cityVersion == 6) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					hosLayout = new HospitalLayout(myTeam);
					hosLayout.panelHos.setVisible(true);
				} 
			}
		});
		panelMap.add(NorthButton);
		
		WestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!myTeam.teamMaps.contains("West")) {
					myTeam.teamMaps.add("West");
					if (myTeam.mapCount < 4) {
						myTeam.mapCount++;
					} else {
						myTeam.mapCount = 4;
					}
				}
				if (cityVersion == 1) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					shopLayout = new ShopLayout(myTeam);
					shopLayout.panelShop.setVisible(true);
				} else if (cityVersion == 2) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					hosLayout = new HospitalLayout(myTeam);
					hosLayout.panelHos.setVisible(true);
				}  else if (cityVersion == 3) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					denLayout = new DenLayout(myTeam);
					denLayout.panelDen.setVisible(true);
				}  else if (cityVersion == 4) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					hosLayout = new HospitalLayout(myTeam);
					hosLayout.panelHos.setVisible(true);
				}  else if (cityVersion == 5) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					battles = new BattleGrounds(myTeam);
					battles.panelVillain.setVisible(true);
				}  else if (cityVersion == 6) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					battles = new BattleGrounds(myTeam);
					battles.panelVillain.setVisible(true);
				} 
			}
		});
		WestButton.setBounds(39, 187, 100, 100);
		panelMap.add(WestButton);
		
		EastButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!myTeam.teamMaps.contains("East")) {
					myTeam.teamMaps.add("East");
					if (myTeam.mapCount < 4) {
						myTeam.mapCount++;
					} else {
						myTeam.mapCount = 4;
					}
				}
				if (cityVersion == 1) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					hosLayout = new HospitalLayout(myTeam);
					hosLayout.panelHos.setVisible(true);
				} else if (cityVersion == 2) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					battles = new BattleGrounds(myTeam);
					battles.panelVillain.setVisible(true);
				}  else if (cityVersion == 3) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					hosLayout = new HospitalLayout(myTeam);
					hosLayout.panelHos.setVisible(true);
				}  else if (cityVersion == 4) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					shopLayout = new ShopLayout(myTeam);
					shopLayout.panelShop.setVisible(true);
				}  else if (cityVersion == 5) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					denLayout = new DenLayout(myTeam);
					denLayout.panelDen.setVisible(true);
				}  else if (cityVersion == 6) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					denLayout = new DenLayout(myTeam);
					denLayout.panelDen.setVisible(true);
				} 
			}
		});
		EastButton.setBounds(463, 187, 100, 100);
		panelMap.add(EastButton);
		
		SouthButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!myTeam.teamMaps.contains("South")) {
					myTeam.teamMaps.add("South");
					if (myTeam.mapCount < 4) {
						myTeam.mapCount++;
					} else {
						myTeam.mapCount = 4;
					}
				}
				if (cityVersion == 1) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					denLayout = new DenLayout(myTeam);
					denLayout.panelDen.setVisible(true);
				} else if (cityVersion == 2) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					shopLayout = new ShopLayout(myTeam);
					shopLayout.panelShop.setVisible(true);
				}  else if (cityVersion == 3) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					battles = new BattleGrounds(myTeam);
					battles.panelVillain.setVisible(true);
				}  else if (cityVersion == 4) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					battles = new BattleGrounds(myTeam);
					battles.panelVillain.setVisible(true);
				}  else if (cityVersion == 5) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					hosLayout = new HospitalLayout(myTeam);
					hosLayout.panelHos.setVisible(true);
				}  else if (cityVersion == 6) {
					panelMap.setVisible(false);
					frmOasysReady.dispose();
					shopLayout = new ShopLayout(myTeam);
					shopLayout.panelShop.setVisible(true);
				} 
			}
		});
		SouthButton.setBounds(253, 340, 100, 100);
		panelMap.add(SouthButton);
		
		BaseButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/BaseSprite1.png")));
		BaseButton.setBounds(253, 187, 100, 100);
		panelMap.add(BaseButton);
		BaseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMap.setVisible(false);
				frmOasysReady.dispose();
				baseLayout = new BaseLayout(myTeam);
				baseLayout.panelBase.setVisible(true);
			}
		});		
		
		JLabel ArrivalBackground1 = new JLabel();
		ArrivalBackground1.setBounds(0, 0, 600, 478);
		panelMap.add(ArrivalBackground1);
		
		panel.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		ArrivalScreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				frmOasysReady.dispose();
				baseLayout = new BaseLayout(myTeam);
				baseLayout.panelBase.setVisible(true);
			}
		});
		JTextField ArrivalMsg = new JTextField();
		String string1 = "Welcome~";
		if (myTeam.doneCities == (myTeam.totalCities - 1)) {
			string1 = "Arrived at Shiganshina Dome";
			ArrivalMsg.setText(string1);
			cityVersion = 6;
			ArrivalScreen.setIcon(new ImageIcon(MapLayout.class.getResource("/img/TitanBackground.jpg")));
			ArrivalBackground1.setIcon(new ImageIcon(MapLayout.class.getResource("/img/TitanBackground.jpg")));
		} else {
			if (myTeam.doneCities == 0) {
				string1 = "Arrived at Palette Town";
				ArrivalMsg.setText(string1);
				cityVersion = 1;
				ArrivalScreen.setIcon(new ImageIcon(MapLayout.class.getResource("/img/PalletTownBckground.png")));
				ArrivalBackground1.setIcon(new ImageIcon(MapLayout.class.getResource("/img/PalletTownBckground.png")));
			} else if (myTeam.doneCities == 1) {
				string1 = "Arrived at Vacante City";
				ArrivalMsg.setText(string1);
				cityVersion = 2;
				ArrivalScreen.setIcon(new ImageIcon(MapLayout.class.getResource("/img/VacantCityBackground.png")));
				ArrivalBackground1.setIcon(new ImageIcon(MapLayout.class.getResource("/img/VacantCityBackground.png")));
			} else if (myTeam.doneCities == 2) {
				string1 = "Arrived at Henesis-Genesys";
				ArrivalMsg.setText(string1);
				cityVersion = 3;
				ArrivalScreen.setIcon(new ImageIcon(MapLayout.class.getResource("/img/HenesysBackground.jpg")));
				ArrivalBackground1.setIcon(new ImageIcon(MapLayout.class.getResource("/img/HenesysBackground.jpg")));
			} else if (myTeam.doneCities == 3) {
				string1 = "Arrived at Got-them City";
				ArrivalMsg.setText(string1);
				cityVersion = 4;
				ArrivalScreen.setIcon(new ImageIcon(MapLayout.class.getResource("/img/GothamBackground.jpg")));
				ArrivalBackground1.setIcon(new ImageIcon(MapLayout.class.getResource("/img/GothamBackground.jpg")));
			} else if (myTeam.doneCities == 4) {
				string1 = "Arrived at Summoner's Bay";
				ArrivalMsg.setText(string1);
				cityVersion = 5;
				ArrivalScreen.setIcon(new ImageIcon(MapLayout.class.getResource("/img/RiftBackground.jpg")));
				ArrivalBackground1.setIcon(new ImageIcon(MapLayout.class.getResource("/img/RiftBackground.jpg")));
			}
		}
		
		
		ArrivalMsg.setEditable(false);
		ArrivalMsg.setHorizontalAlignment(SwingConstants.CENTER);
		ArrivalMsg.setFont(new Font("Courier", Font.BOLD, 22));
		ArrivalMsg.setBounds(12, 57, 576, 82);
		panel.add(ArrivalMsg);
		
		ArrivalScreen.setBounds(0, 0, 600, 478);
		panel.add(ArrivalScreen);
		
		//checks and updates map - start
		for (String map: myTeam.teamMaps) {
			if (map == "North") {
				if (cityVersion == 1) {
					NorthButton.setText(null);
					NorthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/LairSprite1.png")));
					NorthComment.setText("Villain's Lair");
				} else if (cityVersion == 2) {
					NorthButton.setText(null);
					NorthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/DenSprite1.png")));
					NorthComment.setText("Power-Up Den");
				} else if (cityVersion == 3) {
					NorthButton.setText(null);
					NorthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopSprite1.png")));
					NorthComment.setText("Item Shop");
				} else if (cityVersion == 4) {
					NorthButton.setText(null);
					NorthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/DenSprite1.png")));
					NorthComment.setText("Power-Up Den");
				} else if (cityVersion == 5) {
					NorthButton.setText(null);
					NorthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopSprite1.png")));
					NorthComment.setText("Item Shop");
				} else if (cityVersion == 6) {
					NorthButton.setText(null);
					NorthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/HospitalSprite1.png")));
					NorthComment.setText("Hospital");
				} 
			} else if (map == "West") {
				if (cityVersion == 1) {
					WestButton.setText(null);
					WestButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopSprite1.png")));
					WestComment.setText("Item Shop");
				} else if (cityVersion == 2) {
					WestButton.setText(null);
					WestButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/HospitalSprite1.png")));
					WestComment.setText("Hospital");
				} else if (cityVersion == 3) {
					WestButton.setText(null);
					WestButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/DenSprite1.png")));
					WestComment.setText("Power-Up Den");
				} else if (cityVersion == 4) {
					WestButton.setText(null);
					WestButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/HospitalSprite1.png")));
					WestComment.setText("Hospital");
				} else if (cityVersion == 5) {
					WestButton.setText(null);
					WestButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/LairSprite1.png")));
					WestComment.setText("Villain's Lair");
				} else if (cityVersion == 6) {
					WestButton.setText(null);
					WestButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/LairSprite1.png")));
					WestComment.setText("Final Boss Fight");
				}
			} else if (map == "East") {
				if (cityVersion == 1) {
					EastButton.setText(null);
					EastButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/HospitalSprite1.png")));
					EastComment.setText("Hospital");
				} else if (cityVersion == 2) {
					EastButton.setText(null);
					EastButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/LairSprite1.png")));
					EastComment.setText("Villain's Lair");
				} else if (cityVersion == 3) {
					EastButton.setText(null);
					EastButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/HospitalSprite1.png")));
					EastComment.setText("Hospital");
				} else if (cityVersion == 4) {
					EastButton.setText(null);
					EastButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopSprite1.png")));
					EastComment.setText("Item Shop");
				} else if (cityVersion == 5) {
					EastButton.setText(null);
					EastButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/DenSprite1.png")));
					EastComment.setText("Power-Up Den");
				} else if (cityVersion == 6) {
					EastButton.setText(null);
					EastButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/DenSprite1.png")));
					EastComment.setText("Power-Up Den");
				}
			} else if (map == "South") {
				if (cityVersion == 1) {
					SouthButton.setText(null);
					SouthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/DenSprite1.png")));
					SouthComment.setText("Power-Up Den");
				} else if (cityVersion == 2) {
					SouthButton.setText(null);
					SouthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopSprite1.png")));
					SouthComment.setText("Item Shop");
				} else if (cityVersion == 3) {
					SouthButton.setText(null);
					SouthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/LairSprite1.png")));
					SouthComment.setText("Villain's Lair");
				} else if (cityVersion == 4) {
					SouthButton.setText(null);
					SouthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/LairSprite1.png")));
					SouthComment.setText("Villain's Lair");
				} else if (cityVersion == 5) {
					SouthButton.setText(null);
					SouthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/HospitalSprite1.png")));
					SouthComment.setText("Hospital");
				} else if (cityVersion == 6) {
					SouthButton.setText(null);
					SouthButton.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopSprite1.png")));
					SouthComment.setText("Item Shop");
				}
			}
		} //checks and updates map - end
	}
}
