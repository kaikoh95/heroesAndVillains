package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
 * Class for Shop GUI - 
 * allows user to buy healing item, power up buffs and maps.
 * Prompts error message if not enough gold or map that user is trying to buy already exists.
 * Otherwise, buys and adds into the respective inventory
 * and reduces gold by the cost price
 * @author Kai and Blue
 */
public class ShopLayout {

	private JFrame frmOasysReady;
	
	public JPanel panelShop = new JPanel();
	private JLabel ShopBackground = new JLabel("");
	private int shopCost = 0;
	private JTextPane ShopItemDes = new JTextPane();
	private JTextField ShopGold, ShopGreetings1 = new JTextField(), ShopGreetings2 = new JTextField(),
					   ShopNotEnough = new JTextField(), ShopBought = new JTextField();
	private JButton ShopViewTeamButton = new JButton("View Team"), ShopItem2 = new JButton(""),
				    ShopBuyButton1 = new JButton("Buy Me"), ShopItem3 = new JButton(""), 
			 	    ShopItem1 = new JButton(""), ShopBuff2 = new JButton(""), 
			 	    ShopBuff3 = new JButton(""), ShopBuff1 = new JButton(""), 
			 	    ShopMapW = new JButton(""), ShopMapE = new JButton(""), 
			 	    ShopMapN = new JButton(""), ShopMapS = new JButton("");
	private String shopSel = "", shopStr = "";	

	/**
	 * Launch the application.
	 * @param args - for main function
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					ShopLayout window = new ShopLayout(myTeam);
					window.frmOasysReady.setVisible(true);
					window.panelShop.setVisible(true);
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
	public ShopLayout(WarriorsOfLight myTeam) {
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
		
		/*
		 * simple map count checker
		 */
		if (myTeam.mapCount > 4) {
			myTeam.mapCount = 4;
		} else if (myTeam.mapCount <= 0) {
			myTeam.mapCount = 0;
		}
		
		/*
		 * Sets background for item shop according to current city
		 */
		if (myTeam.doneCities == (myTeam.totalCities - 1)) {
			ShopBackground.setIcon(new ImageIcon(ShopLayout.class.getResource("/img/ShopTitan.jpg")));
		} else {
			if (myTeam.doneCities == 0) {
				ShopBackground.setIcon(new ImageIcon(ShopLayout.class.getResource("/img/ShopPalletTown.jpg")));
			} else if (myTeam.doneCities == 1) {
				ShopBackground.setIcon(new ImageIcon(ShopLayout.class.getResource("/img/ShopVacantCity.png")));
			} else if (myTeam.doneCities == 2) {
				ShopBackground.setIcon(new ImageIcon(ShopLayout.class.getResource("/img/ShopHenesys.png")));
			} else if (myTeam.doneCities == 3) {
				ShopBackground.setIcon(new ImageIcon(ShopLayout.class.getResource("/img/ShopGotham.jpg")));
			} else if (myTeam.doneCities == 4) {
				ShopBackground.setIcon(new ImageIcon(ShopLayout.class.getResource("/img/ShopRift.jpg")));
			}
		}
		
		ShopBought.setEditable(false);
		ShopBought.setVisible(false);
		ShopBought.setFont(new Font("Courier", Font.PLAIN, 9));
		
		ShopBought.setText("Bought: ");
		ShopBought.setBounds(320, 433, 229, 26);
		ShopBought.setColumns(10);
		
		ShopNotEnough.setVisible(false);
		ShopNotEnough.setFont(new Font("Courier", Font.PLAIN, 8));
		ShopNotEnough.setText("NOT ENOUGH GOLD!");
		ShopNotEnough.setBounds(372, 349, 147, 26);
		ShopNotEnough.setColumns(10);
		
		JButton ShopBuyButton = new JButton("Buy something");
		JButton ShopExitButton2 = new JButton("Nah, I'm good");
		ShopExitButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShopBought.setVisible(false);
				ShopNotEnough.setVisible(false);
				ShopBuyButton.setVisible(true);
				ShopExitButton2.setVisible(false);
				ShopItemDes.setVisible(false);
				ShopViewTeamButton.setVisible(true);
				ShopBuyButton1.setVisible(false);
				ShopItem1.setVisible(false);
				ShopItem2.setVisible(false);
				ShopItem3.setVisible(false);
				ShopBuff1.setVisible(false);
				ShopBuff2.setVisible(false);
				ShopBuff3.setVisible(false);
				ShopMapN.setVisible(false);
				ShopMapS.setVisible(false);
				ShopMapE.setVisible(false);
				ShopMapW.setVisible(false);
				ShopItem1.setEnabled(true);
				ShopItem2.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopMapW.setEnabled(true);
				
			}
		});
		ShopExitButton2.setVisible(false);
		ShopExitButton2.setBounds(223, 380, 147, 29);
		panelShop.setVisible(false);
		panelShop.add(ShopExitButton2);
		panelShop.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelShop);
		panelShop.setLayout(null);		
		
		ShopBuyButton.setBounds(352, 294, 156, 29);
		panelShop.add(ShopBuyButton);
		ShopViewTeamButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelShop.setVisible(false);
				frmOasysReady.setVisible(false);
				TeamInfo teamInfo = new TeamInfo(3, myTeam);
				teamInfo.panel.setVisible(true);
			}
		});
		ShopViewTeamButton.setBounds(112, 294, 117, 29);
		
		panelShop.add(ShopViewTeamButton);
		
		ShopGreetings1.setEditable(false);
		ShopGreetings1.setHorizontalAlignment(SwingConstants.CENTER);
		ShopGreetings1.setFont(new Font("Courier", Font.BOLD, 20));
		ShopGreetings1.setText("Good Day, mate! How can I help?");
		ShopGreetings1.setBounds(110, 61, 398, 35);
		panelShop.add(ShopGreetings1);
		ShopGreetings1.setColumns(10);
		
		JButton ShopExitButton = new JButton("Nah, I'm good");

		ShopBuyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShopBought.setVisible(false);
				ShopNotEnough.setVisible(false);
				ShopBuyButton.setVisible(false);
				ShopViewTeamButton.setVisible(false);
				ShopExitButton2.setVisible(true);
				ShopBuyButton1.setVisible(true);
				ShopItem1.setVisible(true);
				ShopItem2.setVisible(true);
				ShopItem3.setVisible(true);
				ShopBuff1.setVisible(true);
				ShopBuff2.setVisible(true);
				ShopBuff3.setVisible(true);
				ShopMapN.setVisible(true);
				ShopMapS.setVisible(true);
				ShopMapE.setVisible(true);
				ShopMapW.setVisible(true);
			}
		});
		ShopGreetings2.setText("-the only item shop you'll ever need-");
		ShopGreetings2.setHorizontalAlignment(SwingConstants.CENTER);
		ShopGreetings2.setFont(new Font("Courier", Font.BOLD, 10));
		ShopGreetings2.setEditable(false);
		ShopGreetings2.setColumns(10);
		ShopGreetings2.setBounds(243, 98, 265, 29);
		
		panelShop.add(ShopGreetings2);
		ShopExitButton.setBounds(223, 380, 147, 29);
		panelShop.add(ShopExitButton);
		
		ShopItem2.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopItemMorphine.jpg")));
		ShopItem2.setVisible(false);
		ShopItem2.setBounds(393, 160, 50, 50);
		panelShop.add(ShopItem2);
		ShopItem2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: Mighty Morphine - Price: 480 (was 600)\n Time taken to heal: 5 seconds");
						shopCost = 480;
						break;
					} else {
						ShopItemDes.setText(" Name: Mighty Morphine - Price: 600\n Time taken to heal: 5 seconds");
						shopCost = 600;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "Morphine";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem1.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopMapW.setEnabled(true);
				ShopItem2.setEnabled(false);
			}
		});
		
		ShopItem3.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopItemFountain.jpg")));
		ShopItem3.setVisible(false);
		ShopItem3.setBounds(469, 160, 50, 50);
		panelShop.add(ShopItem3);
		ShopItem3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: Fountain of Life - Price: 960 (was 1200)\n Time taken to heal: 3 seconds");
						shopCost = 960;
						break;
					} else {
						ShopItemDes.setText(" Name: Fountain of Life - Price: 1200\n Time taken to heal: 3 seconds");
						shopCost = 1200;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "Fountain";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem1.setEnabled(true);
				ShopItem2.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopMapW.setEnabled(true);
				ShopItem3.setEnabled(false);
			}
		});
		
		ShopItem1.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopItemSalve.jpg")));
		ShopItem1.setVisible(false);
		ShopItem1.setBounds(320, 160, 50, 50);
		panelShop.add(ShopItem1);
		ShopItem1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: Small Salve - Price: 80 (was 100)\n Time taken to heal: 10 seconds");
						shopCost = 80;
						break;
					} else {
						ShopItemDes.setText(" Name: Small Salve - Price: 100\n Time taken to heal: 10 seconds");
						shopCost = 100;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "Salve";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem2.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopMapW.setEnabled(true);
				ShopItem1.setEnabled(false);
			}
		});
		
		ShopBuff2.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopBuffFuture.jpg")));
		ShopBuff2.setVisible(false);
		ShopBuff2.setBounds(147, 160, 50, 50);
		panelShop.add(ShopBuff2);
		ShopBuff2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: Youaremydestiny - Price: 700 (was 1000)\n Sees the villain's choice for the next round\n (Unusable for dice roll rounds and Final Boss fight)");
						shopCost = 700;
						break;
					} else {
						ShopItemDes.setText(" Name: Youaremydestiny - Price: 1000\n Sees the villain's choice for the next round\n (Unusable for dice roll rounds and Final Boss fight)");
						shopCost = 1000;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "Destiny";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem1.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopItem2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopMapW.setEnabled(true);
				ShopBuff2.setEnabled(false);
			}
		});
		
		ShopBuff3.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopBuffIron.jpg")));
		ShopBuff3.setVisible(false);
		ShopBuff3.setBounds(223, 160, 50, 50);
		panelShop.add(ShopBuff3);
		ShopBuff3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: Iron Maiden Potent - Price: 350 (was 500)\n Takes no damage when you lose the next round");
						shopCost = 350;
						break;
					} else {
						ShopItemDes.setText(" Name: Iron Maiden Potent - Price: 500\n Takes no damage when you lose the next round");
						shopCost = 500;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "Iron";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem1.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopItem2.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopMapW.setEnabled(true);
				ShopBuff3.setEnabled(false);
			}
		});
	
		
		ShopBuff1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: 50-50 Lemon Squeezy - Price: 210 (was 300)\n 50% chance of winning the next round");
						shopCost = 210;
						break;
					} else {
						ShopItemDes.setText(" Name: 50-50 Lemon Squeezy - Price: 300\n 50% chance of winning the next round");
						shopCost = 300;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "Lemon";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem1.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopItem2.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopMapW.setEnabled(true);
				ShopBuff1.setEnabled(false);
			}
		});
		ShopBuff1.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopBuffCritical.jpeg")));
		ShopBuff1.setVisible(false);
		ShopBuff1.setBounds(74, 160, 50, 50);
		panelShop.add(ShopBuff1);
		
		ShopMapW.setVisible(false);
		ShopMapW.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopMaps.jpg")));
		ShopMapW.setBounds(393, 232, 50, 50);
		panelShop.add(ShopMapW);
		ShopMapW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: West Map - Price: 160 (was 200)\n Discovers West of city");
						shopCost = 160;
						break;
					} else {
						ShopItemDes.setText(" Name: West Map - Price: 200\n Discovers West of city");
						shopCost = 200;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "West";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem1.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopItem2.setEnabled(true);
				ShopMapW.setEnabled(false);
			}
		});
		
		ShopMapE.setVisible(false);
		ShopMapE.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopMaps.jpg")));
		ShopMapE.setBounds(320, 232, 50, 50);
		panelShop.add(ShopMapE);
		ShopMapE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: East Map - Price: 160 (was 200)\n Discovers East of city");
						shopCost = 160;
						break;
					} else {
						ShopItemDes.setText(" Name: East Map - Price: 200\n Discovers East of city");
						shopCost = 200;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "East";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem1.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopItem2.setEnabled(true);
				ShopMapW.setEnabled(true);
				ShopMapE.setEnabled(false);
			}
		});
		
		ShopMapN.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopMaps.jpg")));
		ShopMapN.setVisible(false);
		ShopMapN.setBounds(147, 232, 50, 50);
		panelShop.add(ShopMapN);
		ShopMapN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: North Map - Price: 160 (was 200)\n Discovers North of city");
						shopCost = 160;
						break;
					} else {
						ShopItemDes.setText(" Name: North Map - Price: 200\n Discovers North of city");
						shopCost = 200;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "North";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem1.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopItem2.setEnabled(true);
				ShopMapS.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopMapW.setEnabled(true);
				ShopMapN.setEnabled(false);
			}
		});
		
		ShopMapS.setVisible(false);
		ShopMapS.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopMaps.jpg")));
		ShopMapS.setBounds(223, 232, 50, 50);
		panelShop.add(ShopMapS);
		ShopMapS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Character hero: myTeam.teamHeroes) {
					if (hero.charType == Character.Type.LUCKY) {
						ShopItemDes.setText(" Name: South Map - Price: 160 (was 200)\n Discovers South of city");
						shopCost = 160;
						break;
					} else {
						ShopItemDes.setText(" Name: South Map - Price: 200\n Discovers South of city");
						shopCost = 200;
					}
				}
				ShopBought.setVisible(false);
				shopSel = "South";
				ShopNotEnough.setVisible(false);
				ShopBuyButton1.setEnabled(true);
				ShopItemDes.setVisible(true);
				ShopItem1.setEnabled(true);
				ShopItem3.setEnabled(true);
				ShopBuff1.setEnabled(true);
				ShopBuff2.setEnabled(true);
				ShopBuff3.setEnabled(true);
				ShopMapN.setEnabled(true);
				ShopItem2.setEnabled(true);
				ShopMapE.setEnabled(true);
				ShopMapW.setEnabled(true);
				ShopMapS.setEnabled(false);
			}
		});
		ShopItemDes.setVisible(false);
		ShopItemDes.setFont(new Font("Courier", Font.PLAIN, 11));
		ShopItemDes.setEditable(false);
		ShopItemDes.setBounds(147, 300, 296, 43);
		panelShop.add(ShopItemDes);
		ShopBuyButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((myTeam.teamMaps.contains("North") && shopSel == "North") || (myTeam.teamMaps.contains("South") && shopSel == "South") || 
				    (myTeam.teamMaps.contains("West") && shopSel == "West") || (myTeam.teamMaps.contains("East") && shopSel == "East")) {
					ShopNotEnough.setText("Already have this!");
					ShopNotEnough.setVisible(true);
					ShopBought.setVisible(false);
				} else {
					if (myTeam.teamGold - shopCost >= 0) {
						myTeam.teamGold -= shopCost;
						ShopGold.setText(String.format("Gold: %d", myTeam.teamGold));
						if (shopSel == "North") {
							myTeam.teamMaps.add("North");
							if (myTeam.mapCount < 4) {
								myTeam.mapCount++;
							} else {
								myTeam.mapCount = 4;
							}
							shopStr = "Bought: Map Piece - North";
						} else if (shopSel == "South") {
							myTeam.teamMaps.add("South");
							if (myTeam.mapCount < 4) {
								myTeam.mapCount++;
							} else {
								myTeam.mapCount = 4;
							}
							shopStr = "Bought: Map Piece - South";
						}  else if (shopSel == "East") {
							myTeam.teamMaps.add("East");
							shopStr = "Bought: Map Piece - East";
							if (myTeam.mapCount < 4) {
								myTeam.mapCount++;
							} else {
								myTeam.mapCount = 4;
							}
						}  else if (shopSel == "West") {
							myTeam.teamMaps.add("West");
							shopStr = "Bought: Map Piece - West";
							if (myTeam.mapCount < 4) {
								myTeam.mapCount++;
							} else {
								myTeam.mapCount = 4;
							}
						}  else if (shopSel == "Salve") {
							myTeam.itemCount++;
							myTeam.teamItems.add("Name: Small Salve|Time taken to heal: 10 seconds|");
							shopStr = "Bought: Item - Small Salve";
						}  else if (shopSel == "Morphine") {
							myTeam.itemCount++;
							shopStr = "Bought: Item - Mighty Morphine";
							myTeam.teamItems.add("Name: Mighty Morphine|Time taken to heal: 5 seconds|");
						}  else if (shopSel == "Fountain") {
							myTeam.itemCount++;
							shopStr = "Bought: Item - Fountain of Life";
							myTeam.teamItems.add("Name: Fountain of Life|Time taken to heal: 3 seconds|");
						}  else if (shopSel == "Lemon") {
							myTeam.buffCount++;
							shopStr = "Bought: Item - 50-50 Lemon Squeezy";
							myTeam.teamBuffs.add("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
						}  else if (shopSel == "Iron") {
							myTeam.buffCount++;
							shopStr = "Bought: Item - Iron Maiden Potent";
							myTeam.teamBuffs.add("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
						}  else if (shopSel == "Destiny") {
							myTeam.buffCount++;
							shopStr = "Bought: Item - Youaremydestiny";
							myTeam.teamBuffs.add("Name: Youaremydestiny|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
						} 
						ShopBought.setText(shopStr);
						ShopBought.setVisible(true);
						ShopNotEnough.setVisible(false);
						ShopItem1.setEnabled(true);
						ShopItem2.setEnabled(true);
						ShopItem3.setEnabled(true);
						ShopBuff1.setEnabled(true);
						ShopBuff2.setEnabled(true);
						ShopBuff3.setEnabled(true);
						ShopMapN.setEnabled(true);
						ShopMapS.setEnabled(true);
						ShopMapE.setEnabled(true);
						ShopMapW.setEnabled(true);
					} else {
						ShopBought.setVisible(false);
						ShopNotEnough.setText("Not enough gold!");
						ShopNotEnough.setVisible(true);
					}
				}	
			}
		});
		
		ShopBuyButton1.setVisible(false);
		ShopBuyButton1.setEnabled(false);
		ShopBuyButton1.setBounds(243, 349, 117, 29);
		panelShop.add(ShopBuyButton1);
		
		ShopGold = new JTextField();
		ShopGold.setText(String.format("Gold: %d", myTeam.teamGold));
		ShopGold.setFont(new Font("Courier", Font.BOLD, 10));
		ShopGold.setEditable(false);
		ShopGold.setColumns(10);
		ShopGold.setBounds(112, 98, 100, 29);
		
		ShopExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ShopBought.setVisible(false);
				ShopNotEnough.setVisible(false);
				panelShop.setVisible(false);
				ShopBuyButton.setVisible(true);
				ShopItemDes.setVisible(false);
				ShopViewTeamButton.setVisible(true);
				ShopBuyButton1.setVisible(false);
				ShopItem1.setVisible(false);
				ShopItem2.setVisible(false);
				ShopItem3.setVisible(false);
				ShopBuff1.setVisible(false);
				ShopBuff2.setVisible(false);
				ShopBuff3.setVisible(false);
				ShopMapN.setVisible(false);
				ShopMapS.setVisible(false);
				ShopMapE.setVisible(false);
				ShopMapW.setVisible(false);	
				
				frmOasysReady.dispose();
				BaseLayout baseLay = new BaseLayout(myTeam);
				baseLay.panelBase.setVisible(true);
			}
		});
		
		
		/*
		 * sets up panel for JComponents
		 */
		panelShop.add(ShopGold);
		panelShop.updateUI();
		panelShop.add(ShopNotEnough);
		panelShop.add(ShopBought);
		
		ShopBackground.setBounds(0, 0, 600, 478);
		panelShop.add(ShopBackground);
	}

}
