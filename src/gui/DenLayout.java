package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cli.Character;
import cli.WarriorsOfLight;

/**
 * Class for Power up den GUI -
 * for user to use a chosen power up and decrements it from inventory.
 * Also buffs up the chosen character too.
 * One-time usage for the buff that will only be active the next time the
 * hero is chosen for battle
 * @author Kai and Blue
 *
 */
public class DenLayout {

	private JFrame frmOasysReady;
	
	private JLabel DenBackground = new JLabel("");
	public JPanel panelDen = new JPanel();
	
	private JTextField DenGreeting1 = new JTextField(), DenGreetings2 = new JTextField();
	private JButton DenViewTeamButton = new JButton("View Team"), DenExitButton = new JButton("Not, I will"),
		    			DenUseButton = new JButton("Use, I will"), DenBuff1 = new JButton(""),
		    			DenBuff2 = new JButton(""), DenBuff3 = new JButton(""),
	    				DenUseButton1 = new JButton("Use, I will");
	private JTextField DenCount1 = new JTextField(), DenCount2 = new JTextField(), 
					   DenCount3 = new JTextField(), DenBuffSelected = new JTextField(), 
					   DenAnnounce = new JTextField();
	
	@SuppressWarnings("rawtypes")
	private JComboBox DenHeroSelected = new JComboBox();

	/**
	 * Launch the application.
	 * @param args - main function
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					DenLayout window = new DenLayout(myTeam);
					window.frmOasysReady.setVisible(true);
					window.panelDen.setVisible(true);
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
	public DenLayout(WarriorsOfLight myTeam) {
		initialize(myTeam);
		frmOasysReady.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param myTeam - team of heroes
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		 * Sets background for power-up den according to current city
		 */
		if (myTeam.doneCities == (myTeam.totalCities - 1)) {
			DenBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/DenTitan.jpg")));
		} else {
			if (myTeam.doneCities == 0) {
				DenBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/DenPalletTown.png")));
			} else if (myTeam.doneCities == 1) {
				DenBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/DenVacantCity.jpg")));
			} else if (myTeam.doneCities == 2) {
				DenBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/DenHenesys.png")));
			} else if (myTeam.doneCities == 3) {
				DenBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/DenGotham.jpg")));
			} else if (myTeam.doneCities == 4) {
				DenBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/DenRift.jpg")));
			}
		}
		
		DenAnnounce.setVisible(false);
		DenAnnounce.setBounds(53, 343, 481, 26);
		DenAnnounce.setColumns(10);
		panelDen.add(DenAnnounce);
		
		panelDen.setVisible(false);
		panelDen.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelDen);
		panelDen.setLayout(null);

		DenGreeting1.setEditable(false);
		DenGreeting1.setText("Come to use a power-up, have you?");
		DenGreeting1.setHorizontalAlignment(SwingConstants.CENTER);
		DenGreeting1.setFont(new Font("Courier", Font.BOLD, 20));
		DenGreeting1.setColumns(10);
		DenGreeting1.setBounds(109, 77, 398, 35);
		
		panelDen.add(DenGreeting1);
		DenGreetings2.setEditable(false);
		DenGreetings2.setText("-win the battles, you must-");
		DenGreetings2.setHorizontalAlignment(SwingConstants.CENTER);
		DenGreetings2.setFont(new Font("Courier", Font.BOLD, 10));
		DenGreetings2.setColumns(10);
		DenGreetings2.setBounds(303, 114, 204, 29);
		
		panelDen.add(DenGreetings2);
		DenViewTeamButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelDen.setVisible(false);
				frmOasysReady.dispose();
				TeamInfo teamInfo = new TeamInfo(1, myTeam);
				teamInfo.panel.setVisible(true);
			}
		});
		DenViewTeamButton.setBounds(247, 389, 117, 29);
		panelDen.add(DenViewTeamButton);
		
		DenExitButton.setBounds(109, 425, 117, 29);
		
		panelDen.add(DenExitButton);
		DenUseButton.setBounds(390, 425, 117, 29);
		
		panelDen.add(DenUseButton);
		DenBuff1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DenAnnounce.setVisible(false);
				DenBuff1.setEnabled(false);
				DenBuff2.setEnabled(true);
				DenBuff3.setEnabled(true);
				int count1 = 0;
				for (String buff: myTeam.teamBuffs) {
					if (buff.contains("Lemon")) {
						count1++;
					}
				}
				if (count1 > 0) {
					DenHeroSelected.setVisible(true);
					DenBuffSelected.setVisible(true);
					DenUseButton1.setEnabled(true);
					DenBuffSelected.setText("<50-50 Lemon Squeezy> on");
				} else {
					DenHeroSelected.setVisible(false);
					DenBuffSelected.setVisible(false);
					DenUseButton1.setEnabled(false);
				}
			}
		});
		DenBuff1.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopBuffCritical.jpeg")));
		DenBuff1.setVisible(false);
		DenBuff1.setBounds(109, 171, 50, 50);
		
		panelDen.add(DenBuff1);
		DenBuff2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DenAnnounce.setVisible(false);
				DenBuff2.setEnabled(false);
				DenBuff1.setEnabled(true);
				DenBuff3.setEnabled(true);
				int count1 = 0;
				for (String buff: myTeam.teamBuffs) {
					if (buff.contains("destiny")) {
						count1++;
					}
				}
				if (count1 > 0) {
					DenHeroSelected.setVisible(true);
					DenBuffSelected.setVisible(true);
					DenUseButton1.setEnabled(true);
					DenBuffSelected.setText("<Youaremydestiny> on");
				} else {
					DenHeroSelected.setVisible(false);
					DenBuffSelected.setVisible(false);
					DenUseButton1.setEnabled(false);
				}
			}
		});
		DenBuff2.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopBuffFuture.jpg")));
		DenBuff2.setVisible(false);
		DenBuff2.setBounds(275, 171, 50, 50);
		
		panelDen.add(DenBuff2);
		DenBuff3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DenAnnounce.setVisible(false);
				DenBuff3.setEnabled(false);
				DenBuff2.setEnabled(true);
				DenBuff1.setEnabled(true);
				int count1 = 0;
				for (String buff: myTeam.teamBuffs) {
					if (buff.contains("Iron")) {
						count1++;
					}
				}
				if (count1 > 0) {
					DenBuffSelected.setVisible(true);
					DenUseButton1.setEnabled(true);
					DenBuffSelected.setText("<Iron Maiden> on");
					DenHeroSelected.setVisible(true);
				} else {
					DenHeroSelected.setVisible(false);
					DenBuffSelected.setVisible(false);
					DenUseButton1.setEnabled(false);
				}
			}
		});
		DenBuff3.setIcon(new ImageIcon(MapLayout.class.getResource("/img/ShopBuffIron.jpg")));
		DenBuff3.setVisible(false);
		DenBuff3.setBounds(451, 171, 50, 50);
		
		panelDen.add(DenBuff3);	
		
		DenExitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DenAnnounce.setVisible(false);
				DenBuffSelected.setVisible(false);
				DenHeroSelected.setVisible(false);
				DenUseButton.setVisible(true);
				DenUseButton1.setEnabled(false);
				DenBuff1.setEnabled(true);
				DenBuff2.setEnabled(true);
				DenBuff3.setEnabled(true);
				DenBuff1.setVisible(false);
				DenBuff2.setVisible(false);
				DenBuff3.setVisible(false);
				DenCount1.setVisible(false);
				DenCount2.setVisible(false);
				DenCount3.setVisible(false);
				DenViewTeamButton.setVisible(true);
				panelDen.setVisible(false);
				
				frmOasysReady.dispose();
				BaseLayout baseLay = new BaseLayout(myTeam);
				baseLay.panelBase.setVisible(true);
			}
		});
		
		
		DenHeroSelected = new JComboBox();
		ArrayList<String> heroComboBox = new ArrayList<String>();
		DenHeroSelected.setVisible(false);
		DenHeroSelected.setBounds(319, 295, 230, 27);
		for (Character hero: myTeam.teamHeroes) {
			if (!heroComboBox.contains(hero.charName)) {
				DenHeroSelected.addItem(hero.charName);
				heroComboBox.add(hero.charName);
			}
		}
		panelDen.add(DenHeroSelected);
		
		DenCount1.setEditable(false);
		DenCount1.setHorizontalAlignment(SwingConstants.CENTER);
		DenCount1.setVisible(false);
		
		DenCount1.setBounds(109, 229, 50, 26);
		DenCount1.setColumns(10);
		panelDen.add(DenCount1);
		DenCount2.setEditable(false);
		DenCount2.setHorizontalAlignment(SwingConstants.CENTER);
		DenCount2.setVisible(false);
		DenCount2.setColumns(10);
		DenCount2.setBounds(275, 229, 50, 26);
		
		panelDen.add(DenCount2);
		DenCount3.setEditable(false);
		DenCount3.setHorizontalAlignment(SwingConstants.CENTER);
		DenCount3.setVisible(false);
		DenCount3.setColumns(10);
		DenCount3.setBounds(451, 229, 50, 26);
		
		panelDen.add(DenCount3);
		
		DenBuffSelected.setVisible(false);
		panelDen.add(DenBuffSelected);
		
		DenBuffSelected.setText("Use ?");
		DenBuffSelected.setEditable(false);
		DenBuffSelected.setBounds(43, 294, 246, 26);
		DenBuffSelected.setColumns(10);
		DenUseButton1.setVisible(false);
		DenUseButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * check which buff is selected
				 */
				if (DenBuffSelected.getText().contains("Lemon")) {
					myTeam.teamHeroes.get(DenHeroSelected.getSelectedIndex()).charPower = 1;
					myTeam.teamHeroes.get(DenHeroSelected.getSelectedIndex()).checkBuff();
					myTeam.teamBuffs.remove("Name: 50-50 Lemon Squeezy|Attribute: 50% chance of winning the next round|");
					myTeam.buffCount--;
				} else if (DenBuffSelected.getText().contains("Iron")) {
					myTeam.teamHeroes.get(DenHeroSelected.getSelectedIndex()).charPower = 3;
					myTeam.teamHeroes.get(DenHeroSelected.getSelectedIndex()).checkBuff();
					myTeam.teamBuffs.remove("Name: Iron Maiden Potent|Attribute: Takes no damage when you lose the next round|");
					myTeam.buffCount--;
				} else if (DenBuffSelected.getText().contains("destiny")) {
					myTeam.teamHeroes.get(DenHeroSelected.getSelectedIndex()).charPower = 2;
					myTeam.teamHeroes.get(DenHeroSelected.getSelectedIndex()).checkBuff();
					myTeam.teamBuffs.remove("Name: Youaremydestiny|Attribute: Sees the villain's choice for the next round (Unusable for dice roll rounds and Final Boss fight)|");
					myTeam.buffCount--;
				}
				DenAnnounce.setText(String.format("Used %s Hero: %s", DenBuffSelected.getText(), 
							                      myTeam.teamHeroes.get(DenHeroSelected.getSelectedIndex()).charName));
				DenBuff1.setEnabled(true);
				DenBuff2.setEnabled(true);
				DenBuff3.setEnabled(true);
				int count1 = 0, count2 = 0, count3 = 0;
				
				for (String buff: myTeam.teamBuffs) {
					if (buff.contains("Lemon")) {
						count1++;
					} else if (buff.contains("destiny")) {
						count2++;
					} else if (buff.contains("Maiden")) {
						count3++;
					}
				}
				if (count1 == 0  && count2 == 0 && count3 == 0) {
					if (DenBuff1.isEnabled() == true && DenBuff2.isEnabled() == true && DenBuff3.isEnabled() == true ) {
						DenAnnounce.setVisible(false);
					}
				} else {
					if (DenBuff1.isEnabled() == true && DenBuff2.isEnabled() == true && DenBuff3.isEnabled() == true ) {
						DenAnnounce.setVisible(false);
					} else {
						DenAnnounce.setVisible(true);
					}
				}
				DenBuffSelected.setVisible(false);
				DenHeroSelected.setVisible(false);
				DenBuffSelected.setText("");
				DenHeroSelected.setSelectedItem("");
				DenCount1.setText(String.format("x %d", count1));
				DenCount2.setText(String.format("x %d", count2));
				DenCount3.setText(String.format("x %d", count3));
			}
		});
		DenUseButton1.setBounds(390, 425, 117, 29);
		
		panelDen.add(DenUseButton1);
		
		DenUseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count1 = 0, count2 = 0, count3 = 0;
				
				for (String buff: myTeam.teamBuffs) {
					if (buff.contains("Lemon")) {
						count1++;
					} else if (buff.contains("destiny")) {
						count2++;
					} else if (buff.contains("Maiden")) {
						count3++;
					}
				}
				DenCount1.setText(String.format("x %d", count1));
				DenCount2.setText(String.format("x %d", count2));
				DenCount3.setText(String.format("x %d", count3));
		
				DenViewTeamButton.setVisible(false);
				DenAnnounce.setVisible(false);
				DenUseButton.setVisible(false);
				DenUseButton1.setEnabled(false);
				DenBuffSelected.setVisible(false);
				DenHeroSelected.setVisible(false);
				DenUseButton1.setVisible(true);
				DenBuff1.setVisible(true);
				DenBuff2.setVisible(true);
				DenBuff3.setVisible(true);
				DenCount1.setVisible(true);
				DenCount2.setVisible(true);
				DenCount3.setVisible(true);
				
			}
		});
		
		DenBackground.setBounds(0, 0, 600, 478);
		panelDen.add(DenBackground);
		
	}

}
