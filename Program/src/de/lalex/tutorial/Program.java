package de.lalex.tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.lalex.tutorial.util.FileStorage;
import de.lalex.tutorial.util.UserDataFile;
import de.lalex.tutorial.util.UserInfos;


public class Program {

	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
	private JFrame frame;
	private JLabel label;
	private JLabel lb2;
	private JLabel lb3;
	private JButton bt1;
	private JButton bt2;
	
	public static void main(String[] args) {
		new Program();
		System.out.println("App Startet...");
	}
	
	public Program() {		
		FileStorage db = null;
		
		
		try {
			db = new FileStorage(new File(UserDataFile.path() + "//UserChache.dat"));
		} catch (IllegalArgumentException | IOException ep) {
			ep.printStackTrace();
		}
		UserInfos username = null;
		
		try {
			username = (UserInfos) db.get("Saved_User");
		} catch (IllegalArgumentException e) {
			username = null;
		}
		bt1 = new JButton("Jetzt Anmelden");
		if (username != null) {
			bt2 = new JButton("Login als " + username.name);
		} else
			bt2 = new JButton("ERROR");
		frame = new JFrame("Freemusic");
		label = new JLabel("Willkommen!");
		lb3 = new JLabel("vollständig nutzen zu können.");
		lb2 = new JLabel("Sie müssen sich Anmelden, um die App");
		
		frame.getContentPane().setBackground(Color.GRAY);
		bt1.setBackground(Color.CYAN);
		bt2.setBackground(Color.GREEN);
		
		frame.getContentPane().setMaximumSize(new Dimension(500, 500));
		
		frame.getContentPane().setLayout(null);
				
		frame.setResizable(false);
		
		label.setFont(label.getFont().deriveFont(50.0F));
		bt1.setFont(label.getFont().deriveFont(15.0F));
		bt2.setFont(bt2.getFont().deriveFont(10.0F));
		bt2.setFont(bt2.getFont().deriveFont(Font.BOLD));
		
		
		frame.setBounds(10, 10, 500, 500);
		bt2.setBounds(165, 350, 150, 40);
		label.setBounds(100, -150, 500, 500);
		bt1.setBounds(165, 250, 150, 40);
		lb2.setBounds(100, 115, 500, 30);
		lb3.setBounds(101, 130, 500, 30);
		
		frame.transferFocusUpCycle();
		
		frame.setIconImage(logo.getImage());
		
		bt1.addActionListener(new onButtonClick());
		bt2.addActionListener(new onButtonClick());
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(label);
		frame.getContentPane().add(bt2);
		frame.getContentPane().add(bt1);
		frame.getContentPane().add(lb2);
		frame.getContentPane().add(lb3);
		
		frame.setVisible(true);
		lb2.setVisible(true);
		lb3.setVisible(true);
		if (db.get("Saved_User") != null) {
			bt2.setVisible(true);
		} else
			bt2.setVisible(false);
		bt1.setVisible(true);	
		
		
	}
	
	public class onButtonClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bt1) {
				Login.main(null);
				frame.dispose();
			} else if(e.getSource() == bt2) {
				NormalWindow.main(null);
				frame.dispose();
			}
		}
	}
	
}
