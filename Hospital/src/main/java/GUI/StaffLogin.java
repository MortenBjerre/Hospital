package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.PatientRegister;
import Hospital.StaffRegister;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import java.awt.Font;


@SuppressWarnings({ "serial", "unused" })
public class StaffLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField SerialNumber;
	static StaffRegister StaffReg;
	static PatientRegister PatientReg;
	private int attempts = 2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		StaffRegister registertest = new StaffRegister();
//		registertest.createDepartment("lol");
//		H.staffRegister.add("email", "name", "surname", new Date(), "gender", "lol");
//		H.staffRegister.add("email2", "name2", "surname2", new Date(), "gender2", "lol");
//		System.out.println(H.staffRegister.searchEmail("email"));
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffLogin frame = new StaffLogin(StaffReg, PatientReg);
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
	public StaffLogin(final StaffRegister StaffReg, final PatientRegister PatientReg) {
		StaffLogin.StaffReg = StaffReg;
		StaffLogin.PatientReg = PatientReg;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Staff Login Page");
		setBounds(100, 100, 981, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblSerialNumber = new JLabel("Serial Number :");
		lblSerialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblSerialNumber.setBounds(64, 177, 235, 33);
		contentPane.add(lblSerialNumber);
		
		final JLabel invalidLogin = new JLabel("Incorrect Login");
		invalidLogin.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		invalidLogin.setBounds(334, 226, 193, 33);
		contentPane.add(invalidLogin);
		invalidLogin.setForeground(Color.red);
		invalidLogin.setVisible(false);
		
		SerialNumber = new JPasswordField();
		SerialNumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		SerialNumber.setBounds(309, 174, 235, 39);
		contentPane.add(SerialNumber);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				int serialNumber = Integer.parseInt(SerialNumber.getText());
				
				if (attempts != 0) {
					if (StaffReg.users.containsKey(serialNumber)) {
						Staff_Menu menu = new Staff_Menu(StaffReg, serialNumber, PatientReg);
						menu.setVisible(true);
						dispose();
					} else {
						invalidLogin.setVisible(true);
						attempts--;
					}
				} else {
					dispose();
				}
			}
		});
		btnLogin.setBounds(334, 300, 171, 41);
		contentPane.add(btnLogin);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(0, 498, 171, 41);
		contentPane.add(btnGoBack);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Staff login page!");
		lblWelcomeToThe.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblWelcomeToThe.setBounds(64, 39, 407, 33);
		contentPane.add(lblWelcomeToThe);
		
	}
}