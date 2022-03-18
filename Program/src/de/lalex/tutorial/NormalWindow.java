package de.lalex.tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.lalex.tutorial.util.FileStorage;
import de.lalex.tutorial.util.UserDataFile;
import de.lalex.tutorial.util.UserInfos;


public class NormalWindow {

	private JFrame frame;
	private JPanel panel;
	private JLabel user;
	private Dimension sz = Toolkit.getDefaultToolkit().getScreenSize();
	int ScreenX = sz.width;
	int ScreenY = sz.height;
	
	public static void main(String[] args) {
		new NormalWindow();
		System.out.println("App Startet...");
	}
	
	public NormalWindow() {		
		FileStorage db = null;
		
		
		try {
			db = new FileStorage(new File(UserDataFile.path() + "//UserChache.dat"));
		} catch (IllegalArgumentException | IOException ep) {
			ep.printStackTrace();
		}
		UserInfos username = null;
		String usname = "ERROR";
		try {
			username = (UserInfos) db.get("Saved_User");
			usname = username.name;
		} catch (Exception e) {
			username = null;
		}
		frame = new JFrame("Freemusic");
		user = new JLabel("Angemeldet als: " + usname);
		panel = new JPanel();
		
		frame.getContentPane().setBackground(Color.GRAY);
		
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		
		frame.getContentPane().setMaximumSize(new Dimension(500, 500));
		
		frame.getContentPane().setLayout(null);
				
		user.setFont(user.getFont().deriveFont(15.0F));
		
		
		frame.setBounds(10, 10, ScreenX, ScreenY);
		int frameX = frame.getSize().width;
		int frameY = frame.getSize().height;
		panel.setBounds(0, 0, ScreenX, 100);
		user.setBounds(frameX - 170, frameY - 1100, 500, 500);

		panel.setBackground(Color.GREEN);
		
		frame.transferFocusUpCycle();
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(user);
		frame.getContentPane().add(panel);
		
		frame.setVisible(true);
		panel.setVisible(true);
		user.setVisible(true);
		
		
	}
	
}
