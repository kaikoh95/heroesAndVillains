package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import cli.WarriorsOfLight;
import cli.Character;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;

/**
 * Class for creating team of heroes after a short narrative, 
 * allows user to choose a sprite and the type of attributes from 
 * a preset list of character types - displays the attributes.
 * This is so that user can compare between each character type
 * and also set a name for the hero chosen
 * @author Kai and Blue
 *
 */
public class Chapter2 {
	
	public ArrayList<String> myChars = new ArrayList<String>(), takenNames = new ArrayList<String>();
	public String charName;
	public int charTypeSel;
	private JFrame frmOasysReady;
	private JTextField NameField;
	private JLabel CharPic = new JLabel();
	private JPanel panel4 = new JPanel(), panel3 = new JPanel();
	public JPanel panel5 = new JPanel(), panel6 = new JPanel(), panel7 = new JPanel();
	
	public String[] charType = {"Berserker", "Sturdy", "Pickup", "Navigator", "Lucky", "Regen"};
	public String[] cityCount = {"3", "4", "5", "6"};
	private Character char1 = new Character(Character.Type.BERSERKER);

	/**
	 * Launch the application.
	 * @param args - main function
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					Chapter2 window = new Chapter2(myTeam);
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
	public Chapter2(WarriorsOfLight myTeam) {
		initialize(myTeam);
		frmOasysReady.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param myTeam - team of heroes
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize(WarriorsOfLight myTeam) {
		frmOasysReady = new JFrame();
		frmOasysReady.setFont(new Font("Courier", Font.PLAIN, 12));
		frmOasysReady.setTitle("O.A.S.Y.S - Ready Player Two");
		frmOasysReady.setBounds(100, 100, 600, 500);
		frmOasysReady.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOasysReady.getContentPane().setLayout(null);
				
				
		panel3.setVisible(false);
		panel4.setVisible(false);
		panel4.setLayout(null);
		panel5.setVisible(false);
		panel6.setVisible(false);
		panel7.setVisible(false);
		
		
		panel7.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel7);
		panel7.setLayout(null);
		
		JTextPane Narrate11 = new JTextPane();
		Narrate11.setBounds(6, 377, 588, 95);
		panel7.add(Narrate11);
		Narrate11.setEditable(false);
		Narrate11.setBackground(Color.CYAN);
		Narrate11.setFont(new Font("Courier", Font.BOLD, 21));
		Narrate11.setText(String.format(" Morgan Freeman (aka Narrator): All set mighty %s!\n Now let's go save the world!",myTeam.teamName));
		
		JTextPane ChatBorder11 = new JTextPane();
		ChatBorder11.setBounds(0, 370, 600, 108);
		panel7.add(ChatBorder11);
		ChatBorder11.setEditable(false);
		ChatBorder11.setBackground(Color.BLACK);
		
		JButton BackGround7 = new JButton("");
		BackGround7.setBounds(0, 0, 600, 472);
		panel7.add(BackGround7);
		BackGround7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmOasysReady.dispose();
				MapLayout mapLay = new MapLayout(myTeam);
				mapLay.panel.setVisible(true);
			}
		});
		BackGround7.setIcon(new ImageIcon(Chapter1.class.getResource("/img/Background1.jpg")));
		
		panel6.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel6);
		panel6.setLayout(null);
		
		JComboBox CityCount = new JComboBox(cityCount);
		CityCount.setBounds(248, 226, 78, 27);
		panel6.add(CityCount);
		CityCount.setSelectedIndex(0);
		
		JButton StartButton = new JButton("Final Check!");
		StartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myTeam.totalCities = CityCount.getSelectedIndex() + 3;
				frmOasysReady.dispose();
				TeamInfo teamAtt = new TeamInfo(9, myTeam);
				teamAtt.panel.setVisible(true);
				
				
			}
		});
		StartButton.setBounds(210, 336, 161, 29);
		panel6.add(StartButton);
		
		JLabel Title6 = new JLabel("How many cities do you want to challenge?");
		Title6.setHorizontalAlignment(SwingConstants.CENTER);
		Title6.setFont(new Font("Courier", Font.PLAIN, 13));
		Title6.setForeground(Color.WHITE);
		Title6.setBounds(79, 113, 415, 41);
		panel6.add(Title6);
		
		JLabel Bg6 = new JLabel("");
		Bg6.setIcon(new ImageIcon(Chapter2.class.getResource("/img/Background1.jpg")));
		Bg6.setBounds(0, 0, 600, 478);
		panel6.add(Bg6);
		
		panel5.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel5);
		panel5.setLayout(null);
		
		JLabel PartyFull1 = new JLabel("Party is full noob...");
		PartyFull1.setHorizontalAlignment(SwingConstants.CENTER);
		PartyFull1.setFont(new Font("Courier", Font.BOLD, 19));
		PartyFull1.setForeground(Color.WHITE);
		PartyFull1.setBounds(113, 167, 291, 29);
		PartyFull1.setVisible(false);
		panel5.add(PartyFull1);
		
		JButton No1 = new JButton("Nah I'm good!");
		No1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel5.setVisible(false);
				panel6.setVisible(true);
			}
		});
		
		
		No1.setBounds(219, 330, 161, 29);
		panel5.add(No1);
		
		JButton Yes1 = new JButton("Yes please! I'm a nub...");
		Yes1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = 0;
				for (Character hero: myTeam.teamHeroes) {
					count++;
				}
				if (count < 3) {
					PartyFull1.setVisible(false);
					panel5.setVisible(false);
					panel3.setVisible(true);
				} else {
					PartyFull1.setVisible(true);
				}
			}
		});
		Yes1.setBounds(163, 257, 227, 29);
		panel5.add(Yes1);
		
		JLabel Text1 = new JLabel("Do you want to recruit more heroes?");
		Text1.setHorizontalAlignment(SwingConstants.CENTER);
		Text1.setForeground(Color.WHITE);
		Text1.setFont(new Font("Courier", Font.BOLD, 20));
		Text1.setBounds(33, 79, 503, 28);
		panel5.add(Text1);
		
		JLabel Background5 = new JLabel("");
		Background5.setIcon(new ImageIcon(Chapter2.class.getResource("/img/Background3.jpg")));
		Background5.setBounds(0, 0, 600, 478);
		panel5.add(Background5);
		
		panel4.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel4);
		panel4.setLayout(null);
		
		JLabel NameLabel = new JLabel("Name:");
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setFont(new Font("Courier", Font.BOLD, 20));
		NameLabel.setBounds(309, 191, 85, 25);
		panel4.add(NameLabel);
		
		NameField = new JTextField();
		NameField.setBounds(390, 193, 130, 26);
		panel4.add(NameField);
		NameField.setColumns(10);
		
		JLabel ErrorName = new JLabel("Name has been taken");
		ErrorName.setVisible(false);
		ErrorName.setForeground(Color.WHITE);
		ErrorName.setFont(new Font("Courier", Font.PLAIN, 15));
		ErrorName.setBounds(335, 304, 195, 25);
		panel4.add(ErrorName);
		
		JLabel ErrorName1 = new JLabel("Please enter something");
		ErrorName1.setVisible(false);
		ErrorName1.setForeground(Color.WHITE);
		ErrorName1.setFont(new Font("Courier", Font.PLAIN, 10));
		ErrorName1.setBounds(328, 304, 202, 25);
		panel4.add(ErrorName1);
		
		JLabel ClassLabel = new JLabel("Class:");
		ClassLabel.setForeground(Color.WHITE);
		ClassLabel.setFont(new Font("Courier", Font.BOLD, 20));
		ClassLabel.setBounds(309, 248, 85, 25);
		panel4.add(ClassLabel);
		
		JComboBox TypeCombo = new JComboBox(charType);
		TypeCombo.setSelectedIndex(0);
		
		JTextPane StatsLabel = new JTextPane();
		StatsLabel.setEditable(false);
		StatsLabel.setBackground(Color.BLACK);
		StatsLabel.setForeground(Color.WHITE);
		StatsLabel.setBounds(309, 34, 211, 140);
		panel4.add(StatsLabel);
		StatsLabel.setText(String.format("Class: %s\nMax Health: %d\nAttack: %d\nDefence: %d\nSkill: %s", 
				  char1.charType, char1.charHealth, char1.charATK, char1.charDEF, char1.charSkill));
		
		TypeCombo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (TypeCombo.getSelectedIndex() == 0) {
					char1 = new Character(Character.Type.BERSERKER);
					char1.getType();
				} else if (TypeCombo.getSelectedIndex() == 1) {
					char1 = new Character(Character.Type.STURDY);
					char1.getType();
				} else if (TypeCombo.getSelectedIndex() == 2) {
					char1 = new Character(Character.Type.PICKUP);
					char1.getType();
				}  else if (TypeCombo.getSelectedIndex() == 3) {
					char1 = new Character(Character.Type.NAVIGATOR);
					char1.getType();
				} else if (TypeCombo.getSelectedIndex() == 4) {
					char1 = new Character(Character.Type.LUCKY);
					char1.getType();
				} else if (TypeCombo.getSelectedIndex() == 5) {
					char1 = new Character(Character.Type.REGEN);
					char1.getType();
					
				}
				StatsLabel.setText(String.format("Class: %s\nMax Health: %d\nAttack: %d\nDefence: %d\nSkill: %s", 
						  char1.charType, char1.charHealth, char1.charATK, char1.charDEF, char1.charSkill));
			}
		});		
		
		TypeCombo.setBounds(390, 248, 130, 30);
		panel4.add(TypeCombo);
		
		
		CharPic.setBounds(11, 34, 509, 335);
		panel4.add(CharPic);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panel4.setVisible(false);
				panel3.setVisible(true);
				myChars = new ArrayList<String>();
				NameField.setText(null);
				ErrorName.setVisible(false);
				ErrorName1.setVisible(false);
				TypeCombo.setSelectedIndex(0);
			}
		});
		btnBack.setBounds(157, 368, 117, 29);
		panel4.add(btnBack);
		
		JButton btnNext = new JButton("Next");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (takenNames.contains(NameField.getText())) { //duplicate check
					if (ErrorName1.isVisible() == true) {
						ErrorName1.setVisible(false);
					}
					ErrorName.setVisible(true);
					NameField.setText(null);
				} else if (NameField.getText().replace(" ", "").equals("")) { //if only contains whitespace
					NameField.setText(null);
					if (ErrorName.isVisible() == true) {
						ErrorName.setVisible(false);
					}
					ErrorName1.setVisible(true);
				} else {
					//create and add hero to myTeam.teamHeroes
					charTypeSel = TypeCombo.getSelectedIndex();
					charName = NameField.getText();
					Character char1 = new Character();
					char1.charName = charName;
					if (charTypeSel == 0) {
						char1.charType = Character.Type.BERSERKER;
					} else if (charTypeSel == 1) {
						char1.charType = Character.Type.STURDY;
					} else if (charTypeSel == 2) {
						char1.charType = Character.Type.PICKUP;
					} else if (charTypeSel == 3) {
						char1.charType = Character.Type.NAVIGATOR;
					} else if (charTypeSel == 4) {
						char1.charType = Character.Type.LUCKY;
					} else if (charTypeSel == 5) {
						char1.charType = Character.Type.REGEN;
					}
					char1.getType();
					char1.checkBuff();
					takenNames.add(charName); //make sure no duplicate names
					myTeam.teamHeroes.add(char1);
					myTeam.originalTeam++; //keeps track of hero count
					
					myTeam.teamSprites.add(myChars.get(0)); //adds chosen hero sprite to myTeam.teamSprites for team info page
					
					//reset this panel
					ErrorName.setVisible(false);
					ErrorName1.setVisible(false);
					TypeCombo.setSelectedIndex(0);
					NameField.setText(null);
					
					//bring up next panel
					panel4.setVisible(false);
					panel5.setVisible(true);
				}
			}
		});
		btnNext.setBounds(324, 368, 117, 29);
		panel4.add(btnNext);
		
		JLabel Background4 = new JLabel("");
		Background4.setIcon(new ImageIcon(Chapter2.class.getResource("/img/Background1.jpg")));
		Background4.setBounds(0, 0, 600, 478);
		panel4.add(Background4);

		
		panel3.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel3);
		panel3.setLayout(null);
		
		JLabel ErrorMsg = new JLabel("Please select an option");
		ErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorMsg.setForeground(Color.WHITE);
		ErrorMsg.setVisible(false);
		ErrorMsg.setFont(new Font("Courier", Font.BOLD, 18));
		ErrorMsg.setBounds(136, 320, 355, 29);
		panel3.add(ErrorMsg);
		
		JButton NextButton = new JButton("Next");
		NextButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = 0;
				for (String chars: myChars) {
					count++;
				}
				if (count == 0) {
					ErrorMsg.setVisible(true);
				} else {
					ErrorMsg.setVisible(false);
					panel3.setVisible(false);
					panel4.setVisible(true);
				}
			}
		});
		NextButton.setBounds(258, 379, 67, 29);
		panel3.add(NextButton);
		
		JLabel ChooseCharTitle = new JLabel("Choose a Hero");
		ChooseCharTitle.setForeground(Color.YELLOW);
		ChooseCharTitle.setFont(new Font("Courier", Font.BOLD, 21));
		ChooseCharTitle.setBounds(203, 32, 179, 29);
		panel3.add(ChooseCharTitle);
		
		JButton button = new JButton("");
		JButton button_1 = new JButton("");
		JButton button_2 = new JButton("");
		JButton button_3 = new JButton("");
		JButton button_4 = new JButton("");
		JButton button_5 = new JButton("");
		JButton button_6 = new JButton("");
		JButton button_7 = new JButton("");
		JButton button_8 = new JButton("");
		JButton button_9 = new JButton("");
		
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button_2.setEnabled(false);
				button.setEnabled(true);
				button_1.setEnabled(true);
				button_7.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_8.setEnabled(true);
				button_9.setEnabled(true);
				myChars.add("/img/sprite3.png");
				if (myChars.contains("/img/sprite1.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite2.png")) {
					myChars.remove("/img/sprite2.png");
				}
				if (myChars.contains("/img/sprite4.png")) {
					myChars.remove("/img/sprite4.png");
				}
				if (myChars.contains("/img/sprite5.png")) {
					myChars.remove("/img/sprite5.png");
				}
				if (myChars.contains("/img/sprite6.png")) {
					myChars.remove("/img/sprite6.png");
				}
				if (myChars.contains("/img/sprite7.png")) {
					myChars.remove("/img/sprite7.png");
				}
				if (myChars.contains("/img/sprite8.png")) {
					myChars.remove("/img/sprite8.png");
				}
				if (myChars.contains("/img/sprite9.png")) {
					myChars.remove("/img/sprite9.png");
				}
				if (myChars.contains("/img/sprite10.png")) {
					myChars.remove("/img/sprite10.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char4.png")));
			}
		});
		button_2.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite3.png")));
		button_2.setBounds(387, 92, 67, 77);
		panel3.add(button_2);
		
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button.setEnabled(false);
				button_9.setEnabled(true);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_8.setEnabled(true);
				button_7.setEnabled(true);
				myChars.add("/img/sprite1.png");
				if (myChars.contains("/img/sprite3.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite2.png")) {
					myChars.remove("/img/sprite2.png");
				}
				if (myChars.contains("/img/sprite4.png")) {
					myChars.remove("/img/sprite4.png");
				}
				if (myChars.contains("/img/sprite5.png")) {
					myChars.remove("/img/sprite5.png");
				}
				if (myChars.contains("/img/sprite6.png")) {
					myChars.remove("/img/sprite6.png");
				}
				if (myChars.contains("/img/sprite7.png")) {
					myChars.remove("/img/sprite7.png");
				}
				if (myChars.contains("/img/sprite8.png")) {
					myChars.remove("/img/sprite8.png");
				}
				if (myChars.contains("/img/sprite9.png")) {
					myChars.remove("/img/sprite9.png");
				}
				if (myChars.contains("/img/sprite10.png")) {
					myChars.remove("/img/sprite10.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char2.png")));
			}
		});
		button.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite1.png")));
		button.setBounds(160, 92, 67, 77);
		panel3.add(button);
		
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button_9.setEnabled(false);
				button.setEnabled(true);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_8.setEnabled(true);
				button_7.setEnabled(true);
				myChars.add("/img/sprite2.png");
				if (myChars.contains("/img/sprite1.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite3.png")) {
					myChars.remove("/img/sprite3.png");
				}
				if (myChars.contains("/img/sprite4.png")) {
					myChars.remove("/img/sprite4.png");
				}
				if (myChars.contains("/img/sprite5.png")) {
					myChars.remove("/img/sprite5.png");
				}
				if (myChars.contains("/img/sprite6.png")) {
					myChars.remove("/img/sprite6.png");
				}
				if (myChars.contains("/img/sprite7.png")) {
					myChars.remove("/img/sprite7.png");
				}
				if (myChars.contains("/img/sprite8.png")) {
					myChars.remove("/img/sprite8.png");
				}
				if (myChars.contains("/img/sprite9.png")) {
					myChars.remove("/img/sprite9.png");
				}
				if (myChars.contains("/img/sprite10.png")) {
					myChars.remove("/img/sprite10.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char1.png")));
			}
		});
		button_9.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite2.png")));
		button_9.setBounds(51, 92, 67, 77);
		panel3.add(button_9);
		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button_1.setEnabled(false);
				button.setEnabled(true);
				button_7.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_8.setEnabled(true);
				button_9.setEnabled(true);
				myChars.add("/img/sprite7.png");
				if (myChars.contains("/img/sprite1.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite2.png")) {
					myChars.remove("/img/sprite2.png");
				}
				if (myChars.contains("/img/sprite4.png")) {
					myChars.remove("/img/sprite4.png");
				}
				if (myChars.contains("/img/sprite5.png")) {
					myChars.remove("/img/sprite5.png");
				}
				if (myChars.contains("/img/sprite6.png")) {
					myChars.remove("/img/sprite6.png");
				}
				if (myChars.contains("/img/sprite3.png")) {
					myChars.remove("/img/sprite3.png");
				}
				if (myChars.contains("/img/sprite8.png")) {
					myChars.remove("/img/sprite8.png");
				}
				if (myChars.contains("/img/sprite9.png")) {
					myChars.remove("/img/sprite9.png");
				}
				if (myChars.contains("/img/sprite10.png")) {
					myChars.remove("/img/sprite10.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char3.png")));
			}
		});
		button_1.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite7.png")));
		button_1.setBounds(258, 92, 84, 77);
		panel3.add(button_1);
		
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button_3.setEnabled(false);
				button.setEnabled(true);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_7.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_8.setEnabled(true);
				button_9.setEnabled(true);
				myChars.add("/img/sprite9.png");
				if (myChars.contains("/img/sprite1.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite2.png")) {
					myChars.remove("/img/sprite2.png");
				}
				if (myChars.contains("/img/sprite4.png")) {
					myChars.remove("/img/sprite4.png");
				}
				if (myChars.contains("/img/sprite5.png")) {
					myChars.remove("/img/sprite5.png");
				}
				if (myChars.contains("/img/sprite6.png")) {
					myChars.remove("/img/sprite6.png");
				}
				if (myChars.contains("/img/sprite7.png")) {
					myChars.remove("/img/sprite7.png");
				}
				if (myChars.contains("/img/sprite8.png")) {
					myChars.remove("/img/sprite8.png");
				}
				if (myChars.contains("/img/sprite3.png")) {
					myChars.remove("/img/sprite3.png");
				}
				if (myChars.contains("/img/sprite10.png")) {
					myChars.remove("/img/sprite10.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char9.png")));
			}
		});
		button_3.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite9.png")));
		button_3.setBounds(387, 213, 67, 77);
		panel3.add(button_3);
		
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button_4.setEnabled(false);
				button.setEnabled(true);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_7.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_8.setEnabled(true);
				button_9.setEnabled(true);
				myChars.add("/img/sprite8.png");
				if (myChars.contains("/img/sprite1.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite2.png")) {
					myChars.remove("/img/sprite2.png");
				}
				if (myChars.contains("/img/sprite4.png")) {
					myChars.remove("/img/sprite4.png");
				}
				if (myChars.contains("/img/sprite5.png")) {
					myChars.remove("/img/sprite5.png");
				}
				if (myChars.contains("/img/sprite6.png")) {
					myChars.remove("/img/sprite6.png");
				}
				if (myChars.contains("/img/sprite7.png")) {
					myChars.remove("/img/sprite7.png");
				}
				if (myChars.contains("/img/sprite3.png")) {
					myChars.remove("/img/sprite3.png");
				}
				if (myChars.contains("/img/sprite9.png")) {
					myChars.remove("/img/sprite9.png");
				}
				if (myChars.contains("/img/sprite10.png")) {
					myChars.remove("/img/sprite10.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char5.png")));
			}
		});
		button_4.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite8.png")));
		button_4.setBounds(502, 92, 67, 77);
		panel3.add(button_4);
		
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button_5.setEnabled(false);
				button.setEnabled(true);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_6.setEnabled(true);
				button_7.setEnabled(true);
				button_8.setEnabled(true);
				button_9.setEnabled(true);
				myChars.add("/img/sprite10.png");
				if (myChars.contains("/img/sprite1.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite2.png")) {
					myChars.remove("/img/sprite2.png");
				}
				if (myChars.contains("/img/sprite4.png")) {
					myChars.remove("/img/sprite4.png");
				}
				if (myChars.contains("/img/sprite5.png")) {
					myChars.remove("/img/sprite5.png");
				}
				if (myChars.contains("/img/sprite6.png")) {
					myChars.remove("/img/sprite6.png");
				}
				if (myChars.contains("/img/sprite7.png")) {
					myChars.remove("/img/sprite7.png");
				}
				if (myChars.contains("/img/sprite8.png")) {
					myChars.remove("/img/sprite8.png");
				}
				if (myChars.contains("/img/sprite9.png")) {
					myChars.remove("/img/sprite9.png");
				}
				if (myChars.contains("/img/sprite3.png")) {
					myChars.remove("/img/sprite3.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char10.png")));
			}
		});
		button_5.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite10.png")));
		button_5.setBounds(502, 213, 67, 77);
		panel3.add(button_5);
		
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button_6.setEnabled(false);
				button.setEnabled(true);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_7.setEnabled(true);
				button_8.setEnabled(true);
				button_9.setEnabled(true);
				myChars.add("/img/sprite5.png");
				if (myChars.contains("/img/sprite1.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite2.png")) {
					myChars.remove("/img/sprite2.png");
				}
				if (myChars.contains("/img/sprite4.png")) {
					myChars.remove("/img/sprite4.png");
				}
				if (myChars.contains("/img/sprite3.png")) {
					myChars.remove("/img/sprite3.png");
				}
				if (myChars.contains("/img/sprite6.png")) {
					myChars.remove("/img/sprite6.png");
				}
				if (myChars.contains("/img/sprite7.png")) {
					myChars.remove("/img/sprite7.png");
				}
				if (myChars.contains("/img/sprite8.png")) {
					myChars.remove("/img/sprite8.png");
				}
				if (myChars.contains("/img/sprite9.png")) {
					myChars.remove("/img/sprite9.png");
				}
				if (myChars.contains("/img/sprite10.png")) {
					myChars.remove("/img/sprite10.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char8.png")));
			}
		});
		button_6.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite5.png")));
		button_6.setBounds(258, 213, 84, 77);
		panel3.add(button_6);
		
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button_7.setEnabled(false);
				button.setEnabled(true);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_8.setEnabled(true);
				button_9.setEnabled(true);
				myChars.add("/img/sprite4.png");
				if (myChars.contains("/img/sprite1.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite2.png")) {
					myChars.remove("/img/sprite2.png");
				}
				if (myChars.contains("/img/sprite3.png")) {
					myChars.remove("/img/sprite3.png");
				}
				if (myChars.contains("/img/sprite5.png")) {
					myChars.remove("/img/sprite5.png");
				}
				if (myChars.contains("/img/sprite6.png")) {
					myChars.remove("/img/sprite6.png");
				}
				if (myChars.contains("/img/sprite7.png")) {
					myChars.remove("/img/sprite7.png");
				}
				if (myChars.contains("/img/sprite8.png")) {
					myChars.remove("/img/sprite8.png");
				}
				if (myChars.contains("/img/sprite9.png")) {
					myChars.remove("/img/sprite9.png");
				}
				if (myChars.contains("/img/sprite10.png")) {
					myChars.remove("/img/sprite10.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char7.png")));
			}
		});
		button_7.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite4.png")));
		button_7.setBounds(160, 213, 67, 77);
		panel3.add(button_7);
		
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ErrorMsg.setVisible(false);
				button_8.setEnabled(false);
				button.setEnabled(true);
				button_1.setEnabled(true);
				button_2.setEnabled(true);
				button_3.setEnabled(true);
				button_4.setEnabled(true);
				button_5.setEnabled(true);
				button_6.setEnabled(true);
				button_7.setEnabled(true);
				button_9.setEnabled(true);
				myChars.add("/img/sprite6.png");
				if (myChars.contains("/img/sprite1.png")) {
					myChars.remove("/img/sprite1.png");
				}
				if (myChars.contains("/img/sprite2.png")) {
					myChars.remove("/img/sprite2.png");
				}
				if (myChars.contains("/img/sprite4.png")) {
					myChars.remove("/img/sprite4.png");
				}
				if (myChars.contains("/img/sprite5.png")) {
					myChars.remove("/img/sprite5.png");
				}
				if (myChars.contains("/img/sprite3.png")) {
					myChars.remove("/img/sprite3.png");
				}
				if (myChars.contains("/img/sprite7.png")) {
					myChars.remove("/img/sprite7.png");
				}
				if (myChars.contains("/img/sprite8.png")) {
					myChars.remove("/img/sprite8.png");
				}
				if (myChars.contains("/img/sprite9.png")) {
					myChars.remove("/img/sprite9.png");
				}
				if (myChars.contains("/img/sprite10.png")) {
					myChars.remove("/img/sprite10.png");
				}
				CharPic.setIcon(new ImageIcon(Chapter2.class.getResource("/img/char6.png")));
			}
		});
		button_8.setIcon(new ImageIcon(Chapter2.class.getResource("/img/sprite6.png")));
		button_8.setBounds(51, 213, 67, 77);
		panel3.add(button_8);
		
		JLabel Background3 = new JLabel("");
		Background3.setIcon(new ImageIcon(Chapter2.class.getResource("/img/Background3.jpg")));
		Background3.setBounds(0, 0, 600, 478);
		panel3.add(Background3);
		
		JPanel panel2 = new JPanel();
		panel2.setVisible(false);
		
		panel2.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JTextPane Narrate1 = new JTextPane();
		Narrate1.setBounds(6, 377, 588, 95);
		panel2.add(Narrate1);
		Narrate1.setEditable(false);
		Narrate1.setBackground(Color.CYAN);
		Narrate1.setFont(new Font("Courier", Font.BOLD, 21));
		Narrate1.setText(" Morgan Freeman (aka Narrator): We must hurry!! Sonaht's\n forces have already begun their invasion!\n Gather your team!");
		
		JTextPane ChatBorder1 = new JTextPane();
		ChatBorder1.setBounds(0, 370, 600, 108);
		panel2.add(ChatBorder1);
		ChatBorder1.setEditable(false);
		ChatBorder1.setBackground(Color.BLACK);
		
		JButton BackGround2 = new JButton("");
		BackGround2.setBounds(-351, -218, 1296, 732);
		panel2.add(BackGround2);
		BackGround2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Narrate1.getText().contains("!!")) {
					Narrate1.setText(" Morgan Freeman (aka Narrator): We must hurry! Sonaht's\n forces have already begun their invasion!\n Gather your team!");
				} else {
					panel2.setVisible(false);
					panel3.setVisible(true);
				}
			}
		});
		BackGround2.setIcon(new ImageIcon(Chapter1.class.getResource("/img/Background1.jpg")));
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JButton StartButton1 = new JButton("-Begin-");
		StartButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel1.setVisible(false);
				panel2.setVisible(true);
			}
		});
		StartButton1.setBackground(new Color(255, 255, 255));
		StartButton1.setForeground(Color.BLACK);
		StartButton1.setBounds(248, 294, 96, 29);
		panel1.add(StartButton1);
		
		JLabel Chapter2Title = new JLabel("");
		Chapter2Title.setBounds(60, 181, 487, 51);
		panel1.add(Chapter2Title);
		Chapter2Title.setIcon(new ImageIcon(Chapter2.class.getResource("/img/Chapter2.jpg")));
		
		JLabel Background1 = new JLabel("");
		Background1.setBounds(0, 0, 1280, 720);
		panel1.add(Background1);
		Background1.setBackground(new Color(0, 0, 0));
		Background1.setForeground(Color.WHITE);
		Background1.setIcon(new ImageIcon(Chapter1.class.getResource("/img/Background1.jpg")));
		frmOasysReady.setVisible(true);
		frmOasysReady.setVisible(true);
	}
}
