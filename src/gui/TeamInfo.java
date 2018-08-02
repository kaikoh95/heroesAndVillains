package gui;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cli.WarriorsOfLight;
import cli.Character;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

/**
 * Class for team attributes and hero attributes.
 * Note: do not go into this page without any heroes otherwise it'll have errors.
 * Main page shows team name, gold, maps owned, cities cleared, items owned, buffs owned, heroes left.
 * Clicking hero icons will show detailed hero attributes
 * @author Kai and Blue
 *
 */
public class TeamInfo {

	private JFrame frmOasysReady;
	public JPanel panel = new JPanel(), panelHero1 = new JPanel(), panelHero2 = new JPanel(), panelHero3 = new JPanel();
	private Border border = BorderFactory.createLineBorder(Color.GREEN, 5);
	private JLabel Background1, Border1, Border2, TeamSizeLabel, Border3, 
		           GoldLabel, Border4, Border5, ItemBagLabel, PowerBag, 
		           MapBag, CityCountLabel;
	private JTextPane ItemBag, BuffBag;
	private JButton HeroButton2, HeroButton1, HeroButton3;
	
	private int item1 = 0, item2 = 0, item3 = 0, buff1 = 0, buff2 = 0, buff3 = 0;
	private JButton Hero1Exit;
	private JLabel Hero1Background;
	private JButton Hero2Exit;
	private JLabel Hero2Background;
	private JButton Hero3Exit;
	private JLabel Hero3Background;
	private JLabel Hero1Icon;
	private JLabel Hero2Icon;
	private JLabel Hero3Icon;

	/**
	 * Launch the application.
	 * @param args - for main function
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					TeamInfo window = new TeamInfo(0, myTeam);
					window.frmOasysReady.setVisible(true);
					window.panel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * create application, checks previous frame if is from shop, base, den or hospital
	 * @param prevFrame - previous screen
	 * @param myTeam - team of heroes used
	 */
	public TeamInfo(int prevFrame, WarriorsOfLight myTeam) {
		initialize(prevFrame, myTeam);
		frmOasysReady.setVisible(true);
	}

	/**
	 * initialize contents of frame
	 * @param prevFrame - previous screen
	 * @param myTeam - team of heroes used
	 */
	@SuppressWarnings("unused")
	private void initialize(int prevFrame, WarriorsOfLight myTeam) {
		frmOasysReady = new JFrame();
		frmOasysReady.setFont(new Font("Courier", Font.PLAIN, 12));
		frmOasysReady.setTitle("O.A.S.Y.S - Ready Player Two");
		frmOasysReady.setBounds(100, 100, 600, 500);
		frmOasysReady.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOasysReady.getContentPane().setLayout(null);
		
		//check for heroes left in party
		myTeam.heroesLeft = 0;
		for (Character hero: myTeam.teamHeroes) {
			myTeam.heroesLeft++;
		}
		
		panelHero1.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelHero1);
		panelHero1.setVisible(false);
		panelHero1.setLayout(null);
		
		Hero1Exit = new JButton("X");
		Hero1Exit.setHorizontalAlignment(SwingConstants.LEADING);
		Hero1Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelHero1.setVisible(false);
				panel.setVisible(true);
			}
		});
		Hero1Exit.setForeground(Color.BLACK);
		Hero1Exit.setFont(new Font("Courier", Font.BOLD, 15));
		Hero1Exit.setBackground(Color.WHITE);
		Hero1Exit.setBounds(551, 6, 43, 33);
		panelHero1.add(Hero1Exit);
		
		JTextPane Hero1Stats = new JTextPane();
		Hero1Stats.setEditable(false);
		Hero1Stats.setBackground(Color.BLACK);
		Hero1Stats.setForeground(Color.WHITE);
		Hero1Stats.setBounds(105, 215, 386, 243);
		panelHero1.add(Hero1Stats);
		Hero1Stats.setText("");
		
		Hero1Icon = new JLabel("");
		Hero1Icon.setIcon(null);
		Hero1Icon.setBounds(252, 75, 100, 100);
		panelHero1.add(Hero1Icon);
		
		Hero1Background = new JLabel("");
		Hero1Background.setIcon(new ImageIcon(TeamInfo.class.getResource("/img/Background5.jpg")));
		Hero1Background.setBounds(-355, -359, 1507, 1250);
		panelHero1.add(Hero1Background);
		
		panelHero2.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelHero2);
		panelHero2.setVisible(false);
		panelHero2.setLayout(null);
		
		Hero2Exit = new JButton("X");
		Hero2Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelHero2.setVisible(false);
				panel.setVisible(true);
			}
		});
		Hero2Exit.setForeground(Color.BLACK);
		Hero2Exit.setFont(new Font("Courier", Font.BOLD, 15));
		Hero2Exit.setBackground(Color.WHITE);
		Hero2Exit.setBounds(551, 6, 43, 40);
		panelHero2.add(Hero2Exit);
		
		JTextPane Hero2Stats = new JTextPane();
		Hero2Stats.setEditable(false);
		Hero2Stats.setBackground(Color.BLACK);
		Hero2Stats.setForeground(Color.WHITE);
		Hero2Stats.setBounds(105, 215, 386, 243);
		panelHero2.add(Hero2Stats);
		Hero2Stats.setText("");
		
		Hero2Icon = new JLabel("");
		Hero2Icon.setIcon(null);
		Hero2Icon.setBounds(252, 75, 100, 100);
		panelHero2.add(Hero2Icon);
		
		Hero2Background = new JLabel("");
		Hero2Background.setIcon(new ImageIcon(TeamInfo.class.getResource("/img/Background5.jpg")));
		Hero2Background.setBounds(-347, -342, 1507, 1250);
		panelHero2.add(Hero2Background);
		
		panelHero3.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelHero3);
		panelHero3.setVisible(false);
		panelHero3.setLayout(null);
		
		Hero3Exit = new JButton("X");
		Hero3Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelHero3.setVisible(false);
				panel.setVisible(true);
			}
		});
		Hero3Exit.setForeground(Color.BLACK);
		Hero3Exit.setFont(new Font("Courier", Font.BOLD, 15));
		Hero3Exit.setBackground(Color.WHITE);
		Hero3Exit.setBounds(551, 6, 43, 39);
		panelHero3.add(Hero3Exit);
		
		JTextPane Hero3Stats = new JTextPane();
		Hero3Stats.setEditable(false);
		Hero3Stats.setBackground(Color.BLACK);
		Hero3Stats.setForeground(Color.WHITE);
		Hero3Stats.setBounds(105, 215, 386, 243);
		panelHero3.add(Hero3Stats);
		Hero3Stats.setText("");
		
		Hero3Icon = new JLabel("");
		Hero3Icon.setIcon(null);
		Hero3Icon.setBounds(252, 75, 100, 100);
		panelHero3.add(Hero3Icon);
		
		Hero3Background = new JLabel("");
		Hero3Background.setIcon(new ImageIcon(TeamInfo.class.getResource("/img/Background5.jpg")));
		Hero3Background.setBounds(-314, -317, 1507, 1250);
		panelHero3.add(Hero3Background);
		
		panel.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		
		HeroButton1 = new JButton("");
		HeroButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myTeam.teamHeroes.get(0).checkBuff();
				panel.setVisible(false);
				Hero1Icon.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
				Hero1Stats.setText(String.format(" Name: %s\n\n Class: %s\n\n Health: %d/%d\n\n Attack: %d\n\n Defence: %d\n\n Skill: %s\n\n Buff: %s", 
						  myTeam.teamHeroes.get(0).charName, myTeam.teamHeroes.get(0).charType, 
						  myTeam.teamHeroes.get(0).charCurrentHealth,
						  myTeam.teamHeroes.get(0).charHealth,
						  myTeam.teamHeroes.get(0).charATK, myTeam.teamHeroes.get(0).charDEF, 
						  myTeam.teamHeroes.get(0).charSkill, myTeam.teamHeroes.get(0).charBuff));
				panelHero1.setVisible(true);
			}
		});
		HeroButton1.setVisible(false);
		HeroButton1.setBounds(457, 290, 85, 75);
		panel.add(HeroButton1);
		
		HeroButton2 = new JButton("");
		HeroButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myTeam.teamHeroes.get(1).checkBuff();
				panel.setVisible(false);
				Hero2Icon.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
				Hero2Stats.setText(String.format(" Name: %s\n\n Class: %s\n\n Health: %d/%d\n\n Attack: %d\n\n Defence: %d\n\n Skill: %s\n\n Buff: %s", 
						myTeam.teamHeroes.get(1).charName,
						myTeam.teamHeroes.get(1).charType, myTeam.teamHeroes.get(1).charCurrentHealth,
					 	myTeam.teamHeroes.get(1).charHealth,
					 	myTeam.teamHeroes.get(1).charATK, myTeam.teamHeroes.get(1).charDEF, 
					 	myTeam.teamHeroes.get(1).charSkill, myTeam.teamHeroes.get(1).charBuff));
				panelHero2.setVisible(true);
			}
		});
		HeroButton2.setVisible(false);
		HeroButton2.setBounds(405, 380, 85, 75);
		panel.add(HeroButton2);
		
		HeroButton3 = new JButton("");
		HeroButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myTeam.teamHeroes.get(2).checkBuff();
				panel.setVisible(false);
				Hero3Icon.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
				Hero3Stats.setText(String.format(" Name: %s\n\n Class: %s\n\n Health: %d/%d\n\n Attack: %d\n\n Defence: %d\n\n Skill: %s\n\n Buff: %s", 
						myTeam.teamHeroes.get(2).charName, myTeam.teamHeroes.get(2).charType, 
						myTeam.teamHeroes.get(2).charCurrentHealth,
						  myTeam.teamHeroes.get(2).charHealth,
						  myTeam.teamHeroes.get(2).charATK, myTeam.teamHeroes.get(2).charDEF, 
						  myTeam.teamHeroes.get(2).charSkill, myTeam.teamHeroes.get(2).charBuff));
				panelHero3.setVisible(true);
			}
		});
		HeroButton3.setVisible(false);
		HeroButton3.setBounds(502, 377, 85, 75);
		panel.add(HeroButton3);
		
		CityCountLabel = new JLabel(String.format("Cities Won: %d/%d", myTeam.doneCities, myTeam.totalCities));
		CityCountLabel.setForeground(Color.YELLOW);
		CityCountLabel.setFont(new Font("Courier", Font.BOLD, 15));
		CityCountLabel.setBounds(422, 119, 188, 58);
		panel.add(CityCountLabel);
		
		ItemBag = new JTextPane();
		ItemBag.setText(String.format(" Healing Salve\n (10 sec)\n %d\n Mighty Morphine\n (5 sec)\n %d\n Fountain of Life\n (3 sec)\n %d", item1, item2, item3));
		ItemBag.setFont(new Font("Courier", Font.PLAIN, 13));
		ItemBag.setBounds(23, 290, 143, 154);
		panel.add(ItemBag);
		
		BuffBag = new JTextPane();
		BuffBag.setFont(new Font("Courier", Font.PLAIN, 11));
		BuffBag.setText(String.format(" 50-50 Lemon Squeezy\n (Increased chances\n of winning)\n %d\n Youaremydestiny\n (Flashpoint..ok,\n sees the future)\n %d\n Iron Maiden Potent\n (Take no damage)\n %d", buff1, buff2, buff3));
		BuffBag.setBounds(218, 290, 143, 154);
		panel.add(BuffBag);
		
		GoldLabel = new JLabel(String.format("Gold: %d", myTeam.teamGold));
		GoldLabel.setForeground(Color.YELLOW);
		GoldLabel.setFont(new Font("Courier", Font.BOLD, 20));
		GoldLabel.setBounds(23, 156, 194, 25);
		panel.add(GoldLabel);
		TeamSizeLabel = new JLabel(String.format("Maps Collected: %d", myTeam.mapCount));
		TeamSizeLabel.setForeground(Color.YELLOW);
		TeamSizeLabel.setFont(new Font("Courier", Font.BOLD, 20));
		TeamSizeLabel.setBounds(23, 119, 207, 25);
		
		panel.add(TeamSizeLabel);
		
		JLabel TeamNameLabel = new JLabel(String.format("Team: %s", myTeam.teamName));
		TeamNameLabel.setForeground(Color.YELLOW);
		TeamNameLabel.setFont(new Font("Courier", Font.BOLD, 20));
		TeamNameLabel.setBounds(23, 29, 554, 51);
		panel.add(TeamNameLabel);
		
		PowerBag = new JLabel("Power-Up Bag");
		PowerBag.setForeground(Color.YELLOW);
		PowerBag.setFont(new Font("Courier", Font.BOLD, 20));
		PowerBag.setBounds(218, 217, 149, 25);
		panel.add(PowerBag);
		
		MapBag = new JLabel("Heroes");
		MapBag.setForeground(Color.YELLOW);
		MapBag.setFont(new Font("Courier", Font.BOLD, 20));
		MapBag.setBounds(461, 217, 149, 25);
		panel.add(MapBag);
		
		ItemBagLabel = new JLabel("Item Bag");
		ItemBagLabel.setForeground(Color.YELLOW);
		ItemBagLabel.setFont(new Font("Courier", Font.BOLD, 20));
		ItemBagLabel.setBounds(42, 217, 101, 25);
		panel.add(ItemBagLabel);
		
		JButton ExitButton = new JButton("X");
		ExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmOasysReady.dispose();
				if (prevFrame == 0) {
					BaseLayout baseLay = new BaseLayout(myTeam);
					baseLay.panelBase.setVisible(true);
				} else if (prevFrame == 1) {
					DenLayout denLay = new DenLayout(myTeam);
					denLay.panelDen.setVisible(true);
				} else if (prevFrame == 2) {
					HospitalLayout hosLay = new HospitalLayout(myTeam);
					hosLay.panelHos.setVisible(true);
				} else if (prevFrame == 3) {
					ShopLayout shopLay = new ShopLayout(myTeam);
					shopLay.panelShop.setVisible(true);
				} else if (prevFrame == 9) {
					MapLayout mapLay = new MapLayout(myTeam);
				}
			}
		});
		ExitButton.setBackground(Color.BLACK);
		ExitButton.setForeground(Color.WHITE);
		ExitButton.setFont(new Font("Courier", Font.BOLD, 15));
		ExitButton.setBounds(551, 6, 43, 51);
		panel.add(ExitButton);
		
		Border3 = new JLabel("");
		Border3.setBorder(border);
		Border3.setBounds(0, 193, 600, 75);
		panel.add(Border3);
		
		Border2 = new JLabel("");
		Border2.setBounds(0, 0, 600, 98);
		Border2.setBorder(border);
		panel.add(Border2);
		
		Border1 = new JLabel("");
		Border1.setBounds(0, 0, 600, 478);
		panel.add(Border1);
		
		Border1.setBorder(border);
		
		Border4 = new JLabel("");
		Border4.setBorder(border);
		Border4.setBounds(0, 193, 189, 285);
		panel.add(Border4);
		
		Border5 = new JLabel("");
		Border5.setBorder(border);
		Border5.setBounds(393, 92, 207, 386);
		panel.add(Border5);
		
		Background1 = new JLabel("");
		Background1.setIcon(new ImageIcon(TeamInfo.class.getResource("/img/Background5.jpg")));
		Background1.setBounds(-397, -412, 1507, 1250);
		panel.add(Background1);	

		if (myTeam.heroesLeft == 1) {
			HeroButton1.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
			HeroButton1.setVisible(true);
			HeroButton2.setVisible(false);
			HeroButton3.setVisible(false);
		} else if (myTeam.heroesLeft == 2) {
			HeroButton1.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
			HeroButton2.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
			HeroButton1.setVisible(true);
			HeroButton2.setVisible(true);
			HeroButton3.setVisible(false);
		} else if (myTeam.heroesLeft == 3) {
			HeroButton1.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(0))));
			HeroButton2.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(1))));
			HeroButton3.setIcon(new ImageIcon(TeamInfo.class.getResource(myTeam.teamSprites.get(2))));
			HeroButton1.setVisible(true);
			HeroButton2.setVisible(true);
			HeroButton3.setVisible(true);
		}

		for (String item: myTeam.teamItems) {
			if (item.contains("Salve")) {
				item1++;
				ItemBag.setText(String.format(" Healing Salve\n (10 sec)\n %d\n Mighty Morphine\n (5 sec)\n %d\n Fountain of Life\n (3 sec)\n %d", item1, item2, item3));
			} else if (item.contains("Morphine")) {
				item2++;
				ItemBag.setText(String.format(" Healing Salve\n (10 sec)\n %d\n Mighty Morphine\n (5 sec)\n %d\n Fountain of Life\n (3 sec)\n %d", item1, item2, item3));
			} else if (item.contains("Fountain")) {
				item3++;
				ItemBag.setText(String.format(" Healing Salve\n (10 sec)\n %d\n Mighty Morphine\n (5 sec)\n %d\n Fountain of Life\n (3 sec)\n %d", item1, item2, item3));
			}
		}
		
		for (String buff: myTeam.teamBuffs) {
			if (buff.contains("Lemon")) {
				buff1++;
				BuffBag.setText(String.format(" 50-50 Lemon Squeezy\n (Increased chances\n of winning)\n %d\n Youaremydestiny\n (Flashpoint..ok,\n sees the future)\n %d\n Iron Maiden Potent\n (Take no damage)\n %d", buff1, buff2, buff3));
			} else if (buff.contains("destiny")) {
				buff2++;
				BuffBag.setText(String.format(" 50-50 Lemon Squeezy\n (Increased chances\n of winning)\n %d\n Youaremydestiny\n (Flashpoint..ok,\n sees the future)\n %d\n Iron Maiden Potent\n (Take no damage)\n %d", buff1, buff2, buff3));
			} else if (buff.contains("Iron")) {
				buff3++;
				BuffBag.setText(String.format(" 50-50 Lemon Squeezy\n (Increased chances\n of winning)\n %d\n Youaremydestiny\n (Flashpoint..ok,\n sees the future)\n %d\n Iron Maiden Potent\n (Take no damage)\n %d", buff1, buff2, buff3));
			}
		}
		
		for (Character hero: myTeam.teamHeroes) {
			if (hero.charType == Character.Type.NAVIGATOR) {
				if (!myTeam.teamMaps.contains("North")) {
					myTeam.teamMaps.add("North");
				} 
				if (!myTeam.teamMaps.contains("East")) {
					myTeam.teamMaps.add("East");
				} 
				if (!myTeam.teamMaps.contains("South")) {
					myTeam.teamMaps.add("South");
				} 
				if (!myTeam.teamMaps.contains("West")) {
					myTeam.teamMaps.add("West");
				}
			}
		}
		myTeam.mapCount = 0; //re-evaluates map count
		for (String maps: myTeam.teamMaps) {
			myTeam.mapCount++;
		}
		if (myTeam.mapCount > 4) {
			myTeam.mapCount = 4;
		}
	}
}
