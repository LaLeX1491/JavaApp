package de.lalex.tutorial;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import de.lalex.tutorial.util.FileStorage;
import de.lalex.tutorial.util.UserDataFile;
import de.lalex.tutorial.util.UserInfos;

public class Login {

	private JLabel label1;
	private JLabel label2;
	private JLabel lb3;
	private JLabel lb4;
	private static JFrame frame;
	private JPasswordField textfield1;
	private JTextArea textfield2;
	private JButton bt1;
	private Border blborder = BorderFactory.createLineBorder(Color.BLACK);
	private Color bt1c = new Color(0, 204, 0);
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("bt1.png"));
		
	public static void main(String[] args) {
		new Login();
		System.out.println("Login-Fenster startet...");
	}
	
	public Login() {
		frame = new JFrame("Login");
		lb3 = new JLabel("Du hast noch keinen Account?");
		lb4 = new JLabel(" - Jetzt Registrieren");
		textfield2 = new JTextArea();
		bt1 = new JButton("Anmelden");
		label1 = new JLabel("Passwort:");
		label2 = new JLabel("Benutzername:");
		textfield1 = new JPasswordField();
		
		frame.getContentPane().setLayout(null);
		
		textfield2.setFont(textfield2.getFont().deriveFont(15.0F));
		
		frame.setResizable(false);
		
		lb3.addMouseListener(new onClickAction());
		lb4.addMouseListener(new onClickAction());
		
		lb3.setForeground(Color.BLUE);
		lb4.setForeground(Color.BLUE);
		
		bt1.setBackground(bt1c);
		
		bt1.setBorder(blborder);
		
		bt1.setBorder(null);
		
		bt1.addActionListener(new onClickAction());
		
		frame.setBounds(10, 10, 300, 300);
		label1.setBounds(65, 40, 100, 100);
		label2.setBounds(65, -10, 100, 100);
		textfield1.setBounds(65, 100, 150, 30);
		textfield2.setBounds(65, 50, 150, 30);
		lb3.setBounds(40, 200, 200, 30);
		lb4.setBounds(40, 220, 200, 30);
		bt1.setBounds(65, 150, 150, 30);
								
		frame.getContentPane().add(label1);
		frame.getContentPane().add(lb3);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(textfield1);
		frame.getContentPane().add(textfield2);
		frame.getContentPane().add(bt1);
		frame.getContentPane().add(lb4);
		
		frame.setVisible(true);
		lb4.setVisible(true);
		lb3.setVisible(true);
		bt1.setVisible(true);
		textfield2.setVisible(true);
		label1.setVisible(true);
		label2.setVisible(true);
		textfield1.setVisible(true);
	}
	
	public static int getFrameX() {
		try {
			return frame.getX();
		} catch (Exception e) {
			return 10;
		}
	}
	
	public static int getFrameY() {
		try {
			return frame.getY();
		} catch (Exception e) {
			return 10;
		}
	}
	
	public static void close() {
		frame.dispose();
	}
	
	public class onClickAction implements MouseListener, ActionListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {
			if(e.getSource() == lb3) {
				AccCreate.main(null);
			} else if (e.getSource() == lb4) {
				AccCreate.main(null);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == lb3) {
				lb3.setFont(lb3.getFont().deriveFont(Font.ITALIC));
				lb4.setFont(lb4.getFont().deriveFont(Font.ITALIC));
			}
			if(e.getSource() == lb4) {
				lb3.setFont(lb3.getFont().deriveFont(Font.ITALIC));
				lb4.setFont(lb4.getFont().deriveFont(Font.ITALIC));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() == lb3) {
				lb3.setFont(lb3.getFont().deriveFont(Font.BOLD));
				lb4.setFont(lb4.getFont().deriveFont(Font.BOLD));
			}
			if(e.getSource() == lb4) {
				lb3.setFont(lb3.getFont().deriveFont(Font.BOLD));
				lb4.setFont(lb4.getFont().deriveFont(Font.BOLD));
			}
		}

		@SuppressWarnings( "deprecation" )
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bt1) {
				if(textfield1.getText().equals("DEVVVVV") && textfield2.getText().equals("Dev")) {
					System.out.println("Eingeloggt als Dev");
					NormalWindow.main(null);
					
					UserDataFile.main(null);
					
					FileStorage db = null;
					
					try {
						db = new FileStorage(new File(UserDataFile.path() + "//UserChache.dat"));
					} catch (IllegalArgumentException | IOException ep) {
						ep.printStackTrace();
					}
					UserInfos user = new UserInfos(textfield2.getText(), textfield1.getText());
					try {
						if(db.get("Saved_User") == null) {
							db.store("Saved_User", user);
							System.out.println("[SYSTEM] User saved!");
						}
					} catch (IOException e1) {
						System.out.println("Error while the save Process");
					}
					
					
					frame.dispose();
				} else
					System.out.println("Wrong Password or Username");
			}
		}
		
	}
	
}
