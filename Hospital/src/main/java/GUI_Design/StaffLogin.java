package GUI_Design;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;


public class StaffLogin extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffLogin frame = new StaffLogin();
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
	public StaffLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 981, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(64, 161, 115, 33);
		contentPane.add(lblEmail);
		
		JLabel lblSerialNumber = new JLabel("Serial Number :");
		lblSerialNumber.setBounds(64, 291, 235, 33);
		contentPane.add(lblSerialNumber);
		
		JLabel invalidLogin = new JLabel("Incorrect Login");
		invalidLogin.setBounds(332, 338, 193, 33);
		contentPane.add(invalidLogin);
		invalidLogin.setForeground(Color.red);
		invalidLogin.setVisible(false);
		
		email = new JTextField();
		email.setBounds(309, 158, 236, 39);
		contentPane.add(email);
		email.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(309, 288, 235, 39);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = email.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				int attempts = 100;
				
				while (attempts != 0) {
				
					if (username.equals("alexfc@live.dk") && password.equals("s174355")) {
						Staff_Menu menu = new Staff_Menu();
						menu.setVisible(true);
						break;
					} else {
						invalidLogin.setVisible(true);
					}
					attempts--;
				}
			}
		});
		btnLogin.setBounds(334, 419, 171, 41);
		contentPane.add(btnLogin);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnGoBack.setBounds(0, 498, 171, 41);
		contentPane.add(btnGoBack);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Staff login page!");
		lblWelcomeToThe.setBounds(64, 39, 407, 33);
		contentPane.add(lblWelcomeToThe);
		
	}
}
