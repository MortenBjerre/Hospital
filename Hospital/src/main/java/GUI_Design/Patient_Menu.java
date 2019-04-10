package GUI_Design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hospital.Hospital;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings({ "unused", "serial" })
public class Patient_Menu extends JFrame {

	private JPanel contentPane;
	static Hospital H;
	private String role;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_Menu frame = new Patient_Menu(H);
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
	public Patient_Menu(Hospital H) {
		Patient_Menu.H = H;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 985, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Patient Menu, ");
		lblWelcomeToThe.setBounds(51, 44, 341, 32);
		lblWelcomeToThe.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(5, 528, 171, 41);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblYourEmailIs = new JLabel("Your E-mail is : ");
		lblYourEmailIs.setBounds(51, 240, 190, 33);
		lblYourEmailIs.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblYourAddressIs = new JLabel("Your Address is :");
		lblYourAddressIs.setBounds(51, 320, 202, 33);
		lblYourAddressIs.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblYourPhoneNumber = new JLabel("Your Phone Number is :");
		lblYourPhoneNumber.setBounds(50, 392, 293, 33);
		lblYourPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblNameOfThe = new JLabel("Name of the patient");
		lblNameOfThe.setBounds(405, 42, 237, 33);
		lblNameOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblPatientsEmail = new JLabel("Patients Email");
		lblPatientsEmail.setBounds(358, 238, 166, 33);
		lblPatientsEmail.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblPatientsAddress = new JLabel("Patients Address");
		lblPatientsAddress.setBounds(358, 318, 196, 33);
		lblPatientsAddress.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		
		JLabel lblPatientsPhonenumber = new JLabel("Patients phoneNumber");
		lblPatientsPhonenumber.setBounds(358, 390, 271, 33);
		lblPatientsPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		contentPane.setLayout(null);
		contentPane.add(lblWelcomeToThe);
		contentPane.add(lblNameOfThe);
		contentPane.add(lblYourEmailIs);
		contentPane.add(lblPatientsEmail);
		contentPane.add(lblYourAddressIs);
		contentPane.add(lblPatientsAddress);
		contentPane.add(lblYourPhoneNumber);
		contentPane.add(lblPatientsPhonenumber);
		contentPane.add(btnGoBack);
	}
}
