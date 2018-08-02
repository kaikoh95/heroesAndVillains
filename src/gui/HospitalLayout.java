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
 * Class for Hospital GUI - 
 * lets user heal up by expending one of the selected healing item 
 * on a chosen hero.
 * Heal time varies depending on quality of item used
 * and decrements the respective item from the bag
 * @author Kai and Blue
 *
 */
public class HospitalLayout {

	private JFrame frmOasysReady;
	
	private JLabel HosBackground = new JLabel("");
	public JPanel panelHos = new JPanel();
	
	private JButton HosItem1 = new JButton(""), HosItem2 = new JButton(""), HosItem3 = new JButton(""),
				    HosUseButton1 = new JButton("Aye, rest"), HosUseButton2 = new JButton("Heal me!");;
	private JTextField HosCount1 = new JTextField(), HosCount2 = new JTextField(),
						HosCount3 = new JTextField(), HosAnnounce = new JTextField(),
						HosGreetings1, HosGreetings2, HosItemSelected = new JTextField();
	
	@SuppressWarnings("rawtypes")
	private JComboBox HosHeroSelected = new JComboBox();

	/**
	 * Launch the application.
	 * @param args - for main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					HospitalLayout window = new HospitalLayout(myTeam);
					window.frmOasysReady.setVisible(true);
					window.panelHos.setVisible(true);
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
	public HospitalLayout(WarriorsOfLight myTeam) {
		initialize(myTeam);
		frmOasysReady.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param myTeam - team of heroes
	 */
	@SuppressWarnings("unchecked")
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
		
		/**
		 * simple map count checker
		 */
		if (myTeam.mapCount > 4) {
			myTeam.mapCount = 4;
		} else if (myTeam.mapCount <= 0) {
			myTeam.mapCount = 0;
		}
		
		/**
		 * Sets background for power-up den according to current city
		 */
		if (myTeam.doneCities == (myTeam.totalCities - 1)) {
			HosBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/HospitalTitan.jpg")));
		} else {
			if (myTeam.doneCities == 0) {
				HosBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/HospitalPalletTown.png")));
			} else if (myTeam.doneCities == 1) {
				HosBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/HospitalVacantCity.jpg")));
			} else if (myTeam.doneCities == 2) {
				HosBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/HospitalHenesys.png")));
			} else if (myTeam.doneCities == 3) {
				HosBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/HospitalGotham.jpg")));
			} else if (myTeam.doneCities == 4) {
				HosBackground.setIcon(new ImageIcon(DenLayout.class.getResource("/img/HospitalRift.jpg")));
			}
		}
		
		HosAnnounce.setVisible(false);
		HosAnnounce.setBounds(79, 341, 428, 26);
		HosAnnounce.setColumns(10);
		panelHos.add(HosAnnounce);
		
		panelHos.setVisible(false);
		panelHos.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelHos);
		panelHos.setLayout(null);
		
		HosItem1.setIcon(new ImageIcon(HospitalLayout.class.getResource("/img/ShopItemSalve.jpg")));
		HosItem1.setVisible(false);
		HosItem1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HosAnnounce.setVisible(false);
				HosItem1.setEnabled(false);
				HosItem2.setEnabled(true);
				HosItem3.setEnabled(true);
				int count1 = 0;
				for (String item: myTeam.teamItems) {
					if (item.contains("Salve")) {
						count1++;
					}
				}
				if (count1 > 0) {
					HosHeroSelected.setVisible(true);
					HosItemSelected.setVisible(true);
					HosUseButton2.setEnabled(true);
					HosItemSelected.setText("Use <Healing Salve> on");
				} else {
					HosHeroSelected.setVisible(false);
					HosItemSelected.setVisible(false);
					HosUseButton2.setEnabled(false);
				}
			}
		});
		HosItem1.setBounds(110, 173, 50, 50);
		panelHos.add(HosItem1);
		
		HosItem2.setIcon(new ImageIcon(HospitalLayout.class.getResource("/img/ShopItemMorphine.jpg")));
		HosItem2.setVisible(false);
		HosItem2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HosAnnounce.setVisible(false);
				HosItem2.setEnabled(false);
				HosItem1.setEnabled(true);
				HosItem3.setEnabled(true);
				int count1 = 0;
				for (String item: myTeam.teamItems) {
					if (item.contains("Morphine")) {
						count1++;
					}
				}
				if (count1 > 0) {
					HosHeroSelected.setVisible(true);
					HosItemSelected.setVisible(true);
					HosUseButton2.setEnabled(true);
					HosItemSelected.setText("Use <Mighty Morphine> on");
				} else {
					HosHeroSelected.setVisible(false);
					HosItemSelected.setVisible(false);
					HosUseButton2.setEnabled(false);
				}
			}
		});
		HosItem2.setBounds(277, 173, 50, 50);
		panelHos.add(HosItem2);
		
		HosItem3.setIcon(new ImageIcon(HospitalLayout.class.getResource("/img/ShopItemFountain.jpg")));
		HosItem3.setVisible(false);
		HosItem3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HosAnnounce.setVisible(false);
				HosItem3.setEnabled(false);
				HosItem2.setEnabled(true);
				HosItem1.setEnabled(true);
				int count1 = 0;
				for (String item: myTeam.teamItems) {
					if (item.contains("Fountain")) {
						count1++;
					}
				}
				if (count1 > 0) {
					HosHeroSelected.setVisible(true);
					HosItemSelected.setVisible(true);
					HosUseButton2.setEnabled(true);
					HosItemSelected.setText("Use <Fountain of Life> on");
				} else {
					HosHeroSelected.setVisible(false);
					HosItemSelected.setVisible(false);
					HosUseButton2.setEnabled(false);
				}
			}
		});
		HosItem3.setBounds(458, 173, 50, 50);
		panelHos.add(HosItem3);
		
		HosCount1.setVisible(false);
		HosCount1.setEditable(false);
		HosCount1.setHorizontalAlignment(SwingConstants.CENTER);
		HosCount1.setColumns(10);
		HosCount1.setBounds(110, 231, 50, 26);
		
		panelHos.add(HosCount1);
		HosCount2.setVisible(false);
		HosCount2.setEditable(false);
		HosCount2.setHorizontalAlignment(SwingConstants.CENTER);
		HosCount2.setColumns(10);
		HosCount2.setBounds(277, 231, 50, 26);
		
		panelHos.add(HosCount2);
		HosCount3.setVisible(false);
		HosCount3.setEditable(false);
		HosCount3.setHorizontalAlignment(SwingConstants.CENTER);
		HosCount3.setColumns(10);
		HosCount3.setBounds(458, 231, 50, 26);
		
		panelHos.add(HosCount3);
		
		int count4 = 0, count5 = 0, count6 = 0;
		for (String item: myTeam.teamItems) {
			if (item.contains("Salve")) {
				count4++;
			} else if (item.contains("Morphine")) {
				count5++;
			} else if (item.contains("Fountain")) {
				count6++;
			}
		}
		HosCount1.setText(String.format("x %d", count4));
		HosCount2.setText(String.format("x %d", count5));
		HosCount3.setText(String.format("x %d", count6));
		
		ArrayList<String> heroComboBox = new ArrayList<String>();
		HosHeroSelected.setVisible(false);
		HosHeroSelected.setBounds(319, 295, 230, 27);
		for (Character hero: myTeam.teamHeroes) {
			if (!heroComboBox.contains(hero.charName)) {
				HosHeroSelected.addItem(hero.charName);
				heroComboBox.add(hero.charName);
			}
		}
		panelHos.add(HosHeroSelected);
		
		HosGreetings1 = new JTextField();
		HosGreetings1.setText("Come inside and heal up!");
		HosGreetings1.setHorizontalAlignment(SwingConstants.CENTER);
		HosGreetings1.setFont(new Font("Courier", Font.BOLD, 20));
		HosGreetings1.setEditable(false);
		HosGreetings1.setColumns(10);
		HosGreetings1.setBounds(110, 75, 398, 35);
		panelHos.add(HosGreetings1);
		
		HosGreetings2 = new JTextField();
		HosGreetings2.setText("-take a break, have a kit-kat-");
		HosGreetings2.setHorizontalAlignment(SwingConstants.CENTER);
		HosGreetings2.setFont(new Font("Courier", Font.BOLD, 10));
		HosGreetings2.setEditable(false);
		HosGreetings2.setColumns(10);
		HosGreetings2.setBounds(304, 112, 204, 29);
		panelHos.add(HosGreetings2);
		
		JButton HosViewTeamButton = new JButton("View Team");
		HosViewTeamButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelHos.setVisible(false);
				frmOasysReady.dispose();
				TeamInfo teamInfo = new TeamInfo(2, myTeam);
				teamInfo.panel.setVisible(true);
			}
		});
		HosViewTeamButton.setBounds(248, 379, 117, 29);
		panelHos.add(HosViewTeamButton);
		
		JButton HosExitButton1 = new JButton("I'm fine");
		HosExitButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				HosAnnounce.setVisible(false);
				HosItemSelected.setVisible(false);
				HosUseButton1.setVisible(true);
				HosUseButton2.setEnabled(false);
				HosHeroSelected.setVisible(false);
				HosItem1.setEnabled(true);
				HosItem2.setEnabled(true);
				HosItem3.setEnabled(true);
				HosItem1.setVisible(false);
				HosItem2.setVisible(false);
				HosItem3.setVisible(false);
				HosCount1.setVisible(false);
				HosCount2.setVisible(false);
				HosCount3.setVisible(false);
				HosViewTeamButton.setVisible(true);
				panelHos.setVisible(false);
				
				frmOasysReady.dispose();
				BaseLayout baseLay = new BaseLayout(myTeam);
				baseLay.panelBase.setVisible(true);
			}
		});
		HosExitButton1.setBounds(110, 415, 117, 29);
		panelHos.add(HosExitButton1);
		
		HosItemSelected.setVisible(false);
		panelHos.add(HosItemSelected);
		
		HosItemSelected.setText("");
		HosItemSelected.setEditable(false);
		HosItemSelected.setBounds(43, 294, 246, 26);
		HosItemSelected.setColumns(10);
		HosUseButton2.setVisible(false);
		HosUseButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (HosItemSelected.getText().contains("Salve")) {
					panelHos.setVisible(false);
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e1) {
						Thread.currentThread().interrupt();
					}
					panelHos.setVisible(true);
					myTeam.teamHeroes.get(HosHeroSelected.getSelectedIndex()).charCurrentHealth = myTeam.teamHeroes.get(HosHeroSelected.getSelectedIndex()).charHealth;
					myTeam.teamItems.remove("Name: Small Salve|Time taken to heal: 10 seconds|");
					myTeam.itemCount--;
				} else if (HosItemSelected.getText().contains("Morphine")) {
					panelHos.setVisible(false);
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e1) {
						Thread.currentThread().interrupt();
					}
					panelHos.setVisible(true);
					myTeam.teamHeroes.get(HosHeroSelected.getSelectedIndex()).charCurrentHealth = myTeam.teamHeroes.get(HosHeroSelected.getSelectedIndex()).charHealth;
					myTeam.teamItems.remove("Name: Mighty Morphine|Time taken to heal: 5 seconds|");
					myTeam.itemCount--;
				} else if (HosItemSelected.getText().contains("Fountain")) {
					panelHos.setVisible(false);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						Thread.currentThread().interrupt();
					}
					panelHos.setVisible(true);
					myTeam.teamHeroes.get(HosHeroSelected.getSelectedIndex()).charCurrentHealth = myTeam.teamHeroes.get(HosHeroSelected.getSelectedIndex()).charHealth;
					myTeam.teamItems.remove("Name: Fountain of Life|Time taken to heal: 3 seconds|");
					myTeam.itemCount--;
				}
				HosAnnounce.setText(String.format("Used %s Hero: %s", HosItemSelected.getText(), 
							                      myTeam.teamHeroes.get(HosHeroSelected.getSelectedIndex()).charName));
				HosItem1.setEnabled(true);
				HosItem2.setEnabled(true);
				HosItem3.setEnabled(true);
				
				int count1 = 0, count2 = 0, count3 = 0;
				
				for (String item: myTeam.teamItems) {
					if (item.contains("Salve")) {
						count1++;
					} else if (item.contains("Morphine")) {
						count2++;
					} else if (item.contains("Fountain")) {
						count3++;
					}
				}
				HosItemSelected.setVisible(false);
				HosHeroSelected.setVisible(false);
				HosItemSelected.setText("");
				
				HosHeroSelected.setSelectedItem("");
				HosCount1.setText(String.format("x %d", count1));
				HosCount2.setText(String.format("x %d", count2));
				HosCount3.setText(String.format("x %d", count3));
			}
		});
		HosUseButton2.setBounds(391, 415, 117, 29);
		
		panelHos.add(HosUseButton2);
		
		HosUseButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count1 = 0, count2 = 0, count3 = 0;
				
				for (String item: myTeam.teamItems) {
					if (item.contains("Salve")) {
						count1++;
					} else if (item.contains("Morphine")) {
						count2++;
					} else if (item.contains("Fountain")) {
						count3++;
					}
				}
				HosCount1.setText(String.format("x %d", count1));
				HosCount2.setText(String.format("x %d", count2));
				HosCount3.setText(String.format("x %d", count3));
		
				HosViewTeamButton.setVisible(false);
				HosAnnounce.setVisible(false);
				HosUseButton1.setVisible(false);
				HosUseButton2.setEnabled(false);
				HosItemSelected.setVisible(false);
				HosHeroSelected.setVisible(false);
				HosUseButton2.setVisible(true);
				HosItem1.setVisible(true);
				HosItem2.setVisible(true);
				HosItem3.setVisible(true);
				HosCount1.setVisible(true);
				HosCount2.setVisible(true);
				HosCount3.setVisible(true);
				
			}
		});
		HosUseButton1.setBounds(391, 415, 117, 29);
		panelHos.add(HosUseButton1);
		
		HosBackground.setBounds(0, 0, 600, 478);
		panelHos.add(HosBackground);
	}
}
