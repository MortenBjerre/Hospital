//package GUI_Design;
//
//import Hospital.*;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JButton;
//import javax.swing.JTextField;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Font;
//
//@SuppressWarnings({ "serial", "unused" })
//public class PatientLogin extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField firstName;
//	private JTextField Surname;
//	private JTextField email;
//	static Hospital H;
//	private int attempts = 2;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PatientLogin frame = new PatientLogin(H);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public PatientLogin(Hospital H) {
//		PatientLogin.H =H;
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 975, 701);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel invalidLogin = new JLabel("Incorrect Login");
//		invalidLogin.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		invalidLogin.setBounds(287, 404, 193, 33);
//		contentPane.add(invalidLogin);
//		invalidLogin.setForeground(Color.red);
//		invalidLogin.setVisible(false);
//		
//		JLabel lblWelcomeToPatient = new JLabel("Welcome to patient login page");
//		lblWelcomeToPatient.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		lblWelcomeToPatient.setBounds(240, 72, 361, 33);
//		contentPane.add(lblWelcomeToPatient);
//		
//		JButton btnGoBack = new JButton("Go Back");
//		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		btnGoBack.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});
//		btnGoBack.setBounds(0, 572, 171, 41);
//		contentPane.add(btnGoBack);
//		
//		JLabel lblEmail = new JLabel("Email :  ");
//		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		lblEmail.setBounds(63, 364, 98, 33);
//		contentPane.add(lblEmail);
//		
//		JLabel lblNewLabel = new JLabel("First Name :");
//		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		lblNewLabel.setBounds(63, 156, 146, 33);
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblSurname = new JLabel("Surname :");
//		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		lblSurname.setBounds(63, 265, 124, 33);
//		contentPane.add(lblSurname);
//		
//		firstName = new JTextField();
//		firstName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		firstName.setBounds(265, 153, 236, 39);
//		contentPane.add(firstName);
//		firstName.setColumns(10);
//		
//		Surname = new JTextField();
//		Surname.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		Surname.setBounds(265, 260, 236, 39);
//		contentPane.add(Surname);
//		Surname.setColumns(10);
//		
//		email = new JTextField();
//		email.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		email.setBounds(265, 361, 236, 39);
//		contentPane.add(email);
//		email.setColumns(10);
//		
//		JButton btnLogin = new JButton("Login");
//		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 27));
//		btnLogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				String nameFirst = firstName.getText();
//				String nameSecond = Surname.getText();
//				String mail = email.getText();
//				
//				if (attempts != 0) {
//				
//					if (nameFirst.equals("Alexander") && nameSecond.equals("Christensen") && mail.equals("alexfc@live.dk")) {
//						Patient_Menu menu = new Patient_Menu(H);
//						menu.setVisible(true);
//					} else {
//						invalidLogin.setVisible(true);
//						attempts--;
//					}
//				} else {
//						dispose();
//					}
//			}
//		});
//		btnLogin.setBounds(294, 491, 171, 41);
//		contentPane.add(btnLogin);
//	}
//}
