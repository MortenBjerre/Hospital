package GUI;

import Hospital.*;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.awt.Font;
import javax.swing.JPasswordField;

@SuppressWarnings({ "serial", "unused" })
public class PatientLogin extends JFrame {

	private JPanel contentPane;
	static PatientRegister PatientReg;
	static DepartmentRegister DepartReg;
	private int attempts = 2;
	private int serialNumber;
	private JPasswordField SerialNumber;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientLogin frame = new PatientLogin(PatientReg, DepartReg);
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
	public PatientLogin(final PatientRegister PatientReg, final DepartmentRegister DepartReg) {
		PatientLogin.PatientReg = PatientReg;
		PatientLogin.DepartReg = DepartReg;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 975, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel invalidLogin = new JLabel("Incorrect Login");
		invalidLogin.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		invalidLogin.setBounds(294, 313, 193, 33);
		contentPane.add(invalidLogin);
		invalidLogin.setForeground(Color.red);
		invalidLogin.setVisible(false);
		
		JLabel lblWelcomeToPatient = new JLabel("Welcome to patient login page");
		lblWelcomeToPatient.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblWelcomeToPatient.setBounds(202, 72, 361, 33);
		contentPane.add(lblWelcomeToPatient);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnGoBack.setBounds(0, 572, 171, 41);
		contentPane.add(btnGoBack);
		
		JLabel lblSurname = new JLabel("Serial Number :");
		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblSurname.setBounds(63, 265, 171, 32);
		contentPane.add(lblSurname);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				@SuppressWarnings("deprecation")
				int serialNumber = Integer.parseInt(SerialNumber.getText());
				
				if (attempts != 0) {
				
					if (PatientReg.users.containsKey(serialNumber)) {
						Patient_Menu menu = new Patient_Menu(PatientReg, DepartReg, serialNumber);
						menu.setVisible(true);
					} else {
						invalidLogin.setVisible(true);
						attempts--;
					}
				} else {
						dispose();
					}
			}
		});
		btnLogin.setBounds(294, 414, 171, 41);
		contentPane.add(btnLogin);
		
		SerialNumber = new JPasswordField();
		SerialNumber.setBounds(294, 263, 171, 33);
		contentPane.add(SerialNumber);
	}
}