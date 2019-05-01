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
import java.awt.GridLayout;
import javax.swing.SwingConstants;

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
		this.setTitle("Patient Login Page");
		setBounds(100, 100, 975, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblWelcomeToPatient = new JLabel("Welcome to patient login page");
		lblWelcomeToPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToPatient.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblWelcomeToPatient);
		
		JLabel label = new JLabel("");
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("");
		contentPane.add(label_3);
		
		JLabel lblSurname = new JLabel("Serial Number :");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(lblSurname);
		
		SerialNumber = new JPasswordField();
		contentPane.add(SerialNumber);
		
		JLabel label_4 = new JLabel("");
		contentPane.add(label_4);
		
		final JLabel invalidLogin = new JLabel("Incorrect Login");
		invalidLogin.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		contentPane.add(invalidLogin);
		invalidLogin.setForeground(Color.red);
		invalidLogin.setVisible(false);
		
		JLabel label_5 = new JLabel("");
		contentPane.add(label_5);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				@SuppressWarnings("deprecation")
				int serialNumber = Integer.parseInt(SerialNumber.getText());
				
				if (attempts != 0) {
				
					if (PatientReg.users.containsKey(serialNumber)) {
						Patient_Menu menu = new Patient_Menu(PatientReg, DepartReg, serialNumber);
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
		contentPane.add(btnLogin);
		
		JLabel label_6 = new JLabel("");
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		contentPane.add(label_7);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnGoBack);
		
		JLabel label_8 = new JLabel("");
		contentPane.add(label_8);
	}
}