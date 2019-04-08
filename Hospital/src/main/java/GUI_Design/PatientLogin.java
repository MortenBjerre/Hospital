package GUI_Design;

import Hospital.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PatientLogin extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField Surname;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientLogin frame = new PatientLogin();
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
	public PatientLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 975, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToPatient = new JLabel("Welcome to patient login page");
		lblWelcomeToPatient.setBounds(240, 72, 377, 33);
		contentPane.add(lblWelcomeToPatient);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(0, 572, 171, 41);
		contentPane.add(btnGoBack);
		
		JLabel lblEmail = new JLabel("Email :  ");
		lblEmail.setBounds(63, 364, 115, 33);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("First Name :");
		lblNewLabel.setBounds(63, 156, 154, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname :");
		lblSurname.setBounds(56, 263, 140, 33);
		contentPane.add(lblSurname);
		
		firstName = new JTextField();
		firstName.setBounds(265, 153, 236, 39);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		Surname = new JTextField();
		Surname.setBounds(265, 260, 236, 39);
		contentPane.add(Surname);
		Surname.setColumns(10);
		
		email = new JTextField();
		email.setBounds(265, 361, 236, 39);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nameFirst = firstName.getText();
				String nameSecond = Surname.getText();
				String mail = email.getText();
				int attempts = 3;
				
				while (attempts != 0) {
				
					if (nameFirst.equals("Alexander") && nameSecond.equals("Christensen") && mail.equals("alexfc@live.dk")) {
						Patient_Menu menu = new Patient_Menu();
						menu.setVisible(true);
						
					} else {
						attempts--;
						JOptionPane.showMessageDialog(rootPane, "Incorrect Login, Please try again!");
						
					}
				}
			}
		});
		btnLogin.setBounds(294, 491, 171, 41);
		contentPane.add(btnLogin);
	}
}
