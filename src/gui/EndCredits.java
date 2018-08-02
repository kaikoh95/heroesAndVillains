package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import cli.WarriorsOfLight;
import javax.swing.JTextPane;
import cli.Character;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

/**
 * Class for End game scene GUI -
 * If Game Over status, display game over message.
 * Else You have won the game! well done
 * @author Kai and Blue
 *
 */
public class EndCredits {

	private JFrame frmOasysReady;
	private JPanel panelCredits = new JPanel();
	
	private String str1 = "";
	private long currentTime;
	private long diffTime;

	/**
	 * Launch the application.
	 * @param args - for main function
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					EndCredits window = new EndCredits(myTeam);
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
	public EndCredits(WarriorsOfLight myTeam) {
		initialize(myTeam);
		frmOasysReady.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param myTeam - team of heroes
	 */
	@SuppressWarnings("unused")
	public void initialize(WarriorsOfLight myTeam) {
		frmOasysReady = new JFrame();
		frmOasysReady.setFont(new Font("Courier", Font.PLAIN, 12));
		frmOasysReady.setTitle("O.A.S.Y.S - Ready Player Two");
		frmOasysReady.setBounds(100, 100, 600, 500);
		frmOasysReady.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOasysReady.getContentPane().setLayout(null);
		
		//check time elapsed since start of game
		currentTime = System.currentTimeMillis();
		diffTime = currentTime - Chapter1.startTime;
		
		JTextPane EndChat = new JTextPane();
		EndChat.setEditable(false);
		EndChat.setFont(new Font("Courier", Font.PLAIN, 10));
		int count = 0;
		for (Character hero: myTeam.teamHeroes) {
			count++;
		}
		if (count <=0) {
			//lose
			str1 = String.format(" ...You took %d seconds\n and still lose!\n SMH", diffTime % 1000);
		} else {
			//win
			str1 = String.format(" You took a bloody %d seconds!\n Still, good on you!\n You and the %s team\n have done\n the world proud!", diffTime % 1000, myTeam.teamName);
		}
		
		panelCredits.setVisible(false);
		panelCredits.setBounds(0, 0, 600, 478);
		frmOasysReady.getContentPane().add(panelCredits);
		panelCredits.setLayout(null);
		
		JButton EndCloseCredits = new JButton("X");
		EndCloseCredits.setForeground(Color.BLACK);
		EndCloseCredits.setFont(new Font("Courier", Font.BOLD, 15));
		EndCloseCredits.setBackground(Color.WHITE);
		EndCloseCredits.setBounds(551, 6, 43, 45);
		panelCredits.add(EndCloseCredits);
		
		JTextPane EndCreditsText = new JTextPane();
		EndCreditsText.setEditable(false);
		EndCreditsText.setText(" Created By: Kai & Blue\n\n Thank you for playing the game!\n\n (Kai) I wanted to add in the reference links\n\n to all the images but halfway through,\n\n Eclipse just quit on me…\n\n So...shoutout to ALL the contributors\n\n of the images which\n\n I’ve gotten from Google\n\n YAY SENG201 YAY\n\n");
		EndCreditsText.setFont(new Font("Courier", Font.PLAIN, 14));
		EndCreditsText.setBounds(159, 152, 317, 303);
		panelCredits.add(EndCreditsText);
		
		JLabel EndCredits2 = new JLabel("");
		EndCredits2.setIcon(new ImageIcon(EndCredits.class.getResource("/img/EndCreditsBackgroun.png")));
		EndCredits2.setBounds(0, 0, 600, 478);
		panelCredits.add(EndCredits2);
		EndChat.setText(str1);
		EndChat.setBounds(175, 41, 98, 94);
		frmOasysReady.getContentPane().add(EndChat);
		
		JButton EndToTitleScreen = new JButton("Go Home");
		EndToTitleScreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmOasysReady.dispose();
				TitleGUI title = new TitleGUI(myTeam);	
			}
		});
		EndToTitleScreen.setBounds(391, 322, 111, 29);
		frmOasysReady.getContentPane().add(EndToTitleScreen);
		
		JLabel EndChatBox1 = new JLabel("");
		EndChatBox1.setIcon(new ImageIcon(EndCredits.class.getResource("/img/LeftChat.png")));
		EndChatBox1.setBounds(122, -12, 176, 200);
		frmOasysReady.getContentPane().add(EndChatBox1);
		
		JTextPane EndChat1 = new JTextPane();
		EndChat1.setEditable(false);
		EndChat1.setFont(new Font("Courier", Font.PLAIN, 11));
		EndChat1.setText(" Hey big guy,\n sun's getting low\n time to go home!\n Yeeet!");
		EndChat1.setBounds(492, 59, 98, 94);
		frmOasysReady.getContentPane().add(EndChat1);
		
		JButton EndViewCredits = new JButton("View Credits");
		EndViewCredits.setBounds(57, 322, 134, 29);
		frmOasysReady.getContentPane().add(EndViewCredits);
		
		JLabel EndChatBox2 = new JLabel("");
		EndChatBox2.setIcon(new ImageIcon(EndCredits.class.getResource("/img/LeftChat.png")));
		EndChatBox2.setBounds(439, 6, 176, 200);
		frmOasysReady.getContentPane().add(EndChatBox2);
		
		JLabel EndCredits = new JLabel("");
		EndCredits.setIcon(new ImageIcon(EndCredits.class.getResource("/img/EndCreditsPic.jpg")));
		EndCredits.setBounds(-250, -12, 1197, 611);
		frmOasysReady.getContentPane().add(EndCredits);
		
		//button events
		EndViewCredits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EndViewCredits.setVisible(false);
				EndToTitleScreen.setVisible(false);
				EndChatBox2.setVisible(false);
				EndChatBox1.setVisible(false);
				EndCredits.setVisible(false);
				EndChat.setVisible(false);
				EndChat1.setVisible(false);
				panelCredits.setVisible(true);
			}
		});
		
		EndCloseCredits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EndViewCredits.setVisible(true);
				EndToTitleScreen.setVisible(true);
				EndChatBox2.setVisible(true);
				EndChatBox1.setVisible(true);
				EndCredits.setVisible(true);
				EndChat.setVisible(true);
				EndChat1.setVisible(true);
				panelCredits.setVisible(false);
			}
		});
		
	}
}
