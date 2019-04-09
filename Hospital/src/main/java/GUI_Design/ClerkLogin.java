package GUI_Design;

import Hospital.*;

import java.awt.BorderLayout;
import java.awt.Color;
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

@SuppressWarnings({ "serial", "unused" })
public class ClerkLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	static Hospital H;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClerkLogin frame = new ClerkLogin(H);
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
	public ClerkLogin(Hospital H) {
		ClerkLogin.H = H;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 998, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel invalidLogin = new JLabel("Incorrect Login");
		invalidLogin.setBounds(324, 231, 193, 33);
		contentPane.add(invalidLogin);
		invalidLogin.setForeground(Color.red);
		invalidLogin.setVisible(false);
		
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
			@SuppressWarnings("unlikely-arg-type")
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				int attempts = 100;
				
				while (attempts != 0) {
					if (H.staffRegister.users.containsKey(password)) {
							Clerk_Menu clerk = new Clerk_Menu(H);
					clerk.setVisible(true);
					} else {
						invalidLogin.setVisible(true);
						attempts--;
					}
				}
				if (attempts == 0) {
					dispose();
				}
//					
			
			}
		});
		
		
		btnLogin.setBounds(73, 296, 171, 41);
		contentPane.add(btnLogin);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(0, 526, 171, 41);
		contentPane.add(btnGoBack);
	}
}

