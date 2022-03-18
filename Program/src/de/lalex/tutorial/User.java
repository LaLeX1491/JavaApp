package de.lalex.tutorial;

import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class User implements Serializable, ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static ArrayList<String> allUsernames = new ArrayList<String>();

    String username;
    String password;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User();
        user.mainGUI();
    }



    JFrame frame;
    JPanel panel;
    JTextField createUsername;
    JPasswordField createPassword;
    JPasswordField confirmPassword;
    JButton createAccount;
    JLabel noValid;

    public void mainGUI() {
        noValid = new JLabel();
        frame = new JFrame("Create a new account!");
        panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        createPassword = new JPasswordField(10);
        confirmPassword = new JPasswordField(10);
        createUsername = new JTextField(10);
        JLabel userTxt = new JLabel("New Username: ");
        JLabel userPass = new JLabel("New Password: ");
        JLabel confirmPass = new JLabel("Confirm Password: ");
        createAccount = new JButton("Create your account!");

        panel.setLayout(new GridBagLayout());
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.WEST;
        GridBagConstraints right = new GridBagConstraints();
        right.anchor = GridBagConstraints.EAST;
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;

        frame.getContentPane().add(BorderLayout.NORTH, noValid);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        panel.add(userTxt, left);
        panel.add(createUsername, right);
        panel.add(userPass, left);
        panel.add(createPassword, right);
        panel.add(confirmPass, left);
        panel.add(confirmPassword, right);

        frame.getContentPane().add(BorderLayout.SOUTH, createAccount);
        frame.setVisible(true);
        frame.setSize(500, 300);

        createAccount.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        if (createUsername.getText().length() <= 0 ) {
            noValid.setText("That is not a valid username. Please try again.");
            frame.getContentPane().add(BorderLayout.NORTH, noValid);
        }

        else if (allUsernames.contains(createUsername.getText())) {
            noValid.setText("That username is already taken. Please try again.");
            frame.getContentPane().add(BorderLayout.NORTH, noValid);
        }

            //THIS IS THE PART I'M CONFUSED ABOUT
        else if (!(createPassword.getPassword().equals(confirmPassword.getPassword()))) {
            noValid.setText("Your passwords do not match!");
            frame.getContentPane().add(BorderLayout.NORTH, noValid);
        } else {    
            noValid.setText("Account created successfully");
            frame.getContentPane().add(BorderLayout.NORTH, noValid);
        }
    }
}