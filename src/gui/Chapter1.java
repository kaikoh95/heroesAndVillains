package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import cli.WarriorsOfLight;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Class for introduction and choosing name for team
 * and that's about it actually.
 * Moves user into next Chapter to create heroes
 * @author Kai and Blue
 *
 */
public class Chapter1 {

	private JFrame frmOasysReady;
	public static long startTime; //to keep track of time taken to complete (or not) the game
	private JTextField TeamName;

	/**
	 * Launch the application.
	 * @param args - main 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					Chapter1 window = new Chapter1(myTeam);
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
	public Chapter1(WarriorsOfLight myTeam) {
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
		
		startTime = System.currentTimeMillis(); //start timing
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JPanel panel2 = new JPanel();
		panel2.setVisible(false);
		JPanel panel3 = new JPanel();
		panel3.setVisible(false);
		JPanel panel4 = new JPanel();
		panel4.setVisible(false);
		
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
		StartButton1.setBounds(248, 294, 94, 29);
		panel1.add(StartButton1);
		
		JLabel Chapter1Title = new JLabel("");
		Chapter1Title.setBounds(62, 181, 485, 51);
		panel1.add(Chapter1Title);
		Chapter1Title.setIcon(new ImageIcon(Chapter1.class.getResource("/img/Chapter1.jpg")));
		
		JLabel Background1 = new JLabel("");
		Background1.setBounds(0, 0, 1280, 720);
		panel1.add(Background1);
		Background1.setBackground(new Color(0, 0, 0));
		Background1.setForeground(Color.WHITE);
		Background1.setIcon(new ImageIcon(Chapter1.class.getResource("/img/Background1.jpg")));
	
		
		panel2.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JTextPane Narrate1 = new JTextPane();
		Narrate1.setBounds(12, 377, 576, 95);
		panel2.add(Narrate1);
		Narrate1.setEditable(false);
		Narrate1.setBackground(Color.CYAN);
		Narrate1.setFont(new Font("Courier", Font.BOLD, 21));
		Narrate1.setText(" Morgan Freeman (aka Narrator): Not so long long ago, in a\n  Galaxy not so far far away...");
		
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
				if (Narrate1.getText().contains("  ")) {
					Narrate1.setText(" Morgan Freeman (aka Narrator): Not so long long ago, in a\n Galaxy not so far far away...");
				} else if (Narrate1.getText().contains("away.")) {
					Narrate1.setText(" Planet O.A.S.Y.S faces an invasion by Sanoht and his\n great-grand children...");
				} else if (Narrate1.getText().contains("faces")) {
					panel2.setVisible(false);
					panel3.setVisible(true);
				}
				
			}
		});
		BackGround2.setIcon(new ImageIcon(Chapter1.class.getResource("/img/Background1.jpg")));
		
		panel3.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel3);
		panel3.setLayout(null);
		frmOasysReady.setVisible(true);
		
		JTextPane SonahtChat1 = new JTextPane();
		SonahtChat1.setBounds(6, 377, 588, 95);
		panel3.add(SonahtChat1);
		SonahtChat1.setEditable(false);
		SonahtChat1.setBackground(Color.CYAN);
		SonahtChat1.setFont(new Font("Courier", Font.BOLD, 21));
		SonahtChat1.setText(" Sonaht: Skrt skrrrt! Everybody put'cha hands up!  Now!");
		
		JTextPane ChatBorder = new JTextPane();
		ChatBorder.setBounds(0, 370, 600, 108);
		panel3.add(ChatBorder);
		ChatBorder.setEditable(false);
		ChatBorder.setBackground(Color.BLACK);
		
		JLabel SonahtIcon = new JLabel("");
		SonahtIcon.setBounds(344, 184, 256, 256);
		panel3.add(SonahtIcon);
		SonahtIcon.setIcon(new ImageIcon(Chapter1.class.getResource("/img/BossSonaht.png")));
		
		JButton BackGround3 = new JButton("");
		BackGround3.setBounds(-89, -219, 2064, 2060);
		panel3.add(BackGround3);
		BackGround3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SonahtChat1.getText().contains("  ")) {
					SonahtChat1.setText(" Sonaht: Skrt skrrt! Everybody put'cha hands up! Now!");
				} else if (SonahtChat1.getText().contains("rrt")) {
					SonahtChat1.setText(" I am Lord Sonaht, King of Ass-guard! And I have come\n here for your salvation!");
				} else if (SonahtChat1.getText().contains("Ass-guard")) {
					SonahtChat1.setText(" You mere mortals only know how to code all day err day,\n and do not know how to live a FUN life!");
				} else if (SonahtChat1.getText().contains("mere mortals")) {
					SonahtChat1.setText(" *deadpool voice while jumping off the chopper*\n Now, cue the music!");
				} else if (SonahtChat1.getText().contains("deadpool")) {
					panel3.setVisible(false);
					panel4.setVisible(true);
				} 
			}
		});
		BackGround3.setIcon(new ImageIcon(Chapter1.class.getResource("/img/Chapter1Background1.jpg")));
		
		panel4.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panel4);
		panel4.setLayout(null);
		
		JLabel Title = new JLabel("Name your Mighty Team");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Courier", Font.PLAIN, 21));
		Title.setForeground(Color.WHITE);
		Title.setBounds(112, 133, 342, 34);
		panel4.add(Title);
		
		JLabel ErrorMsg = new JLabel("2-10 characters only!");
		ErrorMsg.setHorizontalAlignment(SwingConstants.CENTER);
		JButton Next = new JButton("Let's Go!");
		
		Next.setBounds(220, 360, 128, 29);
		panel4.add(Next);
		
		ErrorMsg.setVisible(false);
		ErrorMsg.setForeground(Color.WHITE);
		ErrorMsg.setBounds(173, 227, 226, 16);
		panel4.add(ErrorMsg);
		
		TeamName = new JTextField();
		TeamName.setBounds(173, 277, 242, 40);
		panel4.add(TeamName);
		TeamName.setColumns(10);
		Next.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				if (TeamName.getText().length() < 2 || TeamName.getText().length() > 10 || TeamName.getText().replace(" ", "").equals("")) {
					ErrorMsg.setVisible(true);
					TeamName.setText(null);
				} else {
					ErrorMsg.setVisible(false);
					myTeam.teamName = TeamName.getText();
					TeamName.setText(null);
					frmOasysReady.dispose();
					Chapter2 chap2 = new Chapter2(myTeam);
				}
			}
		});
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(Chapter1.class.getResource("/img/Background1.jpg")));
		Background.setForeground(new Color(0, 0, 0));
		Background.setBounds(-50, -38, 1280, 720);
		panel4.add(Background);
		
		
	}
}
