package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;

import cli.WarriorsOfLight;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class for Main Screen GUI - 
 * allows user to play the game and
 * sends user into introduction chapter
 * @author Kai and Blue
 *
 */
public class TitleGUI {

	private JFrame frmOasysReady;
	
	/**
	 * Launch the application.
	 * @param args - for main function
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarriorsOfLight myTeam = new WarriorsOfLight();
					TitleGUI window = new TitleGUI(myTeam);
					window.frmOasysReady.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param myTeam - team of heroes used
	 */
	public TitleGUI(WarriorsOfLight myTeam) {
		initialize(myTeam);
		frmOasysReady.setVisible(true);
	}

	/**
	 * Close this window launches chapter 1
	 * @param myTeam - team of heroes used
	 */
	public void closeWindow(WarriorsOfLight myTeam) {
		frmOasysReady.setVisible(false);;
		@SuppressWarnings("unused")
		Chapter1 chap1 = new Chapter1(myTeam);
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @param myTeam - team of heroes used
	 */
	public void initialize(WarriorsOfLight myTeam) {
		frmOasysReady = new JFrame();
		frmOasysReady.setFont(new Font("Courier", Font.PLAIN, 12));
		frmOasysReady.setTitle("O.A.S.Y.S - Ready Player Two");
		frmOasysReady.setBounds(100, 100, 600, 500);
		frmOasysReady.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOasysReady.getContentPane().setLayout(null);
		
		JLabel TitleComment1 = new JLabel("Very Fun");
		TitleComment1.setFont(new Font("Courier", Font.BOLD, 23));
		TitleComment1.setBounds(28, 99, 173, 36);
		frmOasysReady.getContentPane().add(TitleComment1);
		
		JLabel TitleComment2 = new JLabel("Much Wow");
		TitleComment2.setFont(new Font("Courier", Font.BOLD, 23));
		TitleComment2.setBounds(456, 178, 124, 36);
		frmOasysReady.getContentPane().add(TitleComment2);
		
		JLabel Creators = new JLabel("created by: Kai & Blue");
		Creators.setFont(new Font("Courier", Font.BOLD, 13));
		Creators.setBounds(259, 120, 185, 29);
		frmOasysReady.getContentPane().add(Creators);
		
		JButton StartButton = new JButton("");
		StartButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeWindow(myTeam);
			}
		});
		
		JButton TitleLoad = new JButton("Load Game");
		TitleLoad.setEnabled(false);
		TitleLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * We didn't have time to implement this section
				 * but the gist of it is to read the information from the save file 
				 * by clicking on the "Load Game"
				 * button located in the BaseLayout and parsing it
				 * into a team by using the WarriorsOfLight and Character constructors
				 */
			}
		});
		TitleLoad.setBounds(235, 412, 117, 29);
		frmOasysReady.getContentPane().add(TitleLoad);
		StartButton.setIcon(new ImageIcon(TitleGUI.class.getResource("/img/StartButton.png")));
		StartButton.setBounds(131, 324, 333, 47);
		frmOasysReady.getContentPane().add(StartButton);
		
		JLabel Title = new JLabel("");
		Title.setIcon(new ImageIcon(TitleGUI.class.getResource("/img/TitleName.jpg")));
		Title.setBounds(151, 149, 293, 53);
		frmOasysReady.getContentPane().add(Title);
		
		JLabel TitleScreen = new JLabel("");
		TitleScreen.setIcon(new ImageIcon(TitleGUI.class.getResource("/img/TitlePic.jpg")));
		TitleScreen.setBounds(-689, -193, 1920, 1080);
		frmOasysReady.getContentPane().add(TitleScreen);
	}
}
