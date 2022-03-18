package de.lalex.tutorial;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.security.spec.XECPublicKeySpec;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import de.lalex.tutorial.emails.SendEmail;

public class AccCreate {

	private JLabel label1;
	private JLabel label2;
	private JLabel lb3;
	private JLabel lb4;
	private JFrame frame;
	private JTextArea textfield1;
	private JTextArea textfield2;
	private static JPasswordField pwf1;
	private static JPasswordField pwf2;
	private JButton bt1;
	private Color bt1c = new Color(0, 204, 0);
	private JLabel tf;
	private String tft;
	private Border blborder = BorderFactory.createLineBorder(Color.BLACK);
	
	public static void main(String[] args) {
		new AccCreate();
		System.out.println("Account - Creation Startet...");
	}
	
	public AccCreate() {
		frame = new JFrame("Account Erstellen");
		pwf1 = new JPasswordField();
		lb4 = new JLabel("Passwort bestätigen");
		lb3 = new JLabel("Passwort:");
		pwf2 = new JPasswordField();
		tf = new JLabel(tft);
		textfield2 = new JTextArea();
		bt1 = new JButton("Bestätigen & Anmelden");
		label1 = new JLabel("E-Mail:");
		label2 = new JLabel("Benutzername:");
		textfield1 = new JTextArea();
		
		frame.getContentPane().setLayout(null);
		
		textfield2.setFont(textfield2.getFont().deriveFont(15.0F));
		bt1.setFont(bt1.getFont().deriveFont(10.0F));
		
		bt1.setBorderPainted(false);
		
		bt1.setBackground(bt1c);
		
		bt1.addActionListener(new onButtonClick());
		
		frame.setResizable(false);
		
		textfield1.setBorder(blborder);
		textfield2.setBorder(blborder);
								
		frame.setBounds(10, 10, 300, 350);
		label1.setBounds(65, 40, 100, 100);
		label2.setBounds(65, -10, 100, 100);
		textfield1.setBounds(65, 100, 150, 30);
		textfield2.setBounds(65, 50, 150, 30);
		pwf1.setBounds(65, 150, 150, 30);
		lb3.setBounds(65, 90, 100, 100);
		tf.setBounds(65, 290, 100, 100);
		pwf2.setBounds(65, 200, 150, 30);
		lb4.setBounds(65, 140, 150, 100);
		bt1.setBounds(65, 250, 150, 30);
								
		frame.getContentPane().add(label1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(textfield1);
		frame.getContentPane().add(textfield2);
		frame.getContentPane().add(bt1);
		frame.getContentPane().add(pwf1);
		frame.getContentPane().add(lb3);
		frame.getContentPane().add(pwf2);
		frame.getContentPane().add(lb4);
		frame.getContentPane().add(bt1);
		frame.getContentPane().add(tf);
		
		frame.setVisible(true);
		pwf1.setVisible(true);
		lb3.setVisible(true);
		lb4.setVisible(true);
		bt1.setVisible(true);
		pwf2.setVisible(true);
		textfield2.setVisible(true);
		label1.setVisible(true);
		label2.setVisible(true);
		tf.setVisible(true);
		textfield1.setVisible(true);
	}
	
	public class onButtonClick implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bt1) {
				String email = textfield1.getText();
				String useemail = null;
				String name = "ERROR (023)";
				boolean bol;
				
				// TEXTFIELD 1&2 VERTAUSCHT!!! :D bitte fixen 
				
				if(textfield1.getText() != null) {
					if(textfield1.getText().length() < 16) {
						System.out.println("Der Name darf nicht Länger als 16 Zeichen sein.");
						bol = false;
					} else {
						System.out.println("Benutzername ist korrekt");
						name = textfield1.getText();
						bol = true;
					}
				} else {
					System.out.println("Das Feld Benutzername muss ausgefüllt werden!s");
				}
					
					
				if(email.contains("@") && email.contains(".")) {
					if (!(email.length() < 5)) {
						System.out.println("E-Mail ist korrekt!");
						useemail = email;
						bol = true;
					} else {
						System.out.println("Email-Adresse ist keine Email-Adresse!");
					}
				} else {
					System.out.println("Email-Adresse ist keine Email-Adresse!");
					bol = false;
				}					
					
					
				if(pwf1.getPassword().length > 4) {
					bol = true;
					if(pwf1.getPassword().length < 16) {
						bol = true;
						if(pwf1.getText().equals(pwf2.getText())) {
							System.out.println("Passwort ist korrekt");
						} else {
							System.out.println("pw ungleich");
						}
					} else {
						bol = false;
						System.out.println("Passwort zu lang!");
					}
				} else {
					bol = false;
					System.out.println("Passwort zu kurz!");
				}
						@SuppressWarnings("unused")
						SendEmail mail = new SendEmail(useemail, "Anmeldung bei Freemusic", "Hallo,\nvielen Dank das Sie ab jetzt Freemusic benutzen.\n\nSie haben sich angemeldet als: " + name + "\n\nFalls sie es nicht sind, informieren Sie bitte unseren Kunden-Support!");
				}
			}
		}
		
}
