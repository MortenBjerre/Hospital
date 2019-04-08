package GUI_Design;

import Hospital.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.collections.MappingChange.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClerkLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClerkLogin frame = new ClerkLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClerkLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClerkId = new JLabel("Clerk ID : ");
		lblClerkId.setBounds(73, 188, 202, 33);
		contentPane.add(lblClerkId);
		
		JLabel lblPleaseEnterClerk = new JLabel("Please enter Clerk Login");
		lblPleaseEnterClerk.setBounds(73, 62, 482, 33);
		contentPane.add(lblPleaseEnterClerk);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(314, 185, 217, 36);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = passwordField.getText();
				int attempts = 3;
				
				while (attempts != 0) {
	//				if (staffRegister.containsKey(password)) {
	//						Clerk_Menu clerk = new Clerk_Menu();
	//				clerk.setVisible(true);
	//				} else {
	//					JOptionPane.showMessageDialog(frame, "Invalid Clerk ID number, please try again! ");
	//				}
				}
//					
			
			}
		});
		
		
		btnLogin.setBounds(73, 296, 171, 41);
		contentPane.add(btnLogin);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(0, 526, 171, 41);
		contentPane.add(btnGoBack);
	}

}
